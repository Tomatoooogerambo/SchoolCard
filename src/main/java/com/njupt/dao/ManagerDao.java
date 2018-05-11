package com.njupt.dao;

import com.njupt.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 越 on 2018/5/11.
 */
@Repository
public class ManagerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String HAS_MATCH_RECORD = "SELECT COUNT(*) FROM manager" +
                                                    " WHERE ma_jobnumber=? AND ma_password=?";

    private static final String GET_MATCH_RECORD = "SELECT * FROM manager " +
                                                    "WHERE ma_jobnumber=? AND ma_password=?";

    /**
     * 验证登陆信息
     * @param jobNumber
     * @param passWord
     * @return
     */
    public int hasMatchRecord(String jobNumber, String passWord) {
        return jdbcTemplate.queryForObject(HAS_MATCH_RECORD, new Object[]{jobNumber, passWord}, Integer.class);
    }

    /**
     * 返回相应的管理员对象
     * @param jobNumber
     * @param passWord
     * @return
     */
    public Manager getMatchRecord(final String jobNumber, String passWord) {
        final Manager manager = new Manager();
        jdbcTemplate.query(
                GET_MATCH_RECORD,
                new Object[]{jobNumber, passWord},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        manager.setManagerJobNumber(jobNumber);
                        manager.setSchoolDistrict(resultSet.getString("school_district"));
                        manager.setPosition(resultSet.getString("ma_position"));
                    }
                }
        );
        return manager;
    }
}
