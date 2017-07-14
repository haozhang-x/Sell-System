package com.example.web.controller;

import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by zhang on 2017/6/29.
 */
@Controller
public class LoginAndLogoutController {

    private LoginService loginService;

    @Autowired
    private void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("title", "登录");
        return "login";
    }


    @RequestMapping("/logout")
    public String logout(ModelMap modelMap, HttpSession httpSession) {
        httpSession.removeAttribute("user");
        modelMap.addAttribute("title", "登录");
        return "login";
    }


}
