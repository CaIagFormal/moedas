package kotacoes.moedas.model;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;


public interface M_Chart {
    Double getValue();

    long getDate();
}
