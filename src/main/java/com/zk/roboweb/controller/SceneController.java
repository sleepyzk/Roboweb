package com.zk.roboweb.controller;

import com.zk.roboweb.service.SceneService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("scene")
public class SceneController {

    @Resource(name = "sceneService")
    private SceneService sceneService;
}
