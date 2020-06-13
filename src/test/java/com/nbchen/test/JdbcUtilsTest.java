package com.nbchen.test;

import com.nbchen.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        Connection conn = JdbcUtils.getConnection();
        System.out.println("conn = " + conn);
        // 获取连接对应释放连接
        // 否则,加入你循环获取100次连接,但是数据库最大连接数为10、
        // 你连接没有归还给连接池,就只能拿到10次连接
//        JdbcUtils.close(conn);
    }
}
