package com.algaworks.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;;


@Entity(name="itens")
public class Item  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
    @NotNull
    @Column(nullable=false,length =20)
    private String nome;
    
    @NotNull
    @Column(nullable= false, length = 200)
	private String descricao;
    
    @Min(value = 0)
    @NotNull
    @Column(nullable = false)
	private int QtdsEstoque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getQtdsEstoque() {
		return QtdsEstoque;
	}

	public void setQtdsEstoque(int qtdsEstoque) {
		QtdsEstoque = qtdsEstoque;
	}
    
    
}
