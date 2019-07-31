package com.xaut.mapper;

import com.xaut.entity.Student;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 学生相关接口
 */
@Repository
public interface StudentMapper {

    /**
     *	功能：新增学生
     * @param student
     */
    public void addStudent(Student student);
    
    /**
     *	功能：删除学生
     * @param sno
     */
    public void deleteStudent(String sno);
    
    /**
     *	功能：学生选课
     * @param sno cno state score updatetime
     */
    public void studentSelectCourse(Map<String, Object> map);
    
    /**
     *	功能：学生退课
     * @param sno cno
     */
    public void studentUndoCourse(@Param("sno") String sno,@Param("cno") String cno);
    
    /**
     *	功能：学生选作业
     * @param map
     */
    public void studentSelectWork(Map<String, Object> map);
    
    /**
     *	功能：学生根据作业号退选作业
     * @param cno
     * @param wno
     */
    public void studentUndoWork(@Param("sno") String sno,@Param("wno") String wno);

    /**
     * 功能：根据课程号分页查询学生
     * @param cno
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> getStudentByCourse(@Param("cno") String cno,
                                                        @Param("startPage") Integer startPage,
                                                        @Param("rows") Integer rows) throws Exception;

    /**
     * 功能：根据课程号分页查询学生时提供总数
     * @param cno
     * @return
     * @throws Exception
     */
    public int countStudent(@Param("cno") String cno) throws Exception;
}