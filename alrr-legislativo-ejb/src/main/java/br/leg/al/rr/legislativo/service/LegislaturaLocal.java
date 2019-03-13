package br.leg.al.rr.legislativo.service;

import javax.ejb.Local;

import br.leg.rr.al.core.dao.DominioJPADao;
import br.leg.rr.al.legislativo.entity.Legislatura;

@Local
public interface LegislaturaLocal extends DominioJPADao<Legislatura> {

}
