/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : supermarket

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 18/02/2020 16:02:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for market_goods
-- ----------------------------
DROP TABLE IF EXISTS `market_goods`;
CREATE TABLE `market_goods`  (
  `goods_id` int(255) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_state` int(10) NULL DEFAULT 1 COMMENT '商品状态 1：启用 0：关闭',
  `goods_big_type` int(10) NULL DEFAULT NULL COMMENT '商品大分类：0：代表全部 1：常见水果 2：进口水果',
  `goods_type` int(10) NULL DEFAULT NULL COMMENT '水果细分种类：0：该大分类下的全部 1：寒性水果 2：温性水果 3：中性水果',
  `goods_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_cost_price` double(10, 2) NULL DEFAULT NULL,
  `goods_rel_price` double(10, 2) NULL DEFAULT NULL COMMENT '商品真实 价格',
  `goods_price` double(10, 2) NULL DEFAULT NULL COMMENT '商品假价格',
  `goods_buy_num` int(50) NULL DEFAULT 0 COMMENT '购买数量',
  `goods_renark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品详情',
  `goods_create_time` datetime(0) NULL DEFAULT NULL,
  `goods_update_time` datetime(0) NULL DEFAULT NULL,
  `goods_inventory` int(255) NULL DEFAULT 0 COMMENT '商品库存量',
  `goods_sort` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品分类',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of market_goods
-- ----------------------------
INSERT INTO `market_goods` VALUES (32, 'G20200214152728338', '/AllImg/BranchImg/20200214/c2374d1c41f1409e8b532e5499f7a55a.jpg', 1, NULL, NULL, 'eeee', 1.50, 2.00, NULL, 0, 'ttttt', '2020-02-14 15:27:28', '2020-02-18 15:43:41', 11, '即食类');

-- ----------------------------
-- Table structure for market_order
-- ----------------------------
DROP TABLE IF EXISTS `market_order`;
CREATE TABLE `market_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `order_type` int(5) NULL DEFAULT NULL COMMENT '1.出库单 2.入库单',
  `order_create_time` datetime(5) NULL DEFAULT NULL,
  `order_update_time` datetime(0) NULL DEFAULT NULL,
  `order_from_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'l来源方式',
  `order_good_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编号',
  `order_good_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名',
  `order_good_sort` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品分类',
  `order_number` int(11) NULL DEFAULT NULL COMMENT '订单数量',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of market_order
-- ----------------------------
INSERT INTO `market_order` VALUES (6, 'O20200218154341613', 2, '2020-02-18 15:43:41.00000', NULL, '人工送货', 'G20200214152728338', 'eeee', '即食类', 11);

-- ----------------------------
-- Table structure for market_user
-- ----------------------------
DROP TABLE IF EXISTS `market_user`;
CREATE TABLE `market_user`  (
  `user_id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '会员资料自增id',
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号',
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `user_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户密码',
  `sex` int(3) UNSIGNED NULL DEFAULT 0 COMMENT '性别，0，保密；1，男；2，女',
  `birthday` date NULL DEFAULT NULL COMMENT '生日日期',
  `mobile_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动电话',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `role` tinyint(5) NULL DEFAULT NULL COMMENT '角色权限 0：管理员 1：项目经理 2：研发技术 3：测试人员',
  `user_sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `mobile_phone`(`mobile_phone`) USING BTREE,
  INDEX `email`(`email`) USING BTREE,
  INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of market_user
-- ----------------------------
INSERT INTO `market_user` VALUES (1, 'S20181218150514531', '3@qq.com', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, '1970-01-01', '18606958002', 'admin', '2018-12-18 15:05:14', 0, '1212');
INSERT INTO `market_user` VALUES (54, 'S20200218155605456', '1033620252@qq.com', 'aaa', 'e10adc3949ba59abbe56e057f20f883e', 1, '2020-02-18', '18796328756', '1111', '2020-02-18 15:56:05', 4, '');

SET FOREIGN_KEY_CHECKS = 1;
