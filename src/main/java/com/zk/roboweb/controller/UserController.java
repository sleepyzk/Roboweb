package com.zk.roboweb.controller;


import com.zk.roboweb.bean.User;
import com.zk.roboweb.service.UserService;
import com.zk.roboweb.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("all")
    public Result<List<User>> findAll() {
        return Result.success(userService.selectAll());
    }

}
