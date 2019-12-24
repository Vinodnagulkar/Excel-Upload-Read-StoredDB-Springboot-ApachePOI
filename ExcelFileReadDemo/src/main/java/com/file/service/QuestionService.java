package com.file.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface QuestionService 
{
	public void saveExelData(MultipartFile file) throws IOException;
}
