package com.nbchen.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;

    // 将连接和ThreadLocal绑定,这样可以拿到同一个连接,可以管理事务
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            // 读取数据库配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = connectionThreadLocal.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection(); // 如果ThreadLocal没有连接,从数据库连接池获取链接
                connectionThreadLocal.set(conn); // 保存链接到ThreadLocal,给后面的JDBC操作使用
                conn.setAutoCommit(false); // 设置为手动管理事务
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务,并关闭释放连接
     */
    public static void commitAndClose() {
        Connection conn = connectionThreadLocal.get();
        if (conn != null) { // 如果不等于null,说明之前使用过连接,操作过数据库
            try {
                conn.commit(); // 提交事务
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close(); // 关闭连接,释放资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作,否则就会出错。因为tomcat服务器底层使用了线程池技术
        connectionThreadLocal.remove();
    }

    /**
     * 回滚事务,并关闭释放连接
     */
    public static void rollBackAndClose() {
        Connection conn = connectionThreadLocal.get();
        if (conn != null) { // 如果不等于null,说明之前使用过连接,操作过数据库
            try {
                conn.rollback(); // 回滚事务
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close(); // 关闭连接,释放资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作,否则就会出错。因为tomcat服务器底层使用了线程池技术
        connectionThreadLocal.remove();
    }
}
