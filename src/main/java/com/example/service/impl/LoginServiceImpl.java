package com.example.service.impl;

import com.example.dao.UserDAO;
import com.example.model.UserDO;
import com.example.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhang on 2017/6/29.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean login(UserDO userDO) {
        UserDO userDOInfo = userDAO.getUserInfo(userDO);
        if (userDOInfo != null) {
            if (userDOInfo.getPassWord().equals(userDO.getPassWord())) {
                BeanUtils.copyProperties(userDOInfo, userDO);
                return true;
            } else
                return false;
        }
        return false;
    }
}
