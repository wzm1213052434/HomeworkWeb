package com.xaut.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.xaut.entity.Student;

/**
 * 学生相关接口
 */
@Repository
public interface StudentMapper {

    /**
     *	功能：新增学生
     * @param student
     */
    void addStudent(Student student);
    
    /**
     *	功能：删除学生
     * @param sno
     */
    void deleteStudent(String sno);
    
    /**
     *	功能：学生选课
     * @param sno cno state score updatetime
     */
    void studentSelectCourse(Map<String, Object> map);
    
    /**
     *	功能：学生退课
     * @param sno cno
     */
    void studentUndoCourse(@Param("sno") String sno,@Param("cno") String cno);
    
    /**
     *	功能：学生选作业
     * @param map
     */
    void studentSelectWork(Map<String, Object> map);
    
    /**
     *	功能：学生根据作业号退选作业
     * @param cno
     * @param wno
     */
    void studentUndoWork(@Param("sno") String sno,@Param("wno") String wno);

    /**
     *	功能：根据课程号分页查询学生
     * @param cno
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> getStudentByCourse(@Param("cno") String cno,
                                                        @Param("startPage") Integer startPage,
                                                        @Param("rows") Integer rows,
                                                        @Param("isPage") Boolean isPage) throws Exception;

    /**
     *	功能：根据课程号分页查询学生时提供总数
     * @param cno
     * @return
     * @throws Exception
     */
    int countStudent(@Param("cno") String cno) throws Exception;
    
    /**
     * function：根据学生账号获得学生姓名
     * @param username
     * @return
     */
    String getStudentNameByUsername(@Param("username") String username);
    
    /**
     * function:获得学生所选课程概况
     * @param 学生账号 结课/未结课
     * @return 课程号 课程名 开课学期 开课学年 教工号 开课老师 老师学院 此课程作业数 课程公告数
     */
    List<Map<String, Object>> getCourseSurvey(@Param("username") String username,@Param("isClassEnd") String isClassEnd);
    
    /**
     * function:学生详细信息
     * @param sno
     * @return
     */
    Map<String, Object> getStudentDetail(@Param("sno") String sno);
    
    /**
     * function:动态sql更新学生表
     * @param map
     */
    void updateStudent(Map<String, Object> map);
}