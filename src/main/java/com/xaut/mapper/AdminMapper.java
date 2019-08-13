package com.xaut.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Admin相关
 * Created by 旺旺
 * 2019/8/13 11:06
 */
@Repository
public interface AdminMapper {

    /**
     * 按角色标记查询所有的用户的数量
     * @return
     * @throws Exception
     */
    int findAllUser(@Param("userFlag") String userFlag,
                    @Param("roleName") String roleName) throws Exception;

    /**
     * 分组获取教师用户所在的学院和各学院人数
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> groupTeacherInfo() throws Exception;

    /**
     * 分组获取学生用户所在的专业和各专业人数
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> groupStudentInfo() throws Exception;

    /**
     * 获取不同角色的账号锁定状态
     * @param roleFlag 角色标记
     * @param isLocked 锁定标记(查询条件:锁定1/未锁定0)
     * @return
     * @throws Exception
     */
    int getAccountStatus(@Param("roleFlag") String roleFlag,
                         @Param("isLocked") String isLocked) throws Exception;
}
