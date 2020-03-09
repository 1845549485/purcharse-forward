package cn.eight.purcharseforward.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//连接池类
public class DbPool {
    private static ComboPooledDataSource ds;

    static {
        //创建连接池对象并设置属性
        ds=new ComboPooledDataSource();
        //读取属性文件中的值
        Properties properties=new Properties();
        try {
            //加载输入流，传入文件名（根目录下）
            properties.load(DbPool.class.getClassLoader().getResourceAsStream("db.properties"));
            //设置连接池的基本属性
            ds.setDriverClass(properties.getProperty("driverName"));
            ds.setJdbcUrl(properties.getProperty("url"));
            ds.setUser(properties.getProperty("username"));
            ds.setPassword(properties.getProperty("password"));
            ds.setInitialPoolSize(Integer.valueOf(properties.getProperty("InitialPoolSize")));
            ds.setMinPoolSize(Integer.valueOf(properties.getProperty("MinPoolSize")));
            ds.setMaxIdleTime(Integer.valueOf(properties.getProperty("MaxIdleTime")));
            ds.setMaxPoolSize(Integer.valueOf(properties.getProperty("MaxPoolSize")));
            ds.setMaxStatements(Integer.valueOf(properties.getProperty("MaxStatements")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
