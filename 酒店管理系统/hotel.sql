/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-02-25 20:32:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hotel_room
-- ----------------------------
DROP TABLE IF EXISTS `hotel_room`;
CREATE TABLE `hotel_room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_code` varchar(25) DEFAULT NULL,
  `room_parent_code` varchar(25) DEFAULT 'nullcode',
  `room_is_use` int(5) DEFAULT '1' COMMENT '1:启用0：关闭',
  `room_state` int(11) DEFAULT '0' COMMENT '0:空闲 1：预约 2：已入住',
  `room_detail` varchar(255) DEFAULT NULL,
  `room_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `room_title` varchar(255) DEFAULT NULL,
  `rom_img` varchar(255) DEFAULT NULL,
  `room_create_time` datetime DEFAULT NULL,
  `room_update_time` datetime DEFAULT NULL,
  `user_code` varchar(25) DEFAULT NULL,
  `room_bed_length` varchar(15) DEFAULT NULL COMMENT '床大小',
  `room_areas` varchar(15) DEFAULT NULL COMMENT '房间大小',
  `room_is_window` int(5) DEFAULT '1' COMMENT '是否有窗户 1：有 0：无',
  `room_is_beside_window` int(5) DEFAULT NULL COMMENT '1:外窗 0：内窗',
  `room_is_breakfast` int(5) DEFAULT '1' COMMENT '1:含早0：不含早',
  `room_is_wifi` int(5) DEFAULT '1' COMMENT '1：有wifi 0： 没有',
  `room_is_wc` int(5) DEFAULT '1' COMMENT '1:卫生间 0：没有',
  `room_is_pc` int(5) DEFAULT '1' COMMENT '1:有电脑 0：没有',
  `room_is_tv` int(5) DEFAULT '1' COMMENT '1:有电视 0：没有',
  `room_is_sofa` int(5) DEFAULT '1' COMMENT '1:有沙发 0：没有',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_room
-- ----------------------------
INSERT INTO `hotel_room` VALUES ('10', 'R20190219174445491', 'nullcode', '1', '1', '可以', '2-302', '今生今世', '/AllImg/BranchImg/20190222/8e56c75ce6764dd0bad6522fc6a68400.jpg', '2019-02-19 17:44:45', null, 'U20190225023534956', '单床--1.5m*2.0m', '18㎡', '1', '0', '1', '0', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('14', 'R20190219174632557', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:32', null, '', '单床--1.8m*2.5m', '30㎡', '0', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('15', 'R20190219174632578', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:32', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('16', 'R20190219174633635', 'nullcode', '1', '2', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:33', null, 'U20190225014137873', '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('17', 'R20190219174633582', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:33', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('18', 'R20190219174634942', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:34', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('19', 'R20190219174634319', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:34', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('20', 'R20190219174634493', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:34', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('21', 'R20190219174635329', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:35', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('22', 'R20190219174635271', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:35', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('23', 'R20190219174635749', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:35', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('24', 'R20190219174635875', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:35', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('25', 'R20190219174636661', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:36', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('26', 'R20190219174636468', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:36', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');
INSERT INTO `hotel_room` VALUES ('27', 'R20190219174636434', 'nullcode', '1', '0', '打扫打扫', '3-502', '晋升近视2', '/AllImg/BranchImg/20190219/00a02bc8efe643ce89e3d23aefa1bc88.jpg', '2019-02-19 17:46:36', null, null, '单床--1.8m*2.5m', '30㎡', '1', '1', '1', '1', '0', '1', '0', '0');

-- ----------------------------
-- Table structure for hotel_room_img
-- ----------------------------
DROP TABLE IF EXISTS `hotel_room_img`;
CREATE TABLE `hotel_room_img` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `img_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `room_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属房源的code',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_room_img
-- ----------------------------
INSERT INTO `hotel_room_img` VALUES ('17', '/AllImg/BranchImg/20190219/3acae6c46a5f488b8ea36d42bd7c7348.jpg', 'R20190219172959740');
INSERT INTO `hotel_room_img` VALUES ('18', '/AllImg/BranchImg/20190219/e66fe4b54a3148c6950951800517845c.jpg', 'R20190219172959740');
INSERT INTO `hotel_room_img` VALUES ('19', '/AllImg/BranchImg/20190219/878be6efdcb1451c8aa7b8ba1f56a9d3.jpg', 'R20190219173756889');
INSERT INTO `hotel_room_img` VALUES ('20', '/AllImg/BranchImg/20190219/33c56b7c8adb4d8e805a2b70c54aa66d.jpg', 'R20190219173756889');
INSERT INTO `hotel_room_img` VALUES ('25', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174628944');
INSERT INTO `hotel_room_img` VALUES ('26', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174628944');
INSERT INTO `hotel_room_img` VALUES ('27', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174631948');
INSERT INTO `hotel_room_img` VALUES ('28', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174631948');
INSERT INTO `hotel_room_img` VALUES ('29', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174632557');
INSERT INTO `hotel_room_img` VALUES ('30', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174632557');
INSERT INTO `hotel_room_img` VALUES ('31', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174632578');
INSERT INTO `hotel_room_img` VALUES ('32', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174632578');
INSERT INTO `hotel_room_img` VALUES ('33', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174633635');
INSERT INTO `hotel_room_img` VALUES ('34', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174633635');
INSERT INTO `hotel_room_img` VALUES ('35', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174633582');
INSERT INTO `hotel_room_img` VALUES ('36', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174633582');
INSERT INTO `hotel_room_img` VALUES ('37', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174634942');
INSERT INTO `hotel_room_img` VALUES ('38', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174634942');
INSERT INTO `hotel_room_img` VALUES ('39', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174634319');
INSERT INTO `hotel_room_img` VALUES ('40', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174634319');
INSERT INTO `hotel_room_img` VALUES ('41', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174634493');
INSERT INTO `hotel_room_img` VALUES ('42', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174634493');
INSERT INTO `hotel_room_img` VALUES ('43', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174635329');
INSERT INTO `hotel_room_img` VALUES ('44', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174635329');
INSERT INTO `hotel_room_img` VALUES ('45', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174635271');
INSERT INTO `hotel_room_img` VALUES ('46', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174635271');
INSERT INTO `hotel_room_img` VALUES ('47', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174635749');
INSERT INTO `hotel_room_img` VALUES ('48', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174635749');
INSERT INTO `hotel_room_img` VALUES ('49', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174635875');
INSERT INTO `hotel_room_img` VALUES ('50', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174635875');
INSERT INTO `hotel_room_img` VALUES ('51', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174636661');
INSERT INTO `hotel_room_img` VALUES ('52', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174636661');
INSERT INTO `hotel_room_img` VALUES ('53', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174636468');
INSERT INTO `hotel_room_img` VALUES ('54', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174636468');
INSERT INTO `hotel_room_img` VALUES ('55', '/AllImg/BranchImg/20190219/e9a35959dd73413f87522580f28f864d.jpg', 'R20190219174636434');
INSERT INTO `hotel_room_img` VALUES ('56', '/AllImg/BranchImg/20190219/86fbecfd7609409cae28aa3f768af34d.jpg', 'R20190219174636434');
INSERT INTO `hotel_room_img` VALUES ('62', '/AllImg/BranchImg/20190221/3ddf8566bdf5468e86761d8a6817446d.jpg', 'R20190219174625132');

-- ----------------------------
-- Table structure for hotel_user
-- ----------------------------
DROP TABLE IF EXISTS `hotel_user`;
CREATE TABLE `hotel_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id 自增',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登录密码',
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户唯一标识',
  `user_role` int(10) DEFAULT NULL COMMENT '用户角色',
  `user_id_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户身份证号',
  `user_phone` varchar(50) DEFAULT NULL COMMENT '用户电话',
  `room_code` varchar(255) DEFAULT NULL,
  `room_state` int(5) DEFAULT '2' COMMENT '1:预约 2：已入住 3：退房',
  `user_create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `user_update_time` datetime DEFAULT NULL COMMENT '用户更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_user
-- ----------------------------
INSERT INTO `hotel_user` VALUES ('6', 'admin', '202cb962ac59075b964b07152d234b70', 'A20181221150150654', '1', null, '18796328756', null, '2', null, null);
INSERT INTO `hotel_user` VALUES ('13', '撒比较好吧', null, 'U20190225014137873', '2', '350322199803290538', '18796328756', 'R20190219174633635', '2', '2019-02-25 01:41:37', null);
INSERT INTO `hotel_user` VALUES ('14', '朱利敏', null, 'U20190225023534956', '2', '350322199803290538', '18796328756', 'R20190219174445491', '1', '2019-02-25 02:35:34', null);
