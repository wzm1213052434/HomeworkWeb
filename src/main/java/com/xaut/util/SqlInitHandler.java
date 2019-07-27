package com.xaut.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by 旺旺
 * 2019/7/26 22:12
 * 运行SQL脚本更新数据库
 */
@Component
public final class SqlInitHandler {

    private static final String SQL_SCHEMA = "HomeWorkWeb-schema";
    private static final String SQL_DATA = "HomeWorkWeb-data";

    public static void run() {
        try {
            Properties properties = Resources.getResourceAsProperties("properties/db.properties");

            String url = properties.getProperty("jdbc.url");
            String userName = properties.getProperty("jdbc.username");
            String passWord = properties.getProperty("jdbc.password");

            Connection connection = DriverManager.getConnection(url, userName, passWord);

            ScriptRunner runner = new ScriptRunner(connection);
            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);

            runner.runScript(Resources.getResourceAsReader("sql/" +SQL_SCHEMA+ ".sql"));
            System.out.println("=========== 更新表成功 ============");
            runner.runScript(Resources.getResourceAsReader("sql/" +SQL_DATA+ ".sql"));
            System.out.println("=========== 更新数据成功 ===========");

            connection.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

}
