package org.jrimum.utilix.text;

import org.jrimum.utilix.Objects;


abstract class ThreadLocalFormat<T> extends ThreadLocal<T>{

	protected final String format;
	
	protected ThreadLocalFormat(String format){
		
		Objects.checkNotNull(format, "INVALID NULL FORMAT!");
		
		this.format = format;
	}
}
