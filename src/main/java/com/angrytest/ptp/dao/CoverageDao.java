package com.angrytest.ptp.dao;

import com.angrytest.ptp.mapper.CoverageMapper;
import com.angrytest.ptp.model.Coverage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoverageDao {

    @Autowired
    private CoverageMapper coverageMapper;

    public int saveCoverage(Coverage coverage){
        coverageMapper.saveCoverage(coverage);
        return coverage.getId();
    }

    public List<Coverage> queryCoverage(Coverage coverage){
        return coverageMapper.queryCoverage(coverage);
    }

    public PageInfo<Coverage> queryCoverageByPage(Coverage coverage, Integer pageNo,Integer pageSize){
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Coverage> coverages = coverageMapper.queryCoverage(coverage);
        return new PageInfo<>(coverages);
    }

}
