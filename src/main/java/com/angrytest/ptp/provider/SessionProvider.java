package com.angrytest.ptp.provider;


import com.angrytest.ptp.model.Session;

public class SessionProvider extends BasicProvider {

    public String saveSession(Session session) {
        return super.createInsertSql(session, "session");
    }

    public String querySession(Session session) {
        return super.createSelectSql(session, "session");
    }

}
