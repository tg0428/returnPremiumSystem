package com.returnSystem.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;

@SuppressWarnings("deprecation")
public class ExportExcel {

	private HSSFWorkbook wb = null;
	private HSSFSheet sheet = null;

	public HSSFWorkbook getWb() {
		return wb;
	}

	public void setWb(HSSFWorkbook wb) {
		this.wb = wb;
	}

	public HSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(HSSFSheet sheet) {
		this.sheet = sheet;
	}

	public ExportExcel(HSSFWorkbook wb, HSSFSheet sheet) {
		super();
		this.wb = wb;
		this.sheet = sheet;
	}

	public void createNormalHead(String headString,short colSum) {

		HSSFRow row = sheet.createRow(0);

		// 设置第一行
		HSSFCell cell = row.createCell(0);
		row.setHeight((short) 600);

		// 定义单元格为字符串类型
		cell.setCellType(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(new HSSFRichTextString(headString));

		// 指定合并区域
		 sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) colSum));

		HSSFCellStyle cellStyle = wb.createCellStyle();

		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setWrapText(true);// 指定单元格自动换行

		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 500);
		cellStyle.setFont(font);

		cell.setCellStyle(cellStyle);
	}

	public void createColumHeader(String[] columHeader) {

		// 设置列头
		HSSFRow row2 = sheet.createRow(1);

		// 指定行高
		row2.setHeight((short) 600);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setWrapText(true);// 指定单元格自动换行

		// 单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 200);
		cellStyle.setFont(font);

		HSSFCell cell2 = null;
		for (int i = 0; i < columHeader.length; i++) {
			cell2 = row2.createCell(i);
			cell2.setCellType(HSSFCell.ENCODING_UTF_16);
			cell2.setCellValue(new HSSFRichTextString(columHeader[i]));
			cell2.setCellStyle(cellStyle);
		}

	}

	/**
	 * 创建内容单元格
	 * 
	 * @param wb
	 *            HSSFWorkbook
	 * @param row
	 *            HSSFRow
	 * @param col
	 *            short型的列索引
	 * @param align
	 *            对齐方式
	 * @param val
	 *            列值
	 */
	public void createCell(HSSFWorkbook wb, HSSFRow row, int col,
			String val,HSSFCellStyle cellstyle) {
		HSSFCell cell = row.createCell(col);
		cell.setCellType(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(new HSSFRichTextString(val));
		cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellstyle.setWrapText(true);
		cell.setCellStyle(cellstyle);
	}
	
	
	/**
	 * 
	 * 下面的方法的作用：生成考试确认表，退费申请表
	 * */
	
	public void createSpecialHead(String headString,short colm){
		
		HSSFRow row = sheet.createRow(0);

		// 设置第一行
		HSSFCell cell = row.createCell(0);
		row.setHeight((short) 3000);

		// 定义单元格为字符串类型
		cell.setCellType(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(new HSSFRichTextString(headString));

		// 指定合并区域
		 sheet.addMergedRegion(new Region(0, (short) 0, 0, (short)(colm-1)));
		 HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setWrapText(true);// 指定单元格自动换行

		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 300);
		cellStyle.setFont(font);

		cell.setCellStyle(cellStyle);
	}
	
	//创建个人信息表的头部以下每行的列头名称
	public void createRowColumHeader(String[] columHeader) {

		
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setWrapText(true);// 指定单元格自动换行

		// 单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 300);
		cellStyle.setFont(font);
		
		//第一列单元格的宽度
		sheet.setColumnWidth(0, (short)5000);

		HSSFCell cell2 = null;
		for (int i = 0; i < columHeader.length; i++) {
			// 设置列头
			HSSFRow row = sheet.createRow(i+1);
			// 指定行高
			row.setHeight((short) 700);
			cell2 = row.createCell(0);
			cell2.setCellType(HSSFCell.ENCODING_UTF_16);
			cell2.setCellValue(new HSSFRichTextString(columHeader[i]));
			cell2.setCellStyle(cellStyle);
		}
	}
	
	//创建每行第二列的单元格
	public void specialCell(String colum,int rowNum){
		//合并后几列的单元格
		sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum, (short)8));
		sheet.setColumnWidth(0, (short)5000);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setWrapText(true);// 指定单元格自动换行
		
		// 单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 300);
		cellStyle.setFont(font);
		
		HSSFRow row = sheet.getRow(rowNum);
		row.setHeight((short) 700);
		
		HSSFCell cell2 = row.createCell(1);
		cell2.setCellType(HSSFCell.ENCODING_UTF_16);
		cell2.setCellValue(new HSSFRichTextString(colum));
		cell2.setCellStyle(cellStyle);
	}
	
	//创建页尾签名区
	public void createSignName(String content){
		
		HSSFRow row = sheet.createRow(8);
		HSSFCell cell = row.createCell(0);
		sheet.addMergedRegion(new Region(8, (short) 0, 28, (short)8));
		
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setWrapText(true);// 指定单元格自动换行
		
		// 单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 300);
		cellStyle.setFont(font);
		
		cell.setCellType(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(new HSSFRichTextString(content));
		cell.setCellStyle(cellStyle);
		
	}
}

