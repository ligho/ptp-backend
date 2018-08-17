package com.angrytest.ptp.controller;

import com.angrytest.ptp.model.Session;
import com.angrytest.ptp.service.ISessionService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController {

    /**
     * 日志
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    public ISessionService sessionService;

    @RequestMapping(value = "/session", method = RequestMethod.POST)
    public ResponseEntity<Integer> addSession(@RequestBody Session session) {
        try {
            sessionService.saveSession(session);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public ResponseEntity<List<Session>> querySession
            (@RequestParam(value = "id", defaultValue = "") String id,
             @RequestParam(value = "coverageId", defaultValue = "") String coverageId,
             @RequestParam(value = "sessionId", defaultValue = "") String sessionId) {
        Session session = new Session();
        if(!id.equals("")){
            session.setId(Integer.parseInt(id));
        }
        if(!coverageId.equals("")){
            session.setCoverageId(Integer.parseInt(coverageId));
        }
        if(!sessionId.equals("")){
            session.setSessionId(sessionId);
        }
        List<Session> sessions;
        try {
            sessions = sessionService.querySession(session);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(sessions);
    }

}