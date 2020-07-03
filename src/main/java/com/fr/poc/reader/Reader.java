package com.fr.poc.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;


public interface Reader {
	
	public List<String> read(Set<String> wordToFilter, Path inputFileName) throws IOException;

}
