package com.example.web.controller;

import com.example.model.ProductDO;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhang on 2017/6/30.
 */
@Controller
public class PublicController {
    private ProductService productService;

    @ModelAttribute("title")
    private void setTitle(ModelMap modelMap) {
        modelMap.addAttribute("title", "发布");
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/public")
    public ModelAndView publicSells() {
        return new ModelAndView("public");
    }

    @RequestMapping(value = "/publicSubmit", method = RequestMethod.POST)
    public ModelAndView publicSubmit(ProductDO product, ModelMap modelMap) {
        ProductDO productDO = productService.saveProduct(product);
        return new ModelAndView("publicSubmit", modelMap.addAttribute("product", productDO));
    }
}
