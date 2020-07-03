package com.fr.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.fr.poc.reader.Reader;
import com.fr.poc.reader.impl.FileReader;


@RunWith(JUnitPlatform.class)
public class FileReaderTest {

	
	
	@Test
	public void testReadEmptyFile() throws IOException, URISyntaxException {

		String fileName = "emptyInput.txt";
        ClassLoader classLoader = new FileReaderTest().getClass().getClassLoader();
 
		Reader fileReader = new FileReader();
		Set<String> wordToFilter = new HashSet<>();
		List<String> result = fileReader.read(wordToFilter, Paths.get(classLoader.getResource(fileName).toURI()));
		assertEquals(result.size(), 0);
	}
	
	@Test
	public void testReadFileWithoutFilter() throws IOException, URISyntaxException {

		String fileName = "inputFileTest1.txt";
        ClassLoader classLoader = new FileReaderTest().getClass().getClassLoader();
		
		Reader fileReader = new FileReader();
		Set<String> wordToFilter = new HashSet<>();
		List<String> result = fileReader.read(wordToFilter, Paths.get(classLoader.getResource(fileName).toURI()));

		
		assertEquals(result.size(), 5);
	}
	
	@Test
	public void testReadFileWithOneFilter() throws IOException, URISyntaxException {
		
		String fileName = "inputFileTest1.txt";
        ClassLoader classLoader = new FileReaderTest().getClass().getClassLoader();
		
		Reader fileReader = new FileReader();
		Set<String> wordToFilter = new HashSet<>();
		wordToFilter.add("ligne1");
		List<String> result = fileReader.read(wordToFilter, Paths.get(classLoader.getResource(fileName).toURI()));

		assertEquals(result.size(), 4);
		assertEquals(result.contains("ligne1"),false);
	}
	
	@Test
	public void testReadFileWithTwoFilters() throws IOException, URISyntaxException {

		String fileName = "inputFileTest1.txt";
        ClassLoader classLoader = new FileReaderTest().getClass().getClassLoader();
		
		Reader fileReader = new FileReader();
		Set<String> wordToFilter = new HashSet<>();
		wordToFilter.add("ligne1");
		wordToFilter.add("ligne2");
		List<String> result = fileReader.read(wordToFilter, Paths.get(classLoader.getResource(fileName).toURI()));

		
		
		assertEquals(result.size(), 3);
		assertEquals(result.contains("ligne1"),false);
		assertEquals(result.contains("ligne2"),false);
	}
	
	@Test
	public void testReadFileWithWhitespace() throws IOException, URISyntaxException {

		String fileName = "inputFileTest2.txt";
        ClassLoader classLoader = new FileReaderTest().getClass().getClassLoader();
		
		Reader fileReader = new FileReader();
		Set<String> wordToFilter = new HashSet<>();
		List<String> result = fileReader.read(wordToFilter, Paths.get(classLoader.getResource(fileName).toURI()));

		
		
		assertEquals(result.size(), 7);

	}
	
	@Test
	public void testReadFileWithWhitespaceAndOneFilter() throws IOException, URISyntaxException {

		String fileName = "inputFileTest2.txt";
        ClassLoader classLoader = new FileReaderTest().getClass().getClassLoader();
		
		Reader fileReader = new FileReader();
		Set<String> wordToFilter = new HashSet<>();
		wordToFilter.add("");
		List<String> result = fileReader.read(wordToFilter, Paths.get(classLoader.getResource(fileName).toURI()));

		
		
		assertEquals(result.size(), 5);
		assertEquals(result.contains(""),false);

	}
	
	@Test
	public void testReadFileWithWhitespaceAndTwoFilters() throws IOException, URISyntaxException {

		String fileName = "inputFileTest2.txt";
        ClassLoader classLoader = new FileReaderTest().getClass().getClassLoader();
		
		Reader fileReader = new FileReader();
		Set<String> wordToFilter = new HashSet<>();
		wordToFilter.add("test");
		wordToFilter.add("tito");
		List<String> result = fileReader.read(wordToFilter, Paths.get(classLoader.getResource(fileName).toURI()));

		
		
		assertEquals(result.size(), 5);
		assertEquals(result.contains("test"),false);
		assertEquals(result.contains("tito"),false);

	}
}
