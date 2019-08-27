package com.xaut.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.xaut.util.PageInfo;
import com.xaut.util.ResponseBean;

/**
 * function:通用的分页
 * @author 苏哥哥
 */
@Service("GetListByPage")
public class GetListByPage<T> {
	/**
	 * function:分页显示list
	 * @param list
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public ResponseBean getListByPage(List<T> list,Integer currentPage,Integer pageSize) {
		//1..判断参数
		if (StringUtils.isEmpty(currentPage) || StringUtils.isEmpty(pageSize)) {
			return new ResponseBean(false, "部分参数为空");
		}
		
		//2..具体业务
		PageInfo<T> pageInfo = null;
		try {
			if (list.size() == 0) {
				return new ResponseBean(true, list, "无数据");
			}
			int pageNo = 5; //设置页码显示位数
			pageInfo = new PageInfo<T>(list.size(), currentPage, pageSize , pageNo);
			if(currentPage == pageInfo.getTotalPage()) { //如果最后一页就显示最后一页的几条
	            pageInfo.setList(list.subList((currentPage-1)*pageSize, list.size()));
	        }
	        else { //不是最后一页就显示pageSize条
	            pageInfo.setList(list.subList((currentPage-1)*pageSize, (currentPage-1)*pageSize+pageSize));
	        }
		} catch(Exception e) {
			return new ResponseBean(false, "分页查询异常");
		}
		
		//3..返回数据
		return new ResponseBean(true, pageInfo, "分页查询成功");
	}
}