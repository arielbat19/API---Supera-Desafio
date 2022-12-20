package br.com.banco.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transferencia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date data_transferencia;
	private Double valor;
	private String tipo;
	private String nome_operador_transferencias;
	private String conta_id;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta_id == null) ? 0 : conta_id.hashCode());
		result = prime * result + ((data_transferencia == null) ? 0 : data_transferencia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nome_operador_transferencias == null) ? 0 : nome_operador_transferencias.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencia other = (Transferencia) obj;
		if (conta_id == null) {
			if (other.conta_id != null)
				return false;
		} else if (!conta_id.equals(other.conta_id))
			return false;
		if (data_transferencia == null) {
			if (other.data_transferencia != null)
				return false;
		} else if (!data_transferencia.equals(other.data_transferencia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome_operador_transferencias == null) {
			if (other.nome_operador_transferencias != null)
				return false;
		} else if (!nome_operador_transferencias.equals(other.nome_operador_transferencias))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
}
