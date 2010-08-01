package org.jrimum.utilix;

/**
 * <p>
 * Classe utilitária para validações de arrays em geral.
 * </p>
 * 
 * <p>
 * Inicialmente fornece métodos booleanos para verificação da existência de elementos.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public final class Arrays {
	
	/**
	 * Utility class pattern: classe não instanciável
	 * 
	 * @throws AssertionError caso haja alguma tentativa de utilização deste construtor.
	 */
	private Arrays() {
		
		throw new AssertionError("NOT SUPORTED OPERATION!");
	}

	/**
	 * <p>
	 * Indica se um dado array de chars tem elementos sem gerar NPE.
	 * </p>
	 * <p>
	 * Resposta direata para o seguinte código:
	 * <code>(a != null && a > 0)</code>.
	 * </p>
	 * 
	 * @param a
	 *            - O array a ser testado.
	 * 
	 * @return (a != null && a > 0)
	 * 
	 * @since 0.2
	 */
	public static boolean hasElement(char[] a){
		
		return (a != null && a.length > 0);
	}
	
	/**
	 * <p>
	 * Indica se um dado array de booleans tem elementos sem gerar NPE.
	 * </p>
	 * <p>
	 * Resposta direata para o seguinte código:
	 * <code>(a != null && a > 0)</code>.
	 * </p>
	 * 
	 * @param a
	 *            - O array a ser testado.
	 * 
	 * @return (a != null && a > 0)
	 * 
	 * @since 0.2
	 */
	public static boolean hasElement(boolean[] a){
		
		return (a != null && a.length > 0);
	}
	
	/**
	 * <p>
	 * Indica se um dado array de bytes tem elementos sem gerar NPE.
	 * </p>
	 * <p>
	 * Resposta direata para o seguinte código:
	 * <code>(a != null && a > 0)</code>.
	 * </p>
	 * 
	 * @param a
	 *            - O array a ser testado.
	 * 
	 * @return (a != null && a > 0)
	 * 
	 * @since 0.2
	 */
	public static boolean hasElement(byte[] a){
		
		return (a != null && a.length > 0);
	}
	
	/**
	 * <p>
	 * Indica se um dado array de shorts tem elementos sem gerar NPE.
	 * </p>
	 * <p>
	 * Resposta direata para o seguinte código:
	 * <code>(a != null && a > 0)</code>.
	 * </p>
	 * 
	 * @param a
	 *            - O array a ser testado.
	 * 
	 * @return (a != null && a > 0)
	 * 
	 * @since 0.2
	 */
	public static boolean hasElement(short[] a){
		
		return (a != null && a.length > 0);
	}
	
	/**
	 * <p>
	 * Indica se um dado array de ints tem elementos sem gerar NPE.
	 * </p>
	 * <p>
	 * Resposta direata para o seguinte código:
	 * <code>(a != null && a > 0)</code>.
	 * </p>
	 * 
	 * @param a
	 *            - O array a ser testado.
	 * 
	 * @return (a != null && a > 0)
	 * 
	 * @since 0.2
	 */
	public static boolean hasElement(int[] a){
		
		return (a != null && a.length > 0);
	}
	
	/**
	 * <p>
	 * Indica se um dado array de longs tem elementos sem gerar NPE.
	 * </p>
	 * <p>
	 * Resposta direata para o seguinte código:
	 * <code>(a != null && a > 0)</code>.
	 * </p>
	 * 
	 * @param a
	 *            - O array a ser testado.
	 * 
	 * @return (a != null && a > 0)
	 * 
	 * @since 0.2
	 */
	public static boolean hasElement(long[] a){
		
		return (a != null && a.length > 0);
	}
	
	/**
	 * <p>
	 * Indica se um dado array de floats tem elementos sem gerar NPE.
	 * </p>
	 * <p>
	 * Resposta direata para o seguinte código:
	 * <code>(a != null && a > 0)</code>.
	 * </p>
	 * 
	 * @param a
	 *            - O array a ser testado.
	 * 
	 * @return (a != null && a > 0)
	 * 
	 * @since 0.2
	 */
	public static boolean hasElement(float[] a){
		
		return (a != null && a.length > 0);
	}
	
	/**
	 * <p>
	 * Indica se um dado array de doubles tem elementos sem gerar NPE.
	 * </p>
	 * <p>
	 * Resposta direata para o seguinte código:
	 * <code>(a != null && a > 0)</code>.
	 * </p>
	 * 
	 * @param a
	 *            - O array a ser testado.
	 * 
	 * @return (a != null && a > 0)
	 * 
	 * @since 0.2
	 */
	public static boolean hasElement(double[] a){
		
		return (a != null && a.length > 0);
	}
	
	/**
	 * <p>
	 * Indica se um dado array de objetos tem elementos sem gerar NPE.
	 * </p>
	 * <p>
	 * Resposta direata para o seguinte código:
	 * <code>(a != null && a > 0)</code>.
	 * </p>
	 * 
	 * @param a
	 *            - O array a ser testado.
	 * 
	 * @return (a != null && a > 0)
	 * 
	 * @since 0.2
	 */
	public static boolean hasElement(Object[] a) {

		return (a != null && a.length > 0);
	}
}
