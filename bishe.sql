/*
Navicat MySQL Data Transfer

Source Server         : carsystem
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : bishe

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-03-08 21:31:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `baofeicar`
-- ----------------------------
DROP TABLE IF EXISTS `baofeicar`;
CREATE TABLE `baofeicar` (
  `carid` int(25) NOT NULL AUTO_INCREMENT,
  `fixed` varchar(255) DEFAULT NULL,
  `errormsg` varchar(255) DEFAULT NULL,
  `pos` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `price` int(25) DEFAULT NULL,
  `size` int(25) DEFAULT NULL,
  `photolocation` varchar(255) DEFAULT NULL,
  `carnum` varchar(255) DEFAULT NULL,
  `pinpai` varchar(255) DEFAULT NULL,
  `yaprice` int(25) DEFAULT NULL,
  PRIMARY KEY (`carid`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of baofeicar
-- ----------------------------

-- ----------------------------
-- Table structure for `bookcar`
-- ----------------------------
DROP TABLE IF EXISTS `bookcar`;
CREATE TABLE `bookcar` (
  `carid` int(11) NOT NULL AUTO_INCREMENT,
  `booker` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `pos` varchar(255) DEFAULT NULL,
  `fixed` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `photolocation` varchar(255) DEFAULT NULL,
  `carnum` varchar(255) DEFAULT NULL,
  `pinpai` varchar(255) DEFAULT NULL,
  `yaprice` int(11) DEFAULT NULL,
  `errormsg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`carid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookcar
-- ----------------------------

-- ----------------------------
-- Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carid` int(11) NOT NULL AUTO_INCREMENT COMMENT '车代号',
  `account` varchar(255) NOT NULL COMMENT '租赁点管理员账号',
  `state` varchar(255) DEFAULT NULL COMMENT '1=借出，2=归还，3=已损坏,4=正常',
  `category` varchar(255) DEFAULT NULL COMMENT '类型待定',
  `price` int(10) DEFAULT NULL,
  `pos` varchar(255) DEFAULT NULL COMMENT '租赁地点',
  `fixed` varchar(255) DEFAULT NULL COMMENT '修理状态 1=已修理 2=待修理,3=正常',
  `size` int(11) DEFAULT NULL,
  `photolocation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `carnum` varchar(255) DEFAULT NULL,
  `pinpai` varchar(255) DEFAULT NULL,
  `yaprice` int(11) DEFAULT NULL,
  `errormsg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`carid`),
  KEY `account` (`account`),
  KEY `pos` (`pos`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('59', '9377', '借出', '中高档轿车', '1500', '沙溪', '正常', '4', '/image/2020-02-24/a7b2968e-0738-42bf-96a9-c3e650158576.JPG', '粤A123', '大众', '500', '该车辆丢失');
INSERT INTO `car` VALUES ('60', '9377', '借出', '中高档轿车', '1500', '黄岐', '正常', '4', '/image/2020-02-24/f181088d-cbfb-4b6b-9680-f8195a95d400.JPG', '粤B123', '比亚迪', '500', null);
INSERT INTO `car` VALUES ('61', '9377', '借出', '商务车', '1500', '黄岐', '正常', '7', '/image/2020-02-24/b82bee21-1882-4502-992c-d16fd51943e7.JPG', '粤C123', '福特', '500', null);
INSERT INTO `car` VALUES ('62', '9377', '正常', '中巴车', '2000', '黄岐', '正常', '10', '/image/2020-02-24/9670a049-76a4-4376-9bb7-2c20a11988d9.JPG', '粤D123', '宝马', '500', null);
INSERT INTO `car` VALUES ('63', '9377', '正常', '大巴车', '3000', '黄岐', '正常', '20', '/image/2020-02-24/975de6c8-813a-4c2d-8b4b-cb306bea3d5c.JPG', '粤E123', '奔驰', '1500', null);
INSERT INTO `car` VALUES ('64', '9377', '正常', '中高档轿车', '1000', '黄岐', '正常', '23', '/image/2020-03-05/dbcdba12-acc2-4130-a9e8-5a927cd46b89.JPG', '粤P123', '宾利', '100', null);
INSERT INTO `car` VALUES ('65', '9377', '借出', '中高档轿车', '10000', '黄岐', '正常', '3', '/image/2020-03-05/6616c01f-370f-40fa-b0a3-96385f8f1cb0.JPG', '粤Q123', '玛莎拉蒂', '1000', null);

-- ----------------------------
-- Table structure for `carcategory`
-- ----------------------------
DROP TABLE IF EXISTS `carcategory`;
CREATE TABLE `carcategory` (
  `num` int(11) DEFAULT NULL,
  `categoryname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(255) NOT NULL,
  `state` int(11) DEFAULT NULL COMMENT '0正常，1删除了',
  PRIMARY KEY (`categoryname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carcategory
-- ----------------------------
INSERT INTO `carcategory` VALUES ('10', '中巴车', '9377', '0');
INSERT INTO `carcategory` VALUES ('4', '中高档轿车', '9377', '0');
INSERT INTO `carcategory` VALUES ('7', '商务车', '9377', '0');
INSERT INTO `carcategory` VALUES ('20', '大巴车', '9377', '0');

-- ----------------------------
-- Table structure for `dingdan`
-- ----------------------------
DROP TABLE IF EXISTS `dingdan`;
CREATE TABLE `dingdan` (
  `ddid` int(255) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `carid` int(11) NOT NULL,
  `account` varchar(255) NOT NULL COMMENT '订单发起人',
  `name` varchar(25) NOT NULL COMMENT '客户名',
  `category` varchar(255) NOT NULL,
  `price` int(255) NOT NULL,
  `yaprice` int(255) NOT NULL,
  `pos` varchar(255) NOT NULL,
  `size` int(255) DEFAULT NULL,
  `pinpai` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ddid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dingdan
-- ----------------------------
INSERT INTO `dingdan` VALUES ('2', '62', '0438', '周小彬', '中巴车', '2000', '500', '黄岐', '10', '宝马', '已完成');

-- ----------------------------
-- Table structure for `pos`
-- ----------------------------
DROP TABLE IF EXISTS `pos`;
CREATE TABLE `pos` (
  `posname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '租赁点',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '租赁点管理员分配',
  `carid` int(11) DEFAULT NULL COMMENT '车代号',
  `posid` int(11) NOT NULL AUTO_INCREMENT,
  `posaddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`posid`) USING BTREE,
  KEY `pos` (`posname`),
  KEY `carid` (`carid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pos
-- ----------------------------
INSERT INTO `pos` VALUES ('黄岐', '9377', null, '17', '黄岐白天鹅花园');
INSERT INTO `pos` VALUES ('沙溪', '9377', null, '18', '沙溪工业城');

-- ----------------------------
-- Table structure for `poser`
-- ----------------------------
DROP TABLE IF EXISTS `poser`;
CREATE TABLE `poser` (
  `poserid` int(20) NOT NULL AUTO_INCREMENT COMMENT 'poserid',
  `posername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pos` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `carid` int(20) DEFAULT NULL COMMENT '管理哪些车辆',
  `phone` varchar(255) DEFAULT NULL,
  `shenfenzheng` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`poserid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poser
-- ----------------------------
INSERT INTO `poser` VALUES ('15', '周文彬', '沙溪', null, '18998861430', '440183199705022130', '1640129337');
INSERT INTO `poser` VALUES ('16', '陈智文', '黄岐', null, '13168581426', '440183199705022210', '1640129339');
INSERT INTO `poser` VALUES ('17', '蔡文姬', '沙溪', null, '1333640000', '465456', null);
INSERT INTO `poser` VALUES ('18', '李白', null, null, '111111111', '111111', null);
INSERT INTO `poser` VALUES ('19', '李白', null, null, '13059580107', '44110', null);
INSERT INTO `poser` VALUES ('28', 'fawenji', null, null, '110', '120', 'fawenji');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `account` varchar(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `grade` int(10) NOT NULL,
  `money` int(255) DEFAULT NULL,
  `shenfenzheng` int(255) DEFAULT NULL,
  PRIMARY KEY (`account`),
  UNIQUE KEY `u_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('0438', '123', '周小彬', '1', '123', '3', '1610', '123');
INSERT INTO `users` VALUES ('11111', '111', '1', '1', '1', '3', '0', null);
INSERT INTO `users` VALUES ('123456', '123456', '陈智文', null, null, '2', '0', null);
INSERT INTO `users` VALUES ('1426392099', '123456', null, null, null, '3', '0', null);
INSERT INTO `users` VALUES ('2121', '111', '1', '1', '1', '3', '0', null);
INSERT INTO `users` VALUES ('9377', '111', null, null, null, '1', '0', null);
INSERT INTO `users` VALUES ('93771', '111', '', null, null, '3', '0', null);
INSERT INTO `users` VALUES ('937712', 'sadasd', '啊', '21', '123', '3', '0', null);
INSERT INTO `users` VALUES ('93772', '111', '', null, null, '3', '0', null);
INSERT INTO `users` VALUES ('93773', '111', '1', '1', '1', '3', '0', null);
INSERT INTO `users` VALUES ('951753', '111', '123', '123', '123', '3', '0', null);
INSERT INTO `users` VALUES ('dnf', 'dnf520', 'dnf', '10', '1313', '3', '0', null);
INSERT INTO `users` VALUES ('fawenji', '111', 'fawenji', '1', '110', '2', '0', '120');
