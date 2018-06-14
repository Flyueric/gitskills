/*
Navicat MySQL Data Transfer

Source Server         : Eric
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-14 17:35:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(255) DEFAULT NULL,
  `goodsPrice` decimal(10,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `typeid` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeid` (`typeid`),
  CONSTRAINT `typeid` FOREIGN KEY (`typeid`) REFERENCES `goodstype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('9', 'pen', '50.00', '10', '3', 'cao');
INSERT INTO `goods` VALUES ('10', 'pen', '50.00', '10', '3', 'cao');
INSERT INTO `goods` VALUES ('12', 'basketball', '150.00', '10', '1', null);
INSERT INTO `goods` VALUES ('13', 'basketball', '123.00', '10', '2', null);
INSERT INTO `goods` VALUES ('14', 'basketball', '150.00', '20', '3', null);

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('1', '生活用品');
INSERT INTO `goodstype` VALUES ('2', '体育用品');
INSERT INTO `goodstype` VALUES ('3', 'aaaa');
INSERT INTO `goodstype` VALUES ('4', 'Test');
INSERT INTO `goodstype` VALUES ('13', null);
INSERT INTO `goodstype` VALUES ('14', null);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `isAdmin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'bovane', '123456', 'bo', 'yes');
