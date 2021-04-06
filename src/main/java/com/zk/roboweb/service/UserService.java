package com.zk.roboweb.service;

import com.zk.roboweb.bean.User;

import java.util.List;

public interface UserService {

    //查询所有用户
    List<User> selectAll();
}
