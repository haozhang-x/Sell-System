package com.example.service.impl;

import com.example.model.UserDO;
import com.example.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhang on 2017/7/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class LoginServiceImplTest {
    @Autowired
    LoginService loginService;

    @Test
    public void login() throws Exception {
        UserDO userDO = new UserDO();
        userDO.setUserName("seller");
        userDO.setPassWord("981c57a5cfb0f868e064904b8745766f");
        if (loginService.login(userDO)){
            System.out.println("success");
            String s = userDO.toString();
            System.out.println(s);
        }

    }

}