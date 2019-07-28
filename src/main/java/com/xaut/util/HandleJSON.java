package com.xaut.util;

import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * JSON的相关处理
 * @author 小华
 */
public class HandleJSON {
	/**
	 * 功能：JSON的格式化输出
	 * @param jsonString
	 * @return 格式化后的JSON
	 */
	public String print_JSON(String jsonString) {
		//JSON.parse是将JSON字符串	转为	JSON对象
		String standard_json = JSON.toJSONString(JSON.parse(jsonString),SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
		return standard_json;
	}
	
	/**
	 * 功能：Java的List集合	转为	JSON格式数据字符串
	 */
	public JSONArray to_JSON(List<?> data) {
		JSONArray json = JSONArray.fromObject(data);
		return json;
	}
	
	/**
	 * 功能：Java的对象	转为	JSON格式数据字符串
	 */
	public JSONObject to_JSON(Object data) {
		JSONObject json = JSONObject.fromObject(data);
		return json;
	}
}