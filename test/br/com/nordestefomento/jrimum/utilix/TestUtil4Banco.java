package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TestUtil4Banco {

	GregorianCalendar data = new GregorianCalendar();
	
	@Test
	public final void testCalculcarFatorVencimento() {
		data.set(2000, Calendar.JULY, 3);
		assertEquals(1000, Util4Banco.calculcarFatorVencimento(data.getTime()));
		
		data.set(2000, Calendar.JULY, 5);
		assertEquals(1002, Util4Banco.calculcarFatorVencimento(data.getTime()));
		
		data.set(2025, Calendar.FEBRUARY, 21);
		assertEquals(9999, Util4Banco.calculcarFatorVencimento(data.getTime()));		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public final void testCalculcarFatorVencimentoDataBaseException() {
		data.set(1995, Calendar.JULY, 3);
		Util4Banco.calculcarFatorVencimento(data.getTime());		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void testCalculcarFatorVencimentoDataLimiteException() {
		data.set(2025, Calendar.FEBRUARY, 22);
		Util4Banco.calculcarFatorVencimento(data.getTime());		
	}	

}
