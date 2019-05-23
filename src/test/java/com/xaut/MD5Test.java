package com.xaut;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Test {
	/**
     * 密码加密
     */
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456", "2222123456");
        System.out.println(md5Hash);
    }
}
