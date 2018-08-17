package com.angrytest.ptp.service.impl;

import com.angrytest.ptp.dao.MethodDao;
import com.angrytest.ptp.model.Method;
import com.angrytest.ptp.service.IMethodService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodService implements IMethodService {
    @Autowired
    MethodDao methodDao;

    @Override
    public int saveMethod(Method method) {
        return methodDao.saveMethod(method);
    }

    @Override
    public List<Method> queryMethod(Method method) {
        return methodDao.queryMethod(method);
    }

    @Override
    public PageInfo<Method> queryMethodByPage(Method method, Integer pageNo, Integer pageSize) {
        return methodDao.queryMethodByPage(method, pageNo, pageSize);
    }

    @Override
    public Integer getMax(String column, int classId) {
        return methodDao.getMax(column, classId);
    }
}
