package br.com.banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.domain.Filtro;
import br.com.banco.domain.Transferencia;
import br.com.banco.service.DadosTransferenciaService;

@RestController
@RequestMapping(value = "supera/dadosTransferencia")
public class DadosTransferenciaController {
	
	@Autowired
	private DadosTransferenciaService service;
	
	@GetMapping
	public ResponseEntity<List<Transferencia>> buscarTodasTransferencias() {
		List<Transferencia> transferencias = service.buscarTodasTranferencias();
		return ResponseEntity.status(HttpStatus.OK).body(transferencias);
		
	}
	
	@GetMapping(path = "/conta/{id}")
	public ResponseEntity<Optional<Transferencia>> buscarTransferenciasPorId(@PathVariable Long id) {
		Optional<Transferencia> transferencias = service.buscarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(transferencias);
		
	}
	
	@GetMapping("/conta")
	public ResponseEntity<Transferencia> buscarTransferenciasPorNome(@RequestBody Transferencia request) {
		Transferencia transferencias = service.buscarPorNome(request.getNome());
		return ResponseEntity.status(HttpStatus.OK).body(transferencias);
		
	}
	
	@GetMapping("/buscar/contas")
	public ResponseEntity<List<Transferencia>> buscarTransferenciasPorData(@RequestBody Filtro request) {
		List<Transferencia> transferencias = service.buscarPorData(request.getDataInicio(), request.getDataFim());
		return ResponseEntity.status(HttpStatus.OK).body(transferencias);
		
	}
	
}
