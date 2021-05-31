package com.zk.roboweb.service;

import com.zk.roboweb.bean.Scene;

import java.io.IOException;
import java.util.List;

public interface SceneService {

    void addScene(String sceneName,String createUser,String sceneCover,String scene) throws IOException;

    List<Scene> selectSceneByKeyword(String keyword);
}
