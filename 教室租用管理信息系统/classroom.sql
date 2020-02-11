/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : classroom

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-04-10 16:53:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classroom_order
-- ----------------------------
DROP TABLE IF EXISTS `classroom_order`;
CREATE TABLE `classroom_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `order_state` int(10) DEFAULT NULL COMMENT '订单状态 1：审核中 2：已审核 3.撤回',
  `order_examine_state` int(10) DEFAULT NULL COMMENT '审核状态 1：审核通过 2：审核不通过',
  `order_appointment_time` date DEFAULT NULL COMMENT '订单预约时间',
  `order_purpose` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用途',
  `order_selection` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '预约的哪一节',
  `order_remark` varchar(255) DEFAULT NULL,
  `order_result` varchar(255) DEFAULT NULL COMMENT '审核结果',
  `order_create_time` datetime DEFAULT NULL,
  `order_update_time` datetime DEFAULT NULL,
  `room_code` varchar(30) DEFAULT NULL,
  `room_building` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '大楼名称',
  `room_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教室门牌号',
  `student_code` varchar(30) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `student_college` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属学院',
  `student_class` varchar(50) DEFAULT NULL,
  `tercher_code` varchar(50) DEFAULT NULL,
  `tercher_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '审核老师姓名',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classroom_order
-- ----------------------------
INSERT INTO `classroom_order` VALUES ('7', 'B20190405221940769', '3', null, '2019-04-07', '书面课', '1-2节', '我要拿来上课', '申请撤回', '2019-04-05 22:19:40', '2019-04-05 22:35:45', 'R20190405221517335', '3号楼', '203', 'S20190405220921871', '朱利敏', '哲学与公共管理学院', '16哲41', null, null);
INSERT INTO `classroom_order` VALUES ('8', 'B20190405223344254', '2', '2', '2019-04-06', '音乐课', '1-2节', '23123', '我不满意你', '2019-04-05 22:33:44', '2019-04-05 22:35:15', 'R20190405221517335', '3号楼', '203', 'S20190405220921871', '朱利敏', '哲学与公共管理学院', '16哲41', 'A20159991855842665', '李键老师');
INSERT INTO `classroom_order` VALUES ('9', 'B20190405223353325', '2', '1', '2019-04-09', '书面课', '1-2节', '23123123', '审核通过', '2019-04-05 22:33:53', '2019-04-05 22:34:44', 'R20190405221535820', '4号楼', '123', 'S20190405220921871', '朱利敏', '哲学与公共管理学院', '16哲41', 'A20159991855842665', '李键老师');

-- ----------------------------
-- Table structure for classroom_room
-- ----------------------------
DROP TABLE IF EXISTS `classroom_room`;
CREATE TABLE `classroom_room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_state` int(11) DEFAULT NULL,
  `room_code` varchar(50) DEFAULT NULL,
  `room_building` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '楼名称',
  `room_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '楼编号',
  `room_sections1` int(5) DEFAULT NULL COMMENT '1-2节',
  `room_sections2` int(5) DEFAULT NULL COMMENT '3-4节',
  `room_sections3` int(5) DEFAULT NULL COMMENT '5-6节',
  `room_sections4` int(5) DEFAULT NULL COMMENT '7-8节',
  `room_people` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '容纳人数',
  `room_purpose` varchar(255) DEFAULT NULL COMMENT '用途',
  `room_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `room_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '位置',
  `room_create_time` datetime DEFAULT NULL,
  `room_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classroom_room
-- ----------------------------
INSERT INTO `classroom_room` VALUES ('7', '1', 'R20190405221517335', '3号楼', '203', '1', '1', '0', '0', '40-50人', '\"书面课\",\"音乐课\",\"美术课\",\"情景模拟\",\"舞会\",\"生物实验室\",\"地理实验室\",\"大型会议室\",\"画室\",\"辩论赛室\",\"钢琴房\",\"小提琴房\"', '这个教室是全新的，但是5-6已经被人占用。', null, '2019-04-05 22:15:17', null);
INSERT INTO `classroom_room` VALUES ('8', '1', 'R20190405221535820', '4号楼', '123', '1', '1', '1', '0', '40-50人', '\"书面课\",\"音乐课\",\"情景模拟\",\"小型晚会\",\"大型会议室\",\"辩论赛室\",\"话剧室\",\"舞蹈房\"', '23123213123', null, '2019-04-05 22:15:35', null);

-- ----------------------------
-- Table structure for classroom_user
-- ----------------------------
DROP TABLE IF EXISTS `classroom_user`;
CREATE TABLE `classroom_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) DEFAULT NULL,
  `user_real_name` varchar(50) DEFAULT NULL,
  `user_code` varchar(50) DEFAULT NULL,
  `user_sex` varchar(10) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `user_role` int(5) DEFAULT NULL,
  `user_create_time` datetime DEFAULT NULL,
  `user_update_time` datetime DEFAULT NULL,
  `user_college` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_classroom` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classroom_user
-- ----------------------------
INSERT INTO `classroom_user` VALUES ('1', 'admin', '202cb962ac59075b964b07152d234b70', '李键', 'A20159991855842665', '保密', '18796632215', '0', null, '2019-03-28 01:26:07', '', '');
INSERT INTO `classroom_user` VALUES ('11', 'xuesheng1', '202cb962ac59075b964b07152d234b70', '朱利敏', 'S20190405220921871', '保密', '18796328756', '1', '2019-04-05 22:09:21', null, '哲学与公共管理学院', '16哲41');
INSERT INTO `classroom_user` VALUES ('12', 'xuesheng2', '202cb962ac59075b964b07152d234b70', '朱利敏2', 'S20190405221016883', '男生', '18796328756', '1', '2019-04-05 22:10:16', null, '文学院', '13文41');
