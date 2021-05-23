package com.syft.parser;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


public class FileParserTest {
	
	@Test
	public void should_return_record_count_excluding_header() throws IOException{
		String[] inputRecords = FileParser.parseInputFile("src/test/resources/test-input/input1.csv", true);
		Assert.assertEquals(7, inputRecords.length);
	}
	
	@Test
	public void should_return_record_all_record_count() throws IOException{
		String[] inputRecords = FileParser.parseInputFile("src/test/resources/test-input/input1.csv", false);
		Assert.assertEquals(8, inputRecords.length);
	}
	
	@Test
	public void should_throw_IOException() {
		IOException exception = Assert.assertThrows(IOException.class,
									() -> FileParser.parseInputFile("test/resources/test-inputs/input3.csv", true));
		Assert.assertTrue(exception != null);
	} 

}
