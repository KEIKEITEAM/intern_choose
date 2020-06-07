package com.lcvc.intern_choose.util.poi;


import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.TeacherStudent;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 负责处理所有要导出的表格
 */
@Service
public class ExcelWirteForTable {

    /**
     * 学生信息表
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getStudentSheet(List<Student> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForStudentSheet.getShee(book,list);
        return book;
    }

    /**
     * 教师信息表
     * @param list 要遍历的数据集合
     */
    public static XSSFWorkbook getTeacherSheet(List<Teacher> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForTeacherSheet.getShee(book,list);
        return book;
    }

    public static XSSFWorkbook getTeacherStudentSheet(List<TeacherStudent> list) {
        // 创建工作簿
        XSSFWorkbook book = new XSSFWorkbook();
        // 创建工作表1
        ExcelWirteForTeacherStudentSheet.getShee(book,list);
        return book;
    }
}
