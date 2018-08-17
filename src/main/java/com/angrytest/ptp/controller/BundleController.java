package com.angrytest.ptp.controller;


import com.angrytest.ptp.model.Bundle;
import com.angrytest.ptp.service.IBundleService;
import com.github.pagehelper.PageInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BundleController {

    /**
     * 日志
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BundleController.class);

    @Autowired
    public IBundleService bundleService;

    @RequestMapping(value = "/bundle", method = RequestMethod.POST)
    public ResponseEntity<Integer> addBundle(@RequestBody Bundle bundle) {
        int bundleId;
        try {
            bundleId = bundleService.saveBundle(bundle);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(bundleId);
    }

    @RequestMapping(value = "/bundle", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Bundle>> queryBundle
            (@RequestParam(value = "id", defaultValue = "") String id,
             @RequestParam(value = "coverageId", defaultValue = "") String coverageId,
             @RequestParam(value = "bundleName", defaultValue = "") String bundleName,
             @RequestParam(value = "pageNo", defaultValue = "") String pageNo,
             @RequestParam(value = "pageSize", defaultValue = "") String pageSize
            ) {
        Bundle bundle = new Bundle();
        Integer pn = 1;
        Integer ps = 10;
        if (!id.equals("")) {
            bundle.setId(Integer.parseInt(id));
        }
        if (!coverageId.equals("")) {
            bundle.setCoverageId(Integer.parseInt(coverageId));
        }
        if (!bundleName.equals("")) {
            bundle.setBundleName(bundleName);
        }
        if (!pageNo.equals("")) {
            pn = Integer.parseInt(pageNo);
        }
        if (!pageSize.equals("")) {
            ps = Integer.parseInt(pageSize);
        }
        PageInfo<Bundle> pageInfo;
        try {
            pageInfo = bundleService.queryBundleByPage(bundle, pn, ps);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    @RequestMapping(value = "/bundle/sum", method = RequestMethod.GET)
    public ResponseEntity<Integer> getSum(@RequestParam(value = "column", defaultValue = "instruction_coverd") String column,
                                          @RequestParam(value = "coverageId", defaultValue = "1") String coverageId){

        int sum = 0;
        try {
            sum = bundleService.getSum(column,Integer.parseInt(coverageId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(sum);
    }

    @RequestMapping(value = "/bundle/max", method = RequestMethod.GET)
    public ResponseEntity<Integer> getMax(@RequestParam(value = "column", defaultValue = "instruction") String column,
                                          @RequestParam(value = "coverageId", defaultValue = "1") String coverageId){

        int max = 0;
        try {
            max = bundleService.getMax(column,Integer.parseInt(coverageId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(max);
    }

}