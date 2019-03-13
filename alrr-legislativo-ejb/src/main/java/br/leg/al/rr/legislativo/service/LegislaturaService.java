package br.leg.al.rr.legislativo.service;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.leg.rr.al.core.dao.BaseDominioJPADao;
import br.leg.rr.al.legislativo.entity.Legislatura;

@Named
@Stateless
public class LegislaturaService extends BaseDominioJPADao<Legislatura> implements LegislaturaLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3001313827531583652L;

	//TODO: implementar
	@Override
	public Boolean jaExiste(Legislatura entidade) {
		return false;
	}

}
