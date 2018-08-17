package com.angrytest.ptp.provider;

import com.angrytest.ptp.model.Package;

public class PackageProvider extends BasicProvider {

    public String savePackage(Package pkg) {
        return super.createInsertSql(pkg, "package");
    }

    public String queryPackage(Package pkg) {
        return super.createSelectSql(pkg, "package");
    }

    public String getMax(String column, Integer bundleId) {
        return "select max(" + column + "_coverd+" + column + "_notcoverd)" + "as max from package where bundle_id=" + bundleId;
    }
}
