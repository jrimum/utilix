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

package org.jrimum.utilix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.jrimum.utilix.ObjectUtil;
import org.junit.Test;

/**
 * <p>
 * Teste unitário para a classe utilitária de objetos
 * </p>
 * 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 *
 */
public class TestObjectUtil {
	
	private static final Object NULL_OBJECT = null;
	
	private static final Object EMPTY_OBJECT = new Object();
	
	private static final Map<Object, Object> NULL_MAP = null;
	
	private static final Collection<Object> NULL_COLLECTION = null;
	
	private static final Map<Object, Object> MAP_COM_ELEMENTO;
	
	private static final Collection<Object> COLLECTION_COM_ELEMENTO;
	
	static {
		
		MAP_COM_ELEMENTO = new HashMap<Object, Object>();
		MAP_COM_ELEMENTO.put(EMPTY_OBJECT, EMPTY_OBJECT);
		
		COLLECTION_COM_ELEMENTO = new ArrayList<Object>();
		COLLECTION_COM_ELEMENTO.add(EMPTY_OBJECT);
	}

	@Test
	public void testIsNull() {
		assertTrue(ObjectUtil.isNull(NULL_OBJECT));
		assertFalse(ObjectUtil.isNull(EMPTY_OBJECT));
	}
	
	@Test
	public void testIsNotNull() {
		assertTrue(ObjectUtil.isNotNull(EMPTY_OBJECT));
		assertFalse(ObjectUtil.isNotNull(NULL_OBJECT));
	}
	
	@Test
	public void testIsEmptyMap() {
		
		assertTrue(ObjectUtil.isEmpty(NULL_MAP));
		assertTrue(ObjectUtil.isEmpty(Collections.EMPTY_MAP));
		
		assertFalse(ObjectUtil.isEmpty(MAP_COM_ELEMENTO));
	}
	
	@Test
	public void testIsNotEmptyMap() {
		
		assertTrue(ObjectUtil.isNotEmpty(MAP_COM_ELEMENTO));
		
		assertFalse(ObjectUtil.isNotEmpty(NULL_MAP));
		assertFalse(ObjectUtil.isNotEmpty(Collections.EMPTY_MAP));
	}
	
	@Test
	public void testIsEmptyCollection() {
		
		assertTrue(ObjectUtil.isEmpty(NULL_COLLECTION));
		assertTrue(ObjectUtil.isEmpty(Collections.EMPTY_LIST));
		
		assertFalse(ObjectUtil.isEmpty(COLLECTION_COM_ELEMENTO));
	}
	
	@Test
	public void testIsNotEmptyCollection() {
		
		assertTrue(ObjectUtil.isNotEmpty(COLLECTION_COM_ELEMENTO));
		
		assertFalse(ObjectUtil.isNotEmpty(NULL_COLLECTION));
		assertFalse(ObjectUtil.isNotEmpty(Collections.EMPTY_LIST));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckNull() {
		ObjectUtil.checkNull(EMPTY_OBJECT);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckNullComMensagem() {
		ObjectUtil.checkNull(EMPTY_OBJECT, "Argumento não nulo");
	}
	
	@Test
	public void testMensagemCheckNullComMensagem() {
		
		try {
			
			ObjectUtil.checkNull(EMPTY_OBJECT, "Argumento não nulo");
			Assert.fail("Exceção não disparada.");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Argumento não nulo", e.getMessage());
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotNull() {
		ObjectUtil.checkNotNull(NULL_OBJECT);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotNullComMensagem() {
		ObjectUtil.checkNotNull(NULL_OBJECT, "Argumento nulo");
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
		ObjectUtil.checkEmpty(MAP_COM_ELEMENTO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckEmptyMapComMensagem() {
		ObjectUtil.checkEmpty(MAP_COM_ELEMENTO, "Argumento não nulo");
	}
	
	@Test
	public void testMensagemCheckEmptyMapComMensagem() {

		try {
			
			ObjectUtil.checkEmpty(MAP_COM_ELEMENTO, "Argumento não nulo");
			Assert.fail("Exceção não disparada");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Argumento não nulo", e.getMessage());
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotEmptyMapNullPointer() {
		ObjectUtil.checkNotEmpty(NULL_MAP);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckNotEmptyMapIllegalArgument() {
		ObjectUtil.checkNotEmpty(Collections.EMPTY_MAP);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotEmptyMapComMensagemNullPointer() {
		ObjectUtil.checkNotEmpty(NULL_MAP, "Argumento nulo");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckNotEmptyMapComMensagemIllegalArgument() {
		ObjectUtil.checkNotEmpty(Collections.EMPTY_MAP, "Map vazio");
	}
	
	@Test
	public void testMensagemCheckNotEmptyMapComMensagem() {
		
		try {
			
			ObjectUtil.checkNotEmpty(NULL_MAP, "Argumento nulo");
			Assert.fail("Exceção não disparada");
						
		} catch (NullPointerException e) {
			assertEquals("Argumento nulo", e.getMessage());
		}
		
		try {
			
			ObjectUtil.checkNotEmpty(Collections.EMPTY_MAP, "Map vazio");
			Assert.fail("Exceção não disparada");
						
		} catch (IllegalArgumentException e) {
			assertEquals("Map vazio", e.getMessage());
		}
	}
	
	
	/*******************************************************************************/
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckEmptyCollection() {
		ObjectUtil.checkEmpty(COLLECTION_COM_ELEMENTO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckEmptyCollectionComMensagem() {
		ObjectUtil.checkEmpty(COLLECTION_COM_ELEMENTO, "Argumento não nulo");
	}
	
	@Test
	public void testMensagemCheckEmptyCollectionComMensagem() {
		
		try {
			
			ObjectUtil.checkEmpty(COLLECTION_COM_ELEMENTO, "Argumento não nulo");
			Assert.fail("Exceção não disparada");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Argumento não nulo", e.getMessage());
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotEmptyCollectionNullPointer() {
		ObjectUtil.checkNotEmpty(NULL_COLLECTION);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckNotEmptyCollectionIllegalArgument() {
		ObjectUtil.checkNotEmpty(Collections.EMPTY_LIST);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckNotEmptyCollectionComMensagemNullPointer() {
		ObjectUtil.checkNotEmpty(NULL_COLLECTION, "Argumento nulo");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheckNotEmptyCollectionComMensagemIllegalArgument() {
		ObjectUtil.checkNotEmpty(Collections.EMPTY_LIST, "Coleção vazia");
	}
	
	@Test
	public void testMensagemCheckNotEmptyCollectionComMensagem() {
		
		try {
			
			ObjectUtil.checkNotEmpty(NULL_COLLECTION, "Argumento nulo");
			Assert.fail("Exceção não disparada");
						
		} catch (NullPointerException e) {
			assertEquals("Argumento nulo", e.getMessage());
		}
		
		try {
			
			ObjectUtil.checkNotEmpty(Collections.EMPTY_LIST, "Coleção vazia");
			Assert.fail("Exceção não disparada");
						
		} catch (IllegalArgumentException e) {
			assertEquals("Coleção vazia", e.getMessage());
		}
	}
}
