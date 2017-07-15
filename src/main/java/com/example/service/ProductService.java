package com.example.service;

import com.example.model.ProductDO;

import java.util.List;

/**
 * Created by zhang on 2017/7/8.
 */
public interface ProductService {
    List<ProductDO> listProduct();

    ProductDO getProductById(Integer pid);

    ProductDO saveProduct(ProductDO productDO);

    ProductDO updateProduct(ProductDO productDO);

    void deleteProduct(Integer pid);

}
