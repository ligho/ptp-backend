package com.angrytest.ptp.provider;

import com.angrytest.ptp.model.Method;

public class MethodProvider extends BasicProvider {

    public String saveMethod(Method method) {
        return super.createInsertSql(method, "method");
    }

    public String queryMethod(Method method) {
        return super.createSelectSql(method, "method");
    }

    public String getMax(String column, Integer classId) {
        return "select max(" + column + "_coverd+" + column + "_notcoverd)" + "as max from method where class_id=" + classId;
    }
}
