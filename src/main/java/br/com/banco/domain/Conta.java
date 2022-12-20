package br.com.banco.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_conta;
	private String nome_responsavel;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_conta == null) ? 0 : id_conta.hashCode());
		result = prime * result + ((nome_responsavel == null) ? 0 : nome_responsavel.hashCode());
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
		Conta other = (Conta) obj;
		if (id_conta == null) {
			if (other.id_conta != null)
				return false;
		} else if (!id_conta.equals(other.id_conta))
			return false;
		if (nome_responsavel == null) {
			if (other.nome_responsavel != null)
				return false;
		} else if (!nome_responsavel.equals(other.nome_responsavel))
			return false;
		return true;
	}
	
	
}
