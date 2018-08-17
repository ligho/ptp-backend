package com.angrytest.ptp.mapper;

import com.angrytest.ptp.model.Coverage;
import com.angrytest.ptp.provider.CoverageProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CoverageMapper {

    @InsertProvider(type = CoverageProvider.class, method = "saveCoverage")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void saveCoverage(Coverage coverage);

    @SelectProvider(type = CoverageProvider.class, method = "queryCoverage")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "pro_name", property = "proName"),
            @Result(column = "pro_version", property = "proVersion"),
            @Result(column = "is_increment", property = "isIncrement"),
            @Result(column = "base_version", property = "baseVersion"),
            @Result(column = "createtimestamp", property = "createtimestamp")
    })
    List<Coverage> queryCoverage(Coverage coverage);


}
