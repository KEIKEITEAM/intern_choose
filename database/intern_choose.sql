/*
 Navicat Premium Data Transfer

 Source Server         : yuanzi_manhua
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : intern_choose

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 07/06/2020 18:37:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账户名',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (2, 'user', 'keikei', 'fh58q2ea6thauof5ikg98fe2ciafh50r');
INSERT INTO `admin` VALUES (1, '123', '123123', 'fh58q2ea6thauof5ikg98fe2ciafh50r');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名字',
  `majorId` int(11) NULL DEFAULT NULL COMMENT '专业ID外键',
  `gradeId` int(11) NULL DEFAULT NULL COMMENT '年级ID外键',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `年级外键`(`gradeId`) USING BTREE,
  INDEX `专业外键`(`majorId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '1班', 1, 1);
INSERT INTO `classes` VALUES (2, '2班', 2, 1);

-- ----------------------------
-- Table structure for grades
-- ----------------------------
DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grades
-- ----------------------------
INSERT INTO `grades` VALUES (1, '18级');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业名称',
  `professionalId` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业群ID',
  `open` bit(1) NULL DEFAULT NULL COMMENT '专业开放权限',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `专业群外键`(`professionalId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, '软件技术', '1', b'1');
INSERT INTO `major` VALUES (2, '动漫制作', '2', b'1');

-- ----------------------------
-- Table structure for professional
-- ----------------------------
DROP TABLE IF EXISTS `professional`;
CREATE TABLE `professional`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业群名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of professional
-- ----------------------------
INSERT INTO `professional` VALUES (1, '软件专业群');
INSERT INTO `professional` VALUES (2, '动漫专业群');
INSERT INTO `professional` VALUES (3, '网络专业群');

-- ----------------------------
-- Table structure for professional_grade
-- ----------------------------
DROP TABLE IF EXISTS `professional_grade`;
CREATE TABLE `professional_grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `professionalId` int(11) NULL DEFAULT NULL COMMENT '专业群ID外键',
  `gradeId` int(10) NULL DEFAULT NULL COMMENT '年级ID外键',
  `open` bit(1) NULL DEFAULT NULL COMMENT '是否开放选择权限',
  `startTime` datetime(6) NULL DEFAULT NULL COMMENT '开始选择的时间',
  `endTime` datetime(6) NULL DEFAULT NULL COMMENT '结束选择的时间',
  `creatTime` datetime(6) NULL DEFAULT NULL COMMENT '创建该条数据的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of professional_grade
-- ----------------------------
INSERT INTO `professional_grade` VALUES (1, 1, 1, b'1', '2020-05-30 16:32:27.000000', '2020-06-30 16:32:31.000000', '2020-06-05 13:31:37.000000');
INSERT INTO `professional_grade` VALUES (2, 2, 1, b'1', '2020-06-01 09:30:03.000000', '2020-06-24 09:30:09.000000', '2020-06-05 13:31:40.000000');
INSERT INTO `professional_grade` VALUES (16, 3, 1, b'0', '1992-07-06 00:00:00.000000', '2020-07-09 00:00:00.000000', '2020-06-06 13:15:14.908000');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `studentNumber` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生主键',
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `classId` int(11) NULL DEFAULT NULL COMMENT '年级ID外键',
  PRIMARY KEY (`studentNumber`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('16243057', '陈强', 'bnaenmm64o4sgd7neq7g4a3bf65tgaho', 1);
INSERT INTO `student` VALUES ('16283088', '韦清钟', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 1);
INSERT INTO `student` VALUES ('16253104', '吴立康', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 1);
INSERT INTO `student` VALUES ('174011005', '梁佳伟', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 1);
INSERT INTO `student` VALUES ('174011006', '韦耀威', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 1);
INSERT INTO `student` VALUES ('174011007', '潘会泰', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 2);
INSERT INTO `student` VALUES ('174011008', '梁泉', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 2);
INSERT INTO `student` VALUES ('174011016', '蓝秀健', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 2);
INSERT INTO `student` VALUES ('174011017', '覃象日', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 2);
INSERT INTO `student` VALUES ('174011020', '黄嘉翔', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 2);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacherNumber` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师工号',
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `professionalId` int(11) NULL DEFAULT NULL COMMENT '专业群ID外键',
  PRIMARY KEY (`teacherNumber`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2006000002', '杨萍', 'bnaenmm64o4sgd7neq7g4a3bf65tgaho', 1);
INSERT INTO `teacher` VALUES ('2006010005', '杨惠 ', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 2);
INSERT INTO `teacher` VALUES ('2006010006', '韦锦钰', 'fh58q2ea6thauof5ikg98fe2ciafh50r', 1);

-- ----------------------------
-- Table structure for teacher_professional_grade
-- ----------------------------
DROP TABLE IF EXISTS `teacher_professional_grade`;
CREATE TABLE `teacher_professional_grade`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `teacherNumber` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师学号',
  `professionalGradeId` int(11) NULL DEFAULT NULL COMMENT '年级专业群开放权限关系表对应的ID',
  `studentQuantity` int(10) NULL DEFAULT NULL COMMENT '实习学生最大选择数量',
  `creatTime` datetime(6) NULL DEFAULT NULL COMMENT '创建该条记录的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of teacher_professional_grade
-- ----------------------------
INSERT INTO `teacher_professional_grade` VALUES (1, '2006000002', 1, 10, '2020-06-06 13:31:49.000000');
INSERT INTO `teacher_professional_grade` VALUES (5, '2006010006', 1, 10, '2020-06-06 13:24:39.722000');
INSERT INTO `teacher_professional_grade` VALUES (4, '2006010005', 2, 10, '2020-06-06 13:31:53.000000');

-- ----------------------------
-- Table structure for teacher_student
-- ----------------------------
DROP TABLE IF EXISTS `teacher_student`;
CREATE TABLE `teacher_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `studentNumber` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `tpgId` int(10) NULL DEFAULT NULL COMMENT '专业群年级开放权限的教师关系表的ID',
  `creatTime` datetime(6) NULL DEFAULT NULL COMMENT '创建该条记录的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of teacher_student
-- ----------------------------
INSERT INTO `teacher_student` VALUES (13, '16243057', 1, '2020-06-12 13:26:22.000000');
INSERT INTO `teacher_student` VALUES (14, '174011005', 1, '2020-06-06 13:28:25.276000');
INSERT INTO `teacher_student` VALUES (15, '174011017', 4, '2020-06-07 17:15:35.637000');
INSERT INTO `teacher_student` VALUES (16, '16283088', 1, '2020-06-07 18:31:29.942000');

SET FOREIGN_KEY_CHECKS = 1;
