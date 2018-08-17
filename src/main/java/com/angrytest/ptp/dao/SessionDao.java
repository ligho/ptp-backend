package com.angrytest.ptp.dao;

import com.angrytest.ptp.mapper.SessionMapper;
import com.angrytest.ptp.model.Session;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SessionDao {

    @Autowired
    private SessionMapper sessionMapper;

    public void saveSession(Session session){
        sessionMapper.saveSession(session);
    }

    public List<Session> querySession(Session session){
        return sessionMapper.querySession(session);
    }

    public PageInfo<Session> querySessionByPage(Session session, Integer pageNo, Integer pageSize){
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Session> sessions = sessionMapper.querySession(session);
        return new PageInfo<>(sessions);
    }
}