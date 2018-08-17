package com.angrytest.ptp.model;


import com.angrytest.ptp.annotations.Persist;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Coverage {
    @Persist(column = "id")
    private Integer id;

    @Persist(column = "pro_name")
    private String proName;

    @Persist(column = "pro_version")
    private String proVersion;

    @Persist(column = "is_increment")
    private Integer isIncrement;

    @Persist(column = "base_version")
    private String baseVersion;

    @Persist(column = "createtimestamp")
    private Timestamp createtimestamp;


}
