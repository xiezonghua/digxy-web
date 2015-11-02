/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.46-0ubuntu0.14.04.2 : Database - digxy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`digxy` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `digxy`;

/*Table structure for table `tb_collection` */

DROP TABLE IF EXISTS `tb_collection`;

CREATE TABLE `tb_collection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'key id',
  `resid` bigint(20) DEFAULT NULL COMMENT 'resource id',
  `collection_id` bigint(20) DEFAULT NULL COMMENT 'collector id',
  `collectioner` varchar(50) DEFAULT NULL COMMENT 'collector',
  `collectionDate` datetime DEFAULT NULL COMMENT 'collect date time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_collection` */

/*Table structure for table `tb_comment` */

DROP TABLE IF EXISTS `tb_comment`;

CREATE TABLE `tb_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
  `res_id` bigint(20) DEFAULT NULL COMMENT 'resource id',
  `commenter_id` bigint(20) DEFAULT NULL COMMENT 'who comment',
  `commenter` varchar(50) DEFAULT NULL COMMENT ' who revert',
  `comment_date` datetime DEFAULT NULL COMMENT 'comment time',
  `content` text COMMENT 'content',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tb_comment` */

insert  into `tb_comment`(`id`,`res_id`,`commenter_id`,`commenter`,`comment_date`,`content`) values (3,1,1,'xiezonghuago@163.com','2015-06-14 10:31:45','东法夫'),(4,3,2,'xiezonghuago@163.com','2015-09-09 21:16:39','把多纳多尼'),(5,3,2,'xiezonghuago@163.com','2015-09-09 22:06:51','撒等级啊睡觉的'),(6,3,1,'xiezonghuago@163.com','2015-09-09 22:10:00','放大镜发觉对方'),(7,10,1,'xiezonghuago@163.com','2015-09-13 09:53:37','大对策');

/*Table structure for table `tb_expert` */

DROP TABLE IF EXISTS `tb_expert`;

CREATE TABLE `tb_expert` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `profile` varchar(600) DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_expert` */

insert  into `tb_expert`(`id`,`name`,`qq`,`profile`,`add_date`) values (4,'曾霞光','452981233','技术','2015-06-13 11:20:22');

/*Table structure for table `tb_guanzhu` */

DROP TABLE IF EXISTS `tb_guanzhu`;

CREATE TABLE `tb_guanzhu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'key id',
  `user_id` bigint(20) NOT NULL COMMENT 'attentive user id',
  `follower_id` bigint(20) NOT NULL COMMENT 'follower user id',
  `date` datetime DEFAULT NULL COMMENT 'attentive time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_guanzhu` */

insert  into `tb_guanzhu`(`id`,`user_id`,`follower_id`,`date`) values (1,1,1,'2015-06-14 10:38:42');

/*Table structure for table `tb_keyword` */

DROP TABLE IF EXISTS `tb_keyword`;

CREATE TABLE `tb_keyword` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
  `keywords` varchar(200) DEFAULT NULL COMMENT 'key word',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_keyword` */

insert  into `tb_keyword`(`id`,`keywords`) values (1,'ASBW12'),(2,'的');

/*Table structure for table `tb_message` */

DROP TABLE IF EXISTS `tb_message`;

CREATE TABLE `tb_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
  `sender_id` bigint(20) DEFAULT NULL COMMENT 'sender id',
  `sender` varchar(50) DEFAULT NULL COMMENT ' sender',
  `receiver_id` bigint(20) DEFAULT NULL COMMENT 'receiver id',
  `receiver` varchar(50) DEFAULT NULL COMMENT 'email receiver',
  `title` varchar(200) DEFAULT NULL COMMENT 'email title',
  `content` text COMMENT 'email content',
  `add_date` datetime DEFAULT NULL COMMENT 'email create time',
  `status` tinyint(4) DEFAULT '0',
  `sender_mark` tinyint(4) DEFAULT '0',
  `receiver_mark` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_message` */

/*Table structure for table `tb_notification` */

DROP TABLE IF EXISTS `tb_notification`;

CREATE TABLE `tb_notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'key id',
  `bus_id` bigint(20) DEFAULT NULL COMMENT 'business id',
  `content` varchar(500) DEFAULT NULL COMMENT 'detail',
  `add_date` datetime DEFAULT NULL COMMENT 'add date',
  `add_user_id` bigint(20) DEFAULT NULL COMMENT 'add user id',
  `type` tinyint(4) DEFAULT '0' COMMENT ' 0 : information , 1: notify all',
  `status` tinyint(4) DEFAULT '1' COMMENT '0 : unavailable , 1 : available',
  `is_main` tinyint(4) DEFAULT '0' COMMENT '1 : main  ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `tb_notification` */

