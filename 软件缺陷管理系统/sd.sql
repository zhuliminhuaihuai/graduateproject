/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80013
Source Host           : 127.0.0.1:3306
Source Database       : sd

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-25 14:41:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sd_bug
-- ----------------------------
DROP TABLE IF EXISTS `sd_bug`;
CREATE TABLE `sd_bug` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bug_title` varchar(20) DEFAULT NULL COMMENT 'bug名称',
  `status` int(2) DEFAULT '0' COMMENT 'bug状态 0待项目经理查看 1经理撤回 2经理忽略该bug 3转移研发，待研发查看 4研发撤回 5研发处理中 6研发已处理 7测试确认已完成BUG',
  `type_id` int(11) DEFAULT NULL COMMENT 'bug分类Id',
  `bug_describe` varchar(255) DEFAULT NULL COMMENT 'bug描述',
  `performance` int(5) DEFAULT '3' COMMENT '优先级 1特急 2一般  3普通',
  `expected_time` datetime DEFAULT NULL COMMENT '预期时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `end_time` datetime DEFAULT NULL COMMENT '解决bug 结束时间',
  `user_id` int(11) DEFAULT NULL COMMENT '创建人用户ID',
  `project_id` int(11) DEFAULT NULL COMMENT '项目ID',
  `project_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目名称',
  `technology_id` int(11) DEFAULT NULL COMMENT '技术ID',
  `technology_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '技术姓名',
  `bug_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '缺陷文档',
  `bug_result` varchar(255) DEFAULT NULL COMMENT '处理结果',
  `withdraw_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '撤回原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sd_bug
-- ----------------------------
INSERT INTO `sd_bug` VALUES ('8', '登陆模块', '7', '4', '1.登录失败情况下 页面404\n2.登录失败 没有提示密码错误或用户名错误', '3', null, '2019-01-23 14:03:32', '2019-01-24 16:30:35', '36', '4', '酒店管理系统', '35', '陈飞', null, '以上问题 都以修复 请确认查看', '');
INSERT INTO `sd_bug` VALUES ('9', '11111', '3', '4', '撒旦水水水水', '1', null, '2019-01-24 16:42:35', null, '36', '4', '酒店管理系统', '0', '/', null, null, '测试');

-- ----------------------------
-- Table structure for sd_bug_classification
-- ----------------------------
DROP TABLE IF EXISTS `sd_bug_classification`;
CREATE TABLE `sd_bug_classification` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id自增',
  `bug_name` varchar(50) DEFAULT NULL COMMENT 'bug名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `bug_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'bug类别描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sd_bug_classification
-- ----------------------------
INSERT INTO `sd_bug_classification` VALUES ('4', '功能不正常', '2019-01-14 20:47:40', '简单地说就是所应提供的功能，在使用上并不符合产品设计规格说明书中规定的要求，或是根本无法使用。这个错误常常会发生在测试过程的初期和中期，有许多在设计规格说明书中规定的功能无法运行，或是运行结果达不到预期设计。最明显的例子就是在用户接口上所提供的选项及动作，使用者操作后毫无反应。');
INSERT INTO `sd_bug_classification` VALUES ('5', '软件在使用上感觉不方便', '2019-01-14 20:48:22', '只要是不知如何使用或难以使用的软件，在产品设计上一定是出了问题。所谓好用的软件，就是使用上尽量方便，使用户易于操作。如微软推出的软件，在用户接口及使用操作上确实是下了一番功夫。有许多软件公司推出的软件产品，在彼此的接口上完全不同，这样其实只会增加使用者的学习难度，另一方面也凸显了这些软件公司的集成能力不足。');
INSERT INTO `sd_bug_classification` VALUES ('6', '软件的结构未做良好规划', '2019-01-14 20:50:15', '这里主要指软件是以自顶向下方式开发，还是以自底向上方式开发。如果是以自顶向下的结构或方法开发的软件，在功能的规划及组织上比较完整，相反以自底向上的组合式方法开发处的软件则功能较为分散，容易出现缺陷');
INSERT INTO `sd_bug_classification` VALUES ('7', '提供的功能不充分', '2019-01-14 20:50:57', '这个问题与功能不正常不同，这里指的是软件提供的功能在运作上正常，但对于使用者而言却不完整。即使软件的功能运作结果符合设计规格的要求，系统测试人员在测试结果的判断上，也必须从使用者的角度进行思考，这就是所谓的“从用户体验出发”。');
INSERT INTO `sd_bug_classification` VALUES ('8', '与软件操作者的互动不良', '2019-01-14 20:51:19', '一个好的软件必须与操作者之间可以实现正常互动。在操作者使用软件的过程中，软件必须很好地响应。例如在浏览网页时，如果操作者在某一网页填写信息，但是输入的信息不足或有误。当点击“确定”按钮后，网页此时提示操作者输入信息有误，却并未指出错误的哪里，操作者只好回到上一页重新填写，或直接放弃离开。这个问题就是典型的在软件对操作互动方面未做完整的设计。');

