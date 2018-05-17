package com.njupt.web;

import com.aliyuncs.exceptions.ClientException;
import com.njupt.entity.Student;
import com.njupt.service.ManagerService;
import com.njupt.service.MessageService;
import com.njupt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 越 on 2018/5/7.
 */
@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MessageService messageService;


    @RequestMapping(value = "managerLogin.html")
    public ModelAndView loginCheck(HttpServletRequest request) {
        String jobNumber = request.getParameter("jobNumber");
        String password = request.getParameter("passWord");
        if(managerService.isValidManager(jobNumber, password)) {
            List<Student> students = studentService.getAllStudents();
            request.getSession().setAttribute("students", students);
            return new ModelAndView("managerPage");
        }else {
            return new ModelAndView("managerLogin","wrongInfo","请输入管理员账号和密码!");
        }
    }

    @RequestMapping(value = "managerOp.html")
    public ModelAndView findMatchRecord(HttpServletRequest request) {
        String num = request.getParameter("IdOrMacNum");
        if(studentService.getStudentLostRecord(num) != null) {
            Student student = studentService.getStudentLostRecord(num);
            request.getSession().setAttribute("student", student);
            request.getSession().setAttribute("single","single");
            return new ModelAndView("managerPage");
        }else{
            return new ModelAndView("managerPage", "nullRecord", "暂未有相应校园卡的丢失记录");
        }
    }

    @RequestMapping(value = "sendMessage")
    public ModelAndView sendMessage(HttpServletRequest request) throws ClientException{
        Student student = (Student) request.getSession().getAttribute("student");
        messageService.sendSms(student);
        return new ModelAndView("managerPage");
    }

    @RequestMapping(value = "markToFind")
    public ModelAndView markToFind(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Student student = (Student) request.getSession().getAttribute("student");
        studentService.setCardFindBack(student.getUserId());
        request.getSession().setAttribute("student", null);
        return new ModelAndView("managerPage");
    }

    @RequestMapping(value = "addLostRecord")
    public ModelAndView addLostRecord(HttpServletRequest request) throws ClientException {
        String macNum = request.getParameter("macNum");
        if(studentService.checkValidMacNumber(macNum)) {
            studentService.setCardStatusByMacNum(macNum);
            messageService.sendSms(studentService.getRecordByMacNuber(macNum));
            request.getSession().setAttribute("hasAdd","Ok");
            request.getSession().setAttribute("student",studentService.getRecordByMacNuber(macNum));
            return new ModelAndView("managerPage");
        }else{
            request.getSession().setAttribute("hasAdd","No");
            return new ModelAndView("managerPage");
        }
    }

    @RequestMapping(value = "queryAll")
    public ModelAndView queryAll(HttpServletRequest request) {
        List<Student> students = studentService.getAllStudents();
        request.getSession().setAttribute("students",students);
        request.getSession().setAttribute("flag","all");
        return new ModelAndView(("managerPage"));
    }

}
