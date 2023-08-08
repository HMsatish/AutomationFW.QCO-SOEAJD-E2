package VTiger.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteTheDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1:Load the Document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestDataVtiger.xlsx");
		        
		//step 2:create a workbook for the file loaded
		Workbook wb = WorkbookFactory.create(fis);
		        
		//step 3:create a sheet
		Sheet sheet = wb.createSheet("Trail");
		        
		//step 4: create a Row
		Row row = sheet.createRow(3);
		        
		//step 5:create a cell
	    Cell cell = row.createCell(2);
	    
		//step 6:set the value into a cell.
		 cell.setCellValue("satish");
		 
		//step 7:open the file in java write format
	     FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestDataVtiger.xlsx");
			        
		//step 8:call the write method
		 wb.write(fos);
		 System.out.println("Data added");
		 
		//step 9:close the work book
		 wb.close();
		 System.out.println("workbook close");
		 

	}

}
