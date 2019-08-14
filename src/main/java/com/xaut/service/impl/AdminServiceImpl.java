package com.xaut.service.impl;

import com.xaut.mapper.AdminMapper;
import com.xaut.service.AdminService;
import com.xaut.util.CommonString;
import com.xaut.util.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Admin业务实现
 * Created by 旺旺
 * 2019/8/12 22:50
 */
@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    // 日志
    private Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 获取用户群体的统计信息
     * @return
     */
    public ResponseBean getUserGroupInfo() {
        Map<String, Map<String, Object>> resultMap = new HashMap<String, Map<String, Object>>(); // 最终响应数据
        Map<String, Object> adminInfo = new HashMap<String, Object>(); // 管理员数量统计
        Map<String, Object> superAdminInfo = new HashMap<String, Object>(); // 超级管理员数量统计
        Map<String, Object> teacherInfo = new HashMap<String, Object>(); // 教师信息
        Map<String, Object> studentInfo = new HashMap<String, Object>(); // 学生信息
        try {
            // 整体信息统计(all)
            int adminCount = this.adminMapper.findAllUser(CommonString.ADMIN_FLAG, "adminCount"); // 获取管理员总数
            int superAdminCount = this.adminMapper.findAllUser(CommonString.SUPER_ADMIN_FLAG, "superAdminCount"); //获取超级管理员总数
            int studentCount = this.adminMapper.findAllUser(CommonString.STUDENT_FLAG, "studentCount"); //获取学生总数
            int teacherCount = this.adminMapper.findAllUser(CommonString.TEACHER_FLAG, "teacherCount"); //获取教师总数
            adminInfo.put("adminCount", adminCount);
            superAdminInfo.put("superAdminCount", superAdminCount);

            // 教师信息统计(teacherInfo)
            List<Map<String, Object>> fromCompany = adminMapper.groupTeacherInfo();
            int teacherLocked = adminMapper.getAccountStatus(CommonString.TEACHER_FLAG, CommonString.LOCKED); // 账号被锁定的教师人数
            int teacherUnLocked = adminMapper.getAccountStatus(CommonString.TEACHER_FLAG, CommonString.UN_LOCKED); // 账号未被锁定的教师人数
            teacherInfo.put("teacherCount", teacherCount); // 教师人数
            teacherInfo.put("fromCompany", fromCompany); // 教师用户所在的学院和各学院人数
            teacherInfo.put("locked", teacherLocked);
            teacherInfo.put("unLocked", teacherUnLocked);


            // 学生信息统计(studentInfo)
            List<Map<String, Object>> fromMajor = adminMapper.groupStudentInfo();
            int studentLocked = adminMapper.getAccountStatus(CommonString.STUDENT_FLAG, CommonString.LOCKED); // 账号被锁定的学生人数
            int studentUnLocked = adminMapper.getAccountStatus(CommonString.STUDENT_FLAG, CommonString.UN_LOCKED); // 账号未被锁定的学生人数
            studentInfo.put("studentCount", studentCount); // 学生人数
            studentInfo.put("fromMajor", fromMajor); // 学生用户所在的专业和各专业人数
            studentInfo.put("locked", studentLocked);
            studentInfo.put("unLocked", studentUnLocked);

            resultMap.put("adminInfo", adminInfo);
            resultMap.put("superAdminInfo", superAdminInfo);
            resultMap.put("teacherInfo", teacherInfo);
            resultMap.put("studentInfo", studentInfo);
        } catch (Exception e) {
            logger.error("获取用户群体的统计信息异常: ", e);
            return new ResponseBean(false, "获取用户群体的统计信息异常");
        }
        return new ResponseBean(true, resultMap,"获取用户群体的统计信息成功");
    }
}
