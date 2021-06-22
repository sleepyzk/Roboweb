package com.zk.roboweb.service.impl;

import com.zk.roboweb.bean.User;

import com.zk.roboweb.dao.UserDao;
import com.zk.roboweb.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> selectAll() {

        return userDao.selectAll();
    }
}
