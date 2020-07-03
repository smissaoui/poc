package com.fr.poc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fr.poc.exception.InputParametersException;
import com.fr.poc.readwrite.business.ProcessFilter;
import com.fr.poc.spring.config.AppConfig;

public class MainApplication {




	public static void main(String[] args) throws InputParametersException, IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProcessFilter readWriteBusiness = context.getBean(ProcessFilter.class);

		Set<String> wordsToFilter = new HashSet<>();
		if(args.length >= 2) {
			String inputFileName = args[0];
			// adding the filters in a hashSet
			for(int i=1;i<args.length;i++) {
				wordsToFilter.add(args[i]);
			}
			Path input = Paths.get(inputFileName);
			Path output = Paths.get(input.getParent() + File.separator + "output.txt");
			readWriteBusiness.run(input,wordsToFilter, output);
		}else {
			throw new InputParametersException(args.length == 0 ? "No params provided" :"No words to filter");
		}

		context.close();






	}

}
