/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : recruit

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2021-01-14 10:03:19
*/

CREATE DATABASE  IF NOT EXISTS `recruit`;
USE `recruit`;

-- ----------------------------
-- Table structure for activate_info
-- ----------------------------
DROP TABLE IF EXISTS `activate_info`;
CREATE TABLE `activate_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `type` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activate_info
-- ----------------------------

-- ----------------------------
-- Table structure for cb
-- ----------------------------
DROP TABLE IF EXISTS `cb`;
CREATE TABLE `cb` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NOT NULL,
  `boss_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cb
-- ----------------------------

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(30) NOT NULL,
  `leader_introduce` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(100) NOT NULL,
  `treatment` text NOT NULL,
  `company_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `company_logo` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `flag` int NOT NULL DEFAULT '0',
  `boss_num` int NOT NULL DEFAULT '0',
  `job_num` int NOT NULL DEFAULT '0',
  `mid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int NOT NULL AUTO_INCREMENT,
  `job_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `boss_id` int NOT NULL,
  `salary` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `job_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `experience` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `education` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `flag` int NOT NULL DEFAULT '5',
  `job_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `work_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `job_request` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `release_time` datetime NOT NULL,
  `mid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int NOT NULL AUTO_INCREMENT,
  `send_id` int NOT NULL,
  `receive_id` int NOT NULL,
  `context` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `post_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `nation` varchar(30) NOT NULL,
  `height` varchar(20) NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(30) NOT NULL,
  `politic_status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(30) NOT NULL,
  `school` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `education` varchar(30) NOT NULL,
  `educationbg` text NOT NULL,
  `i_experience` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `s_experience` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `skills` text NOT NULL,
  `self` text NOT NULL,
  `photo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resume
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(30) NOT NULL,
  `password` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_number` varchar(30) NOT NULL,
  `identity_id` tinyint NOT NULL DEFAULT '0',
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date_of_birth` date NOT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  `credit` int NOT NULL DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('17', 'manager', 'manager123', '0795151defba7a4b5dfa89170de46277', '0', '3', '管', '理', '2020-01-01', '17702960648', '男', '724128629@qq.com', '1', '100');

-- ----------------------------
-- Table structure for workerhistory
-- ----------------------------
DROP TABLE IF EXISTS `workerhistory`;
CREATE TABLE `workerhistory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `worker_id` int NOT NULL,
  `employment_id` int NOT NULL,
  `t` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workerhistory
-- ----------------------------

-- ----------------------------
-- Table structure for workersignup
-- ----------------------------
DROP TABLE IF EXISTS `workersignup`;
CREATE TABLE `workersignup` (
  `id` int NOT NULL AUTO_INCREMENT,
  `worker_id` int NOT NULL,
  `employment_id` int NOT NULL,
  `t` datetime NOT NULL,
  `flag` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workersignup
-- ----------------------------
