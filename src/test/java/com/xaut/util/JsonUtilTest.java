package com.xaut.util;

import java.io.File;
import org.junit.Test;

public class JsonUtilTest {
	JsonUtil jsonUtil = new JsonUtil();
	
	/**
	 * 测试：操作文件
	 */
	@Test
	public void JsonTest() {
		//1.测试创建文件
		String dirPath = "src/main/webapp/mockJSON"; //项目根目录HomeworkWeb下
		String fileName = "test.txt";
		File file = null;
		try {
			file = jsonUtil.createFile(dirPath,fileName);
			System.out.println("创建成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("创建失败");
		}
		
		//2.测试写文件
		String content = "{\"a\":\"123\",\"b\":\"456\"}";
		jsonUtil.writeFile(content,file);
		System.out.println("写入成功");
		
		//3.测试读文件
		try {
			String result = jsonUtil.readFile(file);
			System.out.println(result);
			System.out.println("读出成功");
		} catch (Exception e) {
			System.out.println("读出失败");
			e.printStackTrace();
		}
	}
}