package com.xaut.service;

import com.xaut.util.ResponseBean;

/**
 * 学生相关业务接口
 */
public interface StudentService {

    /**
     * 根据课程号查询学生
     * @param cno
     * @return
     */
    ResponseBean getStudentByCourse(String cno);

}