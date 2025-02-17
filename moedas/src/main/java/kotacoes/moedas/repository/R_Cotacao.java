package kotacoes.moedas.repository;

import kotacoes.moedas.model.M_Chart;
import kotacoes.moedas.model.M_Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface R_Cotacao extends JpaRepository<M_Cotacao, Long> {
    @Query(value = "select " +
                    "cotacao as value," +
                    "data_cota as date" +
                    " from kotacoes.cotacao " +
                    "where code = :moeda"
            ,nativeQuery = true)
    List<M_Chart> getChartByMoeda(@Param("moeda") String moeda);
}
