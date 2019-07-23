package com.xaut.mapper;

import com.xaut.entity.Teacher;
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
    public int addTeacher(Teacher teacher) throws Exception;
}
