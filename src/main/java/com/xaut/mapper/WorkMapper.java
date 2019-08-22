package com.xaut.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.xaut.entity.Work;

@Repository
public interface WorkMapper {
	/**
	 * 功能：教师新增作业
	 * @param work
	 */
	public void addWork(Work work);
	
	/**
	 * 功能：教师删除作业
	 * @param wno
	 */
	public void deteteWork(String wno);
	
	/**
	 * 功能：根据课程号查看发布作业次数
	 * @param cno
	 * @return
	 */
	public int findWorkTimesByCno(String cno);
	
	/**
     * function:获得学生所选作业概况
     * @param 学生账号
     * @return 作业名	所属课程名	开课老师	起始时间	截止时间	剩余提交次数	是否批改	评分
     */
    List<Map<String, Object>> getWorkSurvey(@Param("username") String username);
}