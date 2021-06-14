package com.syft.finder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WorkerContinuityFinder {
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.SSS]");
	
	public Map<String,Integer> generateWorkerContinuityReport(String[] inputRows, boolean isSortedByDate) throws IllegalArgumentException{
		
		if(inputRows == null || inputRows.length == 0)
			throw new IllegalArgumentException("Input array must be contain elements");
		
		if(!isSortedByDate)
			Arrays.sort(inputRows,(x,y)->compareDates(x, y));
		
		Map<String, Integer> output = new HashMap<String, Integer>();
		Map<String,List<LocalDateTime>> workerGroupingMap = getWorkerGroupingMap(inputRows,formatter);
		int workerGroupKeyCounter = 0;
		for(String key : workerGroupingMap.keySet()) {
			String workerId = key.split("_")[0];
			int counter = 0;
			List<LocalDateTime> values = workerGroupingMap.get(key);
			for(int i=0; i < values.size(); i++) {
				if(i == 0 || Math.abs(values.get(i).until(values.get(i-1), ChronoUnit.DAYS)) <=6) {
					counter++;
				}
				else {
					output.put(workerId, Math.max(counter,output.getOrDefault(workerId, 1)));
					counter = 1;
				}	
			}
			workerGroupKeyCounter++;
			if(workerGroupKeyCounter < workerGroupingMap.keySet().size())
				counter = 0;	
		}
		return output;
	}
	
	private Map<String,List<LocalDateTime>> getWorkerGroupingMap(String[] inputRows, DateTimeFormatter dateTimeFormater){
		Map<String, List<LocalDateTime>> workerGroupingMap = new HashMap();
		
		for(String row : inputRows) {
			String[] values = row.split(",");
			String key = values[0].trim()+"_"+values[1].trim()+"_"+values[2].trim();
			LocalDateTime date = LocalDateTime.parse(values[3].trim(),dateTimeFormater);
			if(!workerGroupingMap.containsKey(key))
				workerGroupingMap.put(key, new LinkedList<LocalDateTime>());
			workerGroupingMap.get(key).add(date);
		}
		return workerGroupingMap;
	}
	
	private int compareDates(String x, String y) {
		LocalDateTime xDate = LocalDateTime.parse(x.split(",")[3].trim(),formatter);
		LocalDateTime yDate = LocalDateTime.parse(y.split(",")[3].trim(),formatter);
		return yDate.compareTo(xDate);
	}
}
