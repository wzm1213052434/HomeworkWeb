package com.xaut.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xaut.mapper.StudentMapper;
import com.xaut.mapper.WorkMapper;
import com.xaut.service.StudentService;
import com.xaut.util.CommonString;
import com.xaut.util.ResponseBean;

/**
 * 学生相关业务实现
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    // 日志
    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;
    
    @Autowired
    private WorkMapper workMapper;

    /**
     *	根据课程号分页查询学生
     * @param cno
     * @return
     */
    public ResponseBean getStudentByCourse(String cno, Integer page, Integer rows, Boolean isPage) {
        if (StringUtils.isEmpty(cno)) {
            return new ResponseBean(false, "课程号不能为空");
        }
        if (page == 0 || rows == 0) { // page和rows为0时,为其设置默认值
            page = Integer.parseInt(CommonString.ONE);
            rows = Integer.parseInt(CommonString.TEN);
        }
        int startPage = (rows * page) - rows;
        List<Map<String, Object>> list = null;
        String total = null;
        try {
            total = Integer.toString(this.studentMapper.countStudent(cno)); // 总数
            list = this.studentMapper.getStudentByCourse(cno, startPage, rows, isPage);
            if (list.size() == 0) {
                return new ResponseBean(false, "该课程无学生选择");
            }
        } catch (Exception e) {
            logger.error("根据课程号查询学生异常: " +e);
            return new ResponseBean(false, "根据课程号查询学生异常");
        }
        return new ResponseBean(true, list, total);
    }
    
    /**
     * function：根据学生账号获得学生姓名
     * @param username
     * @return
     */
    public String findStudentNameByUsername(String username) {
    	return studentMapper.getStudentNameByUsername(username);
    }
    
    /**
     * function：获得学生所选课程概况
     * @param username
     * @param isClassEnd
     * @return
     */
    public ResponseBean getCourseSurvey(String username,String isClassEnd){
    	if (StringUtils.isEmpty(username) || StringUtils.isEmpty(isClassEnd)) {
			return new ResponseBean(false, "参数为空");
		}
    	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = this.studentMapper.getCourseSurvey(username, isClassEnd);
			if (list.size() == 0) {
				if(isClassEnd.equals("0")) {
					return new ResponseBean(true, list, "该学生未结课程为空");
				}
				else if(isClassEnd.equals("1")) {
					return new ResponseBean(true, list, "该学生已结课程为空");
				}
			}
		} catch (Exception e) {
			return new ResponseBean(false, "获得学生所选课程概况异常");
		}
		
		return new ResponseBean(true, list, "获得学生所选课程概况成功");
    }
    
    /**
     * function:学生提交作业	前往改变	学生作业表
     * @param userName
     * @param wno
     */
    public ResponseBean studentSubmitWorkToUpdate(String userName,String wno,String originalFilename) {
    	//1. 查询学生作业表
    	Map<String,Object> data = workMapper.getWorkDetail(userName, wno);
    	
    	//2.更新学生作业表(评论,成绩保持为上一次的)
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("username",userName);
    	map.put("wno",wno);
    	map.put("studentWorkName",originalFilename); //提交作业文件名-更新
    	map.put("subTime",new java.sql.Date(new Date().getTime())); //提交时间-更新
    	map.put("times",Integer.parseInt((String) data.get("times"))-1); //剩余提交次数-减1
    	map.put("isCorrect","0"); //是否批改-为否
		map.put("updateTime",new java.sql.Date(new Date().getTime())); //更新时间-更新
		map.put("isPublish","0"); //是否发布-为否
		return updateStudentWork(map);
    }
    
    /**
     * function:更新学生作业表
     * @param map
     * @return
     */
    public ResponseBean updateStudentWork(Map<String, Object> map) {
    	if(map == null) {
    		return new ResponseBean(false, "参数为空");
    	}
    	
    	try {
    		workMapper.updateStudentWork(map);
    	} catch(Exception e) {
    		return new ResponseBean(false, "更新学生作业表异常");
    	}
    	
    	return new ResponseBean(true, "更新学生作业表成功");
    }
    
    /**
     * function:学生详细信息
     * @param sno
     * @return
     */
    public ResponseBean getStudentDetail(String sno) {
    	if (StringUtils.isEmpty(sno)) {
			return new ResponseBean(false, "参数为空");
		}
    	
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = studentMapper.getStudentDetail(sno);
			if (map == null) {
				return new ResponseBean(true, map, "没有该学生");
			}
		} catch (Exception e) {
			return new ResponseBean(false, "获得学生详细信息异常");
		}
		
		return new ResponseBean(true, map, "获得学生详细信息成功");
    }
    
    /**
     * function:动态sql更新学生表
     * @param map
     */
    public ResponseBean updateStudent(Map<String, Object> map) {
    	if (map == null) {
			return new ResponseBean(false, "参数为空");
		}
    	
		String userName = studentMapper.getStudentNameByUsername(map.get("userName").toString());
		if(userName == null || "".equals(userName)) {
			return new ResponseBean(false, "无此学生");
		}
		try {
			studentMapper.updateStudent(map);
		} catch (Exception e) {
			return new ResponseBean(false, "更新学生信息异常");
		}
		
		return new ResponseBean(true, "更新学生信息成功");
	}
}