/*******************************************************************************
 * Copyright (c) 2017, KMDR Consultoria e Serviços, Boa Vista, RR - Brasil.
 * Todos os direitos reservados. Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.legislativo.mesa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.leg.rr.al.core.jpa.BaseEntityStatus;
import br.leg.rr.al.legislativo.entity.Legislatura;

/**
 * The persistent class for the pessoa_fisica database table.
 * 
 */
@Entity
@Table(name = "mesa_diretora")
public class MesaDiretora extends BaseEntityStatus<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 526344525628753871L;

	@OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "mesaDiretora")
	private Set<MembroMesaDiretora> membros;

	@NotNull(message = "Legislatura: campo obrigatório.")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "legislatura_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "legislatura_fk"))
	private Legislatura legislatura;

	@Column(length = 4, nullable = true, name = "ano_inicio")
	private String anoInicio;

	@Column(length = 4, nullable = true, name = "ano_fim")
	private String anoFim;

	/**
	 * @return the anoFim
	 */
	public String getAnoFim() {
		return anoFim;
	}

	/**
	 * @param anoFim the anoFim to set
	 */
	public void setAnoFim(String anoFim) {
		this.anoFim = anoFim;
	}

	/**
	 * @return the anoInicio
	 */
	public String getAnoInicio() {
		return anoInicio;
	}

	/**
	 * @param anoInicio the anoInicio to set
	 */
	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}

	/**
	 * @return the legislatura
	 */
	public Legislatura getLegislatura() {
		return legislatura;
	}

	/**
	 * @param legislatura the legislatura to set
	 */
	public void setLegislatura(Legislatura legislatura) {
		this.legislatura = legislatura;
	}

	/**
	 * @return the membros
	 */
	public Set<MembroMesaDiretora> getMembros() {
		return membros;
	}

	/**
	 * @param membros the membros to set
	 */
	public void setMembros(Set<MembroMesaDiretora> membros) {
		this.membros = membros;
	}

}
