package com.example.web.controller.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.model.UserDO;
import com.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zhang on 2017/7/14.
 */
@Controller
@RequestMapping("/api")
public class BuyProductApiController {
    private TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping("/buy")
    @ResponseBody
    public ModelMap buy(@RequestBody String data, ModelMap modelMap, HttpSession httpSession) {
        Integer userId = -1;
        if (httpSession.getAttribute("user") != null) {
            UserDO user = (UserDO) httpSession.getAttribute("user");
            userId = user.getUid();
            System.out.println(data);


            List<JSONObject> jsonObjectList = JSON.parseArray(data, JSONObject.class);
            for (JSONObject jsonObject : jsonObjectList) {
                String id = jsonObject.getString("id");
                String number = jsonObject.getString("number");
                System.out.println(jsonObject.toString());
                transactionService.saveTransaction(Integer.valueOf(id), Integer.valueOf(number), userId);
            }


            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", true);
        } else {
            modelMap.addAttribute("code", 400);
            modelMap.addAttribute("message", "failed");
            modelMap.addAttribute("result", false);
        }

        return modelMap;
    }
}
