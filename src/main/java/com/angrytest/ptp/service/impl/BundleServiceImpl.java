package com.angrytest.ptp.service.impl;

import com.angrytest.ptp.dao.BundleDao;
import com.angrytest.ptp.model.Bundle;
import com.angrytest.ptp.service.IBundleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BundleServiceImpl implements IBundleService {

    @Autowired
    BundleDao bundleDao;

    @Override
    public int saveBundle(Bundle bundle) {
        return bundleDao.saveBundle(bundle);
    }

    @Override
    public List<Bundle> queryBundle(Bundle bundle) {
        return bundleDao.queryBundle(bundle);
    }

    @Override
    public PageInfo<Bundle> queryBundleByPage(Bundle bundle, Integer pageNo, Integer pageSize) {
        return bundleDao.queryBundleByPage(bundle, pageNo, pageSize);
    }

    @Override
    public Integer getSum(String column, int coverageId) {
        return bundleDao.getSum(column, coverageId);
    }

    @Override
    public Integer getMax(String column, int coverageId) {
        return bundleDao.getMax(column, coverageId);
    }
}
