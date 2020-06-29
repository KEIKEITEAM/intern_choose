/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : intern_choose

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-06-29 15:48:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录账户名',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', 'user', 'keikei', 'fh58q2ea6thauof5ikg98fe2ciafh50r');
INSERT INTO `admin` VALUES ('1', '123', '123123', 'fh58q2ea6thauof5ikg98fe2ciafh50r');

-- ----------------------------
-- Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级名字',
  `majorId` int(11) DEFAULT NULL COMMENT '专业ID外键',
  `gradeId` int(11) DEFAULT NULL COMMENT '年级ID外键',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `年级外键` (`gradeId`) USING BTREE,
  KEY `专业外键` (`majorId`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=286 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '软件1班', '1', '1');
INSERT INTO `classes` VALUES ('2', '软件2班', '1', '1');
INSERT INTO `classes` VALUES ('3', '软件(对口)3班', '1', '1');
INSERT INTO `classes` VALUES ('18', '动漫1班', '2', '1');
INSERT INTO `classes` VALUES ('19', '动漫对口2班', '2', '1');
INSERT INTO `classes` VALUES ('20', '数媒1班', '3', '1');
INSERT INTO `classes` VALUES ('21', '计网1班', '4', '1');
INSERT INTO `classes` VALUES ('22', '计网2班', '4', '1');
INSERT INTO `classes` VALUES ('23', '计网3班', '4', '1');
INSERT INTO `classes` VALUES ('24', '计网(对口)4班', '4', '1');
INSERT INTO `classes` VALUES ('25', '计网(对口)5班', '4', '1');
INSERT INTO `classes` VALUES ('4', '软件(手机)1班', '1', '1');
INSERT INTO `classes` VALUES ('5', '软件(同耕)班', '1', '1');
INSERT INTO `classes` VALUES ('26', '云计算1班', '8', '1');
INSERT INTO `classes` VALUES ('28', '电商2班', '5', '1');
INSERT INTO `classes` VALUES ('29', '电商3班', '5', '1');
INSERT INTO `classes` VALUES ('30', '动漫(对口)3班', '2', '1');
INSERT INTO `classes` VALUES ('31', '数媒（对口）2班', '3', '1');
INSERT INTO `classes` VALUES ('32', '数媒（对口）3班', '3', '1');
INSERT INTO `classes` VALUES ('33', '数媒（对口）4班', '3', '1');
INSERT INTO `classes` VALUES ('34', '数媒（对口）5班', '3', '1');
INSERT INTO `classes` VALUES ('35', '数媒（对口）6班', '3', '1');
INSERT INTO `classes` VALUES ('27', '电商1班', '5', '1');

-- ----------------------------
-- Table structure for `grades`
-- ----------------------------
DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of grades
-- ----------------------------
INSERT INTO `grades` VALUES ('1', '18级');
INSERT INTO `grades` VALUES ('2', '17级');
INSERT INTO `grades` VALUES ('3', '16级');

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业名称',
  `professionalId` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业群ID',
  `open` bit(1) DEFAULT NULL COMMENT '专业开放权限',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `专业群外键` (`professionalId`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '软件技术', '1', '');
INSERT INTO `major` VALUES ('2', '动漫制作', '2', '');
INSERT INTO `major` VALUES ('3', '数字媒体与应用', '2', '');
INSERT INTO `major` VALUES ('4', '计算机网络技术', '3', '');
INSERT INTO `major` VALUES ('5', '电子商务', '1', '');
INSERT INTO `major` VALUES ('6', '大数据技术与应用', '1', '');
INSERT INTO `major` VALUES ('7', '无人机应用技术', '1', '');
INSERT INTO `major` VALUES ('8', '云计算与应用', '3', '');

-- ----------------------------
-- Table structure for `professional`
-- ----------------------------
DROP TABLE IF EXISTS `professional`;
CREATE TABLE `professional` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业群名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of professional
-- ----------------------------
INSERT INTO `professional` VALUES ('1', '软件专业群');
INSERT INTO `professional` VALUES ('2', '动漫专业群');
INSERT INTO `professional` VALUES ('3', '网络专业群');

