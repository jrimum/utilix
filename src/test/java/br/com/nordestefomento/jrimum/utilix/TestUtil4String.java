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
 * Created at: 30/03/2008 - 18:15:10
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
 * Criado em: 30/03/2008 - 18:15:10
 * 
 */


package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestUtil4String {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEliminateSymbols() {
		
		assertEquals("", Util4String.eliminateSymbols("><,;.:!*&%+-_<>[]\\/"));
	}

	@Test
	public void testEliminateAccent() {
		
		assertEquals("c", Util4String.eliminateAccent("ç"));
		assertEquals("C", Util4String.eliminateAccent("Ç"));
		
		assertEquals("a", Util4String.eliminateAccent("à"));
		assertEquals("a", Util4String.eliminateAccent("á"));
		assertEquals("a", Util4String.eliminateAccent("â"));
		assertEquals("a", Util4String.eliminateAccent("ã"));
		assertEquals("a", Util4String.eliminateAccent("ä"));
		
		assertEquals("e", Util4String.eliminateAccent("è"));
		assertEquals("e", Util4String.eliminateAccent("é"));
		assertEquals("e", Util4String.eliminateAccent("ê"));
		assertEquals("e", Util4String.eliminateAccent("ë"));
		
		assertEquals("i", Util4String.eliminateAccent("ì"));
		assertEquals("i", Util4String.eliminateAccent("í"));
		assertEquals("i", Util4String.eliminateAccent("î"));
		assertEquals("i", Util4String.eliminateAccent("ï"));
		
		assertEquals("o", Util4String.eliminateAccent("ò"));
		assertEquals("o", Util4String.eliminateAccent("ó"));
		assertEquals("o", Util4String.eliminateAccent("ô"));
		assertEquals("o", Util4String.eliminateAccent("õ"));
		assertEquals("o", Util4String.eliminateAccent("ö"));
		
		assertEquals("u", Util4String.eliminateAccent("ù"));
		assertEquals("u", Util4String.eliminateAccent("ú"));
		assertEquals("u", Util4String.eliminateAccent("û"));
		assertEquals("u", Util4String.eliminateAccent("ü"));
		
		assertEquals("A", Util4String.eliminateAccent("À"));
		assertEquals("A", Util4String.eliminateAccent("Á"));
		assertEquals("A", Util4String.eliminateAccent("Â"));
		assertEquals("A", Util4String.eliminateAccent("Ã"));
		assertEquals("A", Util4String.eliminateAccent("Ä"));
		
		assertEquals("E", Util4String.eliminateAccent("È"));
		assertEquals("E", Util4String.eliminateAccent("É"));
		assertEquals("E", Util4String.eliminateAccent("Ê"));
		assertEquals("E", Util4String.eliminateAccent("Ë"));
		
		assertEquals("I", Util4String.eliminateAccent("Ì"));
		assertEquals("I", Util4String.eliminateAccent("Í"));
		assertEquals("I", Util4String.eliminateAccent("Î"));
		assertEquals("I", Util4String.eliminateAccent("Ï"));
		
		assertEquals("O", Util4String.eliminateAccent("Ò"));
		assertEquals("O", Util4String.eliminateAccent("Ó"));
		assertEquals("O", Util4String.eliminateAccent("Ô"));
		assertEquals("O", Util4String.eliminateAccent("Õ"));
		assertEquals("O", Util4String.eliminateAccent("Ö"));
		
		assertEquals("U", Util4String.eliminateAccent("Ù"));
		assertEquals("U", Util4String.eliminateAccent("Ú"));
		assertEquals("U", Util4String.eliminateAccent("Û"));
		assertEquals("U", Util4String.eliminateAccent("Ü"));
	}
}