insert  into `tb_notification`(`id`,`bus_id`,`content`,`add_date`,`add_user_id`,`type`,`status`,`is_main`) values (11,10,'水下机器人紧急筹划中。。。','2015-10-11 10:18:53',1,0,1,1);

/*Table structure for table `tb_project` */

DROP TABLE IF EXISTS `tb_project`;

CREATE TABLE `tb_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'key id',
  `name` varchar(50) NOT NULL COMMENT 'project name',
  `description` varchar(500) DEFAULT NULL COMMENT 'description',
  `sponsor` bigint(20) DEFAULT NULL COMMENT 'who upload the resource',
  `upload_date` datetime DEFAULT NULL COMMENT 'upload date',
  `checker` bigint(20) DEFAULT NULL COMMENT 'who check the resource',
  `check_date` datetime DEFAULT NULL COMMENT 'check date',
  `status` tinyint(4) DEFAULT NULL COMMENT 'passed , waiting , failure',
  `check_msg` varchar(500) DEFAULT NULL COMMENT 'check message',
  `begin_datetime` datetime DEFAULT NULL COMMENT 'what time the project begin in plan',
  `end_datetime` datetime DEFAULT NULL COMMENT 'what time the project end in plan',
  `attender_limit` int(11) DEFAULT NULL COMMENT 'attender limit',
  `plan_doc` varchar(300) DEFAULT NULL COMMENT 'plan document',
  `foster_doc` varchar(300) DEFAULT NULL COMMENT 'foster plan document',
  `talents_doc` varchar(300) DEFAULT NULL COMMENT 'talents document',
  `process_status` tinyint(4) DEFAULT NULL COMMENT 'project handle status',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `tb_project` */

insert  into `tb_project`(`id`,`name`,`description`,`sponsor`,`upload_date`,`checker`,`check_date`,`status`,`check_msg`,`begin_datetime`,`end_datetime`,`attender_limit`,`plan_doc`,`foster_doc`,`talents_doc`,`process_status`) values (10,'水下机器人项目','水下机器人是海洋等水下开发作业中的重要工具，在海洋石油工程、水下采矿、水产养殖、水下维修、水下搜寻、水下科研等方面有重要应用价值。随着中国海洋强国战略的实施，水下机器人将得到越来越广泛的应用，其重要性也必将越来越突出，因此水下机器人的研制具有重大科学技术价值和经济价值。水下机器人根据运行方式分为自治型（AUV）（无缆自航）和遥控型（ROV）（缆绳控制），AUV通过安装在机器人上的计算机自动控制，而ROV通过线缆连接到水面，由操作人员在水面控制。这两种机器人都具有广泛的应用价值，其中水下机器人密封设计、编程控制技术等是其核心技术，是制约先进水下机器人研制的瓶颈。本项目将对其展开深入系统的科学研究，形成切实可行的技术文件，并完成缆绳控制模型样机的研制。该项目旨在突破水下机器人研制的核心技术，并探索出一套新型、高效的产学研模式，因此具有重要的工业价值和社会效益。',2,'2015-09-13 08:26:58',1,'2015-09-13 08:28:07',4,NULL,'2011-12-12 00:00:00','2010-12-12 00:00:00',12,'3b159984-b372-4bd7-94c0-196dffc1ad45_plandoc','3b159984-b372-4bd7-94c0-196dffc1ad45_fosterdoc','3b159984-b372-4bd7-94c0-196dffc1ad45_talentsdoc',NULL);

/*Table structure for table `tb_project_attender` */

DROP TABLE IF EXISTS `tb_project_attender`;

CREATE TABLE `tb_project_attender` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT 'prorject id',
  `attender_id` bigint(20) DEFAULT NULL COMMENT 'attender id',
  `apply_date` datetime DEFAULT NULL COMMENT 'create date time',
  `role` tinyint(4) DEFAULT NULL COMMENT 'attender role',
  `state` tinyint(4) DEFAULT NULL COMMENT 'state , 1 apply , 2 : working 3:completed ',
  `msg` varchar(500) DEFAULT NULL COMMENT 'failure inforamtion',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_project_attender` */

