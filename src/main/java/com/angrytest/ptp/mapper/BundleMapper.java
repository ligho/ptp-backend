package com.angrytest.ptp.mapper;

import com.angrytest.ptp.model.Bundle;
import com.angrytest.ptp.provider.BundleProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BundleMapper {

    @InsertProvider(type = BundleProvider.class, method = "saveBundle")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void saveBundle(Bundle bundle);

    @SelectProvider(type = BundleProvider.class, method = "queryBundle")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "coverage_id", property = "coverageId"),
            @Result(column = "bundle_name", property = "bundleName"),
            @Result(column = "instruction_coverd", property = "instructionCoverd"),
            @Result(column = "instruction_notcoverd", property = "instructionNotCoverd"),
            @Result(column = "instruction_coverdradio", property = "instructionCoverdRadio"),
            @Result(column = "branch_coverd", property = "branchCoverd"),
            @Result(column = "branch_notcoverd", property = "branchNotCoverd"),
            @Result(column = "branch_coverdradio", property = "branchCoverdRadio"),
            @Result(column = "complexity_coverd", property = "complexityCoverd"),
            @Result(column = "complexity_notcoverd", property = "complexityNotCoverd"),
            @Result(column = "complexity_coverdradio", property = "complexityCoverdRadio"),
            @Result(column = "line_coverd", property = "lineCoverd"),
            @Result(column = "line_notcoverd", property = "lineNotCoverd"),
            @Result(column = "line_coverdradio", property = "lineCoverdRadio"),
            @Result(column = "method_coverd", property = "methodCoverd"),
            @Result(column = "method_notcoverd", property = "methodNotCoverd"),
            @Result(column = "method_coverdradio", property = "methodCoverdRadio"),
            @Result(column = "class_coverd", property = "classCoverd"),
            @Result(column = "class_notcoverd", property = "classNotCoverd"),
            @Result(column = "class_coverdradio", property = "classCoverdRadio")
    })
    List<Bundle> queryBundle(Bundle bundle);


    @SelectProvider(type = BundleProvider.class, method = "getSum")
    Integer getSum(String column, Integer coverageId);

    @SelectProvider(type = BundleProvider.class, method = "getMax")
    Integer getMax(String column, Integer coverageId);

}
