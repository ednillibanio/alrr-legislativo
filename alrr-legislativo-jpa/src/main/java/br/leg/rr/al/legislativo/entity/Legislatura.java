package br.leg.rr.al.legislativo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import br.leg.rr.al.core.jpa.Dominio;

@Entity
public class Legislatura extends Dominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4371269050979657274L;

	@Column(length = 4, nullable = true, name = "ano_inicio")
	private String anoInicio;

	@Column(length = 4, nullable = true, name = "ano_fim")
	private String anoFim;

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
	 * Método transiente que retorna uma string com o ano inicio e ano fim. Ex.
	 * "2010 - 2014"
	 * 
	 * @return união dos valores: ano inicio e ano fim.
	 */
	@Transient
	public String getPeriodo() {
		if (StringUtils.isNotBlank(anoInicio) && StringUtils.isNotBlank(anoFim)) {
			return anoInicio.concat(" - ").concat(anoFim);
		}
		return null;
	}
}
