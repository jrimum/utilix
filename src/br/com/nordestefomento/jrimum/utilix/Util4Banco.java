/*
 * Copyright 2008 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * Created at: 30/03/2008 - 18:17:40
 * 
 * ================================================================================
 * 
 * Direitos autorais 2008 JRimum Project
 * 
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode usar
 * esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que
 * haja exigência legal ou acordo por escrito, a distribuição de software sob
 * esta LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER
 * TIPO, sejam expressas ou tácitas. Veja a LICENÇA para a redação específica a
 * reger permissões e limitações sob esta LICENÇA.
 * 
 * Criado em: 30/03/2008 - 18:17:40
 * 
 */


package br.com.nordestefomento.jrimum.utilix;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import br.com.nordestefomento.jrimum.ACurbitaObject;
import br.com.nordestefomento.jrimum.JRimumException;


/**
 * 
 * Esta classe tem a responsabilidade de prover serviços utilitários
 * do universo bancário, como por exemplo calcular o fator de vencimento.</code>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto 
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since Utilix 1.0
 * 
 * @version 1.0
 */

public class Util4Banco extends ACurbitaObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private static final Date DATA_BASE_DO_FATOR_DE_VENCIMENTO = new GregorianCalendar(1997, Calendar.OCTOBER, 7).getTime();
	
	
	/**
	 *
	 *<p>
	 * 		Calcula o fator de vencimento, com base na subtração entre a 
	 * 		DATA DE VENCIMENTO do título e a DATA BASE , fixada em
	 * 		07.10.1997 (03.07.2000 retrocedidos 1000 dias do início do processo).
	 * 		Trata-se de um referencial numérico de 4 dígitos, situado nas
	 * 		quatro primeiras posições do campo “valor”, que representa a
	 * 		quantidade de dias decorridos da data base à data de vencimento
	 * 		do título.
	 *</p>
	 *<p>
	 * 		Os bloquetos de cobrança emitidos a partir de 1º de setembro
	 * 		de 2000 (primeiro dia útil = 03/07/2000 - SEGUNDA)
	 * 		devem conter essas características, para que quando
	 * 		forem capturados pela rede bancária, os sistemas possam realizar
	 * 		operação inversa, ou seja, adicionar à data base o fator de
	 * 		vencimento capturado, obtendo, dessa forma, a data do
	 * 		vencimento do bloqueto.<br/>
	 * 		
	 * 		Exemplos: 03/07/2000(Fator = 1000), 05/07/2000(Fator = 1002), 
	 * 		01/05/2002 (Fator = 1667), 05/07/2000(Fator = 1002)
	 * 		e 21/02/2025(Fator = 9999).
	 *</p>
	 *
	 *<p>
	 *		Observações: 
	 *		<ul>
	 *			<li>
	 *				O valor limite mínimo para o fator de vencimento é 1000
	 *				(data de vencimento = 03/07/2000). Caso a data de vencimento seja
	 *				anterior a 03/07/2000, ao fator de vencimento é atribuído o 
	 *				valor 0(ZERO).
	 *			</li>
	 *			<li>
	 *				O valor limite máximo para o fator de vencimento é 9999
	 *				(data de vencimento = 21/02/2025). Caso a data de vencimento seja
	 *				posterior a 21/02/2025, uma exceção do tipo JRimumException
	 *				será lançada.
	 *			</li>
	 *		</ul>
	 *</p>
	 *
	 * @param dataVencimento - data de vencimento.
	 * @return fator de vencimento.
	 */	
	public static int calculcarFatorVencimento(Date dataVencimento) throws JRimumException{
		
		final long fatorMinimo = 1000;
		final long fatorMaximo = 9999;
		long fator = Util4Date.calculeDiferencaEmDias(DATA_BASE_DO_FATOR_DE_VENCIMENTO, dataVencimento);
		
		if (fator < fatorMinimo) {
			fator = 0;
			
			if(log.isDebugEnabled()) {
				log.debug(
						    "Cálculo do fator de vencimento: Como a data de " +
						    "vencimento informada (" +
						    Util4Date.fmt_dd_MM_yyyy.format(dataVencimento) +
						    ") é anterior a 03/07/2000, ao fator de vencimento" +
						    " foi atribuído o valor ZERO."
						 ); 
			}
		}
		else if (fator > fatorMaximo) {
			throw new JRimumException("Fator de vencimento: Limite máximo " +
					"ultrapassado devido ao fato da data de vencimento " +
					"informada (" + Util4Date.fmt_dd_MM_yyyy.format(dataVencimento) +
					") ser superior ao 21/02/2025(Fator = " + fatorMaximo + ").");
		}
			
		
		return (int) fator;
	}
}
