package br.leg.al.rr.legislativo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.leg.al.rr.legislativo.service.LegislaturaLocal;
import br.leg.rr.al.core.domain.StatusType;
import br.leg.rr.al.core.utils.StringHelper;
import br.leg.rr.al.core.web.controller.status.DialogControllerEntityStatus;
import br.leg.rr.al.legislativo.entity.Legislatura;

@Named
@ViewScoped
public class LegislaturaController extends DialogControllerEntityStatus<Legislatura, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3648549856125954471L;

	@EJB
	private LegislaturaLocal bean;

	private String nome;

	private StatusType situacao;

	@PostConstruct
	public void init() {
		setBean(bean);
		jaExisteMsg = "Legislatura já existe.";
		setNovoDialogName("dlg-legislatura");
		setEditarDialogName("dlg-legislatura");
		setDetalhesDialogName("dlg-legislatura-detalhes");
	}

	@Override
	public void prePesquisar() {

		Map<String, Object> filtros = new HashMap<String, Object>();
		filtros.put(LegislaturaLocal.PESQUISAR_PARAM_NOME, nome);
		filtros.put(LegislaturaLocal.PESQUISAR_PARAM_SITUACAO, situacao);

		setFiltros(filtros);
	}

	/**
	 * Transformar primeira letra de cada palavra em maiúscula.
	 */
	public void capitalizeNome() {
		String nome = StringHelper.capitalizeFully(getEntity().getNome());
		getEntity().setNome(nome);
	}

	public StatusType getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusType situacao) {
		this.situacao = situacao;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
