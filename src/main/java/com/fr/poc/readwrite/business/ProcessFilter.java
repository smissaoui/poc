package com.fr.poc.readwrite.business;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

public interface ProcessFilter {
	
	public void run(Path inputFileName, Set<String> wordToFilter, Path outputFileName) throws IOException;
}
