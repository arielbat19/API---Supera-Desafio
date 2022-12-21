package br.com.banco.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filtro {
	
	private Timestamp dataInicio;
	private Timestamp dataFim;
	private String nome;

}
