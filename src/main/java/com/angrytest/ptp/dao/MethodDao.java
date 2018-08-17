package com.angrytest.ptp.dao;

import com.angrytest.ptp.mapper.MethodMapper;
import com.angrytest.ptp.model.Method;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MethodDao {
    @Autowired
    private MethodMapper methodMapper;

    public int saveMethod(Method method) {
        methodMapper.saveMethod(method);
        return method.getId();
    }

    public List<Method> queryMethod(Method method) {
        return methodMapper.queryMethod(method);
    }

    public PageInfo<Method> queryMethodByPage(Method method, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Method> methods = methodMapper.queryMethod(method);
        return new PageInfo<>(methods);
    }

    public Integer getMax(String column, Integer classId) {
        return methodMapper.getMax(column, classId);
    }
}
