package com.njupt.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 越 on 2018/5/7.
 */
@RestController
public class ManagerController {
    @RequestMapping(value = "managerLogin.html")
    public ModelAndView loginCheck(String jobNumber, String passWord) {

        return null;
    }

}
