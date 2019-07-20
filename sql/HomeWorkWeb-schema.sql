/*
create database HomeWorkWeb;    
*/
use HomeWorkWeb;

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
CREATE TABLE `db_student` (
 `sno` char(10) NOT NULL COMMENT '学号',
 `sname` varchar(20) NOT NULL COMMENT '姓名',
 `depart` varchar(30) NOT NULL COMMENT '专业',
 `mailbox` varchar(50) COMMENT '邮箱',
 `updatetime` datetime NOT NULL COMMENT '更新时间',
 `remark1` varchar(100) NOT NULL COMMENT '预留',
 `remark2` varchar(100) NOT NULL COMMENT '预留',
 PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='学生表';

/* 2.教师表 */
DROP TABLE IF EXISTS `db_teacher`;
CREATE TABLE `db_teacher` (
 `tno` char(6) NOT NULL COMMENT '教师工号',
 `tname` varchar(20) NOT NULL COMMENT '姓名',
 `company` varchar(30) NOT NULL COMMENT '学院',
 `updatetime` datetime NOT NULL COMMENT '更新时间',
 `remark1` varchar(100) NOT NULL COMMENT '预留',
 `remark2` varchar(100) NOT NULL COMMENT '预留',
 PRIMARY KEY (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='教师表';

/* 3.课程表 */
DROP TABLE IF EXISTS `db_course`;
CREATE TABLE `db_course` (
 `cno` varchar(50) NOT NULL COMMENT '课程号',
 `tno` char(6) NOT NULL COMMENT '教职工号',
 `cname` varchar(30) NOT NULL COMMENT '课程名',
 `year` varchar(10) NOT NULL COMMENT '学年',
 `term` varchar(8) NOT NULL COMMENT '学期',
 `time` varchar(50) NOT NULL COMMENT '上课时间',
 `place` varchar(50) NOT NULL COMMENT '上课地点',
 `state` boolean default false NOT NULL COMMENT '是否结课',
 `stablename` varchar(50) COMMENT '选课表名',
 `updatetime` datetime NOT NULL COMMENT '更新时间',
 `remark1` varchar(100) NOT NULL COMMENT '预留',
 `remark2` varchar(100) NOT NULL COMMENT '预留',
 PRIMARY KEY (`cno`),
 FOREIGN KEY (`tno`) REFERENCES `db_teacher`(`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='课程表';

/* 4.作业表 */
DROP TABLE IF EXISTS `db_work`;
CREATE TABLE `db_work` (
 `wno` varchar(50) NOT NULL COMMENT '作业号',
 `cno` varchar(50) NOT NULL COMMENT '课程号',
 `wname` varchar(20) NOT NULL COMMENT '作业名',
 `desc` varchar(500) COMMENT '作业描述',
 `start_time` datetime NOT NULL COMMENT '发布时间',
 `end_time` datetime NOT NULL COMMENT '结束时间',
 `updatetime` datetime NOT NULL COMMENT '更新时间',
 `remark1` varchar(100) NOT NULL COMMENT '预留',
 `remark2` varchar(100) NOT NULL COMMENT '预留',
 PRIMARY KEY (`wno`),
 FOREIGN KEY (`cno`) REFERENCES `db_course`(`cno`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='作业表';

/* 5.公告表 */
DROP TABLE IF EXISTS `db_announcement`;
CREATE TABLE `db_announcement` (
 `ano` varchar(50) NOT NULL COMMENT '公告号',
 `cno` varchar(50) NOT NULL COMMENT '课程号',
 `aname` varchar(50) NOT NULL COMMENT '公告名',
 `desc` varchar(500) NOT NULL COMMENT '公告描述',
 `occurtime` datetime NOT NULL COMMENT '发布时间',
 `updatetime` datetime NOT NULL COMMENT '更新时间',
 `remark1` varchar(100) NOT NULL COMMENT '预留',
 `remark2` varchar(100) NOT NULL COMMENT '预留',
 PRIMARY KEY (`ano`),
 FOREIGN KEY (`cno`) REFERENCES `db_course`(`cno`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='公告表';

/* 6.学生课程表 */
DROP TABLE IF EXISTS `db_studcour`;
CREATE TABLE `db_studcour` (
 `sno` char(10) NOT NULL COMMENT '学生学号',
 `cno` varchar(50) NOT NULL COMMENT '课程号',
 `state` boolean NOT NULL COMMENT '是否可提交',
 `score` int COMMENT '总成绩',
 `updatetime` datetime NOT NULL COMMENT '更新时间',
 `remark1` varchar(100) NOT NULL COMMENT '预留',
 `remark2` varchar(100) NOT NULL COMMENT '预留',
 PRIMARY KEY (`sno`,`cno`),
 FOREIGN KEY (`sno`) REFERENCES `db_student`(`sno`),
 FOREIGN KEY (`cno`) REFERENCES `db_course`(`cno`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='学生课程表';

/* 7.学生作业表 */
DROP TABLE IF EXISTS `db_studwork`;
CREATE TABLE `db_studwork` (
 `sno` char(10) NOT NULL COMMENT '学生学号',
 `wno` varchar(50) NOT NULL COMMENT '作业号',
 `subtime` datetime NOT NULL COMMENT '提交时间',
 `times` int NOT NULL COMMENT '可提交次数',
 `correctionstatus` boolean NOT NULL COMMENT '批改状态',
 `state` int COMMENT '重新提交过程状态',
 `comment` varchar(500) COMMENT '评语',
 `evaluate` varchar(500) COMMENT '备注',
 `score` int COMMENT '评分',
 `updatetime` datetime NOT NULL COMMENT '更新时间',
 `remark1` varchar(100) NOT NULL COMMENT '预留',
 `remark2` varchar(100) NOT NULL COMMENT '预留',
 PRIMARY KEY (`sno`,`wno`),
 FOREIGN KEY (`sno`) REFERENCES `db_student`(`sno`),
 FOREIGN KEY (`wno`) REFERENCES `db_work`(`wno`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='学生作业表';

/* 8.用户表 */
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
 `username` varchar(20) NOT NULL COMMENT '账号',
 `password` varchar(100) NOT NULL COMMENT '密码',
 `flag` bigint(2) NOT NULL COMMENT '账号类型',
 `salt` varchar(100) NOT NULL COMMENT '盐',
 `locked` bool default false COMMENT '是否锁定',
 `createtime` datetime NOT NULL COMMENT '更新时间',
 `remark1` varchar(100) NOT NULL COMMENT '预留',
 `remark2` varchar(100) NOT NULL COMMENT '预留',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

/* 9.角色表 */
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
 `rname` varchar(100) NOT NULL COMMENT '角色名称',
 `sn` varchar(100) NOT NULL COMMENT '角色标识符',
 `available` bool default true COMMENT '是否可用',
 `createtime` datetime NOT NULL COMMENT '更新时间',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

/* 10.权限表 */
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
 `pname` varchar(100) NOT NULL COMMENT '权限名称',
 `resource` varchar(100) NOT NULL COMMENT '权限标识符',
 `available` bool default true COMMENT '是否可用',
 `createtime` datetime NOT NULL COMMENT '更新时间',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

/* 11.用户角色表 */
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
 `uid` bigint(20) NOT NULL COMMENT 'uid',
 `rid` bigint(20) NOT NULL COMMENT 'rid',
 `createtime` datetime NOT NULL COMMENT '更新时间',
 PRIMARY KEY (`uid`,`rid`), 
 FOREIGN KEY (`uid`) REFERENCES `users`(`id`),
 FOREIGN KEY (`rid`) REFERENCES `role`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';

/* 12.角色权限表 */
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
 `rid` bigint(20) NOT NULL COMMENT 'rid',
 `pid` bigint(20) NOT NULL COMMENT 'pid',
 `createtime` datetime NOT NULL COMMENT '更新时间',
 PRIMARY KEY (`rid`,`pid`), 
 FOREIGN KEY (`rid`) REFERENCES `role`(`id`),
 FOREIGN KEY (`pid`) REFERENCES `permission`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限表';