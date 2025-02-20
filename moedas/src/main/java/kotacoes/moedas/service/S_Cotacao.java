package kotacoes.moedas.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kotacoes.moedas.model.M_Chart;
import kotacoes.moedas.model.M_Cotacao;
import kotacoes.moedas.model.M_CotacaoJson;
import kotacoes.moedas.model.M_RespostaApi;
import kotacoes.moedas.repository.R_Cotacao;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class S_Cotacao {

    private final R_Cotacao r_cotacao;
    private RestTemplate rest_template = new RestTemplate();

    public S_Cotacao(R_Cotacao r_cotacao) {
        this.r_cotacao = r_cotacao;
    }

    @Scheduled(cron="0 * 10-18 * * ?")
    public void getCotacoesApi() throws JsonProcessingException {

        Map<String,M_CotacaoJson> mapCotacao = new ObjectMapper().readValue(
                rest_template.getForObject("https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL",
                        String.class),
                M_RespostaApi.class).getCotacoes();

        List<M_Cotacao> cotacoes = new ArrayList<>();
        for (M_CotacaoJson json: mapCotacao.values()) {
            cotacoes.add(new M_Cotacao(json));
        }

        r_cotacao.saveAll(cotacoes);
    }

    public List<M_Chart> getChartByMoeda(String moeda) {
        return r_cotacao.getChartByMoeda(moeda);
    }

    public M_Chart getLatestChartByMoeda(String moeda) {

        M_Chart m_chart = r_cotacao.getlatestChartByMoeda(moeda);
        long now = Instant.now(Clock.system(ZoneId.of("America/Sao_Paulo"))).toEpochMilli();

        if ((now - (now%60000))>m_chart.getDate()) {
            return null;
        }

        return m_chart;
    }
}