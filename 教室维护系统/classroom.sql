/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : classroom

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 23/01/2020 00:50:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classroom_check
-- ----------------------------
DROP TABLE IF EXISTS `classroom_check`;
CREATE TABLE `classroom_check`  (
  `check_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '检查表主键',
  `check_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查单编号',
  `check_create_time` datetime(0) NULL DEFAULT NULL COMMENT '检查单创建时间',
  `check_update_time` datetime(0) NULL DEFAULT NULL COMMENT '检查单更新时间',
  `check_time` datetime(0) NULL DEFAULT NULL COMMENT '反馈时间',
  `check_state` int(10) NULL DEFAULT NULL COMMENT '检查单状态 1.待反馈 2.反馈完毕',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '教室主键',
  `room_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教室编号',
  `room_is_damage_window` int(20) NULL DEFAULT NULL COMMENT '窗户是否损坏 1.是 0.不是',
  `room_damage_window_number` int(11) NULL DEFAULT 0 COMMENT '窗户损坏数量',
  `room_is_damage_chair` int(50) NULL DEFAULT NULL COMMENT '座椅是否损坏1.是 0.不是',
  `room_damage_chair_number` int(50) NULL DEFAULT 0 COMMENT '座椅损坏数量',
  `room_is_need_chalk` int(255) NULL DEFAULT NULL COMMENT '粉笔是否需要1.需要 0.不需要',
  `room_need_chalk_number` int(255) NULL DEFAULT 0 COMMENT '粉笔需要数量',
  `room_is_damage_platform` int(255) NULL DEFAULT NULL COMMENT '讲台是否损坏1.是 0.不是',
  `room_damage_platform_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '讲台损坏大致原因',
  `room_is_damage_blackboard` int(255) NULL DEFAULT NULL COMMENT '黑板是否损坏1.是 0.不是',
  `room_damage_blackboard_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '黑板损坏大致原因',
  `room_is_damage_media` int(255) NULL DEFAULT NULL COMMENT '多媒体是否损坏 1.是0.不是',
  `room_damage_media_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '多媒体损坏大致原因',
  `room_is_damage_microphone` int(255) NULL DEFAULT NULL COMMENT '麦克风是否损坏1.是 0.不是',
  `room_damage_microphone_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '麦克风损坏大致原因',
  `room_is_damage_door` int(255) NULL DEFAULT NULL COMMENT '门是否损坏1.是0.不是',
  `room_damage_door_number` int(11) NULL DEFAULT 0 COMMENT '门损坏数量',
  `room_damage_door_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门损坏大致原因',
  `room_is_damage_sound` int(255) NULL DEFAULT NULL COMMENT '音响是否损坏1.是0.不是',
  `room_damage_sound_number` int(255) NULL DEFAULT 0 COMMENT '音响损坏数量',
  `room_damage_sound_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '音响损坏大致原因',
  `room_is_damage_curtains` int(255) NULL DEFAULT NULL COMMENT '窗帘是否损坏 1.是0.不是',
  `room_damage_curtains_number` int(11) NULL DEFAULT 0 COMMENT '窗帘损坏数量',
  `room_damage_curtains_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '窗帘损坏大致原因',
  PRIMARY KEY (`check_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom_check
-- ----------------------------
INSERT INTO `classroom_check` VALUES (22, 'C20200123003759720', '2020-01-23 00:37:59', NULL, '2020-01-23 00:39:40', 2, 5, 'R20200123003753436', 0, 0, 0, 0, 0, 0, 0, '', 0, '', 0, '', 0, '', 0, 0, '', 0, 0, '', 0, 0, '');
INSERT INTO `classroom_check` VALUES (23, 'C20200123003956635', '2020-01-23 00:39:56', NULL, '2020-01-23 00:41:29', 2, 5, 'R20200123003753436', 0, 0, 0, 0, 0, 0, 0, '', 0, '', 0, '', 0, '', 0, 0, '', 0, 0, '', 0, 0, '');

-- ----------------------------
-- Table structure for classroom_clean
-- ----------------------------
DROP TABLE IF EXISTS `classroom_clean`;
CREATE TABLE `classroom_clean`  (
  `clean_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '打扫表主键',
  `clean_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打扫单编号',
  `clean_create_time` datetime(0) NULL DEFAULT NULL COMMENT '打扫单创建时间',
  `clean_update_time` datetime(0) NULL DEFAULT NULL COMMENT '打扫单更新时间',
  `clean_time` datetime(0) NULL DEFAULT NULL COMMENT '打扫时间',
  `clean_state` int(5) NULL DEFAULT NULL COMMENT '打扫状态 1.打扫中 2.打扫完毕',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '教室主键',
  `room_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教室编号',
  PRIMARY KEY (`clean_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for classroom_defend
-- ----------------------------
DROP TABLE IF EXISTS `classroom_defend`;
CREATE TABLE `classroom_defend`  (
  `defend_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '维护表主键',
  `defend_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护单编号',
  `defend_create_time` datetime(0) NULL DEFAULT NULL COMMENT '维护单创建时间',
  `defend_update_time` datetime(0) NULL DEFAULT NULL COMMENT '维护单更新时间',
  `defend_state` int(10) NULL DEFAULT NULL COMMENT '维护单状态 1.待维护 2.维护完毕',
  `defend_time` datetime(0) NULL DEFAULT NULL COMMENT '维护时间',
  `check_id` int(11) NULL DEFAULT NULL COMMENT '检查单主键',
  `check_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查单编号',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '教室主键',
  `room_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教室编号',
  `defend_object` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护对象',
  `defend_number` int(11) NULL DEFAULT NULL COMMENT '维护数量',
  `defend_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护理由',
  PRIMARY KEY (`defend_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for classroom_room
-- ----------------------------
DROP TABLE IF EXISTS `classroom_room`;
CREATE TABLE `classroom_room`  (
  `room_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `room_state` int(5) NULL DEFAULT NULL COMMENT '教室是否启用 0：未启用 1：启用 ',
  `room_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教室编号',
  `room_building` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼名称',
  `room_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教室门牌号',
  `room_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置',
  `room_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `room_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `room_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `room_check_state` int(5) NULL DEFAULT 1 COMMENT '教室检查状态 1.检查完毕 2.检查中 3：维护中',
  `room_check_number` int(5) NULL DEFAULT 0 COMMENT '教室检查次数',
  `room_defend_number` int(5) NULL DEFAULT 0 COMMENT '教室维护次数',
  `room_clear_state` int(5) NULL DEFAULT 1 COMMENT '教室打扫状态 1.打扫完毕 2.打扫中',
  `room_clear_number` int(5) NULL DEFAULT 0 COMMENT '教室打扫次数',
  `room_sections1` int(5) NULL DEFAULT NULL COMMENT '1-2节 状态 1：有课 0：没课',
  `room_sections2` int(5) NULL DEFAULT NULL COMMENT '3-4节 状态 1：有课 0：没课',
  `room_sections3` int(5) NULL DEFAULT NULL COMMENT '5-6节 状态 1：有课 0：没课',
  `room_sections4` int(5) NULL DEFAULT NULL COMMENT '7-8节 状态 1：有课 0：没课',
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom_room
-- ----------------------------
INSERT INTO `classroom_room` VALUES (5, 1, 'R20200123003753436', '1号楼', '123', '1111111', '11111', '2020-01-23 00:37:53', '2020-01-23 00:41:29', 1, 2, 0, 1, 0, 1, 1, 1, 0);

-- ----------------------------
-- Table structure for classroom_user
-- ----------------------------
DROP TABLE IF EXISTS `classroom_user`;
CREATE TABLE `classroom_user`  (
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
  `user_college` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_classroom` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom_user
-- ----------------------------
INSERT INTO `classroom_user` VALUES (1, 'admin', '202cb962ac59075b964b07152d234b70', '李键', 'A20159991855842665', '保密', '18796632215', 0, NULL, '2020-01-23 00:42:38', '', '');
INSERT INTO `classroom_user` VALUES (13, 'aaa', '202cb962ac59075b964b07152d234b70', 'zzz', 'S20191220165135695', '男生', '18796328756', 1, '2019-12-20 16:51:35', NULL, NULL, NULL);
INSERT INTO `classroom_user` VALUES (14, 'aaaaa', '202cb962ac59075b964b07152d234b70', 'asdaa', 'S20191220172449172', '保密', '18796328755', 1, '2019-12-20 17:24:49', '2019-12-20 17:38:07', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
