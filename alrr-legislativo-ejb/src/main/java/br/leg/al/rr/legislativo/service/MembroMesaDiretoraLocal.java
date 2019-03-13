package br.leg.al.rr.legislativo.service;

import javax.ejb.Local;

import br.leg.rr.al.core.dao.JPADao;
import br.leg.rr.al.legislativo.mesa.entity.MembroMesaDiretora;

@Local
public interface MembroMesaDiretoraLocal extends JPADao<MembroMesaDiretora, Integer> {

}
