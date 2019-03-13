package br.leg.al.rr.legislativo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.leg.al.rr.legislativo.service.MembroMesaDiretoraLocal;
import br.leg.rr.al.core.dao.BeanException;
import br.leg.rr.al.core.web.controller.DialogController;
import br.leg.rr.al.core.web.util.FacesMessageUtils;
import br.leg.rr.al.legislativo.domain.CargoMesaDiretora;
import br.leg.rr.al.legislativo.mesa.entity.MembroMesaDiretora;

@Named
@ViewScoped
public class MembroMesaDiretoraController extends DialogController<MembroMesaDiretora, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3648549856125954471L;

	@EJB
	private MembroMesaDiretoraLocal bean;

	@PostConstruct
	public void init() {
		setBean(bean);
		setNovoDialogName("dlg-membro-mesa");
		setEditarDialogName("dlg-membro-mesa");
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

	/**
	 * Método usado para buscar Localidades. A busca é realizada por parte do nome
	 * informado.
	 * 
	 * @param nome
	 * @return lista de localidades. <code>null </code> se nenhum encontrado.
	 */
	public List<MembroMesaDiretora> completeByNome(String nome) {
		if (StringUtils.isNotBlank(nome) && (!nome.equals(" - "))) {
			try {
				return bean.buscarPorNome(nome);
			} catch (BeanException e) {
				FacesMessageUtils.addFatal(e.getMessage());
				e.printStackTrace();
			}

		}

		return null;
	}

}
