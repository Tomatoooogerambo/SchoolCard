package com.njupt.service;

import com.alibaba.fastjson.JSONArray;
import com.njupt.dao.StudentDao;
import com.njupt.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 越 on 2018/5/3.
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;


    public boolean checkValidId(String userId) {
        return studentDao.getMatchNumberByUserId(userId);
    }

    public boolean checkValidMacNumber(String macNumber){
        return studentDao.getMatchNumberByMacNum(macNumber);
    }

    public Student getRecordByMacNuber(String macNumber) {
        return studentDao.getRecordByMacNumber(macNumber);
    }
    /**
     * 按照校园卡的物理卡号进行卡丢失状态设置
     * @param macNum
     */
    @Transactional
    public void setCardStatusByMacNum(String macNum) {
        if(studentDao.getMatchNumberByMacNum(macNum)) {
            studentDao.setUpdateStatusLostByMacNumber(macNum);
        }
    }

    /**
     * 按照校园卡的学号进行卡丢失状态的设置
     * @param userId
     */
    @Transactional
    public void setCardStatusById(String userId) {
        if(studentDao.getMatchNumberByUserId(userId)) {
            studentDao.setUpdateStatusLostById(userId);
        }
    }

    /**
     * 将丢失的卡标记为已经找回状态
     * @param userId
     */
    public void setCardFindBack(String userId) {
            studentDao.setCardFindBack(userId);
    }
    /**
     * 获取表中所有记录
     * 分装成JSON格式
     * @return
     */
    @Transactional
    public JSONArray getLostCardListInJSON() {
        List<Student> students = studentDao.getAllStudentRecords();
        JSONArray jsonArrayStudents = new JSONArray();
        for(Student s : students) {
            jsonArrayStudents.add(s);
        }
        return jsonArrayStudents;
    }

    /**
     * 得到所有标记为丢失的校园卡记录
     * @return
     */
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        List<Student> allStudents = studentDao.getAllStudentRecords();
        for(Student s : allStudents) {
            if(s.isLost() == true)
                students.add(s);
        }
        return students;
    }

    public Student getStudentLostRecord(String num) {
        Student student = null;
        if(studentDao.getMatchNumberByMacNum(num)) {
            student = studentDao.getRecordByMacNumber(num);
            return student.isLost() == true ? student : null;
        }

        if(studentDao.getMatchNumberByUserId(num)) {
            student = studentDao.getRecordByUserId(num);
            return student.isLost() == true ? student : null;
        }
        return student;
    }

}
