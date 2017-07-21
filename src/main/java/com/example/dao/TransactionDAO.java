package com.example.dao;

import com.example.model.TransactionDO;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by zhang on 2017/7/13.
 */
public interface TransactionDAO {
    List<TransactionDO> getTransactionByUid(Integer uid);

    Integer countTransactionByPId(Integer pid);

    Integer countTransactionByTime(Timestamp timestamp);


    List<TransactionDO> getTransactionByPId(Integer pid);

    void saveTransaction(TransactionDO transactionDO);
}
