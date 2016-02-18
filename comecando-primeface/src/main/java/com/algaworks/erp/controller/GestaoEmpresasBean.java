package com.algaworks.erp.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.service.CadastroEmpresaService;
import com.algaworks.erp.util.FacesMessages;

;

/**
 *
 * @author dellNote
 */
@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;

	@Inject
	private CadastroEmpresaService cadastroEmpresaService;

	@Inject
	private FacesMessages messages;

	private List<Empresa> todasEmpresas;

	private Empresa empresaEdicao = new Empresa();
	public void setEmpresaEdicao(Empresa empresaEdicao) {
		this.empresaEdicao = empresaEdicao;
	}

	private Empresa empresaSelecionada;

	public List<Empresa> getTodasEmpresas() {
		return todasEmpresas;
	}

	public Empresa getEmpresaEdicao() {
		return empresaEdicao;
	}

	public void prepararNovaEmpresa() {
		empresaEdicao = new Empresa();
	}

	public void consultar() {
		todasEmpresas = empresas.todas();
	}

	public TipoEmpresa[] getTiposEmpresas() {

		return TipoEmpresa.values();
	}

	public void salvar() {
		cadastroEmpresaService.salvar(empresaEdicao);
		consultar();

		RequestContext.getCurrentInstance().update(Arrays.asList("frm:Msgs", "frm:empresas-table"));
		messages.info("Empresa salva com sucesso");
	}
	
	public void excluir()
	{
		cadastroEmpresaService.excluir(empresaSelecionada);
		empresaSelecionada = null;
		
		consultar();
		
		messages.info("Empresa Excuida com sucesso");
		
	}

	public Empresa getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Empresa empresaSelecionada) {

		this.empresaSelecionada = empresaSelecionada;
	}

}
