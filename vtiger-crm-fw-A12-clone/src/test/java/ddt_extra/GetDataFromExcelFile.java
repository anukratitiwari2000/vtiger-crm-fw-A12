package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream FisExcel = new FileInputStream("./src/test/resources/GetDataFromExcelFile.java.xlsx");
		Workbook wb = WorkbookFactory.create(FisExcel);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(5);
		Cell cell=	row.getCell(0);
		String string=cell.getStringCellValue()+(int)(Math.random())*1000;

	}
}
