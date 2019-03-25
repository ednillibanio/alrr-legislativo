package br.leg.rr.al.legislativo.domain;

import java.util.EnumMap;

import br.leg.rr.al.core.jpa.BasicEnum;

public enum CargoMembroComissao implements BasicEnum<CargoMembroComissao> {

	PRESIDENTE("Presidente"), VICE_PRESIDENTE("Vice-Presidente"), MEMBRO("Membro");

	private CargoMembroComissao(String label) {
		this.label = label;

	}

	private String label;

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return label;
	}

	/**
	 * Contém os valores das chaves que serão armazenados no banco de dados.
	 * 
	 * @return Retorna uma lista com todos os CargoMembroComissao.
	 */
	@Override
	public EnumMap<CargoMembroComissao, String> getEnumMap() {
		EnumMap<CargoMembroComissao, String> map = new EnumMap<CargoMembroComissao, String>(CargoMembroComissao.class);
		map.put(CargoMembroComissao.PRESIDENTE, "1");
		map.put(CargoMembroComissao.VICE_PRESIDENTE, "2");
		map.put(CargoMembroComissao.MEMBRO, "3");

		return map;
	}

}