/*Table structure for table `tb_project_resource` */

DROP TABLE IF EXISTS `tb_project_resource`;

CREATE TABLE `tb_project_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'key id',
  `name` varchar(50) NOT NULL COMMENT 'resource name',
  `res_desc` varchar(500) DEFAULT NULL COMMENT 'resource description',
  `doc_name` varchar(200) NOT NULL COMMENT 'file name , including the doc , swf ,image',
  `doc_floder` varchar(200) DEFAULT NULL COMMENT 'where the file store .',
  `star` tinyint(4) DEFAULT '0' COMMENT 'level',
  `upload_date` datetime DEFAULT NULL COMMENT 'upload time',
  `uploader` bigint(20) DEFAULT NULL COMMENT 'who upload',
  `project_id` bigint(20) DEFAULT NULL COMMENT 'who belong to ',
  `label` varchar(50) DEFAULT NULL COMMENT 'some tag  ',
  `click_times` int(11) DEFAULT NULL COMMENT 'click it times',
  `download_times` int(11) DEFAULT NULL COMMENT 'download times',
  `status` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_project_resource` */

insert  into `tb_project_resource`(`id`,`name`,`res_desc`,`doc_name`,`doc_floder`,`star`,`upload_date`,`uploader`,`project_id`,`label`,`click_times`,`download_times`,`status`) values (1,'走到哪','打打','5dc13ee8-6cb0-43f8-a4d7-5f043a850da5','2015-09-11/',0,'2015-09-11 17:21:11',1,3,NULL,0,NULL,3),(2,'走到哪','打打','eab67cb5-be20-41cb-a25a-6ddab3cf793d','2015-09-11/',0,'2015-09-11 17:28:50',1,3,NULL,0,NULL,3),(3,'走到哪','打打','143e43a4-b658-471f-a389-cc182a32035e','2015-09-11/',0,'2015-09-11 17:30:43',1,3,NULL,0,NULL,3),(4,'走到哪','打打','46386cd7-dd14-4bf3-af20-1e56017ab0f9','2015-09-11/',0,'2015-09-11 17:31:55',1,3,NULL,0,NULL,3),(5,'走到哪','打打','28a05516-b99d-497a-9e78-9cae1ee7c3bb','2015-09-11/',0,'2015-09-11 17:44:20',1,3,NULL,0,NULL,3),(6,'走到哪','打打','7d1c9263-e67f-4f3f-96e9-38e19dd1eaf8','2015-09-11/',0,'2015-09-11 17:49:56',1,3,NULL,0,NULL,3),(7,'走到哪','打打','0986d773-c7f1-4ddb-8f75-de47450753b8','2015-09-11/',0,'2015-09-11 17:57:58',1,3,NULL,0,NULL,3),(8,'我的文档信息','打打','9f1fad56-dd88-4bf9-a296-a333be0c7358','2015-09-13/',0,'2015-09-13 09:52:11',1,10,NULL,0,NULL,3);

/*Table structure for table `tb_recorder` */

