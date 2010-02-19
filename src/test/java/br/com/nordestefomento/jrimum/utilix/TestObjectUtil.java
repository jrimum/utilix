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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

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
	public void testIsEmptyMap() {
		
		Map<Object, Object> mapaNull = null;
		Map<Object, Object> mapa = new HashMap<Object, Object>();
		
		assertTrue(ObjectUtil.isEmpty(mapaNull));
		assertTrue(ObjectUtil.isEmpty(mapa));
		
		mapa.put(new Object(), new Object());
		
		assertFalse(ObjectUtil.isEmpty(mapa));
	}
	
	@Test
	public void testIsNotEmptyMap() {
		
		Map<Object, Object> mapa = new HashMap<Object, Object>();
		mapa.put(new Object(), new Object());
		
		assertTrue(ObjectUtil.isNotEmpty(mapa));
		
		mapa.clear();
		
		Map<Object, Object> mapaNull = null;
		
		assertFalse(ObjectUtil.isNotEmpty(mapaNull));
		assertFalse(ObjectUtil.isNotEmpty(mapa));
	}
	
	@Test
	public void testIsEmptyCollection() {
		
		Collection<Object> collectionNull = null;
		Collection<Object> collection = new ArrayList<Object>();
		
		assertTrue(ObjectUtil.isEmpty(collectionNull));
		assertTrue(ObjectUtil.isEmpty(collection));
		
		collection.add(new Object());
		
		assertFalse(ObjectUtil.isEmpty(collection));
	}
	
	@Test
	public void testIsNotEmptyCollection() {
		
		Collection<Object> collection = new ArrayList<Object>();
		collection.add(new Object());
		
		assertTrue(ObjectUtil.isNotEmpty(collection));
		
		collection.clear();
		
		Collection<Object> collectionNull = null;
		
		assertFalse(ObjectUtil.isNotEmpty(collectionNull));
		assertFalse(ObjectUtil.isNotEmpty(collection));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckNull() {
		ObjectUtil.checkNull(new Object());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckNullComMensagem() {
		ObjectUtil.checkNull(new Object(), "Argumento não nulo");
	}
	
	@Test
	public void testMensagemCheckNullComMensagem() {
		
		try {
			
			ObjectUtil.checkNull(new Object(), "Argumento não nulo");
			Assert.fail("Exceção não disparada.");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Argumento não nulo", e.getMessage());
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotNull() {
		ObjectUtil.checkNotNull(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotNullComMensagem() {
		ObjectUtil.checkNotNull(null, "Argumento nulo");
	}
	
	@Test
	public void testMensagemChecNotkNullComMensagem() {
		
		try {
			
			ObjectUtil.checkNotNull(null, "Argumento nulo");
			Assert.fail("Exceção não disparada.");
			
		} catch (NullPointerException e) {
			assertEquals("Argumento nulo", e.getMessage());
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckEmptyMap() {
		
		Map<Object, Object> mapa = new HashMap<Object, Object>();
		mapa.put(new Object(), new Object());
		
		ObjectUtil.checkEmpty(mapa);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckEmptyMapComMensagem() {
		
		Map<Object, Object> mapa = new HashMap<Object, Object>();
		mapa.put(new Object(), new Object());
		
		ObjectUtil.checkEmpty(mapa, "Argumento não nulo");
	}
	
	@Test
	public void testMensagemCheckEmptyMapComMensagem() {
		
		Map<Object, Object> mapa = new HashMap<Object, Object>();
		mapa.put(new Object(), new Object());
		
		try {
			
			ObjectUtil.checkEmpty(mapa, "Argumento não nulo");
			Assert.fail("Exceção não disparada");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Argumento não nulo", e.getMessage());
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotEmptyMap() {
		
		ObjectUtil.checkNotEmpty(null);
		ObjectUtil.checkNotEmpty(new HashMap<Object, Object>());
	}
	
	
}
