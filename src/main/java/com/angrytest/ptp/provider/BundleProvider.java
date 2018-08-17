package com.angrytest.ptp.provider;


import com.angrytest.ptp.model.Bundle;

public class BundleProvider extends BasicProvider {

    public String saveBundle(Bundle bundle) {
        return super.createInsertSql(bundle, "bundle");
    }

    public String queryBundle(Bundle bundle) {
        return super.createSelectSql(bundle, "bundle");
    }

    public String getSum(String column, Integer coverageId) {
        return "select sum(" + column + ") as sum from bundle where coverage_id=" + coverageId;
    }

    public String getMax(String column, Integer coverageId) {
        return "select max(" + column + "_coverd+" + column + "_notcoverd)" + "as max from bundle where coverage_id=" + coverageId;
    }
}
