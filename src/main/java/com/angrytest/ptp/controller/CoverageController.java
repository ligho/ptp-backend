package com.angrytest.ptp.controller;

import com.angrytest.ptp.model.Coverage;
import com.angrytest.ptp.service.ICoverageService;
import com.github.pagehelper.PageInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoverageController {
    /**
     * 日志
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CoverageController.class);

    @Autowired
    public ICoverageService coverageService;

    @RequestMapping(value = "/coverage", method = RequestMethod.POST)
    public ResponseEntity<Integer> addCoverage(@RequestBody Coverage coverage) {
        int coverageId;
        try {
            coverageId = coverageService.saveCoverage(coverage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(coverageId);
    }

    @RequestMapping(value = "/coverage", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Coverage>> queryCoverageByPage
            (@RequestParam(value = "id", defaultValue = "") String id,
             @RequestParam(value = "proName", defaultValue = "") String proName,
             @RequestParam(value = "proVersion", defaultValue = "") String proVersion,
             @RequestParam(value = "isIncrement", defaultValue = "") String isIncrement,
             @RequestParam(value = "pageNo", defaultValue = "") String pageNo,
             @RequestParam(value = "pageSize", defaultValue = "") String pageSize) {
        Coverage coverage = new Coverage();
        Integer pn = 1;
        Integer ps = 10;
        if (!id.equals("")) {
            coverage.setId(Integer.parseInt(id));
        }
        if (!proName.equals("")) {
            coverage.setProName(proName);
        }
        if (!proVersion.equals("")) {
            coverage.setProVersion(proVersion);
        }
        if (!isIncrement.equals("")) {
            coverage.setIsIncrement(Integer.parseInt(isIncrement));
        }
        if (!pageNo.equals("")) {
            pn = Integer.parseInt(pageNo);
        }
        if (!pageSize.equals("")) {
            ps = Integer.parseInt(pageSize);
        }
        PageInfo<Coverage> pageInfo;
        try {
            pageInfo = coverageService.queryCoverageByPage(coverage, pn, ps);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }
}