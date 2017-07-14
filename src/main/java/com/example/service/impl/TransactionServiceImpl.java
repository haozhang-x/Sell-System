package com.example.service.impl;

import com.example.dao.TransactionDAO;
import com.example.model.TransactionDO;
import com.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhang on 2017/7/13.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionDAO transactionDAO;

    @Autowired
    public void setTransactionDAO(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }


    public TransactionDO getTransactionByUId(Integer uid) {
        return transactionDAO.getTransactionByUid(uid);
    }

    public TransactionDO getTransactionByPId(Integer pid) {
        return transactionDAO.getTransactionByPId(pid);
    }
}
