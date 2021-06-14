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
		Assert.assertEquals(expectedOutput,actualOutput);
	}
	
	@Test
	public void smallset_of_date_discontinuity_test() throws Exception{
		String[] rows = {
				"456,  78,  576, 2020-02-22 15:00:00",
				"456,  78,  576, 2020-02-17 06:00:00",
				"456,  78,  576, 2020-02-09 06:00:00",
				"456,  78,  576, 2020-02-08 05:00:00",
				"456,  78,  576, 2020-11-04 14:30:00"
		};
		
		Map<String, Integer> actualOutput = finder.generateWorkerContinuityReport(rows,false);
		Map<String,Integer> expectedOutput = new HashMap<String,Integer>();
		expectedOutput.put("456", 2);
		Assert.assertEquals(expectedOutput,actualOutput);
	}
	
	@Test
	public void full_continuity_test() throws Exception{
		String[] rows = {
				"1435, 234, 86,  2020-01-01 17:00:00",
				"1435, 234, 86,  2020-01-04 12:30:00",
				"1435, 234, 86,  2020-01-08 07:00:00"
		};
		Map<String, Integer> actualOutput = finder.generateWorkerContinuityReport(rows,false);
		Map<String,Integer> expectedOutput = new HashMap<String,Integer>();
		expectedOutput.put("1435", 3);
		Assert.assertEquals(expectedOutput,actualOutput);
	}
	
	@Test
	public void largeset_date_discontinuity_test() throws Exception{
		String[] rows = {
				"1001864,103886,1452,2020-08-28 17:00:00",
				"1001864,103886,1452,2020-08-21 17:00:00",
				"1001864,103886,1452,2020-08-20 17:00:00",
				"1001864,103886,1452,2020-08-19 17:00:00",
				"1001864,103886,1452,2020-08-18 17:00:00",
				"1001864,103886,1452,2020-08-14 17:00:00",
				"1001864,103886,1452,2020-08-13 17:00:00",
				"1001864,103886,1452,2020-08-12 17:00:00",
				"1001864,103886,1452,2020-08-11 17:00:00",
				"1001864,103886,1452,2020-08-10 17:00:00",
				"1001864,103886,1452,2020-08-09 17:00:00",
				"1001864,103886,1452,2020-08-08 17:00:00",
				"1001864,103886,1452,2020-08-04 17:00:00",
				"1001864,103886,1452,2020-08-03 17:00:00",
				"1001864,103886,1452,2020-08-02 17:00:00",
				"1001864,103886,1452,2020-07-30 17:00:00",
				"1001864,103886,1452,2020-07-28 17:00:00",
				"1001864,103886,1452,2020-07-27 17:00:00",
				"1001864,103886,1452,2020-07-26 17:00:00",
				"1001864,103886,1452,2020-07-25 17:00:00",
				"1001864,103886,1445,2020-07-19 17:00:00",
				"1001864,103886,1452,2020-07-18 17:00:00",
				"1001864,103886,1452,2020-07-17 17:00:00",
				"1001864,103886,1452,2020-07-11 17:00:00",
				"1001864,103886,1452,2020-07-09 17:00:00",
				"1001864,103886,1452,2020-07-08 17:00:00",
				"1001864,103886,1452,2020-07-07 17:00:00",
				"1001864,103886,1452,2020-07-06 17:00:00",
				"1001864,103886,1445,2020-07-05 17:00:00",
				"1001864,103886,1452,2020-07-05 17:00:00",
				"1001864,103886,1452,2020-07-04 17:00:00"
		};
		Map<String, Integer> actualOutput = finder.generateWorkerContinuityReport(rows,false);
		Map<String,Integer> expectedOutput = new HashMap<String,Integer>();
		expectedOutput.put("1001864", 19);
		Assert.assertEquals(expectedOutput,actualOutput);
	}
	
}
