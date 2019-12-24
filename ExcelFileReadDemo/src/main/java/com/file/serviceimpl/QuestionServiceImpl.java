package com.file.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.exceptions.InvalidHeaderException;
import com.file.model.Questions;
import com.file.repository.QuestionRepository;
import com.file.service.QuestionService;

/**
 * @author vinod.nagulkar
 * This is implementation class for QuestionService interface.
 */
@Service
public class QuestionServiceImpl implements QuestionService
{
	@Autowired
	QuestionRepository questionRepo;
	
	/**
	 * This method saves the data from excel file to DB
	 * @param File
	 * @throws InvalidHeaderException if Excel header not matched with criteria 
	 */
	@Override
	public void saveExelData(MultipartFile file) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		
		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.rowIterator();

		Questions question = null;

		List<Questions> listOfquestion = new ArrayList<>();

		List<String> headers = new ArrayList<>();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			question = new Questions();

			if (headers.isEmpty()) {
				headers = builderHeaders(row);
				continue; // skip header row
			}
			//System.out.println(headers.get);
				Iterator<Cell> cellIterator = row.cellIterator();
				int cellCount = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (headers.get(cellCount).toUpperCase()) {
					case "S.NO":
						question.setNo((int) cell.getNumericCellValue());

						break;
					case "QUESTION":
						question.setQues(cell.getStringCellValue());
						break;
					case "OPTION1":
						question.setOption1(cell.getStringCellValue());
						break;
					case "OPTION2":
						question.setOption2(cell.getStringCellValue());
						break;
					case "OPTION3":
						question.setOption3(cell.getStringCellValue());
						break;
					case "OPTION4":

						question.setOption4(cell.getStringCellValue());
						break;
					case "RIGHT":
						question.setRightOption(cell.getStringCellValue());
						break;
					default:
						System.out.println("not matching header found...");
						throw new InvalidHeaderException("File headers are not accepted..!");
					}
					cellCount++;
				}
				listOfquestion.add(question);
			}

		System.out.println(listOfquestion);

		questionRepo.saveAll(listOfquestion);
	}
	
	/**
	 * This method creates the header of excel file
	 * @param row
	 * @return headers list
	 */
	private static List<String> builderHeaders(Row row) {
		Iterator<Cell> cellIterator = row.cellIterator();
		List<String> headers = new ArrayList<String>();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if (cell.getCellType() == 0) {
				headers.add(cell.getNumericCellValue() + "");
			} else if (cell.getCellType() == 1) {
				headers.add(cell.getStringCellValue());
			}
		}
		return headers;
	}
}
