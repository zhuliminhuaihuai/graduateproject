/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : weddingphoto

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-01-31 00:32:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wedding_menu
-- ----------------------------
DROP TABLE IF EXISTS `wedding_menu`;
CREATE TABLE `wedding_menu` (
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
) ENGINE=MyISAM AUTO_INCREMENT=279 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of wedding_menu
-- ----------------------------
INSERT INTO `wedding_menu` VALUES ('1', '0', '首页', '&#xe68e;', 'openMain.html', '/manage/user/openMain.html', '1', '1', '1', '1', '', '0', '');
INSERT INTO `wedding_menu` VALUES ('2', '0', '系统设置', '&#xe716;', null, null, '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('3', '2', '用户管理', '&#xe770;', 'jumpUserManage.html', '/manage/user/jumpUserManage.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('4', '2', '用户权限配置', '&#xe770;', 'jumpUserPermission.html', '/manage/role/jumpUserPermission.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('5', '0', '婚纱套餐管理', '&#xe770;', null, null, '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('6', '5', '套餐列表', '&#xe770;', 'jumpPhotoList.html', '/manage/photo/jumpPhotoList.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('7', '5', '婚纱套餐上传', '&#xe770;', 'jumpPhotoAdd.html', '/manage/photo/jumpPhotoAdd.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('8', '0', '婚纱预约管理', '&#xe770;', null, null, '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('9', '8', '婚纱照列表', '&#xe770;', 'jumpPhotoListCustomer.html', '/manage/photo/jumpPhotoListCustomer.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('10', '8', '待拍摄婚纱', '&#xe770;', 'jumpOrderCustomerWaitList.html', '/manage/order/jumpOrderCustomerWaitList.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('11', '8', '拍摄中婚纱', '&#xe770;', 'jumpOrderCustomerShooting.html', '/manage/order/jumpOrderCustomerShooting.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('12', '8', '已拍摄婚纱', '&#xe770;', 'jumpOrderCustomerAlready.html', '/manage/order/jumpOrderCustomerAlready.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('13', '0', '婚纱接单管理', '&#xe770;', null, null, '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('14', '13', '待摄影婚纱', '&#xe770;', 'jumpOrderPhotograpgerWait.html', '/manage/order/jumpOrderPhotograpgerWait.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('15', '13', '摄影中婚纱', '&#xe770;', 'jumpOrderPhotographerShooting.html', '/manage/order/jumpOrderPhotographerShooting.html', '1', '1', '1', '1', null, '0', null);
INSERT INTO `wedding_menu` VALUES ('16', '13', '已摄影婚纱', '&#xe770;', 'jumpOrderPhotographerAlready.html', '/manage/order/jumpOrderPhotographerAlready.html', '1', '1', '1', '1', null, '0', null);

-- ----------------------------
-- Table structure for wedding_order
-- ----------------------------
DROP TABLE IF EXISTS `wedding_order`;
CREATE TABLE `wedding_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `order_customer_name` varchar(255) DEFAULT NULL,
  `order_customer_phone` varchar(255) DEFAULT NULL,
  `order_customer_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户编号',
  `order_photographer_name` varchar(255) DEFAULT NULL,
  `order_photographer_phone` varchar(255) DEFAULT NULL,
  `order_photographer_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '摄影师编号',
  `order_photo_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '照片编号',
  `order_photo_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '照片',
  `order_photo_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '相片标题',
  `order_state` int(10) DEFAULT '0' COMMENT '订单状态 0：客户待拍摄（默认） 1：客户拍摄中 2：客户已拍摄 4：摄影师待摄影 5：摄影师摄影中 6：待客户确认 7：摄影师已摄影 8: 客户撤回婚纱拍摄',
  `order_remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `order_create_time` datetime DEFAULT NULL,
  `order_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wedding_order
-- ----------------------------
INSERT INTO `wedding_order` VALUES ('9', 'O20190129173259757', 'kehu1', '18796328756', 'U20190129165735579', 'sheyingshi1', '18796328756', 'U20190108203005241', 'P20190123151651513', '/AllImg/BranchImg/20190124/b2376cd312694157a8ae2d04012e7919.jpg', '爱你发发发', '2', '', '2019-01-29 17:35:57', null);
INSERT INTO `wedding_order` VALUES ('10', 'O20190129173304740', 'kehu1', '18796328756', 'U20190129165735579', 'sheyingshi1', '18796328756', 'U20190108203005241', 'P20190123151651513', '/AllImg/BranchImg/20190124/b2376cd312694157a8ae2d04012e7919.jpg', '爱你发发发', '1', '', '2019-01-29 17:34:36', null);
INSERT INTO `wedding_order` VALUES ('11', 'O20190129173310597', 'kehu1', '18796328756', 'U20190129165735579', 'sheyingshi2', '18796328756', 'U20190129165636564', 'P20190123151651513', '/AllImg/BranchImg/20190124/b2376cd312694157a8ae2d04012e7919.jpg', '爱你发发发', '0', '', '2019-01-29 17:33:10', null);

-- ----------------------------
-- Table structure for wedding_photo
-- ----------------------------
DROP TABLE IF EXISTS `wedding_photo`;
CREATE TABLE `wedding_photo` (
  `photo_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '婚纱自增id',
  `photo_code` varchar(255) DEFAULT NULL COMMENT '照片code',
  `photo_img` varchar(255) DEFAULT NULL COMMENT '照片地址',
  `photo_create_time` datetime DEFAULT NULL COMMENT '照片创建时间',
  `photo_update_time` datetime DEFAULT NULL COMMENT '照片修改时间',
  `photo_parent_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'nullcode' COMMENT '照片的母照片，为空即为母照片',
  `photo_state` int(11) DEFAULT '0' COMMENT '0：未启用 1 ：启用',
  `photo_title` varchar(255) DEFAULT NULL COMMENT '照片标题',
  `photo_name` varchar(255) DEFAULT NULL COMMENT '照片名称',
  `photo_detail` varchar(255) DEFAULT NULL COMMENT '照片详情',
  `photo_remarks` varchar(255) DEFAULT NULL COMMENT '照片备注',
  PRIMARY KEY (`photo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wedding_photo
-- ----------------------------
INSERT INTO `wedding_photo` VALUES ('42', 'P20190120010748628', '/AllImg/BranchImg/20190120/10b43955404645f48209b4a702a4a821.jpg', '2019-01-20 01:07:48', null, 'nullcode', '1', '钟爱一生', null, '拖后腿肉', '的各个人');
INSERT INTO `wedding_photo` VALUES ('43', 'PC20190120010748508', '/AllImg/BranchImg/20190120/a7f80723455f4046b298a09b8213a67e.png', '2019-01-20 01:07:48', null, 'P20190120010748628', '1', null, null, null, null);
INSERT INTO `wedding_photo` VALUES ('44', 'PC20190120010748917', '/AllImg/BranchImg/20190120/36f9a46d26944b568f5ff596754c096f.png', '2019-01-20 01:07:48', null, 'P20190120010748628', '1', null, null, null, null);
INSERT INTO `wedding_photo` VALUES ('45', 'PC20190120010748954', '/AllImg/BranchImg/20190120/93e2a0cf0bfd4736b855befe2f9277d9.png', '2019-01-20 01:07:48', null, 'P20190120010748628', '1', null, null, null, null);
INSERT INTO `wedding_photo` VALUES ('46', 'PC20190120010748245', '/AllImg/BranchImg/20190120/bd4751dac0014fa0bbea907ab89b6d07.png', '2019-01-20 01:07:48', null, 'P20190120010748628', '1', null, null, null, null);
INSERT INTO `wedding_photo` VALUES ('47', 'P20190123151651513', '/AllImg/BranchImg/20190124/b2376cd312694157a8ae2d04012e7919.jpg', '2019-01-23 15:16:51', null, 'nullcode', '1', '爱你发发发', null, '很好', '很好');
INSERT INTO `wedding_photo` VALUES ('48', 'PC20190123151651844', '/AllImg/BranchImg/20190123/34c62bdb348a452ba2ac60927ccdb87c.jpg', '2019-01-23 15:16:51', null, 'P20190123151651513', '1', null, null, null, null);
INSERT INTO `wedding_photo` VALUES ('49', 'PC20190123151651570', '/AllImg/BranchImg/20190123/a1028a47f9704c078f2513a62ff624bd.jpg', '2019-01-23 15:16:51', null, 'P20190123151651513', '1', null, null, null, null);
INSERT INTO `wedding_photo` VALUES ('50', 'PC20190123151651810', '/AllImg/BranchImg/20190123/22a8a9a5de92488289e38d2923d7453e.jpg', '2019-01-23 15:16:51', null, 'P20190123151651513', '1', null, null, null, null);
INSERT INTO `wedding_photo` VALUES ('51', 'PC20190123151651191', '/AllImg/BranchImg/20190123/218348cbea8b4eb59ce22e9b71ca7940.jpg', '2019-01-23 15:16:51', null, 'P20190123151651513', '1', null, null, null, null);
INSERT INTO `wedding_photo` VALUES ('52', 'PC20190123151652540', '/AllImg/BranchImg/20190123/69e3b3ed86014c86bdd858241c7a87fe.jpg', '2019-01-23 15:16:52', null, 'P20190123151651513', '1', null, null, null, null);

-- ----------------------------
-- Table structure for wedding_role
-- ----------------------------
DROP TABLE IF EXISTS `wedding_role`;
CREATE TABLE `wedding_role` (
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
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of wedding_role
-- ----------------------------
INSERT INTO `wedding_role` VALUES ('150', '摄影1', '1', '1', '', '2019-01-27 05:56:07', '0', '0', null, '0', 'U20190108203005241');
INSERT INTO `wedding_role` VALUES ('151', '客户', '1', '1', '', '2019-01-29 05:06:09', '0', '0', null, '0', 'U20190129165735579');
INSERT INTO `wedding_role` VALUES ('152', '客户23', '1', '1', '', '2019-01-29 05:06:38', '0', '0', null, '0', 'U20190129170052900');
INSERT INTO `wedding_role` VALUES ('153', '摄影师', '1', '1', '', '2019-01-29 05:06:59', '0', '0', null, '0', 'U20190129165636564');

-- ----------------------------
-- Table structure for wedding_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `wedding_role_menu`;
CREATE TABLE `wedding_role_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3479 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wedding_role_menu
-- ----------------------------
INSERT INTO `wedding_role_menu` VALUES ('3461', 'U20190108203005241', '13');
INSERT INTO `wedding_role_menu` VALUES ('3462', 'U20190108203005241', '14');
INSERT INTO `wedding_role_menu` VALUES ('3463', 'U20190108203005241', '15');
INSERT INTO `wedding_role_menu` VALUES ('3464', 'U20190108203005241', '16');
INSERT INTO `wedding_role_menu` VALUES ('3465', 'U20190129165735579', '8');
INSERT INTO `wedding_role_menu` VALUES ('3466', 'U20190129165735579', '9');
INSERT INTO `wedding_role_menu` VALUES ('3467', 'U20190129165735579', '10');
INSERT INTO `wedding_role_menu` VALUES ('3468', 'U20190129165735579', '11');
INSERT INTO `wedding_role_menu` VALUES ('3469', 'U20190129165735579', '12');
INSERT INTO `wedding_role_menu` VALUES ('3470', 'U20190129170052900', '8');
INSERT INTO `wedding_role_menu` VALUES ('3471', 'U20190129170052900', '9');
INSERT INTO `wedding_role_menu` VALUES ('3472', 'U20190129170052900', '10');
INSERT INTO `wedding_role_menu` VALUES ('3473', 'U20190129170052900', '11');
INSERT INTO `wedding_role_menu` VALUES ('3474', 'U20190129170052900', '12');
INSERT INTO `wedding_role_menu` VALUES ('3475', 'U20190129165636564', '13');
INSERT INTO `wedding_role_menu` VALUES ('3476', 'U20190129165636564', '14');
INSERT INTO `wedding_role_menu` VALUES ('3477', 'U20190129165636564', '15');
INSERT INTO `wedding_role_menu` VALUES ('3478', 'U20190129165636564', '16');

-- ----------------------------
-- Table structure for wedding_user
-- ----------------------------
DROP TABLE IF EXISTS `wedding_user`;
CREATE TABLE `wedding_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id 自增',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登录密码',
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户唯一标识',
  `user_role` int(10) DEFAULT NULL COMMENT '用户角色',
  `user_find_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户找回密码专用',
  `user_phone` varchar(50) DEFAULT NULL COMMENT '用户电话',
  `user_birthday` date DEFAULT NULL COMMENT '用户生日日期',
  `headimg` varchar(150) DEFAULT NULL COMMENT '用户头像',
  `user_create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `user_update_time` datetime DEFAULT NULL COMMENT '用户更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wedding_user
-- ----------------------------
INSERT INTO `wedding_user` VALUES ('1', 'admin', '202cb962ac59075b964b07152d234b70', 'A20181221150150654', '1', '123456', '18796328755', '2019-01-31', '/AllImg/BranchImg/20190131/71d0b583c4544416b6f1518fe900b4c3.jpg', '2018-12-22 13:40:11', '2019-01-31 00:27:09');
INSERT INTO `wedding_user` VALUES ('3', 'admin123', 'e10adc3949ba59abbe56e057f20f883e', 'U20181222165410162', '0', '202cb962ac59075b964b07152d234b70', '123', '1970-01-01', '/AllImg/BranchImg/20190130/d8c27151d43e4de5903a80952018f703.jpg', '2018-12-22 16:54:10', null);
INSERT INTO `wedding_user` VALUES ('5', 'sheyingshi1', '202cb962ac59075b964b07152d234b70', 'U20190108203005241', '2', '202cb962ac59075b964b07152d234b70', '18796328756', '2019-01-08', null, '2019-01-08 20:30:05', null);
INSERT INTO `wedding_user` VALUES ('6', 'sheyingshi2', '202cb962ac59075b964b07152d234b70', 'U20190129165636564', '2', '202cb962ac59075b964b07152d234b70', '18796328756', '2019-01-29', null, '2019-01-29 16:56:36', null);
INSERT INTO `wedding_user` VALUES ('7', 'sheyingshi3', '202cb962ac59075b964b07152d234b70', 'U20190129165707861', '2', '202cb962ac59075b964b07152d234b70', '18796328756', '2019-01-29', null, '2019-01-29 16:57:07', null);
INSERT INTO `wedding_user` VALUES ('8', 'kehu1', '202cb962ac59075b964b07152d234b70', 'U20190129165735579', '0', '202cb962ac59075b964b07152d234b70', '18796328756', '2019-01-29', null, '2019-01-29 16:57:35', null);
INSERT INTO `wedding_user` VALUES ('9', 'kehu3', '202cb962ac59075b964b07152d234b70', 'U20190129170052900', '0', '202cb962ac59075b964b07152d234b70', '18796328756', null, null, '2019-01-29 17:00:52', null);
