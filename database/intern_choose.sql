/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : intern_choose

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-06-07 14:59:38
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
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '1班', '1', '1');
INSERT INTO `classes` VALUES ('2', '2班', '2', '1');
INSERT INTO `classes` VALUES ('18', '3班', '1', '1');
INSERT INTO `classes` VALUES ('20', '1班', '2', '1');

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

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业名称',
  `professionalId` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业群ID',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `专业群外键` (`professionalId`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '软件技术', '1');
INSERT INTO `major` VALUES ('2', '动漫制转', '2');
INSERT INTO `major` VALUES ('3', '动漫制作', '3');

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
  `startTime` datetime DEFAULT NULL COMMENT '寮€濮嬮€夋嫨鐨勬椂闂?',
  `endTime` datetime DEFAULT NULL COMMENT '缁撴潫閫夋嫨鐨勬椂闂?',
  `creatTIme` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of professional_grade
-- ----------------------------
INSERT INTO `professional_grade` VALUES ('1', '1', '1', '', '2020-05-30 16:32:27', '2020-06-30 16:32:31', null);
INSERT INTO `professional_grade` VALUES ('2', '2', '1', '', '2020-06-01 09:30:03', '2020-06-24 09:30:09', null);

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentNumber` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生主键',
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名字',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `classId` int(11) DEFAULT NULL COMMENT '年级ID外键',
  PRIMARY KEY (`studentNumber`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('16243057', '陈强', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '1');
INSERT INTO `student` VALUES ('16283088', '韦清钟', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '1');
INSERT INTO `student` VALUES ('16253104', '吴立康', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '1');
INSERT INTO `student` VALUES ('174011005', '梁佳伟', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '1');
INSERT INTO `student` VALUES ('174011006', '韦耀威', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '1');
INSERT INTO `student` VALUES ('174011007', '潘会泰', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '2');
INSERT INTO `student` VALUES ('174011008', '梁泉', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '2');
INSERT INTO `student` VALUES ('174011016', '蓝秀健', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '2');
INSERT INTO `student` VALUES ('174011017', '覃象日', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '2');
INSERT INTO `student` VALUES ('174011020', '黄嘉翔', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '2');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherNumber` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师工号',
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `professionalId` int(11) DEFAULT NULL COMMENT '专业群ID外键',
  PRIMARY KEY (`teacherNumber`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2006000002', '陈萍', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '1');
INSERT INTO `teacher` VALUES ('2006010005', '杨惠 ', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '2');
INSERT INTO `teacher` VALUES ('2006010006', '韦锦钰', 'fh58q2ea6thauof5ikg98fe2ciafh50r', '1');

-- ----------------------------
-- Table structure for `teacher_professional_grade`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_professional_grade`;
CREATE TABLE `teacher_professional_grade` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `teacherNumber` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师学号',
  `professionalGradeId` int(11) DEFAULT NULL COMMENT '年级专业群开放权限关系表对应的ID',
  `studentQuantity` int(10) DEFAULT NULL COMMENT '实习学生最大选择数量',
  `creatTIme` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of teacher_professional_grade
-- ----------------------------
INSERT INTO `teacher_professional_grade` VALUES ('1', '2006000002', '1', '10', null);
INSERT INTO `teacher_professional_grade` VALUES ('2', '2006010006', '1', '10', null);
INSERT INTO `teacher_professional_grade` VALUES ('4', '2006010005', '2', '10', null);

-- ----------------------------
-- Table structure for `teacher_student`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_student`;
CREATE TABLE `teacher_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `studentNumber` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学号',
  `tpgId` int(10) DEFAULT NULL COMMENT '专业群年级开放权限的教师关系表的ID',
  `creatTIme` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of teacher_student
-- ----------------------------
INSERT INTO `teacher_student` VALUES ('13', '16243057', '1', null);
INSERT INTO `teacher_student` VALUES ('14', '16283088', '2', null);
INSERT INTO `teacher_student` VALUES ('15', '16253104', '2', null);
INSERT INTO `teacher_student` VALUES ('16', '174011017', '4', '2020-06-06 21:24:14');
INSERT INTO `teacher_student` VALUES ('17', '174011020', '4', '2020-06-06 21:25:48');
