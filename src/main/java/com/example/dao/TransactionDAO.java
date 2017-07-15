package com.example.dao;

import com.example.model.TransactionDO;

import java.util.List;

/**
 * Created by zhang on 2017/7/13.
 */
public interface TransactionDAO {
    List<TransactionDO> getTransactionByUid(Integer uid);

    List<TransactionDO> getTransactionByPId(Integer pid);

    void saveTransaction(TransactionDO transactionDO);
}
