package com.example.service;

import com.example.model.TransactionDO;

/**
 * Created by zhang on 2017/7/13.
 */
public interface TransactionService {
    TransactionDO getTransactionByUId(Integer uid);

    TransactionDO getTransactionByPId(Integer pid);
}
