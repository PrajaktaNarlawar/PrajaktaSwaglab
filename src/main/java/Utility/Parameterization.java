package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization
{
	public static String getData(String name,int r,int c) throws EncryptedDocumentException, IOException
	{

	FileInputStream File=new FileInputStream("E:\\Automation\\eclipse-workspace\\Prajakta_Automation\\SwagLab\\src\\test\\resources\\SwagLabTestData.xlsx");
	String value=WorkbookFactory.create(File).getSheet("Sheet1").getRow(r).getCell(c).getStringCellValue();
	return value;
	}
	
}
