package org.jrimum.utilix;

/**
 * <p>
 * Locales não disponíveis em <code>java.util.Locale</code>.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 */
public final class Locale {

	/**
	 * <p>
	 * Localização pt-BR.
	 * </p>
	 */
	public static final java.util.Locale BRASIL = new java.util.Locale("pt", "BR");

	/**
	 * <p>
	 * Utility class pattern: classe não instanciável
	 * </p>
	 */
	private Locale() {

		throw new AssertionError("INSTANCIA��O NÃO PERMITIDA!");
	}
}
