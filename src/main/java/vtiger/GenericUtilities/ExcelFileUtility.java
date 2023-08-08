package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consist of all the generic methods related to Excel file
 * @author Satish
 *
 */
public class ExcelFileUtility {

	/**
	 * this method reads String data from Excel file based on given sheetname row  number and cell number
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String value
	 * @throws Throwable
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable, Throwable {
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	
	/**
	 * this method reads Numerical data from Excel file based on given sheetname,RowNumber and CellNumber
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */
	public int getNumericDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable, Throwable {
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		int value = (int) wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		wb.close();
		return value;	
	}
	
	
	/**
	 * this method Used to write String data into the Excel file based on given sheetname ,rowNumber and cell number.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName,int rowNum,int cellNum,String value) throws Throwable, Throwable {
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(ConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * This method will capture all the data inside a sheet for dataprovider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();//5
		int lastCel = sh.getRow(lastRow).getLastCellNum();//3
		
  Object[][] data = new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
	
	
}
