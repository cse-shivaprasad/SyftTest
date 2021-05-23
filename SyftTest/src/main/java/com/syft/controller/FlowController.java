package com.syft.controller;

import java.util.Map;

import com.syft.finder.WorkerContinuityFinder;
import com.syft.input.InputArgs;
import com.syft.input.InputHandler;
import com.syft.meta.OutputWriterMeta;
import com.syft.parser.FileParser;
import com.syft.writer.OutputWriter;

public class FlowController {
	
	
	public void invokeFlow(String[] args) throws Exception{
		
		//1. Input Values Parsing
		InputArgs inputArgs = new InputHandler().getInputArgs(args);
		
		//2. Parse the input file
		String[] inputRecords = FileParser.parseInputFile(inputArgs.inputFilePath, true);
		
		//3. Invoke WorkerContinuityFinder
		Map<String,Integer> outputRecords = new WorkerContinuityFinder().generateWorkerContinuityReport(inputRecords,false);
		
		//4. Write Output content
		OutputWriter writer = OutputWriterMeta.valueOf(OutputWriterMeta.FILE.name()).getOutputWriter();
		writer.writeContent(inputArgs.outputFolderPath, inputArgs.entityName, outputRecords);
	}
}
