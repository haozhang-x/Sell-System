package com.example.web.controller.api;

import com.example.service.ProductService;
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

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ModelMap delete(@RequestParam("id") Integer pid, ModelMap modelMap) {
        productService.deleteProduct(pid);
        modelMap.addAttribute("code", 200);
        modelMap.addAttribute("message", "success");
        modelMap.addAttribute("result", true);
        return modelMap;
    }
}
