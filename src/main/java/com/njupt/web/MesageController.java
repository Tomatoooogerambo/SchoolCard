package com.njupt.web;

import com.njupt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 越 on 2018/5/7.
 */
@RestController
public class MesageController {
    // 使用网易云短信网关服务
    //发送验证码的请求路径URL
    private static final String
            SERVER_URL="https://api.netease.im/sms/sendtemplate.action";
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private static final String
            APP_KEY="98240c288015e3c3b0b4adcb89bd4b24";
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private static final String APP_SECRET="db3db19dd0fb";
    //随机数
    private static final String NONCE="123456";
    //短信模板ID
    private static final String TEMPLATEID="";
    //手机号
    private static final String MOBILE="13888888888";
    StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping(value="messageManager.html")
    public ModelAndView SendMessage(HttpServletRequest request) {
        if(studentService.checkValidMacNumber(request.getParameter("macNumber"))) {

        }
        return null;
    }

}
