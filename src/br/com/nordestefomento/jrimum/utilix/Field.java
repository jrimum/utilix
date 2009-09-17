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
 * Created at: 30/03/2008 - 18:16:48
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
 * Criado em: 30/03/2008 - 18:16:48
 * 
 */

package br.com.nordestefomento.jrimum.utilix;

import static br.com.nordestefomento.jrimum.utilix.ObjectUtil.isNotNull;
import static br.com.nordestefomento.jrimum.utilix.ObjectUtil.isNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;


/**
 * 
 * Descrição:
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class Field <G> implements TextStream {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7432509456997808459L;

	/**
	 * 
	 */
	private Integer length;
	
	/**
	 * 
	 */
	private G value;
	
	/**
	 * Formatador utilizado na leitura e na escrita do value. <br/> - Na leitura para realizar o <code>parse</code> da String.<br/> - Na escrita para transformar o objeto em uma String e assim ser possível tratá-la para ser escrita.
	 * 
	 */
	private Format format;
	
	/**
	 * Preenchedor do value utilizado na hora da escrita.
	 */
	private Filler<?> filler;
	
	/**
	 * Cria um <code>Field</code> sem um formatador. Isto significa que a leitura da String 
	 * pelo objeto criado será como uma atribuição simples. 
	 * @param value Valor do campo
	 * @param length Tamanho que o value deve possuir.
	 */
	public Field(G value, Integer length){
		
		setValue(value);
		setLength(length);
	}
	
	/**
	 * Cria um <code>Field</code> com um formatador. Isto significa que a leitura da String pelo
	 * objeto criado será de acordo com o formatador.
	 * @param value Valor do campo
	 * @param length tamanho do campo
	 * @param format Formatador que irá formatar a String fornecida na leitura para o value 
	 * especificado.
	 */
	public Field(G value, Integer length, Format format){
		
		setLength(length);
		setValue(value);
		setFormat(format);
	}
	
	/**
	 * Cria um <code>Field</code> com um preenchedor. Este preenchedor é utilizado na escrita do 
	 * <code>Field</code> quado é necessário preencher com caracteres especificados até o length definido. 
	 * 
	 * @param value valor do campo
	 * @param length tamaho do campo
	 * @param filler preenchedor
	 */
	public Field(G value, Integer length, Filler<?> filler){
		
		setLength(length);
		setValue(value);
		setFiller(filler);
	}
	
	/**
	 * Cria um <code>Field</code> com um formatador e com um preenchedor. 
	 * 
	 * @param value Valor do campo
	 * @param length Tamanho do campo
	 * @param format Formatador que irá formatar a String fornecida na leitura para o value 
	 * especificado.
	 * @param filler preenchedor
	 */
	public Field(G value, Integer length, Format format, Filler<?> filler){
		
		setLength(length);
		setValue(value);
		setFormat(format);
		setFiller(filler);
	}
	

	/**
	 * Converte a String fornecida para o value representado pelo objeto.
	 * <br />
	 * A conversão é realizada a partir do formatador fornecido para o objeto. Se não houver 
	 * formatador a String fornecida será atribuída como o valor do value.
	 * 
	 * @param valueAsString valor do campo como uma String
	 */
	public void read(String valueAsString){
		
		if (isNull(valueAsString)) {
			throw new IllegalArgumentException("String inválida [ " + valueAsString + " ]!");
		}
		
		if (valueAsString.length() != length) {
			throw new IllegalArgumentException("O tamanho da String [ " + valueAsString + " ] é incompatível com o especificado [ "+length+" ]!");
		}
		
		if (value instanceof TextStream) {
			TextStream reader = (TextStream) value;
			reader.read(valueAsString);
			
		} else if (value instanceof BigDecimal) {
		
		 	readDecimalField(valueAsString);
		 	
		} else if (value instanceof Date) {
			
			readDateField(valueAsString);
			
		} else {
			
			readStringOrNumericField(valueAsString);
		}
	}

	@SuppressWarnings("unchecked")
	private void readStringOrNumericField(String valueAsString) {
		
		Class<?> c = value.getClass();

		for (Constructor<?> cons : c.getConstructors()) {

			if (cons.getParameterTypes().length == 1){
				if (cons.getParameterTypes()[0].equals(String.class)){
					try {
						
						value = (G) cons.newInstance(valueAsString);

					} catch (IllegalArgumentException e) {
						errorG(e, valueAsString).printStackTrace();
					} catch (InstantiationException e) {
						errorG(e, valueAsString).printStackTrace();
					} catch (IllegalAccessException e) {
						errorG(e, valueAsString).printStackTrace();
					} catch (InvocationTargetException e) {
						errorG(e, valueAsString).printStackTrace();
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void readDateField(String valueAsString){
		
		try {
			
			value = (G) format.parseObject(valueAsString);
		} 
		catch (ParseException e) {
			
			errorG(e, valueAsString);
		}
	}

	@SuppressWarnings("unchecked")
	private void readDecimalField(String valueAsString){
		
		DecimalFormat decimalFormat = (DecimalFormat) format;
		
		try {
			
			Long parsedValue = (Long) format.parseObject(valueAsString);
			BigDecimal decimalValue = new BigDecimal(parsedValue.longValue());
			decimalValue = decimalValue.movePointLeft(decimalFormat.getMaximumFractionDigits());
							
			value = (G) decimalValue;
			
		} 
		catch (ParseException e) {
			
			errorG(e, valueAsString);
		}
	}
	
	public String write(){
		
		String str = null;

		if (value instanceof TextStream) {

			TextStream its = (TextStream) value;

			str = its.write();

		} else if (value instanceof Date) {

			Date campoDate = (Date) value;

			if (campoDate.compareTo(DateUtil.DATE_NULL) == 0) {
				str = StringUtils.EMPTY;
				
			} else {
				str = format.format(value);
			}
			
		} else if (value instanceof BigDecimal) {
			str = StringUtils.replaceChars(value.toString(), ".", StringUtils.EMPTY);
			
		} else {
			str = value.toString();
		}

		str = fill(str);

		if (str.length() != length) {
			throw new IllegalArgumentException("O campo [ " + str
					+ " ] é incompatível com o especificado [" + length + "]!");
		}
		
		return StringUtil.eliminateAccent(str).toUpperCase();
	}

	private String fill(String str) {
		
		if(isNotNull(filler)) {
			str = filler.fill(str, length);
		}
		
		return str;
	}

	public G getValue() {
		return value;
	}

	
	public void setValue(G field) {
	
		if (isNotNull(field)) {
			this.value = field;
			
		} else {
			throw new IllegalArgumentException("Campo inválido [" + field + "]!");
		}
	
	}

	
	public Integer getLength() {
		return length;
	}

	
	public void setLength(Integer length) {
	
		if (length > 0) {
			this.length = length;
			
		} else {
			throw new IllegalArgumentException("Tamanho inválido [ " + length + " ]!");
		}
	
	}
	
	
	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		
		if (isNotNull(format)) {
			this.format = format;
			
		} else {
			throw new IllegalArgumentException("Formato inválido [ " + format + " ]!");
		}
	}
	
	public Filler<?> getFiller() {
		return filler;
	}

	public void setFiller(Filler<?> filler) {
		
		if(isNotNull(filler)) {
			this.filler = filler;
			
		} else {
			throw new IllegalArgumentException("Filler inválido [ " + filler + " ]!");
		}
	}
	
	private static Exception errorG(Exception e, String value){		
		
		StackTraceElement[] stackTrace = e.getStackTrace();
		e = new RuntimeException("Problemas entre instância e valor: [ " + value + " ]!\nCausado por: "+e.getCause());
		e.setStackTrace(stackTrace);
		
		return e;
	}
	
	@Override
	public String toString() {
		return ObjectUtil.toString(this);
	}
}