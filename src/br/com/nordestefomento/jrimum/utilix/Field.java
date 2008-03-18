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
 * Created at / Criado em : 10/11/2007 - 22:48:16
 * 
 */
package br.com.nordestefomento.jrimum.utilix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import br.com.nordestefomento.jrimum.ACurbitaObject;


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
 * @since JMatryx 1.0
 * 
 * @version 1.0
 */
public class Field <G> extends ACurbitaObject implements ITextStream{
	
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
	private G field;
	
	/**
	 * Formatador utilizado na leitura e na escrita do field. <br/> - Na leitura para realizar o <code>parse</code> da String.<br/> - Na escrita para transformar o objeto em uma String e assim ser possível tratá-la para ser escrita.
	 * 
	 */
	private Format format;
	
	/**
	 * Preenchedor do field utilizado na hora da escrita.
	 */
	private Filler<?> filler;
	
	/**
	 * Cria um <code>Field</code> sem um formatador. Isto significa que a leitura da String 
	 * pelo objeto criado será como uma atribuição simples. 
	 * @param field
	 * @param length Tamanho que o field deve possuir.
	 */
	public Field(G field, Integer length){
		
		setField(field);
		setLength(length);
	}
	
	/**
	 * Cria um <code>Field</code> com um formatador. Isto significa que a leitura da String pelo
	 * objeto criado será de acordo com o formatador.
	 * @param field
	 * @param length
	 * @param format Formatador que irá formatar a String fornecida na leitura para o field 
	 * especificado.
	 */
	public Field(G field, Integer length, Format format){
		
		setLength(length);
		setField(field);
		setFormat(format);
	}
	
	/**
	 * Cria um <code>Field</code> com um preenchedor. Este preenchedor é utilizado na escrita do 
	 * <code>Field</code> quado é necessário preencher com caracteres especificados até o length definido. 
	 * 
	 * @param field
	 * @param length
	 * @param filler
	 */
	public Field(G field, Integer length, Filler<?> filler){
		
		setLength(length);
		setField(field);
		setFiller(filler);
	}
	
	/**
	 * Cria um <code>Field</code> com um formatador e com um preenchedor. 
	 * 
	 * @param field
	 * @param length
	 * @param format
	 * @param filler
	 */
	public Field(G field, Integer length, Format format, Filler<?> filler){
		
		setLength(length);
		setField(field);
		setFormat(format);
		setFiller(filler);
	}
	

	/**
	 * Converte a String fornecida para o field representado pelo objeto.
	 * <br />
	 * A conversão é realizada a partir do formatador fornecido para o objeto. Se não houver 
	 * formatador a String fornecida será atribuída como o valor do field.
	 * 
	 * @param value
	 */
	public void read(String value){
		
		if(value == null)
			throw new IllegalArgumentException("Invalid string [ " + value + " ]!");
		
		if(value.length() != length)
			throw new IllegalArgumentException("String length [ " + value + " ] incompatible with specified [ "+length+" ]!");
		
		if(field instanceof ITextStream){
			ITextStream reader = (ITextStream) field;
			reader.read(value);
		}else if(field instanceof BigDecimal){
		
			readDecimalField(value);
		}else if(field instanceof Date) {
			
			readDateField(value);
		}else {
			
			readStringOrNumericField(value);
		}
	}

	@SuppressWarnings("unchecked")
	private void readStringOrNumericField(String value) {
		
		Class<?> c = field.getClass();

		for (Constructor<?> cons : c.getConstructors()) {

			if (cons.getParameterTypes().length == 1){
				if (cons.getParameterTypes()[0].equals(String.class)){
					try {
						
						field = (G) cons.newInstance(value);

					} catch (IllegalArgumentException e) {
						errorG(e, value).printStackTrace();
					} catch (InstantiationException e) {
						errorG(e, value).printStackTrace();
					} catch (IllegalAccessException e) {
						errorG(e, value).printStackTrace();
					} catch (InvocationTargetException e) {
						errorG(e, value).printStackTrace();
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void readDateField(String value){
		
		try {
			
			field = (G) format.parseObject(value);
		} 
		catch (ParseException e) {
			
			errorG(e, value);
		}
	}

	@SuppressWarnings("unchecked")
	private void readDecimalField(String value){
		
		DecimalFormat decimalFormat = (DecimalFormat) format;
		
		try {
			
			Long parsedValue = (Long) format.parseObject(value);
			BigDecimal decimalValue = new BigDecimal(parsedValue.longValue());
			decimalValue = decimalValue.movePointLeft(decimalFormat.getMaximumFractionDigits());
							
			field = (G) decimalValue;
			
		} 
		catch (ParseException e) {
			
			errorG(e, value);
		}
	}
	
	public String write(){
		
		String str = null;

		if (field instanceof ITextStream) {

			ITextStream its = (ITextStream) field;

			str = its.write();

		} else if (field instanceof Date) {

			Date campoDate = (Date) field;

			if (campoDate.compareTo(Operator4Date.DATE_NULL) == 0)
				str = StringUtils.EMPTY;

			else
				str = format.format(field);
		}

		else if (field instanceof BigDecimal)
			str = StringUtils.replaceChars(field.toString(), ".", "");

		else
			str = field.toString();

		str = fill(str);

		if (str.length() != length)
			throw new IllegalArgumentException("Field [ " + str
					+ " ] incompatible with specified [" + length + "]!");
		
		return Operator4String.eliminateAccent(str).toUpperCase();
	}

	private String fill(String str) {
		
		if(filler != null)
			str = filler.fill(str, length);
		
		return str;
	}

	public G getField() {
		return field;
	}

	
	public void setField(G field) {
	
		if (field != null)
			this.field = field;
		else
			throw new IllegalArgumentException("Invalid Field [" + field + "]!");
	
	}

	
	public Integer getLength() {
		return length;
	}

	
	public void setLength(Integer length) {
	
		if (length > 0)
			this.length = length;
		else
			throw new IllegalArgumentException("Invalid Length [ " + length + " ]!");
	
	}
	
	
	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		
		if (format != null)
			this.format = format;
		else
			throw new IllegalArgumentException("Invalid Format [ " + format + " ]!");
	}
	
	public Filler<?> getFiller() {
		return filler;
	}

	public void setFiller(Filler<?> filler) {
		
		if(filler != null)
			this.filler = filler;
		
		else
			throw new IllegalArgumentException("Invalid Filler [ " + filler + " ]!");
	}
	
	private static Exception errorG(Exception e, String value){		
		
		StackTraceElement[] stackTrace = e.getStackTrace();
		e = new RuntimeException("Problems between instace and value: [ " + value + " ]!\nCaused by: "+e.getCause());
		e.setStackTrace(stackTrace);
		
		return e;
	}
}



