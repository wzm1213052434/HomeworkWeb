package com.xaut.mapper;

import com.xaut.entity.Course;
import org.springframework.stereotype.Repository;

/**
 * Created by 旺旺
 * 2019/7/20 1:59
 * 课程相关接口
 */
@Repository
public interface CourseMapper {

    /**
     * 新增课程
     * @param course
     * @return
     * @throws Exception
     */
    public int addCourse(Course course) throws Exception;
}
