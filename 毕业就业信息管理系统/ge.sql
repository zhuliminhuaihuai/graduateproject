/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80013
Source Host           : 127.0.0.1:3306
Source Database       : ge

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-18 16:11:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ecs_employ_info
-- ----------------------------
DROP TABLE IF EXISTS `ecs_employ_info`;
CREATE TABLE `ecs_employ_info` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `empoloy_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '三方协议编号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生姓名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `user_id` int(5) DEFAULT NULL COMMENT '关联学生userid',
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户编号',
  `three_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '三方协议文件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ecs_employ_info
-- ----------------------------
INSERT INTO `ecs_employ_info` VALUES ('4', 'E20190118160237634', '2019-01-18 16:02:37', '黄宇', '男', '26', 'S20181217214959938', '/AllWord//34f1208f0e9c4b648405831fefb93b29.docx');

-- ----------------------------
-- Table structure for ecs_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `ecs_enterprise`;
CREATE TABLE `ecs_enterprise` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '企业ID',
  `enterprise_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业编号',
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '企业邮箱',
  `enterprise_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '企业名称',
  `mobile_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '企业联系电话',
  `enterprise_contacts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'qiye 联系人',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `district` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详细地址',
  `enterprise_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业logo',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `introduction` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '简介',
  `enterprise_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业类型',
  `update_time` datetime DEFAULT NULL,
  `user_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关联user_code',
  `is_check` int(5) DEFAULT NULL COMMENT '是否审批通过 1待审核 2通过 3审核不通过',
  `check_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审批结果',
  `legral_person` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '法人代表',
  `enter_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile_phone` (`mobile_phone`),
  KEY `email` (`email`),
  KEY `user_name` (`enterprise_name`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=1015 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='会员信息表';

-- ----------------------------
-- Records of ecs_enterprise
-- ----------------------------
INSERT INTO `ecs_enterprise` VALUES ('1013', 'S20181215141848843', '59326543@qq.com', '阿里巴巴', '0858-2254581', null, '浙江', '杭州市', '萧山区', '西湖257号', null, '2018-12-23 20:49:05', '阿里巴巴集团经营多项业务，另外也从关联公司的业务和服务中取得经营商业生态系统上的支援。业务和关联公司的业务包括：淘宝网、天猫、聚划算、全球速卖通、阿里巴巴国际交易市场、1688、阿里妈妈、阿里云、蚂蚁金服、菜鸟网络等', '电子商务、网上支付、B2B网上交易市场及云计算业务', null, 'S20181215141848843', '2', '为正常企业，允许运营', '马云', null);
INSERT INTO `ecs_enterprise` VALUES ('1014', 'S20181223205557747', '142121254@qq.com', '深圳市腾讯计算机系统有限公司', '8585-2356514', null, '广东', '深圳市', '福田区', '腾讯大厦', null, '2018-12-23 20:58:15', '深圳市腾讯计算机系统有限公司成立于1998年11月 [1]  ，由马化腾、张志东、许晨晔、陈一丹、曾李青五位创始人共同创立。 [1]  是中国最大的互联网综合服务提供商之一，也是中国服务用户最多的互联网企业之一。', '多元化网络服务', null, 'S20181223205557747', '2', '经审核，该企业符合要求', '马化腾', null);

-- ----------------------------
-- Table structure for ecs_job
-- ----------------------------
DROP TABLE IF EXISTS `ecs_job`;
CREATE TABLE `ecs_job` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `job_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位名称',
  `job_detail` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '职位详情',
  `job_place` varchar(255) DEFAULT NULL COMMENT '职位工作地点',
  `enterprise_id` int(2) DEFAULT NULL COMMENT '公司ID',
  `enterprise_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业编号',
  `job_salary` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位薪资',
  `enterprise_name` varchar(50) DEFAULT NULL COMMENT '企业名称',
  `job_welfare` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '福利待遇',
  `job_skill` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位技能要求',
  `remark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_on` int(11) DEFAULT '1' COMMENT '是否显示 1显示 2关闭',
  `job_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工作类型',
  `job_num` int(11) DEFAULT NULL COMMENT '此职位招聘人数',
  `job_create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业用户 关联userName/realName',
  `job_create_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联userCode',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ecs_job
-- ----------------------------
INSERT INTO `ecs_job` VALUES ('10', 'Java工程师', null, '杭州', '1013', 'S20181215141848843', '8000', '阿里巴巴', '六险二金，16薪，周末双休', '1.精通Java/J2EE， 基础扎实，熟练掌握常用Java技术框架，能编写简洁清晰的高质量代码；\n2.、至少熟悉1种主流数据库的使用，熟练使用SQL语言；\n3、熟悉底层中间件、分布式技术（包括缓存、消息系统等）。', '暂无', '2018-12-23 20:52:09', null, '1', '工程技术', '10', '阿里巴巴', 'S20181215141848843');
INSERT INTO `ecs_job` VALUES ('11', 'Web前端', null, '杭州', '1013', 'S20181215141848843', '6500', '阿里巴巴', '六险二金，16薪，周末双休', '1、热爱计算机科学和互联网技术，熟练掌握Java Web开发相关技术：协议、开发框架、存储、缓存、安全等\n2、掌握扎实的计算机基础知识，深入理解数据结构、算法和操作系统知识\n3、有足够的代码质量意识，时间管理意识，团队协作意识\n4、有强烈的求知欲，优秀的学习和沟通能力\n5、有广告投放或相关工作经验者优先', '暂无', '2018-12-23 20:53:49', null, '1', '工程技术', '10', '阿里巴巴', 'S20181215141848843');
INSERT INTO `ecs_job` VALUES ('12', '大数据开发', null, '杭州', '1013', 'S20181215141848843', '12000', '阿里巴巴', '六险二金，16薪，周末双休', '- 计算机、统计学、数学 相关专业本科及以上学历\n- 精通 Java / C++ / Python / Scala 其中的一种或几种编程语言\n- 精通 Hadoop / Hive / Spark / Hbase / Druid / Impala 其中的一种或几种，有分布式系统的实际开发经验者优先\n- 对数据敏感，能熟练预估数据量，善于从数据中发现问题，有广告数据处理经验者优先\n- 很强的学习、分析问题能力，良好的团队意识和协作精神', '暂无', '2018-12-23 20:55:14', null, '1', '工程技术', '5', '阿里巴巴', 'S20181215141848843');
INSERT INTO `ecs_job` VALUES ('13', '云计算', null, '深圳', '1014', 'S20181223205557747', '10000-15000', '深圳市腾讯计算机系统有限公司', '六险二金，15薪', '精通云计算技术，熟悉常见的云计算产品，了解主流厂商的云计算解决方案；\n能把握并引导客户云计算方面的需求，并能迅速应对，出相应技术方案；\n具有较强的文字功底和表达能力、客户交流能力、需求挖掘能力、方案设计能力；', '', '2018-12-23 21:11:32', null, '1', '工程技术', '3', '腾讯', 'S20181223205557747');
INSERT INTO `ecs_job` VALUES ('14', '人工智能AI', null, '深圳', '1014', 'S20181223205557747', '18000-25000', '深圳市腾讯计算机系统有限公司', '15薪，六险二金，各种福利', '1. 计算机相关专业本科及以上学历；\n2. 熟练掌握一种通用编程语言，包括(不限于): C/C++, Python或Java；\n3. 具有机器学习相关开发经验，深刻理解机器学习常用算法，具备算法改进经验；：\n4. 有AI工程化或者NLP相关项目经验者优先\n5. 良好的抗压能力和团队协作能力，强烈的求知欲，探索精神和自我驱动力', '', '2018-12-23 21:13:13', null, '1', '工程技术', '1', '腾讯', 'S20181223205557747');

-- ----------------------------
-- Table structure for ecs_project
-- ----------------------------
DROP TABLE IF EXISTS `ecs_project`;
CREATE TABLE `ecs_project` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) DEFAULT NULL,
  `project_date` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `project_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '项目内容',
  `project_harvest` varchar(255) DEFAULT NULL,
  `resume_code` varchar(50) DEFAULT NULL COMMENT '关联简历编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ecs_project
-- ----------------------------
INSERT INTO `ecs_project` VALUES ('1', '毕业生就业管理系统', '2018.09-2018.11', '2018-12-22 15:20:11', 'xxx', 'xxxx', 'Re20181222151943983');
INSERT INTO `ecs_project` VALUES ('2', 'ces', 'ces', '2018-12-22 15:23:55', 'ces', 'ce', 'Re20181222152331643');
INSERT INTO `ecs_project` VALUES ('3', '111', '1212', '2018-12-22 15:32:18', '111', '11', 'Re20181222153207834');
INSERT INTO `ecs_project` VALUES ('4', '111', '111', '2018-12-22 15:39:23', '111', '11', 'Re20181222153857451');
INSERT INTO `ecs_project` VALUES ('5', '11', '1', '2018-12-22 15:45:00', '1', '11', 'Re20181222154452338');
INSERT INTO `ecs_project` VALUES ('6', '12', '12', '2018-12-22 15:48:53', '12', '121', 'Re20181222154848640');
INSERT INTO `ecs_project` VALUES ('7', '122', '12', '2018-12-22 15:49:02', '121', '212', 'Re20181222154848640');
INSERT INTO `ecs_project` VALUES ('8', '1', '1', '2018-12-22 15:50:09', '1', '1', 'Re20181222155005399');
INSERT INTO `ecs_project` VALUES ('9', '2', '2', '2018-12-22 15:50:14', '2', '2', 'Re20181222155005399');
INSERT INTO `ecs_project` VALUES ('10', '1', '1', '2018-12-22 15:56:22', '1', '1', 'Re20181222155611618');
INSERT INTO `ecs_project` VALUES ('11', '21', '221', '2018-12-22 16:04:40', '212', '212', 'Re20181222160418455');
INSERT INTO `ecs_project` VALUES ('12', '12', '212', '2018-12-22 16:06:15', '1212', '212', 'Re20181222160602141');
INSERT INTO `ecs_project` VALUES ('13', '12', '12', '2018-12-23 09:01:51', '12', '211', 'Re20181223085010586');
INSERT INTO `ecs_project` VALUES ('14', '1', '1', '2018-12-23 09:03:38', '1', '1', 'Re20181223085010586');
INSERT INTO `ecs_project` VALUES ('15', '2222', '22', '2018-12-23 09:04:20', '222', '22', 'Re20181223090407993');
INSERT INTO `ecs_project` VALUES ('16', '212', '212', '2018-12-23 09:05:54', '212', '212', 'Re20181223090545194');
INSERT INTO `ecs_project` VALUES ('17', '212', '212', '2018-12-23 09:07:14', '21', '212', 'Re20181223090704107');
INSERT INTO `ecs_project` VALUES ('18', '1212', '212', '2018-12-23 09:08:55', '212', '212', 'Re20181223090848656');
INSERT INTO `ecs_project` VALUES ('19', '2112', '212', '2018-12-23 09:09:00', '21', '212', 'Re20181223090848656');
INSERT INTO `ecs_project` VALUES ('20', '12', '212', '2018-12-23 09:49:33', '21', '21', 'Re20181223094909761');

-- ----------------------------
-- Table structure for ecs_resume
-- ----------------------------
DROP TABLE IF EXISTS `ecs_resume`;
CREATE TABLE `ecs_resume` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `resume_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '简历编号',
  `job_intention` varchar(50) DEFAULT NULL COMMENT '求职意向/期望职位',
  `expected_salary` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '期望薪水',
  `expected_place` varchar(50) DEFAULT NULL COMMENT '期望地点',
  `user_name` varchar(20) DEFAULT NULL,
  `user_id` int(2) DEFAULT NULL COMMENT '用户ID',
  `user_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生编号',
  `mastering_skills` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '掌握技能',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_default` int(2) DEFAULT '2' COMMENT '简历是否默认显示 1默认 2不默认 ',
  `resume_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '简历word/可下载',
  `resume_img` varchar(255) DEFAULT NULL,
  `personal_evaluation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '自我评价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ecs_resume
-- ----------------------------
INSERT INTO `ecs_resume` VALUES ('36', 'Re20181223090848656', '1212', '212', '2121', 'huangyu', '26', 'S20181217214959938', '121212', '2018-12-23 09:08:48', null, '2', null, '/48158706347f483a8656125d28074902.jpg', '12211');
INSERT INTO `ecs_resume` VALUES ('51', 'Re20181223094909761', 'Java工程师', '6000', '南京', 'huangyu', '26', 'S20181217214959938', 'java1', '2018-12-23 09:49:09', null, '1', '465ab795023142f0b1ad4fb70c054a4e.doc', '008015ddb43f4e3ab3f8d1611bea6a6c.jpg', '2121');

-- ----------------------------
-- Table structure for ecs_resume_record
-- ----------------------------
DROP TABLE IF EXISTS `ecs_resume_record`;
CREATE TABLE `ecs_resume_record` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `user_code` varchar(50) DEFAULT NULL COMMENT '关联求职人',
  `resume_id` int(11) DEFAULT NULL COMMENT '简历ID',
  `resume_code` varchar(255) DEFAULT NULL COMMENT '关联简历编号',
  `hire_status` int(5) DEFAULT NULL COMMENT '雇佣状态 0待受邀面试 1企业邀约面试，2，接受面试， 3面试成功 4面试失败 5同意加入企业 6拒绝加入企业',
  `hire_result` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '雇佣结果',
  `job_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '投递职位名称',
  `enter_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '投递公司',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '投递人',
  `enter_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业编号/企业用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ecs_resume_record
-- ----------------------------
INSERT INTO `ecs_resume_record` VALUES ('3', '2018-12-28 20:11:06', null, '26', 'S20181217214959938', '51', 'Re20181223094909761', '6', '该学生符合我司要求', 'Java工程师', '阿里巴巴', '黄宇', 'S20181215141848843');
INSERT INTO `ecs_resume_record` VALUES ('4', '2019-01-18 09:37:05', null, '26', 'S20181217214959938', '51', 'Re20181223094909761', '4', '该学生不符合我司要求', '人工智能AI', '深圳市腾讯计算机系统有限公司', '黄宇', 'S20181223205557747');
INSERT INTO `ecs_resume_record` VALUES ('5', '2019-01-18 10:01:46', null, '26', 'S20181217214959938', '51', 'Re20181223094909761', '0', null, '云计算', '深圳市腾讯计算机系统有限公司', '黄宇', 'S20181223205557747');
INSERT INTO `ecs_resume_record` VALUES ('8', '2019-01-18 11:02:48', null, '26', 'S20181217214959938', '51', 'Re20181223094909761', '0', null, '大数据开发', '阿里巴巴', '黄宇', 'S20181215141848843');

-- ----------------------------
-- Table structure for ecs_user
-- ----------------------------
DROP TABLE IF EXISTS `ecs_user`;
CREATE TABLE `ecs_user` (
  `user_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '会员资料自增id',
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户编号',
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '邮箱',
  `user_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户密码',
  `sex` int(3) unsigned DEFAULT '0' COMMENT '性别，0，保密；1，男；2，女',
  `birthday` date DEFAULT NULL COMMENT '生日日期',
  `mobile_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '移动电话',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `country` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '国家/暂时没用到',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '市',
  `district` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '区/县',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详细地址',
  `headimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `role` tinyint(5) DEFAULT NULL COMMENT '角色权限 0：管理员 1：学生 2：企业',
  `user_sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个性描述',
  `courtyard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '系专业',
  `education` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学历',
  `political_outlook` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '政治面貌',
  `native_place` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '籍贯',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `age` int(2) DEFAULT NULL COMMENT '年龄',
  `school` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '毕业学校',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `mobile_phone` (`mobile_phone`),
  KEY `email` (`email`),
  KEY `user_name` (`user_name`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='会员信息表';

-- ----------------------------
-- Records of ecs_user
-- ----------------------------
INSERT INTO `ecs_user` VALUES ('26', 'S20181217214959938', '12@qq.com', 'huangyu', 'e10adc3949ba59abbe56e057f20f883e', '1', '1996-12-10', '18950336780', '黄宇', null, '江苏', '徐州市', '鼓楼区', '阳光城9#1802', null, '2018-12-17 21:49:59', '1', '帅气', '计算机系软件工程', '本科', '团员', '沛县', null, '22', '徐州师范学院');
INSERT INTO `ecs_user` VALUES ('1', 'S20181218150514531', '', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0', null, '18606958002', null, null, '江苏', '徐州市', '鼓楼区', null, null, '2018-12-18 15:05:14', '0', null, null, null, null, null, null, null, null);
INSERT INTO `ecs_user` VALUES ('31', 'S20181218194610511', '', '2121', 'e10adc3949ba59abbe56e057f20f883e', '1', '1998-06-01', '18950336867', '', null, '北京', '市辖区', '东城区', '', null, '2018-12-18 19:46:10', '2', '', '', '', null, '', null, null, null);
INSERT INTO `ecs_user` VALUES ('22', 'S20181215141848843', null, '阿里巴巴', 'e10adc3949ba59abbe56e057f20f883e', null, null, '13958584545', null, null, '北京', '市辖区', '东城区', null, null, '2018-12-15 14:18:48', '2', null, null, null, null, null, null, null, null);
INSERT INTO `ecs_user` VALUES ('33', 'S20181223205557747', '', '腾讯', 'e10adc3949ba59abbe56e057f20f883e', '0', null, '15698585858', null, null, '北京', '市辖区', '东城区', null, null, '2018-12-23 20:55:57', '2', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for ecs_win_experience
-- ----------------------------
DROP TABLE IF EXISTS `ecs_win_experience`;
CREATE TABLE `ecs_win_experience` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `win_time` varchar(50) DEFAULT NULL,
  `win_contenr` longtext,
  `create_time` datetime DEFAULT NULL,
  `resume_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联简历编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ecs_win_experience
-- ----------------------------
INSERT INTO `ecs_win_experience` VALUES ('1', null, '111', '2018-12-22 15:56:27', 'Re20181222155611618');
INSERT INTO `ecs_win_experience` VALUES ('2', null, '1', '2018-12-22 15:57:40', 'Re20181222155736146');
INSERT INTO `ecs_win_experience` VALUES ('3', null, '1', '2018-12-22 15:58:53', 'Re20181222155850211');
INSERT INTO `ecs_win_experience` VALUES ('4', '1', '1', '2018-12-22 16:01:22', 'Re20181222160118380');
INSERT INTO `ecs_win_experience` VALUES ('5', '222', '2222', '2018-12-22 16:01:26', 'Re20181222160118380');
INSERT INTO `ecs_win_experience` VALUES ('6', '12', '121', '2018-12-22 16:04:44', 'Re20181222160418455');
INSERT INTO `ecs_win_experience` VALUES ('7', '121', '212', '2018-12-22 16:06:19', 'Re20181222160602141');
INSERT INTO `ecs_win_experience` VALUES ('8', '2016.09', '', '2018-12-23 09:02:30', 'Re20181223085010586');
INSERT INTO `ecs_win_experience` VALUES ('9', '222', '2222', '2018-12-23 09:04:25', 'Re20181223090407993');
INSERT INTO `ecs_win_experience` VALUES ('10', '1212', '212', '2018-12-23 09:05:58', 'Re20181223090545194');
INSERT INTO `ecs_win_experience` VALUES ('11', '11', '11', '2018-12-23 09:07:24', 'Re20181223090704107');
INSERT INTO `ecs_win_experience` VALUES ('12', '212', '212', '2018-12-23 09:09:05', 'Re20181223090848656');
INSERT INTO `ecs_win_experience` VALUES ('13', '212', '1212', '2018-12-23 09:09:09', 'Re20181223090848656');
INSERT INTO `ecs_win_experience` VALUES ('14', '1212', '212', '2018-12-23 09:49:36', 'Re20181223094909761');
