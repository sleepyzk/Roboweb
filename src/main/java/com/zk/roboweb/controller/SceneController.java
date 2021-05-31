package com.zk.roboweb.controller;

import com.zk.roboweb.bean.Scene;
import com.zk.roboweb.service.SceneService;
import com.zk.roboweb.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("scene")
public class SceneController {

    @Resource(name = "sceneService")
    private SceneService sceneService;

    @PostMapping("add")
    public Result addScene(HttpServletRequest request) throws IOException {

        String sceneName = request.getParameter("sceneName");
        String createUser = request.getParameter("createUser");
        String sceneCover = request.getParameter("sceneCover");
        String scene = request.getParameter("scene");
        sceneService.addScene(sceneName, createUser, sceneCover, scene);
        return Result.success();
    }

    @GetMapping("find")
    public Result<List<Scene>> selectSceneByKeyword(@RequestParam(value = "keyword") String keyword, HttpServletRequest request) {

        return Result.success(sceneService.selectSceneByKeyword(keyword));
    }
}
