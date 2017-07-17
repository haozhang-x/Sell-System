package com.example.dao;

import com.example.model.ProductDO;
import com.example.model.UserDO;

import java.util.List;

/**
 * Created by zhang on 2017/7/8.
 * productDAO
 */
public interface ProductDAO {


    /**
     * 获取产品列表
     *
     * @return productList
     */
    List<ProductDO> listProduct();

    /**
     * 获取产品
     *
     * @param pid product id
     * @return productDO
     */

    ProductDO getProduct(Integer pid);

    /**
     * 列出购买的商品
     *
     * @param userDO userDo
     * @return list<ProductDTO>
     */

    List<ProductDO> listBuy(UserDO userDO);


    /**
     * 新增购买的商品
     *
     * @param productDO productDO
     */

    void saveProduct(ProductDO productDO);


    /**
     * 更新商品
     *
     * @param productDO productDO
     */

    void updateProduct(ProductDO productDO);

    /**
     * 计算id购买的商品数量
     *
     * @param pid product Id
     * @return Integer
     */

    Integer countProductById(Integer pid);


    /**
     * 删除商品
     *
     * @param pid product id
     */

    void deleteProduct(Integer pid);


    //计算所有的商品数量

    Integer countAllProduct();

    /**
     * 得到最后一个商品
     */
    ProductDO getLastProduct();


    /**
     * 得到商品的价格，通过id
     */


    Float getPriceById(Integer pid);
}
