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

import br.leg.rr.al.core.jpa.BaseEntity;
import br.leg.rr.al.legislativo.domain.CargoMembroComissao;

@Entity
@Table(name = "membro_mesa_diretora")
public class MembroComissao extends BaseEntity<Integer> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8663528018231120530L;

	@NotNull(message = "Comissão: campo obrigatório.")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "comissao_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "comissao_fk"))
	private Comissao comissao;

	@NotNull(message = "Cargo: campo obrigatório.")
	@Convert(converter = CargoMembroComissao.class)
	@Column(length = 1)
	private CargoMembroComissao cargo;

	/**
	 * @return the comissao
	 */
	public Comissao getComissao() {
		return comissao;
	}

	/**
	 * @param comissao the comissao to set
	 */
	public void setComissao(Comissao comissao) {
		this.comissao = comissao;
	}

	/**
	 * @return the cargo
	 */
	public CargoMembroComissao getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(CargoMembroComissao cargo) {
		this.cargo = cargo;
	}

	// FIXME: comentado temporariamente até implementar pessoa.
	// @ManyToOne
	// private Deputado deputado;

}
