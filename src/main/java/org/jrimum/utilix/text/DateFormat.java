package org.jrimum.utilix.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum DateFormat implements Format<Date, SimpleDateFormat>{

	/**
	 * <p>
	 * Formatador de datas no padrão <tt>ddMMyy</tt>.
	 * </p>
	 */
	DDMMYY("ddMMyy"),
	/**
	 * <p>
	 * Formatador de datas no padrão <tt></tt>.
	 * </p>
	 */
	DDMMYY_B("dd/MM/yy"), 
	DDMMYY_H("dd-MM-yy"), 
	DDMMYY_U("dd_MM_yy"),
	DDMMYYYY("ddMMyyyy"), 
	DDMMYYYY_B("dd/MM/yyyy"), 
	DDMMYYYY_H("dd-MM-yyyy"), 
	DDMMYYYY_U("dd_MM_yyyy"),
	YYMMDD("yyMMdd"),
	YYMMDD_B("yy/MM/dd"),
	YYMMDD_H("yy-MM-dd"),
	YYMMDD_U("yy_MM_dd"),
	YYYYMMDD("yyyyMMdd"),
	YYYYMMDD_B("yyyy/MM/dd"),
	YYYYMMDD_H("yyyy-MM-dd"),
	YYYYMMDD_U("yyyy_MM_dd"),
	HHMMSS("hhmmss"),
	HHMMSS_24("HHmmss"),
	HHMMSS_C("hh:mm:ss"),
	HHMMSS_24C("HH:mm:ss"),
	;
	
	private final ThreadLocalFormat<SimpleDateFormat> DATE_FORMAT;

	private DateFormat(String format) {
	
		DATE_FORMAT = new ThreadLocalFormat<SimpleDateFormat>(format){

			@Override
			protected SimpleDateFormat initialValue() {
				
		       return new SimpleDateFormat(format);
			}
	        
	    };
	}

	/**
	 * @see org.jrimum.utilix.text.Format#format(java.lang.Object)
	 */
	public String format(Date obj) {
	
		return DATE_FORMAT.get().format(obj);
	}
	
	/**
	 * @see org.jrimum.utilix.text.Format#parse(java.lang.String)
	 */
	public Date parse(String text) {
		
		try {
			
			return DATE_FORMAT.get().parse(text);
			
		} catch (ParseException e) {
			
			throw new IllegalArgumentException("DateFormat Exception!", e);
		}
	}
	
	/**
	 * @see org.jrimum.utilix.text.Format#copy()
	 */
	public SimpleDateFormat copy(){
		
			
		return (SimpleDateFormat) DATE_FORMAT.get().clone();
	}
}
