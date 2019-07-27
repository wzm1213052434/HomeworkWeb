package com.xaut.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class SqlInitHandlerTest {

    @Test
    public void init() {
        SqlInitHandler.run();
        System.out.println("数据库更新完成");
    }
}