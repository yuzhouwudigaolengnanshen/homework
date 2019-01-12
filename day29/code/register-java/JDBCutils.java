package com.westos.sql;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName JDBCutils
 * @Author zhang-peng-zhan
 * @Date 2019/1/11 17:18
 */
public class JDBCutils {
    static final String url_user = "jdbc:mysql://localhost:3306/user" +
            "?rewriteBatchedStatements=true&useCursorFetch=true&defaultFetchSize=50&useSSL=false";
    static final String usename = "root";
    static final String password = "01070511";

    static final DruidDataSource dataSource = new DruidDataSource();
    static {
        dataSource.setUrl(url_user);
        dataSource.setUsername(usename);
        dataSource.setPassword(password);
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver"); 可选步骤，注册驱动
        dataSource.setInitialSize(5); // 初始连接数
        dataSource.setMaxActive(10); // 最大连接数
        dataSource.setMinIdle(5);    // 最小连接数
        dataSource.setValidationQuery("select 1"); // 一条简单的sql语句，用来保活
        dataSource.setTestWhileIdle(true); // 当空闲时时不时检查一下连接的有效性, 利用ValidationQuery中的sql语句
        dataSource.setTimeBetweenEvictionRunsMillis(60*1000); // 默认一分钟
    }
    // 获取数据库连接, 直连
    public static Connection connectionJWGL() throws SQLException {
        return DriverManager.getConnection(url_user,usename,password);
    }
    //// 获取数据库连接, 池连
    public static Connection getConnection2() throws SQLException {
        return dataSource.getConnection();
    }

}
