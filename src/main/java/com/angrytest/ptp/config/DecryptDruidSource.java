package com.angrytest.ptp.config;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;

public class DecryptDruidSource extends DruidDataSource{
    @Override
    public void setUsername(String username) {
        try {
            username = ConfigTools.decrypt(username);

        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setUsername(username);
    }
}
