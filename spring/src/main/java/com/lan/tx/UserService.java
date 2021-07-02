package com.lan.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jianglin.lan
 * @title: UserService
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/1 15:31
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void insert () {
        userDao.insert ();
    }
}
