package com.angrytest.ptp.service.impl;

import com.angrytest.ptp.dao.ClassDao;
import com.angrytest.ptp.model.Class;
import com.angrytest.ptp.service.IClassService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {

    @Autowired
    ClassDao classDao;

    @Override
    public int saveClass(Class clazz) {
        return classDao.saveClass(clazz);
    }

    @Override
    public List<Class> queryClass(Class clazz) {
        return classDao.queryClass(clazz);
    }

    @Override
    public PageInfo<Class> queryClassByPage(Class clazz, Integer pageNo, Integer pageSize) {
        return classDao.queryClassByPage(clazz, pageNo, pageSize);
    }

    @Override
    public Integer getMax(String column, int packageId) {
        return classDao.getMax(column, packageId);
    }
}
