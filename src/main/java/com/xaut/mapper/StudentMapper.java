package com.xaut.mapper;

import com.xaut.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * Created by 旺旺
 * 2019/7/20 1:40
 * 学生相关接口
 */
@Repository
public interface StudentMapper {

    /**
     * 根据id(学号)新增学生
     * @param student
     * @return
     * @throws Exception
     */
    public int addStudent(Student student) throws Exception;
}
