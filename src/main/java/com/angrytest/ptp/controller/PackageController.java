package com.angrytest.ptp.controller;

import com.angrytest.ptp.model.Package;
import com.angrytest.ptp.service.IPackageService;
import com.github.pagehelper.PageInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {
    /**
     * 日志
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PackageController.class);

    @Autowired
    public IPackageService packageService;

    @RequestMapping(value = "/package", method = RequestMethod.POST)
    public ResponseEntity<Integer> addPackage(@RequestBody Package pkg) {
        int packageId;
        try {
            packageId = packageService.savePackage(pkg);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(packageId);
    }

    @RequestMapping(value = "/package", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Package>> queryPackage
            (@RequestParam(value = "id", defaultValue = "") String id,
             @RequestParam(value = "bundleId", defaultValue = "") String bundleId,
             @RequestParam(value = "packageName", defaultValue = "") String packageName,
             @RequestParam(value = "pageNo", defaultValue = "") String pageNo,
             @RequestParam(value = "pageSize", defaultValue = "") String pageSize) {
        Package pkg = new Package();
        Integer pn = 1;
        Integer ps = 10;
        if(!id.equals("")){
            pkg.setId(Integer.parseInt(id));
        }
        if(!bundleId.equals("")){
            pkg.setBundleId(Integer.parseInt(bundleId));
        }
        if(!packageName.equals("")){
            pkg.setPackageName(packageName);
        }
        if (!pageNo.equals("")) {
            pn = Integer.parseInt(pageNo);
        }
        if (!pageSize.equals("")) {
            ps = Integer.parseInt(pageSize);
        }
        PageInfo<Package> pageInfo;
        try {
            pageInfo = packageService.queryPackageByPage(pkg,pn,ps);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    @RequestMapping(value = "/package/max", method = RequestMethod.GET)
    public ResponseEntity<Integer> getMax(@RequestParam(value = "column", defaultValue = "instruction") String column,
                                          @RequestParam(value = "bundleId", defaultValue = "1") String bundleId){

        int max = 0;
        try {
            max = packageService.getMax(column,Integer.parseInt(bundleId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(max);
    }

}