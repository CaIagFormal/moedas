package kotacoes.moedas.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import kotacoes.moedas.model.M_CotacaoJson;

import java.util.HashMap;
import java.util.Map;

public class M_RespostaApi {

    private Map<String, M_CotacaoJson> cotacoes = new HashMap<>();

    @JsonAnySetter
    public void setCotacoes(String chave, M_CotacaoJson valor) {
        cotacoes.put(chave, valor);
    }

    public Map<String, M_CotacaoJson> getCotacoes() {
        return cotacoes;
    }
}