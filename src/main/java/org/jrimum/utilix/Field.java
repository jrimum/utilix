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

package org.jrimum.utilix;

import static org.jrimum.utilix.ObjectUtil.isNotNull;
import static org.jrimum.utilix.ObjectUtil.isNull;

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
 * <p>
 * Um campo de texto, número, data ou outro como <code>TextStream</code>.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @see TextStream
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class Field<G> implements TextStream {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7432509456997808459L;

	/**
	 * <p>
	 * Tamanho do campo como string.
	 * </p>
	 */
	private Integer length;

	/**
	 * <p>
	 * Valor do campo.
	 * </p>
	 */
	private G value;

	/**
	 * <p>
	 * Formatador utilizado na leitura e na escrita do value.
	 * </p>
	 * 
	 */
	private Format format;

	/**
	 * <p>
	 * Preenchedor do value utilizado na hora da escrita.
	 * </p>
	 */
	private Filler<?> filler;

	/**
	 * <p>
	 * Cria um <code>Field</code> sem um formatador. Isto significa que a
	 * leitura da String pelo objeto criado será como uma atribuição simples.
	 * </p>
	 * 
	 * @param value
	 *            Valor do campo
	 * @param length
	 *            Tamanho que o value deve possuir.
	 * @since 0.2
	 */
	public Field(G value, Integer length) {

		setValue(value);
		setLength(length);
	}

	/**
	 * <p>
	 * Cria um <code>Field</code> com um formatador. Isto significa que a
	 * leitura da String pelo objeto criado será de acordo com o formatador.
	 * </p>
	 * 
	 * @param value
	 *            Valor do campo
	 * @param length
	 *            tamanho do campo
	 * @param format
	 *            Formatador que irá formatar a String fornecida na leitura para
	 *            o value especificado.
	 * @since 0.2
	 */
	public Field(G value, Integer length, Format format) {

		setLength(length);
		setValue(value);
		setFormat(format);
	}

	/**
	 * <p>
	 * Cria um <code>Field</code> com um preenchedor. Este preenchedor é
	 * utilizado na escrita do <code>Field</code> quado é necessário preencher
	 * com caracteres especificados até o length definido.
	 * </p>
	 * 
	 * @param value
	 *            valor do campo
	 * @param length
	 *            tamaho do campo
	 * @param filler
	 *            preenchedor
	 * @since 0.2
	 */
	public Field(G value, Integer length, Filler<?> filler) {

		setLength(length);
		setValue(value);
		setFiller(filler);
	}

	/**
	 * <p>
	 * Cria um <code>Field</code> com um formatador e com um preenchedor.
	 * </p>
	 * 
	 * @param value
	 *            Valor do campo
	 * @param length
	 *            Tamanho do campo
	 * @param format
	 *            Formatador que irá formatar a String fornecida na leitura para
	 *            o value especificado.
	 * @param filler
	 *            preenchedor
	 * @since 0.2
	 */
	public Field(G value, Integer length, Format format, Filler<?> filler) {

		setLength(length);
		setValue(value);
		setFormat(format);
		setFiller(filler);
	}

	/**
	 * <p>
	 * Converte a String fornecida para o value representado pelo objeto.
	 * </p>
	 * <p>
	 * A conversão é realizada a partir do formatador fornecido para o objeto.
	 * Se não houver formatador a String fornecida será atribuída como o valor
	 * do value.
	 * </p>
	 * 
	 * @param valueAsString
	 *            valor do campo como uma String
	 * @since 0.2
	 */
	public void read(String valueAsString) {

		if (isNull(valueAsString)) {
			throw new IllegalArgumentException("String inválida [ "
					+ valueAsString + " ]!");
		}

		if (valueAsString.length() != length) {
			throw new IllegalArgumentException("O tamanho da String [ "
					+ valueAsString + " ] é incompatível com o especificado [ "
					+ length + " ]!");
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

	/**
	 * Lê campos texto (String) ou numéricos que pode ser obtidos a partir de uma String,
	 * usando, por exemplo, o construtor ou o método <code>valueOf</code>.
	 * 
	 * @param valueAsString
	 */
	@SuppressWarnings("unchecked")
	private void readStringOrNumericField(String valueAsString) {

		Class<?> c = value.getClass();

		for (Constructor<?> cons : c.getConstructors()) {

			if (cons.getParameterTypes().length == 1) {
				if (cons.getParameterTypes()[0].equals(String.class)) {
					try {

						value = (G) cons.newInstance(valueAsString);

					} catch (IllegalArgumentException e) {
						getGenericReadError(e, valueAsString).printStackTrace();
					} catch (InstantiationException e) {
						getGenericReadError(e, valueAsString).printStackTrace();
					} catch (IllegalAccessException e) {
						getGenericReadError(e, valueAsString).printStackTrace();
					} catch (InvocationTargetException e) {
						getGenericReadError(e, valueAsString).printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Lê campos do tipo data. O parse é feito através do formatador do campo.
	 *  
	 * @param valueAsString
	 */
	@SuppressWarnings("unchecked")
	private void readDateField(String valueAsString) {

		try {

			value = (G) format.parseObject(valueAsString);
		} catch (ParseException e) {

			getGenericReadError(e, valueAsString);
		}
	}

	/**
	 * Lê campos de valores decimais. O parse é feito através de formatadores de números decimais.
	 * @param valueAsString
	 */
	@SuppressWarnings("unchecked")
	private void readDecimalField(String valueAsString) {

		DecimalFormat decimalFormat = (DecimalFormat) format;

		try {

			Long parsedValue = (Long) format.parseObject(valueAsString);
			BigDecimal decimalValue = new BigDecimal(parsedValue.longValue());
			decimalValue = decimalValue.movePointLeft(decimalFormat
					.getMaximumFractionDigits());

			value = (G) decimalValue;

		} catch (ParseException e) {

			getGenericReadError(e, valueAsString);
		}
	}

	/**
	 * <p>
	 * Escreve o campo no formato e tamanho especificado.
	 * </p>
	 * 
	 * @see TextStream#write()
	 * 
	 * @return campo escrito
	 * @since 0.2
	 */
	public String write() {

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
			str = StringUtils.replaceChars(value.toString(), ".",
					StringUtils.EMPTY);

		} else {
			str = value.toString();
		}

		str = fill(str);

		if (str.length() != length) {
			throw new IllegalArgumentException("O tamaho do campo [ " + str
					+ " ] é incompatível com o especificado [" + length + "]!");
		}

		return StringUtil.eliminateAccent(str).toUpperCase();
	}

	/**
	 * Preenche a string passada de acordo com o filler do campo.
	 * @param str
	 * @return
	 */
	private String fill(String str) {

		if (isNotNull(filler)) {
			str = filler.fill(str, length);
		}

		return str;
	}

	/**
	 * <p>
	 * Retorna o valor que o campo contém.
	 * </p>
	 * 
	 * @return objeto valor do campo
	 * 
	 * @since 0.2
	 */
	public G getValue() {
		return value;
	}

	/**
	 * <p>
	 * Atribui um valor a instância.
	 * </p>
	 * 
	 * @param field
	 * 
	 * @since 0.2
	 */
	public void setValue(G field) {

		if (isNotNull(field)) {
			this.value = field;

		} else {
			throw new IllegalArgumentException("Campo inválido [" + field
					+ "]!");
		}
	}

	/**
	 * <p>
	 * Tamanho do campo como string.
	 * </p>
	 * 
	 * @return
	 * 
	 * @since 0.2
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * <p>
	 * Atribui um tamanho (maior que zero) a instância.
	 * </p>
	 * 
	 * @param length
	 * 
	 * @since 0.2
	 */
	public void setLength(Integer length) {

		if (length > 0) {
			this.length = length;

		} else {
			throw new IllegalArgumentException("Tamanho inválido [ " + length
					+ " ]!");
		}
	}

	/**
	 * <p>
	 * Formatador utilizado na leitura e na escrita do value.
	 * </p>
	 * 
	 * <p>
	 * <ul>
	 * <li>Na leitura para realizar o <code>parse</code> da String.</li>
	 * <li>Na escrita para transformar o objeto em uma String e assim ser
	 * possível tratá-la para ser escrita.</li>
	 * </ul>
	 * </p>
	 * 
	 * @return formatador
	 * 
	 * @since 0.2
	 */
	public Format getFormat() {
		return format;
	}

	/**
	 * <p>
	 * Atribui um formatador a instância.
	 * </p>
	 * 
	 * @param format
	 * 
	 * @since 0.2
	 */
	public void setFormat(Format format) {

		if (isNotNull(format)) {
			this.format = format;

		} else {
			throw new IllegalArgumentException("Formato inválido [ " + format
					+ " ]!");
		}
	}

	/**
	 * <p>
	 * Retorna o preenchedor do campo.
	 * </p>
	 * 
	 * @return preenchedor
	 * 
	 * @since 0.2
	 */
	public Filler<?> getFiller() {
		return filler;
	}

	/**
	 * <p>
	 * Atribui um preenchedor a instância.
	 * </p>
	 * 
	 * @param filler
	 * 
	 * @since 0.2
	 */
	public void setFiller(Filler<?> filler) {

		if (isNotNull(filler)) {
			this.filler = filler;

		} else {
			throw new IllegalArgumentException("Filler inválido [ " + filler
					+ " ]!");
		}
	}

	/**
	 * Formata a exceção caso ela ocorra na leitura do campo.
	 * @param e
	 * @param value
	 * @return
	 */
	private static Exception getGenericReadError(Exception e, String value) {

		StackTraceElement[] stackTrace = e.getStackTrace();
		e = new RuntimeException("VALOR INVÁLIDO [ "
				+ value + " ]!\nCausado por: " + e.getCause());
		e.setStackTrace(stackTrace);

		return e;
	}

	/**
	 * @see ObjectUtil#toString()
	 */
	@Override
	public String toString() {
		return ObjectUtil.toString(this);
	}
}