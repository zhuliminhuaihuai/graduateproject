/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : dormitory

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-03-13 17:39:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dormitory_bedroom
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_bedroom`;
CREATE TABLE `dormitory_bedroom` (
  `bedroom_id` int(11) NOT NULL AUTO_INCREMENT,
  `bedroom_code` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `bedroom_title` varchar(80) COLLATE utf8_croatian_ci DEFAULT NULL,
  `bedroom_number` int(10) DEFAULT NULL COMMENT '房间人数',
  `bedroom_bed` int(10) DEFAULT NULL COMMENT '床铺',
  `bedroom_faculty` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '所属院系',
  `bedroom_type` int(50) DEFAULT NULL COMMENT '房间类型',
  `bedroom_people` int(10) DEFAULT NULL COMMENT '房间目前人数',
  `bedroom_state` int(10) DEFAULT NULL COMMENT '房间状态 1.未住满 2.住满 3.封闭',
  `bedroom_balance` double(10,2) DEFAULT '0.00' COMMENT '房间余额',
  `building_code` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '所属宿舍楼',
  `bedroom_create_time` datetime DEFAULT NULL,
  `bedroom_update_time` datetime DEFAULT NULL,
  `bedroom_detail` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  PRIMARY KEY (`bedroom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=403 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- ----------------------------
-- Records of dormitory_bedroom
-- ----------------------------

-- ----------------------------
-- Table structure for dormitory_building
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_building`;
CREATE TABLE `dormitory_building` (
  `building_id` int(11) NOT NULL AUTO_INCREMENT,
  `building_code` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '编号',
  `building_title` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '标题',
  `building_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '名/字',
  `building_adress` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `building_detail` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `building_sex` int(5) DEFAULT NULL COMMENT '宿舍楼是男生还是女生',
  `building_img` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `building_create_time` datetime DEFAULT NULL,
  `building_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`building_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- ----------------------------
-- Records of dormitory_building
-- ----------------------------

-- ----------------------------
-- Table structure for dormitory_menu
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_menu`;
CREATE TABLE `dormitory_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parentid` int(11) NOT NULL DEFAULT '0' COMMENT '父id',
  `name` varchar(200) NOT NULL DEFAULT '' COMMENT '名称/11111',
  `icon` varchar(50) DEFAULT NULL,
  `urlkey` varchar(256) DEFAULT NULL COMMENT '菜单key',
  `url` varchar(256) DEFAULT NULL COMMENT '链接地址',
  `status` int(11) DEFAULT '1' COMMENT '状态//radio/2,隐藏,1,显示',
  `type` int(11) DEFAULT '1' COMMENT '类型//select/1,根目录,2,a标签,3,a标签_blank,4,外部url',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `level` int(11) DEFAULT '1' COMMENT '级别',
  `create_time` varchar(64) DEFAULT NULL COMMENT '创建时间',
  `create_id` int(11) DEFAULT '0' COMMENT '创建者',
  `office_code` varchar(50) DEFAULT NULL COMMENT '所属机构',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=293 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of dormitory_menu
-- ----------------------------
INSERT INTO `dormitory_menu` VALUES ('1', '0', '后台首页', '&#xe68e;', 'openMain.html', '/manage/user/jumpMain.html', '1', '1', '1', '1', '', '0', '');
INSERT INTO `dormitory_menu` VALUES ('2', '0', '系统设置', '&#xe716;', null, null, '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('3', '2', '管理员管理', '&#xe770;', 'jumpUserManage.html', '/manage/user/jumpUserManage.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('4', '2', '用户权限配置', '&#xe770;', 'jumpUserPermission.html', '/manage/role/jumpUserPermission.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('5', '0', '宿舍大楼管理', '&#xe632;', null, null, '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('6', '5', '宿舍楼列表', '&#xe630;', 'jumpBuildingList.html', '/manage/building/jumpBuildingList.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('279', '5', '创建宿舍楼', '&#xe654;', 'jumpBuildingAdd.html', '/manage/building/jumpBuildingAdd.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('280', '0', '房间管理', '&#xe62b;', null, null, '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('281', '280', '生成房间', '&#xe674;', 'jumpBedRoomAddMany.html', '/manage/bedroom/jumpBedRoomAddMany.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('292', '286', '报修订单列表', '&#xe62d;', 'jumpRepairOrderList.html', '/manage/order/jumpRepairOrderList.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('283', '0', '生活管理', '&#xe62c;', null, null, '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('284', '283', '充值', '&#xe65e;', 'jumpRechargOrderAdd.html', '/manage/order/jumpRechargOrderAdd.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('285', '283', '报修', '&#xe64d;', 'jumpRepairOrderAdd.html', '/manage/order/jumpRepairOrderAdd.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('286', '0', '订单管理', '&#xe609;', null, null, '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('287', '286', '充值订单列表', '&#xe62d;', 'jumpRechargeOrderList.html', '/manage/order/jumpRechargeOrderList.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('288', '0', '学生管理', '&#xe664;', null, null, '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('289', '288', '学生列表', '&#xe6fc;', 'jumpStudentList.html', '/manage/user/jumpStudentList.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('290', '288', '添加学生', '&#xe654;', 'jumpStudentAdd.html', '/manage/user/jumpStudentAdd.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `dormitory_menu` VALUES ('291', '283', '房间详情', '&#xe68e;', 'jumpStudentDetailBedRoom.html', '/manage/user/jumpStudentDetailBedRoom.html', '1', '1', '1', '1', null, '0', null);

-- ----------------------------
-- Table structure for dormitory_order
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_order`;
CREATE TABLE `dormitory_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `order_type` int(10) DEFAULT NULL COMMENT '1.充值订单 2.保修订单',
  `order_state` int(10) DEFAULT NULL COMMENT '1.未受理 2.已受理',
  `order_money` double(10,2) DEFAULT NULL,
  `user_code` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `user_name` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `user_faculty` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `building_code` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `building_name` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `bedroom_code` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `bedroom_name` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL,
  `order_detail` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `order_create_time` datetime DEFAULT NULL,
  `order_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- ----------------------------
