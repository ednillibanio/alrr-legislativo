package br.leg.al.rr.legislativo.service;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.leg.rr.al.core.dao.BaseJPADao;
import br.leg.rr.al.legislativo.mesa.entity.MembroMesaDiretora;

@Named
@Stateless
public class MembroMesaDiretoraService extends BaseJPADao<MembroMesaDiretora, Integer>
		implements MembroMesaDiretoraLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515878187804135727L;

	// TODO: implementar
	@Override
	public Boolean jaExiste(MembroMesaDiretora entidade) {
		return false;
	}

}
