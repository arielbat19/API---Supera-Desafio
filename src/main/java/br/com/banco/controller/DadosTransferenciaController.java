package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
