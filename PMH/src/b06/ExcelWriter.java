package b06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * Class for writing data to the list
 * @author karl
 *
 */
public class ExcelWriter {
	private String filename;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	
	public ExcelWriter(String filename) {
		this.filename = filename;
	}
	/**
	 * Opens a file if possible or prepares workbook to create a new one
	 */
	public void prepare() {
		try {
			workbook = new HSSFWorkbook(new FileInputStream(filename));
		} catch (IOException e) {
			workbook = new HSSFWorkbook();
		}
	}
	/**
	 * Sets the sheet attribute to the next free sheet
	 */
	public void findFreeSheet() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd _HH_mm_ss ");
		Date currentTime = new Date();
		String trySheetName = formatter.format(currentTime);
		String randomString = "";
		
		while(sheetExists(trySheetName + randomString))
			randomString = genRandomString("ABCDEFG123456", 2);
		
		sheet = workbook.createSheet(trySheetName + randomString);
		
	}
	
	private boolean sheetExists(String toCheckSheet) {
		for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
			if(workbook.getSheetName(sheetNum).equals(toCheckSheet))
				return true;
		}
		return false;
	}
	
	/**
	 * Creates the first row with required color and font types
	 */
	public void prepareSheet() {
		HSSFRow row;
		HSSFFont fat = workbook.createFont();
		CellStyle style = workbook.createCellStyle();
		HSSFCell cell;
		
		
		fat.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(fat);
		
	
		row = sheet.createRow(0);
	
		cell = row.createCell(0);
		cell.setCellValue("Name");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("Content");
		cell.setCellStyle(style);
		
	}
	
	/**
	 * Fills the sheet with data
	 * @param token The data that will be filled
	 */
	public void fillData(ArrayList <Token> token) {
		HSSFRow row;
		HSSFCell cell;
		int i = 1;
		CellStyle grey = workbook.createCellStyle();
		grey.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		grey.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		
		for (Token tmp : token) {
			row = sheet.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue(tmp.getClass().getName().substring(4));// Cell durch Wert Token Name ersetzen
			
			cell = row.createCell(1);
			cell.setCellValue(tmp.getHtml());// Cell durch Wert Token Content ersetzen
			
			if ((i % 2) == 0)
				cell.setCellStyle(grey);
			i++;
		}
	}
	/**
	 * Saves the temporary data to file
	 * @return Returns false if there's a problem with the file-writing
	 */
	public boolean saveToFile() {
		try {
			workbook.write(new FileOutputStream(filename));
		} catch (IOException e) {
			System.out.println("Error at writing!");
			return false;
		}		
		return true;
	}

	private String genRandomString(String chars, int length) {
	  Random rand = new Random();
	  
	  StringBuilder buf = new StringBuilder();
	  for (int i=0; i<length; i++) {
	    buf.append(chars.charAt(rand.nextInt(chars.length())));
	  }
	  return buf.toString();
	}


}
