package br.com.generation.lojagames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // SERA UMA ENTIDADE DO JPA
@Table(name = "tb_produtos") // CRIAÇÃO DA TABELA TEMA
public class Produto {

	// ATRIBUTOS E MÉTODOS
	@Id // ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO-INCREMENTO
	private long id;

	@NotNull
	private String nome;

	@NotNull
	private String marca;
	
	@NotNull
	private double preco;
	
	private int qtd;
	
	@ManyToOne //FAZENDO RELAÇAO DESSA TABLEA COM A TABELA TEMA 
	@JsonIgnoreProperties("produtos")//	VAI IGNORAR O ATRIBUTOS PRODUTO 
	private Categoria categoria;
	
	@ManyToOne //FAZENDO RELAÇAO DESSA TABLEA COM A TABELA TEMA 
	@JsonIgnoreProperties("produtos")//	VAI IGNORAR O ATRIBUTOS PRODUTO 
	private Usuario usuario;
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	
}
