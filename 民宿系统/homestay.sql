/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : homestay

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 05/03/2020 14:29:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for homestay_comment
-- ----------------------------
DROP TABLE IF EXISTS `homestay_comment`;
CREATE TABLE `homestay_comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `com_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_create_time` datetime(0) NULL DEFAULT NULL,
  `comment_update_time` datetime(0) NULL DEFAULT NULL,
  `comment_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `comment_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人',
  `comment_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人编号',
  `tenant_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房东',
  `tenant_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房东编号',
  `room_simple_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源',
  `room_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homestay_comment
-- ----------------------------
INSERT INTO `homestay_comment` VALUES (1, 'C20200304180649607', '2020-03-04 18:06:49', NULL, 'ad撒大声地', '朱利敏', 'U20200304173208739', '阿栋4', 'U20200304175744189', '27#之“云起”- Free airport pickup service', 'R20200304180140162');
INSERT INTO `homestay_comment` VALUES (2, 'C20200304180655995', '2020-03-04 18:06:55', NULL, '睡多多', '朱利敏', 'U20200304173208739', '阿栋4', 'U20200304175744189', '27#之“云起”- Free airport pickup service', 'R20200304180140162');

-- ----------------------------
-- Table structure for homestay_order
-- ----------------------------
DROP TABLE IF EXISTS `homestay_order`;
CREATE TABLE `homestay_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `order_state` int(10) NULL DEFAULT NULL COMMENT '1.预约中 2.预约成功 3.预约失败',
  `order_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `order_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `check_in_start_time` datetime(0) NULL DEFAULT NULL COMMENT '入住开始时间',
  `check_in_end_time` datetime(0) NULL DEFAULT NULL COMMENT '入住结束时间',
  `check_in_state` int(10) NULL DEFAULT NULL COMMENT '1.未入住 2.已离宿',
  `customer_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入住人',
  `customer_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入住人编号',
  `customer_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入住人身份证号',
  `tenant_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房东',
  `tenant_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房东编号',
  `tenant_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入住人手机号',
  `room_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源编号',
  `room_simple_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源简单介绍',
  `room_rel_price` int(10) NULL DEFAULT NULL COMMENT '房源真实价',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '房源主键',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homestay_order
-- ----------------------------
INSERT INTO `homestay_order` VALUES (4, 'O20200304181802989', 2, '2020-03-04 18:18:02', '2020-03-04 18:19:01', '2020-03-04 00:00:00', '2020-03-05 00:00:00', 1, '朱利敏', 'U20200304173208739', '350322199803290536', '阿栋4', 'U20200304175744189', '18796328756', 'R20200304180140162', '27#之“云起”- Free airport pickup service', 198, 6);
INSERT INTO `homestay_order` VALUES (5, 'O20200304181922865', 3, '2020-03-04 18:19:22', '2020-03-04 18:19:44', '2020-03-02 00:00:00', '2020-03-26 00:00:00', 1, '朱利敏', 'U20200304173208739', '350322199803290536', '阿栋4', 'U20200304175744189', '18796328756', 'R20200304180140162', '27#之“云起”- Free airport pickup service', 198, 6);

-- ----------------------------
-- Table structure for homestay_room
-- ----------------------------
DROP TABLE IF EXISTS `homestay_room`;
CREATE TABLE `homestay_room`  (
  `room_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `room_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间编号',
  `room_state` int(50) NULL DEFAULT NULL COMMENT '房间状态 1.启用 0.未启用',
  `room_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `room_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `room_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源照片',
  `room_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源主题 情侣，商务',
  `room_rel_price` int(10) NULL DEFAULT NULL COMMENT '房源真实价',
  `room_reference_price` int(10) NULL DEFAULT NULL COMMENT '房源参考价',
  `room_simple_remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简单描述',
  `room_bed_number` int(11) NULL DEFAULT NULL COMMENT '床的数量',
  `room_bath_number` int(11) NULL DEFAULT NULL COMMENT '浴室数量',
  `room_wc_number` int(11) NULL DEFAULT NULL COMMENT '厕所数量',
  `room_number` int(11) NULL DEFAULT NULL COMMENT '房间数量',
  `room_max_customer_number` int(11) NULL DEFAULT NULL COMMENT '房源最大入住人数',
  `room_is_dayly_use` int(11) NULL DEFAULT NULL COMMENT '生活用品是否有 1.有 0.没有',
  `room_is_wifi` int(11) NULL DEFAULT NULL COMMENT '是否有wifi 1.有 0.没有',
  `room_is_parking` int(11) NULL DEFAULT NULL COMMENT '是否有停车位 1.有 0.没有',
  `room_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房源简介',
  `upload_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传人',
  `upload_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传人编号',
  `tenant_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房东名字',
  `tenant_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房东编号',
  `room_spare1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `room_spare2` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `room_spare3` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homestay_room
