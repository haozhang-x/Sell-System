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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zhang on 2017/6/30.
 */
@Controller
public class ShowController {
    private ProductService productService;
    private TransactionService transactionService;


    @Autowired
    public void setProductService(ProductService productService, TransactionService transactionService) {
        this.productService = productService;
        this.transactionService = transactionService;
    }


    @RequestMapping("/show")
    public ModelAndView show(@RequestParam("pid") Integer pid, ModelMap modelMap, HttpSession httpSession) {
        modelMap.addAttribute("title", "详情");
        ProductDTO productDTO = new ProductDTO();
        if (httpSession.getAttribute("user") != null) {
            UserDO user = (UserDO) httpSession.getAttribute("user");
            Integer userType = user.getUserType();
            Integer uid = user.getUid();
            Integer isBuy = 0;
            Float buyPrice = 0f;
            Integer isSell = 0;
            List<TransactionDO> transactions = transactionService.getTransactionByUId(uid);
            for (TransactionDO transaction : transactions) {
                Integer productId = -1;
                productId = transaction.getProductId();
                if (userType == 0) {
                    if (productId.equals(pid)) {
                        isBuy = 1;
                        buyPrice = transaction.getPrice();
                    }
                } else {
                    if (productId.equals(pid)) {
                        isSell = 1;
                    }
                }
            }
            productDTO.setIsBuy(isBuy);
            productDTO.setIsSell(isSell);
            productDTO.setBuyPrice(buyPrice);
        }
        ProductDO product = productService.getProductById(pid);
        BeanUtils.copyProperties(product, productDTO);
        modelMap.addAttribute("product", productDTO);
        return new ModelAndView("show", modelMap);
    }
}
