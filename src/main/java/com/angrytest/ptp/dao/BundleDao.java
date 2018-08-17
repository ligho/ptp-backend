package com.angrytest.ptp.dao;

import com.angrytest.ptp.mapper.BundleMapper;
import com.angrytest.ptp.model.Bundle;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BundleDao {

    @Autowired
    private BundleMapper bundleMapper;

    public int saveBundle(Bundle bundle) {
        bundleMapper.saveBundle(bundle);
        return bundle.getId();
    }

    public List<Bundle> queryBundle(Bundle bundle) {
        return bundleMapper.queryBundle(bundle);
    }

    public PageInfo<Bundle> queryBundleByPage(Bundle bundle, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Bundle> bundles = bundleMapper.queryBundle(bundle);
        return new PageInfo<>(bundles);
    }

    public Integer getSum(String column, Integer coverageId) {
        return bundleMapper.getSum(column, coverageId);
    }

    public Integer getMax(String column, Integer coverageId) {
        return bundleMapper.getMax(column, coverageId);
    }
}
