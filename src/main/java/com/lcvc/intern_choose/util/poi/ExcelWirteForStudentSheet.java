package com.lcvc.intern_choose.util.poi;


import com.lcvc.intern_choose.model.Student;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelWirteForStudentSheet {


    public static XSSFSheet getShee(XSSFWorkbook book, List<Student> list) {
        String[] header = {"学生信息表"};
        String[] title = {
                "学号",
                "姓名",
                "专业群",
                "年级",
                "专业",
                "班级",
                "电话号码",
                "QQ号码"
        };

        // 创建工作表
        XSSFSheet sheet = book.createSheet("Sheet1");

        // 设置单元格表单头部样式
        XSSFCellStyle headerStyle = book.createCellStyle();
        XSSFFont headerFont = book.createFont();
        headerFont.setFontHeightInPoints((short) 16);
        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER); //
        headerStyle.setWrapText(true);//自动换行
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);


        // 设置单元格表单标题样式
        XSSFCellStyle titleStyle = book.createCellStyle();
        XSSFFont titlefont = book.createFont();
        titlefont.setFontHeightInPoints((short) 12);
        titleStyle.setFont(titlefont);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER); //
        titleStyle.setWrapText(true);//自动换行


        //设置行
        //header
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints(30);//设置行的高度是50个点
        //titie
        XSSFRow titleRow = sheet.createRow(1);
        titleRow.setHeightInPoints(30);//设置行的高度是50个点


        //跨行跨列
        //header行
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, title.length - 1);
        sheet.addMergedRegion(region);

        //添加表头栏
        for (int i = 0; i < title.length; i++) {
            XSSFCell headerCell = headerRow.createCell(i);
            sheet.setColumnWidth(i, 10 * 256);//设置第i列的宽度是31个字符宽度
            headerCell.setCellStyle(headerStyle);
            if (i == 0) {
                headerCell.setCellValue(header[0]);
            }
        }

        //添加标题栏
        for (int i = 0; i < title.length; i++) {
            XSSFCell titleRowCell = titleRow.createCell(i);
            sheet.setColumnWidth(i, 10 * 256);//设置第i列的宽度是31个字符宽度
            titleRowCell.setCellStyle(titleStyle);
            titleRowCell.setCellValue(title[i]);
        }

        //list
        for (int i = 0; i < list.size(); i++) {
            //创建行
            XSSFRow listRow = sheet.createRow(i + 2);
            titleRow.setHeightInPoints(30);//设置行的高度是50个点

            //创建列
            XSSFCell listRowCell0 = listRow.createCell(0);
            //为列赋值和样式
            listRowCell0.setCellStyle(titleStyle);
            listRowCell0.setCellValue(list.get(i).getStudentNumber());

            //创建列
            XSSFCell listRowCell1 = listRow.createCell(1);
            //为列赋值和样式
            listRowCell1.setCellStyle(titleStyle);
            listRowCell1.setCellValue(list.get(i).getName());

            //创建列
            XSSFCell listRowCell2 = listRow.createCell(2);
            //为列赋值和样式
            listRowCell2.setCellStyle(titleStyle);
            listRowCell2.setCellValue(list.get(i).getClasses().getMajor().getProfessional().getName());

            //创建列
            XSSFCell listRowCell3 = listRow.createCell(3);
            //为列赋值和样式
            listRowCell3.setCellStyle(titleStyle);
            listRowCell3.setCellValue(list.get(i).getClasses().getGrades().getName());

            //创建列
            XSSFCell listRowCell4 = listRow.createCell(4);
            //为列赋值和样式
            listRowCell4.setCellStyle(titleStyle);
            listRowCell4.setCellValue(list.get(i).getClasses().getMajor().getName());

            //创建列
            XSSFCell listRowCell5 = listRow.createCell(5);
            //为列赋值和样式
            listRowCell5.setCellStyle(titleStyle);
            listRowCell5.setCellValue(list.get(i).getClasses().getName());

            //创建列
            XSSFCell listRowCell6 = listRow.createCell(6);
            //为列赋值和样式
            listRowCell6.setCellStyle(titleStyle);
            listRowCell6.setCellValue(list.get(i).getTel());

            //创建列
            XSSFCell listRowCell7 = listRow.createCell(7);
            //为列赋值和样式
            listRowCell7.setCellStyle(titleStyle);
            listRowCell7.setCellValue(list.get(i).getQq());
        }
        return sheet;
    }
}
