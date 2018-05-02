package njupt.colom.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by 越 on 2018/4/27.
 */
@Repository
public class StudentDao {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    private final static String SELECT_COUNT_ISLOST = "SELECT COUNT(*) FROM stu_info" +
                                                " WHERE isLost=?";

    public int getRecordByIsLost(boolean isLost) {
        return jdbcTemplate.queryForObject(SELECT_COUNT_ISLOST, new Object[]{ isLost}, Integer.class);
    }
}
