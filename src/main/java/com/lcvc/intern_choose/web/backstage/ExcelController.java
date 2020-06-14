package com.lcvc.intern_choose.web.backstage;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.TeacherStudent;
import com.lcvc.intern_choose.service.StudentService;
import com.lcvc.intern_choose.service.TeacherService;
import com.lcvc.intern_choose.service.TeacherStudentService;
import com.lcvc.intern_choose.util.poi.ExcelWirteForTable;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 专门处理9个表的内容，并将其用excel导出
 * https://blog.csdn.net/shrek11/article/details/88988638
 */
@RestController
@RequestMapping(value = "/api/backstage/excel")
public class ExcelController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherStudentService teacherStudentService;
    /**
     * 通过流的方式输出excle到页面，每个文件都要下载
     *
     * @param response 响应
     * @param workbook 表对象
     * @param fileName 文件名，下载时显示的文件名
     */
    private void outExcelStream(HttpServletResponse response, Workbook workbook, String fileName) {
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            response.setContentType("application/x-download");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xlsx");
            workbook.write(os);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取教师的信息
    @GetMapping("/teacher")
    public String getTeacherTable(HttpServletResponse response){
        List<Teacher> list=teacherService.readAll(null);
        //导出表格
        XSSFWorkbook book= ExcelWirteForTable.getTeacherSheet(list);//根据记录，生成excel表格
        //创建文件对象，导出
        this.outExcelStream(response,book," 教师信息表");
        return "SUCCESS";//这里其实就是随意返回一个字符串
    }

    //获取教师的信息
    @GetMapping("/student")
    public String student(HttpServletResponse response){
        List<Student> list=studentService.readAll(null);
        //导出表格
        XSSFWorkbook book= ExcelWirteForTable.getStudentSheet(list);//根据记录，生成excel表格
        //创建文件对象，导出
        this.outExcelStream(response,book," 学生信息表");
        return "SUCCESS";//这里其实就是随意返回一个字符串
    }

    //获取已选择的实习老师的学生信息
    @GetMapping("/teacherStudent")
    public String teacherStduent(HttpServletResponse response){
        List<TeacherStudent> list=teacherStudentService.readAll(null);
        //导出表格
        XSSFWorkbook book= ExcelWirteForTable.getTeacherStudentSheet(list);//根据记录，生成excel表格
        //创建文件对象，导出
        this.outExcelStream(response,book," 实习学生信息表");
        return "SUCCESS";//这里其实就是随意返回一个字符串
    }
}
