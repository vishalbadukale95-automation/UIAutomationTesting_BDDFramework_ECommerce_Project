package UtilityLayer;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook workbook;
	static XSSFSheet sheets;

	public static List<Map<String, Object>> getAllSheetTestData(String excelSheetPath, String sheetName) {

		try {
			FileInputStream fis = new FileInputStream(excelSheetPath);

			workbook = new XSSFWorkbook(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

		XSSFSheet sheets = workbook.getSheet(sheetName);

		int rowCount = sheets.getLastRowNum();

		List<Map<String, Object>> rowTestData = new ArrayList<Map<String, Object>>();

		for (int i = 1; i <= rowCount; i++) {

			int cellCount = sheets.getRow(0).getLastCellNum();

			LinkedHashMap<String, Object> columnTestData = new LinkedHashMap<String, Object>();

			for (int j = 0; j < cellCount; j++) {

				String columnHeading = sheets.getRow(0).getCell(j).getStringCellValue();

				XSSFCell cells = sheets.getRow(i).getCell(j);
				if (cells.getCellType() == CellType.BLANK) {

					columnTestData.put(columnHeading, "");
				} else if (cells.getCellType() == CellType.STRING) {
					String cellValue = cells.getStringCellValue();

					columnTestData.put(columnHeading, cellValue);

				} else if (cells.getCellType() == CellType.NUMERIC) {
					String cellValue = cells.getRawValue();
					columnTestData.put(columnHeading, cellValue);
				} else if (cells.getCellType() == CellType.BOOLEAN) {
					boolean cellValue = cells.getBooleanCellValue();
					columnTestData.put(columnHeading, cellValue);
				} else if (cells.getCellType() == CellType.FORMULA) {
					String cellValue = cells.getCellFormula();
					columnTestData.put(columnHeading, cellValue);
				} else {
					System.out.println("Please check Excel Sheet");
				}

			}

			rowTestData.add(columnTestData);
		}

		return rowTestData;
	}
}
