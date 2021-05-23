package com.syft.writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FileWriter implements OutputWriter<String, String, Map<String,Integer>>{

	@Override
	public void writeContent(String source, String entityName, Map<String,Integer> contentMap) throws IOException {
		
		Files.createDirectories(Path.of(source));
		Path outputFilepath = Path.of(source+File.separator+entityName);
		Files.deleteIfExists(outputFilepath);
		
		Files.write(outputFilepath, () -> contentMap.entrySet().stream()
			    							.<CharSequence>map(e -> e.getKey() + "," + e.getValue())
			    							.iterator());
	}

}
