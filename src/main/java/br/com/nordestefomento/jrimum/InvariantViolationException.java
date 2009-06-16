/* 
 * Copyright 2008 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Created at: 04/04/2009 - 13:52:07
 *
 * ================================================================================
 *
 * Direitos autorais 2008 JRimum Project
 *
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode 
 * usar esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma 
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que 
 * haja exigência legal ou acordo por escrito, a distribuição de software sob esta 
 * LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER TIPO, sejam 
 * expressas ou tácitas. Veja a LICENÇA para a redação específica a reger permissões 
 * e limitações sob esta LICENÇA.
 * 
 * Criado em: 04/04/2009 - 13:52:07
 * 
 */
package br.com.nordestefomento.jrimum;

/**
 * 
 * <p>
 * Exceção disparada quando ocorre violação de uma invariante de uma classe
 * </p>
 * 
 * @author Rômulo
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class InvariantViolationException extends RuntimeException {

	private static final long serialVersionUID = -5336301254028015531L;
	
	/**
	 * 
	 * @see java.lang.RuntimeException#RuntimeException()
	 * 
	 * @since 0.2
	 */
	public InvariantViolationException() {
		super();
		// Nothing to do.
	}

	/**
	 * @param message
	 * @param cause
	 * 
	 * @see java.lang.RuntimeException#RuntimeException(String, Throwable)
	 * 
	 * @since 0.2
	 */
	public InvariantViolationException(String message, Throwable cause) {
		super(message, cause);
		// Nothing to do.
	}

	/**
	 * @param message
	 * 
	 * @see java.lang.RuntimeException#RuntimeException(String)
	 * 
	 * @since 0.2
	 */
	public InvariantViolationException(String message) {
		super(message);
		// Nothing to do.
	}

	/**
	 * @param cause
	 * 
	 * @see java.lang.RuntimeException#RuntimeException(Throwable)
	 * 
	 * @since 0.2
	 */
	public InvariantViolationException(Throwable cause) {
		super(cause);
		// Nothing to do.
	}
}
