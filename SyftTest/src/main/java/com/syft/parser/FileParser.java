package com.syft.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FileParser {
	
	public static String[] parseInputFile(String filePath, boolean headerIncluded) throws IOException{
		List<String> rows = Files.readAllLines(Paths.get(filePath));
		
		String[] inputRecords = headerIncluded ? new String[rows.size()-1] : new String[rows.size()];
		
		for(int i=0,j=0; i<rows.size(); i++) {
			if(headerIncluded && i==0)
				continue;
			inputRecords[j++] = rows.get(i);
		}
		return inputRecords;
	}

}
