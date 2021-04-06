package com.zk.roboweb.dao;

import com.zk.roboweb.bean.Model;
import java.util.List;

public interface ModelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Model record);

    Model selectByPrimaryKey(Integer id);

    List<Model> selectAllByKeyword(String keyword);

    int updateByPrimaryKey(Model record);

    void updateDownloadTimeByName(String modelName);
}