package org.jrimum.utilix.text;

import java.util.Currency;

import org.jrimum.utilix.Locales;

/**
 * <p>
 * DecimalFormatSymbols com localização (Processo de localização) inicialmente
 * do Brasil.
 * </p>
 * 
 * @author <a href=http://gilmatryx.googlepages.com/>Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public enum DecimalFormatSymbols {

	/**
	 * DecimalFormatSymbols relacionados aos padrões pt-BR.
	 */
	BRASIL;

	private final ThreadLocal<java.text.DecimalFormatSymbols> DF_SYMBOLS;

	private DecimalFormatSymbols() {

		DF_SYMBOLS = new ThreadLocal<java.text.DecimalFormatSymbols>() {

			protected java.text.DecimalFormatSymbols initialValue() {

				java.text.DecimalFormatSymbols dfSymbols = new java.text.DecimalFormatSymbols(
						Locales.BRASIL);

				dfSymbols.setZeroDigit('0');
				dfSymbols.setDecimalSeparator(',');
				dfSymbols.setMonetaryDecimalSeparator(',');
				dfSymbols.setDigit('#');
				dfSymbols.setGroupingSeparator('.');
				dfSymbols.setCurrency(Currency.getInstance(Locales.BRASIL));

				return dfSymbols;
			}

		};
	}

	/**
	 * <p>
	 * Cópia de símbolos utilizados em <code>BRASIL</code>.
	 * </p>
	 * 
	 * @return símbolos - Instância de
	 *         <code>java.text.DecimalFormatSymbols</code> estilo pt-BR
	 * 
	 * @since 0.2
	 */
	public java.text.DecimalFormatSymbols copy() {

		return (java.text.DecimalFormatSymbols) DF_SYMBOLS.get().clone();
	}
}
