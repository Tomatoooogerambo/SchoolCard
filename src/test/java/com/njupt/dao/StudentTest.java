package com.njupt.dao;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.njupt.entity.Student;
import com.njupt.service.MessageService;
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

    /**
     * Created by 越 on 2018/5/9.
     */
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:/spring/applicationContext-service.xml")
    public static class MessageServiceTest {
        private MessageService messageService;

        @Autowired
        public void setMessageService(MessageService messageService) {
            this.messageService = messageService;
        }

        public void testSendSms() throws ClientException, InterruptedException {
            Student student = new Student();
            student.setTelNumber("15195881862");
            student.setName("意谦");
            SendSmsResponse response = messageService.sendSms(student);
            System.out.println("短信接口返回的数据----------------");
            System.out.println("Code=" + response.getCode());
            System.out.println("Message=" + response.getMessage());
            System.out.println("RequestId=" + response.getRequestId());
            System.out.println("BizId=" + response.getBizId());

            Thread.sleep(3000L);
        }
    }
}