DROP TABLE IF EXISTS `tb_recorder`;

CREATE TABLE `tb_recorder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
  `resid` bigint(20) DEFAULT NULL COMMENT 'resource id',
  `downloaderId` bigint(20) DEFAULT NULL COMMENT 'who download id',
  `downloader` varchar(50) DEFAULT NULL COMMENT 'who download',
  `downloadDate` datetime DEFAULT NULL COMMENT 'download date time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_recorder` */

/*Table structure for table `tb_resources` */

DROP TABLE IF EXISTS `tb_resources`;

CREATE TABLE `tb_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
  `resName` varchar(200) DEFAULT NULL COMMENT 'resouce name ',
  `resDescribe` varchar(1000) DEFAULT '' COMMENT 'resource description',
  `resLabel` varchar(200) DEFAULT NULL COMMENT 'resource label',
  `resPath` varchar(500) DEFAULT NULL COMMENT 'resource store path',
  `pdfPath` varchar(500) DEFAULT NULL COMMENT 'pdf store path',
  `swfPath` varchar(500) DEFAULT NULL COMMENT 'swf store path',
  `resFormat` varchar(50) DEFAULT NULL COMMENT 'resource format',
  `resSrc` varchar(200) DEFAULT '' COMMENT 'resource src',
  `resType` tinyint(4) DEFAULT '1' COMMENT 'type',
  `dicType` tinyint(4) DEFAULT '1' COMMENT 'dic type',
  `uploaderId` bigint(20) DEFAULT NULL COMMENT 'who commit',
  `uploader` varchar(50) DEFAULT NULL COMMENT 'who commit',
  `uploadDate` datetime DEFAULT NULL COMMENT 'commit datetime',
  `modifier` varchar(50) DEFAULT '-1' COMMENT 'who modify ',
  `modifyDate` datetime DEFAULT NULL COMMENT 'modify date time',
  `clickTimes` int(11) DEFAULT '0' COMMENT 'click times',
  `downloadTimes` int(11) DEFAULT '0' COMMENT 'download times',
  `resStar` tinyint(4) DEFAULT '0' COMMENT 'document class',
  `resStatus` tinyint(4) DEFAULT NULL COMMENT 'resource state',
  `pState` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `tb_resources` */

insert  into `tb_resources`(`id`,`resName`,`resDescribe`,`resLabel`,`resPath`,`pdfPath`,`swfPath`,`resFormat`,`resSrc`,`resType`,`dicType`,`uploaderId`,`uploader`,`uploadDate`,`modifier`,`modifyDate`,`clickTimes`,`downloadTimes`,`resStar`,`resStatus`,`pState`) values (1,'我的文档','function  大尺度','','21-08-44.swf',NULL,NULL,NULL,'Functional-Design Spec Template070830V20.doc',1,1,8,NULL,'2015-06-04 18:17:04','-1',NULL,31,0,0,4,NULL),(2,'我的report','好东西分享你知道的','',NULL,NULL,NULL,NULL,'Customer Care SP-Report .xlsx',2,2,8,'xiezonghuago@163.com','2015-06-05 21:08:14','-1',NULL,4,0,0,3,NULL),(3,'我的上传信息','大家发的时间放假爱上对方','',NULL,NULL,NULL,NULL,'2015-Zonghua.Xie-FTG-evaluate-engr.xls',1,1,8,'xiezonghuago@163.com','2015-06-05 21:20:46','-1',NULL,5,0,0,1,NULL),(4,'开始发额','的麻烦尖端科技飞机飞机','',NULL,NULL,NULL,NULL,'2015-Zonghua.Xie-FTG-evaluate-engr.xls',1,1,8,'xiezonghuago@163.com','2015-06-05 21:22:42','-1',NULL,4,0,0,1,NULL),(5,'Functional','spec','','20155811/',NULL,NULL,'DOC','d9d988f2-519a-4eda-9d19-7b368d43f548',2,1,1,'xiezonghuago@163.com','2015-06-11 18:58:08','-1',NULL,0,0,0,3,NULL),(6,'Functional','spec','','20155911/',NULL,NULL,'DOCX','6e9d475b-3d02-496e-b03c-f9a9f0f2003e',2,1,1,'xiezonghuago@163.com','2015-06-11 18:59:15','-1',NULL,0,0,0,3,NULL),(7,'asbw','asw','','20150511/',NULL,NULL,'DOC','04bc169d-4bf1-48c5-82fa-5780a5d46691',2,1,1,'xiezonghuago@163.com','2015-06-11 19:05:54','-1',NULL,0,0,0,3,NULL),(8,'spec','我','','20154311/',NULL,NULL,'DOC','09259e23-243a-49b2-8d22-9086301b5a8c',2,1,1,'xiezonghuago@163.com','2015-06-11 20:43:47','-1',NULL,3,0,0,3,NULL),(9,'spec','我','','20155311/',NULL,NULL,'DOC','9a124e73-8854-44b9-b08c-7528263399a5',2,1,1,'xiezonghuago@163.com','2015-06-11 20:53:40','-1',NULL,0,0,0,3,NULL),(10,'spec','我','','20155911/',NULL,NULL,'DOC','291b880f-9cae-4636-bd6f-3b6cde069a47',2,1,1,'xiezonghuago@163.com','2015-06-11 20:59:56','-1',NULL,2,0,0,3,NULL),(11,'spec','我','','20150611/',NULL,NULL,'DOC','d5031c1a-12e0-4c5f-9649-ae4ecee02a35',2,1,1,'xiezonghuago@163.com','2015-06-11 21:06:41','-1',NULL,0,0,0,3,NULL),(12,'spec','我','','20151411/',NULL,NULL,'DOC','9f1f350a-429b-4075-9a88-8d5f98dac447',2,1,1,'xiezonghuago@163.com','2015-06-11 21:14:08','-1',NULL,4,0,0,3,NULL),(13,'spec','我','','20151511/',NULL,NULL,'DOC','04677316-e0c6-4e49-a5dd-95ed1b81a9a7',2,1,1,'xiezonghuago@163.com','2015-06-11 21:15:39','-1',NULL,2,0,0,3,1),(14,'spec','我','','2015-06-11/',NULL,NULL,'DOC','07bb838a-378c-4101-9e7c-dc7908b7c201',2,1,1,'xiezonghuago@163.com','2015-06-11 21:47:26','-1',NULL,23,0,0,1,2);

/*Table structure for table `tb_share` */

DROP TABLE IF EXISTS `tb_share`;

CREATE TABLE `tb_share` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
  `resid` int(11) DEFAULT NULL COMMENT 'resource id',
  `sharer_id` bigint(20) DEFAULT NULL COMMENT 'share owner',
  `date` datetime DEFAULT NULL COMMENT 'share time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_share` */

