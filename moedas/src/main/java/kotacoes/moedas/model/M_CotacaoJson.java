package kotacoes.moedas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class M_CotacaoJson {

    @JsonProperty(value="code")
    private String code;
    @JsonProperty(value="codein")
    private String codein;
    @JsonProperty(value="name")
    private String name;
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
    @JsonProperty(value="ask")
    private String ask;
    @JsonProperty(value="timestamp")
    private String data_cota;
    @JsonProperty(value="create_date")
    private String create_date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodein() {
        return codein;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getData_cota() {
        return data_cota;
    }

    public void setData_cota(String data_cota) {
        this.data_cota = data_cota;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
}
