/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : u25

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-09-06 16:41:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL auto_increment,
  `cname` varchar(20) NOT NULL,
  PRIMARY KEY  (`cid`),
  UNIQUE KEY `cname` (`cname`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('3', '家电');
INSERT INTO `category` VALUES ('8', '文具2');
INSERT INTO `category` VALUES ('1', '服装');
INSERT INTO `category` VALUES ('10', '测试');
INSERT INTO `category` VALUES ('2', '箱包');
INSERT INTO `category` VALUES ('4', '钟表');
INSERT INTO `category` VALUES ('5', '饮料');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cid` int(11) NOT NULL auto_increment,
  `cname` varchar(40) NOT NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'zsf');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL auto_increment,
  `Name` varchar(20) character set gbk default NULL,
  `Location` varchar(20) NOT NULL,
  PRIMARY KEY  (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('10', '财务部', '重庆');
INSERT INTO `department` VALUES ('20', '科研部', '成都');
INSERT INTO `department` VALUES ('30', '销售部', '北京');
INSERT INTO `department` VALUES ('40', '运营部', '南京');

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `did` int(11) NOT NULL auto_increment,
  `dname` varchar(20) NOT NULL,
  PRIMARY KEY  (`did`),
  UNIQUE KEY `dname` (`dname`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('3', '人事部');
INSERT INTO `dept` VALUES ('2', '市场部');
INSERT INTO `dept` VALUES ('4', '研发部');
INSERT INTO `dept` VALUES ('1', '财务部');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `eid` int(11) NOT NULL auto_increment,
  `ename` varchar(20) NOT NULL,
  `age` int(11) default '25',
  `salary` decimal(7,2) default NULL,
  `deptid` int(11) default NULL,
  PRIMARY KEY  (`eid`),
  KEY `fk_deptid` (`deptid`),
  CONSTRAINT `fk_deptid` FOREIGN KEY (`deptid`) REFERENCES `dept` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', '张三', '22', '3000.00', '2');
INSERT INTO `emp` VALUES ('2', '李四', '28', '3100.00', '2');
INSERT INTO `emp` VALUES ('3', '王五', '28', '2800.00', '2');
INSERT INTO `emp` VALUES ('5', '张翠山', '23', '3000.00', '3');
INSERT INTO `emp` VALUES ('6', '张无忌', '20', '3800.00', '3');
INSERT INTO `emp` VALUES ('7', '张三丰', null, '3600.00', '2');
INSERT INTO `emp` VALUES ('8', '张三丰', '70', '10000.00', '1');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `Employee_id` int(11) NOT NULL auto_increment,
  `Employee_Name` varchar(20) character set gbk NOT NULL,
  `job_id` int(11) default NULL,
  `manager_id` int(11) NOT NULL,
  `HireDate` datetime default NULL,
  `Salary` int(11) NOT NULL,
  `comm` int(11) default NULL,
  `Department_id` int(11) default NULL,
  PRIMARY KEY  (`Employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7537 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('7369', '康勤生', '1', '7505', '2014-03-12 00:00:00', '1800', null, '20');
INSERT INTO `employee` VALUES ('7499', '刘方顺', '4', '7505', '2015-08-21 00:00:00', '2600', '300', '30');
INSERT INTO `employee` VALUES ('7505', '龙腾', '5', '7839', '2013-02-28 00:00:00', '2850', '500', '30');
INSERT INTO `employee` VALUES ('7506', '包崇林', '5', '7839', '2014-11-12 00:00:00', '2700', '300', '30');
INSERT INTO `employee` VALUES ('7507', '孔令维', '5', '7505', '2014-10-01 00:00:00', '2400', '300', '40');
INSERT INTO `employee` VALUES ('7521', '蓝勇', '4', '7698', '2015-12-01 00:00:00', '2850', '500', '30');
INSERT INTO `employee` VALUES ('7522', '唐天鳌', '2', '7902', '2014-01-13 00:00:00', '2950', '100', '20');
INSERT INTO `employee` VALUES ('7523', '娄阳', '2', '7902', '2014-02-14 00:00:00', '3050', '300', '20');
INSERT INTO `employee` VALUES ('7524', '胡友林', '2', '7505', '2014-03-15 00:00:00', '3800', null, '20');
INSERT INTO `employee` VALUES ('7525', '杨鹏飞', '2', '7902', '2014-03-16 00:00:00', '3200', null, '20');
INSERT INTO `employee` VALUES ('7526', '敖杰', '3', '7918', '2014-04-17 00:00:00', '3300', null, '40');
INSERT INTO `employee` VALUES ('7527', '罗杰', '2', '7902', '2014-05-19 00:00:00', '3800', null, '10');
INSERT INTO `employee` VALUES ('7528', '张冬', '2', '7505', '2014-06-18 00:00:00', '2800', '50', '40');
INSERT INTO `employee` VALUES ('7529', '彭柯智', '4', '7698', '2015-10-18 00:00:00', '2250', null, '30');
INSERT INTO `employee` VALUES ('7530', '黄飞', '4', '7698', '2015-03-21 00:00:00', '2650', '300', '30');
INSERT INTO `employee` VALUES ('7531', '鲜小卫', '5', '7839', '2013-08-28 00:00:00', '2750', '500', '30');
INSERT INTO `employee` VALUES ('7532', '程治韬', '5', '7839', '2015-11-12 00:00:00', '2650', '200', '30');
INSERT INTO `employee` VALUES ('7533', '黄吴庭阳', '5', '7839', '2015-10-02 00:00:00', '2450', '300', '40');
INSERT INTO `employee` VALUES ('7534', '尹刚', '4', '7698', '2015-12-02 00:00:00', '2150', '500', '30');
INSERT INTO `employee` VALUES ('7535', '段学良', '2', '7902', '2016-01-13 00:00:00', '3950', '100', '20');
INSERT INTO `employee` VALUES ('7536', '陈锐', '2', '7902', '2016-02-14 00:00:00', '3350', '300', '20');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gid` int(11) NOT NULL auto_increment,
  `gname` varchar(40) NOT NULL,
  `price` decimal(9,2) default NULL,
  PRIMARY KEY  (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'shubiao', '22.50');

-- ----------------------------
-- Table structure for `idcard`
-- ----------------------------
DROP TABLE IF EXISTS `idcard`;
CREATE TABLE `idcard` (
  `cid` int(11) NOT NULL auto_increment,
  `idno` varchar(18) NOT NULL,
  `issueDate` datetime default NULL,
  `endDate` datetime default NULL,
  `pid` int(11) default NULL,
  PRIMARY KEY  (`cid`),
  UNIQUE KEY `idno` (`idno`),
  UNIQUE KEY `pid` (`pid`),
  CONSTRAINT `idcard_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `person` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of idcard
-- ----------------------------
INSERT INTO `idcard` VALUES ('1', '500113199209236716', '2008-08-08 00:00:00', '2018-08-08 00:00:00', '1');
INSERT INTO `idcard` VALUES ('2', '500238199207021896', '2008-12-12 00:00:00', '2018-12-12 00:00:00', '2');

-- ----------------------------
-- Table structure for `job`
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `job_id` int(11) NOT NULL auto_increment,
  `job_name` varchar(20) character set gbk default NULL,
  PRIMARY KEY  (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('1', '前台');
INSERT INTO `job` VALUES ('2', '普通员工');
INSERT INTO `job` VALUES ('3', '分析师');
INSERT INTO `job` VALUES ('4', '销售');
INSERT INTO `job` VALUES ('5', '经理');
INSERT INTO `job` VALUES ('6', '总裁');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `mid` int(11) NOT NULL auto_increment,
  `name` varchar(30) NOT NULL,
  `url` varchar(100) default NULL,
  `isshow` int(11) default '1',
  `level` int(11) default NULL,
  `parentid` int(11) default NULL,
  PRIMARY KEY  (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统根菜单', '#', '0', '1', '-1');
INSERT INTO `menu` VALUES ('2', '用户管理', '#', '1', '2', '1');
INSERT INTO `menu` VALUES ('3', '用户列表', 'view/showUsers.jsp', '1', '3', '2');
INSERT INTO `menu` VALUES ('4', '权限管理', '#', '1', '2', '1');
INSERT INTO `menu` VALUES ('5', '角色列表', 'showRoles.do?methodName=showRoles', '1', '3', '4');
INSERT INTO `menu` VALUES ('6', '菜单列表', 'view/showMenus.jsp', '1', '3', '4');
INSERT INTO `menu` VALUES ('7', '添加菜单', 'toAddMenu.do?methodName=toAddMenu', '1', '3', '4');
INSERT INTO `menu` VALUES ('8', '班级管理', '#', '1', '2', '1');
INSERT INTO `menu` VALUES ('11', '班级列表', 'showClasses.do?methodName=showClasses', '1', '3', '8');
INSERT INTO `menu` VALUES ('12', '修改角色菜单页面', 'loadRoleMenu.do', '0', '3', '4');
INSERT INTO `menu` VALUES ('13', '修改角色菜单', 'editRoleMenu.do', '0', '3', '4');
INSERT INTO `menu` VALUES ('14', '添加菜单提交表单', 'insertMenu.do', '0', '3', '4');
INSERT INTO `menu` VALUES ('15', '员工列表', 'view/showEmps.jsp', '1', '3', '16');
INSERT INTO `menu` VALUES ('16', '员工管理', '#', '1', '2', '1');

-- ----------------------------
-- Table structure for `ordergc`
-- ----------------------------
DROP TABLE IF EXISTS `ordergc`;
CREATE TABLE `ordergc` (
  `oid` int(11) NOT NULL auto_increment,
  `cid` int(11) default NULL,
  `gid` int(11) default NULL,
  `buyCount` int(11) default NULL,
  PRIMARY KEY  (`oid`),
  KEY `cid` (`cid`),
  KEY `gid` (`gid`),
  CONSTRAINT `ordergc_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`),
  CONSTRAINT `ordergc_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `goods` (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordergc
-- ----------------------------
INSERT INTO `ordergc` VALUES ('1', '1', '1', '4');

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `pid` int(11) NOT NULL auto_increment,
  `pname` varchar(20) NOT NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'zsf');
INSERT INTO `person` VALUES ('2', 'zxy');
INSERT INTO `person` VALUES ('3', 'zs');
INSERT INTO `person` VALUES ('4', 'ls');
INSERT INTO `person` VALUES ('5', 'ww');
INSERT INTO `person` VALUES ('6', 'zhangsanfeng');
INSERT INTO `person` VALUES ('7', 'zhangcuishan');
INSERT INTO `person` VALUES ('8', 'zhangwuji');
INSERT INTO `person` VALUES ('9', '张三丰');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL auto_increment,
  `pname` varchar(30) NOT NULL,
  `cid` int(11) NOT NULL,
  `costPrice` decimal(7,2) default NULL,
  `salePrice` decimal(7,2) default NULL,
  `upTime` datetime default NULL,
  PRIMARY KEY  (`pid`),
  KEY `cid` (`cid`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '长虹彩电', '3', '500.00', '899.00', '2016-07-01 09:35:30');
INSERT INTO `product` VALUES ('2', '雅戈尔衬衫', '1', '800.00', '1299.00', '2016-07-03 09:35:30');
INSERT INTO `product` VALUES ('3', '欧米伽腕表', '4', '15000.00', '18899.00', '2016-07-03 09:35:30');
INSERT INTO `product` VALUES ('4', '加多宝', '5', '3.00', '5.00', '2016-04-07 09:35:30');
INSERT INTO `product` VALUES ('5', '丰谷金银花凉茶', '5', '2.00', '7.00', '2016-05-07 09:35:30');
INSERT INTO `product` VALUES ('6', '红豆西服', '1', '1500.00', '2899.00', '2016-08-07 09:35:30');
INSERT INTO `product` VALUES ('7', '乐视超级电视', '3', '1500.00', '1999.00', '2016-07-04 09:35:30');
INSERT INTO `product` VALUES ('8', '海尔洗衣机', '3', '1100.00', '1399.00', '2016-01-07 09:35:30');
INSERT INTO `product` VALUES ('9', '浪琴男士手表', '4', '5500.00', '8899.00', '2016-02-07 09:35:30');
INSERT INTO `product` VALUES ('10', '昆仑山矿泉水', '5', '1.00', '7.00', '2016-03-07 09:35:30');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL auto_increment,
  `rname` varchar(20) NOT NULL,
  PRIMARY KEY  (`rid`),
  UNIQUE KEY `rname` (`rname`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('4', '学员');
INSERT INTO `role` VALUES ('2', '班主任');
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('3', '项目经理');

-- ----------------------------
-- Table structure for `rolemenu`
-- ----------------------------
DROP TABLE IF EXISTS `rolemenu`;
CREATE TABLE `rolemenu` (
  `rmid` int(11) NOT NULL auto_increment,
  `rid` int(11) default NULL,
  `mid` int(11) default NULL,
  PRIMARY KEY  (`rmid`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rolemenu
-- ----------------------------
INSERT INTO `rolemenu` VALUES ('6', '2', '1');
INSERT INTO `rolemenu` VALUES ('7', '2', '2');
INSERT INTO `rolemenu` VALUES ('8', '2', '3');
INSERT INTO `rolemenu` VALUES ('67', '1', '1');
INSERT INTO `rolemenu` VALUES ('68', '1', '2');
INSERT INTO `rolemenu` VALUES ('69', '1', '3');
INSERT INTO `rolemenu` VALUES ('70', '1', '4');
INSERT INTO `rolemenu` VALUES ('71', '1', '5');
INSERT INTO `rolemenu` VALUES ('72', '1', '6');
INSERT INTO `rolemenu` VALUES ('73', '1', '7');
INSERT INTO `rolemenu` VALUES ('74', '1', '8');
INSERT INTO `rolemenu` VALUES ('75', '1', '11');
INSERT INTO `rolemenu` VALUES ('76', '1', '12');
INSERT INTO `rolemenu` VALUES ('77', '1', '13');
INSERT INTO `rolemenu` VALUES ('78', '1', '14');
INSERT INTO `rolemenu` VALUES ('79', '1', '15');
INSERT INTO `rolemenu` VALUES ('80', '1', '16');

-- ----------------------------
-- Table structure for `salelog`
-- ----------------------------
DROP TABLE IF EXISTS `salelog`;
CREATE TABLE `salelog` (
  `sid` int(11) NOT NULL auto_increment,
  `pname` varchar(20) NOT NULL,
  `costPrice` decimal(7,2) default NULL,
  `salePrice` decimal(7,2) default NULL,
  `saleCount` int(11) default NULL,
  `saleTime` datetime default NULL,
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salelog
-- ----------------------------
INSERT INTO `salelog` VALUES ('1', '签字笔', '1.00', '1.30', '3400', '2016-07-05 00:00:00');
INSERT INTO `salelog` VALUES ('2', '男士皮鞋', '70.00', '110.30', '34', '2016-07-05 00:00:00');
INSERT INTO `salelog` VALUES ('3', '签字笔', '1.05', '1.25', '400', '2016-07-05 00:00:00');
INSERT INTO `salelog` VALUES ('4', '牙刷', '1.00', '1.50', '300', '2016-07-05 00:00:00');
INSERT INTO `salelog` VALUES ('5', '牙刷', '1.00', '1.40', '400', '2016-07-05 00:00:00');
INSERT INTO `salelog` VALUES ('6', '男士皮鞋', '60.00', '90.30', '40', '2016-07-05 00:00:00');
INSERT INTO `salelog` VALUES ('7', '签字笔签字笔签字笔签字笔签字笔签字笔签字', '1.00', '1.30', '3400', '2016-07-05 16:07:06');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `sid` int(11) NOT NULL auto_increment,
  `sname` varchar(20) NOT NULL,
  `course` varchar(20) NOT NULL,
  `score` int(11) default NULL,
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '张三丰', '语文', '88');
INSERT INTO `score` VALUES ('2', '张三丰', '数学', '28');
INSERT INTO `score` VALUES ('3', '张三丰', '英语', '68');
INSERT INTO `score` VALUES ('4', '张翠山', '语文', '78');
INSERT INTO `score` VALUES ('5', '张翠山', '数学', '88');
INSERT INTO `score` VALUES ('6', '张翠山', '英语', '58');
INSERT INTO `score` VALUES ('7', '张无忌', '语文', '88');
INSERT INTO `score` VALUES ('8', '张无忌', '数学', '28');
INSERT INTO `score` VALUES ('9', '张无忌', '英语', '68');
INSERT INTO `score` VALUES ('10', '张三', '语文', '66');
INSERT INTO `score` VALUES ('11', '张三', '数学', '88');
INSERT INTO `score` VALUES ('12', '张三', '英语', '58');
INSERT INTO `score` VALUES ('13', '张永福', '语文', null);
INSERT INTO `score` VALUES ('14', '张永福', '数学', '99');
INSERT INTO `score` VALUES ('15', '张永福', '英语', '34');
INSERT INTO `score` VALUES ('16', '刘江龙', '语文', '77');
INSERT INTO `score` VALUES ('17', '刘江龙', '数学', '88');
INSERT INTO `score` VALUES ('18', '刘江龙', '英语', null);
INSERT INTO `score` VALUES ('19', '冯元燚', '语文', '56');
INSERT INTO `score` VALUES ('20', '冯元燚', '数学', '89');
INSERT INTO `score` VALUES ('21', '冯元燚', '英语', '45');
INSERT INTO `score` VALUES ('22', '冉启松', '语文', '77');
INSERT INTO `score` VALUES ('23', '冉启松', '数学', null);
INSERT INTO `score` VALUES ('24', '冉启松', '英语', '76');
INSERT INTO `score` VALUES ('25', '杨永', '语文', '66');
INSERT INTO `score` VALUES ('26', '杨永', '数学', null);
INSERT INTO `score` VALUES ('27', '杨永', '英语', '89');
INSERT INTO `score` VALUES ('28', '周憾宇', '语文', '66');
INSERT INTO `score` VALUES ('29', '周憾宇', '数学', '67');
INSERT INTO `score` VALUES ('30', '周憾宇', '英语', null);

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL auto_increment,
  `sno` int(11) default NULL,
  `sname` varchar(20) NOT NULL,
  `sex` varchar(1) default NULL,
  `age` int(11) default NULL,
  `height` int(11) default NULL,
  `money_left` decimal(7,2) default NULL,
  `monet_right` decimal(7,2) default NULL,
  `phone` varchar(11) default NULL,
  `address` varchar(50) default NULL,
  `remark` varchar(50) default NULL,
  PRIMARY KEY  (`sid`),
  UNIQUE KEY `sno` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1001', '黄蓉', '女', '20', '160', '233.50', '12.80', '18996157300', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('2', '1002', '郭靖', '男', '22', '170', '1233.50', '112.80', '18996157301', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('3', '1003', '杨康', '男', '22', '172', '233.50', '0.00', '18996157302', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('4', '1004', '穆念慈', '女', '19', '162', '2133.50', '12.81', '18996157303', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('5', '1005', '杨过', '男', '23', '175', '2323.50', '12.80', '18996157304', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('6', '1006', '小龙女', '女', '20', '161', '233.50', '121.80', '18996157305', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('7', '1007', '郭襄', '女', '17', '160', '33.50', '12.80', '18996157306', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('8', '1008', '郭虎', '男', '28', '168', '233.50', '112.80', '18996157307', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('9', '1009', '郭富城', '男', '30', '170', '33.50', '12.80', '18996157308', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('10', '1010', '周淮安', '男', '27', '178', '233.50', '1.80', '18996157309', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('11', '1011', '陈奕迅', '男', '40', '167', '233.50', '12.80', '18996157310', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('12', '1012', '刘德华', '男', '44', '170', '23.50', '1.80', '18996157311', '重庆市渝中区较场口', null);
INSERT INTO `student` VALUES ('13', '1013', '张学友', '男', '42', '170', '23.50', '11.80', '18996157312', '重庆市渝中区较场口', null);

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `uid` int(11) NOT NULL auto_increment,
  `userName` varchar(20) NOT NULL,
  `userPass` varchar(20) NOT NULL,
  `sex` int(11) default NULL,
  `email` varchar(50) default NULL,
  `education` int(11) default NULL,
  `hobbys` varchar(30) default NULL,
  `description` varchar(100) default NULL,
  `avatar` varchar(50) default NULL,
  PRIMARY KEY  (`uid`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('13', 'admin', '123321', '1', 'wuyong_0513@163.com', '3', '3,5', '专注坑货20年', 'files/16481473057106155.jpg');
INSERT INTO `tb_user` VALUES ('14', 'aaa', '123', '2', '123@qq.com', '2', '2,3,5', '啊地方海事局好的伤口附近的圣诞节啊', null);
INSERT INTO `tb_user` VALUES ('15', 'bbb', '321', '1', 'bbb@163.com', '2', '1,2', '蝴蝶飞飞飞飞', null);

-- ----------------------------
-- Table structure for `userrole`
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `urid` int(11) NOT NULL auto_increment,
  `uid` int(11) default NULL,
  `rid` int(11) default NULL,
  PRIMARY KEY  (`urid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('2', '13', '1');
INSERT INTO `userrole` VALUES ('3', '14', '2');
INSERT INTO `userrole` VALUES ('4', '15', '2');
