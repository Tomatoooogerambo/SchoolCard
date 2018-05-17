package com.njupt.service;

import com.njupt.dao.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 越 on 2018/5/11.
 */
@Service
public class ManagerService {
    @Autowired
    private ManagerDao managerDao;

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    public boolean isValidManager(String managerJobNumber, String password) {
        return managerDao.hasMatchRecord(managerJobNumber,password) > 0;
    }

}
