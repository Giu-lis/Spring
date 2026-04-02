package com.devsenai2A.giulia.petshop.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")

public class Produtos implements Serializable {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProdutos;
	
	private String nome;
	private String descricao;
	private Double preco;
	private Double preco_desconto;
	private String imagem;
	private Double qtd_estoque;
	private Boolean ativo;
	
	@ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
    public Integer getIdProduto() {
        return idProdutos;
    }
    
    public Produtos () {
    	
    }
    
    
    public Produtos (String nome, String descricao, Double preco, Double preco_desconto, String imagem, Double qtd_estoque, Boolean ativo) {
    	this.nome = nome;
    	this.descricao = descricao;
    	this.preco = preco;
    	this.preco_desconto = preco_desconto;
    	this.imagem = imagem;
    	this.qtd_estoque = qtd_estoque;
    	this.ativo = ativo;
    }

	public Integer getIdProdutos() {
		return idProdutos;
	}

	public void setIdProdutos(Integer idProdutos) {
		this.idProdutos = idProdutos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPreco_desconto() {
		return preco_desconto;
	}

	public void setPreco_desconto(Double preco_desconto) {
		this.preco_desconto = preco_desconto;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Double getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(Double qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
    

}
