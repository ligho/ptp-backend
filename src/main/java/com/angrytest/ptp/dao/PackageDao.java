package com.angrytest.ptp.dao;

import com.angrytest.ptp.mapper.PackageMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.angrytest.ptp.model.Package;

import java.util.List;

@Repository
public class PackageDao {
    @Autowired
    private PackageMapper packageMapper;

    public int savePackage(Package pkg){
        packageMapper.savePackage(pkg);
        return pkg.getId();
    }

    public List<Package> queryPackage(Package pkg){
        return packageMapper.queryPackage(pkg);
    }

    public PageInfo<Package> queryPackageByPage(Package pkg, Integer pageNo,Integer pageSize){
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Package> packages = packageMapper.queryPackage(pkg);
        return new PageInfo<>(packages);
    }

    public Integer getMax(String column, Integer bundleId) {
        return packageMapper.getMax(column, bundleId);
    }
}
