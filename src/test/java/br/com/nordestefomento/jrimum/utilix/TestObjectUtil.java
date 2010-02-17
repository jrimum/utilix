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
 * Created at: 16/02/2010 - 18:40:40
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
 * Criado em: 16/02/2010 - 18:40:40
 * 
 */

package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * <p>
 * Teste unitário para a classe utilitária de objetos
 * </p>
 * 
 * @author Rômulo Augusto
 * 
 * @since 0.2
 * 
 * @version 0.2
 *
 */
public class TestObjectUtil {

	@Test
	public void testIsNull() {
		assertTrue(ObjectUtil.isNull(null));
		assertFalse(ObjectUtil.isNull(new Object()));
	}
	
	@Test
	public void testIsNotNull() {
		assertTrue(ObjectUtil.isNotNull(new Object()));
		assertFalse(ObjectUtil.isNotNull(null));
	}
	
	@Test
	public void testIsEmpty() {
		
		Map<Object, Object> mapa = new HashMap<Object, Object>();
		
		assertTrue(ObjectUtil.isEmpty(null));
		assertTrue(ObjectUtil.isEmpty(mapa));
		
		mapa.put(new Object(), new Object());
		
		assertFalse(ObjectUtil.isEmpty(mapa));
	}
	
	@Test
	public void testIsNotEmpty() {
		
		Map<Object, Object> mapa = new HashMap<Object, Object>();
		mapa.put(new Object(), new Object());
		
		assertTrue(ObjectUtil.isNotEmpty(mapa));
		
		mapa.clear();
		
		assertFalse(ObjectUtil.isNotEmpty(null));
		assertFalse(ObjectUtil.isNotEmpty(mapa));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckNull() {
		ObjectUtil.checkNull(new Object());
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotNull() {
		ObjectUtil.checkNotNull(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckEmpty() {
		
		Map<Object, Object> mapa = new HashMap<Object, Object>();
		mapa.put(new Object(), new Object());
		
		ObjectUtil.checkEmpty(mapa);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotEmpty() {
		
		ObjectUtil.checkNotEmpty(null);
		ObjectUtil.checkNotEmpty(new HashMap<Object, Object>());
	}
}
