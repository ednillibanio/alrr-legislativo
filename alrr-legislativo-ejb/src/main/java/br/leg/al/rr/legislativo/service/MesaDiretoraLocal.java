/*******************************************************************************
 * Copyright (c) 2017, KMDR Consultoria e Serviços, Boa Vista, RR - Brasil.
 * Todos os direitos reservados. Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.al.rr.legislativo.service;

import java.util.List;

import javax.ejb.Local;

import br.leg.rr.al.core.dao.JPADao;
import br.leg.rr.al.legislativo.entity.Legislatura;
import br.leg.rr.al.legislativo.mesa.entity.MesaDiretora;

@Local
public interface MesaDiretoraLocal extends JPADao<MesaDiretora, Integer> {

	public List<MesaDiretora> buscarPorLegislatura(List<Legislatura> legislaturas);

	public List<MesaDiretora> buscarPorLegislatura(Legislatura legislatura);
}
