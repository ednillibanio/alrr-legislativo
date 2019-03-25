package br.leg.rr.al.legislativo.domain;

import java.util.EnumMap;

import br.leg.rr.al.core.jpa.BasicEnum;

public enum CargoMembroMesaDiretora implements BasicEnum<CargoMembroMesaDiretora> {

	PRESIDENTE("Presidente"), PRIMEIRO_VICE("1º Vice-presidente"), SEGUNDO_VICE("2º Vice-presidente"),
	TERCEIRO_VICE("3º Vice-presidente"), PRIMEIRO_SECRETARIO("1º Secretário"), SEGUNDO_SECRETARIO("2º Secretário"),
	TERCEIRO_SECRETARIO("3º Secretário"), QUARTO_SECRETARIO("4º Secretário"), CORREGEDOR_GERAL("Corregedor Geral"),
	OUVIDOR_GERAL("Ouvidor Geral");

	private CargoMembroMesaDiretora(String label) {
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
	 * @return Retorna uma lista com todos os EstadoCivilType.
	 */
	@Override
	public EnumMap<CargoMembroMesaDiretora, String> getEnumMap() {
		EnumMap<CargoMembroMesaDiretora, String> map = new EnumMap<CargoMembroMesaDiretora, String>(CargoMembroMesaDiretora.class);
		map.put(CargoMembroMesaDiretora.PRESIDENTE, "1");
		map.put(CargoMembroMesaDiretora.PRIMEIRO_VICE, "2");
		map.put(CargoMembroMesaDiretora.SEGUNDO_VICE, "3");
		map.put(CargoMembroMesaDiretora.TERCEIRO_VICE, "4");
		map.put(CargoMembroMesaDiretora.PRIMEIRO_SECRETARIO, "5");
		map.put(CargoMembroMesaDiretora.SEGUNDO_SECRETARIO, "6");
		map.put(CargoMembroMesaDiretora.TERCEIRO_SECRETARIO, "7");
		map.put(CargoMembroMesaDiretora.CORREGEDOR_GERAL, "8");
		map.put(CargoMembroMesaDiretora.OUVIDOR_GERAL, "9");

		return map;
	}

}
