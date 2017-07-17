package com.example.web.controller.api;

import com.example.service.ProductService;
import com.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhang on 2017/7/14.
 */
@Controller
@RequestMapping("/api")
public class DeleteProductApiController {
    private ProductService productService;
    private TransactionService transactionService;

    @Autowired
    public void setProductService(ProductService productService, TransactionService transactionService) {
        this.productService = productService;
        this.transactionService = transactionService;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ModelMap delete(@RequestParam("id") Integer pid, ModelMap modelMap) {
        if (transactionService.getTransactionByPId(pid) == null) {
            productService.deleteProduct(pid);
            if (productService.getProductById(pid) == null) {
                modelMap.addAttribute("code", 200);
                modelMap.addAttribute("message", "success");
                modelMap.addAttribute("result", true);
            } else {
                modelMap.addAttribute("code", 400);
                modelMap.addAttribute("message", "删除失败");
                modelMap.addAttribute("result", false);
            }
        } else {
            modelMap.addAttribute("code", 400);
            modelMap.addAttribute("message", "商品存在交易，删除失败");
            modelMap.addAttribute("result", false);
        }


        return modelMap;
    }
}
