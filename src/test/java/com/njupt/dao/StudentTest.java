package com.njupt.dao;

import com.njupt.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 越 on 2018/4/30.
 */

@ContextConfiguration("classpath:/spring/applicationContext-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentTest {
    private StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Test
    public void testTetRecordByUserId() {
        int count = studentDao.getRecordByIsLost(true);
        System.out.println(count);
    }

    @Test
    public void testGetMatchNumberByUserId() {
        String userId_1 = "20143606";
        String userId_2 = "20143601";
        boolean result1 = studentDao.getMatchNumberByUserId(userId_1);
        boolean result2 = studentDao.getMatchNumberByUserId(userId_2);
        System.out.println("user_1 in the table: " + result1);
        System.out.println("user_2 in the table: " + result2);
    }

    @Test
    public void testGetMatchNumberByMacNum() {
        String macNumber1 = "2158540800";
        String macNumber2 = "2158540801";
        boolean b1 = studentDao.getMatchNumberByMacNum(macNumber1);
        boolean b2 = studentDao.getMatchNumberByMacNum(macNumber2);
        System.out.println("user_1 in the table: " + b1);
        System.out.println("user_2 in the table: " + b2);
    }

    @Test
    public void testGetRecordByUserId() {
        String userId = "20143606";
        Student student = studentDao.getRecordByUserId(userId);
        System.out.println(student);
    }

    @Test
    public void testGetRecordByMacNumber() {
        String macNumber = "2158540800";
        Student student = studentDao.getRecordByMacNumber(macNumber);
        System.out.println(student);
    }

    @Test
    public void testSetUpdateStatusLostByMacNumber() {
        String macNumber = "2158540800";
        studentDao.setUpdateStatusLostByMacNumber(macNumber);
    }

    @Test
    public void testSetUpdateStatusLostById() {
        String uerId = "20143606";
        studentDao.setUpdateStatusLostById(uerId);
    }

    @Test
    public void testGetLostCardList() {
        List<Student> students = studentDao.getAllStudentRecords();
        for(Student s : students)
            System.out.println(s);
    }

    @Test
    public void testSetCardFindBack() {
        studentDao.setCardFindBack("20143606");
        System.out.println(studentDao.getRecordByUserId("20143606"));
    }
}
