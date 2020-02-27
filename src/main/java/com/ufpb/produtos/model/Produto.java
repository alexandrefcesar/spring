package com.ufpb.produtos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Produto {
    
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
    @NotEmpty
    @Size(max=90)
    @Column(name = "nomeDoProduto")
	private String nome;
	
    @NotEmpty
    @Min(0)
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoProduto() {
		return nome;
	}

	public void setNomeDoProduto(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nomeDoProduto=" + nome + ", valor=" + valor + "]";
	}

}