/*Table structure for table `tb_system` */

DROP TABLE IF EXISTS `tb_system`;

CREATE TABLE `tb_system` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'key id',
  `aboutmy` text COMMENT 'about for our information',
  `docupload` text COMMENT 'document upload law information',
  `lxwm` text COMMENT 'connect our ',
  `hyzc` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_system` */

insert  into `tb_system`(`id`,`aboutmy`,`docupload`,`lxwm`,`hyzc`) values (1,'<ul style=\"font-size: medium; white-space: normal; line-height: 14px; list-style: none; font-family: Arial, 宋体;\"><li style=\"line-height: 1.8em; text-indent: 2em;\"><p>迪格学苑旨在成为一个开放、自由、高效、公平的学习研究网络平台。这里有新的学习培养方式，新的认证机制，任何人在任何时间任何地点都能享用这个平台。</p><p>让我们共同参与其中，不久的将来我们将改变完善现有高等教育模式，打造出一个更加理想的大学——那里人人求真，向善，尚美！</p></li></ul><p><br/></p>','<p style=\"font-family: Simsun; font-size: medium; white-space: normal;\">1.点击文档帮助即可明白下载情况</p><p style=\"font-family: Simsun; font-size: medium; white-space: normal;\">2.文档可以免费下载，下载格式有多种方式，如PDF,WORD,PPT,EXCEL等</p><p><br/></p>','<p style=\"font-family: Simsun; font-size: medium; white-space: normal;\">QQ：258675336&nbsp;</p><p style=\"font-family: Simsun; font-size: medium; white-space: normal;\">Email：xiaguangdage@163.com&nbsp;</p><p><br/></p>','<p><span style=\"font-size: medium; white-space: normal; font-family: 宋体, arial, helvetica, clean, sans-serif; line-height: 22px;\">1．填写注册信息后，仔细阅读服务条款及隐私条例并点击“同意以上内容，提交注册信息”按钮，完成注册。</span><br style=\"font-size: medium; white-space: normal; font-family: 宋体, arial, helvetica, clean, sans-serif; line-height: 22px;\"/><br style=\"font-size: medium; white-space: normal; font-family: 宋体, arial, helvetica, clean, sans-serif; line-height: 22px;\"/><span style=\"font-size: medium; white-space: normal; font-family: 宋体, arial, helvetica, clean, sans-serif; line-height: 22px;\">2．登录用户名的要求：</span><br style=\"font-size: medium; white-space: normal; font-family: 宋体, arial, helvetica, clean, sans-serif; line-height: 22px;\"/><span style=\"font-size: medium; white-space: normal; font-family: 宋体, arial, helvetica, clean, sans-serif; line-height: 22px;\">登录用户名一经注册不能更改 请选择您喜欢并能牢记的用户名。用户名必须是6-12位的小写英文字母或数字，但不能使用空格、下划线、小数点，例：tom--12345。&nbsp;</span>\n								\n							</p>');

/*Table structure for table `tb_system_dictionary` */

DROP TABLE IF EXISTS `tb_system_dictionary`;

CREATE TABLE `tb_system_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
  `type_id` tinyint(4) NOT NULL COMMENT 'dict type id ',
  `type_name` varchar(50) NOT NULL COMMENT 'dict type name',
  `type_desc` varchar(500) DEFAULT NULL COMMENT 'business description',
  `superior_id` tinyint(4) DEFAULT NULL COMMENT 'some have parent ',
  `type_code` tinyint(4) NOT NULL COMMENT 'what type in dictionary',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `tb_system_dictionary` */

