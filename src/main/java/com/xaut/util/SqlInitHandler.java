package com.xaut.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.charset.Charset;
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

    /**
     * 功能：sql脚本 转为 数据库数据
     * 注意：此方法sql脚本中不能出现除了分割sql执行语句的';'以外的其他任何的';'
     */
    public static void run() {
        try {
        	//1.读取配置文件
            Properties properties = Resources.getResourceAsProperties("properties/db.properties");

            //2.连接数据库
            String url = properties.getProperty("jdbc.url");
            String userName = properties.getProperty("jdbc.username");
            String passWord = properties.getProperty("jdbc.password");
            Connection connection = DriverManager.getConnection(url, userName, passWord);

            //3.拿到ScriptRunner对象，并设置异常日志和设置普通日志
            ScriptRunner runner = new ScriptRunner(connection);
            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);
            runner.setDelimiter(";"); //每条命令间的分隔符
            runner.setStopOnError(true); //出现error时中断
            Resources.setCharset(Charset.forName("UTF-8")); //设置字符集

            //4.写入sql脚本
            runner.runScript(Resources.getResourceAsReader("sql/" +SQL_SCHEMA+ ".sql"));
            System.out.println("=========== 更新表成功 ============");
            runner.runScript(Resources.getResourceAsReader("sql/" +SQL_DATA+ ".sql"));
            System.out.println("=========== 更新数据成功 ===========");

            //5.关闭连接
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}