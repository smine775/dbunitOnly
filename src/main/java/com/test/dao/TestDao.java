package com.test.dao;
/**
 * ClassName:TestDao
 * Package:com.test.dao
 * Decription:
 *
 * @date:2020/7/13 10:55
 * @author:shiqikun
 */

import com.test.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Author 山东彭于晏
 * 2020/7/13
 */
@Mapper
public interface TestDao {
    int insert(User user);
}
