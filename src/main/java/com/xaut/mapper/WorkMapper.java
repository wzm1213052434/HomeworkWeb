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
	void addWork(Work work);
	
	/**
	 * 功能：教师删除作业
	 * @param wno
	 */
	void deteteWork(String wno);
	
	/**
	 * 功能：根据课程号查看发布作业次数
	 * @param cno
	 * @return
	 */
	int findWorkTimesByCno(String cno);
	
	/**
     * function:获得学生所选作业概况
     * @param 学生账号
     * @return 作业号 作业名 所属课程名 开课老师 起始时间 截止时间 剩余提交次数 是否批改 评分 是否公布
     */
    List<Map<String, Object>> getWorkSurvey(@Param("username") String username);
    
    /**
     * function:公布的作业概况
     * @return 作业 所属课程 开课老师 作业评分 公布人
     */
    List<Map<String, Object>> getPublishWorkSurvey();
    
    /**
     * function:学生某个作业的详细信息(学生作业表 + 作业表)
     * description：多表连接时：Mybatis会去除重复列，去除空值的列
     * @param username
     * @param wno
     * @return
     */
    Map<String, Object> getWorkDetail(@Param("username") String username,@Param("wno") String wno);
    
    /**
     * function:动态sql更新学生作业表
     * @param map
     */
    void updateStudentWork(Map<String, Object> map);
}