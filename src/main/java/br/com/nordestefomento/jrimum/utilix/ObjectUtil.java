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
 * Created at: 30/03/2008 - 18:02:40
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
 * Criado em: 30/03/2008 - 18:02:40
 * 
 */

package br.com.nordestefomento.jrimum.utilix;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;

/**
 * <p>
 * Classe utilitária para validações de objetos em geral, como verificações
 * de objetos nulos, coleções/arrays vazios.
 * </p>
 * <p>
 * Fornece métodos booleanos e métodos que verificam se o valor do objeto está de acordo
 * com o desejado e, caso não estejam, lançam exceção.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * @author Rômulo Augusto
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class ObjectUtil implements Serializable {

	private static final long serialVersionUID = -6790981191128287923L;

	private static Logger log = Logger.getLogger(ObjectUtil.class);

	/**
	 * Construtor privado para previnir a instanciação.
	 * 
	 * @throws AssertionError caso haja alguma tentativa de utilização deste construtor.
	 */
	private ObjectUtil() {
		throw new AssertionError();
	}
	
	/**
	 * <p>
	 * Verifica a referência ao objeto e lança uma exceção para casos onde a
	 * referência é nula incluíndo na mensagem de exceção o nome do parâmetro
	 * passado.
	 * </p>
	 * 
	 * @param object
	 * @param name
	 * 
	 * @return (object == null ? true : false)
	 * 
	 * @throws IllegalArgumentException
	 * 
	 * @see #isNotNull(Object, String)
	 * 
	 * @since 0.2
	 */
	@Deprecated
	public static boolean isNull(Object object, String name) throws IllegalArgumentException {

		boolean is = true;

		if (object != null) {
			is = false;

		} else {

			IllegalArgumentException e = new IllegalArgumentException(
					(name != null ? name : "Objeto ") + " inválido : ["
							+ object + "]!");

			log.error(StringUtils.EMPTY, e);

			throw e;
		}

		return is;
	}

	/**
	 * <p>
	 * Verifica a referência ao objeto e lança uma exceção para casos onde a
	 * referência é nula incluíndo na mensagem de exceção o nome do parâmetro
	 * passado.
	 * </p>
	 * 
	 * <p>
	 * É o mesmo que usar <code>!isNull(obj1,"obj1")</code> a diferença é que
	 * utiliza-se um símbolo <code>!</code> a menos.
	 * </p>
	 * 
	 * @param object
	 * @param name
	 * 
	 * @return (object != null ? true : false)
	 * 
	 * @throws IllegalArgumentException
	 * 
	 * @see #isNull(Object, String)
	 * 
	 * @since 0.2
	 */
	@Deprecated
	public static boolean isNotNull(Object object, String name) throws IllegalArgumentException {
		return !isNull(object, name);
	}

	/**
	 * <p>
	 * Verifica se o objeto passado por parâmetro é <code>null</code>.
	 * </p>
	 * 
	 * @param object - Objeto analisado
	 * 
	 * @return (object == null ? true : false)
	 * 
	 * @since 0.2
	 */
	public static boolean isNull(Object object) {
		return (object == null);
	}

	/**
	 * <p>
	 * Verifica se o objeto passado por parâmetro <strong>não</strong> é <code>null</code>. 
	 * </p>
	 * <p>
	 * É o mesmo que usar o método <code>isNull</code> da forma <code>!isNull(obj)</code>, porém
	 * de forma mais legível.
	 * </p>
	 * 
	 * @param object - Objeto analisado
	 * 
	 * @return (object != null ? true : false)
	 * 
	 * @see #isNull(Object)
	 * 
	 * @since 0.2
	 */
	public static boolean isNotNull(Object object) {
		return !isNull(object);
	}

	/**
	 * <p>
	 * Verifica se existe uma referência ao objeto dado.
	 * </p>
	 * 
	 * @param object - Objeto analisado
	 * 
	 * @return (object != null ? true : false)
	 * 
	 * @see #isNotNull(Object)
	 * 
	 * @since 0.2
	 */
	public static boolean exists(Object object) {
		return isNotNull(object);
	}
	
	/**
	 * <p>
	 * Verifica se o <code>Map</code> passado por parâmetro é <code>null</code> ou 
	 * <strong>não</strong> possui elementos. 
	 * </p>
	 * 
	 * @param map - Instância de <code>Map</code> analisado
	 * @return (map == null || map.size() == 0 ? true : false)
	 * 
	 * @since 0.2
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return isNull(map) || map.size() == 0;
	}
	
	/**
	 * <p>
	 * Verifica se o <code>Map</code> passado por parâmetro <strong>não</strong> é <code>null</code> 
	 * e possui elementos. 
	 * </p>
	 * 
	 * @param map - Instância de <code>Map</code> analisado
	 * @return (map != null && map.size() > 0 ? true : false)
	 * 
	 * @see #isEmpty(Map)
	 * 
	 * @since 0.2
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}
	
	/**
	 * <p>
	 * Verifica se a <code>Collection</code> passada por parâmetro é <code>null</code> ou 
	 * <strong>não</strong> possui elementos. 
	 * </p>
	 * 
	 * @param collection - Instância de <code>Collection</code> analisado
	 * @return (collection == null || collection.size() == 0 ? true : false)
	 * 
	 * @since 0.2
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return isNull(collection) || collection.size() == 0;
	}
	
	/**
	 * <p>
	 * Verifica se a <code>Collection</code> passada por parâmetro <strong>não</strong> é <code>null</code> 
	 * e possui elementos. 
	 * </p>
	 * 
	 * @param collection - Instância de <code>Map</code> analisado.
	 * @return (collection != null && collection.size() > 0 ? true : false)
	 * 
	 * @see #isEmpty(Collection)
	 * 
	 * @since 0.2
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return !isEmpty(collection);
	}
	
	/**
	 * <p>
	 * Verifica se o objeto é nulo e lança <code>IllegalArgumentException</code>, com a mensagem 
	 * informada, caso <strong>não</strong> seja.
	 * </p>
	 * 
	 * @thows IllegalArgumentException - Caso o objeto <strong>não</strong> seja <code>null</code>.
	 * 
	 * @see #isNull(Object)
	 * @see #isNotNull(Object)
	 * 
	 * @since 0.2
	 * 
	 * @param object - Objeto analisado
	 * @param message - Mensagem utilizada na exceção
	 */
	public static void checkNull(Object object, String message) {
		
		if (isNotNull(object)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * <p>
	 * Verifica se o objeto é nulo e lança <code>IllegalArgumentException</code> caso 
	 * <strong>não</strong> seja.
	 * </p>
	 * 
	 * @param object - Objeto analisado
	 * 
	 * @thows IllegalArgumentException - Caso o objeto <strong>não</strong> seja <code>null</code>.
	 * 
	 * @see #checkNull(Object, String)
	 * @see #isNull(Object)
	 * @see #isNotNull(Object)
	 * 
	 * @since 0.2
	 */
	public static void checkNull(Object object) {
		checkNull(object, "Objeto não nulo. Valor [" + object + "]");
	}
	
	/**
	 * <p>
	 * Verifica se o objeto <strong>não</strong> é nulo e lança <code>NullPointerException</code>, com
	 * a mensagem informada, caso seja.
	 * </p>
	 * 
	 * @param object - Objeto analisado
	 * @param message - Mensagem utilizada na exceção
	 * 
	 * @thows NullPointerException - Caso o objeto seja <code>null</code>.
	 * 
	 * @see #isNull(Object)
	 * @see #isNotNull(Object)
	 * 
	 * @since 0.2
	 */
	public static void checkNotNull(Object object, String message) {
		
		if (isNull(object)) {
			throw new NullPointerException(message);
		}
	}
	
	/**
	 * <p>
	 * Verifica se o objeto <strong>não</strong> é nulo e lança <code>NullPointerException</code> 
	 * caso seja.
	 * </p>
	 * 
	 * @param object - Objeto analisado
	 * 
	 * @thows NullPointerException - Caso o objeto seja <code>null</code>.
	 * 
	 * @see #checkNotNull(Object, String)
	 * @see #isNull(Object)
	 * @see #isNotNull(Object)
	 * 
	 * @since 0.2
	 */
	public static void checkNotNull(Object object) {
		checkNotNull(object, "Objeto nulo");
	}
	
	/**
	 * <p>
	 * Verifica se o <code>Map</code> passado por parâmetro é <code>null</code> ou 
	 * <strong>não</strong> possui elementos e lança exceção, com a mensagem informada, 
	 * caso não preencha estes requisitos.
	 * </p>
	 * 
	 * @param map - Instância de <code>Map</code> analisado
	 * @param message - Mensagem utilizada na exceção
	 * 
	 * @thows IllegalArgumentException - Caso o mapa <strong>não</strong> seja <code>null</code> e possua elementos.
	 * 
	 * @see #isEmpty(Map)
	 * @see #isNotEmpty(Map)
	 * 
	 * @since 0.2
	 */
	public static void checkEmpty(Map<?, ?> map, String message) {
		
		if (isNotEmpty(map)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * <p>
	 * Verifica se o <code>Map</code> passado por parâmetro é <code>null</code> ou 
	 * <strong>não</strong> possui elementos e lança exceção caso não preencha estes requisitos.
	 * </p>
	 * 
	 * @param map - Instância de <code>Map</code> analisado
	 * 
	 * @thows IllegalArgumentException - Caso o mapa <strong>não</strong> seja <code>null</code> e possua elementos.
	 * 
	 * @see #checkEmpty(Map, String)
	 * @see #isEmpty(Map)
	 * @see #isNotEmpty(Map)
	 * 
	 * @since 0.2
	 */
	public static void checkEmpty(Map<?, ?> map) {
		checkEmpty(map, "Map não nulo e com elementos. Valor [" + map + "]");
	}
	
	/**
	 * <p>
	 * Verifica se o <code>Map</code> passado por parâmetro <strong>não</strong> é <code>null</code> e 
	 * possui elementos e lança exceção, com a mensagem informada, caso não preencha estes requisitos.
	 * </p>
	 * 
	 * @param map - Instância de <code>Map</code> analisado
	 * @param message - Mensagem utiliada na exceção
	 * 
	 * @throws NullPointerException - Caso o mapa seja <code>null</code>.
	 * @thows IllegalArgumentException - Caso o mapa <strong>não</strong> possua elementos.
	 * 
	 * @see #isEmpty(Map)
	 * @see #isNotEmpty(Map)
	 * 
	 * @since 0.2
	 */
	public static void checkNotEmpty(Map<?, ?> map, String message) {
		checkNotEmpty(map, message, message);
	}
	
	/**
	 * <p>
	 * Verifica se o <code>Map</code> passado por parâmetro <strong>não</strong> é <code>null</code> e 
	 * possui elementos e lança exceção caso não preencha estes requisitos.
	 * </p>
	 * 
	 * @param map - Instância de <code>Map</code> analisado
	 * 
	 * @throws NullPointerException - Caso o mapa seja <code>null</code>.
	 * @thows IllegalArgumentException - Caso o mapa <strong>não</strong> possua elementos.
	 * 
	 * @see #checkNotEmpty(Map, String)
	 * @see #isEmpty(Map)
	 * @see #isNotEmpty(Map)
	 * 
	 * @since 0.2
	 */
	public static void checkNotEmpty(Map<?, ?> map) {
		checkNotEmpty(map, "Objeto nulo", "Map sem elementos");
	}
	
	/**
	 * <p>
	 * Método privado para fins de reutilização de código.
	 * </p>
	 * <p>
	 * Verifica se o <code>Map</code> passado por parâmetro <strong>não</strong> é <code>null</code> e 
	 * possui elementos e lança exceção caso não preencha estes requisitos.
	 * </p>
	 * <p>
	 * Caso o objeto seja <code>null</code>, lança <code>NullPointerException</code> com a mensagem informada no
	 * parâmetro <code>messageNullPointer</code> (primeiro parâmetro String). Caso o objeto não seja 
	 * <code>null</code> e não possua elementos, lança <code>IllegalArgumentException</code> com a mensagem 
	 * informada no parâmetro <code>messageIllegalArgument</code> (segundo parâmetro String).
	 * </p>
	 * 
	 * @param map - Instância de <code>Map</code> analisado
	 * @param messageNullPointer - Mensagem utiliada na exceção <code>NullPointerException</code>
	 * @param messageIllegalArgument - Mensagem utiliada na exceção <code>IllegalArgumentException</code>
	 */
	private static void checkNotEmpty(Map<?, ?> map, String messageNullPointer, String messageIllegalArgument) {
		
		if (isNull(map)) {
			throw new NullPointerException(messageNullPointer);
		}
		
		if (isEmpty(map)) {
			throw new IllegalArgumentException(messageIllegalArgument);
		}
	}

	/**
	 * Exibe os valores de instância para um objeto JRimum.
	 * 
	 * @see org.apache.commons.lang.builder.ToStringBuilder#reflectionToString
	 * 
	 * @since 0.2
	 * 
	 * @see java.lang.Object#toString()
	 */
	public static String toString(Object obj) {
		return "JRimumObject: " + ToStringBuilder.reflectionToString(obj);
	}
}