insert  into `tb_system_dictionary`(`id`,`type_id`,`type_name`,`type_desc`,`superior_id`,`type_code`) values (1,1,'学习','资源类型',NULL,1),(2,2,'研究','资源类型',NULL,1),(3,3,'成才','资源类型',NULL,1),(4,1,'待审核','资源处理',NULL,2),(5,2,'审核未通过','资源处理',NULL,2),(6,3,'审核通过','资源处理',NULL,2),(7,4,'正在处理','资源处理',NULL,2),(8,5,'标题或分类不准确','资源处理',NULL,2),(9,6,'信息不完整','资源处理',NULL,2),(10,7,'系统处理','资源处理',NULL,2),(11,1,'用户','用户类型',NULL,3),(12,100,'管理员','用户类型',NULL,3),(13,101,'超级用户','用户类型',NULL,3),(14,1,'待审核','项目审核状态',NULL,4),(15,2,'审核通过','项目审核状态',NULL,4),(16,3,'审核失败','项目审核状态',NULL,4),(17,4,'启动中','项目执行状态',NULL,4),(18,5,'进行中','项目执行状态',NULL,4),(19,6,'完成','项目执行状态',NULL,4),(20,1,'申请中','项目申请人状态',NULL,6),(21,2,'审核通过，参与中','项目申请人状态',NULL,6),(22,3,'完成','项目申请人状态',NULL,6),(23,4,'拒绝','项目申请人状态',NULL,6),(24,1,'发起人','项目参与者角色类型',NULL,7),(25,2,'参与人','项目参与者角色类型',NULL,7),(26,1,'男','性别',NULL,8),(27,0,'女','性别',NULL,8);

