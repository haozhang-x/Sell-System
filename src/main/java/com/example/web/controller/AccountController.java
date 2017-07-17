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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/6/30.
 */
@Controller
public class AccountController {
    private TransactionService transactionService;
    private ProductService productService;

    @Autowired
    public void setTransactionService(TransactionService transactionService, ProductService productService) {
        this.transactionService = transactionService;
        this.productService = productService;
    }

    @RequestMapping(value = "/account")
    public ModelAndView account(ModelMap modelMap, HttpSession httpSession) {
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        if (httpSession.getAttribute("user") != null) {
            UserDO user = (UserDO) httpSession.getAttribute("user");
            Integer uid = user.getUid();
            List<TransactionDO> transactions = transactionService.getTransactionByUId(uid);
            if (transactions != null) {
                for (TransactionDO transaction : transactions) {
                    ProductDTO productDTO = new ProductDTO();
                    Float price = transaction.getPrice();
                    Timestamp time = transaction.getTime();
                    Integer productId = transaction.getProductId();
                    ProductDO product = productService.getProductById(productId);
                    BeanUtils.copyProperties(product, productDTO);
                    productDTO.setBuyPrice(price);
                    productDTO.setBuyTime(time);
                    productDTO.setBuyNum(transactionService.countTransactionByPId(productId));
                    System.out.println(time);
                    productDTOs.add(productDTO);
                }

            }
        }


        return new ModelAndView("account", modelMap.addAttribute("buyList", productDTOs));
    }
}
