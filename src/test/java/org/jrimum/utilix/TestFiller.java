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
 * Created at: 30/03/2008 - 18:15:42
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
 * Criado em: 30/03/2008 - 18:15:42
 * 
 */

package org.jrimum.utilix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jrimum.utilix.text.Filler;
import org.jrimum.utilix.text.TextStream;
import org.jrimum.utilix.text.Filler.SideToFill;
import org.junit.Test;


public class TestFiller {

	private static final String CAMPO = "TESTE";

	private static final int TAMANHO = 10;

	private Filler<String> fillerString;

	private Filler<Integer> fillerInteger;

	private Filler<Double> fillerDouble;

	private Filler<SideToFill> fillerSide;

	@Test(expected = IllegalArgumentException.class)
	public void testSetSideToFillNullValue() {

		Filler.WHITE_SPACE_LEFT.setSideToFill(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetToFillNullValue() {

		Filler.WHITE_SPACE_LEFT.setFillWith(null);
	}

	@Test
	public void testSetToFill() {

		Filler.WHITE_SPACE_LEFT.setFillWith(CAMPO);

		assertTrue(Filler.WHITE_SPACE_LEFT.getFillWith() instanceof String);
		assertEquals(Filler.WHITE_SPACE_LEFT.getFillWith(), CAMPO);
	}

	@Test
	public void testSetSideToFill() {

		Filler.WHITE_SPACE_LEFT.setSideToFill(SideToFill.RIGHT);

		assertEquals(Filler.WHITE_SPACE_LEFT.getSideToFill(), SideToFill.RIGHT);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFiller() {

		new Filler<String>(null, null);
		new Filler<String>("", null);
		new Filler<String>(null, SideToFill.LEFT);
	}

	@Test
	public void testFillString() {

		assertEquals(CAMPO + "00000", Filler.ZERO_RIGHT.fill(CAMPO, TAMANHO));
		assertEquals("00000" + CAMPO, Filler.ZERO_LEFT.fill(CAMPO, TAMANHO));
	}

	@Test
	public void testFillLong() {

		assertEquals(1L + "000000000", Filler.ZERO_RIGHT.fill(1L, TAMANHO));
		assertEquals("000000000" + 1L, Filler.ZERO_LEFT.fill(1L, TAMANHO));
	}

	@Test
	public void testFillInt() {

		assertEquals(1 + "000000000", Filler.ZERO_RIGHT.fill(1, TAMANHO));
		assertEquals("000000000" + 1, Filler.ZERO_LEFT.fill(1, TAMANHO));
	}

	@Test
	public void testFillShort() {

		assertEquals((short) 1 + "000000000", Filler.ZERO_RIGHT.fill((short) 1,
				TAMANHO));
		assertEquals("000000000" + (short) 1, Filler.ZERO_LEFT.fill((short) 1,
				TAMANHO));
	}

	@Test
	public void testFillByte() {

		assertEquals((byte) 1 + "000000000", Filler.ZERO_RIGHT.fill((byte) 1,
				TAMANHO));
		assertEquals("000000000" + (byte) 1, Filler.ZERO_LEFT.fill((byte) 1,
				TAMANHO));
	}

	@Test
	public void testFillChar() {

		assertEquals('1' + "000000000", Filler.ZERO_RIGHT.fill('1', TAMANHO));
		assertEquals("000000000" + '1', Filler.ZERO_LEFT.fill('1', TAMANHO));
	}

	@Test
	public void testFillDouble() {

		assertEquals(1.0 + "0000000", Filler.ZERO_RIGHT.fill(1.0, TAMANHO));
		assertEquals("0000000" + 1.0, Filler.ZERO_LEFT.fill(1.0, TAMANHO));
	}

	@Test
	public void testFillFloat() {

		assertEquals(1.0f + "0000000", Filler.ZERO_RIGHT.fill(1.0f, TAMANHO));
		assertEquals("0000000" + 1.0f, Filler.ZERO_LEFT.fill(1.0f, TAMANHO));
	}

	@Test
	public void testFillObject() {

		Object object = new Object() {

			@Override
			public String toString() {
				return CAMPO;
			}
		};

		assertEquals(object + "00000", Filler.ZERO_RIGHT.fill(object, TAMANHO));
		assertEquals("00000" + object, Filler.ZERO_LEFT.fill(object, TAMANHO));
	}

	@Test
	public void testFillITextStream() {

		TextStream textStream = new TextStream() {

			private static final long serialVersionUID = 1L;

			public void read(String g) {
			}

			public String write() {

				return CAMPO;
			}
		};

		assertEquals(textStream.write() + "00000", Filler.ZERO_RIGHT.fill(
				textStream, TAMANHO));
		assertEquals("00000" + textStream.write(), Filler.ZERO_LEFT.fill(
				textStream, TAMANHO));
	}

	@Test
	public void testFill() {

		fillerString = new Filler<String>("ABC", SideToFill.LEFT);
		assertTrue(fillerString.getFillWith() instanceof String);
		assertEquals("ABCAB" + CAMPO, fillerString.fill(CAMPO, TAMANHO));
		assertEquals(CAMPO, fillerString.fill(CAMPO, 0));
		assertEquals(CAMPO, fillerString.fill(CAMPO, -TAMANHO));

		fillerString.setSideToFill(SideToFill.RIGHT);
		assertEquals(CAMPO + "ABCAB", fillerString.fill(CAMPO, TAMANHO));
		assertEquals(CAMPO, fillerString.fill(CAMPO, 0));
		assertEquals(CAMPO, fillerString.fill(CAMPO, -TAMANHO));

		fillerInteger = new Filler<Integer>(new Integer(TAMANHO),
				SideToFill.LEFT);
		assertTrue(fillerInteger.getFillWith() instanceof Integer);
		assertEquals("10101" + CAMPO, fillerInteger.fill(CAMPO, TAMANHO));
		assertEquals(CAMPO, fillerInteger.fill(CAMPO, 0));
		assertEquals(CAMPO, fillerInteger.fill(CAMPO, -TAMANHO));

		fillerInteger.setSideToFill(SideToFill.RIGHT);
		assertEquals(CAMPO + "10101", fillerInteger.fill(CAMPO, TAMANHO));
		assertEquals(CAMPO, fillerInteger.fill(CAMPO, 0));
		assertEquals(CAMPO, fillerInteger.fill(CAMPO, -TAMANHO));

		fillerDouble = new Filler<Double>(new Double(10.9), SideToFill.LEFT);
		assertTrue(fillerDouble.getFillWith() instanceof Double);
		assertEquals("10.91" + CAMPO, fillerDouble.fill(CAMPO, TAMANHO));
		assertEquals(CAMPO, fillerDouble.fill(CAMPO, 0));
		assertEquals(CAMPO, fillerDouble.fill(CAMPO, -TAMANHO));

		fillerDouble.setSideToFill(SideToFill.RIGHT);
		assertEquals(CAMPO + "10.91", fillerDouble.fill(CAMPO, TAMANHO));
		assertEquals(CAMPO, fillerDouble.fill(CAMPO, 0));
		assertEquals(CAMPO, fillerDouble.fill(CAMPO, -TAMANHO));

		fillerSide = new Filler<SideToFill>(SideToFill.LEFT, SideToFill.LEFT);
		assertTrue(fillerSide.getFillWith() instanceof SideToFill);
		assertEquals("LEFTL" + CAMPO, fillerSide.fill(CAMPO, TAMANHO));
		assertEquals(CAMPO, fillerSide.fill(CAMPO, 0));
		assertEquals(CAMPO, fillerSide.fill(CAMPO, -TAMANHO));

		fillerSide.setSideToFill(SideToFill.RIGHT);
		assertEquals(CAMPO + "LEFTL", fillerSide.fill(CAMPO, TAMANHO));
		assertEquals(CAMPO, fillerSide.fill(CAMPO, 0));
		assertEquals(CAMPO, fillerSide.fill(CAMPO, -TAMANHO));
	}

}
