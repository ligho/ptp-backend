package com.angrytest.ptp.dao;

import com.angrytest.ptp.mapper.ClassMapper;
import com.angrytest.ptp.model.Class;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDao {
    @Autowired
    private ClassMapper classMapper;

    public int saveClass(Class clazz) {
        classMapper.saveClass(clazz);
        return clazz.getId();
    }

    public List<Class> queryClass(Class clazz) {
        return classMapper.queryClass(clazz);
    }

    public PageInfo<Class> queryClassByPage(Class clazz, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Class> clazzs = classMapper.queryClass(clazz);
        return new PageInfo<>(clazzs);
    }

    public Integer getMax(String column, Integer packageId) {
        return classMapper.getMax(column, packageId);
    }
}
