/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : education

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-05-01 00:31:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for education_courses
-- ----------------------------
DROP TABLE IF EXISTS `education_courses`;
CREATE TABLE `education_courses` (
  `courses_id` int(11) NOT NULL AUTO_INCREMENT,
  `courses_code` varchar(50) DEFAULT NULL,
  `courses_title` varchar(50) DEFAULT NULL,
  `courses_img` varchar(255) DEFAULT NULL,
  `courses_state` int(5) DEFAULT NULL COMMENT '1：开设 2：未开设',
  `courses_create_time` datetime DEFAULT NULL,
  `courses_update_time` datetime DEFAULT NULL,
  `user_rel_name` varchar(50) DEFAULT NULL,
  `user_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`courses_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of education_courses
-- ----------------------------
INSERT INTO `education_courses` VALUES ('2', 'S20190316224732616', '早教英语', 'cc2fe3af2ecb43aaa5a96d27b58bf868.jpg', '1', '2019-03-18 11:07:40', '2019-03-18 11:07:42', '朱利敏 宿舍老师', 'S20190320153744435');
INSERT INTO `education_courses` VALUES ('19', 'C20190321014702822', '早教数学', '/AllImg/BranchImg/20190321/296cb169fbae4b70911f584396d088d3.jpg', '1', '2019-03-21 01:47:02', null, '朱利敏 宿舍老师', 'S20190320153744435');
INSERT INTO `education_courses` VALUES ('20', 'C20190323140159757', '早教语文', '/AllImg/BranchImg/20190323/baedd071c7984bf68ba6031e8db8cdf9.jpg', '1', '2019-03-23 14:01:59', null, '张帆老师', 'S20190323140137518');
INSERT INTO `education_courses` VALUES ('21', 'C20190323145220703', '早教数学', '/AllImg/BranchImg/20190323/166c8774221046018cc084d242604e3c.jpeg', '1', '2019-03-23 14:52:20', null, '啊栋老师', 'S20190322231050623');
INSERT INTO `education_courses` VALUES ('22', 'C20190323145411146', '早教音乐', '/AllImg/BranchImg/20190323/eb348b3018ef47d4a5a62d77bb7f59b9.jpg', '1', '2019-03-23 14:54:11', null, '张帆老师', 'S20190323140137518');
INSERT INTO `education_courses` VALUES ('23', 'C20190324024330930', '早教英语', '/AllImg/BranchImg/20190324/6b643e7601384a5fb615068aafbd406d.jpg', '1', '2019-03-24 02:43:30', null, '啊栋老师', 'S20190322231050623');
INSERT INTO `education_courses` VALUES ('24', 'C20190421093638616', '早教英语', '/AllImg/BranchImg/20190421/f0fd95399cdf480c9e612a87e3af0c24.jpg', '1', '2019-04-21 09:36:38', null, '张帆老师', 'S20190323140137518');

-- ----------------------------
-- Table structure for education_office_message
-- ----------------------------
DROP TABLE IF EXISTS `education_office_message`;
CREATE TABLE `education_office_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_code` varchar(50) DEFAULT NULL COMMENT '机构信息',
  `message_title` varchar(50) DEFAULT NULL COMMENT '信息',
  `message_img` varchar(255) DEFAULT NULL,
  `message_create_time` datetime DEFAULT NULL,
  `message_update_time` datetime DEFAULT NULL,
  `message_state` int(5) DEFAULT NULL COMMENT '1:启用 2：未启用',
  `message_detail` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '信息介绍',
  `message_video` varchar(255) DEFAULT NULL COMMENT '视频',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of education_office_message
-- ----------------------------
INSERT INTO `education_office_message` VALUES ('12', 'P20190220094853425', '教师团队力量', 'cc2fe3af2ecb43aaa5a96d27b58bf868.jpg', '2019-03-16 14:33:51', '2019-03-16 14:37:26', '2', '团队力量', 'f1e266fdcca0417ca5323b8728c31e57.mp4');
INSERT INTO `education_office_message` VALUES ('13', 'P20190220094853425', '教师团队力量', 'cc2fe3af2ecb43aaa5a96d27b58bf868.jpg', '2019-03-16 14:33:51', '2019-03-16 14:37:26', '2', '团队力量', 'f1e266fdcca0417ca5323b8728c31e57.mp4');
INSERT INTO `education_office_message` VALUES ('14', 'P20190220094853425', '教师团队力量', 'cc2fe3af2ecb43aaa5a96d27b58bf868.jpg', '2019-03-16 14:33:51', '2019-03-16 14:37:26', '1', '团队力量', 'f1e266fdcca0417ca5323b8728c31e57.mp4');
INSERT INTO `education_office_message` VALUES ('15', 'P20190220094853425', '教师团队力量', 'cc2fe3af2ecb43aaa5a96d27b58bf868.jpg', '2019-03-16 14:33:51', '2019-03-16 14:37:26', '1', '团队力量', 'f1e266fdcca0417ca5323b8728c31e57.mp4');

-- ----------------------------
-- Table structure for education_time_table
-- ----------------------------
DROP TABLE IF EXISTS `education_time_table`;
CREATE TABLE `education_time_table` (
  `timetable_id` int(11) NOT NULL AUTO_INCREMENT,
  `timetable_code` varchar(50) DEFAULT NULL,
  `timetable_state` int(11) DEFAULT NULL,
  `timetable_create_time` datetime DEFAULT NULL,
  `timetable_update_time` datetime DEFAULT NULL,
  `student_code` varchar(50) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `tercher_code` varchar(50) DEFAULT NULL,
  `tercher_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `courses_code` varchar(50) DEFAULT NULL,
  `courses_title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`timetable_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of education_time_table
-- ----------------------------
INSERT INTO `education_time_table` VALUES ('14', 'T20190323145439430', null, '2019-03-23 14:54:39', null, 'S20190323000448116', '李键', 'S20190323140137518', '张帆老师', 'C20190323145411146', '早教音乐');
INSERT INTO `education_time_table` VALUES ('16', 'T20190323145442321', null, '2019-03-23 14:54:42', null, 'S20190323000448116', '李键', 'S20190322231050623', '啊栋老师', 'C20190323145220703', '早教数学');
INSERT INTO `education_time_table` VALUES ('17', 'T20190323145444388', null, '2019-03-23 14:54:44', '2019-03-24 03:19:47', 'S20190323000448116', '李键', 'S20190322231050623', '啊栋老师', 'C20190324024330930', '早教英语');
INSERT INTO `education_time_table` VALUES ('18', 'T20190323145445632', null, '2019-03-23 14:54:45', null, 'S20190323000448116', '李键', 'S20190320153744435', '朱利敏 宿舍老师', 'C20190321014702822', '早教数学');
INSERT INTO `education_time_table` VALUES ('22', 'T20190421093154618', null, '2019-04-21 09:31:54', null, 'S20190323000448116', '李键', 'S20190323140137518', '张帆老师', 'C20190323140159757', '早教语文');
INSERT INTO `education_time_table` VALUES ('23', 'T20190421093205323', null, '2019-04-21 09:32:05', null, 'S20190323000448116', '李键', 'S20190320153744435', '朱利敏 宿舍老师', 'S20190316224732616', '早教英语');
INSERT INTO `education_time_table` VALUES ('24', 'T20190421093409905', null, '2019-04-21 09:34:09', null, 'S20190421093351210', '真实姓名', 'S20190320153744435', '朱利敏 宿舍老师', 'S20190316224732616', '早教英语');
INSERT INTO `education_time_table` VALUES ('25', 'T20190421093416719', null, '2019-04-21 09:34:16', null, 'S20190421093351210', '真实姓名', 'S20190322231050623', '啊栋老师', 'C20190323145220703', '早教数学');

-- ----------------------------
-- Table structure for education_user
-- ----------------------------
DROP TABLE IF EXISTS `education_user`;
CREATE TABLE `education_user` (
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
  `tercher_code` varchar(50) DEFAULT NULL,
  `courses_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `courses_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of education_user
-- ----------------------------
INSERT INTO `education_user` VALUES ('1', 'admin', '202cb962ac59075b964b07152d234b70', '李想', 'admin', null, null, '0', null, null, null, null, null);
INSERT INTO `education_user` VALUES ('2', 'hhh', '202cb962ac59075b964b07152d234b70', '朱利敏', 'S20190316224732616', '保密', '18796328756', '1', '2019-03-16 22:47:32', null, null, null, null);
INSERT INTO `education_user` VALUES ('4', '我是教师2', '202cb962ac59075b964b07152d234b70', '朱利敏 宿舍', 'S20190320153744435', '保密', '18796328756', '2', '2019-03-20 15:37:44', null, null, '\"早教英语\",\"早教数学\",\"早教语文\",\"早教美术\",\"早教画画\",\"早教表演\",\"早教益智\",\"早教街舞\",\"早教朗诵\",\"早教T台\"', null);
INSERT INTO `education_user` VALUES ('5', 'jiaoshi', '202cb962ac59075b964b07152d234b70', '啊栋', 'S20190322231050623', '保密', '18796328566', '2', '2019-03-22 23:10:50', null, null, '\"早教英语\",\"早教数学\",\"早教主持\",\"早教表演\",\"早教朗诵\",\"早教歌唱\"', null);
INSERT INTO `education_user` VALUES ('6', 'xuesheng1', '202cb962ac59075b964b07152d234b70', '李键', 'S20190323000448116', '男生', '18796328756', '1', '2019-03-23 00:04:48', null, null, null, null);
INSERT INTO `education_user` VALUES ('7', 'jiaoshi2', '202cb962ac59075b964b07152d234b70', '张帆', 'S20190323140137518', '男生', '18796328756', '2', '2019-03-23 14:01:37', null, null, '\"早教英语\",\"早教数学\",\"早教语文\",\"早教音乐\",\"早教主持\",\"早教表演\",\"早教益智\",\"早教跳舞\"', null);
INSERT INTO `education_user` VALUES ('8', 'xuesheng2', '202cb962ac59075b964b07152d234b70', '翔宇', 'S20190323140246694', '男生', '18796328756', '1', '2019-03-23 14:02:46', null, null, '[]', null);
INSERT INTO `education_user` VALUES ('10', 'xuesheng', '202cb962ac59075b964b07152d234b70', '真实姓名', 'S20190421093351210', '男生', '18796328766', '1', '2019-04-21 09:33:51', null, null, null, null);
INSERT INTO `education_user` VALUES ('11', 'jiaoshi1', '202cb962ac59075b964b07152d234b70', '李想', 'S20190421093822461', '保密', '18796328755', '2', '2019-04-21 09:38:22', null, null, '\"早教英语\",\"早教数学\",\"早教语文\",\"早教音乐\",\"早教主持\",\"早教表演\",\"早教益智\",\"早教歌唱\",\"早教朗诵\"', null);
