package ddt_extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetDataIntoExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream FisExcel = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(FisExcel);
		Sheet sh = wb.getSheet("org");
//		Row row = sh.createRow(1);
//		Cell cell = row.createCell(1);
//		cell.setCellValue("Google_");

		Row row = sh.createRow(1);
		Cell cell = row.createCell(0);
		cell.setCellValue("Yahoo_");

		// save
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestScriptData.xlsx");
		wb.write(fos);

		wb.close();
	}
}
