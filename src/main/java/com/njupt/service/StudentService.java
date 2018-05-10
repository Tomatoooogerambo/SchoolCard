package com.njupt.service;

import com.alibaba.fastjson.JSONArray;
import com.njupt.dao.StudentDao;
import com.njupt.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 越 on 2018/5/3.
 */
@Service
public class StudentService {
    private StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

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

    public Student getStudentRecordByMacNumber(String macNumber) {
        return studentDao.getRecordByMacNumber(macNumber);
    }
}
