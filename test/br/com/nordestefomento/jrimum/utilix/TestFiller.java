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
	public void testSetSideToFill() {
		
		Filler<String> filler = new Filler<String>("", SideToFill.LEFT);
		filler.setSideToFill(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetToFill() {
		
		Filler<String> filler = new Filler<String>("", SideToFill.LEFT);
		filler.setToFill(null);
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
		assertEquals("ABCABTESTE", fillerString.fill(campo, 10));
		assertEquals("TESTE", fillerString.fill(campo, 0));
		assertEquals("TESTE", fillerString.fill(campo, -10));
		
		fillerString.setSideToFill(SideToFill.RIGHT);
		assertEquals("TESTEABCAB", fillerString.fill(campo, 10));
		assertEquals("TESTE", fillerString.fill(campo, 0));
		assertEquals("TESTE", fillerString.fill(campo, -10));
		
		fillerInteger = new Filler<Integer>(new Integer(10), SideToFill.LEFT);
		assertEquals("10101TESTE", fillerInteger.fill(campo, 10));
		assertEquals("TESTE", fillerInteger.fill(campo, 0));
		assertEquals("TESTE", fillerInteger.fill(campo, -10));
		
		fillerInteger = new Filler<Integer>(new Integer(10), SideToFill.RIGHT);
		assertEquals("TESTE10101", fillerInteger.fill(campo, 10));
		assertEquals("TESTE", fillerInteger.fill(campo, 0));
		assertEquals("TESTE", fillerInteger.fill(campo, -10));
		
		fillerDouble = new Filler<Double>(new Double(10.9), SideToFill.LEFT);
		assertEquals("10.91TESTE", fillerDouble.fill(campo, 10));
		assertEquals("TESTE", fillerDouble.fill(campo, 0));
		assertEquals("TESTE", fillerDouble.fill(campo, -10));
		
		fillerDouble = new Filler<Double>(new Double(10.9), SideToFill.RIGHT);
		assertEquals("TESTE10.91", fillerDouble.fill(campo, 10));
		assertEquals("TESTE", fillerDouble.fill(campo, 0));
		assertEquals("TESTE", fillerDouble.fill(campo, -10));
		
		fillerSide = new Filler<SideToFill>(SideToFill.LEFT, SideToFill.LEFT);
		assertEquals("LEFTLTESTE", fillerSide.fill(campo, 10));
		assertEquals("TESTE", fillerSide.fill(campo, 0));
		assertEquals("TESTE", fillerSide.fill(campo, -10));
		
		fillerSide = new Filler<SideToFill>(SideToFill.LEFT, SideToFill.RIGHT);
		assertEquals("TESTELEFTL", fillerSide.fill(campo, 10));
		assertEquals("TESTE", fillerSide.fill(campo, 0));
		assertEquals("TESTE", fillerSide.fill(campo, -10));
	}

}
