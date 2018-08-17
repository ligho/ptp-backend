package com.angrytest.ptp.service.impl;

import com.angrytest.ptp.dao.SessionDao;
import com.angrytest.ptp.model.Session;
import com.angrytest.ptp.service.ISessionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService implements ISessionService {

    @Autowired
    SessionDao sessionDao;

    @Override
    public void saveSession(Session session) {
        sessionDao.saveSession(session);
    }

    @Override
    public List<Session> querySession(Session session) {
        return sessionDao.querySession(session);
    }

    @Override
    public PageInfo<Session> querySessionByPage(Session session, Integer pageNo, Integer pageSize) {
        return sessionDao.querySessionByPage(session, pageNo, pageSize);
    }

}
