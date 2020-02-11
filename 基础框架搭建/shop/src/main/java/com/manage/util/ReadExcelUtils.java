package com.managesystem.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelUtils {
	private final static String excel_2003 = ".xls"; // 对应2003版本Excel后缀
	private final static String excel_2007 = ".xlsx"; // 对应2007版本Excel后缀

	/**
	 * 读取Excel文件,并以List<Map<String, Object>>的形式返回Excel内容,
	 * Map的key为列名,value为单元格内容,每个Map代表一行
	 * 
	 * @param in:文件输入流
	 * @param fileName:文件名
	 * @return:文件的所有内容
	 * @throws Exception
	 */
	public static List<Map<String, Object>> readExcel(InputStream in,
			String fileName) throws Exception {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); // 存放Excel表格全部内容
		Sheet sheet = null; // 工作表
		Row row = null; // 工作表中的一行
		Cell cell = null; // 工作表中的一个单元格
		// 创建工作薄
		Workbook wb = getWorkbook(in, fileName);
		if (wb == null) {
			throw new Exception("创建工作薄失败");
		}
		// 循环工作簿中的所有工作表
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			sheet = wb.getSheetAt(i);
			if (sheet == null) {
				continue;
			}
			// 存储列名
			List<String> columName = new ArrayList<String>();
			// 遍历工作表的所有行
			for (int j = 0; j < sheet.getLastRowNum(); j++) {
				row = sheet.getRow(j);
				if (row == null) {
					continue;
				}
				//判断是否为工作表第一行(即列名)
				if (j == 0) {
					for (int t = row.getFirstCellNum(); t < row
							.getLastCellNum(); t++) {
						cell = row.getCell(t);
						columName.add((String) getCellValue(cell));
					}
					continue;
				}
				// 遍历每一行的单元格,map的key为列名,value为单元格内容
				Map<String, Object> map = new HashMap<String, Object>();
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					cell = row.getCell(y);
					map.put(columName.get(y), getCellValue(cell));
				}
				list.add(map);
			}
		}
		return list;
	}

	/**
	 * 根据文件后缀,创建对应的Workbook对象
	 * 
	 * @param in
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbook(InputStream in, String fileName)
			throws Exception {
		Workbook wb = null;
		String fileType = fileName.substring(fileName.lastIndexOf(".")); // 获取文件后缀
		if (excel_2003.equals(fileType)) {
			wb = new HSSFWorkbook(in);
		} else if (excel_2007.equals(fileType)) {
			wb = new XSSFWorkbook(in);
		} else {
			throw new Exception("文件格式解析错误!");
		}
		return wb;
	}

	/**
	 * 对单元格数值进行格式化
	 * 
	 * @param cell
	 * @return
	 */
	public static Object getCellValue(Cell cell) {
		Object value = null;
		DecimalFormat df = new DecimalFormat("0"); // 格式化number和String字符
		DecimalFormat df_double = new DecimalFormat("0.00"); // 格式化数字
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 格式化日期

		switch (cell.getCellType()) { // 获取单元格类型
		case Cell.CELL_TYPE_STRING:
			value = cell.getRichStringCellValue().getString();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			// 判断是否是常数/日期/双精度型
			if ("General".equals(cell.getCellStyle().getDataFormatString())) {
				value = df.format(cell.getNumericCellValue());
			} else if (HSSFDateUtil.isCellDateFormatted(cell)) {
				value = sdf.format(cell.getDateCellValue());
			} else {
				value = df_double.format(cell.getNumericCellValue());
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = cell.getBooleanCellValue();
			break;
		default:
			break;
		}
		return value;
	}
}
