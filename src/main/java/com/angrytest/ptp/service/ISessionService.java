package com.angrytest.ptp.service;

import com.angrytest.ptp.model.Session;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ISessionService {

    void saveSession(Session session);

    List<Session> querySession(Session session);

    PageInfo<Session> querySessionByPage(Session session, Integer pageNo, Integer pageSize);
}
