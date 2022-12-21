package br.com.banco.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.domain.Transferencia;
import br.com.banco.repository.DadosTransferenciaRepository;

@Service("DadosTransferenciaService")
public class DadosTransferenciaService {
	
	@Autowired
	private DadosTransferenciaRepository repository;

	public List<Transferencia> buscarTodasTranferencias() {
		return repository.findAll();
	}
	
	public Optional<Transferencia> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public Optional<Transferencia> buscarPorContaId(Long id) {
		return repository.findById(id);
	}

	public Transferencia buscarPorNome(String nome) {
		return repository.findByNome(nome);
	}

	public List<Transferencia>buscarPorData(Timestamp start, Timestamp end) {
		return repository.findByDataBetween(start, end);
	}

	public List<Transferencia> buscarPorDataENome(Timestamp start, Timestamp end, String nome) {
		List<Transferencia> transferencia = repository.findByDataBetween(start, end);
		List<Transferencia> response = new ArrayList<Transferencia>();
		for (int i = 0; i < transferencia.size(); i++) {
			if (transferencia.get(i).getNome().equalsIgnoreCase(nome)) {
				response.add(transferencia.get(i));
			}
			
		}
		return response;
	}
	
}
