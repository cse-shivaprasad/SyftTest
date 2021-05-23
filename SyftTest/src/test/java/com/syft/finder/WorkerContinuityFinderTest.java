package com.syft.finder;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class WorkerContinuityFinderTest {

	private WorkerContinuityFinder finder ;
	
	@Before
	public void beforeTests() {
		finder = new WorkerContinuityFinder();
	}
	
	@Test
	public void should_return_count_2_due_to_role_change() throws Exception{
		String[] rows = {
				"135,  45,  696, 2020-01-25 18:00:00",
				"135,  45,  95,  2020-01-27 18:00:00",
				"135,  45,  95,  2020-01-29 22:15:00"
		};
		
		Map<String, Integer> actualOutput = finder.generateWorkerContinuityReport(rows,false);
		Map<String,Integer> expectedOutput = new HashMap<String,Integer>();
		expectedOutput.put("135", 2);
		Assert.assertEquals(actualOutput, expectedOutput);
	}
	
	@Test
	public void should_return_count_3_as_there_is_continuation() throws Exception{
		String[] rows = {
				"1435, 234, 86,  2020-01-01 17:00:00",
				"1435, 234, 86,  2020-01-04 12:30:00",
				"1435, 234, 86,  2020-01-08 07:00:00"
		};
		Map<String, Integer> actualOutput = finder.generateWorkerContinuityReport(rows,false);
		Map<String,Integer> expectedOutput = new HashMap<String,Integer>();
		expectedOutput.put("1435", 3);
		Assert.assertEquals(actualOutput, expectedOutput);
	}
	
	@Test
	public void should_return_count_18_as_thats_the_max_continuity() throws Exception{
		String[] rows = {
				"1001864,103886,1452,2020-08-28 10:00:00",
				"1001864,103886,1452,2020-08-21 10:00:00",
				"1001864,103886,1452,2020-08-20 10:00:00",
				"1001864,103886,1452,2020-08-19 10:00:00",
				"1001864,103886,1452,2020-08-18 10:00:00",
				"1001864,103886,1452,2020-08-14 10:00:00",
				"1001864,103886,1452,2020-08-13 10:00:00",
				"1001864,103886,1452,2020-08-12 10:00:00",
				"1001864,103886,1452,2020-08-11 10:00:00",
				"1001864,103886,1452,2020-08-10 10:00:00",
				"1001864,103886,1452,2020-08-09 10:00:00",
				"1001864,103886,1452,2020-08-08 10:00:00",
				"1001864,103886,1452,2020-08-04 10:00:00",
				"1001864,103886,1452,2020-08-03 10:00:00",
				"1001864,103886,1452,2020-08-02 10:00:00",
				"1001864,103886,1452,2020-07-30 10:00:00",
				"1001864,103886,1452,2020-07-28 10:00:00",
				"1001864,103886,1452,2020-07-27 10:00:00",
				"1001864,103886,1452,2020-07-26 10:00:00",
				"1001864,103886,1452,2020-07-25 10:00:00", 
				"1001864,103886,1452,2020-07-18 10:00:00",
				"1001864,103886,1452,2020-07-17 10:00:00",
				"1001864,103886,1452,2020-07-11 10:00:00",
				"1001864,103886,1452,2020-07-09 10:00:00",
				"1001864,103886,1452,2020-07-08 10:00:00",
				"1001864,103886,1452,2020-07-07 10:00:00",
				"1001864,103886,1452,2020-07-06 10:00:00",
				"1001864,103886,1452,2020-07-05 10:00:00",
				"1001864,103886,1452,2020-07-04 10:00:00"
		};
		Map<String, Integer> actualOutput = finder.generateWorkerContinuityReport(rows,false);
		Map<String,Integer> expectedOutput = new HashMap<String,Integer>();
		expectedOutput.put("1001864", 18);
		Assert.assertEquals(actualOutput, expectedOutput);
	}
	
}
