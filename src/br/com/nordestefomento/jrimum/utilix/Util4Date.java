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
 * @author Gabriel Guimarães
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto 
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since JMatryx 1.0
 * 
 * @version 1.0
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
	 * Calcula a diferença em dias entre duas datas. A data final deve ser sempre maior que a data inicial, caso isso 
	 * não ocorra o resultado do cálculo será 0 (zero).
	 * 
	 * @param dataInicial - data inicial do intervalo.
	 * @param dataFinal - data final do intervalo.
	 * @return número de dias entre as datas.
	 */
	public static long calcularDiferencaEmDias(Date dataInicial, Date dataFinal) {
		
		long fator = 0;
	
		if (dataInicial != null && dataFinal != null) {
	
			DateUtils.truncate(dataInicial, Calendar.DATE);
			
			DateUtils.truncate(dataFinal, Calendar.DATE);
			
			if (!dataFinal.before(dataInicial)) {
	
				fator = ((dataFinal.getTime() - dataInicial.getTime()) / DateUtils.MILLIS_PER_DAY);
	
			}
		}
	
		return fator;
	}

}
