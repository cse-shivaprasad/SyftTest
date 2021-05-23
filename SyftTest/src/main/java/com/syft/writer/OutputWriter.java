package com.syft.writer;

public interface OutputWriter<T,U,V> {

	public void writeContent(T source, U entity, V content) throws Exception;
}
