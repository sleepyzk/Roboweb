package com.zk.roboweb.dao;

import com.zk.roboweb.bean.Scene;
import java.util.List;

public interface SceneDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Scene record);

    Scene selectByPrimaryKey(Integer id);

    List<Scene> selectAll();

    int updateByPrimaryKey(Scene record);
}