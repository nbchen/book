/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 13/06/2020 10:04:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL COMMENT '价格',
  `author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sales` int(0) NULL DEFAULT NULL COMMENT '销量',
  `stock` int(0) NULL DEFAULT NULL COMMENT '库存',
  `img_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书籍图片的路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (6, '蛋炒饭2', 9.90, '周星星', 14, 13, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (7, '赌神', 66.50, '龙伍', 128, 127, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (8, 'Java 编程思想', 99.50, '阳哥', 54, 52, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (9, 'JavaScript 从入门到精通', 9.90, '婷姐', 85, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (10, 'cocos2d-x 游戏编程入门', 49.00, '国哥', 52, 62, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (11, 'C 语言程序设计', 28.00, '谭浩强', 52, 74, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (12, 'Lua 语言程序设计', 51.50, '雷丰阳', 48, 82, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (13, '西游记', 12.00, '罗贯中', 19, 9999, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (14, '水浒传', 33.05, '华仔', 22, 88, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (15, '操作系统原理', 133.05, '刘优', 122, 188, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (16, '数据结构 java 版', 173.15, '封大神', 21, 81, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (17, 'UNIX 高级环境编程', 99.15, '乐天', 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (18, 'javaScript 高级编程', 69.15, '国哥', 210, 812, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (19, '大话设计模式', 89.15, '国哥', 20, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (20, '人月神话', 88.15, '刚哥', 20, 80, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (22, '陈志杰自传', 100.00, '陈志杰', 10000, 0, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (31, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (32, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (33, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (34, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (35, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (36, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (37, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (38, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (39, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (40, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (41, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (42, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (43, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (44, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (45, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (46, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (47, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (48, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (49, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (50, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (51, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (52, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (53, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (54, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (55, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (56, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (57, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (58, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (59, '木虚肉盖饭2', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (60, 'C++编程思想2', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (61, 'java11', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (62, 'java从入门到入土', 111.00, '陈志杰', 111, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (63, 'C++编程思想2', 111.00, '嘎嘎嘎', 111, 10, 'static/img/default.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(0) NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `total_price` decimal(11, 2) NULL DEFAULT NULL,
  `order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', 'admin@nbchen.com');
INSERT INTO `t_user` VALUES (5, 'test', '123456', 'test@nbchen.com');
INSERT INTO `t_user` VALUES (6, 'nbchen', '123456', 'nbchen@nbchen.com');
INSERT INTO `t_user` VALUES (9, 'rachel', '123456', 'rachel@nbchen.com');

SET FOREIGN_KEY_CHECKS = 1;
