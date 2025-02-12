package kotacoes.moedas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kotacoes.moedas.repository.R_Cotacao;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class S_Cotacao {

    private final R_Cotacao r_cotacao;
    private RestTemplate rest_template = new RestTemplate();

    public S_Cotacao(R_Cotacao r_cotacao) {
        this.r_cotacao = r_cotacao;
    }

    @Scheduled(cron="0 * 10-18 * * ?")
    public void getCotacoesApi() {
        String resposta_api = rest_template.getForObject("https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL", String.class);

        ObjectMapper objectMapper = new ObjectMapper();
    }
}