package br.leg.rr.al.legislativo.mesa.entity;

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
import br.leg.rr.al.legislativo.domain.CargoMembroMesaDiretora;
import br.leg.rr.al.legislativo.domain.CargoMembroMesaDiretoraConverter;

@Entity
@Table(name = "membro_mesa_diretora")
public class MembroMesaDiretora extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3166090862062075886L;

	@NotNull(message = "Mesa Diretora: preenchimento obrigatório")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "mesa_diretora_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "mesa_diretora_fk"))
	private MesaDiretora mesaDiretora;

	@NotNull(message = "Cargo: preenchimento obrigatório")
	@Convert(converter = CargoMembroMesaDiretoraConverter.class)
	@Column(length = 1)
	private CargoMembroMesaDiretora cargo;

	// FIXME: comentado temporariamente até implementar pessoa.
	// @ManyToOne
	// private Deputado deputado;

	public MesaDiretora getMesaDiretora() {
		return mesaDiretora;
	}

	public void setMesaDiretora(MesaDiretora mesaDiretora) {
		this.mesaDiretora = mesaDiretora;
	}

	/**
	 * @return the cargo
	 */
	public CargoMembroMesaDiretora getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(CargoMembroMesaDiretora cargo) {
		this.cargo = cargo;
	}

	/*
	 * public Deputado getDeputado() { return deputado; }
	 * 
	 * public void setDeputado(Deputado deputado) { this.deputado = deputado; }
	 */

}
