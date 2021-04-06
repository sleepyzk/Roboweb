package com.zk.roboweb.controller;

import com.zk.roboweb.bean.Model;
import com.zk.roboweb.service.ModelService;
import com.zk.roboweb.utils.Result;
import com.zk.roboweb.utils.ZipUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("model")
public class ModelController {

    @Resource(name = "modelService")
    private ModelService modelService;

    /**
     * 上传模型对象
     *
     * @param request
     * @param modelFiles
     * @param coverImg
     * @return
     */
    @PostMapping("add")
    public Result addModel(HttpServletRequest request,
                           @RequestParam(value = "modelFiles") MultipartFile[] modelFiles,
                           @RequestParam(value = "coverImg") MultipartFile coverImg) {
        String modelName = request.getParameter("modelName");
        String modelType = request.getParameter("modelType");
        String uploadUser = request.getParameter("userName");
        String fileFormat = request.getParameter("fileFormat");
        modelService.addModel(modelName, modelType, uploadUser, fileFormat, modelFiles, coverImg);
        return Result.success();
    }

    /**
     * 根据关键词找同类模型
     *
     * @param keyword
     * @param request
     * @return
     */
    @GetMapping("find")
    public Result<List<Model>> selectAllByKeyword(@RequestParam(value = "keyword") String keyword,
                                                  HttpServletRequest request) {
        return Result.success(modelService.selectAllByKeyword(keyword));
    }

    /**
     * 根据ID查模型对象
     *
     * @param id
     * @param request
     * @return
     */
    @GetMapping("findOne")
    public Result<Model> selectModelById(@RequestParam(value = "id") int id, HttpServletRequest request) {
        return Result.success(modelService.selectModelById(id));
    }

    /**
     * 下载模型文件zip格式
     *
     * @param modelName
     * @param response
     */
    @GetMapping("downloadZip")
    public void downloadZip(@RequestParam(value = "modelName") String modelName, HttpServletResponse response) {
        String sourceUrl = "D:\\Java\\code\\roboweb\\src\\main\\resources\\static\\files";
        String modelUrl = sourceUrl + "\\" + modelName;
        //设置response Header
        response.setContentType("application/zip;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" + modelName + ".zip");
        //调用工具类，下载zip文件
        try {
            ZipUtils.toZip(modelUrl, response.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //下载次数加1
        modelService.updateDownloadTimeByName(modelName);
    }

}
