package com.zk.roboweb.service.impl;

import com.zk.roboweb.bean.Scene;
import com.zk.roboweb.dao.SceneDao;
import com.zk.roboweb.service.SceneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.io.*;
import java.util.Date;
import java.util.List;

@Service("sceneService")
@Transactional
public class SceneServiceImpl implements SceneService {

    @Resource
    private SceneDao sceneDao;

    @Override
    public void addScene(String sceneName, String createUser, String sceneCover, String scene) throws IOException {

        String scenePath = "D:\\Java\\code\\Vue\\roboweb\\public\\scene\\sceneFile";
        String sceneCoverPath = "D:\\Java\\code\\Vue\\roboweb\\public\\scene\\sceneCover";

        //保存场景封面图片到本地
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] imgByte = decoder.decodeBuffer(sceneCover);
        for (int i = 0; i < imgByte.length; i++) {
            if (imgByte[i] < 0) {
                imgByte[i] += 256;
            }
        }
        OutputStream outs = new FileOutputStream(sceneCoverPath + "\\" + sceneName + ".jpeg");
        outs.write(imgByte);
        outs.flush();
        outs.close();

        //保存场景的JSON文件到本地
        FileWriter fw = new FileWriter(new File(scenePath + "\\" + sceneName + ".json"));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(scene);
        bw.flush();
        bw.close();

        Date timeStamp = new Date();

        Scene newScene = new Scene();
        newScene.setSceneName(sceneName);
        newScene.setCreateUser(createUser);
        newScene.setCreateTime(timeStamp);
        newScene.setUpdateTime(timeStamp);
        sceneDao.insert(newScene);

    }

    @Override
    public List<Scene> selectSceneByKeyword(String keyword) {
        return sceneDao.selectAll(keyword);
    }
}
