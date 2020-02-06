/*
Navicat MySQL Data Transfer

Source Server         : carsystem
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : bishe

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-02-06 13:22:01
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carid` int(11) NOT NULL AUTO_INCREMENT COMMENT '车代号',
  `account` varchar(255) NOT NULL COMMENT '租赁点管理员账号',
  `state` int(255) DEFAULT NULL COMMENT '1=借出，2=归还，3=已损坏',
  `category` int(255) DEFAULT NULL COMMENT '类型待定',
  `price` int(10) DEFAULT NULL,
  `pos` varchar(255) DEFAULT NULL COMMENT '租赁地点',
  `fixed` int(255) DEFAULT NULL COMMENT '修理状态 1=已修理 2=待修理',
  `size` int(11) DEFAULT NULL,
  `photolocation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `carnum` varchar(255) DEFAULT NULL,
  `pinpai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`carid`),
  KEY `account` (`account`),
  KEY `pos` (`pos`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '9377', null, null, null, null, null, null, null, null, null);
INSERT INTO `car` VALUES ('16', '9377', null, '1', null, null, null, null, '/images/2020-02-05/8b5c5e56-6e87-4547-a029-04ccb0644ed1.JPG', '粤A123', '大众');
INSERT INTO `car` VALUES ('17', '9377', null, '1', null, null, null, null, '/images/2020-02-05/8f80642b-cb7a-41d7-aecc-ac5172856a84.JPG', '粤B123', '丰田');
INSERT INTO `car` VALUES ('18', '9377', null, '1', null, null, null, null, '/images/2020-02-05/ddeef038-28ec-41c8-9d58-e7eec0ef446e.JPG', '123', '七夕');
INSERT INTO `car` VALUES ('19', '9377', null, '1', null, null, null, null, '/images/2020-02-05/98025006-395b-4dfb-91a9-3aa5c1985935.JPG', '5533', '不知道');
INSERT INTO `car` VALUES ('20', '9377', null, '1', null, null, null, null, '/images/2020-02-05/4ee14d69-7cad-4b68-a664-ac9bc69931da.JPG', '粤ABC', '不存在');
INSERT INTO `car` VALUES ('21', '9377', null, '1', null, null, null, null, '/images/2020-02-05/f4888417-3f07-40f3-a2fa-15ac59dbf32f.JPG', '粤1a', '不能不');
INSERT INTO `car` VALUES ('22', '9377', null, '1', null, null, null, null, '/images/2020-02-05/3f98e589-32c6-4cfd-af82-80922e13f374.JPG', '粤A', '打啊打');
INSERT INTO `car` VALUES ('23', '9377', null, '1', null, null, null, null, '/images/2020-02-05/59bf1afc-971c-44af-b9ee-ef0bd3986624.JPG', '粤ABC', '大大的');
INSERT INTO `car` VALUES ('24', '9377', null, '1', null, null, null, null, '/images/2020-02-05/8ecfe5f6-37d2-475c-a5c6-bf3b63d559ab.JPG', '粤A', '打1');
INSERT INTO `car` VALUES ('25', '9377', null, '1', null, null, null, null, '/images/2020-02-05/07c832d8-5251-4170-bc2a-665b72882392.JPG', '粤啊', '啊啊');
INSERT INTO `car` VALUES ('26', '9377', null, '1', null, null, null, null, '/images/2020-02-05/3022eba6-992a-4c50-a43b-8b0f20916706.JPG', 'sad撒大声地爱思', '阿萨德');
INSERT INTO `car` VALUES ('27', '9377', null, '1', null, null, null, null, '/images/2020-02-05/d2e4c412-ad96-48d0-ac0e-de55ca3792b4.JPG', '啊', '啊');
INSERT INTO `car` VALUES ('28', '9377', null, '1', null, null, null, null, '/images/2020-02-05/f2515317-cfd6-4b40-9655-60078876e6c0.JPG', '啊是', '啊');
INSERT INTO `car` VALUES ('29', '9377', null, '1', null, null, null, null, '/images/2020-02-05/dd7920cf-28c1-4d54-a1ea-0f8dd86c4dbc.JPG', '三生三世', '啊');

-- ----------------------------
-- Table structure for `carcategory`
-- ----------------------------
DROP TABLE IF EXISTS `carcategory`;
CREATE TABLE `carcategory` (
  `num` int(11) DEFAULT NULL,
  `categoryname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(255) NOT NULL,
  PRIMARY KEY (`categoryname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carcategory
-- ----------------------------
INSERT INTO `carcategory` VALUES ('123', '111', '9377');
INSERT INTO `carcategory` VALUES ('111', '222', '9377');
INSERT INTO `carcategory` VALUES ('12', '类型A', '9377');

-- ----------------------------
-- Table structure for `pos`
-- ----------------------------
DROP TABLE IF EXISTS `pos`;
CREATE TABLE `pos` (
  `pos` varchar(255) NOT NULL COMMENT '租赁点',
  `account` varchar(255) NOT NULL COMMENT '租赁点管理员分配',
  `carid` int(11) NOT NULL COMMENT '车代号',
  `posid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`posid`) USING BTREE,
  KEY `pos` (`pos`),
  KEY `carid` (`carid`),
  CONSTRAINT `pos_ibfk_1` FOREIGN KEY (`carid`) REFERENCES `car` (`carid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pos
-- ----------------------------
INSERT INTO `pos` VALUES ('ca', '1426392099', '1', '1');
INSERT INTO `pos` VALUES ('abc', '9377', '1', '2');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `account` varchar(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `grade` int(10) NOT NULL,
  PRIMARY KEY (`account`),
  UNIQUE KEY `u_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('123456', '123456', null, null, null, '2');
INSERT INTO `users` VALUES ('1426392099', '123456', null, null, null, '3');
INSERT INTO `users` VALUES ('9377', '111', null, null, null, '1');
