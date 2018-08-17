package com.angrytest.ptp.controller;

import com.angrytest.ptp.model.Method;
import com.angrytest.ptp.service.IMethodService;
import com.github.pagehelper.PageInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MethodController {
    /**
     * 日志
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MethodController.class);

    @Autowired
    public IMethodService methodService;

    @RequestMapping(value = "/method", method = RequestMethod.POST)
    public ResponseEntity<Integer> addMethod(@RequestBody Method method) {
        int methodId;
        try {
            methodId = methodService.saveMethod(method);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(methodId);
    }

    @RequestMapping(value = "/method", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Method>> queryMethod
            (@RequestParam(value = "id", defaultValue = "") String id,
             @RequestParam(value = "classId", defaultValue = "") String classId,
             @RequestParam(value = "methodName", defaultValue = "") String methodName,
             @RequestParam(value = "pageNo", defaultValue = "") String pageNo,
             @RequestParam(value = "pageSize", defaultValue = "") String pageSize) {
        Method method = new Method();
        Integer pn = 1;
        Integer ps = 10;
        if (!id.equals("")) {
            method.setId(Integer.parseInt(id));
        }
        if (!classId.equals("")) {
            method.setClassId(Integer.parseInt(classId));
        }
        if (!methodName.equals("")) {
            method.setMethodName(methodName);
        }
        if (!pageNo.equals("")) {
            pn = Integer.parseInt(pageNo);
        }
        if (!pageSize.equals("")) {
            ps = Integer.parseInt(pageSize);
        }
        PageInfo<Method> pageInfo;
        try {
            pageInfo = methodService.queryMethodByPage(method, pn, ps);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    @RequestMapping(value = "/method/max", method = RequestMethod.GET)
    public ResponseEntity<Integer> getMax(@RequestParam(value = "column", defaultValue = "instruction") String column,
                                          @RequestParam(value = "classId", defaultValue = "1") String classId){

        int max = 0;
        try {
            max = methodService.getMax(column,Integer.parseInt(classId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(max);
    }
}