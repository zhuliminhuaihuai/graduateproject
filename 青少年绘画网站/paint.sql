/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80013
Source Host           : 127.0.0.1:3306
Source Database       : paint

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-02-28 09:59:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for paint_branch
-- ----------------------------
DROP TABLE IF EXISTS `paint_branch`;
CREATE TABLE `paint_branch` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `branch_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构编号',
  `branch_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构名称',
  `user_id` int(11) DEFAULT NULL COMMENT '关联用户ID',
  `branch_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构管理者/负责人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `branch_create_time` datetime DEFAULT NULL COMMENT '机构成立时间',
  `branch_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构联系方式',
  `branch_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构座机',
  `branch_email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构邮箱',
  `branch_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构图片',
  `province` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '省',
  `city` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '市区',
  `area` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地区',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '具体地址',
  `branch_introduce` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '机构介绍',
  `branch_honor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构荣誉',
  `branch_service` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '机构服务宗旨',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='机构表';

-- ----------------------------
-- Records of paint_branch
-- ----------------------------
INSERT INTO `paint_branch` VALUES ('2', 'B20190213134930968', '素画非林', null, 'guanguan', '2019-02-13 13:49:30', '2019-02-20 00:00:00', '177-0565-1738', '0668-2575648', '32154571215@qq.com', '69649361e0994e7bb23033bf7e006401.jpg', '江苏', '徐州市', '鼓楼区', '飞澜路清溪大厦19楼2A室', '成立于2012年，是一家综合性的艺术中心。主要面向3-18岁的少年美术爱好者提供美术能力学习、艺术活动与欣赏、美术知识考级与升学等美术教育服务;面向成人及喜爱绘画艺术相关人士提供培训及定制业务;另提供文创产品开发，艺术品定制，产品空间设计装修服务。目前项目在本地市场中已具备一定知名度，我们以实体工作室为入口，除了绘画课程培训外，还承接各类项目设计，ui设计，平面设计，室内景观设计，绘画艺术品定制等，我们正建立以“梦象艺术”为核心的综合艺术服务平台，线上合作淘宝、大众点评、美团，口碑，高德预计覆盖超过200万消费者。', '2016年6月1日少先队深圳市工作委员会办公室嘉奖：多多熊艺术家园在2016年深圳市庆祝六一儿童节“娃出没嘉年华”专场活动中，为广大儿童少年度过一个健康、快乐而有意义的节目，做出了突出贡献。', '创新，博学，励志，不懈');
INSERT INTO `paint_branch` VALUES ('5', 'B20190213173327894', '天下画家', null, 'wudong', '2019-02-13 17:33:27', '2019-02-20 00:00:00', '188-2565-2245', '0669-2546114', '155445@qq.com', 'b31baa3c24a94131af9fcd572a967a0c.jpg', '江苏', '徐州市', '鼓楼区', '北极路天安大厦6楼408室', '艺趣少儿美术培训，面向4到15岁的少儿，根据不同年龄段的心理和趣味需求，按不同类型确定学习目标，实施分班教学。以发掘孩子们的内在潜力，提高儿童的绘画兴趣。本画室可根据学生的学习情况，组织参加各种绘画创作竟赛，利用现代少儿美术理念，通过多感体验，最大程度的激发孩子的想象力，锻炼儿童的色彩感、几何空间感、创造力、观察力、使其对美的感悟有独到的见解，也使孩子的性格和耐力方面得到一定的磨炼，并不断增强他们感受美和鉴赏美的能力。艺趣少儿美术在艺术创造力的培养中，尤其鼓励学生用自己的眼睛去看世界，用自己的心去感受生活，用自己的头脑去构思，用自己的双手去描绘，使眼、心、手、脑四者有效结合，从而提高学生的绘画水平。我们的老师都是专业美术院校毕业，取得美术教学资格。是宿州市少儿艺术委员会的成员之一，会组织学生参加各种绘画大赛，每年可安排学生两次考级。画得好的学生可推荐登报，通过媒体给自己展示的平台。', '2010.06   获得市最佳培训机构荣誉称号', '一切以培养新中国绘画少年为目标');