-- ----------------------------
-- Table structure for `professional_grade`
-- ----------------------------
DROP TABLE IF EXISTS `professional_grade`;
CREATE TABLE `professional_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `professionalId` int(11) DEFAULT NULL COMMENT '专业群ID外键',
  `gradeId` int(10) DEFAULT NULL COMMENT '年级ID外键',
  `open` bit(1) DEFAULT NULL COMMENT '是否开放选择权限',
  `startTime` datetime(6) DEFAULT NULL COMMENT '开始选择的时间',
  `endTime` datetime(6) DEFAULT NULL COMMENT '结束选择的时间',
  `creatTime` datetime(6) DEFAULT NULL COMMENT '创建该条数据的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of professional_grade
-- ----------------------------
INSERT INTO `professional_grade` VALUES ('1', '1', '1', '', '2020-05-30 16:32:27.000000', '2020-06-30 16:32:31.000000', '2020-06-05 13:31:37.000000');
INSERT INTO `professional_grade` VALUES ('2', '2', '1', '', '2020-06-01 09:30:03.000000', '2020-06-24 09:30:09.000000', '2020-06-05 13:31:40.000000');
INSERT INTO `professional_grade` VALUES ('16', '3', '1', '', '2020-04-30 16:32:27.000000', '2020-05-30 16:32:27.000000', '2020-06-06 13:15:14.908000');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentNumber` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生主键',
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名字',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'qq号码',
  `classId` int(11) DEFAULT NULL COMMENT '年级ID外键',
  PRIMARY KEY (`studentNumber`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('16273027', '唐小卫', '-dubri6ik9lljs93hu7krjndt8isd8pr2', null, null, '18');
INSERT INTO `student` VALUES ('184033002', '莫善怀', '-4646cifhkcnfdp547nn94bdmfaep9r4h', null, null, '18');
INSERT INTO `student` VALUES ('184033003', '李晓霞', '5vpg75igkj7b86bbkjqolqlkk4eovm2m', null, null, '18');
INSERT INTO `student` VALUES ('184033005', '游献敏', '-29vae5l4vrcvat75qvh8qdqt8igiltfa', null, null, '18');
INSERT INTO `student` VALUES ('184033006', '张帝锋', 'c5ck54n8777uusgg4l5finpdj00igvlt', null, null, '18');
INSERT INTO `student` VALUES ('184033007', '刘汉卿', '5mpodupbdt7flujs9a8vqfbelkrfnngc', null, null, '18');
INSERT INTO `student` VALUES ('184033008', '韦柔羽', 'edtr3ego1hjog7ea4099dp8jd2aseku1', null, null, '18');
INSERT INTO `student` VALUES ('184033010', '王荻元', '-bg1t233m57jgc4cglelcksbs6v3f1d5l', null, null, '18');
INSERT INTO `student` VALUES ('184033011', '刘小龙', '7qgssrggc4fmob0o3h8m8fdd7nc9e1c9', null, null, '18');
INSERT INTO `student` VALUES ('184033012', '梁晶晶', '-3n85ekb9ri5m18adsi3i55h02dchmice', null, null, '18');
INSERT INTO `student` VALUES ('184033013', '杨文龙', '-8qc7ub7g1hefmomeocm6mmpu22fbmiuo', null, null, '18');
INSERT INTO `student` VALUES ('184033014', '王霆峰', '3iil8mg990dsdhgeom2mnutu7r77ca94', null, null, '18');
INSERT INTO `student` VALUES ('184033015', '韦万祺', 'dp6uio0ql986cr5kfpbkacepb7ooq548', null, null, '18');
INSERT INTO `student` VALUES ('184033016', '唐晓璐', '9ro3bbno2t06p85crasa59c8ep9vu880', null, null, '18');
INSERT INTO `student` VALUES ('184033017', '蒙石孔', '-i0rhq10u610mc1vp2ntg3jbslh12rp9', null, null, '18');
INSERT INTO `student` VALUES ('184033018', '邓行君', '-fbtj2378qaj8rl0ten0pcq016c9kugbm', null, null, '18');
INSERT INTO `student` VALUES ('184033019', '叶静霞', '-1gasrsv3omg37e04cqqatfg3p6jn37t6', null, null, '18');
INSERT INTO `student` VALUES ('184033020', '罗秋雨', '9mgr4djkcfll8jod56md7bkqch54o89u', null, null, '18');
INSERT INTO `student` VALUES ('184033021', '苏珊珊', '-22p4ef6ti9iao07ms0ombgqjng2qfu3c', null, null, '18');
INSERT INTO `student` VALUES ('184033022', '黄志航', '-d0arf1kv0oo16as369ah4jgf04lrhpkd', null, null, '18');
INSERT INTO `student` VALUES ('184033024', '黄颖怡', '3aqq3e5ls5b49sripdfa64abtv07l2rt', null, null, '18');
INSERT INTO `student` VALUES ('184033025', '曾炼锋', '-fcr0ssi5l1ktdb3iok5scvki2qq8hf4h', null, null, '18');
INSERT INTO `student` VALUES ('184033026', '李雅萱', '518lmh9qanl7srjl53dqu9cubmg14n92', null, null, '18');
INSERT INTO `student` VALUES ('184033028', '冯伟琴', 'd663hp5n2vor23ndrbcf65237jdo4po8', null, null, '18');
INSERT INTO `student` VALUES ('184033029', '庾文', '-18h6trcfr29bfb0l8nf0et5v6tos1dkr', null, null, '18');
INSERT INTO `student` VALUES ('184033030', '卢秋妮', '3ladlrheah83h990ubdin2qofbtfih89', null, null, '18');
INSERT INTO `student` VALUES ('184033031', '方石娟', '-c5t65qrh8mhjct3h8rue4bkta8gci2jf', null, null, '18');
INSERT INTO `student` VALUES ('184033032', '陆国璋', '7peo9gm4eqn0if787fqciaugf34k660o', null, null, '18');
INSERT INTO `student` VALUES ('184033033', '刘珏巧', 'dkqvspo66p435ocutudk29mkqn8rk5du', null, null, '18');
INSERT INTO `student` VALUES ('184033034', '秦莉岚', '-7o70ocud3ocm42e5d9bqg2447gktmdgl', null, null, '18');
INSERT INTO `student` VALUES ('184033035', '李玉静', '2sf0voqrb117pbdsmb2c7b4a7a95sk6b', null, null, '18');
INSERT INTO `student` VALUES ('184033036', '郑钧旭', '5pfa4pfsnc88nu8afprl4ogk162md3r6', null, null, '18');
INSERT INTO `student` VALUES ('184033038', '林可', '2c56hf0j8a9arm0b0224s5e4v2n78og4', null, null, '18');
INSERT INTO `student` VALUES ('184033039', '黄正冲', '36cl6tvc7aunq6akfuectbkt5e3bob50', null, null, '18');
INSERT INTO `student` VALUES ('184033040', '陆庆艳', 'cvckb43l59jn306himh5ni5og7h4koul', null, null, '18');
INSERT INTO `student` VALUES ('184033041', '刘佩佩', 'ee5t6mme39ebr9asp6fstlln14h2rmq2', null, null, '18');
INSERT INTO `student` VALUES ('184033042', '覃福妙', 'a91kb2c7qd6slluk8tstk1feo48rv0kp', null, null, '18');
INSERT INTO `student` VALUES ('184033043', '顾津瑞', '2rinc35062uljlr61ni94den86b05r0g', null, null, '18');
INSERT INTO `student` VALUES ('184033045', '王艺瑾', 'efteo37p5h08j6pbgqjqemljojim9olb', null, null, '18');
INSERT INTO `student` VALUES ('184033046', '邱志永', '-97gtrpe1dohd6d9p2u3f2qm2b8pn7dm7', null, null, '18');
INSERT INTO `student` VALUES ('184033048', '邓司杰', '2vfg743nkkcniuhikmomknho5fv2oon8', null, null, '18');
INSERT INTO `student` VALUES ('184033049', '梁骏攀', 'ckefi8clno3jhfjr124b664t9o0qfh1c', null, null, '18');
INSERT INTO `student` VALUES ('174031100', '吴佐莹', '-c07heo92arnq8a9m2muq1isj4krbb949', null, null, '19');
INSERT INTO `student` VALUES ('174031118', '姚伟奇', '-5s0nogv559g25isp01lulsnk6b8niu8q', null, null, '19');
INSERT INTO `student` VALUES ('174031142', '覃忠冠', '-dqo539ojli716opchrq8i7evr4da9irv', null, null, '19');
INSERT INTO `student` VALUES ('174031143', '吴李阳', '28eoug7obplt8eom6qtea4utd77ticsk', null, null, '19');
INSERT INTO `student` VALUES ('184031001', '蒋坤容', '-dvjmsanav8i4qrr4hu7vmqjf29p48eel', null, null, '19');
INSERT INTO `student` VALUES ('184031002', '梁颖', '-4jka9kb46vj793miooqnsgcnrknrqnvt', null, null, '19');
INSERT INTO `student` VALUES ('184031003', '林映彤', '-b71in440c115qv13p60oerbr0a0alkmo', null, null, '19');
INSERT INTO `student` VALUES ('184031004', '黄佳琳', '-6q50tr895piqvm6rqg7aqc6i3sdebkgp', null, null, '19');
INSERT INTO `student` VALUES ('184031005', '凌明慧', '-5f2ugkcv7br71n70vktscej2mpubif5h', null, null, '19');
INSERT INTO `student` VALUES ('184031006', '夏诗钰', '-8abt9i9peuf7s2979deunkbmeno6bk6t', null, null, '19');
INSERT INTO `student` VALUES ('184031007', '黎若萱', 'f7akq92j5oli16j12l5lii1mqsdee47n', null, null, '19');
INSERT INTO `student` VALUES ('184031008', '韦婉璇', 'gnqkijtjc13e3r4nh8nedmps311kul8', null, null, '19');
INSERT INTO `student` VALUES ('184031009', '覃凤丹', '-7fghbo1d9it0o4o854fp1tp0kca8aove', null, null, '19');
INSERT INTO `student` VALUES ('184031010', '李晶晶', '78s1okhjc6uad34g6m3cof1kjp5gnb8g', null, null, '19');
INSERT INTO `student` VALUES ('184031011', '邓嘉豪', '-aj889r2416b89l21bi3tj8qc1daloc41', null, null, '19');
INSERT INTO `student` VALUES ('184031012', '杨海晟', 'i15j0d0jj6se9786e2d7uhpnecateo', null, null, '19');
INSERT INTO `student` VALUES ('184031013', '覃荣巾', '-1ci830l7e9r1sfc9uue9s6hq2lerjqd1', null, null, '19');
INSERT INTO `student` VALUES ('184031014', '曹婷婷', '99em27fhrs28hdhl966vprq314r00cho', null, null, '19');
INSERT INTO `student` VALUES ('184031015', '贾燕萍', 'flffmce9lsu8aci4mtq0t5p7kh46ul45', null, null, '19');
INSERT INTO `student` VALUES ('184031016', '郑晓宇', '87p6mchlsq8l1g02nkpitjf8p52hdpt7', null, null, '19');
INSERT INTO `student` VALUES ('184031017', '林雅雪', 'ep6tvf095spm1ub87t2be2rg8c1c48lm', null, null, '19');
INSERT INTO `student` VALUES ('184031018', '韦龙龙', 'bv6eo5ohpsn63rekq2e37nto86jpifh7', null, null, '19');
INSERT INTO `student` VALUES ('184031019', '冯彩倩', '9pv4m9bcigj4r2hffnvt7jp999olitcv', null, null, '19');
INSERT INTO `student` VALUES ('184031020', '李峻宇', '88i5q1ilcsl9nbl58pkv10mkan2pp02m', null, null, '19');
INSERT INTO `student` VALUES ('184031022', '燕翎', '-ahl56c4jfcgangeqpdc7o50k9hk6ei64', null, null, '19');
INSERT INTO `student` VALUES ('184031023', '韦晓敏', 'bb377lfphkrarks3ohu1ql24sosa5h62', null, null, '19');
INSERT INTO `student` VALUES ('184031024', '朱思妮', '-8ass36i2p7536i86eb4r96cfropqe59d', null, null, '19');
INSERT INTO `student` VALUES ('184031025', '张荣样', 'fp2lkmlrg6toe98ocvl3e2gtdqe0dq59', null, null, '19');
INSERT INTO `student` VALUES ('184031026', '蒙明霞', 'dkc1dsbmtchp2lnibu0kr47c0hm24n28', null, null, '19');
INSERT INTO `student` VALUES ('184031027', '韦佳慧', 'fr3961vbsf7pqvha65ka2o3gg7dd0foo', null, null, '19');
INSERT INTO `student` VALUES ('184031028', '李哲远', '5dcq522ebcdu9clviesclv9im29fud7d', null, null, '19');
INSERT INTO `student` VALUES ('184031029', '农涵惠', '-40m5bl7krddoic6kfvi8p11r6bq2f8fn', null, null, '19');
INSERT INTO `student` VALUES ('184031030', '欧健涛', 'e06eiesf7p12cdgq48pdfsuuqe7uv2h6', null, null, '19');
INSERT INTO `student` VALUES ('184031031', '钟日秀', '-bhf6lunhuvrdchq56ks1bh4jclm0iq0o', null, null, '19');
INSERT INTO `student` VALUES ('184031032', '甘可莹', '-91qkpb7ut53o8t7rgcq8p4rdf4o59vd1', null, null, '19');
INSERT INTO `student` VALUES ('184031033', '阳丞章', '-b5gu6cfo25r34k9ark051ospka70332e', null, null, '19');
INSERT INTO `student` VALUES ('184031036', '蓝锦凤', '-cli2rk6jh832s40jpamn14k26gequdh', null, null, '19');
INSERT INTO `student` VALUES ('184031038', '覃莉娜', '-1qftlgjo45ndpq962jrk04e1vegfejmd', null, null, '19');
INSERT INTO `student` VALUES ('184031039', '陈金宗', '3bp6tj00rjispmpdvgj13eiht6ud3q4n', null, null, '19');
INSERT INTO `student` VALUES ('184031041', '张爱玲', '-9urn8l16ft4poo63stl14o3jet3d7utj', null, null, '19');
INSERT INTO `student` VALUES ('184031042', '韦生庚', 'fgo4mn0go84o8k2mmp4plpcmdtt28qre', null, null, '19');
INSERT INTO `student` VALUES ('184031043', '莫佳茵', '3eg4ulju2156fse0rqbl4o2rkndph4fj', null, null, '19');
INSERT INTO `student` VALUES ('184031044', '罗超', '-728jo70eju4t8nmn070agcdf5psn2elp', null, null, '19');
INSERT INTO `student` VALUES ('184031045', '刘朝桩', '8n7093gkkbdpjfarbeqs5jihk4dnjtbm', null, null, '19');
INSERT INTO `student` VALUES ('184031046', '苏兰', '485tuj4a4flnbdrva1ah2742tq6cn7ip', null, null, '19');
INSERT INTO `student` VALUES ('184031049', '韦理晨', '-gvv78slr8gu0fh0tmvvseclvtiq79vc', null, null, '19');
INSERT INTO `student` VALUES ('184123001', '刘璇', '-13t1vpf60195r5jd1a56f1e26vgto4h6', null, null, '20');
INSERT INTO `student` VALUES ('184123002', '杜羽', '-4108m8rvhrhjdo3o8pufuv6oq8m9t8us', null, null, '20');
INSERT INTO `student` VALUES ('184123003', '蓝香宵', 'dl74n7bin04252v3r515m9ifv4eg8k3b', null, null, '20');
INSERT INTO `student` VALUES ('184123005', '陆子怡', '29k6j9268v6003gvsddpdfi3nt3tls5k', null, null, '20');
INSERT INTO `student` VALUES ('184123007', '苏丽君', '-c3d3kl8hkau2v6mftg2vs5anrrpsfs0f', null, null, '20');
INSERT INTO `student` VALUES ('184123010', '韩炼萍', '8bnsgtchijkftf6rgfhdo4ph5bl9k2g8', null, null, '20');
INSERT INTO `student` VALUES ('184123013', '梁舒媚', '69fqam6cj5dh5017ds183tg1cc7quq1v', null, null, '20');
INSERT INTO `student` VALUES ('184123014', '梁煜铭', '-2pc0o209vsbg1sqigr5co9n5kpmcb0i0', null, null, '20');
INSERT INTO `student` VALUES ('184123015', '黄美琪', '69sfts6uce6aen4fm3d7epm5m8704fhp', null, null, '20');
INSERT INTO `student` VALUES ('184123016', '梁进源', 'ki85j7nukhg2f79glgsq7plu1dabojd', null, null, '20');
INSERT INTO `student` VALUES ('184123017', '韦应思', '-b1pmao9mf7jpu5dtpi5ugm4j588fnlbb', null, null, '20');
INSERT INTO `student` VALUES ('184123018', '谭宇', '-8022bposj4llp521u7968sevc3osj2sl', null, null, '20');
INSERT INTO `student` VALUES ('184123019', '杨雯雯', '-1khl77d8c9a2uecl1jdtiust7ukk5ssl', null, null, '20');
INSERT INTO `student` VALUES ('184123020', '李郁佳', '-aanh8s1c678bd56u2mvlgrmak7tbicqh', null, null, '20');
INSERT INTO `student` VALUES ('184123021', '谢洲屿', '-1jk2eep41kfqp31i2flb3g949390026f', null, null, '20');
INSERT INTO `student` VALUES ('184123023', '黄仪蝶', '-fmvd8m4qb7h1ugimlmn3n5edcgui2q10', null, null, '20');
INSERT INTO `student` VALUES ('184123024', '刘俊', '952e5641joe0kfg3k83mnuf238ssrgvr', null, null, '20');
INSERT INTO `student` VALUES ('184013002', '林德锋', 'ei5cvub9i7gccenn1ucsoa03b1e7tndo', null, null, '21');
INSERT INTO `student` VALUES ('184013003', '李江', '-17v28lr88es3hnik10usrmqgd25q6dos', null, null, '21');
INSERT INTO `student` VALUES ('184013005', '邓秀玲', '-9f68ltlmhdoqci8dg47fh9iojnqki8iv', null, null, '21');
INSERT INTO `student` VALUES ('184013008', '蒋超荣', '-a2gb1khue975535fr1n711ufuorh2dmf', null, null, '21');
INSERT INTO `student` VALUES ('184013009', '冯火荣', '-4jtt28ims6q8oh47q88v8mprrm80o540', null, null, '21');
INSERT INTO `student` VALUES ('184013010', '韦建锋', '-dqfmqab4pgrdh2gnkldumq2q1c9o9jhq', null, null, '21');
INSERT INTO `student` VALUES ('184013011', '廖光轩', '53p1gtud8oulq8omopqu5clbto4n0rtl', null, null, '21');
INSERT INTO `student` VALUES ('184013012', '滕翠莹', '8mq6hup5t525nqbckc41rlnj6us3t628', null, null, '21');
INSERT INTO `student` VALUES ('184013013', '李钟毅', '-970pan7hoi237a06amlcb57o5fe2a3b7', null, null, '21');
INSERT INTO `student` VALUES ('184013014', '张嘉敏', 'u74uo5s18o2fu6vk4t2h80erkegpc0o', null, null, '21');
INSERT INTO `student` VALUES ('184013015', '莫良杰', '52vqdrolnq8fiq6tt9iq34ljmfa714bs', null, null, '21');
INSERT INTO `student` VALUES ('184013016', '贾荣明', '1j2kpikek895fur2js5aqitbi4l20psf', null, null, '21');
INSERT INTO `student` VALUES ('184013017', '莫俊杰', '489lca5uc1vt86a0vckdjd1dkctov6n8', null, null, '21');
INSERT INTO `student` VALUES ('184013018', '李军', '-eecgtcm919d17r3qih7dnhm5p7anevau', null, null, '21');
INSERT INTO `student` VALUES ('184013019', '黄金炳', '-17vc61jdq8vhloatg8jrullgqm9enp2s', null, null, '21');
INSERT INTO `student` VALUES ('184013020', '陈慧怡', 'h7riepjnc45nbkglq1pfkff1o4ilfu2', null, null, '21');
INSERT INTO `student` VALUES ('184013022', '刘湘', 'bkah3c3v4vdlr1abhk6h80b7b0llb4g1', null, null, '21');
INSERT INTO `student` VALUES ('184013024', '朱铖', '-8afng5df9ap6bqgm172qo4surapcgvpm', null, null, '21');
INSERT INTO `student` VALUES ('184013025', '黄鑫', '-1kkroj6ind2tmtmaig9teu6qc8acultp', null, null, '21');
INSERT INTO `student` VALUES ('184013028', '曾春圆', 'cdbhmlpf9ui5qph3jkrs19mrskorodcu', null, null, '21');
INSERT INTO `student` VALUES ('184013029', '陈其华', '5k5jrab7nieed9remqffoe4elrpseakt', null, null, '21');
INSERT INTO `student` VALUES ('184013030', '梁桂惠', '3s3u7i1a38iom27n2gecf8kbse51hk74', null, null, '21');
INSERT INTO `student` VALUES ('184013031', '姚新新', '9nhiksphec82eqh3p6pv48imajb635at', null, null, '21');
INSERT INTO `student` VALUES ('184013032', '梁伟明', '9kingj8oae8mmj27t9imshe6cet5vaai', null, null, '21');
INSERT INTO `student` VALUES ('184013034', '覃良华', '2soar5oaccocjhe59361r4r9atdck32i', null, null, '21');
INSERT INTO `student` VALUES ('184013036', '朱晓云', 'bb4pvut02in9sn4n7pviu9hp8g96b6f8', null, null, '21');
INSERT INTO `student` VALUES ('184013038', '王宇绮', '-c285mr3d1r2hpmvf5ngnbvqvh41l0j6o', null, null, '21');
INSERT INTO `student` VALUES ('184013039', '谭泽', '-1rtsfln9t4u2hu06slpid6ovrgvjl040', null, null, '21');
INSERT INTO `student` VALUES ('184013042', '覃兰艳', 'b20bsu84nc7qu8dfqsll8qdqgbtcl68n', null, null, '21');
INSERT INTO `student` VALUES ('184013043', '于传升', '-1ck8vlr15u147v8h95vh4if7rj1ailqq', null, null, '21');
INSERT INTO `student` VALUES ('184013044', '罗亚转', 'a6ae8ejbsh7v4m30ktudd44hsbnh9vrt', null, null, '21');
INSERT INTO `student` VALUES ('184013046', '唐丽萍', 'esbe8ugjtnsboh6elj0fnuudsa8p5mi8', null, null, '21');
INSERT INTO `student` VALUES ('184013048', '邹颖颖', '2afvr9444av3bvc6u8jchgd64rqoab7u', null, null, '21');
INSERT INTO `student` VALUES ('184013050', '黄炳国', '-4gjpig733j9cbs55e694103pluk020qt', null, null, '21');
INSERT INTO `student` VALUES ('184013051', '石春艳', '-bgaupbc324b7n7mf69c8vn8lk8vjqe02', null, null, '21');
INSERT INTO `student` VALUES ('184013053', '龙玉欣', '-tf5tebfp7v0n8f2lo1l4m0m0cfo19qj', null, null, '21');
INSERT INTO `student` VALUES ('181053189', '罗祎陶', '-4k7cahf0ajtp5o0ukv88tqopnkb9k5cm', null, null, '22');
INSERT INTO `student` VALUES ('184013037', '黄泽华', '-1ijt3asah9l51dfk30rip1ep1kcp5urb', null, null, '22');
INSERT INTO `student` VALUES ('184013054', '梁志康', '-ek13ialf71fsrfhuopaqfr1uqo6dbmi3', null, null, '22');
INSERT INTO `student` VALUES ('184013055', '农远莹', '-2nboi9i6s0m6fe5qpt01j1qr93t426qk', null, null, '22');
INSERT INTO `student` VALUES ('184013060', '施建海', 'aj67m80hdvc3m8aiqk16q60838mt9l5f', null, null, '22');
INSERT INTO `student` VALUES ('184013061', '张艳宜', '4irsi4kotsq8ini4s8349qk6phlcrogg', null, null, '22');
INSERT INTO `student` VALUES ('184013062', '黄上育', '-68h8jv1fsil0d5jgqi88glsp1vbtg0kh', null, null, '22');
INSERT INTO `student` VALUES ('184013064', '胡嘉权', '-dfgmhgs40khrun81ivdrpflgdeqa9m9l', null, null, '22');
INSERT INTO `student` VALUES ('184013065', '隆娇娇', '-548g0tqludigg0l0f0p9njium9mm5ur5', null, null, '22');
INSERT INTO `student` VALUES ('184013066', '梁瑜', '3ofn5ufhcdnfparm7d5hnj1mijrn278m', null, null, '22');
INSERT INTO `student` VALUES ('184013067', '梁景彬', '5llmfe0skbdo04g16vhuo4i45g039po8', null, null, '22');
INSERT INTO `student` VALUES ('184013068', '陆树荣', '9f8hqvru61hlaulhah5cm89sf1aasl1', null, null, '22');
INSERT INTO `student` VALUES ('184013069', '林玉恒', '5i3c2afqcu5hefhndqm9nb0u9gtn1lq1', null, null, '22');
INSERT INTO `student` VALUES ('184013070', '赖星桦', '-1q5bjtc52q9qb3iu2m504ettmg1rimhc', null, null, '22');
INSERT INTO `student` VALUES ('184013071', '杨海凤', 'doc470h74bf0k0h5aqrtqefvehfqknq2', null, null, '22');
INSERT INTO `student` VALUES ('184013072', '杨敏艺', '-eng0ug7f9dj7fuudr9udmkn96be3skdg', null, null, '22');
INSERT INTO `student` VALUES ('184013073', '严子皓', '-7baq0crvi150dg4so6j1l8679in8aiqt', null, null, '22');
INSERT INTO `student` VALUES ('184013077', '林莺', '8557u32svuer6n1vh9rpncqo2r313msl', null, null, '22');
INSERT INTO `student` VALUES ('184013078', '李育龄', 'bqtj1javebkgj3kt5nds8d56sjtl6b62', null, null, '22');
INSERT INTO `student` VALUES ('184013082', '郑小莹', 'ba6t67ismlvfbq2g3p13qq6ok4d1i92a', null, null, '22');
INSERT INTO `student` VALUES ('184013085', '包驰先', 'c5e0fe8mfacu7gt3tut9uck2srti6m1l', null, null, '22');
INSERT INTO `student` VALUES ('184013088', '郭锦萍', 'c3mufvna2ubf67lf4rsi5m5mom250mk', null, null, '22');
INSERT INTO `student` VALUES ('184013089', '韦靖', '5i8lh4oq0d0meq1mms9ouvutar21sa8u', null, null, '22');
INSERT INTO `student` VALUES ('184013091', '秦剑婷', 'dini28hif7q4fhv67atcdcb57m5989e7', null, null, '22');
INSERT INTO `student` VALUES ('184013092', '黄河舟', '10munbq6es9jau6aidedda48a9cjf0cc', null, null, '22');
INSERT INTO `student` VALUES ('184013093', '江水清', '-29f3ckdk2gnocnb57l2meg5j0f5ap579', null, null, '22');
INSERT INTO `student` VALUES ('184013094', '罗一飞', 'fpd153jb2pnpe1hf3lsm4l84ulk7qao9', null, null, '22');
INSERT INTO `student` VALUES ('184013096', '黄义浩', '72bvimjat53rrbm6a1kbadulfdc6btam', null, null, '22');
INSERT INTO `student` VALUES ('184013097', '韦丽凤', '-7dcmb22jeai2u5rlij1i7h7n6dat7ha7', null, null, '22');
INSERT INTO `student` VALUES ('184013098', '唐廷杰', 'c13qs182ro9laueqs5rrflt88runa8b1', null, null, '22');
INSERT INTO `student` VALUES ('184013099', '李振宇', '-q6br30g5jah0146bjd48h3nvuol0d47', null, null, '22');
INSERT INTO `student` VALUES ('184013104', '刘裕平', 'dm9davqk605m5c27gt719tqchamaibsh', null, null, '22');
INSERT INTO `student` VALUES ('184013109', '蒋承', '9ek4e3fj9a35qsq7focs79amqgu0pbt4', null, null, '22');
INSERT INTO `student` VALUES ('183053031', '李亚群', 'et8k2vi1jfto5p4ugj3vr2j9o608hqbc', null, null, '23');
INSERT INTO `student` VALUES ('184013023', '蔡华海', 'fhkkokc62iml14n2oug2iq51n6doh5ah', null, null, '23');
INSERT INTO `student` VALUES ('184013049', '梁华广', '-2vsoahgonm17jeag1vlj0bvpn2pp56s', null, null, '23');
INSERT INTO `student` VALUES ('184013108', '黄晓霜', '-cfvt7v4c9da95qvn2hurumgikcloqt4s', null, null, '23');
INSERT INTO `student` VALUES ('184013110', '李元燎', '-95drei5m4o6n35lhsh4hskhuo3pfbice', null, null, '23');
INSERT INTO `student` VALUES ('184013112', '杨孔', '-2upgauhclf2htiucleo5no8ie62rfm9f', null, null, '23');
INSERT INTO `student` VALUES ('184013113', '王志敏', '-5uhdh247l7kfn1uk9jtahjff3gp4ah3v', null, null, '23');
INSERT INTO `student` VALUES ('184013114', '朱海', 'c8439qkovjh276unntiq3umuj0rpugod', null, null, '23');
INSERT INTO `student` VALUES ('184013115', '王莉晴', '-22f1fukmje98tkt1ilmpr7g1mdtsa46e', null, null, '23');
INSERT INTO `student` VALUES ('184013116', '石煜征', '15sk9bfsrg4k5fh9areorjchmdph064c', null, null, '23');
INSERT INTO `student` VALUES ('184013118', '黄孔林', '2qrqupt3i1mo86n10ht73qbb132r8d72', null, null, '23');
INSERT INTO `student` VALUES ('184013120', '陈德昌', '-1slphuhe9sa96tou3rd11d2b3e0to5ul', null, null, '23');
INSERT INTO `student` VALUES ('184013123', '李焱华', 'd19icg04agip2cs02h83nv12nlvaudr8', null, null, '23');
INSERT INTO `student` VALUES ('184013124', '韦毓植', '-eb9tlqng4cr79tagjr7pvvq58pno2gof', null, null, '23');
INSERT INTO `student` VALUES ('184013125', '钟镘英', 'eji1t07qcbuoahq43habkl7gfu64ford', null, null, '23');
INSERT INTO `student` VALUES ('184013126', '黄建桥', 'f6c0otrl5kh8bra5muqbdltvk9jjlq90', null, null, '23');
INSERT INTO `student` VALUES ('184013127', '傅相龙', '-5156aup0epf8041t5ksm0adq1lfctt7d', null, null, '23');
INSERT INTO `student` VALUES ('184013128', '周佩玲', '9k13qhshi61g4g5ck8er7jdsf45bmtsn', null, null, '23');
INSERT INTO `student` VALUES ('184013129', '李天悦', '-firidl4qbcrf3nnu6qnrk5ks5q7db81i', null, null, '23');
INSERT INTO `student` VALUES ('184013131', '秦晖明', '-6ghqj7p95gia8tiggocm3f0imomscne6', null, null, '23');
INSERT INTO `student` VALUES ('184013133', '陈灿', '1pqam9evmq2rvi2rnujfogpu5kqgl5sa', null, null, '23');
INSERT INTO `student` VALUES ('184013134', '蓝湘萍', '98jjbesl4m9i5tl3pev8cdpfesmeodds', null, null, '23');
INSERT INTO `student` VALUES ('184013135', '郭政', '-s4riar9chi3ef2fajl5aemaeglhbpeo', null, null, '23');
INSERT INTO `student` VALUES ('184013136', '杨家林', '-2nhtma55bl4p97usmiac38gq6dl1nfmp', null, null, '23');
INSERT INTO `student` VALUES ('184013137', '殷文博', '2qpah3j0gqo6v1465qflsbfs17o7hmvi', null, null, '23');
INSERT INTO `student` VALUES ('184013138', '项海平', '-2s7lie3sfgv7cr7isrsigs76m2i8e8rp', null, null, '23');
INSERT INTO `student` VALUES ('184013139', '杨冰', '-am6uch0qjhg5n81r6f2cajbu4ei56an2', null, null, '23');
INSERT INTO `student` VALUES ('184013140', '陆明潇', '-8470j8q7vhusu2jca5jps7osgsbqfcb4', null, null, '23');
INSERT INTO `student` VALUES ('184013141', '王天琴', '-4919hsab4igfa8so0s863nbugh18aeqm', null, null, '23');
INSERT INTO `student` VALUES ('184013142', '李佳承', '9j5g931rscvaedta0b66bon27s80m2jt', null, null, '23');
INSERT INTO `student` VALUES ('184013143', '杨程程', '-ahl56c4jfcgangeqpdc7o50k9hk6ei64', null, null, '23');
INSERT INTO `student` VALUES ('184013144', '周科', '-a7filrmh45avdlpcd76forhhe02bigl1', null, null, '23');
INSERT INTO `student` VALUES ('184013145', '何小米', '-fighogft1rheljakvdgduq27tfbmegis', null, null, '23');
INSERT INTO `student` VALUES ('184013146', '苏雪梅', '277eo53qae32htsi3sgd8524jirts667', null, null, '23');
INSERT INTO `student` VALUES ('184013147', '邓常元', 'f4sg6o8a8290tq4c9b7g0b8157t8qo6g', null, null, '23');
INSERT INTO `student` VALUES ('184011001', '谢正邵', '-d1deachpk0on7ev1motj4lvna1jqdseu', null, null, '24');
INSERT INTO `student` VALUES ('184011003', '覃柳航', '-9hqmi21aob5dftemchuh32psi24gu7uj', null, null, '24');
INSERT INTO `student` VALUES ('184011004', '韦云慧', '-3dpe9nmecp3a0d5tlbdli1cc4h6f5vvv', null, null, '24');
INSERT INTO `student` VALUES ('184011005', '银邦磊', '-1d4rm4ht7a8122h9e47kfugnii61elrk', null, null, '24');
INSERT INTO `student` VALUES ('184011006', '陀杰雄', '8g43n80cfeskjk7jjci6jgde5e07eo8j', null, null, '24');
INSERT INTO `student` VALUES ('184011007', '冯志成', '-90gitj6u2ogro2b0eieu4j2r99fe9mlh', null, null, '24');
INSERT INTO `student` VALUES ('184011008', '常存龙', '-6h33sb6qmka94cl3s7fjverq59248ecu', null, null, '24');
INSERT INTO `student` VALUES ('184011009', '韦康', 'dfu0m8i603j976mvv34eu64l79l02kd7', null, null, '24');
INSERT INTO `student` VALUES ('184011010', '黎桂炯', '-dfvt5f241174c15ha5693jik776hmckj', null, null, '24');
INSERT INTO `student` VALUES ('184011011', '潘雪杉', '8u21tskcda0djgbfcde3i7irlblnd99q', null, null, '24');
INSERT INTO `student` VALUES ('184011012', '廖洎娴', '-j04pbustrtq7np7jdk7569tvsfmj7aj', null, null, '24');
INSERT INTO `student` VALUES ('184011013', '廖海枫', '-5uv0v1ovrjq9104nj7uosh8g3aoinbf0', null, null, '24');
INSERT INTO `student` VALUES ('184011014', '杨南南', '-738301obkgi617fs7pfkcjhvj3f4mdss', null, null, '24');
INSERT INTO `student` VALUES ('184011016', '温丽秀', '-7r6ugqhogkdj1f65bssks8udu64i3tu1', null, null, '24');
INSERT INTO `student` VALUES ('184011017', '黄松', '9te2pudniv8u93lmbmt9ejngi9g6pket', null, null, '24');
INSERT INTO `student` VALUES ('184011018', '韦健', '476i94gbdnjrc1tb9b4mbckir9j0c6a7', null, null, '24');
INSERT INTO `student` VALUES ('184011019', '罗仕安', '29qeerib6lsgm0eviaith3d6pedc9pil', null, null, '24');
INSERT INTO `student` VALUES ('184011020', '韦潘欣旭', '-aq9gc5qsm2kefjnp5dj83sim83hjqjac', null, null, '24');
INSERT INTO `student` VALUES ('184011021', '覃志鹏', 'bpo2bpudan3j7182i15duhu4n6pbbfgq', null, null, '24');
INSERT INTO `student` VALUES ('184011022', '蒋非凡', '3eol04nidmobuk1u23n8k8o9umbas82a', null, null, '24');
INSERT INTO `student` VALUES ('184011023', '杨斌', '-3tjt6c2dsees9pio1bfk9uj1cqm6letu', null, null, '24');
INSERT INTO `student` VALUES ('184011025', '刘宝龙', 'fohifcj3egdl2euv7gvde7dknqufn8r5', null, null, '24');
INSERT INTO `student` VALUES ('184011027', '张其贤', '6u6dqmhr95tjqjt67mjt9cur0e4kn661', null, null, '24');
INSERT INTO `student` VALUES ('184011028', '何榆锋', '3rh3kjg10j17an43mu7rocolts83i253', null, null, '24');
INSERT INTO `student` VALUES ('184011029', '陈艳婷', '8t8ev3tpa62vh4om6bej4sppn6badn1j', null, null, '24');
INSERT INTO `student` VALUES ('184011030', '杨婷', '11e8j9hnel49297bn7u1l0n4heo2jia2', null, null, '24');
INSERT INTO `student` VALUES ('184011031', '庞友', '6fulvcclk6d9aod63q489c4ubntusmel', null, null, '24');
INSERT INTO `student` VALUES ('184011032', '韦庆君', '9vf79faaroa6btp5rl9he123qus3ofn0', null, null, '24');
INSERT INTO `student` VALUES ('174011050', '周思瀚', '-f15psa33s9tjgkn84o9j5d2dr98uns6n', null, null, '25');
INSERT INTO `student` VALUES ('184011034', '庞鸿许', '20l0mppfdkoslhckdbrrjo0nspt18giq', null, null, '25');
INSERT INTO `student` VALUES ('184011035', '周娟萍', '4nhhj8aopbqpvfsdqu5krr5el3m16ni8', null, null, '25');
INSERT INTO `student` VALUES ('184011038', '叶远洋', 'd4l1bku3rcced9et9rjl5lfhheejl8au', null, null, '25');
INSERT INTO `student` VALUES ('184011039', '唐国顺', 'egqko64gu2dfuh15ansjgp3sf732ipgc', null, null, '25');
INSERT INTO `student` VALUES ('184011040', '蒋国辉', '-e9kb8v2mgvv2jj57se6d3krvqu0f6ml7', null, null, '25');
INSERT INTO `student` VALUES ('184011043', '周子贤', '-2gdgmoffa3b8un23gqene394hs4mi824', null, null, '25');
INSERT INTO `student` VALUES ('184011044', '颜国江', '-emuoo518uk2mnkcpvivqavadg576p0e7', null, null, '25');
INSERT INTO `student` VALUES ('184011047', '梁鑫柱', '3nt3qrg4qo05ds0f2lu6v3uggh73ge2n', null, null, '25');
INSERT INTO `student` VALUES ('184011048', '吴艳芳', '5jse8c31ud3huu6868pg80nodaqgu3u0', null, null, '25');
INSERT INTO `student` VALUES ('184011049', '陈何伟', '-bmsvbgbjg85akouf42igf79pjt2s5mnq', null, null, '25');
INSERT INTO `student` VALUES ('184011050', '庞天赐', '-9o5u2795ng18sem4pmbfbhefofnsnnmb', null, null, '25');
INSERT INTO `student` VALUES ('184011051', '文彬宇', '-2cts9v4nrjqe456apfqfl0g8740ir3av', null, null, '25');
INSERT INTO `student` VALUES ('184011052', '黄昌耀', '-8kp227qb93tjj0468sia6aeq13auba9u', null, null, '25');
INSERT INTO `student` VALUES ('184011053', '陈正强', '6u9f7n43kbcpkqbckvtl1tf2hvgvdntd', null, null, '25');
INSERT INTO `student` VALUES ('184011054', '余海凤', 'djn8aav2s0v8m52mjqicu58dcd61vo69', null, null, '25');
INSERT INTO `student` VALUES ('184011055', '张慧玲', '93bd2ke02t70le72k9t8mt1hj8q2529j', null, null, '25');
INSERT INTO `student` VALUES ('184011056', '卢铭伟', '68ifkd784880b3c3fbel58a38lojtas6', null, null, '25');
INSERT INTO `student` VALUES ('184011057', '潘雪莲', '-6e0pa3f7goan9g5jffa1rufuuet5jbrs', null, null, '25');
INSERT INTO `student` VALUES ('184011058', '廖世威', '-a1ebkobor4epivucfs54jg624mfcbggc', null, null, '25');
INSERT INTO `student` VALUES ('184011060', '覃程蔃', '-2er79u3tdbbujoh8v0gjrns971b64ofb', null, null, '25');
INSERT INTO `student` VALUES ('184011061', '陈信有', '92k0v21e5hmmfjog0062po10thj6ggav', null, null, '25');
INSERT INTO `student` VALUES ('184011063', '廖志成', '-38t3gart32o6tpt266hhlqe8eatfp6gq', null, null, '25');
INSERT INTO `student` VALUES ('184011065', '邓继业', '-2hanjk39q980dl915888nklpf4t9a29p', null, null, '25');
INSERT INTO `student` VALUES ('184013001', '李新明', '11g3ftn7kmj7eiv6adntb9dsrncqk870', null, null, '26');
INSERT INTO `student` VALUES ('184013004', '张富龙', '-2ofgklof1302o459lt2rn8ja0bue82ns', null, null, '26');
INSERT INTO `student` VALUES ('184013021', '陈水娇', '-6gr8q19ae6gik4vbuqiqns9cat8b6kh1', null, null, '26');
INSERT INTO `student` VALUES ('184013027', '陈升喜', '-cedkskh72thprav7l9tv0c62vnmte3u', null, null, '26');
INSERT INTO `student` VALUES ('184013035', '苏奇宁', '-49k9thofahr79m0sgile8urk4lb5qasm', null, null, '26');
INSERT INTO `student` VALUES ('184013041', '劳雄明', '-5hnmnd8lvm8sc2t65ctbdac260p7n1oo', null, null, '26');
INSERT INTO `student` VALUES ('184013045', '马其钍', 'bibvf1t0ibkhp46hlttijur3gt876rqs', null, null, '26');
INSERT INTO `student` VALUES ('184013047', '黄信', '-154hodrdn220muf14a1h3pl1294ahtvi', null, null, '26');
INSERT INTO `student` VALUES ('184013057', '王梦', 'dgp5f2omq4t00t35ffh1hgdtsupnlp5e', null, null, '26');
INSERT INTO `student` VALUES ('184013058', '王仕潘', 'chgpjdla3k1d9pe6o9u4i01mlsc52qhu', null, null, '26');
INSERT INTO `student` VALUES ('184013059', '苏宁', '-85s4eip0sgt03gqom6goosouddumdvkg', null, null, '26');
INSERT INTO `student` VALUES ('184013074', '蔡喜铭', '-4c22np1dv7iqe6i48q0n752i8p3dso7p', null, null, '26');
INSERT INTO `student` VALUES ('184013080', '张碧文', '-mh6tv7gg6hgqi846h59r9tgr645dd5s', null, null, '26');
INSERT INTO `student` VALUES ('184013084', '庞力睿', '-cnnk6oo49rqolfhopls54s2tf1vpcr86', null, null, '26');
INSERT INTO `student` VALUES ('184013086', '吴期俊', '-64o709olndnavvib31bqc8r7ru61ohbn', null, null, '26');
INSERT INTO `student` VALUES ('184013100', '覃腾庆', '-27e2le2dq31i96226o4va2b8dvk2e4im', null, null, '26');
INSERT INTO `student` VALUES ('184013101', '陆科名', '-fgkkovons8puhsg7jvlm1sq5qm54ojv', null, null, '26');
INSERT INTO `student` VALUES ('184013102', '莫鸿伟', '43uj98g9btrbvil7g769ii01j4araeuh', null, null, '26');
INSERT INTO `student` VALUES ('184013103', '杨佳宁', '-60qcirk8q11csqf1u8nhs274fgkfdcb0', null, null, '26');
INSERT INTO `student` VALUES ('184013105', '韦彩菊', '-6lu3k29vcb5ldajt73cebbhg3qn1tupj', null, null, '26');
INSERT INTO `student` VALUES ('184013106', '韦宇', 'fs623pd39am5teccpkg2aesv5gan54ug', null, null, '26');
INSERT INTO `student` VALUES ('184013107', '莫镇萍', '9dbho4ecqfuf28a55to3eoonnf8osq0j', null, null, '26');
INSERT INTO `student` VALUES ('184013111', '朱谏青', '-7ujijlordb4fbpijvntk3q8rjlisdjup', null, null, '26');
INSERT INTO `student` VALUES ('184013119', '刘可贵', '-9ol7nf962c0f6qcud55hiagq1ge371d4', null, null, '26');
INSERT INTO `student` VALUES ('184013122', '卜萱忠', '4ng8ddkq7l8hraf1t3bcq3l1cmtlamsf', null, null, '26');
INSERT INTO `student` VALUES ('184013132', '林秋兰', '-a90r6f5cmjgb8vhgfo5mnpt812lbc0q7', null, null, '26');
INSERT INTO `student` VALUES ('184093001', '梁东生', '-3eovaske95bv1g3beude7ecoi4o1n6dm', null, null, '26');
INSERT INTO `student` VALUES ('184093002', '李鑫', '-bmo63jrth5avlti9btu98ir9v7tm6o59', null, null, '26');
INSERT INTO `student` VALUES ('184093004', '黎维', '-efj4tkrijkrblcfcg00ao0bffgeff1g2', null, null, '26');
INSERT INTO `student` VALUES ('184093005', '李永浈', 'aq107l0omld3ghipdp6htuepbvi2njqk', null, null, '26');
INSERT INTO `student` VALUES ('184093006', '何泓绍', '-7edtrucnqop9kb464eu4cqhb01557qp6', null, null, '26');
INSERT INTO `student` VALUES ('184093007', '陈俊材', '-7kvst5e0tqe6oii9omd7q89468egjpqd', null, null, '26');
INSERT INTO `student` VALUES ('184093008', '林栋圣', 'f60k4tesr9402khdmd390ngn2k6nn5u', null, null, '26');
INSERT INTO `student` VALUES ('184093009', '彭炳贵', '5mt3sqi18dfjidm0cn2399jfm8rnhc55', null, null, '26');
INSERT INTO `student` VALUES ('184093010', '黄重霖', '-djvkn2ltuoob62p900mlmsnnps8a8qvk', null, null, '26');
INSERT INTO `student` VALUES ('184093011', '陈春晓', '-9ucflbu47q3rhp1fntf0gk2ep4pdgdjf', null, null, '26');
INSERT INTO `student` VALUES ('184093012', '义坤琪', '1rbmipr7jqlbumki2bie1uas7i7m86st', null, null, '26');
INSERT INTO `student` VALUES ('184093014', '黄成宇', 'b4e5cactcf20auqjjb8bbr81vkdu4j6c', null, null, '26');
INSERT INTO `student` VALUES ('174023079', '谢先文', '-cs1onorcoco6eoekm689lpkor2m8pkaf', null, null, '1');
INSERT INTO `student` VALUES ('184023002', '甘芷莹', 'e56afugqfvukehclogtg3r2g3elt63am', null, null, '1');
INSERT INTO `student` VALUES ('184023003', '李施玲', '-35j0eopcv3en4sj4fkreeeo7huad2aeq', null, null, '1');
INSERT INTO `student` VALUES ('184023006', '蓝仕顺', '-emrdegs3lls7a9scq2bnunjp8f10a7ga', null, null, '1');
INSERT INTO `student` VALUES ('184023007', '蒙泽', '22a0hchgdelo3pdf67jgepjsjm75fvau', null, null, '1');
INSERT INTO `student` VALUES ('184023008', '黄露萍', '-7qcltgrkagjdc1cm25oq8s4khpcq60k5', null, null, '1');
INSERT INTO `student` VALUES ('184023009', '林金萍', '-8t2m0pt3q2v5d41h7oh68amfpigo3a48', null, null, '1');
INSERT INTO `student` VALUES ('184023014', '龚榆红', 'gumb1m8u85g32pjjm4ijjv8kr032via', null, null, '1');
INSERT INTO `student` VALUES ('184023015', '徐方夏', 'bovgk29m2ashsglobgran97kr08u5ff2', null, null, '1');
INSERT INTO `student` VALUES ('184023018', '刘嘉辉', 'd85blk19ifel2gljqgvho6v7lrstcp32', null, null, '1');
INSERT INTO `student` VALUES ('184023019', '梁业', '-b9kca1t4kscokcmbcusmpcrm0p2qlml', null, null, '1');
INSERT INTO `student` VALUES ('184023020', '梁艺娟', '-3sugojbjd28pcg1dd82a4hugoiob2t4h', null, null, '1');
INSERT INTO `student` VALUES ('184023024', '覃显波', '-4snk1quhsub9l0t72sstr77mq13fcdk2', null, null, '1');
INSERT INTO `student` VALUES ('184023025', '黎明烺', '5o6i69j9pbc4lqpql93n9lsgngq4oqlk', null, null, '1');
INSERT INTO `student` VALUES ('184023031', '陈盛芳', '97of2t701naptoipblucdleovc67hqop', null, null, '1');
INSERT INTO `student` VALUES ('184023032', '梁耀荣', 'bb9u1tp462p137jtiup69koodd3mm0p', null, null, '1');
INSERT INTO `student` VALUES ('184023035', '刘嘉琪', '98f6t5chuo8iu71n66f9puk8eiqqiucc', null, null, '1');
INSERT INTO `student` VALUES ('184023038', '黄晓艳', '-a8j5948tivqrsdeahdgf52es3svrsr43', null, null, '1');
INSERT INTO `student` VALUES ('184023040', '莫石伟', '-bpqir8lrbhnmio08vbhhdhkinog8jjj8', null, null, '1');
INSERT INTO `student` VALUES ('184023094', '何艳兰', '67mmclkm3uu7salds6ell2jaint76bi', null, null, '1');
INSERT INTO `student` VALUES ('184023097', '韦梓梅', 'emam342p9p4ed8ssk04sbpem28gsnhnc', null, null, '1');
INSERT INTO `student` VALUES ('184023101', '谭艳', '-7spr1m563330h2ojr3om9mbmmbgg5rgi', null, null, '1');
INSERT INTO `student` VALUES ('184023103', '李桐州', '-don2h3nqf0u6imgogik1fe1e17tc5687', null, null, '1');
INSERT INTO `student` VALUES ('184023104', '巫辅斌', '-78qn9me2umf6hnocccuhkctsk9vt8u0v', null, null, '1');
INSERT INTO `student` VALUES ('184023105', '谭凯云', '-abopps3n7g78gh6abd9i8ll58u9qseoe', null, null, '1');
INSERT INTO `student` VALUES ('183023013', '梁焕辉', 'cadbaeea6igfgubhu1vbuj451d0tofei', null, null, '4');
INSERT INTO `student` VALUES ('184103002', '庞秋萍', '-4cs88338ph373mijclqq3t6tvo07vmji', null, null, '4');
INSERT INTO `student` VALUES ('184103003', '韦千帆', '-94msktkn38747n11bocbqmp3c17dq3v5', null, null, '4');
INSERT INTO `student` VALUES ('184103005', '陈美瑛', '-9e06f9l580uoqsukv249urfg0ue3l9iu', null, null, '4');
INSERT INTO `student` VALUES ('184103008', '蒋玉林', '8c4aetg61b8bmbd2b4n3581aldauipkd', null, null, '4');
INSERT INTO `student` VALUES ('184103009', '谢明洋', 'ec5j0lc0svlm5v88irple3m53alkat2b', null, null, '4');
INSERT INTO `student` VALUES ('184103010', '赖宏军', 'b3u9u9mvbi185q5bgt2cejma672mogvo', null, null, '4');
INSERT INTO `student` VALUES ('184103012', '葛玉安', '4snkml1qgvn5llli5qk7aibtp84mefab', null, null, '4');
INSERT INTO `student` VALUES ('184103013', '梁舒雯', '5msab2ghjkrh3nufdhoq9iinjea9pbqk', null, null, '4');
INSERT INTO `student` VALUES ('184103014', '卓家伟', '-c0g7674eejtchosa53079k1qmhgqvdpt', null, null, '4');
INSERT INTO `student` VALUES ('184103015', '陈家龙', 'd85blk19ifel2gljqgvho6v7lrstcp32', null, null, '4');
INSERT INTO `student` VALUES ('184103016', '宋健', '5ufg1ps9b5rq0c3fdcf60vjet2rf5o39', null, null, '4');
INSERT INTO `student` VALUES ('184103017', '李玉钦', '-5ri0djn5agvigi7sl59ofb0qmvo2pstl', null, null, '4');
INSERT INTO `student` VALUES ('184103018', '黎雨倩', '-2hhk1cj2ua2v7lnavuilm68jh8k178hi', null, null, '4');
INSERT INTO `student` VALUES ('184103019', '白安善', '-bu2onbih2a5kraauuro83d9bcfhcfi7g', null, null, '4');
INSERT INTO `student` VALUES ('184103021', '韦思涛', '-drdj903oek5na006f9gg6j6duej4m3vd', null, null, '4');
INSERT INTO `student` VALUES ('184103022', '吴艳娜', '5hm5rprdqa896t7hkolm2b4vmlk5a97u', null, null, '4');
INSERT INTO `student` VALUES ('16253104', '吴立康', '-36l32usgpavrndecrs4mu08bqr1fh1uf', null, null, '2');
INSERT INTO `student` VALUES ('16253126', '潘广坤', '-en2vmbjr7tku48480bithatnmn6i2uol', null, null, '2');
INSERT INTO `student` VALUES ('174023008', '庞东', '3srpjhk9if2vm7lmqtccrr63im97v3e6', null, null, '2');
INSERT INTO `student` VALUES ('184023041', '谢名龙', '491m9d0kk3fcvvf77935ujlaq99p5qam', null, null, '2');
INSERT INTO `student` VALUES ('184023042', '黄晓梅', '-4r6h99mb07hkil20bsikvnctif44ajij', null, null, '2');
INSERT INTO `student` VALUES ('184023043', '覃宝重', '-3g8invv20phg99413aukpv6b6st4r7j9', null, null, '2');
INSERT INTO `student` VALUES ('184023047', '吕茗', '-4959u76of1ofeno8goediktl8sh7jg7q', null, null, '2');
INSERT INTO `student` VALUES ('184023048', '赵飞腾', '-4ueta784hvvq576cqgd31m4agpb0fmto', null, null, '2');
INSERT INTO `student` VALUES ('184023051', '韦程耀', '-bdjg1uqtej3djts0n14jgert7a1aak1e', null, null, '2');
INSERT INTO `student` VALUES ('184023054', '吴明师', '30qukhqnho4q8mie3ttepdpkhcs8g3e6', null, null, '2');
INSERT INTO `student` VALUES ('184023055', '李亮', '-2d1tgka4k65mdnttdbt94u2e6scvm2pa', null, null, '2');
INSERT INTO `student` VALUES ('184023057', '陈宇', 'ud695lrs4tkvet16ksbffuikjjj5dm9', null, null, '2');
INSERT INTO `student` VALUES ('184023059', '伍文芳', '-1q6406isu87eji3i7b5o808ofdar6rhh', null, null, '2');
INSERT INTO `student` VALUES ('184023061', '杨兰', '-9ui7vurfaareq3dg283jdlt1bpktkbu0', null, null, '2');
INSERT INTO `student` VALUES ('184023062', '潘雪', '5doks17emt0g8nr2p3bstheefacqmqkb', null, null, '2');
INSERT INTO `student` VALUES ('184023063', '潘锦海', '1ja17cfv4gbt10rrf7m22t1df27pi1de', null, null, '2');
INSERT INTO `student` VALUES ('184023067', '温凯杰', 'btnb6u8o9b6ffq3kbt9rkra08qg06dq0', null, null, '2');
INSERT INTO `student` VALUES ('184023070', '黄晓宇', '-8dgmlv494krituckl8rqdvh13q574dao', null, null, '2');
INSERT INTO `student` VALUES ('184023071', '高燕铃', '-e7j5ia2tkatg623bm76vgu3i7ukk78fa', null, null, '2');
INSERT INTO `student` VALUES ('184023072', '叶泽民', 'ak9gd0sn36ool1q1h0r1sdd521nfssu0', null, null, '2');
INSERT INTO `student` VALUES ('184023073', '袁发琪', 'c7dlhnbnd2dce5lt2pi5btisc44dt9qo', null, null, '2');
INSERT INTO `student` VALUES ('184023074', '吴森', '487t6tk6lut7l3afhsunojaaaqngls67', null, null, '2');
INSERT INTO `student` VALUES ('184023075', '陈思伊', '65ltkgoeb1rh7673bp3dqqeiv0t5f4mv', null, null, '2');
INSERT INTO `student` VALUES ('184023078', '陆律史', 'ejja0ln4d8o3fhirk6ktu1oslc8lth03', null, null, '2');
INSERT INTO `student` VALUES ('184023079', '黄宁', '-4eoklkfrfeam894tc9n5lfon3oe4ggd7', null, null, '2');
INSERT INTO `student` VALUES ('184023080', '陈伦富', '-9eohufeu54e6bmgef83g19thh1amt9g9', null, null, '2');
INSERT INTO `student` VALUES ('184023081', '黄绍镇', '-euighit4sil4bc1l85fmch5atqdpki8u', null, null, '2');
INSERT INTO `student` VALUES ('184023082', '周杰', '53vsaagfdar2aquje507ik7gf0t0diml', null, null, '2');
INSERT INTO `student` VALUES ('184023083', '姚涛荣', '-dp3pibb6k254a7it4dn4jejt6amc0c2e', null, null, '2');
INSERT INTO `student` VALUES ('184023084', '韦义杰', '395l0kba6q97612q81sukukkr6dmmerv', null, null, '2');
INSERT INTO `student` VALUES ('184023085', '王宗友', '2mevbbfmoqmr8d3spbfku8meodoa811c', null, null, '2');
INSERT INTO `student` VALUES ('184023086', '蒙宁', 'cn245l4j8jouvcuoum4sadgil0b4i1eb', null, null, '2');
INSERT INTO `student` VALUES ('184023087', '文宗念', 'd16orpqf9b9esn3i4eo8uosbci0th0n3', null, null, '2');
INSERT INTO `student` VALUES ('184023088', '黄杰威', '-comeqoladf8iq1043rnv0v1flaovs8g2', null, null, '2');
INSERT INTO `student` VALUES ('184023092', '黄永帅', 'd8ipnu4t3un8h5ncrc60mi78boqhcpka', null, null, '2');
INSERT INTO `student` VALUES ('184023095', '朱远席', '-ejhfq346k7s0bfpdccpu38psfk84d381', null, null, '2');
INSERT INTO `student` VALUES ('184023102', '凌洪科', '-bo31sjgqm7g0g0v7iaa63rmn57mtcd8e', null, null, '2');
INSERT INTO `student` VALUES ('184011064', '彭康宇', '10kg0ngoi1m4jakt05i7gj06jf33jhon', null, null, '3');
INSERT INTO `student` VALUES ('184021002', '梁智翔', '9hdfnppf32j9vhbqgecv19nj2l1r3o8g', null, null, '3');
INSERT INTO `student` VALUES ('184021004', '李本宇', '31rt3uhjgb2m40kr4g7hksqroohrle0d', null, null, '3');
INSERT INTO `student` VALUES ('184021005', '许发林', 'c0at7lgj4fjacrlml2rmmelni537gnkh', null, null, '3');
INSERT INTO `student` VALUES ('184021008', '王俊焱', '5r1p05n3cfhn98las4cnocgeoralfk70', null, null, '3');
INSERT INTO `student` VALUES ('184021009', '谭庭宇', '84mstblmr0ttq290tr067jlffs6ugldn', null, null, '3');
INSERT INTO `student` VALUES ('184021010', '李明威', '-b9vhdjr1v42862nbdis1o215f45ef1qc', null, null, '3');
INSERT INTO `student` VALUES ('184021011', '贾飘雪', '-71t78q64t5q7bvju46jdog4turhve741', null, null, '3');
INSERT INTO `student` VALUES ('184021012', '何晓婷', '8a57peceqvvgbq8qpsgfpa9m4amppl69', null, null, '3');
INSERT INTO `student` VALUES ('184021013', '韦必峻', '5fplt752bp3bkil0ej131obq4ee4rrpk', null, null, '3');
INSERT INTO `student` VALUES ('184021014', '韦祖枣', 'fc94hi8vabdfb6mn31ndr8q02c829is8', null, null, '3');
INSERT INTO `student` VALUES ('184021015', '蓝吉鋒', 'ooa4qmhflk2mr1ckmonc59vf3985nb1', null, null, '3');
INSERT INTO `student` VALUES ('184021016', '韦军情', '-7nt01pmfja7vn2onsiospkqp5obgt26r', null, null, '3');
INSERT INTO `student` VALUES ('184021019', '吴剑鑫', '6hj05i9al2hben4fm1ef3r0l3vko9gqf', null, null, '3');
INSERT INTO `student` VALUES ('184021020', '吴丽双', 'jn2tt5miasi5e0fs7pv4p9e5il821m2', null, null, '3');
INSERT INTO `student` VALUES ('184021021', '冯民靖', '-83bl8nocut7j21l8rnuqvokvan71iqfk', null, null, '3');
INSERT INTO `student` VALUES ('184021022', '石宁婉', 'b16vrr7l077fc22ptdt1icl5j00037j7', null, null, '3');
INSERT INTO `student` VALUES ('184021023', '袁琦琪', '3230fpjn2e7q5st8k10l7ci9mhdn59or', null, null, '3');
INSERT INTO `student` VALUES ('184021024', '韦蒙华', '2p1i8qtllic33qnhuk1l0tvl6f8m7sv6', null, null, '3');
INSERT INTO `student` VALUES ('184021025', '郭鹏', '-73tulrop8lvelah9v1eird7q518igcbn', null, null, '3');
INSERT INTO `student` VALUES ('184021026', '夏慧芝', 'bjda3e3rs95hpo0ojtpvm0ee5ie2prhj', null, null, '3');
INSERT INTO `student` VALUES ('184021027', '吴雅萍', '-788le6sh5u5ej42rkttjkqv9qdouiiu3', null, null, '3');
INSERT INTO `student` VALUES ('184021028', '王建鹏', 'c3dc17vff7moo6jl9404o8jktc9r1kde', null, null, '3');
INSERT INTO `student` VALUES ('184021030', '邱慧琳', '7mo0kjc7h5gll5hpmc6tvrls23ara4fa', null, null, '3');
INSERT INTO `student` VALUES ('184021031', '覃柳芝', 'ctnflnf7a0q7uuebo9f1k953vaqdlup2', null, null, '3');
INSERT INTO `student` VALUES ('184021034', '凌嘉良', '5otggcoipmng3c9r0484fmp1vvmtoeca', null, null, '3');
INSERT INTO `student` VALUES ('184021037', '吴贤锐', '7q2voe97gag1pop6kju17clk1ug7j4d6', null, null, '3');
INSERT INTO `student` VALUES ('184021001', '温丽婷', 'cij9d6aed5mjmg5oajqc6uomg0p3k830', null, null, '5');
INSERT INTO `student` VALUES ('184021006', '邓柳锋', '-951mvpl87ufco3ssmveu0ns8bqodvc76', null, null, '5');
INSERT INTO `student` VALUES ('184021007', '贺正翔', '-ku538te82d5lgsjbvlmcm2pksjl9r5u', null, null, '5');
INSERT INTO `student` VALUES ('184021017', '李雪滢', '9v2kihuq8c1aas7pi21c7slianmj4mj1', null, null, '5');
INSERT INTO `student` VALUES ('184021018', '黄钦龙', 'fevbk4b6k3rjb6sn1gmm9fctasbmbclh', null, null, '5');
INSERT INTO `student` VALUES ('184021029', '兰坪芯', '-a78e6nkjab8l1ilr87sschrnlkpbcvfl', null, null, '5');
INSERT INTO `student` VALUES ('184021036', '苏春洪', 'dfu0m8i603j976mvv34eu64l79l02kd7', null, null, '5');
INSERT INTO `student` VALUES ('184023001', '裴强钧', '72v87pikjsmm493khnclv97alsl4qg53', null, null, '5');
INSERT INTO `student` VALUES ('184023005', '李玉锋', '9sf42l1jukhfnbvficlvr5mklcci5vme', null, null, '5');
INSERT INTO `student` VALUES ('184023011', '梁维健', '-evca72k3bdc7hinvb9ik8e1slp7c8si4', null, null, '5');
INSERT INTO `student` VALUES ('184023016', '杨东运', '-dqvdm58u90ln8pgt6af9h2bhuea5lj91', null, null, '5');
INSERT INTO `student` VALUES ('184023017', '黄祖礼', '-89061fmtkvej3ineiosgfaqhi57iha4p', null, null, '5');
INSERT INTO `student` VALUES ('184023021', '莫惠勇', '-fuhejplngmojkskhlju41bhsldv5s0c2', null, null, '5');
INSERT INTO `student` VALUES ('184023022', '廖丕云', 'a7bpolq998dj09gojl33eb3ki3aupf82', null, null, '5');
INSERT INTO `student` VALUES ('184023026', '陈俊元', '3mftct4l6pt8p5es19vk5mkg15658f1s', null, null, '5');
INSERT INTO `student` VALUES ('184023027', '吴剑滨', '5hgkjnt22mucaienb79sjg3eqcg0ci0j', null, null, '5');
INSERT INTO `student` VALUES ('184023028', '李海平', '-eduopvmbcjvalm4vvluevlvm9l6g6kq6', null, null, '5');
INSERT INTO `student` VALUES ('184023030', '李庆龙', 'dk06sist0fq3tkncoksb7q25tskqdpqk', null, null, '5');
INSERT INTO `student` VALUES ('184023034', '朱海健', 'bu6pejbq0j2nth5oqcnt4dobvrvqvmp1', null, null, '5');
INSERT INTO `student` VALUES ('184023036', '陈源', '2oos88286av03urs4jlbiu4b9rp92ssn', null, null, '5');
INSERT INTO `student` VALUES ('184023039', '宋秋赵', 'dhg93vrp6u915dllnru699gabi2t18ug', null, null, '5');
INSERT INTO `student` VALUES ('184023044', '龙永鑫', '-8fqf84jar0q3fiigchnflboq4jl324ca', null, null, '5');
INSERT INTO `student` VALUES ('184023045', '岑辉山', '-47l3f9euo6hl2cphohaqs64a045ki9o2', null, null, '5');
INSERT INTO `student` VALUES ('184023050', '周家乐', '23pjh1gdq0e6njlf3h9s7qjv95oqaf5m', null, null, '5');
INSERT INTO `student` VALUES ('184023052', '姚文臣', '4sklmb26p0vpktn5n86jdgts0mphfcm3', null, null, '5');
INSERT INTO `student` VALUES ('184023053', '韦传海', '86jb020qis2f66omo2hbi9i5bb9qgtrg', null, null, '5');
INSERT INTO `student` VALUES ('184023060', '李琦', '-cspd5tem9rpc5p5cf56mfnnjg0apsfum', null, null, '5');
INSERT INTO `student` VALUES ('184023068', '黎浩志', 'cmett840osberd66nu2a84ar2qon2po3', null, null, '5');
INSERT INTO `student` VALUES ('184023099', '李乃健', '6kkccip2ppu8oftbgp28icecnrtlhipe', null, null, '5');
INSERT INTO `student` VALUES ('184023100', '杨丽敏', '7gbk42fb20a8hveb88s66opt0lvc7klq', null, null, '5');
INSERT INTO `student` VALUES ('184053001', '陆艳红', '13foc2kos4t2hqmps78vfgk0et6il3rb', null, null, '27');
INSERT INTO `student` VALUES ('184053003', '韦艳修', '-e1ssrkjqj35r9la053jif30oqni41pcv', null, null, '27');
INSERT INTO `student` VALUES ('184053004', '梁瑜', '-49ugd6g09schng3qa96q72c8s436492f', null, null, '27');
INSERT INTO `student` VALUES ('184053007', '龚捷阳', '-brlf4pgm4eevtsrbmdskae3ko47302h3', null, null, '27');
INSERT INTO `student` VALUES ('184053008', '韦玉玲', '-bvk04di5i1j22nk9fibqchpkvdqnprjn', null, null, '27');
INSERT INTO `student` VALUES ('184053009', '陆燕芬', '-5rc7csl6itfprqr307r367r0613fubpb', null, null, '27');
INSERT INTO `student` VALUES ('184053013', '卢丽莎', '-agn519n9ak8qsdbseltf8ad4saorm2cn', null, null, '27');
INSERT INTO `student` VALUES ('184053015', '林凤萍', '-ds571m18b3date2ubjneehq0u9qaj7p6', null, null, '27');
INSERT INTO `student` VALUES ('184053016', '覃秋萍', '8f7rahtd7q091e8ld546vib75lbdo51v', null, null, '27');
INSERT INTO `student` VALUES ('184053017', '张紫芳', '6olrd6udv3gi9brc49c7aahd1th9t32g', null, null, '27');
INSERT INTO `student` VALUES ('184053018', '徐金玉', '-ceat9ed4bt4qtvkt1tq4qrvkpv426cuc', null, null, '27');
INSERT INTO `student` VALUES ('184053019', '曹仙云', '-1ljd95nco6lv0lf8sokond0v549tofed', null, null, '27');
INSERT INTO `student` VALUES ('184053020', '黄嘉丽', '-33rn3tja8t11hbq7vquvr3dt34t9904o', null, null, '27');
INSERT INTO `student` VALUES ('184053021', '陈新群', '1iu44p2qd1dlmtdfd7boelid2e9au219', null, null, '27');
INSERT INTO `student` VALUES ('184053025', '刘辉', '9bu4ul5kpi8rhvqqmr5lk549n9vg2ch6', null, null, '27');
INSERT INTO `student` VALUES ('184053027', '韦能铝', '-av97fctn5jgjnci13mvgo45ad0p9qruu', null, null, '27');
INSERT INTO `student` VALUES ('184053029', '郑金泉', 'f3fnd8gfppqshg2o0qde3b9tb6lln19g', null, null, '27');
INSERT INTO `student` VALUES ('184053032', '苏春亦', '-nb2eai3f7p87iuklvubfega4c39eglv', null, null, '27');
INSERT INTO `student` VALUES ('184053033', '吕文晖', '59orqa1af461m8hmop7rvnm0cjjbnh9u', null, null, '27');
INSERT INTO `student` VALUES ('184053034', '龚祖基', '-afcgp4670hbul3rsc8irjul7ubuchlhh', null, null, '27');
INSERT INTO `student` VALUES ('184053035', '李佳源', '-en040kr24n4kso2n7dn5i5dl5fdnq0p5', null, null, '27');
INSERT INTO `student` VALUES ('184053036', '李日江', 'th3jsjl9k8js0kbj87qtvbgldfljdrp', null, null, '27');
INSERT INTO `student` VALUES ('184053037', '杨展冰', '-6sbf5cfj0363p7h5idqtk3a9k1uaa13k', null, null, '27');
INSERT INTO `student` VALUES ('184053038', '潘映梅', '4pn6k8s2dtavh28p25mfbvn7j9l176ek', null, null, '27');
INSERT INTO `student` VALUES ('184053039', '李萃淼', 'c8fgcvq96utgq0t4a53puodr9g9u2bj3', null, null, '27');
INSERT INTO `student` VALUES ('184053040', '刘纲成', '978gm02ofsi460ov7qn1rtumkn9ejt15', null, null, '27');
INSERT INTO `student` VALUES ('184053043', '梁丹婷', '-iug56oftfu9ckj00vo56sgarb3r69of', null, null, '27');
INSERT INTO `student` VALUES ('184053044', '甘永慧', 'e59f10ivq2fpl0611mm0vphrd5ss7197', null, null, '27');
INSERT INTO `student` VALUES ('184053047', '廖彩依', '3aqq3e5ls5b49sripdfa64abtv07l2rt', null, null, '27');
INSERT INTO `student` VALUES ('184053048', '廖世好', 'erdo1r16sqfqv7ilg0hhf1fev50j01aq', null, null, '27');
INSERT INTO `student` VALUES ('184053049', '罗万科', 'an787qe4f3vo57p6gv93c1hks9eergfc', null, null, '27');
INSERT INTO `student` VALUES ('184053050', '吴宗麟', '9vnotdogs5rtbd27l3snen9m9d17n5bk', null, null, '27');
INSERT INTO `student` VALUES ('184053051', '黄玉爱', '-3s6495s4a9ul373u3tl5h2fdcovsmu8d', null, null, '27');
INSERT INTO `student` VALUES ('184053052', '罗海文', '-46ob4ra1o38jjtb8gcubvioj0vfotfk7', null, null, '27');
INSERT INTO `student` VALUES ('184053053', '黄小勤', '-f1t2n3c5f49qb2guefqdgcc2f0dk2mh4', null, null, '27');
INSERT INTO `student` VALUES ('184053054', '龙丽丽', '-12jlqnqjtomr91ip8ff41e77ihs0dmgt', null, null, '27');
INSERT INTO `student` VALUES ('184033004', '李国权', 'a4psc6epnpsq30ai990t7p8eqahk14ql', null, null, '28');
INSERT INTO `student` VALUES ('184053055', '冉桂花', '-6v8olvro8kng5rv801ng9vm1eclnrs1n', null, null, '28');
INSERT INTO `student` VALUES ('184053056', '黄敬宗', '-2ug2ecgu1qrcr8tc476av0sg0oab6cnm', null, null, '28');
INSERT INTO `student` VALUES ('184053057', '官政瑜', '4hpfdv5qkj0pqmh70u4vlsdrbu90rbi8', null, null, '28');
INSERT INTO `student` VALUES ('184053059', '冯艳娇', '2hqd9salo7p7eu0c9ha5bp5vas67s1me', null, null, '28');
INSERT INTO `student` VALUES ('184053061', '常建磁', '1it4rcnk5jc7b6d1fqusoth0fru547ob', null, null, '28');
INSERT INTO `student` VALUES ('184053062', '黎广连', 'e7qe74fsom7nefvoa779hvc8kjdcae1e', null, null, '28');
INSERT INTO `student` VALUES ('184053065', '卢合兰', '-4o46edcknl3mpnjmd3r9kbhmks93nfc0', null, null, '28');
INSERT INTO `student` VALUES ('184053067', '刘椿乾', 'qehu0fkpgkh8aqee2m4i7jv6ikv0jji', null, null, '28');
INSERT INTO `student` VALUES ('184053071', '江远庆', '-8abtjpekr18i1ulpgurdt5kfrd918nro', null, null, '28');
INSERT INTO `student` VALUES ('184053073', '罗婷婷', '-ese0f0sa9drin1v8rrnfgl4gshonl41j', null, null, '28');
INSERT INTO `student` VALUES ('184053075', '卢钰雪', '-dje2a59njk8ei564t70n5at3evsdg48h', null, null, '28');
INSERT INTO `student` VALUES ('184053076', '张莹彩', '6ipq46glac5o2uf0j56g931d3jvkar0b', null, null, '28');
INSERT INTO `student` VALUES ('184053079', '黎里渟', '-566rgb3pni80958j9l83s9brfcgj8uua', null, null, '28');
INSERT INTO `student` VALUES ('184053081', '覃春华', '1fl8s16mds77cehah4lbhuat5dgnv27s', null, null, '28');
INSERT INTO `student` VALUES ('184053083', '罗灿梅', '4v475jjdllnd62stkn0dk0qbtm9oe5de', null, null, '28');
INSERT INTO `student` VALUES ('184053084', '邓碧莹', '-7a9dj7dhumrr956pnk8bmf4svr6alnpi', null, null, '28');
INSERT INTO `student` VALUES ('184053085', '覃金薇', 'chjiqfulc7k32pf93jphm4sm8oo4jgb0', null, null, '28');
INSERT INTO `student` VALUES ('184053086', '曾子玲', 'fc19upko8eun309lb1lm73s1tisnnulm', null, null, '28');
INSERT INTO `student` VALUES ('184053087', '陈钰杏', '-becf7rt36cip5v33anckgqnm5s104pe', null, null, '28');
INSERT INTO `student` VALUES ('184053089', '欧妮', '-9n8fulhio3l0ee05nhch2jpadkmqsebq', null, null, '28');
INSERT INTO `student` VALUES ('184053093', '姚荣杰', '84d2dh41h8kr2j4fc94tk62jm8vu2fse', null, null, '28');
INSERT INTO `student` VALUES ('184053094', '韦秀旺', '-9ake65d6kmr069636m6sf4mapmikf4ff', null, null, '28');
INSERT INTO `student` VALUES ('184053095', '黄济东', '-e7j2s0tqgc4tv5a026760q03gvsnburf', null, null, '28');
INSERT INTO `student` VALUES ('184053096', '徐康超', '-f88gbsomn5l0ggufveqeihel9h35554e', null, null, '28');
INSERT INTO `student` VALUES ('184053097', '郑景山', '-epqt71pegvs0bdu1truselsgjfvrph51', null, null, '28');
INSERT INTO `student` VALUES ('184053098', '廖博文', 'dbqg6vavptmvh33r0q1g78sco2dsloib', null, null, '28');
INSERT INTO `student` VALUES ('184053099', '黄和梧', '-bp7tos9j3ta03e1kcdll36qg1fnpukiv', null, null, '28');
INSERT INTO `student` VALUES ('184053100', '盘绍威', '-phntgrpgp2psce0sph6pc281k6k9ltn', null, null, '28');
INSERT INTO `student` VALUES ('184053101', '卢贵山', '3m38piu4uo0hqckis349mvdgouv1mh5m', null, null, '28');
INSERT INTO `student` VALUES ('184053102', '宋喜贵', '-dqs4tup7db3lfbjo68cucqgb24m1qo1t', null, null, '28');
INSERT INTO `student` VALUES ('184053103', '罗仕燚', '9emlt92qe9m2ep4itkdo9bpb57sjspoc', null, null, '28');
INSERT INTO `student` VALUES ('184053105', '黄邦钻', 'ekuicup9g6nu5f014aj99lr1k4j2vl43', null, null, '28');
INSERT INTO `student` VALUES ('184053106', '黄永豪', '6gnopfu9r8f13gagg11udifnh6eg9s9d', null, null, '28');
INSERT INTO `student` VALUES ('184053107', '唐爱英', '3asv7t3rr17k06fvs04p7irgnvmop3t', null, null, '28');
INSERT INTO `student` VALUES ('184053108', '杨小芬', '-d5i9hojm8beqcsmnepug2e5mmu2ahprr', null, null, '28');
INSERT INTO `student` VALUES ('184053109', '陈长周', '-19pldif1tg2d16c4aoflr2qa05rhiggk', null, null, '28');
INSERT INTO `student` VALUES ('184051004', '韦冬梅', '-f0n0t9qlai5bujriujt2rbnrbosdt0od', null, null, '29');
INSERT INTO `student` VALUES ('184051005', '黄柳莲', '-9bv016j9pi7u3k97o4460lkktd8g247q', null, null, '29');
INSERT INTO `student` VALUES ('184051006', '覃洁圆', '-di3manv75be5s6m6ohgp0q096lduijt9', null, null, '29');
INSERT INTO `student` VALUES ('184051007', '于婷', '-d0quc3kcjk8bicv4m8f4gckpj3ubda61', null, null, '29');
INSERT INTO `student` VALUES ('184051008', '罗海龙', '-a2of95k99ttgp60fo2p0nnl8fl8n68l4', null, null, '29');
INSERT INTO `student` VALUES ('184051009', '刘冰', '-eo1k64188anlcpiv7dnu2cb76v8ffp83', null, null, '29');
INSERT INTO `student` VALUES ('184051011', '陈锡呈', '-ftrki8shl05f43sne5jginp1qerfgmfr', null, null, '29');
INSERT INTO `student` VALUES ('184051012', '黄振刚', 'ch39i66cms8mfrfp58o2rtn5e7sq75ki', null, null, '29');
INSERT INTO `student` VALUES ('184051017', '梁江兰', '-95djmra0qv6ngi3vidbeitqa5bd54lqu', null, null, '29');
INSERT INTO `student` VALUES ('184051020', '黄艳兰', '-2j42me1ot52jubm0lap484lea4pjgv9g', null, null, '29');
INSERT INTO `student` VALUES ('184051021', '傅鸿潇', '-7b09ip07c4g7hlbn53khie14f360vt0k', null, null, '29');
INSERT INTO `student` VALUES ('184051022', '吴凤梅', '-a0u1a0ei5kil5tra2cjobitkhdlr4qea', null, null, '29');
INSERT INTO `student` VALUES ('184053005', '张梦玲', '-f43khgd4it0q337lffo1uhum8eg8nggb', null, null, '29');
INSERT INTO `student` VALUES ('184053006', '黄龙秀', '-391oklbboe5i294pki9mn1d4fanoggpr', null, null, '29');
INSERT INTO `student` VALUES ('184053010', '林丽英', 'dg4fq2lnsl2cn426delnj5ghl3tfkl1o', null, null, '29');
INSERT INTO `student` VALUES ('184053011', '梁丽萍', '-b52uh4sfd9in0cukvpf6f3tgsafstkap', null, null, '29');
INSERT INTO `student` VALUES ('184053012', '杨爱丽', 'e090dvueifthj3d04b007f1kudej5583', null, null, '29');
INSERT INTO `student` VALUES ('184053014', '吴艳', '-1oh7g2ssdt1i5ok1m9cp9e6s7t1tpkdi', null, null, '29');
INSERT INTO `student` VALUES ('184053030', '冯锦秀', '-bu7mv966h052be9hsj48u8d41vemamcq', null, null, '29');
INSERT INTO `student` VALUES ('184053042', '谢东妹', '14jvstg8fdqq60qn5pjijrlmeucqohac', null, null, '29');
INSERT INTO `student` VALUES ('184053045', '庞燕秋', '-eps4ae8adjb2saq8k7fokkmde4vjmh2d', null, null, '29');
INSERT INTO `student` VALUES ('184053046', '陆静怡', '-a6hp3g9218081k0j3v4u906p7mort96', null, null, '29');
INSERT INTO `student` VALUES ('184053058', '范漫', '4tifa6ltnp797jm1os7ddg5i82iqmpog', null, null, '29');
INSERT INTO `student` VALUES ('184053063', '罗小雁', '-61cd8e37utqc2hnmn5s6b5b72gh29e9t', null, null, '29');
INSERT INTO `student` VALUES ('184053064', '杨锡昭', '-9vequ20tfn0vmehntcl7v6qn88v9g2rc', null, null, '29');
INSERT INTO `student` VALUES ('184053068', '张燕霞', '-a73dqoj64o5ia3gi7dgv3vjpacgta94g', null, null, '29');
INSERT INTO `student` VALUES ('184053069', '黄献丽', '-65toi03k62ulfahlor3isr2843kpbm2j', null, null, '29');
INSERT INTO `student` VALUES ('184053072', '覃如燕', '2cao44tdbe5fhs3grge8s3t516jq98jh', null, null, '29');
INSERT INTO `student` VALUES ('184053074', '包洁', '-bhmu003so9i8mcecc8s701jp7srhh8fl', null, null, '29');
INSERT INTO `student` VALUES ('184053078', '廖燕雪', 'abo5n0vq4j4g3v6polct6khnha285svb', null, null, '29');
INSERT INTO `student` VALUES ('184053080', '蒋捷玲', '-19mr0b2h8infcsl3ffhd8m9bmqvark4j', null, null, '29');
INSERT INTO `student` VALUES ('184053082', '严小艳', 'drv78usi1cla0kmpkcjnllidr1pje8rr', null, null, '29');
INSERT INTO `student` VALUES ('184053088', '黄丽媚', 'ef9d7t5ikgookb883ce241is5ki3jkg5', null, null, '29');
INSERT INTO `student` VALUES ('184053090', '李先梅', '-3jsatjmkupbfgbt4ejv3hattbm8f48q6', null, null, '29');
INSERT INTO `student` VALUES ('184053091', '梁予璇', '60gi6f82ai4qqq02u52j28fb69bf30ar', null, null, '29');
INSERT INTO `student` VALUES ('184031050', '覃志伟', '-72am56lh56u1v6dehbu5funceh7cvd37', null, null, '30');
INSERT INTO `student` VALUES ('184031051', '范富强', 'eva1dth322uockrji7fh9dcrioii2e40', null, null, '30');
INSERT INTO `student` VALUES ('184031052', '潘文斌', '-bprbspuoesn2gqoo79l4n9ggf4na23g', null, null, '30');
INSERT INTO `student` VALUES ('184031053', '韦忠体', '-14h796cn8cvhe7pkdth878gkj9aggi3', null, null, '30');
INSERT INTO `student` VALUES ('184031054', '黄小波', '-bt7d2ruplnj9m4bktg0rklvtnupbbgrl', null, null, '30');
INSERT INTO `student` VALUES ('184031056', '何海波', '-4a46fipu0fkg1fdi8ilkfr85ts3hgds', null, null, '30');
INSERT INTO `student` VALUES ('184031057', '彭庭吉', '-99r7clbu6cunpjgund2b9ci1856apge7', null, null, '30');
INSERT INTO `student` VALUES ('184031058', '张龙', '8kst3hev9mr8ftb67u5kltm7b1s9kj1c', null, null, '30');
INSERT INTO `student` VALUES ('184031059', '盘俊海', '-1i0ovuugnio2e2ncj0a35gg697iva2ek', null, null, '30');
INSERT INTO `student` VALUES ('184031060', '卢辉煌', '1h5ecfar0ia0huamqjslf79mku1nj99c', null, null, '30');
INSERT INTO `student` VALUES ('184031061', '覃鹏', '2414ei9m6t30dmuo1ie1bft4iiskhpsi', null, null, '30');
INSERT INTO `student` VALUES ('184031062', '章泰乐', '-es71ai6sgsqotbee2p251q5um3s8m10v', null, null, '30');
INSERT INTO `student` VALUES ('184031063', '曹德民', '-1jaev3te8dnfcv4s4bqs2lbshpem2219', null, null, '30');
INSERT INTO `student` VALUES ('184031064', '吴肖杰', '7coru5b162k2dsrf4unb9050g3hhq8bs', null, null, '30');
INSERT INTO `student` VALUES ('184031065', '李佳新', '-a80udaf71hso13a7k77ns9r5ke3dh6g9', null, null, '30');
INSERT INTO `student` VALUES ('184031066', '何龙', '-bp46b7an4gsebpbgndtqv3mpddtos78c', null, null, '30');
INSERT INTO `student` VALUES ('184031067', '蒙世严', '7bjnhpij6hjteqrlv8fkvrj6oa60tkpd', null, null, '30');
INSERT INTO `student` VALUES ('184031068', '李世珑', 'fjhi55mbqqbq7sq07tldbjaci8h7sepd', null, null, '30');
INSERT INTO `student` VALUES ('184031069', '陈佳欢', 'a4sreicn9es6au6m14e255akq7s5cicq', null, null, '30');
INSERT INTO `student` VALUES ('184031070', '覃志缘', '-fs1u5vcvm5madv9ugachamgtrn2v1t94', null, null, '30');
INSERT INTO `student` VALUES ('184031071', '盘俊洋', '-7i7fkems48filbv0j6bbir7q40aglldq', null, null, '30');
INSERT INTO `student` VALUES ('184031072', '章泰安', 'dc6p5fp5vj8r7bh029o7oosr8h0a7b6d', null, null, '30');
INSERT INTO `student` VALUES ('184031073', '王慧宝', '-4pg5ct5p5opt14c2p22afrlm2iu6i1t0', null, null, '30');
INSERT INTO `student` VALUES ('184031074', '蓝韦铄', '-4c1n235bl6j5mhneed2mlsb21dnu8saq', null, null, '30');
INSERT INTO `student` VALUES ('184031075', '黄咏强', '-1430g4nc1qd1pb8j0tvjs9890m8acme4', null, null, '30');
INSERT INTO `student` VALUES ('184031076', '潘陶缘', '2ja20vlsa9n9n19i2a92970kqji7119a', null, null, '30');
INSERT INTO `student` VALUES ('184031077', '易玉华', '78okn3ni9vih09de1r7imep98fpb6ga3', null, null, '30');
INSERT INTO `student` VALUES ('184031078', '林美秀紫', 'dc20gtsdqt2pns6hkvn3mmqli7vu1gh9', null, null, '30');
INSERT INTO `student` VALUES ('184031079', '刘文龙', '-codmnkuc5j73n6kji5or7150cakpnc5s', null, null, '30');
INSERT INTO `student` VALUES ('184031080', '李学珍', '-1mgqdm7bdsspsdtntbnmt2blne9oblls', null, null, '30');
INSERT INTO `student` VALUES ('184031081', '陈忠良', '-439r8psur0kdcnip63q2bbekvjmirh60', null, null, '30');
INSERT INTO `student` VALUES ('184031082', '谢裕昊', 'ei59fe12gca9mupqdc1s8old2fs5pqhb', null, null, '30');
INSERT INTO `student` VALUES ('184031083', '梁淑婷', 'c589rjvp8v2791dgkqvjka616c1cud31', null, null, '30');
INSERT INTO `student` VALUES ('184031084', '曾庆宇', '-ci74cc4pd9j9vih6s5h5d4nrga3ppgon', null, null, '30');
INSERT INTO `student` VALUES ('184031085', '盘樊吉', 'ek6coo11lhqcna9fkpm5ao7p4lvejngs', null, null, '30');
INSERT INTO `student` VALUES ('184031086', '乔张县', '-bi40ig9ckq5p5jf3q37okv8r5pgp6plq', null, null, '30');
INSERT INTO `student` VALUES ('184031087', '蓝海洪', '7bg0hcj95blegfgbdfjq8ouh8itdkeha', null, null, '30');
INSERT INTO `student` VALUES ('184031088', '朱声发', '-efsnlgt8amgh05apu2d8s6l40hgh2cpk', null, null, '30');
INSERT INTO `student` VALUES ('184031089', '李昕怡', '7cmortd2lq39gvc1cseqjv5ttvtus01f', null, null, '30');
INSERT INTO `student` VALUES ('184031090', '谭力聪', '-6uak8v98sgis1cvlhbf11fo5lq3g2l73', null, null, '30');
INSERT INTO `student` VALUES ('184031091', '韦德华', 'dimoi6v2a5g9e7kgsirjhmcvt5nh7df6', null, null, '30');
INSERT INTO `student` VALUES ('184031092', '刘思竹', '44cjm9eabo75glj5r12tg0mqtkti3if0', null, null, '30');
INSERT INTO `student` VALUES ('184031093', '陶泫宇', '25nvtp48873pn02m87bsg08gccssmd2h', null, null, '30');
INSERT INTO `student` VALUES ('184121001', '廖文凤', '-74hkje67ipb6o50e59ritkccgjab78ei', null, null, '31');
INSERT INTO `student` VALUES ('184121002', '黎秋荣', '-e0mnq9291cokj6nmm8hq7f2m3lfokd2o', null, null, '31');
INSERT INTO `student` VALUES ('184121003', '陆荣深', 'c54gds9rgqat86d1aginj4bia2s2hb7p', null, null, '31');
INSERT INTO `student` VALUES ('184121004', '黄婷婷', 'bo3uf2bjndelvk31iothu86age72cek9', null, null, '31');
INSERT INTO `student` VALUES ('184121005', '谭昌勇', 'ocobsp14452qrnmqeetcrjjn3d2uae5', null, null, '31');
INSERT INTO `student` VALUES ('184121007', '黄俏媛', 'cqnd4pv57fp3a3rtkhob1ob91i9ttelt', null, null, '31');
INSERT INTO `student` VALUES ('184121008', '何昌金', '-duf913pj5aarjb22058oikbhbbe383fu', null, null, '31');
INSERT INTO `student` VALUES ('184121009', '石川秀', '3ri28f7ufiv6fj3aqs9aendft6pc206c', null, null, '31');
INSERT INTO `student` VALUES ('184121010', '吴佳妮', 'bjjqug4vstpjusap93bo5nqbq3acaaac', null, null, '31');
INSERT INTO `student` VALUES ('184121011', '黄志峰', '-b58djbm5loe60q9pl4iaqgik1d2akt7l', null, null, '31');
INSERT INTO `student` VALUES ('184121012', '杨慧颖', '5qkmmu4obocrc1f3mvi6qpunc1vd0fbt', null, null, '31');
INSERT INTO `student` VALUES ('184121013', '杨亮', '-brt21ga50pufvuafm4o2gkp9c73dqf0v', null, null, '31');
INSERT INTO `student` VALUES ('184121014', '肖思媛', 'abo5n0vq4j4g3v6polct6khnha285svb', null, null, '31');
INSERT INTO `student` VALUES ('184121015', '陈定水', 'a7kn5hl4bsb3t23ka3eavgucb0pfj9u0', null, null, '31');
INSERT INTO `student` VALUES ('184121016', '李孩创', 'aq91ae4mv2b9fjgkp19cf2s40d86rcjj', null, null, '31');
INSERT INTO `student` VALUES ('184121017', '李聪', '-91stkjrmiev5a1rn3p90th8uf70dr18m', null, null, '31');
INSERT INTO `student` VALUES ('184121018', '黄秀桃', '-ekbvn0on5rndkamefc0dtegh8bu36imf', null, null, '31');
INSERT INTO `student` VALUES ('184121019', '苏方均', '-14vq0lqcie3mpn7re8ivsqbciirr63ld', null, null, '31');
INSERT INTO `student` VALUES ('184121020', '黄梦瑶', '7prr54h07ejv2gj4kdua19m893ce5b6b', null, null, '31');
INSERT INTO `student` VALUES ('184121021', '李璐', 'ck98opduipqhiq0l11kp15tra355n36r', null, null, '31');
INSERT INTO `student` VALUES ('184121022', '罗鹏', '-1fti9mua5iksvf6qrhgqv7c9hcnn4d0e', null, null, '31');
INSERT INTO `student` VALUES ('184121023', '梁鑫', 'f23dvgqa6m8uunfmfl18ob5dfeo7f2ko', null, null, '31');
INSERT INTO `student` VALUES ('184121025', '肖新宏', '-3ehn43ggto74vng53rs41sii0b54ltjv', null, null, '31');
INSERT INTO `student` VALUES ('184121026', '陈以岸', '-9epd703dtpram2ik5m4v1kul6b5jls38', null, null, '31');
INSERT INTO `student` VALUES ('184121027', '颇磊', '4jfjpip2hemad7gtkbeiobqga35oeafv', null, null, '31');
INSERT INTO `student` VALUES ('184121028', '李丹娜', '-fkg54fnlhd0ksc3bmo5q2bjcp2ba0jij', null, null, '31');
INSERT INTO `student` VALUES ('184121029', '潘声驰', '-22omfndh2m4hlnsm9p48r8k5306csibf', null, null, '31');
INSERT INTO `student` VALUES ('184121032', '黄旭升', 'crk51vu05687i5aaspgbbd082h8or8de', null, null, '31');
INSERT INTO `student` VALUES ('184121033', '梁全辉', 'f6qnqs5eh98noiobsl6m4jfslmmg254r', null, null, '31');
INSERT INTO `student` VALUES ('184121034', '甘健聪', '86cfm9da2ilt1vufeqbcrlcmmk32rn7d', null, null, '31');
INSERT INTO `student` VALUES ('184121035', '周吴毓飞', '6ute7u9ccv32v9vumraejcr7m1the081', null, null, '31');
INSERT INTO `student` VALUES ('184121036', '韦炳旺', '348pibjomf6ifcu6g6uqdhqi7m5br4vg', null, null, '32');
INSERT INTO `student` VALUES ('184121037', '蒙思浩', '-p6s99244kfmktho1dtlgi20rn7oc88a', null, null, '32');
INSERT INTO `student` VALUES ('184121038', '宋健聪', '6p6ouqdo1151joujap4cqo03isr7b783', null, null, '32');
INSERT INTO `student` VALUES ('184121039', '吴裕福', '6oesltm5q7gskv0m6do502jppermup69', null, null, '32');
INSERT INTO `student` VALUES ('184121041', '戴玉婷', '-r9f6mkfq31bgcnagg0drsvnrt7rr7ua', null, null, '32');
INSERT INTO `student` VALUES ('184121042', '刘官通', 'flu19g8cpkdm2amdbtj4gaqa0fjibn3v', null, null, '32');
INSERT INTO `student` VALUES ('184121043', '陈荟柠', 'b7arlgiqktikpo0psein1an3927abc8t', null, null, '32');
INSERT INTO `student` VALUES ('184121045', '闭韦智', 'dl74n7bin04252v3r515m9ifv4eg8k3b', null, null, '32');
INSERT INTO `student` VALUES ('184121048', '叶新心', 'bh8kscumid049ish5m7hnpqri3q70nv4', null, null, '32');
INSERT INTO `student` VALUES ('184121050', '余青云', '-ak3aaljnvkblt2h9647fp11rh59sri1n', null, null, '32');
INSERT INTO `student` VALUES ('184121051', '曾柳丹', '579cla71kh31134p548oklp3g5ksirv2', null, null, '32');
INSERT INTO `student` VALUES ('184121052', '卢德雁', 'a5clv8tesqe21m6tc4ogbil74s2k066a', null, null, '32');
INSERT INTO `student` VALUES ('184121053', '韦乔羽', '1k3h4s7ujc3qim12a1qiu44hm595ppao', null, null, '32');
INSERT INTO `student` VALUES ('184121054', '苏磊', '-61khv5msba4o5stda6tg89cs5hjr4hh1', null, null, '32');
INSERT INTO `student` VALUES ('184121055', '吴何磊', '91qlr1e8qlilkqqr58kallm4vd9po9u1', null, null, '32');
INSERT INTO `student` VALUES ('184121056', '权资涵', '910v0m38c2u5aqs2igu6nsihqi35clq7', null, null, '32');
INSERT INTO `student` VALUES ('184121058', '邱思淇', 'f15kafkbkkjlnrg2oumvqjlg90v0pmdm', null, null, '32');
INSERT INTO `student` VALUES ('184121059', '唐楚崎', 'b6djhcd0jrir68gjlu5qnfkp9hggqhlv', null, null, '32');
INSERT INTO `student` VALUES ('184121060', '刘思林', '-d6ug9sts6jq119n1ri09b13ga5kdk202', null, null, '32');
INSERT INTO `student` VALUES ('184121061', '韦林东', '5j74g1dj8667om163nhr3ciufc8pi2rn', null, null, '32');
INSERT INTO `student` VALUES ('184121062', '兰龙', '-2djavk07i01ghuc2iogg3cn0rdif9aj9', null, null, '32');
INSERT INTO `student` VALUES ('184121063', '王征宇', '-5tjtqn9u40qpiepcvocme8p58gu25vot', null, null, '32');
INSERT INTO `student` VALUES ('184121064', '何宝杰', '-377pn4fjmv7jt0ajhh7n5bis5hg1l7jf', null, null, '32');
INSERT INTO `student` VALUES ('184121065', '雷新民', '3lq917qspevi9cgg1b13reroc0np56ci', null, null, '32');
INSERT INTO `student` VALUES ('184121066', '黄春丽', '9ihsfvsfs372k0ia69sklqjalvf0ql4h', null, null, '32');
INSERT INTO `student` VALUES ('184121067', '蓝金福', 'fcn8smvu1sn6lauah839450lvikco494', null, null, '32');
INSERT INTO `student` VALUES ('184121069', '蒙青青', '-c8bnj35ie03duiu1grmdhuuviukg20sf', null, null, '32');
INSERT INTO `student` VALUES ('184121070', '陈诗露', '-cb161he8kf7pue4eknl6l71phleekgb0', null, null, '32');
INSERT INTO `student` VALUES ('184121071', '石其嵩', '5i9uu8vd1omo60i7asjja3cveh2oekgl', null, null, '32');
INSERT INTO `student` VALUES ('184121072', '梁思雅', '-6todje7kbnacepqbr4ct1ggs3lgpui96', null, null, '32');
INSERT INTO `student` VALUES ('184121073', '石佳成', '-al9plbejj6nq12cmo4ue1db89hrh5bfi', null, null, '32');
INSERT INTO `student` VALUES ('184121074', '覃琬', '33fmmtfpe38oj57vhile8ms86sukhapi', null, null, '33');
INSERT INTO `student` VALUES ('184121075', '陈婷', '4u4c05vcgg11k2cncuduin13n876oik4', null, null, '33');
INSERT INTO `student` VALUES ('184121076', '覃文杰', 'cig4m42hgsihis9jvgvhmapefetpaenh', null, null, '33');
INSERT INTO `student` VALUES ('184121077', '唐国海', '-6726g9jebgujv6r1qat3ji9uahe62a9b', null, null, '33');
INSERT INTO `student` VALUES ('184121078', '罗晶晶', '-7risboj7j9mm2arcb97nl5kkiguuj5p4', null, null, '33');
INSERT INTO `student` VALUES ('184121079', '覃杰', '-3s1uks96ef9slgvsr6l5fihditofiqun', null, null, '33');
INSERT INTO `student` VALUES ('184121080', '梁海龙', '-fb101g71b70n776jslou6maovc3jvin2', null, null, '33');
INSERT INTO `student` VALUES ('184121081', '粟息云', '3n5lijefnvcngfnlgjtknps2bc4mq029', null, null, '33');
INSERT INTO `student` VALUES ('184121082', '曾祥海', '5lqm7dihumh23tbjtkmm6pmorc2mk0v1', null, null, '33');
INSERT INTO `student` VALUES ('184121083', '蓝以成', 'cn245l4j8jouvcuoum4sadgil0b4i1eb', null, null, '33');
INSERT INTO `student` VALUES ('184121084', '韦秋菊', 'e6dlo05l5mdc76u8smg7ib2j0r0af8o1', null, null, '33');
INSERT INTO `student` VALUES ('184121085', '覃宝丽', '3qemsivgl24t9anqkcldvgp73nv9rhat', null, null, '33');
INSERT INTO `student` VALUES ('184121086', '王双双', 'blprqk6udnevav1qpbtdqnmi2jh6gsgu', null, null, '33');
INSERT INTO `student` VALUES ('184121087', '赵昌飞', 'e4la28rba5spqr8rnko6g6vtl8dmit40', null, null, '33');
INSERT INTO `student` VALUES ('184121088', '吴林峰', '-2eqeqfbsqec137p3qhnqfo9surfgq5ed', null, null, '33');
INSERT INTO `student` VALUES ('184121089', '覃显鑫', '-f1r0c7j1em70f1kdp69qcfha31b94jkl', null, null, '33');
INSERT INTO `student` VALUES ('184121091', '杨媚', 'd2cqib7325e879qedm7c10r6fcb3d73q', null, null, '33');
INSERT INTO `student` VALUES ('184121092', '门夏秋', '5sre2gqviqqaalgu8cpklime02g05g0q', null, null, '33');
INSERT INTO `student` VALUES ('184121093', '杨心月', '-79bgne0pcv9j127mmhtc70fr4o1qjmev', null, null, '33');
INSERT INTO `student` VALUES ('184121094', '卢晶', '-1b657nii5e8dg0a9ep8reddatqtgu0bv', null, null, '33');
INSERT INTO `student` VALUES ('184121096', '何远通', '-58j26qdponrt30ulnbto15e2b20bobca', null, null, '33');
INSERT INTO `student` VALUES ('184121099', '邱荣辉', '-dli60sd9k0muleli8aqi22cagc2ifgb0', null, null, '33');
INSERT INTO `student` VALUES ('184121100', '陈亚洲', 'f1ocaaqj9sgd4a4a1aasq1c9dpkdtoti', null, null, '33');
INSERT INTO `student` VALUES ('184121101', '容晓东', '-1a87r084dqaajclpvp48obdobldqfeq', null, null, '33');
INSERT INTO `student` VALUES ('184121102', '秦滔', 'dk3v9jqgksh5db2rrd8t2fo8seqbj0bk', null, null, '33');
INSERT INTO `student` VALUES ('184121103', '朱定康', 'daecubv9aovf88ugn9mn98ufjkc953hv', null, null, '33');
INSERT INTO `student` VALUES ('184121104', '杨彬', '3e8qfsdl5fu1hqi7kt2de0p6ljrim62', null, null, '33');
INSERT INTO `student` VALUES ('184121105', '许加宽', '-5351ddfc5b5kf3m2dmd1p6hdg5qf7pk5', null, null, '33');
INSERT INTO `student` VALUES ('184121107', '覃自祥', 'fgtkdlnf5kgh95gcmbou3ar6p7khsbc3', null, null, '33');
INSERT INTO `student` VALUES ('184121108', '刘文斌', 'amimlt6vt04g4u477rsddgq6fi9rfnbg', null, null, '33');
INSERT INTO `student` VALUES ('184121109', '李贤旭', '-bl36cciv5ckissbd7cpujf8b9cfhcjb1', null, null, '33');
INSERT INTO `student` VALUES ('184121112', '胡于志琦', '-4s7qja0g2shgvig0kvfh3fl6afn4t980', null, null, '33');
INSERT INTO `student` VALUES ('184121113', '江志海', 'daaecnmmsuehjicfkpehvksqplura91n', null, null, '34');
INSERT INTO `student` VALUES ('184121114', '覃荣州', 'fl3oh7gdpbne21emc2uo0rrv94fa8lrp', null, null, '34');
INSERT INTO `student` VALUES ('184121115', '黄嘉诚', '-b8gv84263ko5jqqg9cdjfpha5nk75m8r', null, null, '34');
INSERT INTO `student` VALUES ('184121116', '邓棋', '70ntq9n4ej4vdqfcf6r221e92uvivrsv', null, null, '34');
INSERT INTO `student` VALUES ('184121119', '龙建名', '-2176danlmq2u1k24nftp1ha85f3sn9j6', null, null, '34');
INSERT INTO `student` VALUES ('184121120', '李季儒', '-63eiqfm9ga0qb87do19cv4lepnhqt60a', null, null, '34');
INSERT INTO `student` VALUES ('184121121', '韦霄艳', '7hgrqtsf6a28k5ti56scnismhs2h9k59', null, null, '34');
INSERT INTO `student` VALUES ('184121123', '佘飞龙', '-88eq5dmv6rjfiltgjgm71ahg8hm3p70k', null, null, '34');
INSERT INTO `student` VALUES ('184121124', '黄正名', '-323qck0mtae3rvregfk534sjf8q7k0e', null, null, '34');
INSERT INTO `student` VALUES ('184121125', '张晓敏', 'hrji8rferhboa58n2kbjav5p3a96qhb', null, null, '34');
INSERT INTO `student` VALUES ('184121126', '张佳静', 'akj59c1a3nt6v565frcse4j5nsboter6', null, null, '34');
INSERT INTO `student` VALUES ('184121127', '龙明俊', '-5ede2a1bfv9cv99448i0makgfapgjcsp', null, null, '34');
INSERT INTO `student` VALUES ('184121128', '王标', '-1jv65inm8kolkbjbtaj5cojmh69vhkub', null, null, '34');
INSERT INTO `student` VALUES ('184121130', '罗金生', 'f6c0otrl5kh8bra5muqbdltvk9jjlq90', null, null, '34');
INSERT INTO `student` VALUES ('184121131', '黎耀程', '6dpv9tjf8227ps00g90g61fmct9i4lbp', null, null, '34');
INSERT INTO `student` VALUES ('184121132', '赖舟情', '-eaujif4vs9gfahef8et33edkurgjjkd0', null, null, '34');
INSERT INTO `student` VALUES ('184121133', '廖玉凤', '-94qvfge6rmbjhml9q415nadlcb64f8', null, null, '34');
INSERT INTO `student` VALUES ('184121134', '吴建泽', '-8m9597do5fe4k9iauifj9d8jeirfg0hq', null, null, '34');
INSERT INTO `student` VALUES ('184121135', '张文浩', 'epe9mnvvva7obsdm0qdq2lm31jde4mjh', null, null, '34');
INSERT INTO `student` VALUES ('184121136', '韦传健', 'fmkbatrv48veuetj8qhjlqkoq1ed3nmk', null, null, '34');
INSERT INTO `student` VALUES ('184121137', '覃飞', '-36pccqudfb9cb6ifimda5fbqg0mbvp2g', null, null, '34');
INSERT INTO `student` VALUES ('184121138', '吴慧琳', 'e3v33vi71kevrhrts3rburnjatf21p8b', null, null, '34');
INSERT INTO `student` VALUES ('184121139', '肖其璋', '-2nee8qgk630rsas527gq4pnabmr13cf4', null, null, '34');
INSERT INTO `student` VALUES ('184121140', '贾老温', 'eca4aqlpmijshgl88b62pd74gc6qq2fu', null, null, '34');
INSERT INTO `student` VALUES ('184121141', '覃建国', '61lqtsrgf63ig3mu38fdbajjoujb2ple', null, null, '34');
INSERT INTO `student` VALUES ('184121142', '梁心易', '-9pjsj6nacb0mqc7ptlooke56uvb4oaa5', null, null, '34');
INSERT INTO `student` VALUES ('184121143', '韦仁童', '82kkb303desggvunb5323n54395tukc', null, null, '34');
INSERT INTO `student` VALUES ('184121144', '吴迪龙', '-dlvagmqlql57mcb70foo78689fcrvkh9', null, null, '34');
INSERT INTO `student` VALUES ('184121146', '莫龙', '-7fdjpeug38ff75eh74i74iejagqq1rbo', null, null, '34');
INSERT INTO `student` VALUES ('184121148', '李海燕', '-anbrnghs110s9hhhccfdd0goe2nekro9', null, null, '34');
INSERT INTO `student` VALUES ('184121149', '秦学访', '-3p43henbrrh2olcb4sjs90gr61abpf62', null, null, '34');
INSERT INTO `student` VALUES ('184121150', '罗柳凤', '4tlv8nq78eeopr8s3kiqqrgl5t4n78ja', null, null, '34');
INSERT INTO `student` VALUES ('184121151', '覃甜甜', '-c0krai58tmuqivin9m6ou2abma4o91v7', null, null, '34');
INSERT INTO `student` VALUES ('184121152', '周惠方', '1k2lobttvqg9f4km9q4o8bmm61gkvepp', null, null, '34');
INSERT INTO `student` VALUES ('184121153', '蒙华冠', '-8jhnfch5f69ua03i5o8fvnk7ms6i76tk', null, null, '34');
INSERT INTO `student` VALUES ('184121154', '覃莉琳', 'f2u68jemgp12ekftf659s9iqk4uae73e', null, null, '34');
INSERT INTO `student` VALUES ('184121155', '吴留芳', '2kbnec600npao41ngq19e3rg75p6tebh', null, null, '35');
INSERT INTO `student` VALUES ('184121156', '覃诗雨', '-40m5bl7krddoic6kfvi8p11r6bq2f8fn', null, null, '35');
INSERT INTO `student` VALUES ('184121158', '蒋慧', '-2oijgnvjvdb2ng4pd2doku9v40p53sf3', null, null, '35');
INSERT INTO `student` VALUES ('184121159', '杨宗英', '3gsgla19f05752mn197t8glf6sa16d75', null, null, '35');
INSERT INTO `student` VALUES ('184121160', '莫艳兰', '-e97skov1iftafqkl11fbkjivhv228nfe', null, null, '35');
INSERT INTO `student` VALUES ('184121161', '韦献把', 'db53avotk1nr9j0j4908rrdseht3k053', null, null, '35');
INSERT INTO `student` VALUES ('184121162', '韦秋菊', '-7s7liksg5sjgi6h1o157teh5dpin2tsk', null, null, '35');
INSERT INTO `student` VALUES ('184121163', '贾秀青', '99beenbpfdokm4scorktf1u51hj3rqg', null, null, '35');
INSERT INTO `student` VALUES ('184121165', '荣婷', '-defe914fhk54i2g7qot77lkejpbqcdrt', null, null, '35');
INSERT INTO `student` VALUES ('184121167', '韦诗', '-fnct1lahv8fmmiv7sd13bthhci28v6c1', null, null, '35');
INSERT INTO `student` VALUES ('184121168', '韦柳媛', '696ok5basf1cac28411abmt0dph1qf7', null, null, '35');
INSERT INTO `student` VALUES ('184121169', '莫春燕', '-3ikholpcpnrjltbben39t70cpnbj8oq4', null, null, '35');
INSERT INTO `student` VALUES ('184121170', '覃川', 'aa6bt6g94g4io20dgk2asclqnt1n98gi', null, null, '35');
INSERT INTO `student` VALUES ('184121172', '霍丹妹', '64dh9egsv0ll0rte6m2469u6jqah7mr8', null, null, '35');
INSERT INTO `student` VALUES ('184121173', '卢婷婷', '-19e98r4gcc0h31ee9anjau4tpfd0kt25', null, null, '35');
INSERT INTO `student` VALUES ('184121176', '覃湘柳', '-9nh20scsai03hese9g1fdhuf2hac7nkn', null, null, '35');
INSERT INTO `student` VALUES ('184121182', '陈国鑫', '-827dkncl2pjra57b5milhefdt8d77kh', null, null, '35');
INSERT INTO `student` VALUES ('184121184', '潘庆国', '-arpce7qmu46tahgadr455kp7ku3ln6t6', null, null, '35');
INSERT INTO `student` VALUES ('184121185', '张易', '-6tndmc5idjnnobskesjblh915jpee5k6', null, null, '35');
INSERT INTO `student` VALUES ('184121186', '农佳强', '-6cim2u3mtrnnlqjb2fe0vi37quqnfh6d', null, null, '35');
INSERT INTO `student` VALUES ('184121187', '余信江', '-e5fp8vi2cl16mnjhqfgq65phc032ofca', null, null, '35');
INSERT INTO `student` VALUES ('184121188', '陈涛杰', '-b24u3vrqi16kq5m3f6181lpqchhn0c8g', null, null, '35');
INSERT INTO `student` VALUES ('184121191', '谢发宇', '-c2u1stavr2gnf1n30a24emsii8357ear', null, null, '35');
INSERT INTO `student` VALUES ('184121192', '罗惠玲', '4easlnjrfr64vdqv1skg3jk57k69v56', null, null, '35');
INSERT INTO `student` VALUES ('184121193', '苏正鑫', '7fm6lmcar6qni8epd03sa6gks66ufcso', null, null, '35');
INSERT INTO `student` VALUES ('184121194', '王庆龙', '-aehfgopaf1iqtnp67fdi04om6d8esu1p', null, null, '35');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherNumber` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师工号',
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'QQ号码',
  `professionalId` int(11) DEFAULT NULL COMMENT '专业群ID外键',
  PRIMARY KEY (`teacherNumber`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2006010006', '韦锦钰', '-v63mn5mqh5k0vv6m609edu6farkkd0u', '13768863889', null, '3');
INSERT INTO `teacher` VALUES ('2006010017', '秦燊', '-8cf387aj2tj88ig69psmjl8er5cahkc3', '13207722898', null, '3');
INSERT INTO `teacher` VALUES ('2006010028', '吴宇峰', '-7odcknsqn5kuc2tkmtmlbs1m8m6bvdil', '18276830228', null, '3');
INSERT INTO `teacher` VALUES ('2007010007', '封旭', '-9buql020ehuvk313v77dkgmqc3t0pkbc', '15347761083', null, '3');
INSERT INTO `teacher` VALUES ('2006010020', '尹东明', 'd22ij7q3ibb3i051aafca1rpb92opsp3', '18177225653', null, '3');
INSERT INTO `teacher` VALUES ('2006010018', '劳翠金', 'p3263pj5kti2p9hvkjcgv3kn32gvu3d', '13207729027', null, '3');
INSERT INTO `teacher` VALUES ('2006010022', '黄超', '52uib4f7buv7uo0nu6ta2t2igjme8rjf', '13557307979', null, '3');
INSERT INTO `teacher` VALUES ('2007010002', '韦浩波', '-cdjjdguhoqk588lkbdomgnj1kjfmt05', '13633080898', null, '3');
INSERT INTO `teacher` VALUES ('2007010004', '宋伟奇', '-b4c6p8kja4a2b9u5ndo9s7m4658hgp4b', '15877258958', null, '3');
INSERT INTO `teacher` VALUES ('2007000008', '程英鑫', '4ioaq9c2dih0tk4sbp843h1etpbjns5c', '13377237895', null, '3');
INSERT INTO `teacher` VALUES ('2018010244', '李芬', 'tr27m08pnmttp4phett884pnnm2vnro', '15277283565', null, '3');
INSERT INTO `teacher` VALUES ('2006010005', '杨惠 ', '-2cbqm8v1db44r46egupirlcsckiv8c1r', '18707727229', null, '3');
INSERT INTO `teacher` VALUES ('2019010016', '杨冰', '5ench31q5sguvtkpfm7l3baf7pl66u8i', '18307720909', null, '3');
INSERT INTO `teacher` VALUES ('2007010006', '陈书光', '-d6cnb6f7d5be24r5dia7qp2dd5ikmder', '13597066343', null, '1');
INSERT INTO `teacher` VALUES ('2006010014', '赵杰', '-fs2lq3c97m12egndf5m34j29fcmidnfb', '18577212669', null, '1');
INSERT INTO `teacher` VALUES ('2006010015', '禤鲜', '8jl9es4e7h3ln1mpvch1s74r84v3c5f6', '18877213373', null, '1');
INSERT INTO `teacher` VALUES ('2006010016', '温晓宇', '7ccc574p34i9osdb243430n2lvcu4m4r', '13481229180', null, '1');
INSERT INTO `teacher` VALUES ('2007010009', '朱群梅', '-5p42o0it7rjf38jpp8v8tmks6th08cab', '18977285694', null, '1');
INSERT INTO `teacher` VALUES ('2009010108', '练佳熠', '-78ntbvcvsrqkoev49gjafrfcmfprljkl', '17376108213', '', '1');
INSERT INTO `teacher` VALUES ('2006020058', '姜思佳', 'a4gfmtpq4ddklrn05n1dc1dgbsotmsh2', '13633048806', null, '1');
INSERT INTO `teacher` VALUES ('2006010027', '徐立宇', '-42k0n4cdnn82ucltjinjproml09mbtl7', '15907724822', null, '1');
INSERT INTO `teacher` VALUES ('2009000062', '王丽娟', '5h04psreeheifkju12a27dsccchqfgdh', '13597222266', null, '1');
INSERT INTO `teacher` VALUES ('2018010121', '陈旖倩', 'foe84uijn9jmku2ca02cko45qc4kovdp', '15295873036', null, '2');
INSERT INTO `teacher` VALUES ('2006010004', '张良平', '-95a0cei4qsj1paq8f3jr6lhjka34kr9r', '13877229416', null, '2');
INSERT INTO `teacher` VALUES ('2008010001', '吴永慧', 'd8t9hm0u647ev4ej8scsth98fl15a5h5', '13078066031', null, '2');
INSERT INTO `teacher` VALUES ('2016010005', '蒋玲萍', 'cad5dqfsp4k8ufnrgo051b455np1oq5e', '18177267784', null, '2');
INSERT INTO `teacher` VALUES ('2006020059', '韦继谭', 'd12er7aoaj1vrtn26p0jj4be94qvvpvu', '13597067560', null, '2');
INSERT INTO `teacher` VALUES ('2006010007', '韦燕红', 'e0s6rjvi31c0fbbhtubteeujm8sgju91', '13377205815', null, '2');
INSERT INTO `teacher` VALUES ('2006010047', '周小单', '56bnh2hp77sguvvlqhe2qnliossi7tvn', '15877286281', null, '2');
INSERT INTO `teacher` VALUES ('2018010234', '吴健', '9mi8c79udj86kccftgbtrp0kgpo5na53', '18007720301', null, '2');
INSERT INTO `teacher` VALUES ('2009010034', '万青', '-75egdtpj4vrvviolqiq3jvfdbf082tac', '13633084251', null, '1');
INSERT INTO `teacher` VALUES ('2009010095', '梁慧敏', '-cj5gtiqj4ha6kcb8irodapthgf0v1ure', '15077211057', null, '2');
INSERT INTO `teacher` VALUES ('2006010147', '刘丹', '-arpoi4dfuf7o77uaa9v1dh7trdonskie', '13132626000', null, '1');
INSERT INTO `teacher` VALUES ('2006010149', '莫平', '-5kg5gvhc386iehueu2febp9oetkcu0bv', '13481233653', null, '2');
INSERT INTO `teacher` VALUES ('2006020034', '吴玉', 'd1m54ovohd8k47l3ve4c9sfsm4khe39v', '15077221480', null, '2');
INSERT INTO `teacher` VALUES ('2007010048', '程娴', '-58ml27es0ksouul2pbgc2je2v8j9eudc', '18376282951', null, '2');
INSERT INTO `teacher` VALUES ('2006010019', '甘承凯', '-a3bj14vvlc3np7f0fnnija3h04o5s25s', '15678079028', null, '2');
INSERT INTO `teacher` VALUES ('2009020020', '马巍', '-21s0mbr5h2b54qcim8l94hjtthrjbvoo', '13978003835', null, '1');

-- ----------------------------
-- Table structure for `teacher_professional_grade`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_professional_grade`;
CREATE TABLE `teacher_professional_grade` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `teacherNumber` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师学号',
  `professionalGradeId` int(11) DEFAULT NULL COMMENT '年级专业群开放权限关系表对应的ID',
  `studentQuantity` int(10) DEFAULT NULL COMMENT '实习学生最大选择数量',
  `creatTime` datetime(6) DEFAULT NULL COMMENT '创建该条记录的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of teacher_professional_grade
-- ----------------------------
INSERT INTO `teacher_professional_grade` VALUES ('1', '2009010108', '1', '20', '2020-06-06 13:31:49.000000');
INSERT INTO `teacher_professional_grade` VALUES ('5', '2007010009', '1', '10', '2020-06-06 13:24:39.722000');
INSERT INTO `teacher_professional_grade` VALUES ('4', '2008010001', '2', '10', '2020-06-06 13:31:53.000000');
INSERT INTO `teacher_professional_grade` VALUES ('7', '2006010014', '1', '23', '2020-06-11 11:33:02.225000');

-- ----------------------------
-- Table structure for `teacher_student`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_student`;
CREATE TABLE `teacher_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `studentNumber` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学号',
  `tpgId` int(10) DEFAULT NULL COMMENT '专业群年级开放权限的教师关系表的ID',
  `creatTime` datetime(6) DEFAULT NULL COMMENT '创建该条记录的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of teacher_student
-- ----------------------------
INSERT INTO `teacher_student` VALUES ('39', '184023095', '5', '2020-06-08 16:12:39.791000');
INSERT INTO `teacher_student` VALUES ('63', '184031029', '4', '2020-06-13 16:13:42.808000');
INSERT INTO `teacher_student` VALUES ('62', '184023041', '1', '2020-06-13 15:07:19.462000');
INSERT INTO `teacher_student` VALUES ('17', '174023079', '5', '2020-06-08 11:25:33.087000');
INSERT INTO `teacher_student` VALUES ('18', '184023002', '5', '2020-06-08 11:27:47.384000');
INSERT INTO `teacher_student` VALUES ('19', '184023006', '5', '2020-06-08 11:31:48.993000');
INSERT INTO `teacher_student` VALUES ('61', '184021006', '1', '2020-06-13 15:07:19.457000');
INSERT INTO `teacher_student` VALUES ('21', '184023014', '5', '2020-06-08 11:47:27.525000');
INSERT INTO `teacher_student` VALUES ('60', '184023055', '1', '2020-06-13 15:07:19.452000');
INSERT INTO `teacher_student` VALUES ('59', '184023103', '1', '2020-06-13 15:07:19.442000');
INSERT INTO `teacher_student` VALUES ('24', '184023094', '5', '2020-06-08 11:52:39.994000');
INSERT INTO `teacher_student` VALUES ('58', '184023030', '1', '2020-06-13 15:07:19.437000');
INSERT INTO `teacher_student` VALUES ('26', '184023003', '5', '2020-06-08 11:53:50.119000');
INSERT INTO `teacher_student` VALUES ('57', '184103003', '1', '2020-06-13 15:07:19.429000');
INSERT INTO `teacher_student` VALUES ('28', '184023018', '1', '2020-06-08 11:54:05.337000');
INSERT INTO `teacher_student` VALUES ('29', '184023097', '1', '2020-06-08 11:54:30.697000');
INSERT INTO `teacher_student` VALUES ('30', '184023009', '5', '2020-06-08 11:54:38.681000');
INSERT INTO `teacher_student` VALUES ('31', '184023038', '1', '2020-06-08 11:55:30.369000');
INSERT INTO `teacher_student` VALUES ('32', '184023024', '1', '2020-06-08 11:55:36.650000');
INSERT INTO `teacher_student` VALUES ('33', '184023040', '1', '2020-06-08 11:56:44.978000');
INSERT INTO `teacher_student` VALUES ('34', '184023025', '1', '2020-06-08 11:57:23.228000');
INSERT INTO `teacher_student` VALUES ('35', '184023101', '5', '2020-06-08 11:58:06.853000');
INSERT INTO `teacher_student` VALUES ('36', '184023105', '1', '2020-06-08 11:58:12.384000');
INSERT INTO `teacher_student` VALUES ('45', '184023087', '7', '2020-06-11 14:57:12.890000');
INSERT INTO `teacher_student` VALUES ('44', '184023086', '7', '2020-06-11 14:57:12.859000');
INSERT INTO `teacher_student` VALUES ('46', '184023088', '7', '2020-06-11 14:57:49.310000');
INSERT INTO `teacher_student` VALUES ('47', '184023092', '7', '2020-06-11 14:57:49.336000');
INSERT INTO `teacher_student` VALUES ('48', '184023102', '7', '2020-06-11 14:57:49.354000');
INSERT INTO `teacher_student` VALUES ('49', '184023104', '7', '2020-06-11 14:57:49.375000');
INSERT INTO `teacher_student` VALUES ('50', '184021012', '1', '2020-06-13 15:03:54.876000');
INSERT INTO `teacher_student` VALUES ('51', '184023036', '1', '2020-06-13 15:03:54.889000');
INSERT INTO `teacher_student` VALUES ('52', '184021002', '1', '2020-06-13 15:03:54.895000');
INSERT INTO `teacher_student` VALUES ('53', '184023017', '1', '2020-06-13 15:03:54.901000');
INSERT INTO `teacher_student` VALUES ('54', '184021021', '1', '2020-06-13 15:03:54.906000');
INSERT INTO `teacher_student` VALUES ('55', '184021020', '1', '2020-06-13 15:03:54.912000');
INSERT INTO `teacher_student` VALUES ('56', '184023008', '1', '2020-06-13 15:03:54.917000');
INSERT INTO `teacher_student` VALUES ('81', '184031013', '4', '2020-06-13 18:01:22.799000');
INSERT INTO `teacher_student` VALUES ('80', '184031002', '4', '2020-06-13 18:01:22.796000');
INSERT INTO `teacher_student` VALUES ('79', '184031042', '4', '2020-06-13 18:01:22.794000');
INSERT INTO `teacher_student` VALUES ('78', '184033010', '4', '2020-06-13 18:01:22.791000');
INSERT INTO `teacher_student` VALUES ('77', '184033045', '4', '2020-06-13 18:01:22.785000');
INSERT INTO `teacher_student` VALUES ('76', '184033012', '4', '2020-06-13 18:01:22.782000');
INSERT INTO `teacher_student` VALUES ('75', '184031007', '4', '2020-06-13 18:01:22.780000');
INSERT INTO `teacher_student` VALUES ('74', '174031118', '4', '2020-06-13 18:01:22.777000');
INSERT INTO `teacher_student` VALUES ('73', '184031056', '4', '2020-06-13 18:01:22.771000');
