package br.leg.rr.al.legislativo.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.leg.al.rr.commons.entity.PartidoPolitico;
import br.leg.al.rr.core.domain.StatusConverter;
import br.leg.rr.al.core.domain.StatusType;

@Entity
@Table(name = "deputado")
public class Deputado extends PessoaFisica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8892617998873967519L;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "partido_politico_id", referencedColumnName = "id", foreignKey = @ForeignKey(value = "partido_politico_fk"), nullable = true)
	private PartidoPolitico partido;

	/**
	 * Desabilita o deputado no sistema para não ser mais carregado nos componentes.
	 * Default é Ativo.
	 */
	@NotNull(message = "Situação: preenchimento obrigatório")
	@Column(length = 1, nullable = false)
	@Convert(converter = StatusConverter.class)
	private StatusType situacao = StatusType.ATIVO;

	public PartidoPolitico getPartido() {
		return partido;
	}

	public void setPartido(PartidoPolitico partido) {
		this.partido = partido;
	}

	public StatusType getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusType situacao) {
		this.situacao = situacao;
	}

}
