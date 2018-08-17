package com.angrytest.ptp.provider;

import com.angrytest.ptp.model.Class;

public class ClassProvider extends BasicProvider {

    public String saveClass(Class clazz) {
        return super.createInsertSql(clazz, "class");
    }

    public String queryClass(Class clazz) {
        return super.createSelectSql(clazz, "class");
    }

    public String getMax(String column, Integer packageId) {
        return "select max(" + column + "_coverd+" + column + "_notcoverd)" + "as max from class where package_id=" + packageId;
    }

}
