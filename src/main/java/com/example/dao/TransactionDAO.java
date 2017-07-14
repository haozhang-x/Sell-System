package com.example.dao;

import com.example.model.TransactionDO;

/**
 * Created by zhang on 2017/7/13.
 */
public interface TransactionDAO {
    TransactionDO getTransactionByUid(Integer uid);
    TransactionDO getTransactionByPId(Integer pid);
}
