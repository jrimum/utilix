package org.jrimum.utilix.text;

public interface Format<T, F extends java.text.Format> {

	String format(T obj);

	T parse(String text);

	F copy();
}
