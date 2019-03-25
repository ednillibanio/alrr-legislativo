package br.leg.rr.al.legislativo.domain;

import java.util.EnumMap;

import br.leg.rr.al.core.jpa.BasicEnum;

/**
 * Enum que representa as situações de um objeto do tipo entidade
 * (ComissaoType).
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * 
 * @since 1.0.0
 *
 * 
 */
public enum ComissaoType implements BasicEnum<ComissaoType> {

	PERMANENTE("Permanente");

	private String label;
	EnumMap<ComissaoType, String> map;

	private ComissaoType(String label) {
		this.label = label;

	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return label;
	}

	@Override
	public EnumMap<ComissaoType, String> getEnumMap() {
		if (map == null) {
			map = new EnumMap<ComissaoType, String>(ComissaoType.class);
			map.put(ComissaoType.PERMANENTE, "1");
		}
		return map;
	}

}
