package br.com.nordestefomento.jrimum.utilix;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.nordestefomento.jrimum.ACurbitaObject;

public class Util4Monetary extends ACurbitaObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3239576826390112911L;

	/**
	 * DecimalFormatSymbols com localização (Processo de localização) Brasil.
	 */
	public static final DecimalFormatSymbols LocalizacaoBrasil = new DecimalFormatSymbols(new Locale("pt", "BR"));
	
	/**
	 * DecimalFormatSymbols com localização (Processo de localização) England.
	 */
	public static final DecimalFormatSymbols LocalizacaoEngland = new DecimalFormatSymbols(new Locale("en", "US"));
	
	/**
	 * NumberFormat usado para formatar valores monetários em real.
	 */
	public static final NumberFormat fmt_Real = new DecimalFormat("#,##0.00", LocalizacaoBrasil);
	
	/**
	 * NumberFormat usado para formatar valores monetários em real com apenas UMA casa decimal.
	 */
	public static final NumberFormat fmt_Real_v9 = new DecimalFormat("#,##0.0", LocalizacaoBrasil);
	
	/**
	 * NumberFormat usado para formatar valores monetários em real com o prefixo R$, exemplo: R$ 10,00.
	 */
	public static final NumberFormat fmt_R$_Real = new DecimalFormat("R$ #,##0.00", LocalizacaoBrasil);

}
