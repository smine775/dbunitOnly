package com.test.service;

import com.test.dao.TestDao;
import com.test.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName:TestService
 * Package:com.test.service
 * Decription:
 *
 * @date:2020/7/13 10:40
 * @author:qiaomu
 */
@Service
public class TestService {

    @Resource
    private TestDao testDao;

    public void insert(User user) throws Exception {

        int i = testDao.insert(user);
        if(i<1){
            throw new Exception("insert语句错误");
        }

        System.out.println(i);


    }
}
