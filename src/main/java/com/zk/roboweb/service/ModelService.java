package com.zk.roboweb.service;


import com.zk.roboweb.bean.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ModelService {

    void addModel(String modelName, String modelType, String uploadUser, String fileFormat, MultipartFile[] modelFiles, MultipartFile coverImg);

    List<Model> selectAllByKeyword(String keyword);

    Model selectModelById(int id);

    void updateDownloadTimeByName(String modelName);

}
