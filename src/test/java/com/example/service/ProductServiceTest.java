package com.example.service;

import com.example.dto.ProductDTO;
import com.example.model.ProductDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhang on 2017/7/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Test
    public void listProduct() throws Exception {
        List<ProductDO> productDTOS = productService.listProduct();
    }

}