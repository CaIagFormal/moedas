package kotacoes.moedas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="cotacao")
public class M_Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private char[] code = new char[3];
    private double maxima;
    private double minima;
    private double var_cota;
    private double var_pct;
    private double cotacao;
    private LocalDateTime data_cota;
    private LocalDateTime data_cria = LocalDateTime.now();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char[] getCode() {
        return code;
    }

    public void setCode(char[] code) {
        this.code = code;
    }

    public double getMaxima() {
        return maxima;
    }

    public void setMaxima(double maxima) {
        this.maxima = maxima;
    }

    public double getMinima() {
        return minima;
    }

    public void setMinima(double minima) {
        this.minima = minima;
    }

    public double getVar_cota() {
        return var_cota;
    }

    public void setVar_cota(double var_cota) {
        this.var_cota = var_cota;
    }

    public double getVar_pct() {
        return var_pct;
    }

    public void setVar_pct(double var_pct) {
        this.var_pct = var_pct;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public LocalDateTime getData_cota() {
        return data_cota;
    }

    public void setData_cota(LocalDateTime data_cota) {
        this.data_cota = data_cota;
    }

    public LocalDateTime getData_cria() {
        return data_cria;
    }

    public void setData_cria(LocalDateTime data_cria) {
        this.data_cria = data_cria;
    }
}
