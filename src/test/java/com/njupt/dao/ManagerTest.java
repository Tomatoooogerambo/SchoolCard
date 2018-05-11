package com.njupt.dao;

import com.njupt.entity.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 越 on 2018/5/11.
 */
@ContextConfiguration("classpath:/spring/applicationContext-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ManagerTest {
    @Autowired
    private ManagerDao managerDao;
    public String jobNumber = "20000001";
    public String password = "1111111111";

    @Test
    public void testHasMatchRecord() {
        int count = managerDao.hasMatchRecord(jobNumber, password);
        System.out.println(count);
    }

    @Test
    public void testgetMatchRecord() {
        Manager manager = new Manager();

        manager = managerDao.getMatchRecord(jobNumber, password);
        System.out.println(manager);
    }
}
