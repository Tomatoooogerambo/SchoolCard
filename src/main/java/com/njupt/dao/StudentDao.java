package com.njupt.dao;

import com.njupt.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 越 on 2018/4/27.
 */
@Repository
public class StudentDao {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    private final static String SELECT_COUNT_ISLOST = "SELECT COUNT(*) FROM stu_info" +
                                                        " WHERE isLost=?";

    private final static String SELECT_COUONT_MATCH_ID = "SELECT COUNT(*) FROM stu_info" +
                                                            " WHERE user_Id=?";

    private final static String SELECT_COUNT_MATCH_MACNUM = "SELECT COUNT(*) FROM stu_info" +
                                                            " WHERE mac_num=?";

    private final static String SELECT_RECORD_BY_ID = "SELECT * FROM stu_info" +
                                                        " WHERE user_Id=?";

    private final static String SELECT_RECORD_BY_MACNUMBER = "SELECT * FROM stu_info" +
                                                            " WHERE mac_num=?";

    private final static String UPDATE_STATUSLOST_BY_MACNUMBER = "UPDATE stu_info" +
                                                            " SET isLost=1 WHERE mac_num=?";

    private final static String UPDATE_STATUSLOST_BY_ID = "UPDATE stu_info" +
                                                            " SET isLost=1 WHERE user_Id=?";

    private final static String SELECT_ALL_STUDENTS = "SELECT * FROM stu_info ";

    private final static String UPDATE_STATUS_FINDBACK = " UPDATE stu_info" +
                                                            " SET isLost=0 WHERE user_Id=?";
    /**
     * 按照丢失的状态查询数量
     * @param isLost
     * @return
     */
    public int getRecordByIsLost(boolean isLost) {
        return jdbcTemplate.queryForObject(SELECT_COUNT_ISLOST, new Object[]{ isLost}, Integer.class);
    }

    /**
     * 查询该学号是否存在
     * @param userId
     * @return
     */
    public boolean getMatchNumberByUserId(String userId) {
        return jdbcTemplate.queryForObject(SELECT_COUONT_MATCH_ID, new Object[]{userId}, Integer.class) > 0;
    }

    /**
     * 查询该校园卡的物理值是否存在
     * @param macNumber
     * @return
     */
    public boolean getMatchNumberByMacNum(String macNumber) {
        return jdbcTemplate.queryForObject(SELECT_COUNT_MATCH_MACNUM, new Object[]{macNumber}, Integer.class) > 0;
    }

    /**
     * 按照学号查询对应的记录
     * @param userId
     * @return
     */
    public Student getRecordByUserId(final String userId) {
        final Student student = new Student();
        jdbcTemplate.query(
                SELECT_RECORD_BY_ID,
                new Object[]{userId},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        student.setName(resultSet.getString("name"));
                        student.setCollege(resultSet.getString("college"));
                        student.setMajor(resultSet.getString("major"));
                        student.setUserId(userId);
                        student.setMacNumber(resultSet.getString("mac_num"));
                        student.setLost(resultSet.getBoolean("isLost"));
                        student.setTelNumber(resultSet.getString("telNum"));
                    }
                }
        );
        return student;
    }

    /**
     *  按照校园卡物理值得到对应的学生信息
     * @param macNumber
     * @return
     */
    public Student getRecordByMacNumber(final String macNumber) {
        final Student student = new Student();
        jdbcTemplate.query(
                SELECT_RECORD_BY_MACNUMBER,
                new Object[]{macNumber},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        student.setName(resultSet.getString("name"));
                        student.setCollege(resultSet.getString("college"));
                        student.setMajor(resultSet.getString("major"));
                        student.setUserId(resultSet.getString("user_Id"));
                        student.setMacNumber(macNumber);
                        student.setLost(resultSet.getBoolean("isLost"));
                        student.setTelNumber(resultSet.getString("telNum"));
                    }
                }
        );
        return student;
    }

    /**
     * 按照校园卡物理卡号对表中数据进行更新
     * @param macnumber
     */
    public void setUpdateStatusLostByMacNumber(String macnumber) {
        jdbcTemplate.update(UPDATE_STATUSLOST_BY_MACNUMBER, new Object[]{macnumber});
    }

    /**
     * 按照校园卡学号对表中数据进行更新
     * @param userId
     */
    public void setUpdateStatusLostById(String  userId) {
        jdbcTemplate.update(UPDATE_STATUSLOST_BY_ID, new Object[]{userId});
    }

    /**
     * 获取表中所有记录
     * @return
     */
    public List<Student> getAllStudentRecords() {
        List<Student> students = jdbcTemplate.query(
                SELECT_ALL_STUDENTS,
                new ResultSetExtractor<List<Student>>() {
                    @Override
                    public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        List<Student> students = new ArrayList<>();
                        while(resultSet.next()) {
                            Student student = new Student();
                            student.setName(resultSet.getString("name"));
                            student.setCollege(resultSet.getString("college"));
                            student.setMajor(resultSet.getString("major"));
                            student.setUserId(resultSet.getString("user_Id"));
                            student.setMacNumber(resultSet.getString("mac_num"));
                            student.setLost(resultSet.getBoolean("isLost"));
                            student.setTelNumber(resultSet.getString("telNum"));
                            students.add(student);
                        }
                        return students;
                    }
                }
        );
        return students;
    }

    public void setCardFindBack(String num) {
        jdbcTemplate.update(UPDATE_STATUS_FINDBACK, new Object[]{num});
    }
}
