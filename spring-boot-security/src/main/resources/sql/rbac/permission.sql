/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 15/05/2020 11:08:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `action_url` varchar(50) DEFAULT NULL,
  `create_user` varchar(20) DEFAULT NULL,
  `modify_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
INSERT INTO `permission` VALUES (1, '测试连接1', '/user*/**', 'SYSTEM', 'SYSTEM', '2020-05-06 11:11:15', '2020-05-06 11:11:17', 1);
INSERT INTO `permission` VALUES (2, '测试连接2', '/index', 'SYSYEM', 'SYSTEM', '2020-05-06 11:12:51', '2020-05-06 11:12:53', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
