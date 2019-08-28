package com.xaut;

import org.apache.shiro.crypto.hash.Md5Hash;
import com.xaut.util.CommonString;

public class MD5Test {
	/**
     * 密码加密
     */
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash(CommonString.DEFAULT_PASSWORD, "admin");//密码：123456，用账号作为盐
        System.out.println(md5Hash);
    }
}