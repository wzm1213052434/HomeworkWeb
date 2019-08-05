package com.xaut.service;

import com.xaut.util.ResponseBean;

/**
 * 学生相关业务接口
 */
public interface StudentService {

    /**
     * 根据课程号分页查询学生
     * @param cno
     * @param page
     * @param rows
     * @return
     */
    ResponseBean getStudentByCourse(String cno, Integer page, Integer rows, Boolean isPage);

}