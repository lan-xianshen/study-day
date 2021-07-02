package com.lan.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author jianglin.lan
 * @title: UserdDao
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/1 15:30
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert () {
        String sql = "INSERT INTO user( name, age) VALUES (?, ?)";
        jdbcTemplate.update (sql, "zhangsi", 12);
        System.out.println ("插入完成");
    }
}
