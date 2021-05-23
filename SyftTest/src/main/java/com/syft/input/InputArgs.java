package com.syft.input;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = " ")
public class InputArgs {
	
	@Parameter(names = {"-i","inputFilePath"}, required = true)
	public String inputFilePath;
	
	@Parameter(names = {"-o","outputFolderPath"}, required = true)
	public String outputFolderPath;
	
	@Parameter(names = {"-e","entityName"}, required = true)
	public String entityName;
	
}
