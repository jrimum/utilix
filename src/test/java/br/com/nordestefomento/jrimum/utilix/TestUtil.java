package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.*;

import java.util.Date;

public class TestUtil {

	public static <G> void testEscritaCampo(Field<G> campo, Class<G> tipo, G valorDeEntrada, String strEsperada, int tamanho){
		
		//>>>
		assertNotNull(campo);
		assertTrue(tipo.isInstance(campo.getField()));
		assertEquals(valorDeEntrada,campo.getField());
		assertNotNull(campo.write());
		assertEquals(strEsperada,campo.write());
		assertTrue(tamanho == campo.getLength());
		assertTrue(tamanho == campo.write().length());
	}
	
	public static <G> void testLeituraCampo(Field<G> campo, Class<G> tipo, G valorEsperado, String strDeEntrada){
		
		//<<<
		campo.read(strDeEntrada);
		assertTrue(tipo.isInstance(campo.getField()));
		
		if(campo.getField() instanceof Date)//compareNoFormatoEscrito
			assertEquals(campo.getFormat().format(valorEsperado),campo.write());
		else
			assertEquals(valorEsperado,campo.getField());
	
	}
	
}
