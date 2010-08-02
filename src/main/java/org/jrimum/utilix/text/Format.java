package org.jrimum.utilix.text;

/**
 * <p>
 * Interface usada para objetos formatadores utilizados em leitura e escrita de
 * textos.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public interface Format<T, F extends java.text.Format> {

	/**
	 * <p>
	 * Formata um dado objeto para uma representação em string.
	 * </p>
	 * 
	 * @param obj
	 *            - Objeto a ser formatado.
	 * @return string - String formatada.
	 */
	String format(T obj);

	/**
	 * <p>
	 * Transforma uma string formatada em um objeto correspondente.
	 * </p>
	 * 
	 * @param text
	 *            - Texto a ser analisado e transformado em objeto.
	 * @return objeto - Resultado da transformação da string.
	 */
	T parse(String text);

	/**
	 * <p>
	 * Devolve uma cópia do formatador utilizado pela instância.
	 * </p>
	 * 
	 * @return formatador - Cópia da instância do formatador.
	 */
	F copy();
}
