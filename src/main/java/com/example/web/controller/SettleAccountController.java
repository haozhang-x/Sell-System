package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhang on 2017/7/14.
 */
@Controller

public class SettleAccountController {
    @RequestMapping("/settleAccount")
    public String settleAccount() {
        return "settleAccount";
    }
}
