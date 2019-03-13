package br.leg.al.rr.legislativo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.leg.rr.al.core.dao.BaseJPADao;
import br.leg.rr.al.legislativo.entity.Legislatura;
import br.leg.rr.al.legislativo.mesa.entity.MesaDiretora;
import br.leg.rr.al.legislativo.mesa.entity.MesaDiretora_;

@Named
@Stateless
public class MesaDiretoraService extends BaseJPADao<MesaDiretora, Integer> implements MesaDiretoraLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4792605947096933324L;

	@Override
	public List<MesaDiretora> buscarPorLegislatura(List<Legislatura> legislaturas) {

		CriteriaQuery<MesaDiretora> cq = createCriteriaQuery();
		Root<MesaDiretora> root = cq.from(MesaDiretora.class);
		cq.select(root);

		Expression<Legislatura> exp = root.get(MesaDiretora_.legislatura);
		Predicate in = exp.in(legislaturas);
		cq.where(in);

		return getResultList(cq);
	}

	@Override
	public List<MesaDiretora> buscarPorLegislatura(Legislatura legislatura) {
		List<Legislatura> legislaturas = new ArrayList<Legislatura>();
		legislaturas.add(legislatura);
		return buscarPorLegislatura(legislaturas);
	}

	// TODO: implementar
	@Override
	public Boolean jaExiste(MesaDiretora entidade) {
		return false;
	}

}
