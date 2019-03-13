package br.leg.al.rr.legislativo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.leg.al.rr.legislativo.service.MesaDiretoraLocal;
import br.leg.rr.al.core.web.controller.DialogController;
import br.leg.rr.al.legislativo.domain.CargoMesaDiretora;
import br.leg.rr.al.legislativo.entity.Legislatura;
import br.leg.rr.al.legislativo.mesa.entity.MesaDiretora;

@Named
@ViewScoped
public class MesaDiretoraController extends DialogController<MesaDiretora, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3648549856125954471L;

	@EJB
	private MesaDiretoraLocal bean;

	private String nome;

	private List<Legislatura> legislaturasSelecionadas;

	private List<CargoMesaDiretora> cargosSelecionados;

	@PostConstruct
	public void init() {
		setBean(bean);
		setNovoDialogName("dlg-mesa-diretora");
		setEditarDialogName("dlg-mesa-diretora");
	}

	@Produces
	public CargoMesaDiretora[] getCargos() {
		return CargoMesaDiretora.values();

	}

	@Override
	public String pesquisar() {
		setEntities(bean.buscarTodos());
		createDataModel(getEntities());

		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Legislatura> getLegislaturasSelecionadas() {
		return legislaturasSelecionadas;
	}

	public void setLegislaturasSelecionadas(List<Legislatura> legislaturasSelecionadas) {
		this.legislaturasSelecionadas = legislaturasSelecionadas;
	}

	public List<CargoMesaDiretora> getCargosSelecionados() {
		return cargosSelecionados;
	}

	public void setCargosSelecionados(List<CargoMesaDiretora> cargosSelecionados) {
		this.cargosSelecionados = cargosSelecionados;
	}



}
