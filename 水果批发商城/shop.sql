/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80012
Source Host           : 127.0.0.1:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-04-24 11:49:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart` (
  `cart_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '购物车自增id',
  `goods_id` int(255) DEFAULT NULL COMMENT '商品id',
  `cart_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '购物车code',
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户code',
  `goods_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品code',
  `goods_buy_num` int(20) DEFAULT NULL COMMENT '此商品购买数量',
  `goods_rel_price` double(10,2) DEFAULT NULL COMMENT '此商品真实价格',
  `goods_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品照片',
  `goods_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品标题',
  `goods_big_type` int(10) DEFAULT NULL COMMENT '商品大分类',
  `goods_small_type` int(10) DEFAULT NULL COMMENT '商品小分类',
  `goods_one_sum_price` double(10,2) DEFAULT NULL COMMENT '此商品总共金额',
  `goods_sum_price` double(10,2) DEFAULT NULL COMMENT '购物车全部金额',
  `cart_create_time` datetime DEFAULT NULL,
  `cart_update_time` datetime DEFAULT NULL,
  `cart_buy_sum_num` int(50) DEFAULT '0' COMMENT '购物车结算状态：0未结算 1：结算',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_cart
-- ----------------------------
INSERT INTO `shop_cart` VALUES ('66', '10', null, 'A20181221150150654', 'G20190215140550983', '2', '4.50', '/AllImg/BranchImg/20190215/2cdade77f8c14608bd6b4142cc4d92cd.jpg', '橙子', '1', '1', '9.00', null, '2019-04-08 22:52:04', null, '1');
INSERT INTO `shop_cart` VALUES ('67', '11', null, 'A20181221150150654', 'G20190215140724255', '1', '6.50', '/AllImg/BranchImg/20190215/1e028c92670844e88c04835c0931fcb4.jpg', '油桃', '1', '2', '6.50', null, '2019-04-08 22:52:09', null, '1');
INSERT INTO `shop_cart` VALUES ('68', '13', null, 'A20181221150150654', 'G20190215140935377', '2', '6.00', '/AllImg/BranchImg/20190215/5622946993f840dfb830da61986570d1.jpg', '芒果', '1', '1', '12.00', null, '2019-04-08 22:52:14', null, '1');
INSERT INTO `shop_cart` VALUES ('69', '18', null, 'A20181221150150654', 'G20190215141855616', '1', '4.60', '/AllImg/BranchImg/20190215/843e44a56be94df7bd2e429ba4101243.jpg', '桃子', '1', '2', '4.60', null, '2019-04-08 22:52:18', null, '1');
INSERT INTO `shop_cart` VALUES ('70', '23', null, 'A20181221150150654', 'G20190215142534226', '1', '8.50', '/AllImg/BranchImg/20190215/088c9029c4a8436cb33e4db4e49503a2.jpg', '牛油果', '2', '1', '8.50', null, '2019-04-08 22:52:24', null, '1');
INSERT INTO `shop_cart` VALUES ('71', '26', null, 'A20181221150150654', 'G20190215142822822', '1', '6.89', '/AllImg/BranchImg/20190215/daec5fa1937e43cfaede465725d874a1.jpg', '菠萝', '1', '3', '6.89', null, '2019-04-08 22:52:29', null, '1');
INSERT INTO `shop_cart` VALUES ('72', '27', null, 'A20181221150150654', 'G20190215142918336', '1', '6.34', '/AllImg/BranchImg/20190215/0bf5ae29de5c4ae9927db231f6a2ad38.jpg', '柚子', '1', '1', '6.34', null, '2019-04-08 22:52:36', null, '1');
INSERT INTO `shop_cart` VALUES ('73', '16', null, 'U20190311115346837', 'G20190215141624508', '1', '8.90', '/AllImg/BranchImg/20190215/c6f92edfc19547ea89552791ae1a38c7.jpg', '桑葚', '1', '1', '8.90', null, '2019-04-09 09:13:16', null, '1');
INSERT INTO `shop_cart` VALUES ('74', '17', null, 'U20190311115346837', 'G20190215141740675', '3', '3.50', '/AllImg/BranchImg/20190215/5a355c3496ea4a45b3da7e822721e787.jpg', '西瓜', '1', '1', '10.50', null, '2019-04-09 09:13:29', null, '1');
INSERT INTO `shop_cart` VALUES ('75', '21', null, 'U20190311115346837', 'G20190215142303677', '3', '20.69', '/AllImg/BranchImg/20190215/74682154dea14ed88f9218bf555bcf9a.jpg', '石榴', '2', '2', '62.07', null, '2019-04-09 09:13:35', null, '1');
INSERT INTO `shop_cart` VALUES ('76', '25', null, 'U20190311115346837', 'G20190215142726272', '2', '6.89', '/AllImg/BranchImg/20190215/6b024ac1402949208b2214a8e9d8fca4.jpg', '杨桃', '1', '3', '13.78', null, '2019-04-09 09:13:39', null, '1');
INSERT INTO `shop_cart` VALUES ('77', '20', null, 'U20190311115346837', 'G20190215142124383', '1', '3.20', '/AllImg/BranchImg/20190215/22f9bcb0d4dc4da883a9cd3c17774529.jpg', '苹果', '1', '2', '3.20', null, '2019-04-09 09:14:14', null, '1');
INSERT INTO `shop_cart` VALUES ('78', '23', null, 'U20190311115346837', 'G20190215142534226', '2', '8.50', '/AllImg/BranchImg/20190215/088c9029c4a8436cb33e4db4e49503a2.jpg', '牛油果', '2', '1', '17.00', null, '2019-04-09 09:14:19', null, '1');
INSERT INTO `shop_cart` VALUES ('79', '13', null, 'U20190311115346837', 'G20190215140935377', '3', '6.00', '/AllImg/BranchImg/20190215/5622946993f840dfb830da61986570d1.jpg', '芒果', '1', '1', '18.00', null, '2019-04-09 09:17:39', null, '1');
INSERT INTO `shop_cart` VALUES ('80', '20', null, 'U20190311115346837', 'G20190215142124383', '3', '3.20', '/AllImg/BranchImg/20190215/22f9bcb0d4dc4da883a9cd3c17774529.jpg', '苹果', '1', '2', '9.60', null, '2019-04-09 09:17:45', null, '1');
INSERT INTO `shop_cart` VALUES ('81', '21', null, 'U20190311115346837', 'G20190215142303677', '2', '20.69', '/AllImg/BranchImg/20190215/74682154dea14ed88f9218bf555bcf9a.jpg', '石榴', '2', '2', '41.38', null, '2019-04-09 09:17:50', null, '1');
INSERT INTO `shop_cart` VALUES ('82', '25', null, 'U20190311115346837', 'G20190215142726272', '2', '6.89', '/AllImg/BranchImg/20190215/6b024ac1402949208b2214a8e9d8fca4.jpg', '杨桃', '1', '3', '13.78', null, '2019-04-09 09:17:56', null, '1');
INSERT INTO `shop_cart` VALUES ('83', '28', null, 'U20190311115346837', 'G20190311120046498', '2', '5.80', '/AllImg/BranchImg/20190311/1a80073b086841638ba823d0b58809e2.jpg', '菠萝', '1', '1', '11.60', null, '2019-04-09 09:18:01', null, '1');
INSERT INTO `shop_cart` VALUES ('84', '12', null, 'U20190311115346837', 'G20190215140839129', '1', '7.80', '/AllImg/BranchImg/20190215/6b950458e7fc45609ce5b8507287f86f.jpg', '柠檬', '2', '3', '7.80', null, '2019-04-09 09:18:10', null, '1');

