package com.angrytest.ptp.service;


import com.angrytest.ptp.model.Bundle;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBundleService {

    int saveBundle(Bundle bundle);

    List<Bundle> queryBundle(Bundle bundle);

    PageInfo<Bundle> queryBundleByPage(Bundle bundle, Integer pageNo, Integer pageSize);

    Integer getSum(String column, int coverageId);

    Integer getMax(String column, int coverageId);
}
