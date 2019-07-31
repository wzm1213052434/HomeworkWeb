package com.xaut.service.impl;

import com.xaut.mapper.StudentMapper;
import com.xaut.util.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xaut.service.StudentService;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 学生相关业务实现
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    // 日志
    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据课程号查询学生
     * @param cno
     * @return
     */
    public ResponseBean getStudentByCourse(String cno) {
        if (StringUtils.isEmpty(cno)) {
            return new ResponseBean(false, "课程号不能为空");
        }
        List<Map<String, Object>> list = null;
        try {
            list = this.studentMapper.getStudentByCourse(cno);
            if (list.size() == 0) {
                return new ResponseBean(false, "该课程无学生选择");
            }
        } catch (Exception e) {
            logger.error("根据课程号查询学生异常: " +e);
            return new ResponseBean(false, "根据课程号查询学生异常");
        }
        return new ResponseBean(true, list, "根据课程号查询学生成功");
    }
}