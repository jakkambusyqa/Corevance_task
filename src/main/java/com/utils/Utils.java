package com.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.base.TestBase;

public class Utils extends TestBase {

	
	
private static final String filePath="./src/main/java/testdata/corevance_testdata.xlsx";
	

	public static String[][] readData(String sheetName) throws Throwable {

		File file = new File(filePath);
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rows - 1][columns];

		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < columns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}
		return data;
	}
	
}
