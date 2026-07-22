package com.generation.infostore.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_clientes")

public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotBlank(message = "Atributo Produto é obrigatorio!")
	@Size(min = 2, max = 100, message = "Nome do produto deve conter entre 2 e 100 caracteres!")
	@Column(name = "produto", nullable = false, length = 100)
	public String produto;
	
	@NotBlank(message = "Atributo descrição é obrigatorio!")
	@Size(min = 5, max = 500, message = "Nome do produto deve conter entre 5 e 500 caracteres!")
	@Column(name = "descricao", nullable = false, length = 100)
	public String descricao;
	
	@NotNull(message = "O atributo preço é obrigatório!")
	@Positive(message = "O atributo preço deve ser maior que zero!")
	@Column(nullable = false)
	private BigDecimal valor;
	
	@UpdateTimestamp
	public LocalDateTime data;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	@JsonBackReference
	private Cliente cliente;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
