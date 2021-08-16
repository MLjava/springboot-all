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

 Date: 15/05/2020 11:09:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名字',
  `enable` tinyint(1) DEFAULT NULL COMMENT '1:启用,0:关闭',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_user` varchar(20) DEFAULT NULL,
  `modify_user` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, '超级管理员', 1, '2020-04-30 10:53:02', '2020-04-30 10:53:05', 'SYSTEM', 'SYSTEM');
INSERT INTO `role` VALUES (2, '普通用户', 1, '2020-04-30 11:11:52', '2020-04-30 11:11:57', 'SYSTEM', 'SYSTEM');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
