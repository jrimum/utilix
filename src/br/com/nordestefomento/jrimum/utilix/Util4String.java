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
 * Created at / Criado em : 17/03/2007 - 17:36:04
 * 
 */

package br.com.nordestefomento.jrimum.utilix;

import org.apache.commons.lang.StringUtils;

import br.com.nordestefomento.jrimum.ACurbitaObject;

/**
 * 
 * Esta classe tem a responsábilidade de prover serviços utilitários
 * relacionados a manipulação de <code>Strings</code>
 * 
 * 
 * @author Gabriel Guimarães
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto 
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since JMatryx 1.0
 * 
 * @version 1.0
 */
public class Util4String extends ACurbitaObject{

	public static final String WHITE_SPACE = " ";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7425529940068032055L;

	/**
	 * Retorna uma String preenchendo-a de acordo com o objeto Filler passado
	 * até que se atinja o tamanho especificado.
	 * 
	 * @param str String a ser preenchida
	 * @param filler Objeto Filler para preencher a String
	 * @param tamanho Tamanho máximo que a String conterá.
	 * @return String preenchida de acordo com o objeto Filler com tamanho igual ao tamanho especificado.
	 */
	public static String complete_x(String str, Filler<?> filler, int tamanho) {
		
		return complete(str, filler, tamanho);
	}

	
	/**
	 * Retorna uma String preenchendo-a de acordo com o objeto Filler passado
	 * até que se atinja o tamanho especificado.
	 * 
	 * @param n
	 * @param preenchedor
	 * @param tamanho
	 * @return stringFull
	 */
	public static String complete_x(int n, Filler<?> filler, int tamanho) {
		
		return complete(n, filler, tamanho);
	}
	
	/**
	 * Retorna uma String preenchendo-a de acordo com o objeto Filler passado
	 * até que se atinja o tamanho especificado.
	 * 
	 * @param n 
	 * @param preenchedor
	 * @param tamanho
	 * @return stringFull
	 */
	public static String complete_x(long n, Filler<?> filler, int tamanho) {
		
		return complete(n, filler, tamanho);
	}
	//TODO mudar o nome do metodo (ele não apenas completa uma string, também muda a informação)
	/**
	 * Usado para quantidades monetárias R$, retorna uma String preenchendo-a da esquerda para direita com o caracter
	 * preenchedor passado até que se atinja o tamanho especificado transformando o numero em um long.
	 * 
	 * ex: 14.0451 ==> "1404"
	 * 
	 * @param n
	 * @param preenchedor
	 * @param tamanho
	 * @return stringFull
	 */
	public static String complete_x(double n, Filler<?> filler, int tamanho) {
		
		long semFlutuacao = (long) (n * 100);
		
		return complete(semFlutuacao, filler, tamanho);
	}
	
	private static String complete(Object object, Filler<?> filler, int length) {
		
		String str = StringUtils.EMPTY;
		String toFill = StringUtils.EMPTY;
		
		if(object != null)
			toFill = object.toString();

		if(filler != null)
			str = filler.fill(toFill, length);
		
		return StringUtils.left(str, length);
	}
	
	/**
	 * Elimina simbolos como:
	 * ><,;.:!*&%+-_<>[]\/
	 * 
	 * @param str String com os símbolos a serem removidos.
	 * @return String sem símbolos.
	 */
	public static String eliminateSymbols(String str){
		
		if(str != null){
			
			str = StringUtils.replace(str,"-","");
			str = StringUtils.replace(str,"_","");
			str = StringUtils.replace(str,"=","");
			str = StringUtils.replace(str,"+","");
		    str = StringUtils.replace(str,"%","");
		    str = StringUtils.replace(str,"*","");
		    str = StringUtils.replace(str,"@","");
		    str = StringUtils.replace(str,"#","");
		    str = StringUtils.replace(str,"&","");
		    str = StringUtils.replace(str,":","");
		    str = StringUtils.replace(str,".","");
		    str = StringUtils.replace(str,";","");
		    str = StringUtils.replace(str,",","");
		    str = StringUtils.replace(str,"!","");
		    str = StringUtils.replace(str,"?","");
		    str = StringUtils.replace(str,"(","");
		    str = StringUtils.replace(str,")","");
		    str = StringUtils.replace(str,"{","");
		    str = StringUtils.replace(str,"}","");
		    str = StringUtils.replace(str,"[","");
		    str = StringUtils.replace(str,"]","");
		    str = StringUtils.replace(str,"/","");
		    str = StringUtils.replace(str,"\\","");
		    str = StringUtils.replace(str,">","");
		    str = StringUtils.replace(str,"<","");
		    str = StringUtils.replace(str,"\"","");
		    str = StringUtils.replace(str,"'","");
		    str = StringUtils.replace(str,"`","");
		}
			
		return str;
	}
	
