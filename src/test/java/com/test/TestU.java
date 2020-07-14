package com.test;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.*;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.github.springtestdbunit.dataset.ReplacementDataSetLoader;
import com.test.domain.User;
import com.test.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.annotation.Resource;

/**
 * ClassName:Test
 * Package:com.test
 * Decription:
 *
 * @date:2020/7/13 10:35
 * @author:qiaomu
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
@DbUnitConfiguration(dataSetLoader = ReplacementDataSetLoader.class)
public class TestU {


    @Resource
    //private TestDao testDao;
    private  TestService testService;

    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = { "classpath:conf/user.xml" })
    @ExpectedDatabase(value = "classpath:conf/insertUser.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { "classpath:conf/user.xml" })
    public void test(){

        try {
            String id = "1";
            String name = "qiaomu";
            int age = 20;
            User user  = new User();
            user.setId(id);
            user.setName(name);
            user.setAge(age);
            testService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
