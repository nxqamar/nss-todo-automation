package com.nss.ExcelFunction;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import jxl.*; 
import jxl.read.biff.BiffException;
/**
 * @author Jayant
 *
 */
public class ExcelFunctions {
	Workbook workbook;
	String val=null;
	public final String ReadTestData(final String filename,final String testcasename,final String attribute){
		
		
		try {
			workbook = Workbook.getWorkbook(new File(filename));
			Sheet sheet = workbook.getSheet("Testdata");
			int row=0;
			int col=0;
			Cell Cellval=sheet.getCell(0,0);
			String tcname = Cellval.getContents();
			String att;
			for (row = 0 ; row < sheet.getRows(); row ++ ) 
			{
				 if (sheet.getCell(0, row).getContents().equals(testcasename))
				 {
					 break;
				 }
			      
			}
			 for (col = 1 ; col < sheet.getColumns(); col ++) 
			 {
			      String[]  str_array = (sheet.getCell(col, row).getContents()).split(":");
			      if(str_array[0].equalsIgnoreCase(attribute)){
			      val= str_array[1];
			      break;
			 }			         
			 }
    		} catch (BiffException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		} 		
		workbook.close();
		return val;
	}
}
