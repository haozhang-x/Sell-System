package com.example.web.controller.api;

import com.example.model.UserDO;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by zhang on 2017/7/13.
 */
@Controller
@RequestMapping("/api")
public class LoginApiController {
    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap login(UserDO user,
                          ModelMap modelMap, HttpSession httpSession) {
        if (loginService.login(user)) {
            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", true);
            httpSession.setAttribute("user", user);
        } else {
            modelMap.addAttribute("code", 401);
            modelMap.addAttribute("message", "failed");
            modelMap.addAttribute("result", false);
        }
        return modelMap;
    }
}