-- Records of dormitory_order
-- ----------------------------

-- ----------------------------
-- Table structure for dormitory_role
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_role`;
CREATE TABLE `dormitory_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) NOT NULL DEFAULT '' COMMENT '名称/11111/',
  `status` int(11) DEFAULT '1' COMMENT '状态//radio/2,隐藏,1,显示',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `remark` text COMMENT '说明//textarea',
  `create_time` varchar(64) DEFAULT NULL COMMENT '创建时间',
  `create_id` int(11) DEFAULT '0' COMMENT '创建者',
  `isAdmin` int(3) DEFAULT '0' COMMENT '是否管理员 （0是 1否）',
  `parentId` varchar(50) DEFAULT NULL COMMENT '上级编号',
  `roleType` int(3) DEFAULT '0' COMMENT '角色类型 1平台管理员 2机构 3代理商',
  `userCode` varchar(50) DEFAULT NULL COMMENT '自身编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of dormitory_role
-- ----------------------------
INSERT INTO `dormitory_role` VALUES ('158', '1111', '1', '1', '', '2019-03-08 12:19:19', '0', '0', null, '2', 'M20190307172436942');
INSERT INTO `dormitory_role` VALUES ('159', '朱利敏', '1', '1', '', '2019-03-11 05:00:46', '0', '0', null, '2', 'M20190311170022803');

