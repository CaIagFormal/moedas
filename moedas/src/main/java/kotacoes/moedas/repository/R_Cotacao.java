package kotacoes.moedas.repository;

import kotacoes.moedas.model.M_Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Cotacao extends JpaRepository<M_Cotacao, Long> {
}
