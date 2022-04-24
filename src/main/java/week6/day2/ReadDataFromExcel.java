package week6.day2;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	
	public class ReadDataFromExcel {
		
		@DataProvider(name="excelTestData")
		public String[][] getTestDataFromExcelFile() {
			XSSFWorkbook testWorkBook = null;
			
			try {
				testWorkBook= new XSSFWorkbook("./ExcelData\\CreateLeadTestData.xlsx");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			XSSFSheet testWorkSheet= testWorkBook.getSheet("Sheet1");
			int lastRowNum=testWorkSheet.getLastRowNum()-testWorkSheet.getFirstRowNum();
			
			//or
			//int lastRowNum1=testWorkSheet.getPhysicalNumberOfRows()-testWorkSheet.getFirstRowNum();
			//System.out.println(lastRowNum1);
			
			int lastCellNum= testWorkSheet.getRow(0).getLastCellNum();
			
			//Declare a 2d string array to get all the values from xl to array
			String[][] testData=  new String[lastRowNum][lastCellNum];
			
			for(int i=1;i<=lastRowNum;i++)
			{
				
				for(int j=0;j<lastCellNum;j++)
				{
					String temp=testWorkSheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(temp);
					testData[i-1][j] = temp;
				}
			}
			
			//close work book
			try {
				testWorkBook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return testData;
			
		}
	
	}
