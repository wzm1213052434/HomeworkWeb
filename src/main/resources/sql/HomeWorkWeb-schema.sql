-- create database HomeWorkWeb; 
use HomeWorkWeb;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

/* 如果想清空相关的表,可执行下列语句 */
DROP TABLE IF EXISTS `db_studcour`;
DROP TABLE IF EXISTS `db_studwork`;
DROP TABLE IF EXISTS `db_announcement`;
DROP TABLE IF EXISTS `db_work`;
DROP TABLE IF EXISTS `db_course`;
DROP TABLE IF EXISTS `db_student`;
DROP TABLE IF EXISTS `db_teacher`;
DROP TABLE IF EXISTS `user_roles`;
DROP TABLE IF EXISTS `roles_permissions`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `permission`;


/* 1.学生表 */
DROP TABLE IF EXISTS `db_student`;
CREATE TABLE `db_student`  (
  `sno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
  `sname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `depart` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '专业',
  `mailbox` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  `company` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学院',
  `remark2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生表' ROW_FORMAT = Compact;

/* 2.教师表 */
DROP TABLE IF EXISTS `db_teacher`;
CREATE TABLE `db_teacher`  (
  `tno` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教师工号',
  `tname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `company` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学院',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  `remark1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  `remark2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  PRIMARY KEY (`tno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '教师表' ROW_FORMAT = Compact;

/* 3.课程表 */
DROP TABLE IF EXISTS `db_course`;
CREATE TABLE `db_course`  (
  `cno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程号',
  `tno` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教职工号',
  `cname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程名',
  `year` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学年',
  `term` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学期',
  `time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上课时间',
  `place` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上课地点',
  `isclassend` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否结课',
  `tablename` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选课表名',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  `remark1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  `remark2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  PRIMARY KEY (`cno`) USING BTREE,
  INDEX `tno`(`tno`) USING BTREE,
  CONSTRAINT `db_course_ibfk_1` FOREIGN KEY (`tno`) REFERENCES `db_teacher` (`tno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课程表' ROW_FORMAT = Compact;

/* 4.作业表 */
DROP TABLE IF EXISTS `db_work`;
CREATE TABLE `db_work`  (
  `wno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作业号',
  `cno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程号',
  `wname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作业名',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业描述',
  `start_time` datetime NOT NULL COMMENT '发布时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  `remark1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  `remark2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  PRIMARY KEY (`wno`) USING BTREE,
  INDEX `cno`(`cno`) USING BTREE,
  CONSTRAINT `db_work_ibfk_1` FOREIGN KEY (`cno`) REFERENCES `db_course` (`cno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '作业表' ROW_FORMAT = Compact;

/* 5.公告表 */
DROP TABLE IF EXISTS `db_announcement`;
CREATE TABLE `db_announcement`  (
  `ano` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告号',
  `cno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程号',
  `aname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告名',
  `desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告描述',
  `occurtime` datetime NOT NULL COMMENT '发布时间',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  `isread` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '此公告是否已读',
  `remark2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  PRIMARY KEY (`ano`) USING BTREE,
  INDEX `cno`(`cno`) USING BTREE,
  CONSTRAINT `db_announcement_ibfk_1` FOREIGN KEY (`cno`) REFERENCES `db_course` (`cno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告表' ROW_FORMAT = Compact;

/* 6.学生课程表 */
DROP TABLE IF EXISTS `db_studcour`;
CREATE TABLE `db_studcour`  (
  `sno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生学号',
  `cno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程号',
  `iscansubmit` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否可提交',
  `totalscore` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '总成绩',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  `remark1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  `remark2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  PRIMARY KEY (`sno`, `cno`) USING BTREE,
  INDEX `cno`(`cno`) USING BTREE,
  CONSTRAINT `db_studcour_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `db_student` (`sno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `db_studcour_ibfk_2` FOREIGN KEY (`cno`) REFERENCES `db_course` (`cno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生课程表' ROW_FORMAT = Compact;

/* 7.学生作业表 */
DROP TABLE IF EXISTS `db_studwork`;
CREATE TABLE `db_studwork`  (
  `sno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生学号',
  `wno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作业号',
  `studentworkname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生上交作业名',
  `subtime` datetime NULL COMMENT '提交时间',
  `times` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '可提交次数',
  `iscorrect` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '是否批改',
  `comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评语',
  `score` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评分',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  `ispublish` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '是否公布此作业',
  `remark2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  PRIMARY KEY (`sno`, `wno`) USING BTREE,
  INDEX `wno`(`wno`) USING BTREE,
  CONSTRAINT `db_studwork_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `db_student` (`sno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `db_studwork_ibfk_2` FOREIGN KEY (`wno`) REFERENCES `db_work` (`wno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生作业表' ROW_FORMAT = Compact;

/* 8.用户表 */
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `flag` bigint(2) NOT NULL COMMENT '账号类型',
  `salt` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '盐',
  `locked` tinyint(1) NULL DEFAULT 0 COMMENT '是否锁定',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  `remark1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  `remark2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预留',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

/* 9.角色表 */
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `rname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `sn` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色标识符',
  `available` tinyint(1) NULL DEFAULT 1 COMMENT '是否可用',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

/* 10.权限表 */
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `pname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限名称',
  `resource` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标识符',
  `available` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '是否可用',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Compact;

/* 11.用户角色表 */
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles`  (
  `uid` bigint(20) NOT NULL COMMENT 'uid',
  `rid` bigint(20) NOT NULL COMMENT 'rid',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`, `rid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = Compact;

/* 12.角色权限表 */
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions`  (
  `rid` bigint(20) NOT NULL COMMENT 'rid',
  `pid` bigint(20) NOT NULL COMMENT 'pid',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`rid`, `pid`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  CONSTRAINT `roles_permissions_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `roles_permissions_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;