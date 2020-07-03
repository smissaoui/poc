package com.fr.poc;



import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fr.poc.readwrite.business.ProcessFilter;
import com.fr.poc.spring.config.AppConfig;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=AppConfig.class)
public class ReadWriteBusinessTest {
	
	@Autowired
	private ProcessFilter filter;
	
	@Test
	public void testReadWriteBusinessWithEmptyInputFile() throws IOException, URISyntaxException {
		
		String fileName = "emptyInput.txt";
        ClassLoader classLoader = new FileReaderTest().getClass().getClassLoader();

		Set<String> wordToFilter = new HashSet<>();
		Path input = Paths.get(classLoader.getResource(fileName).toURI());
		Path output = Paths.get(input.getParent().toString() + File.separator + "output.txt");
		filter.run(input, wordToFilter, output);
	}
	
	@Test
	public void testReadWriteBusinessWithInputFile1() throws IOException, URISyntaxException {
		
		String fileName = "inputFileTest1.txt";
        ClassLoader classLoader = new FileReaderTest().getClass().getClassLoader();

		
		Set<String> wordToFilter = new HashSet<>();
		wordToFilter.add("ligne1");
		wordToFilter.add("ligne2");
		Path input = Paths.get(classLoader.getResource(fileName).toURI());
		Path output = Paths.get(input.getParent().toString() + File.separator + "output.txt");
		filter.run(input, wordToFilter, output);
	}
	
	@Test
	public void testReadWriteBusinessWithInputFile2() throws IOException, URISyntaxException {
		
		String fileName = "inputFileTest2.txt";
        ClassLoader classLoader = new FileReaderTest().getClass().getClassLoader();

		
		Set<String> wordToFilter = new HashSet<>();
		wordToFilter.add("toto");
		wordToFilter.add("test");
		Path input = Paths.get(classLoader.getResource(fileName).toURI());
		Path output = Paths.get(input.getParent().toString() + File.separator + "output.txt");
		filter.run(input, wordToFilter, output);
	}

}
