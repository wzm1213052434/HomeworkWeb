package com.xaut.util;

import org.junit.Test;

public class SqlInitHandlerTest {

	/**
	 * 功能：sql脚本 转为 数据库数据
	 */
    @Test
    public void init() {
        SqlInitHandler.run();
        System.out.println("数据库更新完成");
    }
}