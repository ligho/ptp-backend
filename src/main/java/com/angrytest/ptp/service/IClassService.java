package com.angrytest.ptp.service;

import com.angrytest.ptp.model.Class;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IClassService {

    int saveClass(Class clazz);

    List<Class> queryClass(Class clazz);

    PageInfo<Class> queryClassByPage(Class clazz, Integer pageNo, Integer pageSize);

    Integer getMax(String column, int packageId);
}
