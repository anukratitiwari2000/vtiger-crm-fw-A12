package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class GetMultipleDataFromExcelFile {
public static void main(String[] args) throws IOException {
	FileInputStream fis =new FileInputStream("./src/test/resources/MultiValuSetData.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("MarkSheet");
	
	/*for(int i=1;i<=sh.getLastRowNum();i++){
		Row rw =sh.getRow(i);
//		Cell cl0=rw.getCell(0);
//		String value=cl0.getStringCellValue();
//		System.out.println(value);
//	
//		Cell cl1=rw.getCell(1);
//		double value1=cl1.getNumericCellValue();
//		System.out.println(value1);
	
	
	String value=rw.getCell(0).getStringCellValue();
	System.out.println(value);
	
	double value1=rw.getCell(1).getNumericCellValue();
	System.out.println(value1);
	}*/
	
	for(int i=1;i<=sh.getLastRowNum();i++) {
		
		String value = sh.getRow(i).getCell(0).getStringCellValue();
		System.out.println(value);
		
		
		double value1 = sh.getRow(i).getCell(1).getNumericCellValue();
		System.out.println(value1);
		}

	}
}
