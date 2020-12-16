/*
 * Copyright 2010 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * Created at: 01/08/2010 - 17:31:00
 * 
 * ================================================================================
 * 
 * Direitos autorais 2010 JRimum Project
 * 
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode usar
 * esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que
 * haja exigência legal ou acordo por escrito, a distribuição de software sob
 * esta LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER
 * TIPO, sejam expressas ou tácitas. Veja a LICENÇA para a redação específica a
 * reger permissões e limitações sob esta LICENÇA.
 * 
 * Criado em: 01/08/2010 - 17:31:00
 * 
 */

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
