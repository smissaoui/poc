package com.fr.poc.writer.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fr.poc.writer.Writer;

@Component
public class FileWriter implements Writer {

	public FileWriter() {
		super();
	}

	/**
	 *
	 * Write the content of the filtered file in an output file
	 * @throws IOException 
	 */
	@Override
	public void write(List<String> fileFiltered, Path outputFileName) throws IOException {
			Files.write(outputFileName, fileFiltered);
	}




}
