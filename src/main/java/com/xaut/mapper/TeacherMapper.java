package com.xaut.mapper;

import com.xaut.entity.Teacher;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 旺旺
 * 2019/7/20 1:48
 * 教师相关信息
 */
@Repository
public interface TeacherMapper {

    /**
     * 新增教师信息
     * @param teacher
     * @return
     * @throws Exception
     */
    int addTeacher(Teacher teacher) throws Exception;
    
    /**
     * function:根据学号获得已选课程老师
     * @param username
     * @return 教师号 教师名 所属院系 开课数
     */
    List<Map<String, Object>> getTeacherByUsername(String username);
    
    /**
     * function:根据学号获得本院老师
     * @param username
     * @return 教师号 教师名 所属院系 开课数
     */
    List<Map<String, Object>> getCollegeTeacherByUsername(String username);
    
    /**
     * function:老师详细信息
     * @param tno
     * @return
     */
    Map<String, Object> getTeacherDetail(@Param("tno") String tno);
}
