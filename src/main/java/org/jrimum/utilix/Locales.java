package org.jrimum.utilix;

/**
 * <p>
 * Locales não disponíveis em <code>java.util.Locale</code>.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public final class Locales {

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
	 * 
	 * @throws AssertionError caso haja alguma tentativa de utilização deste construtor.
	 */
	private Locales() {

		throw new AssertionError("NOT SUPORTED OPERATION!");
	}
}
