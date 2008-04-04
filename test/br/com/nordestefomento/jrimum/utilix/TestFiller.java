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


package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.nordestefomento.jrimum.utilix.Filler;
import br.com.nordestefomento.jrimum.utilix.Filler.SideToFill;

public class TestFiller {
	
	private String campo = "TESTE";
	
	private Filler<String> fillerString;
	
	private Filler<Integer> fillerInteger;
	
	private Filler<Double> fillerDouble;
	
	private Filler<SideToFill> fillerSide;

	@Test(expected=IllegalArgumentException.class)
	public void testSetSideToFillNullValue() {
		
		Filler.STR_WHITE_SPACE_LEFT.setSideToFill(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetToFillNullValue() {
		
		Filler.STR_WHITE_SPACE_LEFT.setToFill(null);
	}
	
	@Test
	public void testSetToFill() {
		
		Filler.STR_WHITE_SPACE_LEFT.setToFill(campo);
		
		assertTrue(Filler.STR_WHITE_SPACE_LEFT.getToFill() instanceof String);
		assertEquals(Filler.STR_WHITE_SPACE_LEFT.getToFill(), campo);
	}
	
	@Test
	public void testSetSideToFill() {
		
		Filler.STR_WHITE_SPACE_LEFT.setSideToFill(SideToFill.RIGHT);
		
		assertEquals(Filler.STR_WHITE_SPACE_LEFT.getSideToFill(), SideToFill.RIGHT);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFiller() {
		
		new Filler<String>(null, null);
		new Filler<String>("", null);
		new Filler<String>(null, SideToFill.LEFT);
	}

	@Test
	public void testFill() {
		
		fillerString = new Filler<String>("ABC", SideToFill.LEFT);
		assertTrue(fillerString.getToFill() instanceof String);
		assertEquals("ABCAB" + campo, fillerString.fill(campo, 10));
		assertEquals(campo, fillerString.fill(campo, 0));
		assertEquals(campo, fillerString.fill(campo, -10));
		
		fillerString.setSideToFill(SideToFill.RIGHT);
		assertEquals(campo + "ABCAB", fillerString.fill(campo, 10));
		assertEquals(campo, fillerString.fill(campo, 0));
		assertEquals(campo, fillerString.fill(campo, -10));
		
		fillerInteger = new Filler<Integer>(new Integer(10), SideToFill.LEFT);
		assertTrue(fillerInteger.getToFill() instanceof Integer);
		assertEquals("10101" + campo, fillerInteger.fill(campo, 10));
		assertEquals(campo, fillerInteger.fill(campo, 0));
		assertEquals(campo, fillerInteger.fill(campo, -10));
		
		fillerInteger.setSideToFill(SideToFill.RIGHT);
		assertEquals(campo + "10101", fillerInteger.fill(campo, 10));
		assertEquals(campo, fillerInteger.fill(campo, 0));
		assertEquals(campo, fillerInteger.fill(campo, -10));
		
		fillerDouble = new Filler<Double>(new Double(10.9), SideToFill.LEFT);
		assertTrue(fillerDouble.getToFill() instanceof Double);
		assertEquals("10.91" + campo, fillerDouble.fill(campo, 10));
		assertEquals(campo, fillerDouble.fill(campo, 0));
		assertEquals(campo, fillerDouble.fill(campo, -10));
		
		fillerDouble.setSideToFill(SideToFill.RIGHT);
		assertEquals(campo + "10.91", fillerDouble.fill(campo, 10));
		assertEquals(campo, fillerDouble.fill(campo, 0));
		assertEquals(campo, fillerDouble.fill(campo, -10));
		
		fillerSide = new Filler<SideToFill>(SideToFill.LEFT, SideToFill.LEFT);
		assertTrue(fillerSide.getToFill() instanceof SideToFill);
		assertEquals("LEFTL" + campo, fillerSide.fill(campo, 10));
		assertEquals(campo, fillerSide.fill(campo, 0));
		assertEquals(campo, fillerSide.fill(campo, -10));
		
		fillerSide.setSideToFill(SideToFill.RIGHT);
		assertEquals(campo + "LEFTL", fillerSide.fill(campo, 10));
		assertEquals(campo, fillerSide.fill(campo, 0));
		assertEquals(campo, fillerSide.fill(campo, -10));
	}

}