-- ----------------------------
-- Table structure for sd_project
-- ----------------------------
DROP TABLE IF EXISTS `sd_project`;
CREATE TABLE `sd_project` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `project_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `project_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目概述',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sd_project
-- ----------------------------
INSERT INTO `sd_project` VALUES ('4', '酒店管理系统', '2019-01-22 14:12:06', '暂无', '酒店管理系统是指一种可以提高酒店管理效率的软件或平台，一般包含前台接待、前台收银、客房管家、销售POS、餐饮管理 、娱乐管理、 公关销售、财务查询、电话计费、系统维护、经理查询、工程维修等功能模块', '郑玉荣', '37');

-- ----------------------------
-- Table structure for sd_team
-- ----------------------------
DROP TABLE IF EXISTS `sd_team`;
CREATE TABLE `sd_team` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `team_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目成员姓名',
  `team_position` varchar(255) DEFAULT NULL COMMENT '对应职位',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `project_id` int(5) DEFAULT NULL COMMENT '所属项目Id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sd_team
-- ----------------------------
INSERT INTO `sd_team` VALUES ('18', null, null, null, null, null, '4', '36');
INSERT INTO `sd_team` VALUES ('19', null, null, null, null, null, '4', '35');
INSERT INTO `sd_team` VALUES ('20', null, null, null, null, null, '4', '40');
INSERT INTO `sd_team` VALUES ('21', null, null, null, null, null, '4', '39');
INSERT INTO `sd_team` VALUES ('22', null, null, null, null, null, '4', '38');

-- ----------------------------
-- Table structure for sd_user
-- ----------------------------
DROP TABLE IF EXISTS `sd_user`;
CREATE TABLE `sd_user` (
  `user_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '会员资料自增id',
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户编号',
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '邮箱',
  `user_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户密码',
  `sex` int(3) unsigned DEFAULT '0' COMMENT '性别，0，保密；1，男；2，女',
  `birthday` date DEFAULT NULL COMMENT '生日日期',
  `mobile_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '移动电话',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `role` tinyint(5) DEFAULT NULL COMMENT '角色权限 0：管理员 1：项目经理 2：研发技术 3：测试人员',
  `user_sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `mobile_phone` (`mobile_phone`),
  KEY `email` (`email`),
  KEY `user_name` (`user_name`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='会员信息表';

-- ----------------------------
-- Records of sd_user
-- ----------------------------
INSERT INTO `sd_user` VALUES ('1', 'S20181218150514531', '3@qq.com', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '1', '1970-01-01', '18606958002', 'admin', '2018-12-18 15:05:14', '0', '1212');
INSERT INTO `sd_user` VALUES ('35', 'S20190109204951307', '2@qq.com', 'cf', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-01-09', '11511511511', '陈飞', '2019-01-09 20:49:51', '2', '1sdsd1221');
INSERT INTO `sd_user` VALUES ('36', 'S20190117153052903', '1@qq.com', 'hy', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-01-17', '12312312311', '黄韵', '2019-01-17 15:30:52', '3', '');
INSERT INTO `sd_user` VALUES ('37', 'S20190119142517893', '1@qq.com', 'zyr', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-01-19', '18812341231', '郑玉荣', '2019-01-19 14:25:17', '1', '无');
INSERT INTO `sd_user` VALUES ('38', 'S20190119142721813', '2@qq.com', 'dyy', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-01-19', '18765846547', '董殷勇', '2019-01-19 14:27:21', '2', '');
INSERT INTO `sd_user` VALUES ('39', 'S20190119142800885', '1@qq.com', 'lly', 'e10adc3949ba59abbe56e057f20f883e', '2', '2019-01-19', '15685851231', '兰丽云', '2019-01-19 14:28:00', '3', '');
INSERT INTO `sd_user` VALUES ('40', 'S20190119142930904', '1@qq.com', 'xxx', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-01-19', '14565652332', '肖兴兴', '2019-01-19 14:29:30', '2', '');
INSERT INTO `sd_user` VALUES ('41', 'S20190119143029593', '1@qq.com', 'cfl', 'e10adc3949ba59abbe56e057f20f883e', '2', '2019-01-19', '16955652232', '陈法拉', '2019-01-19 14:30:29', '2', '');
INSERT INTO `sd_user` VALUES ('42', 'S20190119143112631', '1@qq.com', 'lyf', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-01-19', '13066556655', '林羽飞', '2019-01-19 14:31:12', '3', '');
INSERT INTO `sd_user` VALUES ('43', 'S20190119143250776', '1@qq.com', 'xzl', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-01-19', '17899886655', '辛之琳', '2019-01-19 14:32:50', '3', '');
INSERT INTO `sd_user` VALUES ('44', 'S20190123101439757', '25@qq.com', 'wzr', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-01-01', '16966885023', '王智睿', '2019-01-23 10:14:39', '1', '暂无');
