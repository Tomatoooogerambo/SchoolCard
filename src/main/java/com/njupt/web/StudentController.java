package com.njupt.web;

import com.njupt.entity.Student;
import com.njupt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping(value = "/index.html")
    public String setLoginPage() {
        return "start";
    }

    @RequestMapping(value = "/checkForm.html")
    public ModelAndView checkFormByMacNumber(HttpServletRequest request) {
        if(studentService.checkValidMacNumber(request.getParameter("macNumber"))) {
            Student student = studentService.getRecordByMacNuber(request.getParameter("macNumber"));
            request.getSession().setAttribute("student", student);
            return new ModelAndView("searchResult");
        }else{
            return new ModelAndView("start","error","卡号不存在");
        }
    }

}
