package kotacoes.moedas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class M_CotacaoJson {

    @JsonProperty(value="code")
    private String code;
    @JsonProperty(value="high")
    private String maxima;
    @JsonProperty(value="low")
    private String minima;
    @JsonProperty(value="varBid")
    private String var_cota;
    @JsonProperty(value="pctChange")
    private String var_pct;
    @JsonProperty(value="bid")
    private String cotacao;
    @JsonProperty(value="timestamp")
    private String data_cota;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMaxima() {
        return maxima;
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public String getMinima() {
        return minima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    public String getVar_cota() {
        return var_cota;
    }

    public void setVar_cota(String var_cota) {
        this.var_cota = var_cota;
    }

    public String getVar_pct() {
        return var_pct;
    }

    public void setVar_pct(String var_pct) {
        this.var_pct = var_pct;
    }

    public String getCotacao() {
        return cotacao;
    }

    public void setCotacao(String cotacao) {
        this.cotacao = cotacao;
    }

    public String getData_cota() {
        return data_cota;
    }

    public void setData_cota(String data_cota) {
        this.data_cota = data_cota;
    }
}
