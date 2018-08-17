package com.angrytest.ptp.model;

import com.angrytest.ptp.annotations.Persist;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Session {

    @Persist(column = "id")
    private Integer id;

    @Persist(column = "coverage_id")
    private Integer coverageId;

    @Persist(column = "session_id")
    private String sessionId;

    @Persist(column = "starttimestamp")
    private Timestamp startTimeStamp;

    @Persist(column = "dumptimestamp")
    private Timestamp dumpTimeStamp;
}
