package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nordestefomento.jrimum.utilix.Operator4Monetary;

public class TestOperator4Monetary {
	
	private BigDecimal numero;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFmt_Real() {
		
		try {
			
			numero = new BigDecimal(".50");
			assertEquals("0,50", Operator4Monetary.fmt_Real.format(numero));
			assertEquals(numero, Operator4Monetary.fmt_Real.parse(Operator4Monetary.fmt_Real.format(numero)));
			
			numero = new BigDecimal("100.50");
			assertEquals("100,50", Operator4Monetary.fmt_Real.format(numero));
			assertEquals(numero, Operator4Monetary.fmt_Real.parse(Operator4Monetary.fmt_Real.format(numero)));
			
			numero = new BigDecimal("15100.50");
			assertEquals("15.100,50", Operator4Monetary.fmt_Real.format(numero));
			assertEquals(numero, Operator4Monetary.fmt_Real.parse(Operator4Monetary.fmt_Real.format(numero)));
			
			numero = new BigDecimal("100.509");
			assertEquals("100,51", Operator4Monetary.fmt_Real.format(numero));
			assertEquals(numero, Operator4Monetary.fmt_Real.parse(Operator4Monetary.fmt_Real.format(numero)));
			
			numero = new BigDecimal("10050");
			assertEquals("10.050,00", Operator4Monetary.fmt_Real.format(numero));
			assertEquals(numero, Operator4Monetary.fmt_Real.parse(Operator4Monetary.fmt_Real.format(numero)));
		}
		catch(ParseException e) {
			fail("Erro de PARSE: " + e);
		}
	}
	
	@Test
	public void testFmt_R$_Real() {
		
		try {
		
			numero = new BigDecimal("0.50");
			assertEquals("R$ 0,50", Operator4Monetary.fmt_R$_Real.format(numero));
			assertEquals(numero, Operator4Monetary.fmt_R$_Real.parse(Operator4Monetary.fmt_R$_Real.format(numero)));
			
			numero = new BigDecimal("100.50");
			assertEquals("R$ 100,50", Operator4Monetary.fmt_R$_Real.format(numero));
			assertEquals(numero, Operator4Monetary.fmt_R$_Real.parse(Operator4Monetary.fmt_R$_Real.format(numero)));
			
			numero = new BigDecimal("15100.50");
			assertEquals("R$ 15.100,50", Operator4Monetary.fmt_R$_Real.format(numero));
			assertEquals(numero, Operator4Monetary.fmt_R$_Real.parse(Operator4Monetary.fmt_R$_Real.format(numero)));
			
			numero = new BigDecimal("100.509");
			assertEquals("R$ 100,51", Operator4Monetary.fmt_R$_Real.format(numero));
			assertEquals(numero, Operator4Monetary.fmt_R$_Real.parse(Operator4Monetary.fmt_R$_Real.format(numero)));
			
			numero = new BigDecimal("10050");
			assertEquals("R$ 10.050,00", Operator4Monetary.fmt_R$_Real.format(numero));
			assertEquals(numero, Operator4Monetary.fmt_R$_Real.parse(Operator4Monetary.fmt_R$_Real.format(numero)));
		}
		catch(ParseException e) {
			fail("Erro de PARSE: " + e);
		}
	}

}
