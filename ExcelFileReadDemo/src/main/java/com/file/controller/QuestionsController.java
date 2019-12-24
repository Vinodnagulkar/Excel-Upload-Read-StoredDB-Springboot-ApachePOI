package com.file.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.file.service.QuestionService;
/**
 * @author vinod.nagulkar
 * This is Rest controller which handles all HTTP requests related to Questions Entity.
 * @RestController marks this class as controller which handles all HTTP requests.
 * @CrossOrigin annotation to handle Cross-Origin-Resource-Sharing (CORS). 
 */
@Controller
@CrossOrigin(origins = "*")

public class QuestionsController 
{
	/**
	 * This is QuestionService instance.
	 */
	@Autowired
	QuestionService questionService;
	
	/**
	 * This is logger instance.
	 */
	private final Logger LOGGER = LoggerFactory.getLogger(QuestionsController.class);	
	
	/**
	 * This method is used to uploads the Excel file and stores the data into DB
	 * @param file
	 * @return ResponseEntity with message and HTTP status.
	 * @throws IOException
	 */
	@PostMapping("/uploadExcelFile")
	public ResponseEntity<?> saveExelData(@RequestParam MultipartFile file) throws IOException 
	{
		LOGGER.info(file.getOriginalFilename());

		if (!file.getContentType().contentEquals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) 
		{
			return new ResponseEntity<>("Invalid file type..", HttpStatus.BAD_REQUEST);
		}

		questionService.saveExelData(file);
		return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
	}
	
	

	/**
	 * This method opens the home page of the application.
	 * @return home.jsp page
	 */
	@RequestMapping("/")
	public String indexOpener() 
	{
		System.out.println("Inside indexOpener************************************");
		
		return "home";
	}
}
