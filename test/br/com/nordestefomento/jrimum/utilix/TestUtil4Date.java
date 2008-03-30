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
	public void testCalcularDiferencaEmDias() {
		
		assertEquals(0, Util4Date.calcularDiferencaEmDias(null, null));
		assertEquals(0, Util4Date.calcularDiferencaEmDias(null, data2));
		assertEquals(0, Util4Date.calcularDiferencaEmDias(data1, null));
		assertEquals(0, Util4Date.calcularDiferencaEmDias(data2, data1));
		assertEquals(0, Util4Date.calcularDiferencaEmDias(data1, data1));
		assertEquals(0, Util4Date.calcularDiferencaEmDias(data2, data2));
		assertEquals(30, Util4Date.calcularDiferencaEmDias(data1, data2));
	}

}
