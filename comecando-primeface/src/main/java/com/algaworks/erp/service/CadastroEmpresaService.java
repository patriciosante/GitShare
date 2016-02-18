package com.algaworks.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.Item;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.repository.Itens;
import com.algaworks.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	
	@Inject
	private Itens itens;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresas.guardar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}
	
	
	@Transacional
	public void salvar(Item item)
	{
	  itens.quardar(item);
	}
	
	@Transacional
	public void excluir(Item item)
	{
		itens.remover(item);
	}
}