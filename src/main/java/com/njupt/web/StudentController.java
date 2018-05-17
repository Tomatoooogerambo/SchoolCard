package com.njupt.web;

import com.njupt.entity.Student;
import com.njupt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 越 on 2018/5/3.
 */
@RestController
public class StudentController  {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 设置起始页面
     * @return
     */
    @RequestMapping(value = "/verifyCard")
    public String setLoginPage() {
        return "verifyCard";
    }

    @RequestMapping(value = "verifyCard.html" )
    public ModelAndView checkFormByMacNumber(HttpServletRequest request) {
        if(studentService.checkValidMacNumber(request.getParameter("macNumber"))) {
            Student student = studentService.getRecordByMacNuber(request.getParameter("macNumber"));
            request.getSession().setAttribute("student", student);
            request.getSession().setAttribute("flag","single");
            return new ModelAndView("searchResult");
        }else{
            return new ModelAndView("verifyCard","error","暂未由此卡的信息，请重试");
        }
    }

    @RequestMapping(value = "requestForAll.html" )
    public ModelAndView requestForAll(HttpServletRequest request) {
        List<Student> students = studentService.getAllStudents();
        request.getSession().setAttribute("students", students);
        request.getSession().setAttribute("flag","all");
        return  new ModelAndView("searchResult");
    }

}
