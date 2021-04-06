package com.zk.roboweb.service.impl;

import com.zk.roboweb.bean.Model;
import com.zk.roboweb.dao.ModelDao;
import com.zk.roboweb.service.ModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Service("modelService")
@Transactional
public class ModelServiceImpl implements ModelService {

    @Resource
    private ModelDao modelDao;


    /**
     * 模型上传
     * @param modelName
     * @param modelType
     * @param uploadUser
     * @param fileFormat
     * @param modelFiles
     * @param coverImg
     */
    @Override
    public void addModel(String modelName, String modelType, String uploadUser, String fileFormat,
                         MultipartFile[] modelFiles, MultipartFile coverImg) {

        String basePath = "D:\\Java\\code\\roboweb\\src\\main\\resources\\static\\files";
        String modelPath = basePath + "\\" + modelName;
        File path = new File(modelPath);

        //创建上传文件夹
        if (!path.exists()) {
            path.mkdirs();
        }
        //上传文件
        if (modelFiles != null && modelFiles.length > 0) {
            for (MultipartFile file : modelFiles) {
                if (!file.isEmpty()) {
                    try {
                        file.transferTo(new File(modelPath, Objects.requireNonNull(file.getOriginalFilename())));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (!coverImg.isEmpty()) {
            try {
                coverImg.transferTo(new File(modelPath, Objects.requireNonNull(coverImg.getOriginalFilename())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //模型数据写入数据库
        Date uploadTime = new Date();
        Integer downloadTimes = 0;
        int fileSize = 0;
        String imgName = coverImg.getOriginalFilename();
        if (modelFiles != null && modelName.length() > 0) {
            for (MultipartFile file : modelFiles) {
                fileSize += file.getSize() / 1024 / 1024;
            }
        }
        //封装模型对象
        Model model = new Model();
        model.setModelName(modelName);
        model.setModelType(modelType);
        model.setCoverImg(imgName);
        model.setUploadUser(uploadUser);
        model.setUploadTime(uploadTime);
        model.setFileFormat(fileFormat);
        model.setFileSize(fileSize);
        model.setDownloadTimes(downloadTimes);

        modelDao.insert(model);
    }

    /**
     * 根据关键词查模型
     * @param keyword
     * @return
     */
    @Override
    public List<Model> selectAllByKeyword(String keyword) {
        return modelDao.selectAllByKeyword(keyword);
    }

    /**
     * 根据ID查模型
     * @param id
     * @return
     */
    @Override
    public Model selectModelById(int id) {
        return modelDao.selectByPrimaryKey(id);
    }

    /**
     * 更新下载次数
     * @param modelName
     */
    @Override
    public void updateDownloadTimeByName(String modelName) {
        modelDao.updateDownloadTimeByName(modelName);
    }

}
