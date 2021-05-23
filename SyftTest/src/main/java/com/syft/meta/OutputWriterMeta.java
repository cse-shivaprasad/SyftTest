package com.syft.meta;

import com.syft.writer.FileWriter;
import com.syft.writer.OutputWriter; 

public enum OutputWriterMeta {

	FILE("FILE",new FileWriter());
	
	private String outputType;
	private OutputWriter writer;
	
	private OutputWriterMeta(String outputType, OutputWriter writer) {
		this.outputType = outputType;
		this.writer = writer;
	}
	
	public OutputWriter getOutputWriter() {
		return this.writer;
	}
}
