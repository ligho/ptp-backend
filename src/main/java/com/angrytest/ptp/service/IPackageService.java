package com.angrytest.ptp.service;

import com.angrytest.ptp.model.Package;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IPackageService {

    int savePackage(Package pkg);

    List<Package> queryPackage(Package pkg);

    PageInfo<Package> queryPackageByPage(Package pkg, Integer pageNo, Integer pageSize);

    Integer getMax(String column, int bundleId);

}
