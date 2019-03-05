/****************************************************************************************
 *ExcelUtils: Read and interact with excel file
 ****************************************************************************************
 *Constructor ExcelUtils: Read excel file  @param String path
 *Method getrowcount: Count number of rows with data @param String sheet, @return int rowcount
 *Method getrowData: Count number of cols with data @param	String sheet, int rownum, int colnum @return String data
 *Method closeExcel: Close excel file @param FileInputStream fis
 * 
 * @author  santhiparambalam
 * @version 1.0 05/03/19
 *****************************************************************************************/

package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private static File file;
	private static XSSFWorkbook wb;
	private static XSSFSheet ws;
	
	public ExcelUtil(String path) 
	{
		try {
		file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		try {
			wb=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to read workbook");
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to read excel file");
		}
	}
	
	public static int getrowcount(String sheet)
	{
		ws=wb.getSheet(sheet);
		int lastrow=ws.getLastRowNum();
		int rowcount=lastrow+1;
		return rowcount;
	}
	
	public static String getrowData(String sheet, int rownum, int colnum)
	{
		ws=wb.getSheet(sheet);
		String data=ws.getRow(rownum).getCell(colnum).getStringCellValue();
		return data;
	}
	
	public static void closeExcel(FileInputStream fis)
	{
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to close excel File");
		}
		
	}
}
