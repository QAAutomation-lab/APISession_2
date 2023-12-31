package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;

	public ExcelUtil(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public int getCellCount(String sheetName,int rownum) {
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cellCount;
	}

	public String getCellData(String sheetName,int rownum,int cellnum) {
		
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		DataFormatter formatter=new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		}catch(Exception e) {
			data="";
		}		
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	public void setCellData(String sheetName,int rownum,int cellnum,String data) {
		
		File excelFile=new File(path);
		if(!excelFile.exists()) {
			workbook=new XSSFWorkbook();
			try {
				fos=new FileOutputStream(path);
				workbook.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(workbook.getSheetIndex(sheetName)==-1)
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null)
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		
		try {
			fos=new FileOutputStream(path);
			workbook.write(fos);
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void fillGreenColor(String sheetName,int rownum,int colnum) {
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND); 
		cell.setCellStyle(style);
		
		try {
			workbook.write(fos);
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void fillRedColor(String sheetName,int rownum,int colnum) {
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND); 
		cell.setCellStyle(style);
		
		try {
			workbook.write(fos);
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
	














