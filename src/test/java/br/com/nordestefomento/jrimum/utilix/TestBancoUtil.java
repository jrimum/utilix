package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.nordestefomento.jrimum.JRimumException;

public class TestBancoUtil {

	GregorianCalendar data = new GregorianCalendar();
	
	@Test(expected=JRimumException.class)
	public void testCalculeFatorDeVencimentoDataNull() {
		
		BancoUtil.calculceFatorDeVencimento(null);
	}
	
	@Test(expected=JRimumException.class)
	public void testCalculeFatorDeVencimentoDataMenorQueDataBase() {
		
		data.set(1997, Calendar.JANUARY, 1);
		
		BancoUtil.calculceFatorDeVencimento(data.getTime());
	}
	
	@Test(expected=JRimumException.class)
	public void testCalculeFatorDeVencimentoDataMaiorQueDataLimite() {
		
		data.set(2025, Calendar.FEBRUARY, 22);
		
		BancoUtil.calculceFatorDeVencimento(data.getTime());
	}
	
	@Test
	public final void testCalculceFatorDeVencimento() {
		
		data.set(2000, Calendar.JULY, 3);
		assertEquals(1000, BancoUtil.calculceFatorDeVencimento(data.getTime()));
		
		data.set(2000, Calendar.JULY, 5);
		assertEquals(1002, BancoUtil.calculceFatorDeVencimento(data.getTime()));
		
		data.set(2025, Calendar.FEBRUARY, 21);
		assertEquals(9999, BancoUtil.calculceFatorDeVencimento(data.getTime()));		
	}

}
