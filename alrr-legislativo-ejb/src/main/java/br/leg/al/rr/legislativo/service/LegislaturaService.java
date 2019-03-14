package br.leg.al.rr.legislativo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import br.leg.rr.al.core.dao.BaseDominioJPADao;
import br.leg.rr.al.core.dao.BeanException;
import br.leg.rr.al.core.domain.StatusType;
import br.leg.rr.al.core.jpa.BaseEntityStatus_;
import br.leg.rr.al.legislativo.entity.Legislatura;
import br.leg.rr.al.legislativo.entity.Legislatura_;

@Named
@Stateless
public class LegislaturaService extends BaseDominioJPADao<Legislatura> implements LegislaturaLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3001313827531583652L;

	@Override
	public Boolean jaExiste(Legislatura entidade) {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Legislatura> root = cq.from(Legislatura.class);
		cq.select(cb.count(root));

		List<Predicate> predicates = new ArrayList<Predicate>();

		Predicate nome = cb.equal(root.get(Legislatura_.nome), entidade.getNome());
		predicates.add(nome);

		// condição para não verificar a mesma entidade se já existir.
		if (entidade.getId() != null) {
			Predicate id = cb.notEqual(root.get(BaseEntityStatus_.id), entidade.getId());
			predicates.add(id);
		}

		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Long> q = getEntityManager().createQuery(cq);
		if (q.getSingleResult() > 0) {
			throw new BeanException("Legislatura com este Nome já existe. Informe outro valor.");
		}

		return false;

	}

	@Override
	public List<Legislatura> pesquisar(Map<String, Object> params) {

		/** FILTROS **/
		List<Predicate> predicates = new ArrayList<Predicate>();
		Predicate cond = null;
		String nome = null;
		StatusType sit = null;

		final CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Legislatura> cq = cb.createQuery(Legislatura.class);
		final Root<Legislatura> root = cq.from(Legislatura.class);
		cq.select(root).distinct(true);

		if (params.size() > 0) {

			if (params.containsKey(PESQUISAR_PARAM_NOME)) {

				nome = (String) params.get(PESQUISAR_PARAM_NOME);

				if (StringUtils.isNotBlank(nome)) {

					cond = cb.like(cb.lower(root.get(Legislatura_.nome)), "%" + nome.toLowerCase() + "%");
					predicates.add(cond);
				}
			}

			if (params.containsKey(PESQUISAR_PARAM_SITUACAO)) {
				sit = (StatusType) params.get(PESQUISAR_PARAM_SITUACAO);
				if (sit != null) {
					cond = cb.equal(root.get(Legislatura_.situacao), sit);
					predicates.add(cond);
				}
			}

			cq.where(cb.and(predicates.toArray(new Predicate[] {})));
			return getResultList(cq);

		}

		return null;

	}

}
