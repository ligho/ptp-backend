package com.angrytest.ptp.service.impl;

import com.angrytest.ptp.dao.PackageDao;
import com.angrytest.ptp.model.Package;
import com.angrytest.ptp.service.IPackageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService implements IPackageService {

    @Autowired
    PackageDao packageDao;

    @Override
    public int savePackage(Package pkg) {
        return packageDao.savePackage(pkg);
    }

    @Override
    public List<Package> queryPackage(Package pkg) {
        return packageDao.queryPackage(pkg);
    }

    @Override
    public PageInfo<Package> queryPackageByPage(Package pkg, Integer pageNo, Integer pageSize) {
        return packageDao.queryPackageByPage(pkg, pageNo, pageSize);
    }

    @Override
    public Integer getMax(String column, int bundleId) {
        return packageDao.getMax(column, bundleId);
    }
}
