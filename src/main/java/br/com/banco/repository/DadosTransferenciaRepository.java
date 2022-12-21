package br.com.banco.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.domain.Transferencia;

@Repository
public interface DadosTransferenciaRepository extends JpaRepository<Transferencia, Long>{

	Transferencia findByNome(String nome_operador_transacao);

	List<Transferencia> findByDataBetween(Timestamp start, Timestamp fim);

}
