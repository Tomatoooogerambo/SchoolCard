package njupt.colom.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 越 on 2018/4/30.
 */

@ContextConfiguration("classpath:/spring/applicationContext-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StedentTest {
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
}
