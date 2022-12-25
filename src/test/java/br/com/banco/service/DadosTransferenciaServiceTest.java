package br.com.banco.service;

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
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.banco.domain.Filtro;
import br.com.banco.domain.Transferencia;
import br.com.banco.repository.DadosTransferenciaRepository;

@ExtendWith(SpringExtension.class)
public class DadosTransferenciaServiceTest {
	
	@Mock
	private DadosTransferenciaRepository repository;
	
	@InjectMocks
	private DadosTransferenciaService service;
	
	Transferencia transferencia;
	List<Transferencia> transferenciaList;
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	Filtro filtro;
	
	@BeforeEach
	public void initialize() {
		MockitoAnnotations.initMocks(this);
		
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
	@DisplayName("Deve buscar todas transferencias")
	void deveBuscarTodasTrasnferencias() {
		when(repository.findAll()).thenReturn(transferenciaList);
		
		List<Transferencia> listaTransferencia = service.buscarTodasTranferencias();
		
		assertNotNull(listaTransferencia);
	}

	@Test
	@DisplayName("Deve buscar transferencias por ID")
	void deveBuscarTrasnferenciasPorId() {
		when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(transferencia));
		
		Optional<Transferencia> transferenciaPorId = service.buscarPorId(1L);
		
		assertNotNull(transferenciaPorId);
	}
	
	@Test
	@DisplayName("Deve buscar contas por ID")
	void deveBuscarContasPorId() {
		when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(transferencia));
		
		Optional<Transferencia> transferenciaPorId = service.buscarPorId(1L);
		
		assertNotNull(transferenciaPorId);
	}

	@Test
	@DisplayName("Deve buscar transferencias por nome")
	void deveBuscarTransferenciasPorNome() {
		when(repository.findByNome(Mockito.anyString())).thenReturn(transferencia);
		
		Transferencia transferenciaPorNome = service.buscarPorNome("Beltrano");
		
		assertNotNull(transferenciaPorNome);
	}

	@Test
	@DisplayName("Deve buscar transferencias por data")
	void deveBuscarTransferenciasPorData() {
		when(repository.findByDataBetween(Mockito.any(), Mockito.any())).thenReturn(transferenciaList);
		
		List<Transferencia> transferenciaPorData = service.buscarPorData(timestamp, timestamp);
		
		assertNotNull(transferenciaPorData);
	}
	
	@Test
	@DisplayName("Deve buscar transferencias por data e nome")
	void deveBuscarTransferenciasPorDataENome() {
		List<Transferencia> retorno = (List<Transferencia>) when(repository.findByDataBetween(Mockito.any(), Mockito.any())).thenReturn(transferenciaList);
		
		List<Transferencia> transferenciaPorDataENome = new ArrayList<Transferencia>();
		for (int i = 0; i < retorno.size(); i++) {
			if (retorno.get(i).getNome().equalsIgnoreCase(transferencia.getNome())) {
				transferenciaPorDataENome.add(retorno.get(i));
			}
			
		}
		assertNotNull(transferenciaPorDataENome);
	}
	
}
