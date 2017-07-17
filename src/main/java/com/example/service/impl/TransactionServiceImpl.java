package com.example.service.impl;

import com.example.dao.ProductDAO;
import com.example.dao.TransactionDAO;
import com.example.model.TransactionDO;
import com.example.service.ProductService;
import com.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2017/7/13.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionDAO transactionDAO;
    private ProductDAO productDAO;

    @Autowired
    public void setTransactionDAO(TransactionDAO transactionDAO, ProductDAO productDAO) {
        this.transactionDAO = transactionDAO;
        this.productDAO = productDAO;
    }


    public List<TransactionDO> getTransactionByUId(Integer uid) {
        return transactionDAO.getTransactionByUid(uid);
    }

    public Integer countTransactionByPId(Integer pid) {
        return transactionDAO.countTransactionByPId(pid);
    }

    public List<TransactionDO> getTransactionByPId(Integer pid) {
        return transactionDAO.getTransactionByPId(pid);
    }

    public void saveTransaction(Integer pid, Integer number, Integer userId) {
        for (int i = 0; i < number; i++) {
            TransactionDO transaction = new TransactionDO();
            Float price = productDAO.getPriceById(pid);
            transaction.setProductId(pid);
            transaction.setPrice(price);
            transaction.setUserId(userId);
            transactionDAO.saveTransaction(transaction);
        }
    }
}
