create database HomeWorkWeb;
use HomeWorkWeb;

/* 8.用户实体表 */
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
 `username` varchar(20) NOT NULL COMMENT '账号',
 `password` varchar(100) NOT NULL COMMENT '密码',
 `flag` bigint(2) NOT NULL COMMENT '账号类型',
 `salt` varchar(100) NOT NULL COMMENT '盐',
 `locked` bool default false COMMENT '是否锁定',
 `createtime` datetime NOT NULL COMMENT '更新时间',
 `remark1` varchar(100) NOT NULL COMMENT '预留',
 `remark2` varchar(100) NOT NULL COMMENT '预留',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';

/* 9.角色表 */
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
 `rname` varchar(100) NOT NULL COMMENT '角色名称',
 `sn` varchar(100) NOT NULL COMMENT '角色标识符',
 `available` bool default true COMMENT '是否可用',
 `createtime` datetime NOT NULL COMMENT '更新时间',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='角色表';

/* 10.权限表 */
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
 `pname` varchar(100) NOT NULL COMMENT '权限名称',
 `resource` varchar(100) NOT NULL COMMENT '权限标识符',
 `available` bool default true COMMENT '是否可用',
 `createtime` datetime NOT NULL COMMENT '更新时间',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='权限表';

/* 11.用户_角色表 */
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
 `uid` bigint(20) NOT NULL COMMENT 'uid',
 `rid` bigint(20) NOT NULL COMMENT 'rid',
 `createtime` datetime NOT NULL COMMENT '更新时间',
 PRIMARY KEY (`uid`,`rid`), 
 FOREIGN KEY (`uid`) REFERENCES `users`(`id`),
 FOREIGN KEY (`rid`) REFERENCES `role`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户_角色表';

/* 12.角色_权限表 */
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
 `rid` bigint(20) NOT NULL COMMENT 'rid',
 `pid` bigint(20) NOT NULL COMMENT 'pid',
 `createtime` datetime NOT NULL COMMENT '更新时间',
 PRIMARY KEY (`rid`,`pid`), 
 FOREIGN KEY (`rid`) REFERENCES `role`(`id`),
 FOREIGN KEY (`pid`) REFERENCES `permission`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色_权限表';