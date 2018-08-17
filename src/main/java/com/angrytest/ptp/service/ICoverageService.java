package com.angrytest.ptp.service;


import com.angrytest.ptp.model.Coverage;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICoverageService {

    int saveCoverage(Coverage coverage);

    List<Coverage> queryCoverage(Coverage coverage);

    PageInfo<Coverage> queryCoverageByPage(Coverage coverage, Integer pageNo, Integer pageSize);

}
