/*******************************************************************************
 * Copyright (c) 2017, KMDR Consultoria e Serviços, Boa Vista, RR - Brasil.
 * Todos os direitos reservados. Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.legislativo.mesa.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.leg.rr.al.core.jpa.BaseEntity;
import br.leg.rr.al.legislativo.entity.Legislatura;

/**
 * The persistent class for the pessoa_fisica database table.
 * 
 */
@Entity
@Table(name = "mesa_diretora")
public class MesaDiretora extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 526344525628753871L;

	@OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "mesaDiretora")
	private Set<MembroMesaDiretora> membros;

	@NotNull(message = "Legislatura: preenchimento obrigatório")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "legislatura_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "legislatura_fk"))
	private Legislatura legislatura;

}
