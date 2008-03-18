package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.nordestefomento.jrimum.utilix.Field;
import br.com.nordestefomento.jrimum.utilix.Filler;
import br.com.nordestefomento.jrimum.utilix.Operator4Date;
import br.com.nordestefomento.jrimum.utilix.Operator4Monetary;

public class TestField {

	private Field<String> campoString;
	
	private Field<Integer> campoInteger;
	
	private Field<Long> campoLong;
	
	private Field<Date> campoDate;
	
	private Field<BigDecimal> campoDecimal;
	
	private Field<BigDecimal> campoDecimal_v9;
	
	@Before
	public void setUp(){
		
		campoString = new Field<String>(StringUtils.EMPTY, 8);
		campoString.setFiller(Filler.STR_WHITE_SPACE_RIGHT);
		
		campoDate = new Field<Date>(new GregorianCalendar(2007, Calendar.JULY, 22).getTime(), 6, Operator4Date.fmt_ddMMyy);
		
		campoInteger = new Field<Integer>(0, 6);
		campoInteger.setFiller(Filler.ZERO_LEFT);
		
		campoLong = new Field<Long>(0L, 6);
		campoLong.setFiller(Filler.ZERO_LEFT);
		
		campoDecimal = new Field<BigDecimal>(new BigDecimal("875.98"), 11, Operator4Monetary.fmt_Real);
		campoDecimal.setFiller(Filler.ZERO_LEFT);
		
		campoDecimal_v9 = new Field<BigDecimal>(new BigDecimal("875.9"), 11, Operator4Monetary.fmt_Real_v9);
		campoDecimal_v9.setFiller(Filler.ZERO_LEFT);
	}
	
	@After
	public void tearDown(){
		
		campoString = null;
		campoDate = null;
		campoInteger = null;
		campoLong = null;
		campoDecimal = null;
		campoDecimal_v9 = null;
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCampo() {
		
		Format format = null;
		
		campoDate = new Field<Date>(new Date(), 0, Operator4Date.fmt_ddMMyy);
		campoDate = new Field<Date>(null, 1, Operator4Date.fmt_ddMMyy);
		campoDate = new Field<Date>(new Date(), 0, format);
	}

	@Test
	public void testLer() {
		
		campoString.read("COBRANCA");
		assertNotNull(campoString.getField());
		assertTrue(campoString.getField() instanceof String);
		assertEquals("COBRANCA", campoString.getField().toString());

		campoDate.read("011002");
		assertNotNull(campoDate.getField());
		assertTrue(campoDate.getField() instanceof Date);
		assertEquals("011002", Operator4Date.fmt_ddMMyy.format(campoDate.getField()));
				
		campoInteger.read("000001");
		assertNotNull(campoInteger.getField());
		assertTrue(campoInteger.getField() instanceof Integer);
		assertEquals(1, campoInteger.getField());
		
		campoLong.read("000001");
		assertNotNull(campoLong.getField());
		assertTrue(campoLong.getField() instanceof Long);
		assertEquals(1L, campoLong.getField());
		
		campoDecimal.read("00000523676");
		assertNotNull(campoDecimal.getField());
		assertTrue(campoDecimal.getField() instanceof BigDecimal);
		assertTrue(new BigDecimal("5236.76").compareTo(campoDecimal.getField()) == 0);
		
		campoDecimal_v9.read("00000523676");
		assertNotNull(campoDecimal_v9.getField());
		assertTrue(campoDecimal_v9.getField() instanceof BigDecimal);
		assertTrue(new BigDecimal("52367.6").compareTo(campoDecimal_v9.getField()) == 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLerException(){
		
		campoString.read(null);
		campoDate.read(null);
		campoDate.read("");
		campoDate.read("abcd");
		campoDate.read("1a2MA1205");
	}

	@Test
	public void testEscrever() {
		
		assertNotNull(campoString.toString());
		assertEquals("        ", campoString.toString());
		assertEquals(8, campoString.toString().length());
		
		assertNotNull(campoDate.toString());
		assertEquals("220707", campoDate.toString());
		assertEquals(6, campoDate.toString().length());
		
		campoDate.setField(Operator4Date.DATE_NULL);
		campoDate.setFiller(Filler.ZERO_LEFT);
		assertNotNull(campoDate.toString());
		assertEquals("000000", campoDate.toString());
		assertEquals(6, campoDate.toString().length());
		
		assertNotNull(campoInteger.toString());
		assertEquals("000000", campoInteger.toString());
		assertEquals(6, campoInteger.toString().length());
		
		assertNotNull(campoLong.toString());
		assertEquals("000000", campoLong.toString());
		assertEquals(6, campoLong.toString().length());
		
		assertNotNull(campoDecimal.toString());
		assertEquals("00000087598", campoDecimal.toString());
		assertEquals(11, campoDecimal.toString().length());
		
		assertNotNull(campoDecimal_v9.toString());
		assertEquals("00000008759", campoDecimal_v9.toString());
		assertEquals(11, campoDecimal_v9.toString().length());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEscreverException() {
		
		Field<String> campo = new Field<String>("tamanho", 5);
		assertEquals(5, campo.toString().length());
		
		Field<Integer> campo1 = new Field<Integer>(1234, 3);
		assertEquals(3, campo1.toString().length());
		
		Field<Integer> campo2 = new Field<Integer>(12, 3);
		assertEquals(3, campo2.toString().length());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetCampo() {

		campoInteger.setField(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetTamanho() {

		campoString.setLength(0);
		campoString.setLength(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetFiller() {

		campoString.setFiller(null);
	}

}
