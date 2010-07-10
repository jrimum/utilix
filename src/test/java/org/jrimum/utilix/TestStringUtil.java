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

package org.jrimum.utilix;

import static org.junit.Assert.assertEquals;

import org.jrimum.utilix.StringUtil;
import org.junit.Test;

public class TestStringUtil {

	@Test
	public void testEliminateSymbols() {

		assertEquals("", StringUtil.eliminateSymbols("><,;.:!*&%+-_<>[]\\/"));
	}

	@Test
	public void testEliminateAccent() {

		assertEquals("c", StringUtil.eliminateAccent("ç"));
		assertEquals("C", StringUtil.eliminateAccent("Ç"));

		assertEquals("a", StringUtil.eliminateAccent("à"));
		assertEquals("a", StringUtil.eliminateAccent("á"));
		assertEquals("a", StringUtil.eliminateAccent("â"));
		assertEquals("a", StringUtil.eliminateAccent("ã"));
		assertEquals("a", StringUtil.eliminateAccent("ä"));

		assertEquals("e", StringUtil.eliminateAccent("è"));
		assertEquals("e", StringUtil.eliminateAccent("é"));
		assertEquals("e", StringUtil.eliminateAccent("ê"));
		assertEquals("e", StringUtil.eliminateAccent("ë"));

		assertEquals("i", StringUtil.eliminateAccent("ì"));
		assertEquals("i", StringUtil.eliminateAccent("í"));
		assertEquals("i", StringUtil.eliminateAccent("î"));
		assertEquals("i", StringUtil.eliminateAccent("ï"));

		assertEquals("o", StringUtil.eliminateAccent("ò"));
		assertEquals("o", StringUtil.eliminateAccent("ó"));
		assertEquals("o", StringUtil.eliminateAccent("ô"));
		assertEquals("o", StringUtil.eliminateAccent("õ"));
		assertEquals("o", StringUtil.eliminateAccent("ö"));

		assertEquals("u", StringUtil.eliminateAccent("ù"));
		assertEquals("u", StringUtil.eliminateAccent("ú"));
		assertEquals("u", StringUtil.eliminateAccent("û"));
		assertEquals("u", StringUtil.eliminateAccent("ü"));

		assertEquals("A", StringUtil.eliminateAccent("À"));
		assertEquals("A", StringUtil.eliminateAccent("Á"));
		assertEquals("A", StringUtil.eliminateAccent("Â"));
		assertEquals("A", StringUtil.eliminateAccent("Ã"));
		assertEquals("A", StringUtil.eliminateAccent("Ä"));

		assertEquals("E", StringUtil.eliminateAccent("È"));
		assertEquals("E", StringUtil.eliminateAccent("É"));
		assertEquals("E", StringUtil.eliminateAccent("Ê"));
		assertEquals("E", StringUtil.eliminateAccent("Ë"));

		assertEquals("I", StringUtil.eliminateAccent("Ì"));
		assertEquals("I", StringUtil.eliminateAccent("Í"));
		assertEquals("I", StringUtil.eliminateAccent("Î"));
		assertEquals("I", StringUtil.eliminateAccent("Ï"));

		assertEquals("O", StringUtil.eliminateAccent("Ò"));
		assertEquals("O", StringUtil.eliminateAccent("Ó"));
		assertEquals("O", StringUtil.eliminateAccent("Ô"));
		assertEquals("O", StringUtil.eliminateAccent("Õ"));
		assertEquals("O", StringUtil.eliminateAccent("Ö"));

		assertEquals("U", StringUtil.eliminateAccent("Ù"));
		assertEquals("U", StringUtil.eliminateAccent("Ú"));
		assertEquals("U", StringUtil.eliminateAccent("Û"));
		assertEquals("U", StringUtil.eliminateAccent("Ü"));
	}

	@Test(expected = NullPointerException.class)
	public void testCheckNotBlankNull() {
		StringUtil.checkNotBlank(null);
	}
}