-- ----------------------------
INSERT INTO `homestay_room` VALUES (3, 'R20200301211317175', 1, '2020-03-01 21:13:17', NULL, '/AllImg/BranchImg/20200301/847afb9d164a4a85a4c62178b76b9346.png', '情侣亲密', 2, 1, '客运中心站/高楼层好视野经济卧房/随时响应还可吸猫', 1, 1, 1, 1, 1, 1, 1, 1, '水电费水电费水电费水电费水电费水电费', '1111', 'A20181221150150654', '111', 'U20200227180807947', NULL, NULL, NULL);
INSERT INTO `homestay_room` VALUES (4, 'R20200301211759257', 1, '2020-03-01 21:17:59', NULL, '/AllImg/BranchImg/20200301/b3e0a923c41d42c0bbde1da824d857e3.jpg', '商务出差', 2, 1, 'Patrick Star Home room2 百寸投影 大学城中心 近古城 自助入住', 1, 1, 1, 1, 1, 1, 1, 1, '是否是对方的', '1111', 'A20181221150150654', '111', 'U20200227180807947', NULL, NULL, NULL);
INSERT INTO `homestay_room` VALUES (5, 'R20200304175900401', 1, '2020-03-04 17:59:00', NULL, '/AllImg/BranchImg/20200304/2ccb178963db4cc3a34c66470a72e381.jpg', '情侣亲密', 598, 398, '27#之“花漾”- Free airport pickup service', 1, 1, 1, 1, 2, 1, 1, 1, '好看', '阿栋4', 'U20200304175744189', '阿栋4', 'U20200304175744189', NULL, NULL, NULL);
INSERT INTO `homestay_room` VALUES (6, 'R20200304180140162', 1, '2020-03-04 18:01:40', NULL, '/AllImg/BranchImg/20200304/4e9b24a7c1c641b0bc0bd03ee53bd39b.jpg', '田野风', 198, 298, '27#之“云起”- Free airport pickup service', 1, 1, 1, 1, 2, 1, 1, 1, '好看', '阿栋4', 'U20200304175744189', '阿栋4', 'U20200304175744189', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for homestay_user
-- ----------------------------
DROP TABLE IF EXISTS `homestay_user`;
CREATE TABLE `homestay_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id 自增',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户登录密码',
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户唯一标识',
  `user_role` int(10) NULL DEFAULT NULL COMMENT '用户角色',
  `user_find_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `user_provice` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `user_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `user_region` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `user_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `user_birthday` date NULL DEFAULT NULL COMMENT '用户生日日期',
  `headimg` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `user_create_time` datetime(0) NULL DEFAULT NULL COMMENT '用户创建时间',
  `user_update_time` datetime(0) NULL DEFAULT NULL COMMENT '用户更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homestay_user
-- ----------------------------
INSERT INTO `homestay_user` VALUES (6, 'admin', '202cb962ac59075b964b07152d234b70', 'A20181221150150654', 1, '11111', '1', '', '11', '18796328756', '2020-02-21', '1111', '2020-02-21 18:53:54', NULL);
INSERT INTO `homestay_user` VALUES (16, 'aaaaa', '202cb962ac59075b964b07152d234b70', 'U20200225174021192', 2, NULL, '0', NULL, NULL, '18796328756', NULL, NULL, '2020-02-25 17:40:21', NULL);
INSERT INTO `homestay_user` VALUES (17, 'aaaaa', '202cb962ac59075b964b07152d234b70', 'U20200227180807947', 0, '111', '0', '', '111', '18796328756', '1970-01-01', '111', '2020-02-27 18:08:07', '2020-02-28 11:31:46');
INSERT INTO `homestay_user` VALUES (18, 'zhuhu', '202cb962ac59075b964b07152d234b70', 'U20200304173208739', 2, '350322199803290536', '1', '', '', '18796328756', '1970-01-01', '朱利敏', '2020-03-04 17:32:08', '2020-03-04 17:41:40');
INSERT INTO `homestay_user` VALUES (19, 'fangdong', '202cb962ac59075b964b07152d234b70', 'U20200304173221760', 0, '350322199803290538', '0', '', '', '18796328755', '1970-01-01', '阿栋', '2020-03-04 17:32:21', '2020-03-04 17:32:55');
INSERT INTO `homestay_user` VALUES (20, 'fangdong1', '202cb962ac59075b964b07152d234b70', 'U20200304174742664', 0, '350322199803290539', '0', '', '', '18796328756', '1970-01-01', '阿栋1', '2020-03-04 17:47:42', '2020-03-04 17:48:29');
INSERT INTO `homestay_user` VALUES (21, 'fangdong2', '202cb962ac59075b964b07152d234b70', 'U20200304175040674', 0, '350322199803290538', '0', '', '', '18796328756', '1970-01-01', '阿栋33', '2020-03-04 17:50:40', '2020-03-04 17:51:14');
INSERT INTO `homestay_user` VALUES (22, 'fangdong4', '202cb962ac59075b964b07152d234b70', 'U20200304175744189', 0, '350322199803290534', '0', '', '', '18796328756', '1970-01-01', '阿栋4', '2020-03-04 17:57:44', '2020-03-04 17:58:06');

SET FOREIGN_KEY_CHECKS = 1;
