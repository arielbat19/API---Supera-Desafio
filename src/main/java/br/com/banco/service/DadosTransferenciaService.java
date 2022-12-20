package br.com.banco.service;

import java.util.List;

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
	
}
