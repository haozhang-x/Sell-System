package com.example.service.impl;

import com.example.dao.ProductDAO;
import com.example.model.ProductDO;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2017/7/8.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<ProductDO> listProduct() {
        return productDAO.listProduct();
    }

    public ProductDO getProductById(Integer pid) {
        return productDAO.getProduct(pid);
    }

    public ProductDO saveProduct(ProductDO productDO) {
        Integer count = productDAO.countAllProduct();
        productDAO.saveProduct(productDO);
        if ((count + 1) == productDAO.countAllProduct()) {
            return productDAO.getLastProduct();
        } else return null;
    }

    public ProductDO updateProduct(ProductDO productDO) {
        Integer pid = productDO.getPid();
        productDAO.updateProduct(productDO);
        return productDAO.getProduct(pid);
    }
}
