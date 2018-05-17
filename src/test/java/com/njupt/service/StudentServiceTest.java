package com.njupt.service;

import com.alibaba.fastjson.JSONArray;
import com.njupt.dao.StudentDao;
import com.njupt.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 越 on 2018/5/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/applicationContext-service.xml")
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testGetLostCardListInJSON() {
        JSONArray jsonArray = studentService.getLostCardListInJSON();
        System.out.println(jsonArray.toString());
    }

    @Test
    public void testGetAllStudents() {
        for(Student s : studentService.getAllStudents()) 
            System.out.println(s);

    }

    @Test
    public void testGetStudentLostRecord() {
        String s = "20143606";
        System.out.println(studentService.getStudentLostRecord(s));
    }

    @Test
    public void testSetCardFindBack() {
        String s = "20143606";
        studentService.setCardFindBack(s);
        System.out.println(studentDao.getRecordByUserId(s));
    }

}
