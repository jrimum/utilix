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
 * Created at: 04/04/2009 - 12:09:43
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
 * Criado em: 04/04/2009 - 12:09:43
 * 
 */
package br.com.nordestefomento.jrimum;

/**
 * 
 * <p>
 * Define que a classe que implementa esta interface é capaz de verificar as invariantes 
 * definidas no seu contrato.
 * </p>
 * 
 * <p>
 * A checagem dos dados deve ser no momento em que os dados são atribuídos.
 * </p>
 * 
 * @author Rômulo
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public interface Verifiable {

	/**
	 * <p>
	 * Verifica se os dados atribuídos seguem o contrato especificado pela classe.
	 * </p>
	 * 
	 * @throws IllegalArgumentException Caso alguma invariante seja violada.
	 * 
	 * @since
	 */
	public void verify() throws InvariantViolationException;
}
