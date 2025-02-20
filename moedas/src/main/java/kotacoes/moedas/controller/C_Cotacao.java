package kotacoes.moedas.controller;

import kotacoes.moedas.model.M_Chart;
import kotacoes.moedas.model.M_Cotacao;
import kotacoes.moedas.service.S_Cotacao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class C_Cotacao {

    private final S_Cotacao s_cotacao;

    public C_Cotacao(S_Cotacao s_cotacao) {
        this.s_cotacao = s_cotacao;
    }


    @PostMapping("/get_chart_data")
    @ResponseBody
    public List<M_Chart> getChartByMoeda(@RequestParam("moeda") String moeda) {
        return s_cotacao.getChartByMoeda(moeda);
    }

    @PostMapping("/get_latest_chart")
    @ResponseBody
    public M_Chart getLatestChartByMoeda(@RequestParam("moeda") String moeda) {
        return s_cotacao.getLatestChartByMoeda(moeda);
    }
}
