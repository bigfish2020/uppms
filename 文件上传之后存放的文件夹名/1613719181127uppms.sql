/*
 Navicat Premium Data Transfer

 Source Server         : SSM
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : uppms

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 19/02/2021 14:13:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `Cid` int(11) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名字',
  `Caddress` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司地点',
  `Cturnover` int(100) NOT NULL COMMENT '营业额',
  PRIMARY KEY (`Cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for intern
-- ----------------------------
DROP TABLE IF EXISTS `intern`;
CREATE TABLE `intern`  (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `Position` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位',
  `workContent` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作内容描述',
  `assessmentLevel` int(4) NOT NULL COMMENT '工作考核级别',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sId` int(11) NOT NULL AUTO_INCREMENT,
  `sProfessional` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业',
  `sGrade` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年级',
  `sCollege` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院',
  `sCounselorCode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '辅导员代号',
  `sApplyStatus` int(4) NOT NULL COMMENT '报名状态，0未报名，1报名待审核，2报名审核通过，3报名审核不通过',
  `sSchoolStatus` int(4) NOT NULL COMMENT '在校状态',
  `sUID` int(11) NOT NULL COMMENT '对应的用户ID',
  PRIMARY KEY (`sId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `uNumber` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '18位身份证号',
  `uName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `uAttribute` int(2) NOT NULL COMMENT '0:学生  1:实习生  2:企业实习管理员  3:校方实习负责人  4:校方毕业设计指导老师  5:辅导员',
  `uPassword` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `uPhone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '11位手机号',
  PRIMARY KEY (`uId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
