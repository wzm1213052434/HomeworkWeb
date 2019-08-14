package com.xaut.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.springframework.stereotype.Component;

/**
 * 功能：保存后端Json数据到本地Json文件，为html模拟数据，不用启动后端服务
 * 时间：2019-8-14 早
 */
@Component
public class JsonUtil {
	/**
	 * 功能：创建文件
	 * 参数：路径 文件名
	 */
	public File createFile(String dirPath,String fileName) throws Exception {
		//1.创建文件夹
		File filePath = new File(dirPath);
		if(!filePath.exists()) {
			filePath.mkdirs();
		}
		
		//2.创建文件
		File targetFile = new File(filePath,fileName);
		if(!targetFile.exists()) {
			targetFile.createNewFile();
		}
		
		return targetFile;
	}
	
	/**
	 * 功能：写文件(覆盖原内容)
	 * @param 内容 文件
	 */
	public void writeFile(String content,File file) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			out.write(content.getBytes("utf-8"));
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 功能：读文件
	 * @param file
	 */
	public String readFile(File file) throws Exception {
		String result = "";
		
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String read = null;
		while((read=bufferedReader.readLine()) != null){
	    	result = result + read + "\r\n";
		}
		bufferedReader.close();
		fileReader.close();
		
		return result.trim(); //删除字符串的头尾空白符
	}
}