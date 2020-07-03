package com.fr.poc.writer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface Writer {
	
	public void write(List<String> fileFiltred, Path outputFileName) throws IOException;

}
