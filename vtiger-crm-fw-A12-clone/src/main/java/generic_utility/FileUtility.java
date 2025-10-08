package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}

	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws IOException {
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value1 = cell.getStringCellValue();
		return value1;
	}

	public int getNumericDataFromExcelFile(String sheetName, int rowNum,int cellNum) throws IOException {
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/MultiValuSetData.xlsx");
		Workbook wb=WorkbookFactory.create(fisExcel);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cell=row.getCell(cellNum);
		int value2=(int)cell.getNumericCellValue();
		
		return value2;
	}

}
