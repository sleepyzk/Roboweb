package com.zk.roboweb.service.impl;

import com.zk.roboweb.dao.SceneDao;
import com.zk.roboweb.service.SceneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("sceneService")
@Transactional
public class SceneServiceImpl implements SceneService {

    @Resource
    private SceneDao sceneDao;
}
