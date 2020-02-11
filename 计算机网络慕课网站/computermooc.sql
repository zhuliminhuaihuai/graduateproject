/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : computermooc

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 10/02/2020 02:17:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for education_comment
-- ----------------------------
DROP TABLE IF EXISTS `education_comment`;
CREATE TABLE `education_comment`  (
  `education_comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `education_comment_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education_comment_par_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education_comment_create_time` datetime(0) NULL DEFAULT NULL,
  `education_comment_update_time` datetime(0) NULL DEFAULT NULL,
  `courses_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courses_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studenr_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education_comment_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '留言内容',
  `tercher_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tercher_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`education_comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of education_comment
-- ----------------------------
INSERT INTO `education_comment` VALUES (7, 'C20200206023201774', NULL, '2020-02-06 02:32:01', NULL, 'C20200205220625279', 'Python编程', 'S20190316224732616', '朱利敏', 'sss', 'S20200205220610967', '哈哈哈老师老师');
INSERT INTO `education_comment` VALUES (8, 'C20200206032533479', NULL, '2020-02-06 03:25:33', NULL, 'C20200205220625279', 'Python编程', 'S20190323000448116', '李键', 'nkjbjjh', 'S20200205220610967', '哈哈哈老师老师');
INSERT INTO `education_comment` VALUES (9, 'C20200206032945299', NULL, '2020-02-06 03:29:45', NULL, 'C20200206032853744', 'C编程', 'S20190316224732616', '朱利敏', 'aaaaaaaa', 'S20200206032828981', 'ssss老师');

-- ----------------------------
-- Table structure for education_courses
-- ----------------------------
DROP TABLE IF EXISTS `education_courses`;
CREATE TABLE `education_courses`  (
  `courses_id` int(11) NOT NULL AUTO_INCREMENT,
  `courses_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courses_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courses_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courses_state` int(5) NULL DEFAULT NULL COMMENT '1：开设 2：未开设',
  `courses_create_time` datetime(0) NULL DEFAULT NULL,
  `courses_update_time` datetime(0) NULL DEFAULT NULL,
  `user_rel_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`courses_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of education_courses
-- ----------------------------
INSERT INTO `education_courses` VALUES (25, 'C20200205220625279', 'Python编程', '/AllImg/BranchImg/20200205/21a60fb2f66f4757bdb075afea849dc1.jpg', 1, '2020-02-05 22:06:25', NULL, '哈哈哈老师老师', 'S20200205220610967');
INSERT INTO `education_courses` VALUES (26, 'C20200206032853744', 'C编程', '/AllImg/BranchImg/20200206/4989397963424da1b2ce11ffb0b5c5bf.jpg', 1, '2020-02-06 03:28:53', NULL, 'ssss老师', 'S20200206032828981');

-- ----------------------------
-- Table structure for education_office_message
-- ----------------------------
DROP TABLE IF EXISTS `education_office_message`;
CREATE TABLE `education_office_message`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '信息主键',
  `message_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息标题',
  `message_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名师标题',
  `message_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message_create_time` datetime(0) NULL DEFAULT NULL,
  `message_update_time` datetime(0) NULL DEFAULT NULL,
  `message_state` int(5) NULL DEFAULT NULL COMMENT '1:启用 2：未启用',
  `message_detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '名师介绍',
  `message_video` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频',
  `message_tercher_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师编号',
  `message_tercher_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师名字',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of education_office_message
-- ----------------------------
INSERT INTO `education_office_message` VALUES (18, 'P20200205175726206', 'C++大神', '/AllImg/BranchImg/20200205/51294591980f44d5891cc873181bb76e.jpg', '2020-02-05 17:57:26', NULL, 1, '该教室十分的牛逼！', 'f1e266fdcca0417ca5323b8728c31e57.mp4', 'S20190322231050623', '啊栋');

-- ----------------------------
-- Table structure for education_time_table
-- ----------------------------
DROP TABLE IF EXISTS `education_time_table`;
CREATE TABLE `education_time_table`  (
  `timetable_id` int(11) NOT NULL AUTO_INCREMENT,
  `timetable_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `timetable_state` int(11) NULL DEFAULT NULL,
  `timetable_create_time` datetime(0) NULL DEFAULT NULL,
  `timetable_update_time` datetime(0) NULL DEFAULT NULL,
  `student_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tercher_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tercher_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courses_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courses_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`timetable_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of education_time_table
-- ----------------------------
INSERT INTO `education_time_table` VALUES (27, 'T20200206023003374', NULL, '2020-02-06 02:30:03', NULL, 'S20190316224732616', '朱利敏', 'S20200205220610967', '哈哈哈老师老师', 'C20200205220625279', 'Python编程');
INSERT INTO `education_time_table` VALUES (28, 'T20200206032148874', NULL, '2020-02-06 03:21:48', NULL, 'S20190323000448116', '李键', 'S20200205220610967', '哈哈哈老师老师', 'C20200205220625279', 'Python编程');
INSERT INTO `education_time_table` VALUES (29, 'T20200206032935645', NULL, '2020-02-06 03:29:35', NULL, 'S20190316224732616', '朱利敏', 'S20200206032828981', 'ssss老师', 'C20200206032853744', 'C编程');

-- ----------------------------
-- Table structure for education_user
-- ----------------------------
DROP TABLE IF EXISTS `education_user`;
CREATE TABLE `education_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_role` int(5) NULL DEFAULT NULL,
  `user_create_time` datetime(0) NULL DEFAULT NULL,
  `user_update_time` datetime(0) NULL DEFAULT NULL,
  `tercher_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courses_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courses_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of education_user
-- ----------------------------
INSERT INTO `education_user` VALUES (1, 'admin', '202cb962ac59075b964b07152d234b70', '李想', 'admin', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `education_user` VALUES (2, 'hhh', '202cb962ac59075b964b07152d234b70', '朱利敏', 'S20190316224732616', '保密', '18796328756', 1, '2019-03-16 22:47:32', NULL, NULL, NULL, NULL);
INSERT INTO `education_user` VALUES (6, 'xuesheng1', '202cb962ac59075b964b07152d234b70', '李键', 'S20190323000448116', '男生', '18796328756', 1, '2019-03-23 00:04:48', NULL, NULL, NULL, NULL);
INSERT INTO `education_user` VALUES (8, 'xuesheng2', '202cb962ac59075b964b07152d234b70', '翔宇', 'S20190323140246694', '男生', '18796328756', 1, '2019-03-23 14:02:46', NULL, NULL, '[]', NULL);
INSERT INTO `education_user` VALUES (10, 'xuesheng', '202cb962ac59075b964b07152d234b70', '真实姓名', 'S20190421093351210', '男生', '18796328766', 1, '2019-04-21 09:33:51', NULL, NULL, NULL, NULL);
INSERT INTO `education_user` VALUES (12, '我是老师', '202cb962ac59075b964b07152d234b70', '哈哈哈老师', 'S20200205220610967', '保密', '18796328756', 2, '2020-02-05 22:06:10', NULL, NULL, '\"C编程\",\"Python编程\",\"Java编程\",\"C++编程\",\".NET编程\",\"JavaScript编程\",\"C#编程\",\"PHP编程\",\"SQL编程\",\"Objecttive-C编程\",\"MATLAB编程\",\"R编程\",\"Perl编程\",\"Swift编程\",\"Go编程\",\"PL/SQL编程\",\"Visual Basic编程\",\"A编程\"', NULL);
INSERT INTO `education_user` VALUES (13, 'aa', '202cb962ac59075b964b07152d234b70', 'ssss', 'S20200206032828981', '保密', '18796328756', 2, '2020-02-06 03:28:28', NULL, NULL, '\"C编程\",\"PHP编程\"', NULL);
INSERT INTO `education_user` VALUES (14, 'dddddd', '202cb962ac59075b964b07152d234b70', 'aa', 'S20200206033140481', '女生', '11111111111', 1, '2020-02-06 03:31:40', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for education_video
-- ----------------------------
DROP TABLE IF EXISTS `education_video`;
CREATE TABLE `education_video`  (
  `education_video_id` int(11) NOT NULL AUTO_INCREMENT,
  `education_video_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education_video_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education_video_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education_video_create_time` datetime(0) NULL DEFAULT NULL,
  `education_video_update_time` datetime(0) NULL DEFAULT NULL,
  `education_video_state` int(5) NULL DEFAULT NULL,
  `courses_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courses_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upload_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upload_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tercher_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tercher_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`education_video_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of education_video
-- ----------------------------
INSERT INTO `education_video` VALUES (4, 'V20200210021418477', 'kkk', '3aa46a2fcb7748dba4918e020647b228.mp4', '2020-02-10 02:14:18', NULL, 0, 'C20200205220625279', 'Python编程', '李想', 'admin', '哈哈哈老师老师', 'S20200205220610967');

SET FOREIGN_KEY_CHECKS = 1;
