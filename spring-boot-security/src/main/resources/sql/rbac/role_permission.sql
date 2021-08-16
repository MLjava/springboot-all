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

 Date: 15/05/2020 11:09:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `create_user` varchar(20) DEFAULT NULL,
  `modify_user` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
BEGIN;
INSERT INTO `role_permission` VALUES (1, 1, 1, 'SYSTEM', 'SYSTEM', '2020-05-06 11:13:26', '2020-05-06 11:13:28');
INSERT INTO `role_permission` VALUES (2, 1, 2, 'SYSTEM', 'SYSTEM', '2020-05-06 11:13:43', '2020-05-06 11:13:46');
INSERT INTO `role_permission` VALUES (3, 2, 2, 'SYSTEM', 'SYSTEM', '2020-05-06 11:14:23', '2020-05-06 11:14:25');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