/*Table structure for table `tb_system_user` */

DROP TABLE IF EXISTS `tb_system_user`;

CREATE TABLE `tb_system_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
  `name` varchar(50) NOT NULL COMMENT 'user Name',
  `pet_name` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) NOT NULL COMMENT 'password',
  `resume` varchar(200) DEFAULT NULL COMMENT 'resume',
  `sex` tinyint(4) DEFAULT NULL COMMENT 'boy or girl',
  `email` varchar(50) DEFAULT '' COMMENT 'email address',
  `sfz` varchar(50) DEFAULT NULL,
  `im` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `regist_time` datetime DEFAULT NULL COMMENT 'sign in time',
  `last_sign_in` datetime DEFAULT NULL COMMENT 'sign off time',
  `point` varchar(50) DEFAULT NULL,
  `prestige` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_system_user` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
  `yhm` varchar(50) NOT NULL COMMENT 'user Name',
  `pwd` varchar(50) NOT NULL COMMENT 'password',
  `jianjie` varchar(200) DEFAULT NULL COMMENT 'resume',
  `sex` tinyint(4) DEFAULT NULL COMMENT 'boy or girl',
  `email` varchar(50) DEFAULT '' COMMENT 'email address',
  `sfz` varchar(50) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `zcsj` datetime DEFAULT NULL COMMENT 'sign in time',
  `lastdlsj` datetime DEFAULT NULL COMMENT 'sign off time',
  `nic` varchar(50) DEFAULT NULL,
  `jifen` varchar(50) DEFAULT NULL,
  `shengwang` varchar(50) DEFAULT NULL,
  `yhtp` varchar(50) DEFAULT NULL,
  `lev` varchar(50) DEFAULT NULL,
  `levName` varchar(50) DEFAULT NULL,
  `csrq` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `JiGuan` varchar(50) DEFAULT NULL,
  `JDYuanXiao` varchar(50) DEFAULT NULL,
  `ZhuanYe` varchar(50) DEFAULT NULL,
  `JKZK` varchar(50) DEFAULT NULL,
  `EnglishLevel` varchar(50) DEFAULT NULL,
  `Edu` varchar(50) DEFAULT NULL,
  `ZYJN` varchar(50) DEFAULT NULL,
  `GZJH` varchar(50) DEFAULT NULL,
  `role` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`yhm`,`pwd`,`jianjie`,`sex`,`email`,`sfz`,`qq`,`phone`,`zcsj`,`lastdlsj`,`nic`,`jifen`,`shengwang`,`yhtp`,`lev`,`levName`,`csrq`,`name`,`JiGuan`,`JDYuanXiao`,`ZhuanYe`,`JKZK`,`EnglishLevel`,`Edu`,`ZYJN`,`GZJH`,`role`) values (1,'digxy2014@163.com','e9443557231010c6db2ffafcf355a151',NULL,NULL,'digxy2014@163.com',NULL,NULL,NULL,'2015-11-01 21:19:16',NULL,'digxyAdmin',NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,101),(2,'xiezonghuago@163.com','510ecc7ca1afcb796ce303343f48846','我的单位',NULL,'xiezonghuago@163.com','430421198710109431','452973805','15210368613','2015-06-06 21:21:09',NULL,'野火',NULL,NULL,'1.jpg','2',NULL,'1987-10-10 00:00:00','谢宗华','湘','发生地方','计算机','的','4','大学','打的 ','大尺度',100);

/*Table structure for table `tb_yqLink` */

DROP TABLE IF EXISTS `tb_yqLink`;

CREATE TABLE `tb_yqLink` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `yqtitle` varchar(100) DEFAULT NULL,
  `yqhref` varchar(200) DEFAULT NULL,
  `yqxh` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_yqLink` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
