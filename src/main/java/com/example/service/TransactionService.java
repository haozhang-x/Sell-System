package com.example.service;

import com.example.model.TransactionDO;

import java.util.List;

/**
 * Created by zhang on 2017/7/13.
 */
public interface TransactionService {
    List<TransactionDO> getTransactionByUId(Integer uid);

    Integer countTransactionByPId(Integer pid);

    List<TransactionDO> getTransactionByPId(Integer pid);

    void saveTransaction(Integer pid,Integer number,Integer userId);
}
