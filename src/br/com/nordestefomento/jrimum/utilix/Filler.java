/*
 * Copyright 2007, JMatryx Group
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * <a href="http://www.apache.org/licenses/LICENSE-2.0">
 * http://www.apache.org/licenses/LICENSE-2.0 </a>
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Copyright 2007, Grupo JMatryx
 * 
 * Licenciado sob a licença da Apache, versão 2.0 (a “licença”); você não pode
 * usar este arquivo exceto na conformidade com a licença. Você pode obter uma
 * cópia da licença em
 * 
 * <a href="http://www.apache.org/licenses/LICENSE-2.0">
 * http://www.apache.org/licenses/LICENSE-2.0 </a>
 * 
 * A menos que seja requerido pela aplicação da lei ou esteja de acordo com a
 * escrita, o software distribuído sob esta licença é distribuído “COMO É”
 * BASE,SEM AS GARANTIAS OU às CONDIÇÕES DO TIPO, expresso ou implicado. Veja a
 * licença para as permissões sobre a línguagem específica e limitações quando
 * sob licença.
 * 
 * 
 * Created at / Criado em : 10/11/2007 - 22:47:22
 * 
 */
package br.com.nordestefomento.jrimum.utilix;

import org.apache.commons.lang.StringUtils;

import br.com.nordestefomento.jrimum.ACurbitaObject;

/**
 * Preenchedor de caracteres genérico. É utilizado para preencher objetos <code>String</code>,
 * tanto da esquerda para a direita como da direita para esquerda, com o objeto genérico até
 * o tamanho especificado. Caso o tamanho especificado seja <strong>menor</strong> 
 * ou <strong>igual</strong> a 0 (ZERO), este valor será desconsiderado e nada será preenchido.
 * <br/>
 * É utilizado o método <code>toString()</code> do objeto preenchedor.
 * <br/>
 * Exemplo:<br/>
 * <code>
 * Filler<Integer> filler = new Filler(new Integer(10), SideToFill.LEFT);<br/>
 * String outPut = filler.fill("TESTE", 8);
 * <br/><br/>
 * outPut -> "101TESTE"
 * </code>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since JMatryx 1.0
 * 
 * @version 1.0
 *
 */
public class Filler<G> extends ACurbitaObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3996934478582358340L;

	/**
	 * Filler padrão para preenchimento com zeros a esquerda.
	 */
	public static final Filler<Integer> ZERO_LEFT = new Filler<Integer>(0, SideToFill.LEFT);
	
	/**
	 * Filler padrão para preenchimento com zeros a direita.
	 */
	public static final Filler<Integer> ZERO_RIGHT = new Filler<Integer>(0, SideToFill.RIGHT);
	
	/**
	 * Filler padrão para preenchimento com zeros a esquerda.
	 */
	public static final Filler<Long> LONG_ZERO_LEFT = new Filler<Long>(0L, SideToFill.LEFT);
	
	/**
	 * Filler padrão para preenchimento com zeros a direita.
	 */
	public static final Filler<Long> LONG_ZERO_RIGHT = new Filler<Long>(0L, SideToFill.RIGHT);
	
	/**
	 * Filler padrão para preenchimento com zeros a esquerda.
	 */
	public static final Filler<Character> CHAR_ZERO_LEFT = new Filler<Character>('0', SideToFill.LEFT);
	
	/**
	 * Filler padrão para preenchimento com zeros a direita.
	 */
	public static final Filler<Character> CHAR_ZERO_RIGHT = new Filler<Character>('0', SideToFill.RIGHT);
	
	/**
	 * Filler padrão para preenchimento com zeros a esquerda.
	 */
	public static final Filler<String> STR_ZERO_LEFT = new Filler<String>("0", SideToFill.LEFT);
	
	/**
	 * Filler padrão para preenchimento com zeros a direita.
	 */
	public static final Filler<String> STR_ZERO_RIGHT = new Filler<String>("0", SideToFill.RIGHT);
	
	/**
	 * Filler padrão para preenchimento com espaços em branco a esquerda.
	 */
	public static final Filler<Character> CHAR_WHITE_SPACE_LEFT = new Filler<Character>(' ', SideToFill.LEFT);
	
	/**
	 * Filler padrão para preenchimento com espaços em branco a direita.
	 */
	public static final Filler<Character> CHAR_WHITE_SPACE_RIGHT = new Filler<Character>(' ', SideToFill.RIGHT);
	
	/**
	 * Filler padrão para preenchimento com espaços em branco a esquerda.
	 */
	public static final Filler<String> STR_WHITE_SPACE_LEFT = new Filler<String>(Operator4String.WHITE_SPACE, SideToFill.LEFT);
	
	/**
	 * Filler padrão para preenchimento com espaços em branco a direita.
	 */
	public static final Filler<String> STR_WHITE_SPACE_RIGHT = new Filler<String>(Operator4String.WHITE_SPACE, SideToFill.RIGHT);

	/**
	 * 
	 */
	private G toFill;
	
	/**
	 * 
	 */
	private SideToFill sideToFill;
	
	/**
	 * @param toFill
	 * @param sideToFill
	 */
	public Filler(G toFill, SideToFill sideToFill) {
		
		setToFill(toFill);
		setSideToFill(sideToFill);
	}
	
	public G getToFill() {
		return toFill;
	}

	/**
	 * @param filler
	 */
	public void setToFill(G toFill) {
		
		if(toFill != null)
			this.toFill = toFill;
		
		else
			throw new IllegalArgumentException("Invalid filler [ " + toFill + " ]!");
	}

	/**
	 * @return
	 */
	public SideToFill getSideToFill() {
		return sideToFill;
	}

	/**
	 * @param sideToFill
	 */
	public void setSideToFill(SideToFill sideToFill) {
		
		if(sideToFill != null)
			this.sideToFill = sideToFill;
		
		else
			throw new IllegalArgumentException("Invalid side [ " + sideToFill + " ]!");
	}
	
	/**
	 * Preenche o campo com o caracter especificado e no lado especificado.
	 * <br/>
	 * Por exemplo:
	 * <br/>
	 * Se <code>sideToFill == SideToFill.LEFT</code>, o caracter especificado será adicionado à String
	 * no lado esquerdo até que o campo fique com o tamanho que foi definido.
	 * 
	 * @param field
	 * @param length
	 * @return
	 */
	public String fill(String field, int length){
		
		String str = null;
		
		switch(sideToFill){
		
			case LEFT:
				str = fillLeft(field, length);
				break;
				
			case RIGHT:
				str = fillRight(field, length);
				break;
		}
		
		return str;
	}
	
	/**
	 * @param field
	 * @param length
	 * @return
	 */
	private String fillRight(String field, int length) {
		
		return StringUtils.rightPad(field, length, toFill.toString());
	}

	/**
	 * @param field
	 * @param length
	 * @return
	 */
	private String fillLeft(String field, int length) {
		
		return StringUtils.leftPad(field, length, toFill.toString());
	}

	/**
	 * 
	 *
	 */
	public enum SideToFill{
		
		LEFT,
		RIGHT;
	}

}
