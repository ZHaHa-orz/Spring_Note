/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80017 (8.0.17)
 Source Host           : localhost:3306
 Source Schema         : studb

 Target Server Type    : MySQL
 Target Server Version : 80017 (8.0.17)
 File Encoding         : 65001

 Date: 11/01/2025 09:47:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `class` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (1, '张三', '男', 20, '高中一班');
INSERT INTO `students` VALUES (2, '李四', '男', 19, '高中二班');
INSERT INTO `students` VALUES (3, '王五', '女', 18, '高中一班');
INSERT INTO `students` VALUES (4, '赵六', '女', 20, '高中三班');
INSERT INTO `students` VALUES (5, '刘七', '男', 19, '高中二班');
INSERT INTO `students` VALUES (6, '陈八', '女', 18, '高中一班');
INSERT INTO `students` VALUES (7, '杨九', '男', 20, '高中三班');
INSERT INTO `students` VALUES (8, '吴十', '男', 19, '高中二班');

SET FOREIGN_KEY_CHECKS = 1;
