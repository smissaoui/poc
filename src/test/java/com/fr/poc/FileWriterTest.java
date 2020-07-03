package com.fr.poc;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.fr.poc.writer.impl.FileWriter;

@RunWith(JUnitPlatform.class)
public class FileWriterTest {
	
	@Test
	public void testWriteEmptyFile() throws IOException, URISyntaxException {

		String inputFileName = "emptyInput.txt";
        ClassLoader classLoader = new FileWriterTest().getClass().getClassLoader();
		Path input = Paths.get(classLoader.getResource(inputFileName).toURI());
		Path output = Paths.get(input.getParent().toString() + File.separator + "emptyOutputFile.txt");

		FileWriter writer = new FileWriter();
		List<String> fileFiltered = new ArrayList<>();
		
		writer.write(fileFiltered, output);
		Stream<String> stream = Files.lines(output);
		
		assertEquals(stream.count(), 0L);
		stream.close();
	}
	
	@Test
	public void testWriteFile1() throws IOException, URISyntaxException {

		String inputFileName = "inputFileTest1.txt";
        ClassLoader classLoader = new FileWriterTest().getClass().getClassLoader();
		Path input = Paths.get(classLoader.getResource(inputFileName).toURI());
		Path output = Paths.get(input.getParent().toString() + File.separator + "outputFileTest1.txt");

		FileWriter writer = new FileWriter();
		List<String> fileFiltered = new ArrayList<>();
		fileFiltered.add("ligne1");
		fileFiltered.add("ligne2");
		fileFiltered.add("ligne3");
		
		
		writer.write(fileFiltered, output);
		Stream<String> stream = Files.lines(output);
		
		assertEquals(stream.count(), 3L);
		assertTrue(Files.lines(output).anyMatch(w-> w.equals("ligne1")));
		assertTrue(Files.lines(output).anyMatch(w-> w.equals("ligne2")));
		assertTrue(Files.lines(output).anyMatch(w-> w.equals("ligne3")));
		stream.close();
	}
	
	@Test
	public void testWriteFile2() throws IOException, URISyntaxException {

		String inputFileName = "inputFileTest2.txt";
        ClassLoader classLoader = new FileWriterTest().getClass().getClassLoader();
		Path input = Paths.get(classLoader.getResource(inputFileName).toURI());
		Path output = Paths.get(input.getParent().toString() + File.separator + "outputFileTest2.txt");

		FileWriter writer = new FileWriter();
		List<String> fileFiltered = new ArrayList<>();
		fileFiltered.add("toto");
		fileFiltered.add("");
		fileFiltered.add("titi");
		
		
		writer.write(fileFiltered, output);
		Stream<String> stream = Files.lines(output);
		
		assertEquals(stream.count(), 3L);
		assertTrue(Files.lines(output).anyMatch(w-> w.equals("toto")));
		assertTrue(Files.lines(output).anyMatch(w-> w.equals("")));
		assertTrue(Files.lines(output).anyMatch(w-> w.equals("titi")));
		stream.close();
	}
	

	


}
