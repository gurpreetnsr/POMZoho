package testcases;

import java.util.Hashtable;

import com.zoho.util.Xls_Reader;

public class Temp {
	public static void main(String[] args) {
		String testName = "loginTest"; // test name
		String sheetName = "TestCases"; // sheet name
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");

		int testStartRowNum=1;
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equalsIgnoreCase(testName))
		{
			testStartRowNum++;
		}
		System.out.println("Test " + testName+ " starts from " + testStartRowNum); // row number where required test found

		int colRowNum = testStartRowNum+1;  // row number where actual data starts

		int totalCols = 0;
		while(!xls.getCellData(sheetName, totalCols, colRowNum).equals(""))
		{
			totalCols++;
		}
		System.out.println("Total columns are " + totalCols ); 

		int dataStartRowNum = colRowNum+1;
		int totalDataRows =0;
		while(!xls.getCellData(sheetName, totalDataRows, dataStartRowNum+totalDataRows).equals(""))
		{
			totalDataRows++;
		}
		System.out.println("Total rows with data are " + totalDataRows ); 

		Object[][] tableData = new Object[totalDataRows][1];
		Hashtable<String, String> table =null;
		int i = 0;
		for(int rNum = dataStartRowNum; rNum < (dataStartRowNum+totalDataRows); rNum++)
		{
			table = new Hashtable<String, String>();
			for(int colNum = 0;colNum <totalCols; colNum++)
			{
				String key = xls.getCellData(sheetName, colNum, colRowNum); 
				String data = xls.getCellData(sheetName, colNum, rNum);
				System.out.print(key + " " + data+ " ");
				table.put(key, data);
			}

			tableData[i][0] =table;
			i++;
			System.out.println();
		}


	}
}
