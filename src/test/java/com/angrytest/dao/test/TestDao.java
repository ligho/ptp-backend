package com.angrytest.dao.test;

import com.angrytest.ptp.Application;
import com.angrytest.ptp.dao.BundleDao;
import com.angrytest.ptp.dao.CoverageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringRunner.class)
//@Transactional
public class TestDao {

    @Autowired
    BundleDao bundleDao;


    @Autowired
    CoverageDao coverageDao;

    @Test
    public void testSaveBundle(){
//        Bundle bundle = new Bundle();
//        bundle.setBundleName("test");
//        bundle.setInstructionCoverd(1);
//        bundle.setInstructionNotCoverd(2);
//        bundle.setBranchCoverd(1);
//        bundle.setBranchNotCoverd(2);
//        bundle.setComplexityCoverd(1);
//        bundle.setComplexityNotCoverd(2);
//        bundle.setLineCoverd(1);
//        bundle.setLineNotCoverd(2);
//        bundle.setMethodCoverd(1);
//        bundle.setMethodNotCoverd(2);
//        bundle.setClassCoverd(1);
//        bundle.setClassNotCoverd(2);
//        System.out.print(bundleDao.saveBundle(bundle));
//        Coverage cov = new Coverage();
//        cov.setId(1);
//        cov.setProName("test");
//        cov.setProVersion("1.0");
//        cov.setIsIncrement(0);
//        cov.setStrongText("12312222222222222222222222222222222");
//        coverageDao.saveCoverage(cov);
    }
}
