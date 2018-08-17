package com.angrytest.ptp.provider;


import com.angrytest.ptp.model.Coverage;

public class CoverageProvider extends BasicProvider {

    public String saveCoverage(Coverage coverage) {
        return super.createInsertSql(coverage, "coverage");
    }

    public String queryCoverage(Coverage coverage) {
        return super.createSelectSql(coverage, "coverage");
    }
}