-- ----------------------------
-- Table structure for shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods`;
CREATE TABLE `shop_goods` (
  `goods_id` int(255) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(50) DEFAULT NULL,
  `goods_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `goods_state` int(10) DEFAULT '1' COMMENT '商品状态 1：启用 0：关闭',
  `goods_big_type` int(10) DEFAULT NULL COMMENT '商品大分类：0：代表全部 1：常见水果 2：进口水果',
  `goods_type` int(10) DEFAULT NULL COMMENT '水果细分种类：0：该大分类下的全部 1：寒性水果 2：温性水果 3：中性水果',
  `goods_title` varchar(50) DEFAULT NULL,
  `goods_cost_price` double(10,2) DEFAULT NULL,
  `goods_rel_price` double(10,2) DEFAULT NULL COMMENT '商品真实 价格',
  `goods_price` double(10,2) DEFAULT NULL COMMENT '商品假价格',
  `goods_buy_num` int(50) DEFAULT '0' COMMENT '购买数量',
  `goods_renark` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '商品详情',
  `goods_create_time` datetime DEFAULT NULL,
  `goods_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_goods
-- ----------------------------
INSERT INTO `shop_goods` VALUES ('9', 'G20190215140233546', '/AllImg/BranchImg/20190215/704f9ae08d2f479db1392c0295940a44.jpg', '1', '1', '3', '葡萄', '4.50', '6.89', '8.00', '0', '葡萄是世界栽培面积最大的水果。它是一种树姿优美，适应性强，易繁殖，是庭院绿化的理想果树。葡萄被誉为世界四大水果之首，葡萄中含有丰富的葡萄糖及多种维生素，对保护肝脏效果非常明显。葡萄营养价值极高，含有丰富的抗氧化成分，能延缓衰老，非常适合熬夜的人吃。', '2019-02-15 14:02:33', null);
INSERT INTO `shop_goods` VALUES ('10', 'G20190215140550983', '/AllImg/BranchImg/20190215/2cdade77f8c14608bd6b4142cc4d92cd.jpg', '1', '1', '1', '橙子', '3.20', '4.50', '8.00', '1', '健胃消食，提神醒酒：橙子甘甜带酸，饱食之后肚胀难受时，吃点橙子或者橙汁都是非常不错的选择，不仅能够解除口胃中油腻之感，还能帮助消化，醒酒提神等等。降低固醇，降低血脂血压：桔子和橙子都含有大量的维生素C，我们从各种饮品中也可以看出，一般含有大量的维生素C的都以橙子桔子为封面图标等。经常食用橙汁橙子可以缓解老化的血管，降低固醇，对高血压高血脂有很大的帮助。', '2019-02-15 14:05:50', null);
INSERT INTO `shop_goods` VALUES ('11', 'G20190215140724255', '/AllImg/BranchImg/20190215/1e028c92670844e88c04835c0931fcb4.jpg', '1', '1', '2', '油桃', '3.25', '6.50', '7.00', '1', '油桃营养丰富，具有止咳化痰、补气健肾的功能，能降血压、延年益寿，少儿食用能促进发育，提高智力。油桃有补益气血、养阴生津的作用。在大病之后，可有效减少面部暗黄，气血匮乏的现象，改善气色，恢复健康。油桃的桃仁也不可忽视哦，桃仁有活血化淤、润肠通便的作用，可用于闭经、跌打损伤等辅助治疗。油桃可辅助治疗缺铁性贫血，此类病人可选择油桃食用，效果理想。', '2019-02-15 14:07:24', null);
INSERT INTO `shop_goods` VALUES ('12', 'G20190215140839129', '/AllImg/BranchImg/20190215/6b950458e7fc45609ce5b8507287f86f.jpg', '1', '2', '3', '柠檬', '5.60', '7.80', '9.60', '1', '一就是减肥，二就是润夫和美容。柠檬茶特别有镇定的作用，据俄国人讲,常喝富含维生素C的柠檬茶可以预防感冒，美国科学家发现,饮热柠檬茶有助抗皮肤癌有延缓皮肤老化的作用。\n\n鲜柠檬泡水喝由于维生素含量极为丰富因此是美容的佳品能防止和消除皮肤色素沉着起到美白的作用。喝柠檬水还可以防治心血管疾病因为柠檬水能缓解钙离子，促使血液凝固的作用。所以可预防和辅助治疗高血压和心肌梗死。柠檬水中含有大量柠檬酸盐，能够抑制钙盐结晶从，而阻止肾结石形成，甚至可以使部分慢性肾结石患者的结石减少变少。美国泌尿学会年会上公布的研究成果也表明，常喝含柠檬汁的饮料可提高尿中的柠檬酸酯水平，该化学物质能预防尿中的矿物质在肾内形成结晶体即肾结石。', '2019-02-15 14:08:39', null);
INSERT INTO `shop_goods` VALUES ('13', 'G20190215140935377', '/AllImg/BranchImg/20190215/5622946993f840dfb830da61986570d1.jpg', '1', '1', '1', '芒果', '5.00', '6.00', '7.80', '2', '1、止吐。食用芒果具有清肠胃的功效，对于晕车、晕船有一定的止吐作用。\n\n　　2、抗癌。据现代食疗观点而言，芒果含有大量的维生素A，因此具有防癌、抗癌的作用。\n\n　　3、美化肌肤。由于芒果中含有大量的维生素，因此经常食用芒果，可以起到滋润肌肤的作用。\n\n　　◆ 抗菌消炎： 芒果未成熟的果实及树皮、茎能抑制化脓球菌、大肠杆菌等，芒果叶的提取物也同样有抑制化脓球菌、大肠杆菌的作用，可治疗人体皮肤、消化道感染疾病。 ◆防癌抗癌：芒果果实含芒果酮酸、异芒果醇酸等三醋酸和多酚类化合物，具有抗癌的药理作用；芒果汁还能增加胃肠蠕动，使粪便在结肠内停留时间缩短。因此食芒果对防治结肠癌很有裨益。 ◆ 祛痰止咳：芒果中所含的芒果甙有祛疾止咳的功效，对咳嗽痰多气喘等症有辅助治疗作用。 ◆降低胆固醇、甘油三酯：芒果中含维生素C量高于一般水果，为56.4～98.6毫克％，芒果叶中也有很高的维生素C含量，且具有即使加热加工处理，其含量也不会消失的特点。常食芒果可以不断补充体内维生素C的消耗，降低胆固醇、甘油三酯，有利于防治心血管疾病。', '2019-02-15 14:09:35', null);
INSERT INTO `shop_goods` VALUES ('14', 'G20190215141128910', '/AllImg/BranchImg/20190215/d1d1ed5140ea439190ad1fafdcb04db5.jpg', '0', '2', '1', '草莓', '5.60', '8.60', '9.00', '0', '草莓营养丰富，富含多种有效成分，每百克鲜果肉中含维生素C60毫克，比苹果、葡萄含量还高。果肉中含有大量的糖类、蛋白质、有机酸、果胶等营养物质。此外，草莓还含有丰富的维生素B1、B2、C、PP以及钙、磷、铁、钾、锌、铬等人体必需的矿物质和部分微量元素。草莓是人体必需的纤维素、铁、钾、维生素C和黄酮类等成分的重要来源。草莓中所含的胡萝卜素是合成维生素A的重要物质，具有明目养肝作用；草莓对胃肠道和贫血均有一定的滋补调理作用；', '2019-02-15 14:11:28', null);
INSERT INTO `shop_goods` VALUES ('15', 'G20190215141516895', '/AllImg/BranchImg/20190215/bf388fbb3ca243beaf9f450aabbcfe94.jpg', '1', '2', '1', '泥猴桃', '6.50', '8.90', '9.00', '0', '水果中猕猴桃维生素C的含量可以用优秀来形容，每100可果肉中，就含有100毫克的维生素C，如果按照每天要摄入1000毫克的量来计算的话，只需要吃10个猕猴桃就够了。多C多漂亮，多吃猕猴桃一定可以让你的皮肤更紧致，更红润，而且，VC还能增强抵抗力和免疫力，感冒的时候吃猕猴桃，也可以促进感冒加快好转。', '2019-02-15 14:15:16', null);
INSERT INTO `shop_goods` VALUES ('16', 'G20190215141624508', '/AllImg/BranchImg/20190215/c6f92edfc19547ea89552791ae1a38c7.jpg', '1', '1', '1', '桑葚', '6.30', '8.90', '10.60', '1', '1、女性朋友在怀孕的时候是可以食用桑葚的，因为在怀孕期间的女性身体的抵抗能力和免疫能力都是比较低的，而桑葚中的高品质的营养，还可以增强孕妇的抵抗力和免疫力。2、桑葚的营养价值也是比较丰富的，在桑葚里面含有丰富的活性蛋白、维生素c、氨基酸、矿物质、花青素等，而且据研究，它的营养价值是苹果的5倍。因此，对孕妇来说，吃桑葚是非常有益的。不过，桑葚性寒，不宜多吃，因此孕妇吃桑葚宜在10颗左右。3、桑葚中里面所富含的脂肪酸、苹果酸等，它能够促进蛋白质、淀粉的消化，对于食欲不振的孕妇来说，特别是刚怀孕的孕妇来说是非常好的佳果。', '2019-02-15 14:16:24', null);
INSERT INTO `shop_goods` VALUES ('17', 'G20190215141740675', '/AllImg/BranchImg/20190215/5a355c3496ea4a45b3da7e822721e787.jpg', '1', '1', '1', '西瓜', '1.20', '3.50', '4.50', '1', '清热解暑\n\n含有大量水分、多种氨基酸和糖，有效补充人体的水分，防止因水分散失而中暑。通过利尿排出体内多余的热量而达到清热解暑之效美容、抗衰老\n\n西瓜汁和瓜皮可增加皮肤弹性，减少皱纹，增添光泽帮助蛋白质的吸收\n\n西瓜汁含有蛋白酶，将不溶性蛋白质转化为水溶性蛋白质，帮助人体对蛋白质的吸收', '2019-02-15 14:17:40', null);
INSERT INTO `shop_goods` VALUES ('18', 'G20190215141855616', '/AllImg/BranchImg/20190215/843e44a56be94df7bd2e429ba4101243.jpg', '1', '1', '2', '桃子', '2.30', '4.60', '5.60', '1', '桃子热量低，用做减肥时期的一种食物，效果也非常不错。水蜜桃中含有丰富的果胶与适中的纤维，既能增加饱腹感，还能促进肠胃蠕动，加速新陈代谢，有利于食物的分解。此外，桃含较多的有机酸和纤维素，也能增加胃肠蠕动，有助于消化。水蜜桃中富含天然收敛成分，可以增加肌肤的弹性，防止皱纹的产生；此外，桃子中富含果胶，有助于人体排便排毒，防止因毒素累积而长斑。很多人都知道酒醉后适当食用水果可以醒酒，桃子便是解酒水果的一种。桃子含有烟碱酸，能促进血液循环，可解酒并改善宿醉。桃子富含纤维与果胶，有助于肠胃蠕动，可以清除肠道废物，并促使胆汁分泌，消积润肠，增进食欲。', '2019-02-15 14:18:55', null);
INSERT INTO `shop_goods` VALUES ('19', 'G20190215142018466', '/AllImg/BranchImg/20190215/81a836bebfe544b3bca85a8d53442635.jpg', '1', '2', '2', '水蜜桃', '4.50', '7.80', '9.80', '0', '1、补血养颜\n\n水蜜桃营养丰富，肉甜汁多，含丰富的铁质，能增加人体血红蛋白数量，古人曰：常吃水蜜桃能“益容颜”，原因可能在此。\n\n2、补气润肺\n\n水蜜桃的果肉中含有大量蛋白质、磷、钙、铁与维生素B、维生素C和足够多的水分，对慢性支气管炎、支气管扩张症、肺纤维化、肺不张、矽肺、肺结核等出现的干咳、咳血、慢性发热、盗汗等症，可起到养阴生津、补气润肺的保健功效。', '2019-02-15 14:20:18', null);
INSERT INTO `shop_goods` VALUES ('20', 'G20190215142124383', '/AllImg/BranchImg/20190215/22f9bcb0d4dc4da883a9cd3c17774529.jpg', '1', '1', '2', '苹果', '2.60', '3.20', '4.60', '2', '　苹果有“智慧果”、“记忆果”的美称。人们早就发现，多吃苹果有增进记忆、提高智能的效果。苹果不仅含有丰富的糖、维生素和矿物质等大脑必需的营养素，而且更重要的是富含锌元素。据研究，锌是人体内许多重要酶的组成部分，是促进生长发育的关键元素。锌通过酶广泛参与体内蛋白质、脂肪和糖的代谢。锌还是构成与记忆力息息相关的核酸与蛋白质的必不可少的元素。缺锌可使大脑皮层边缘部海马区发育不良，影响记忆力，实验也证明，减少食物中的锌，幼童的记忆力和学习能力受到严重障碍。锌还与产生抗体、提高人体免疫力等有密切关系。1、苹果具有降低胆固醇含量的功效作用　2、苹果还具有通便和止泻的双重功效与作用', '2019-02-15 14:21:24', null);
INSERT INTO `shop_goods` VALUES ('21', 'G20190215142303677', '/AllImg/BranchImg/20190215/74682154dea14ed88f9218bf555bcf9a.jpg', '1', '2', '2', '石榴', '14.30', '20.69', '25.60', '2', '抗菌\n\n石榴中含有丰富的生物碱，可以起到抗菌效果。\n\n2.止泻\n石榴中含有生物碱和熊果素等物质，可以起到涩肠的作用。\n3.提高免疫力\n\n石榴中含有大量的营养元素，可以起到强身健体，提高免疫力的作用。 石榴汁含有多种氨基酸和微量元素，有助消化、抗胃溃疡、软化血管、降血脂和血糖，降低胆固醇等多种功能。可防止冠心病心病、高血压，可达到健胃提神、增强食欲、益寿谈话派延年之功效，对饮酒过量者，解酒有奇效。石榴可谓全身是宝，果皮、根、花皆可入药。其果皮中含有苹果酸、鞣质、生物碱等成分，据有关实验表明，石榴皮有明显的抑菌和收敛功能，能使肠黏膜收敛，使肠黏腊的分泌物减少，所以能有效地治疗腹泻、痢疾等症，对痢疾杆菌、大肠杆菌有较好的抑制作用。另外，石榴的果皮中含有碱性物质，有驱虫功效；石榴花则有止血功能，且石榴花泡水洗眼，还有明目的效果。', '2019-02-15 14:23:03', null);
INSERT INTO `shop_goods` VALUES ('22', 'G20190215142402575', '/AllImg/BranchImg/20190215/fadf08832ec44a178b8a0a9ced2fb29d.jpg', '1', '2', '2', '红毛丹', '5.30', '7.80', '8.60', '0', '1、补充能量\n\n红毛丹中含有丰富的营养物质，其中包含有碳水化合物，多种维生素和矿物质，而碳水化合物中就包含有蔗糖，葡萄糖等等糖类物质，红毛丹的含糖量也比较高，因此能够给人体提供能量。\n\n2、养颜美容\n\n红毛丹中含有丰富的维生素，其中包含有维生素C，而维生素C是一种很好的抗氧化物质，能够清除人体内的自由基，起到抗衰老的作用，并且维生素C还能抑制黑色素在皮肤中的沉积，所以食用红毛丹又养颜美容的功效。\n\n3、补血\n\n红毛丹中含有丰富的矿物质，其中就包含有铁元素，而铁元素能够促进红细胞合成血红蛋白，对于缺铁性贫血有一定的缓解功效，所以食用红毛丹有补血的功效。', '2019-02-15 14:24:02', null);
INSERT INTO `shop_goods` VALUES ('23', 'G20190215142534226', '/AllImg/BranchImg/20190215/088c9029c4a8436cb33e4db4e49503a2.jpg', '1', '2', '1', '牛油果', '4.00', '8.50', '9.80', '2', '牛油果有“森林奶油”之称，它的脂肪含量高达15.3%。妈妈们也不要谈“脂”色变，脂肪也分“好脂肪”和“坏脂肪”。牛油果的脂肪主要是健康的不饱和脂肪酸，对于宝宝脑部和神经系统发育好处多多。除了脂肪，牛油果的蛋白质、维生素、和膳食纤维含量也很高，小小的一只，营养价值却非常丰富。而且牛油果的膳食纤维很丰富，可以预防和缓解便秘。但是，当宝宝拉肚子的时候，就非常不适合吃它啦。食用牛油果还能很好地补充叶酸。叶酸是一种十分重要的维生素，能够预防胎儿出现先天性神经管缺陷，还能降低成年人患癌症和心脏病的机率。促进宝宝生长发育。宝宝的生长发育过程需要很多营养素，其中就包括蛋白质、维生素、氨基酸以及一些矿质元素。而牛油果中就含多种维生素、多种矿质元素、食用植物纤维以及多种人体需要的氨基酸等，营养元素很丰富全面，能补益宝宝身体，促进宝宝生长发育。', '2019-02-15 14:25:34', null);
INSERT INTO `shop_goods` VALUES ('24', 'G20190215142637302', '/AllImg/BranchImg/20190215/cecab9662f084c06966f0f3a40abb0d2.jpg', '1', '2', '2', '榴莲', '19.00', '29.00', '38.00', '0', '榴莲营养极为丰富，含有蛋白质、糖类、多种维生素、膳食纤维、脂肪、叶酸、氨基酸和矿物质，有强身健体、滋阴补阳之功效。在泰国，榴莲常被当地人用作病人、产妇调养身体的补品，我国民间也有“一只榴莲三只鸡”的说法，这说明榴莲确实具有很高的食疗价值。据测定，每100g榴莲含热量147千卡、蛋白质2.6g、脂肪3.3g、膳食纤维1.7g、维生素c 2.8毫克、维生素E 2.28毫克、维生素A 3微克、维生素B1 0.2毫克、维生素B2 0.13毫克、碳水化合物28.3g、叶酸116.9微克、烟酸1.19毫克、钙4毫克、磷38毫克、钾261毫克、钠2.9毫克、镁27毫克、铁0.3毫克、碘5.6微克、硒3.26微克、铜0.12毫克、锰0.22毫克、锌0.016毫克。滋补身体\n\n榴莲相当丰富，果肉中富含淀粉、蛋白质、维生素、叶酸、氨基酸、脂肪及钙、铁、磷、钾等微量元素，食之可以补充身体所需的能量和营养，缓解体虚，增强机体抵抗力。\n\n缓解痛经\n\n榴莲性热，具有活血散寒的作用，可以改善血液循环，促进体温上升，特别适合体寒痛经的女性和胃腹寒凉的人食用，是寒性体质的滋补佳品。\n\n增强免疫力\n\n榴莲中氨基酸的含量丰富，种类齐全，包括人体必需的8种氨基酸。氨基酸是蛋白质组成的基本单位，与机体免疫密切相关，适量食用榴莲有助于提高人体抗病能力。', '2019-02-15 14:26:37', null);
INSERT INTO `shop_goods` VALUES ('25', 'G20190215142726272', '/AllImg/BranchImg/20190215/6b024ac1402949208b2214a8e9d8fca4.jpg', '1', '1', '3', '杨桃', '4.50', '6.89', '8.50', '2', '杨桃能减少机体对脂肪的吸收，有降低血脂、胆固醇的作用，对高血压、动脉硬化等心血管疾病有预防作用。同时还可保护肝脏，降低血糖。另外，阳桃中糖类、维生素C及有机酸含量丰富，且果汁充沛，能迅速补充人体的水分，生津止渴。\n\n并使体内的热或酒毒随小便排出体外，消除疲劳感。阳桃果汁中含有大量草酸、柠檬酸、苹果酸等，能提高胃液的酸度，促进食物的消化。阳桃含有大量的挥发性成分、胡萝卜素类化合物、糖类、有机酸及维生素B、C等，可消除咽喉炎症及口腔溃疡，防治风火牙痛', '2019-02-15 14:27:26', null);
INSERT INTO `shop_goods` VALUES ('26', 'G20190215142822822', '/AllImg/BranchImg/20190215/daec5fa1937e43cfaede465725d874a1.jpg', '1', '1', '3', '菠萝', '3.50', '6.89', '8.50', '1', '在中医当中，认为菠萝性微寒，味甘，有清热解暑、生津止渴、利小便等功效，临床上可以用于中暑、身热烦渴以及小便不利等方面疾病症状的治疗。1.生津止渴\n\n菠萝是一种含水量十分高的水果，每100克菠萝就含有87.1克的水分，因而可以很好的帮助人体补充水分，既达到解渴的效果同时也有利尿的作用。\n\n2.开胃消食\n\n吃菠萝对于肠胃有很好的促消化作用，因而肠胃消化不良的时候，吃些菠萝可以改善，此外，其中含有的纤维素可以促进肠道蠕动，起到排便的作用，进而能预防便秘。\n\n3.养颜美容\n\n前面我们提到，菠萝当中含有丰富的维生素，其中维生素B可帮助滋养肌肤，维生素C可以起到抗氧化作用和增强免疫力作用。', '2019-02-15 14:28:22', null);
INSERT INTO `shop_goods` VALUES ('27', 'G20190215142918336', '/AllImg/BranchImg/20190215/0bf5ae29de5c4ae9927db231f6a2ad38.jpg', '1', '1', '1', '柚子', '3.25', '6.34', '8.60', '1', '中医认为，柚子味甘、酸，性寒，有健胃化食、下气消痰、轻身悦色等功用。现代医药学研究发现，柚肉中含有非常丰富的维生素C以及类胰岛素等成分，故有降血糖、降血脂、减肥、美肤养容等功效。经常食用，对高血压、糖尿病、血管硬化等疾病有辅助治疗作用，对肥胖者有健体养颜功能。\n\n　　柚子还具有健胃、润肺、补血、清肠、利便等功效，可促进伤口愈合，对败血症等有良好的辅助疗效。此外，柚子含有生理活性物质皮甙，可降低血液的黏滞度，减少血栓的形成，故而对脑血管疾病，如脑血栓、中风等也有较好的预防作用。而鲜柚肉由于含有类似胰岛素的成分，更是糖尿病患者的理想食品。', '2019-02-15 14:29:18', null);
INSERT INTO `shop_goods` VALUES ('28', 'G20190311120046498', '/AllImg/BranchImg/20190311/1a80073b086841638ba823d0b58809e2.jpg', '1', '1', '1', '菠萝', '2.60', '5.80', '3.20', '1', '好吃', '2019-03-11 12:00:46', null);

-- ----------------------------
-- Table structure for shop_order
-- ----------------------------
DROP TABLE IF EXISTS `shop_order`;
CREATE TABLE `shop_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `cart_ids` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '结算的购物车对应id',
  `user_code` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `order_money` double(10,2) DEFAULT NULL,
  `order_type` int(10) DEFAULT '0' COMMENT '订单状态 0：未发货 1：已发货 2：配送完成 3：退货',
  `pay_type` int(10) DEFAULT NULL COMMENT '支付类型0：到货付款 1：支付宝或者微信转账',
  `province` varchar(15) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `district` varchar(15) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `order_create_time` datetime DEFAULT NULL,
  `order_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_order
-- ----------------------------
INSERT INTO `shop_order` VALUES ('32', 'O20190408225256949', '71,72', 'A20181221150150654', 'admin', '18796328756', '13.23', '0', '0', '福建', '福州市', '鼓楼区', '123', '2019-04-08 22:52:56', null);
INSERT INTO `shop_order` VALUES ('33', 'O20190408225308393', '66,67,68', 'A20181221150150654', 'admin', '18796328756', '27.50', '0', '0', '内蒙古', '呼和浩特市', '市辖区', '12312312', '2019-04-08 22:53:08', null);
INSERT INTO `shop_order` VALUES ('34', 'O20190408225322631', '69,70', 'A20181221150150654', 'admin', '18796328756', '13.10', '0', '1', '浙江', '湖州市', '长兴县', '12312', '2019-04-09 22:53:22', null);
INSERT INTO `shop_order` VALUES ('35', 'O20190409091356422', '73,74', 'U20190311115346837', '朱利敏', '18796328756', '19.40', '3', '0', '福建', '福州市', '鼓楼区', '哈哈哈哈', '2019-04-09 09:13:56', null);
INSERT INTO `shop_order` VALUES ('36', 'O20190409091405763', '75,76', 'U20190311115346837', '朱利敏', '18796328756', '75.85', '0', '0', '福建', '泉州市', '市辖区', '5345', '2019-04-09 09:14:05', null);
INSERT INTO `shop_order` VALUES ('37', 'O20190409091427397', '77,78', 'U20190311115346837', '朱利敏', '18796328756', '20.20', '0', '0', '福建', '福州市', '鼓楼区', '64', '2019-04-09 09:14:27', null);
INSERT INTO `shop_order` VALUES ('38', 'O20190409091837161', '83,84', 'U20190311115346837', '朱利敏', '18796328756', '19.40', '0', '0', '福建', '福州市', '鼓楼区', '软件大道', '2019-04-09 09:18:37', null);
INSERT INTO `shop_order` VALUES ('39', 'O20190409091857376', '81,82', 'U20190311115346837', '朱利敏', '18796328756', '55.16', '0', '1', '福建', '福州市', '鼓楼区', '软件大道', '2019-04-09 09:18:57', null);
INSERT INTO `shop_order` VALUES ('40', 'O20190409091910319', '79,80', 'U20190311115346837', '朱利敏', '18796328756', '27.60', '0', '0', '福建', '福州市', '鼓楼区', '软件大道', '2019-04-09 09:19:10', null);

-- ----------------------------
-- Table structure for shop_user
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id 自增',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登录密码',
  `user_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户唯一标识',
  `user_role` int(10) DEFAULT NULL COMMENT '用户角色',
  `user_find_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户找回密码专用',
  `user_provice` varchar(10) DEFAULT NULL,
  `user_city` varchar(10) DEFAULT NULL,
  `user_region` varchar(10) DEFAULT NULL,
  `user_phone` varchar(50) DEFAULT NULL COMMENT '用户电话',
  `user_birthday` date DEFAULT NULL COMMENT '用户生日日期',
  `headimg` varchar(150) DEFAULT NULL COMMENT '用户头像',
  `user_create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `user_update_time` datetime DEFAULT NULL COMMENT '用户更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO `shop_user` VALUES ('6', 'admin', '202cb962ac59075b964b07152d234b70', 'A20181221150150654', '1', null, null, null, null, '18796328756', null, null, null, null);
INSERT INTO `shop_user` VALUES ('7', 'admin1', '202cb962ac59075b964b07152d234b70', 'U20190208222646289', '2', null, null, null, null, '18796328756', null, null, '2019-02-08 22:26:46', null);
INSERT INTO `shop_user` VALUES ('11', 'admin3', '202cb962ac59075b964b07152d234b70', 'U20190215114203523', '0', null, null, null, null, '18796328756', null, null, '2019-02-15 11:42:03', null);
INSERT INTO `shop_user` VALUES ('13', '朱利敏', '202cb962ac59075b964b07152d234b70', 'U20190311115346837', '2', null, null, null, null, '18796328756', null, null, '2019-03-11 11:53:46', null);
