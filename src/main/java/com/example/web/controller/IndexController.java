package com.example.web.controller;

import com.example.dto.ProductDTO;
import com.example.model.ProductDO;
import com.example.model.TransactionDO;
import com.example.model.UserDO;
import com.example.service.ProductService;
import com.example.service.TransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.java2d.pisces.PiscesRenderingEngine;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by zhang on 2017/6/30.
 */
@Controller
public class IndexController {

    private ProductService productService;
    private TransactionService transactionService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(path = {"/", "/index"})
    public String index(ModelMap modelMap, HttpSession httpSession) {
        List<ProductDO> productDOS = productService.listProduct();
        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();

        for (ProductDO product : productDOS) {
            ProductDTO p = new ProductDTO();
            BeanUtils.copyProperties(product, p);
            if (httpSession.getAttribute("user") != null) {
                UserDO user = (UserDO) httpSession.getAttribute("user");
                Integer userType = user.getUserType();
                Integer uid = user.getUid();
                TransactionDO transaction = transactionService.getTransactionByUId(uid);
                Integer productId = -1;
                if (transaction != null) {
                    productId = transaction.getProductId();
                }
                if (userType == 0) {
                    Integer isBuy = 0;
                    if (productId.equals(product.getPid())) {
                        isBuy = 1;
                    }
                    p.setIsBuy(isBuy);
                }
                if (userType == 1) {
                    transaction = transactionService.getTransactionByPId(product.getPid());
                    if (transaction!=null){
                        productId = transaction.getProductId();
                    }
                    Integer isSell = 0;
                    if (productId.equals(product.getPid())) {
                        isSell = 1;
                    }
                    p.setIsSell(isSell);
                }


            }

            productDTOS.add(p);
            System.out.println("p:" + p.toString());
        }
        modelMap.addAttribute("productList", productDTOS);
        modelMap.addAttribute("title", "主页");
        return "index";
    }
}