-- ----------------------------
-- Table structure for paint_product
-- ----------------------------
DROP TABLE IF EXISTS `paint_product`;
CREATE TABLE `paint_product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `product_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作品编号',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作品名称',
  `product_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作品图片',
  `product_video` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作品视频',
  `create_times` datetime DEFAULT NULL COMMENT '上传日期',
  `is_on` int(11) DEFAULT NULL COMMENT '是否上下架 1上架 0下架',
  `is_check` int(11) DEFAULT NULL COMMENT '审批  0待审核 1通过 2不通过 机构管理者审批',
  `product_introduce` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '作品介绍',
  `prodect_user_id` int(11) DEFAULT NULL COMMENT '作品作者ID',
  `product_user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作者名称',
  `is_selected` int(11) DEFAULT NULL COMMENT '是否精选/推荐 1是0否',
  `product_type` int(11) DEFAULT NULL COMMENT '色彩作品：1；素描作品：2；速写作品：3;油画作品：4;其他作品：5',
  `read_num` int(11) DEFAULT NULL COMMENT '阅读次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='作品表';

-- ----------------------------
-- Records of paint_product
-- ----------------------------
INSERT INTO `paint_product` VALUES ('8', 'P20190220094853425', '果蔬', 'cc2fe3af2ecb43aaa5a96d27b58bf868.jpg', '3D69015D2CA69263505CBA65EEEE5F63.mp4', '2019-02-20 09:48:53', '1', '1', '抓住静物的透视结构，画好物体的明暗，把握画面的黑白灰关系，蛇果的画法与苹果有许多相似之处蛇果的颜色比苹果单纯些，一般以橘黄、橘红、中黄为主，暗部以橘黄、橘红加熟褐为主，灰部以纯度较高的橘黄和橘红为主，亮部以橘黄、中黄加白色为主，反光受环境影响变化也较为明显，蛇果的表面比苹果粗糙，有颗粒状突起，所以高光可用于擦的方法来画，会使质感表现得更真实', '59', 'chenfeiyu', '1', '2', '0');

-- ----------------------------
-- Table structure for paint_user
-- ----------------------------
DROP TABLE IF EXISTS `paint_user`;
CREATE TABLE `paint_user` (
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
  `role` tinyint(5) DEFAULT NULL COMMENT '角色权限 0：管理员 1：学生 2：培训机构 3：教师',
  `user_sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述备注',
  `teacher_id` int(11) DEFAULT NULL COMMENT '所属教师ID',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教师名称',
  `branch_id` int(11) DEFAULT NULL COMMENT '所属机构ID',
  `branch_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '机构名称',
  `branch_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '机构管理者',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `mobile_phone` (`mobile_phone`),
  KEY `email` (`email`),
  KEY `user_name` (`user_name`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';

-- ----------------------------
-- Records of paint_user
-- ----------------------------
INSERT INTO `paint_user` VALUES ('1', 'ad888888', '12244322226@qq.com', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '2', '2019-01-29', '18950336633', '超级管理员', '2018-12-21 15:35:37', '0', '管理员', null, null, null, null, null);
INSERT INTO `paint_user` VALUES ('56', 'S20190213172132352', '12242311315@qq.com', 'chenxing', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-02-13', '16655236666', '陈兴', '2019-02-13 17:21:32', '3', '121', null, null, '2', '素画非林', null);
INSERT INTO `paint_user` VALUES ('51', 'B20190213134930968', '125245212@qq.com', 'guanguan', 'e10adc3949ba59abbe56e057f20f883e', '2', '1989-04-07', '18969695202', '肖晓萧', '2019-02-13 13:49:30', '2', '个性随和.', null, null, null, '素画非林', 'guanguan');
INSERT INTO `paint_user` VALUES ('54', 'S20190213155616460', '2232412245@qq.com', 'lanyun', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-02-13', '15680023001', '兰云', '2019-02-13 15:56:16', '3', '1212121212', null, null, '2', '素画非林', null);
INSERT INTO `paint_user` VALUES ('55', 'S20190213165652520', '15245332@qq.com', 'qiaoLin', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-02-13', '18860652236', '乔琳', '2019-02-13 16:56:52', '1', '1212', '54', '兰云', '2', '素画非林', null);
INSERT INTO `paint_user` VALUES ('57', 'B20190213173327894', '21212524@qq.com', 'wudong', 'e10adc3949ba59abbe56e057f20f883e', '1', '1997-02-13', '18860602323', '吴东', '2019-02-13 17:33:27', '2', '1', null, null, null, '天下画家', 'wudong');
INSERT INTO `paint_user` VALUES ('58', 'S20190213173441770', '2153451322@qq.com', 'linruchao', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-02-13', '16685852236', '林入超', '2019-02-13 17:34:41', '3', '121', null, null, '5', '天下画家', null);
INSERT INTO `paint_user` VALUES ('59', 'S20190213173557183', '1221321@qq.com', 'chenfeiyu', 'e10adc3949ba59abbe56e057f20f883e', '1', '2019-02-13', '13655236636', '陈飞宇', '2019-02-13 17:35:57', '1', '', '58', '林入超', '5', '天下画家', null);
