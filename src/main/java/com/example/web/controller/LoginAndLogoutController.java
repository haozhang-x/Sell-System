package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by zhang on 2017/6/29.
 */
@Controller
public class LoginAndLogoutController {

    @ModelAttribute("title")
    private void setTitle(ModelMap modelMap) {
        modelMap.addAttribute("title", "登录");
    }

    @RequestMapping(value = "/login")
    public String login(ModelMap modelMap) {
        return "login";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "login";
    }


}
