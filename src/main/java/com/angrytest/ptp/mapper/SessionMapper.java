package com.angrytest.ptp.mapper;

import com.angrytest.ptp.model.Session;
import com.angrytest.ptp.provider.SessionProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SessionMapper {

    @InsertProvider(type = SessionProvider.class, method = "saveSession")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void saveSession(Session session);

    @SelectProvider(type = SessionProvider.class, method = "querySession")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "coverage_id", property = "coverageId"),
            @Result(column = "session_id", property = "sessionId"),
            @Result(column = "starttimestamp", property = "startTimeStamp"),
            @Result(column = "dumptimestamp", property = "dumpTimeStamp")
    })
    List<Session> querySession(Session session);

}
