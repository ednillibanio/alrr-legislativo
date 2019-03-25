/*******************************************************************************
 * Copyright (c) 2017, KMDR Consultoria e Serviços, Boa Vista, RR - Brasil.
 * Todos os direitos reservados. Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.legislativo.utils;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import br.leg.rr.al.legislativo.domain.CargoMembroMesaDiretora;

/**
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * 
 * @since 1.0.0
 */
@Named
@RequestScoped
public class LegislativoEnumFactory {

	@Produces
	public CargoMembroMesaDiretora[] getCargosMesaDiretora() {
		return CargoMembroMesaDiretora.values();
	}

}
