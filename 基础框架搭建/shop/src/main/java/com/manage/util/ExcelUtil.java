package com.managesystem.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    /**
     * 导出Excel
     * @param
     * @param sheetName sheet名称
     * @param title 标题
     * @param content 内容
     * @return
     */
    public static XSSFWorkbook getXSSFWorkbook(String sheetName, String []title, String [][]content, XSSFWorkbook workBook){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        /*if(wb == null){
            wb = new HSSFWorkbook();
        }*/
        if(workBook == null){
            workBook = new XSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
       /* HSSFSheet sheet = wb.createSheet(sheetName);*/
        XSSFSheet sheet=workBook.createSheet();

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        /*HSSFRow row = sheet.createRow(0);*/
        workBook.setSheetName(0,"学生信息");

        XSSFRow titleRow = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        /*HSSFCellStyle style = wb.createCellStyle();*/
        for(int i=0;i<title.length;i++){
            titleRow.createCell(i).setCellValue(title[i]);
        }
    /*    style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式*/

        //声明列对象
        /*HSSFCell cell = null;*/

        //创建标题
        /*for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }*/

        //创建内容
        for(int i=0;i<content.length;i++){
            XSSFRow row = sheet.createRow(i+1);
            /*row = sheet.createRow(i + 1);*/
            for(int j=0;j<content[i].length;j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(content[i][j]);
            }
        }
        return workBook;
    }
}
