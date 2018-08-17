package com.angrytest.ptp.model;

import com.angrytest.ptp.annotations.Persist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Package {

    @Persist(column = "id")
    private Integer id;

    @Persist(column = "bundle_id")
    private Integer bundleId;

    @Persist(column = "package_name")
    private String packageName;

    @Persist(column = "instruction_coverd")
    private Integer instructionCoverd;

    @Persist(column = "instruction_notcoverd")
    private Integer instructionNotCoverd;

    @Persist(column = "instruction_coverdradio")
    private Double instructionCoverdRadio;

    @Persist(column = "branch_coverd")
    private Integer branchCoverd;

    @Persist(column = "branch_notcoverd")
    private Integer branchNotCoverd;

    @Persist(column = "branch_coverdradio")
    private Double branchCoverdRadio;

    @Persist(column = "complexity_coverd")
    private Integer complexityCoverd;

    @Persist(column = "complexity_notcoverd")
    private Integer complexityNotCoverd;

    @Persist(column = "complexity_coverdradio")
    private Double complexityCoverdRadio;

    @Persist(column = "line_coverd")
    private Integer lineCoverd;

    @Persist(column = "line_notcoverd")
    private Integer lineNotCoverd;

    @Persist(column = "line_coverdradio")
    private Double lineCoverdRadio;

    @Persist(column = "method_coverd")
    private Integer methodCoverd;

    @Persist(column = "method_notcoverd")
    private Integer methodNotCoverd;

    @Persist(column = "method_coverdradio")
    private Double methodCoverdRadio;

    @Persist(column = "class_coverd")
    private Integer classCoverd;

    @Persist(column = "class_notcoverd")
    private Integer classNotCoverd;

    @Persist(column = "class_coverdradio")
    private Double classCoverdRadio;

}
