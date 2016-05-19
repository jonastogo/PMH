package lexer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

public class Write {
	/**
	 * Wirte the list data to file
	 *
	 * @param file
	 * @param list
	 * @throws IOException
	 */
	public Write(ArrayList<Token> list) throws IOException {
		if (list != null) {
			String file = "date/Save.xls";
			boolean added = false;
			HSSFWorkbook workbook = null;
			HSSFSheet sheet = null;
			HSSFCell cell;
			HSSFRow row;
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd _HH_mm_ss ");

			try {
				workbook = new HSSFWorkbook(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				workbook = new HSSFWorkbook();
			}
			Date currentTime = new Date();
			String date = formatter.format(currentTime);
			HSSFFont fett = workbook.createFont();
			fett.setBoldweight(fett.BOLDWEIGHT_BOLD);
			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setFont(fett);

			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				if (workbook.getSheetName(i).equals(date)) {
					sheet = workbook.createSheet(workbook.getSheetName(i) + "(1)");
					//catch (IllegalArgumentException e) {
					//										// Später drüber nach denken

					//		}
					added = true;
				}
			}
			if (added == false) {
				sheet = workbook.createSheet(date);
			}
			row = sheet.createRow(0);

			cell = row.createCell(0);
			cell.setCellValue("Name");
			cell.setCellStyle(style);
			cell = row.createCell(1);
			cell.setCellValue("Content");
			cell.setCellStyle(style);
			int i = 1;
			for (Token tmp : list) {
				row = sheet.createRow(i);
				for (int x = 0; x < 2; x++) {
					if (x == 0) {
						cell = row.createCell(x);
						cell.setCellValue(tmp.getClass().getName().substring(6));//Cell durch Wert Token Name ersetzen
					}
					if (x == 1) {
						cell = row.createCell(x);
						cell.setCellValue(tmp.getHtml());//Cell durch Wert Token Content ersetzen
					}
					if ((i % 2) == 0) {
						CellStyle style1 = workbook.createCellStyle();
						style1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
						style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellStyle(style1);

					}
				}
				i++;
			}
			try {
				workbook.write(new FileOutputStream(file));
			} catch (FileNotFoundException e) {
				System.out.println("Bitte die Datei schließen und erneut Speichern!");
			}
			workbook.close();

		}
	}
}
