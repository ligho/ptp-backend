package com.angrytest.ptp.service.impl;

import com.angrytest.ptp.dao.CoverageDao;
import com.angrytest.ptp.model.Coverage;
import com.angrytest.ptp.service.ICoverageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverageService implements ICoverageService {

    @Autowired
    CoverageDao coverageDao;

    @Override
    public int saveCoverage(Coverage coverage) {
        return coverageDao.saveCoverage(coverage);
    }

    @Override
    public List<Coverage> queryCoverage(Coverage coverage) {
        return coverageDao.queryCoverage(coverage);
    }

    @Override
    public PageInfo<Coverage> queryCoverageByPage(Coverage coverage, Integer pageNo, Integer pageSize) {
        return coverageDao.queryCoverageByPage(coverage, pageNo, pageSize);
    }
}
