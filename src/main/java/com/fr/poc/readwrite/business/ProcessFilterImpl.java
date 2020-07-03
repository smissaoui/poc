package com.fr.poc.readwrite.business;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fr.poc.reader.Reader;
import com.fr.poc.writer.Writer;

@Component
public class ProcessFilterImpl implements ProcessFilter{

	@Autowired
	private Reader reader;
	
	@Autowired
	private Writer writer;
	
	Logger logger = LoggerFactory.getLogger(ProcessFilterImpl.class);
	
	

	
	public ProcessFilterImpl(Reader reader, Writer writer) {
		this.writer = writer;
		this.reader = reader;
	}




	/**
	 *
	 * Read the content of the inputFileName, apply filters and write the result
	 * in an outputFile
	 */
	public void run(Path inputFileName, Set<String> wordToFilter, Path outputFileName) throws IOException {
		
		logger.info("Reading " + inputFileName + " and applying the filters");
		
		List<String> fileFiltered = reader.read(wordToFilter, inputFileName);
		
		logger.info("Reading and filtering finished ");
		logger.info("Writing the result in the output file " + outputFileName);
		
		writer.write(fileFiltered, outputFileName);
		
		logger.info("Writing in the output file " + outputFileName + " finished ");
	}
	
}
