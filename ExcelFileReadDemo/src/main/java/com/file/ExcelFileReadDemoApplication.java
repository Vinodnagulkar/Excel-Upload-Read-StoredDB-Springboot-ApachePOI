package com.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.file.controller.QuestionsController;

@SpringBootApplication
public class ExcelFileReadDemoApplication {

	public static void main(String[] args) {
		/**
		 * This is logger instance.
		 */
		final Logger LOGGER = LoggerFactory.getLogger(QuestionsController.class);	
		
		SpringApplication.run(ExcelFileReadDemoApplication.class, args);
		
		LOGGER.info("\n\n\tHello ExcelFileReadDemoApplication started...");
	}

}