-- ----------------------------
-- Table structure for dormitory_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_role_menu`;
CREATE TABLE `dormitory_role_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3615 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitory_role_menu
-- ----------------------------
INSERT INTO `dormitory_role_menu` VALUES ('3571', 'M20190307172436942', null);
INSERT INTO `dormitory_role_menu` VALUES ('3572', 'M20190307172436942', '1');
INSERT INTO `dormitory_role_menu` VALUES ('3573', 'M20190307172436942', '2');
INSERT INTO `dormitory_role_menu` VALUES ('3574', 'M20190307172436942', '3');
INSERT INTO `dormitory_role_menu` VALUES ('3575', 'M20190307172436942', '4');
INSERT INTO `dormitory_role_menu` VALUES ('3576', 'M20190307172436942', '5');
INSERT INTO `dormitory_role_menu` VALUES ('3577', 'M20190307172436942', '6');
INSERT INTO `dormitory_role_menu` VALUES ('3578', 'M20190307172436942', '279');
INSERT INTO `dormitory_role_menu` VALUES ('3579', 'M20190307172436942', '280');
INSERT INTO `dormitory_role_menu` VALUES ('3580', 'M20190307172436942', '281');
INSERT INTO `dormitory_role_menu` VALUES ('3581', 'M20190307172436942', '282');
INSERT INTO `dormitory_role_menu` VALUES ('3582', 'M20190307172436942', '283');
INSERT INTO `dormitory_role_menu` VALUES ('3583', 'M20190307172436942', '284');
INSERT INTO `dormitory_role_menu` VALUES ('3584', 'M20190307172436942', '285');
INSERT INTO `dormitory_role_menu` VALUES ('3585', 'M20190307172436942', '286');
INSERT INTO `dormitory_role_menu` VALUES ('3586', 'M20190307172436942', '287');
INSERT INTO `dormitory_role_menu` VALUES ('3587', 'M20190307172436942', '288');
INSERT INTO `dormitory_role_menu` VALUES ('3588', 'M20190307172436942', '289');
INSERT INTO `dormitory_role_menu` VALUES ('3589', 'M20190311170022803', '1');
INSERT INTO `dormitory_role_menu` VALUES ('3590', 'M20190311170022803', '2');
INSERT INTO `dormitory_role_menu` VALUES ('3591', 'M20190311170022803', '3');
INSERT INTO `dormitory_role_menu` VALUES ('3592', 'M20190311170022803', '4');
INSERT INTO `dormitory_role_menu` VALUES ('3593', 'M20190311170022803', '5');
INSERT INTO `dormitory_role_menu` VALUES ('3594', 'M20190311170022803', '6');
INSERT INTO `dormitory_role_menu` VALUES ('3595', 'M20190311170022803', '279');
INSERT INTO `dormitory_role_menu` VALUES ('3596', 'M20190311170022803', '280');
INSERT INTO `dormitory_role_menu` VALUES ('3597', 'M20190311170022803', '281');
INSERT INTO `dormitory_role_menu` VALUES ('3598', 'M20190311170022803', '282');
INSERT INTO `dormitory_role_menu` VALUES ('3599', 'M20190311170022803', '283');
INSERT INTO `dormitory_role_menu` VALUES ('3600', 'M20190311170022803', '284');
INSERT INTO `dormitory_role_menu` VALUES ('3601', 'M20190311170022803', '285');
INSERT INTO `dormitory_role_menu` VALUES ('3602', 'M20190311170022803', '291');
INSERT INTO `dormitory_role_menu` VALUES ('3603', 'M20190311170022803', '286');
INSERT INTO `dormitory_role_menu` VALUES ('3604', 'M20190311170022803', '287');
INSERT INTO `dormitory_role_menu` VALUES ('3605', 'M20190311170022803', '288');
INSERT INTO `dormitory_role_menu` VALUES ('3606', 'M20190311170022803', '289');
INSERT INTO `dormitory_role_menu` VALUES ('3607', 'M20190311170022803', '290');
INSERT INTO `dormitory_role_menu` VALUES ('3608', 'S20190312173514309', '283');
INSERT INTO `dormitory_role_menu` VALUES ('3609', 'S20190312173514309', '284');
INSERT INTO `dormitory_role_menu` VALUES ('3610', 'S20190312173514309', '285');
INSERT INTO `dormitory_role_menu` VALUES ('3611', 'S20190312173514309', '286');
INSERT INTO `dormitory_role_menu` VALUES ('3612', 'S20190312173514309', '287');
INSERT INTO `dormitory_role_menu` VALUES ('3613', 'S20190312173514309', '291');
INSERT INTO `dormitory_role_menu` VALUES ('3614', 'S20190312173514309', '292');

-- ----------------------------
-- Table structure for dormitory_user
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_user`;
CREATE TABLE `dormitory_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id 自增',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登录密码',
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户唯一标识',
  `user_role` int(10) DEFAULT NULL COMMENT '用户角色',
  `user_find_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户找回密码专用',
  `user_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户电话',
  `user_birthday` date DEFAULT NULL COMMENT '用户生日日期',
  `headimg` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户头像',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '市',
  `district` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '区',
  `user_faculty` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_state` int(11) DEFAULT '1' COMMENT '1:未入住 2：已入住',
  `bedroom_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `user_create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `user_update_time` datetime DEFAULT NULL COMMENT '用户更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- ----------------------------
-- Records of dormitory_user
-- ----------------------------
INSERT INTO `dormitory_user` VALUES ('1', 'admin', '202cb962ac59075b964b07152d234b70', 'A20181221150150654', '1', '', '18796328755', '2019-03-13', '/AllImg/BranchImg/20190131/71d0b583c4544416b6f1518fe900b4c3.jpg', null, null, null, '', null, '', '2018-12-22 13:40:11', '2019-01-31 00:27:09');
