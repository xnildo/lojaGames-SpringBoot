package br.com.generation.lojagames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //SERA UMA ENTIDADE DO JPA
@Table(name = "tb_categorias") //CRIAÇÃO DA TABELA CATEGORIA
public class Categoria {
	//ATRIBUTOS E MÉTODOS
	
	@Id // ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO-INCREMENTO
	private long id;
	
	@NotNull
	private String categoria;
	
	@NotNull
	private String descricao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")//VAI IGNORAR O ATRIBUTOS CATEGORIAS
	private List<Produto> produtos;

	public long getId() {
		return id;
	}
	

	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}