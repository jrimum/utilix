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
 * Created at: 30/03/2008 - 18:15:33
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
 * Criado em: 30/03/2008 - 18:15:33
 * 
 */

package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nordestefomento.jrimum.utilix.Util4Date;

public class TestUtil4Date {
	
	private static Date data1;
	
	private static Date data2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2007, Calendar.OCTOBER, 16);
		data1 = calendar1.getTime();
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2007, Calendar.NOVEMBER, 16);
		data2 = calendar2.getTime();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		data1 = null;
		data2 = null;
	}

	@Test
	public void testCalculeDiferencaEmDias() {
		assertEquals(0, Util4Date.calculeDiferencaEmDias(data1, data1));
		assertEquals(0, Util4Date.calculeDiferencaEmDias(data2, data2));
		assertEquals(31, Util4Date.calculeDiferencaEmDias(data1, data2));
		assertEquals(31, Util4Date.calculeDiferencaEmDias(data2, data1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculeDiferencaEmDiasException() {
		Util4Date.calculeDiferencaEmDias(null, data1);
	}

}
