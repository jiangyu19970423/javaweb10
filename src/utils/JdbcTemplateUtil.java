package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcTemplateUtil {

    private static DataSource dataSource;



    static {
        Properties pro = new Properties();
        InputStream in = JdbcTemplateUtil.class.getResourceAsStream("/jdbctemplate.properties");
        try {
            pro.load(in);
            try {
                dataSource = DruidDataSourceFactory.createDataSource(pro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据源
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取单个连接
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭资源
     */
    public static void close(Connection conn, Statement stat, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
