package com.angrytest.ptp.controller;

import com.angrytest.ptp.model.Class;
import com.angrytest.ptp.service.IClassService;
import com.github.pagehelper.PageInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassController {
    /**
     * 日志
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ClassController.class);

    @Autowired
    public IClassService classService;

    @RequestMapping(value = "/class", method = RequestMethod.POST)
    public ResponseEntity<Integer> addClass(@RequestBody Class clazz) {
        int classId;
        try {
            classId = classService.saveClass(clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(classId);
    }

    @RequestMapping(value = "/class", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Class>> queryClass
            (@RequestParam(value = "id", defaultValue = "") String id,
             @RequestParam(value = "packageId", defaultValue = "") String packageId,
             @RequestParam(value = "className", defaultValue = "") String className,
             @RequestParam(value = "pageNo", defaultValue = "") String pageNo,
             @RequestParam(value = "pageSize", defaultValue = "") String pageSize) {
        Class clazz = new Class();
        Integer pn = 1;
        Integer ps = 10;
        if (!id.equals("")) {
            clazz.setId(Integer.parseInt(id));
        }
        if (!packageId.equals("")) {
            clazz.setPackageId(Integer.parseInt(packageId));
        }
        if (!className.equals("")) {
            clazz.setClassName(className);
        }
        if (!pageNo.equals("")) {
            pn = Integer.parseInt(pageNo);
        }
        if (!pageSize.equals("")) {
            ps = Integer.parseInt(pageSize);
        }
        PageInfo<Class> pageInfo;
        try {
            pageInfo = classService.queryClassByPage(clazz, pn, ps);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    @RequestMapping(value = "/class/max", method = RequestMethod.GET)
    public ResponseEntity<Integer> getMax(@RequestParam(value = "column", defaultValue = "instruction") String column,
                                          @RequestParam(value = "packageId", defaultValue = "1") String packageId){

        int max = 0;
        try {
            max = classService.getMax(column,Integer.parseInt(packageId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(max);
    }

}