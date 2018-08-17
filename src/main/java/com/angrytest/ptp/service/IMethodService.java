package com.angrytest.ptp.service;

import com.angrytest.ptp.model.Method;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMethodService {

    int saveMethod(Method method);

    List<Method> queryMethod(Method method);

    PageInfo<Method> queryMethodByPage(Method method, Integer pageNo, Integer pageSize);

    Integer getMax(String column, int classId);

}
