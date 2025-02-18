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

    String getChartByMoeda = "select " +
            "cotacao as value," +
            "EXTRACT (EPOCH FROM(data_cota)) " +
            "*1000 as date " +
            "from kotacoes.cotacao " +
            "where code = :moeda";
    String getLatestChartByMoeda = getChartByMoeda +
            " order by date desc limit 1";

    @Query(value = getChartByMoeda,nativeQuery = true)
    List<M_Chart> getChartByMoeda(@Param("moeda") String moeda);

    @Query(value = getLatestChartByMoeda,nativeQuery = true)
    M_Chart getlatestChartByMoeda(@Param("moeda") String moeda);
}
