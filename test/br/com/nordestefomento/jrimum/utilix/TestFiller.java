package br.com.nordestefomento.jrimum.utilix;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.nordestefomento.jrimum.utilix.Filler;
import br.com.nordestefomento.jrimum.utilix.Filler.SideToFill;

public class TestFiller {
	
	private String campo = "TESTE";
	
	private Filler<String> fillerString;
	
	private Filler<Integer> fillerInteger;
	
	private Filler<Double> fillerDouble;
	
	private Filler<SideToFill> fillerSide;

	@Test(expected=IllegalArgumentException.class)
	public void testSetSideToFill() {
		
		Filler<String> filler = new Filler<String>("", SideToFill.LEFT);
		filler.setSideToFill(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetToFill() {
		
		Filler<String> filler = new Filler<String>("", SideToFill.LEFT);
		filler.setToFill(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFiller() {
		
		new Filler<String>(null, null);
		new Filler<String>("", null);
		new Filler<String>(null, SideToFill.LEFT);
	}

	@Test
	public void testFill() {
		
		fillerString = new Filler<String>("ABC", SideToFill.LEFT);
		assertEquals("ABCABTESTE", fillerString.fill(campo, 10));
		assertEquals("TESTE", fillerString.fill(campo, 0));
		assertEquals("TESTE", fillerString.fill(campo, -10));
		
		fillerString.setSideToFill(SideToFill.RIGHT);
		assertEquals("TESTEABCAB", fillerString.fill(campo, 10));
		assertEquals("TESTE", fillerString.fill(campo, 0));
		assertEquals("TESTE", fillerString.fill(campo, -10));
		
		fillerInteger = new Filler<Integer>(new Integer(10), SideToFill.LEFT);
		assertEquals("10101TESTE", fillerInteger.fill(campo, 10));
		assertEquals("TESTE", fillerInteger.fill(campo, 0));
		assertEquals("TESTE", fillerInteger.fill(campo, -10));
		
		fillerInteger = new Filler<Integer>(new Integer(10), SideToFill.RIGHT);
		assertEquals("TESTE10101", fillerInteger.fill(campo, 10));
		assertEquals("TESTE", fillerInteger.fill(campo, 0));
		assertEquals("TESTE", fillerInteger.fill(campo, -10));
		
		fillerDouble = new Filler<Double>(new Double(10.9), SideToFill.LEFT);
		assertEquals("10.91TESTE", fillerDouble.fill(campo, 10));
		assertEquals("TESTE", fillerDouble.fill(campo, 0));
		assertEquals("TESTE", fillerDouble.fill(campo, -10));
		
		fillerDouble = new Filler<Double>(new Double(10.9), SideToFill.RIGHT);
		assertEquals("TESTE10.91", fillerDouble.fill(campo, 10));
		assertEquals("TESTE", fillerDouble.fill(campo, 0));
		assertEquals("TESTE", fillerDouble.fill(campo, -10));
		
		fillerSide = new Filler<SideToFill>(SideToFill.LEFT, SideToFill.LEFT);
		assertEquals("LEFTLTESTE", fillerSide.fill(campo, 10));
		assertEquals("TESTE", fillerSide.fill(campo, 0));
		assertEquals("TESTE", fillerSide.fill(campo, -10));
		
		fillerSide = new Filler<SideToFill>(SideToFill.LEFT, SideToFill.RIGHT);
		assertEquals("TESTELEFTL", fillerSide.fill(campo, 10));
		assertEquals("TESTE", fillerSide.fill(campo, 0));
		assertEquals("TESTE", fillerSide.fill(campo, -10));
	}

}
