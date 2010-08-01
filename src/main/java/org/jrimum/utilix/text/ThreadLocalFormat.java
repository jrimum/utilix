package org.jrimum.utilix.text;


abstract class ThreadLocalFormat<T> extends ThreadLocal<T>{

	protected final String format;
	
	protected ThreadLocalFormat(String format){
		
		if(format == null){
			
			throw new IllegalArgumentException("INVALID NULL FORMAT!");
		}
		
		this.format = format;
	}

}