	/**
	 * Remove a acentuação do texto, que inclui os acentos:
	 * <ul>
	 * <li>Agudo. ex.: á</li>
	 * <li>Grave. ex.: à</li>
	 * <li>Til. ex.: ã</li>
	 * <li>Trema. ex.: ä</li>
	 * <li>Circunflexo. ex.: â</li>
	 * </ul>
	 * 
	 * e o Cedilha (ç).
	 * <br />
	 * Os acentos são removidos tanto para letras minúsculas como para letras maiúsculas.
	 * 
	 * @param value String com os caracteres a serem removidos.
	 * @return String sem acentuação.
	 */
	public static String eliminateAccent(String value) {
		
		value = StringUtils.replaceChars(value, 'ç', 'c');
				
		value = StringUtils.replaceChars(value, 'á', 'a');
		value = StringUtils.replaceChars(value, 'â', 'a');
		value = StringUtils.replaceChars(value, 'à', 'a');
		value = StringUtils.replaceChars(value, 'ã', 'a');
		value = StringUtils.replaceChars(value, 'ä', 'a');
		
		value = StringUtils.replaceChars(value, 'é', 'e');
		value = StringUtils.replaceChars(value, 'ê', 'e');
		value = StringUtils.replaceChars(value, 'è', 'e');
		value = StringUtils.replaceChars(value, 'ë', 'e');
		
		value = StringUtils.replaceChars(value, 'í', 'i');
		value = StringUtils.replaceChars(value, 'î', 'i');
		value = StringUtils.replaceChars(value, 'ì', 'i');
		value = StringUtils.replaceChars(value, 'ï', 'i');
		
		value = StringUtils.replaceChars(value, 'ó', 'o');
		value = StringUtils.replaceChars(value, 'ô', 'o');
		value = StringUtils.replaceChars(value, 'ò', 'o');
		value = StringUtils.replaceChars(value, 'õ', 'o');
		value = StringUtils.replaceChars(value, 'ö', 'o');

		value = StringUtils.replaceChars(value, 'ú', 'u');
		value = StringUtils.replaceChars(value, 'û', 'u');
		value = StringUtils.replaceChars(value, 'ù', 'u');
		value = StringUtils.replaceChars(value, 'ü', 'u');
		
		value = StringUtils.replaceChars(value, 'Ç', 'C');
		
		value = StringUtils.replaceChars(value, 'Á', 'A');
		value = StringUtils.replaceChars(value, 'Â', 'A');
		value = StringUtils.replaceChars(value, 'À', 'A');
		value = StringUtils.replaceChars(value, 'Ã', 'A');
		value = StringUtils.replaceChars(value, 'Ä', 'A');
		
		value = StringUtils.replaceChars(value, 'É', 'E');
		value = StringUtils.replaceChars(value, 'Ê', 'E');
		value = StringUtils.replaceChars(value, 'È', 'E');
		value = StringUtils.replaceChars(value, 'Ë', 'E');
		
		value = StringUtils.replaceChars(value, 'Í', 'I');
		value = StringUtils.replaceChars(value, 'Î', 'I');
		value = StringUtils.replaceChars(value, 'Ì', 'I');
		value = StringUtils.replaceChars(value, 'Ï', 'I');
		
		value = StringUtils.replaceChars(value, 'Ó', 'O');
		value = StringUtils.replaceChars(value, 'Ô', 'O');
		value = StringUtils.replaceChars(value, 'Ò', 'O');
		value = StringUtils.replaceChars(value, 'Õ', 'O');
		value = StringUtils.replaceChars(value, 'Ö', 'O');

		value = StringUtils.replaceChars(value, 'Ú', 'U');
		value = StringUtils.replaceChars(value, 'Û', 'U');
		value = StringUtils.replaceChars(value, 'Ù', 'U');
		value = StringUtils.replaceChars(value, 'Ü', 'U');
		
		return value;
	}
}
