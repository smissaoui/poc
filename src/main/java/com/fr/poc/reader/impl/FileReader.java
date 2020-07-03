package com.fr.poc.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.fr.poc.reader.Reader;

@Component
public class FileReader implements Reader {

	private String inputFileName;

	public FileReader() {

	}



	public String getInputFileName() {
		return inputFileName;
	}


	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}


	/**
	 * Read the content of the inputFileName and apply filters
	 * @throws IOException 
	 *
	 */
	@Override
	public List<String> read(Set<String> wordToFilter,Path inputFileName) throws IOException {

		Stream<String> stream = Files.lines(inputFileName); 
		List<String> wordsFiltered = stream.filter(w-> !wordToFilter.contains(w)).collect(Collectors.toList());
		stream.close();


		return wordsFiltered;

	}


}
