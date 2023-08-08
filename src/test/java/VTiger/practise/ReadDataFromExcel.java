package VTiger.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vtiger.GenericUtilities.ConstantsUtility;



public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1:Load the Document in java readable format
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
        
		//step 2:create a workbook for the file loaded
		Workbook wb = WorkbookFactory.create(fis);
        
		//step 3:Navigate to required sheet
        Sheet sheet = wb.getSheet("Organizations");
        
        //step 4:Navigate to required Row
        Row row = sheet.getRow(0);
        
        //step 5:Navigate to required cell
        Cell cell = row.getCell(0);
        
        //step 6:Read the data from the cell
        String value = cell.getStringCellValue();
        System.out.println(value);
        
        
	}

}
