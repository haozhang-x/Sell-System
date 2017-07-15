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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    public String index(Integer type, ModelMap modelMap, HttpSession httpSession) {
        modelMap.addAttribute("listType", 0);
        if (type != null) {
            System.out.println(type);
            if (type.equals(1)) {
                modelMap.addAttribute("listType", 1);
            }
        }


        List<ProductDO> products = productService.listProduct();
        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();

        for (ProductDO product : products) {

            ProductDTO p = new ProductDTO();
            BeanUtils.copyProperties(product, p);

            if (httpSession.getAttribute("user") != null) {
                UserDO user = (UserDO) httpSession.getAttribute("user");
                Integer userType = user.getUserType();
                Integer uid = user.getUid();

                Integer isBuy = 0;
                Integer isSell = 0;
                Integer productId = -1;
                if (userType == 0) {
                    List<TransactionDO> transactions = transactionService.getTransactionByUId(uid);
                    for (TransactionDO transaction : transactions) {
                        productId = transaction.getProductId();
                        if (productId.equals(product.getPid())) {
                            isBuy = 1;
                        }
                    }
                }
                if (userType == 1) {
                    List<TransactionDO> transactions = transactionService.getTransactionByPId(product.getPid());
                    for (TransactionDO transaction : transactions) {
                        if (transaction != null) {
                            productId = transaction.getProductId();
                        }
                        if (productId.equals(product.getPid())) {
                            isSell = 1;
                        }
                    }
                }
                p.setIsBuy(isBuy);
                p.setIsSell(isSell);
                System.out.println(p.toString());
            }
            productDTOS.add(p);
        }
        modelMap.addAttribute("productList", productDTOS);
        modelMap.addAttribute("title", "主页");
        return "index";
    }
}
