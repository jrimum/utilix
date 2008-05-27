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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import br.com.nordestefomento.jrimum.ACurbitaObject;

/**
 * 
 * Esta classe tem a responsabilidade de prover serviços utilitários
 * relacionados a manipulação de Objetos <code>Date, Calendar, GregorianCalendar.</code>
 * 
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto 
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class Util4Date  extends ACurbitaObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4339951860440604914L;

	/**
	 * Formatador de datas no padrão dd/MM/yyyy.
	 */
	public static final DateFormat fmt_dd_MM_yyyy = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Formatador de datas no padrão ddMMyy.
	 */
	public static final DateFormat fmt_ddMMyy = new SimpleDateFormat("ddMMyy");
	
	/**
	 * Formatador de datas no padrão yyMMdd.
	 */
	public static final DateFormat fmt_yyMMdd = new SimpleDateFormat("yyMMdd");
	
	/**
	 * Representa uma data inexistente. Usada em casos que não se pode usar
	 * <code>null</code>.
	 * <br/>
	 * É obtida da seguinte forma: <code>new GregorianCalendar(1, 0, 1).getTime()</code>
	 */
	public static final Date DATE_NULL;
	
	static {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1, 0, 1);
		calendar.setLenient(false);
		DATE_NULL = DateUtils.truncate(calendar.getTime(), Calendar.YEAR);
	}

	/**
	 * <p>
	 * Calcula a diferença de dias entre duas datas. O resultado é modular, 
	 * ou seja, maior ou igual a zero, logo a data final não precisa ser 
	 * necessariamente maior que a data inicial.
	 * </p>
	 * 
	 * @param dataInicial - data inicial do intervalo.
	 * @param dataFinal - data final do intervalo.
	 * @return número(módulo) de dias entre as datas.
	 * 
	 * @throws IllegalArgumentException Caso pelo menos uma das duas datas seja <code>null</code>.
	 */
	public static long calculeDiferencaEmDias(final Date dataInicial, final Date dataFinal) throws IllegalArgumentException {
		
		long fator = 0;
		Date dataInicialTruncada, dataFinalTruncada;
	
		
		if (isNotNull(dataInicial) && isNotNull(dataFinal)) {
			
			dataInicialTruncada = DateUtils.truncate(dataInicial, Calendar.DATE);
			dataFinalTruncada   = DateUtils.truncate(dataFinal, Calendar.DATE);
			
			fator = ((dataFinalTruncada.getTime() - dataInicialTruncada.getTime()) / DateUtils.MILLIS_PER_DAY);
			
			if (fator < 0)
			  fator *= -1;
		}
		else {
			throw new IllegalArgumentException("A data inicial [" + dataInicial + "] e a data final [" + dataFinal + "] " +
					"não podem ter valor 'null'.");			
		}
	
		return fator;
	}

}
