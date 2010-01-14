package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

public class TestUtil {

	public static <G> void testEscritaCampo(Field<G> campo, Class<G> tipo, G valorDeEntrada, String strEsperada, int tamanho){
		
		//>>>
		assertNotNull(campo);
		assertTrue(tipo.isInstance(campo.getValue()));
		assertEquals(valorDeEntrada,campo.getValue());
		assertNotNull(campo.write());
		assertEquals(strEsperada,campo.write());
		assertTrue(tamanho == campo.getLength());
		assertTrue(tamanho == campo.write().length());
	}
	
	public static <G> void testLeituraCampo(Field<G> campo, Class<G> tipo, G valorEsperado, String strDeEntrada){
		
		//<<<
		campo.read(strDeEntrada);
		assertTrue(tipo.isInstance(campo.getValue()));
		
		if(campo.getValue() instanceof Date)//compareNoFormatoEscrito
			assertEquals(campo.getFormat().format(valorEsperado),campo.write());
		else
			assertEquals(valorEsperado,campo.getValue());
	
	}
	
}
