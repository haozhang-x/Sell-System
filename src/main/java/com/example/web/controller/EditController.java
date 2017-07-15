package com.example.web.controller;

import com.example.model.ProductDO;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhang on 2017/6/30.
 */
@Controller
public class EditController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam("pid") Integer pid, ModelMap modelMap) {
        ProductDO product = productService.getProductById(pid);
        modelMap.addAttribute("product", product);
        return new ModelAndView("edit", modelMap);
    }

    @RequestMapping("/editSubmit")
    public ModelAndView editSubmit(@RequestParam("pid") Integer pid, ProductDO productDO, ModelMap modelMap) {
        productService.updateProduct(productDO);
        ProductDO product = productService.getProductById(pid);
        return new ModelAndView("editSubmit",
                modelMap.addAttribute("product", product));
    }
}
