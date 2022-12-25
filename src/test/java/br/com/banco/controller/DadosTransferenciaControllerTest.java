package br.com.banco.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.banco.domain.Filtro;
import br.com.banco.domain.Transferencia;
import br.com.banco.service.DadosTransferenciaService;

@ExtendWith(SpringExtension.class)
public class DadosTransferenciaControllerTest {

	@Mock
	private DadosTransferenciaService service;

	@InjectMocks
	private DadosTransferenciaController controller;

	Transferencia transferencia;
	List<Transferencia> transferenciaList;

	Filtro filtro;

	@BeforeEach
	public void initialize() {
		MockitoAnnotations.initMocks(this);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		transferencia = new Transferencia();
		transferenciaList = new ArrayList<Transferencia>();
		transferencia.setConta_id("1");
		transferencia.setData(timestamp);
		transferencia.setId(1L);
		transferencia.setNome("Beltrano");
		transferencia.setNome_operador_transferencias(null);
		transferencia.setTipo("TRANSFERENCIA");
		transferencia.setValor(25173.09);
		transferenciaList.add(transferencia);

		filtro = new Filtro();
		filtro.setDataFim(timestamp);
		filtro.setDataFim(timestamp);
		filtro.setNome("Beltrano");

	}

	@Test
	@DisplayName("Deve buscar todas as transferencias")
	void deveBuscarTodasTransferencias() {

		when(service.buscarTodasTranferencias()).thenReturn(transferenciaList);

		ResponseEntity<List<Transferencia>> request = controller.buscarTodasTransferencias();
		
		request.ok().body(transferenciaList);
		assertEquals(HttpStatus.OK, request.getStatusCode());
		assertNotNull(request);
		//assertEquals(request.getBody(), transferenciaList);

	}

	@Test
	@DisplayName("Deve buscar todas as transferencias por ID")
	void deveBuscarTodasTransferenciasPorId() {

		when(service.buscarPorId(Mockito.anyLong())).thenReturn(Optional.of(transferencia));

		ResponseEntity<Optional<Transferencia>> request = controller.buscarTransferenciasPorId(1L);

		request.ok().body(transferencia);
		assertEquals(HttpStatus.OK, request.getStatusCode());
		assertNotNull(request);

	}

	@Test
	@DisplayName("Deve buscar todas as transferencias por NOME")
	void deveBuscarTodasTransferenciasPorNome() {

		when(service.buscarPorNome(Mockito.anyString())).thenReturn(transferencia);

		ResponseEntity<Transferencia> request = controller.buscarTransferenciasPorNome(transferencia);

		request.ok().body(transferencia);
		assertEquals(HttpStatus.OK, request.getStatusCode());
		assertNotNull(request);

	}

	@Test
	@DisplayName("Deve buscar todas as transferencias por DATA")
	void deveBuscarTodasTransferenciasPorData() {

		when(service.buscarPorData(Mockito.any(Timestamp.class), Mockito.any(Timestamp.class)))
				.thenReturn(transferenciaList);

		ResponseEntity<List<Transferencia>> request = controller.buscarTransferenciasPorData(filtro);

		request.ok().body(transferenciaList);
		assertEquals(HttpStatus.OK, request.getStatusCode());
		assertNotNull(request);
		//assertEquals(request.getBody(), transferenciaList);

	}

	@Test
	@DisplayName("Deve buscar todas as transferencias por DATA e NOME")
	void deveBuscarTodasTransferenciasPorDataENome() {

		when(service.buscarPorDataENome(Mockito.any(Timestamp.class), Mockito.any(Timestamp.class),
				Mockito.anyString())).thenReturn(transferenciaList);

		ResponseEntity<List<Transferencia>> request = controller.buscarTransferenciasPorDataENome(filtro);

		request.ok().body(transferenciaList);
		assertEquals(HttpStatus.OK, request.getStatusCode());
		assertNotNull(request);
		//assertEquals(request.getBody(), transferenciaList);

	}

}
