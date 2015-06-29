DROP DATABASE IF EXISTS digxy; 

CREATE DATABASE digxy DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE digxy;

/**
*	collector information
**/
DROP TABLE if exists tb_collection;
CREATE TABLE tb_collection(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'key id',
	resid BIGINT NULL COMMENT 'resource id',
	collection_id BigInt null comment 'collector id' ,  
	collectioner VARCHAR(50) NULL COMMENT 'collector',
	collectionDate DATETIME NULL COMMENT 'collect date time',
	PRIMARY KEY(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
* one user be attentive to the other user.
**/
DROP TABLE if exists tb_guanzhu;
CREATE TABLE tb_guanzhu(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'key id',
	user_id bigint not null  comment 'attentive user id' ,
	follower_id bigint not null comment 'follower user id' , 
	`date` DATETIME NULL COMMENT 'attentive time',
	PRIMARY KEY(id) 
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 /**
 * key word for resource
 **/
 DROP TABLE if exists tb_keyword;
 CREATE TABLE tb_keyword(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	keywords VARCHAR(200) NULL COMMENT 'key word',
	PRIMARY KEY(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * use sender mail for communication .
 */

DROP TABLE IF EXISTS tb_message;
CREATE TABLE tb_message(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	sender_id BIGINT NULL COMMENT 'sender id' , 
	sender VARCHAR(50) NULL COMMENT ' sender',
	receiver_id BIGINT NULL COMMENT 'receiver id' ,
	receiver VARCHAR(50) NULL COMMENT 'email receiver',
	title VARCHAR(200) NULL COMMENT 'email title',
	content TEXT NULL COMMENT 'email content',
	add_date DATETIME NULL COMMENT 'email create time',
	`status` TINYINT NULL  DEFAULT 0  COMMENT'',
	sender_mark TINYINT NULL DEFAULT 0 COMMENT '',
	receiver_mark TINYINT NULL DEFAULT 0 COMMENT '',
	PRIMARY KEY(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * project 
 */
DROP TABLE IF EXISTS tb_project;
CREATE TABLE tb_project(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	res_id BIGINT NULL COMMENT 'resource id',
	attender_id BIGINT NULL COMMENT 'attender id',
	apply_date DATETIME NULL COMMENT 'create date time',
	role TINYINT NULL COMMENT 'attender role' ,  
	state TINYINT NULL COMMENT 'state , 1 apply , 2 : working 3:completed ',
	msg VARCHAR(500) NULL COMMENT 'failure inforamtion',
	PRIMARY KEY(id) 
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/**
 * Record who download and time.
 */
DROP TABLE if exists tb_recorder;
CREATE TABLE tb_recorder(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	resid BIGINT NULL COMMENT 'resource id',
	downloaderId BIGINT NULL COMMENT 'who download id',  
	downloader VARCHAR(50) NULL COMMENT 'who download',
	downloadDate DATETIME NULL COMMENT 'download date time',
	PRIMARY KEY(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * The resource information
 */
DROP TABLE if exists tb_resources;
CREATE TABLE tb_resources(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	resName VARCHAR(200) NULL COMMENT 'resouce name ',
	resDescribe VARCHAR(1000) NULL DEFAULT '' COMMENT 'resource description',
	resLabel VARCHAR(200) NULL COMMENT 'resource label',
	resPath VARCHAR(500) NULL COMMENT 'resource store path',
	pdfPath VARCHAR(500) NULL COMMENT 'pdf store path',
	swfPath VARCHAR(500) NULL COMMENT 'swf store path',
	resFormat VARCHAR(50) NULL COMMENT 'resource format',
	resSrc VARCHAR(200) NULL DEFAULT '' COMMENT 'resource src',
	resType tinyint NULL DEFAULT '1' COMMENT 'type',
	dicType tinyint NULL DEFAULT '1' COMMENT 'dic type',
	uploaderId BIGINT NULL COMMENT 'who commit',
	uploader VARCHAR(50) NULL COMMENT 'who commit',
	uploadDate DATETIME NULL COMMENT 'commit datetime',
	`modifier` VARCHAR(50) NULL DEFAULT '-1' COMMENT 'who modify ',
	modifyDate DATETIME NULL COMMENT 'modify date time',
	clickTimes INT NULL DEFAULT 0 COMMENT 'click times',
	downloadTimes INT null Default 0 comment 'download times',
	resStar tinyint NULL DEFAULT 0 COMMENT 'document class',
	resStatus tinyint NULL COMMENT 'resource state',
	pState INT NULL COMMENT '',
	PRIMARY KEY(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 *  The resource revert
 */
DROP TABLE if exists tb_revert;
DROP TABLE if exists tb_comment;
CREATE TABLE tb_comment(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	res_id BIGINT NULL COMMENT 'resource id',
	commenter_id BIGINT NULL COMMENT 'who comment',
	commenter VARCHAR(50) NULL COMMENT ' who revert',
	comment_date DATETIME NULL COMMENT 'comment time',
	content TEXT NULL COMMENT 'content',
	PRIMARY KEY(id) 
);

/**
 * who share the resource
 */
DROP TABLE if exists tb_share;
CREATE TABLE tb_share(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	resid INT NULL COMMENT 'resource id',
	sharer_id BIGINT comment 'share owner',
	`date` DATETIME NULL COMMENT 'share time',
	PRIMARY KEY(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * The site system information
 */
DROP TABLE if exists tb_system;
CREATE TABLE tb_system(
	id INT NOT NULL AUTO_INCREMENT COMMENT 'key id' , 
	aboutmy TEXT NULL COMMENT 'about for our information',
	docupload TEXT NULL COMMENT 'document upload law information',
	lxwm TEXT NULL COMMENT 'connect our ',
	hyzc TEXT NULL COMMENT '',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * The user information 
 */
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	yhm VARCHAR(50) NOT NULL COMMENT 'user Name',
	pwd VARCHAR(50) NOT NULL COMMENT 'password',
	jianjie VARCHAR(200) NULL COMMENT 'resume',
	sex TINYINT NULL COMMENT 'boy or girl',
	email VARCHAR(50) NULL DEFAULT '' COMMENT 'email address',
	sfz VARCHAR(50) NULL COMMENT '',
	qq VARCHAR(50) NULL ,
	phone VARCHAR(50) NULL,
	zcsj DATETIME NULL COMMENT 'sign in time',
	lastdlsj DATETIME NULL COMMENT 'sign off time',
	nic VARCHAR(50) NULL COMMENT '',
	jifen VARCHAR(50) NULL,
	shengwang VARCHAR(50) NULL,
	yhtp VARCHAR(50) NULL,
	lev VARCHAR(50) NULL,
	levName VARCHAR(50) NULL,
	csrq DATETIME NULL,
	`name` VARCHAR(50) NULL,
	JiGuan VARCHAR(50) NULL,
	JDYuanXiao VARCHAR(50) NULL,
	ZhuanYe VARCHAR(50) NULL,
	JKZK VARCHAR(50) NULL,
	EnglishLevel VARCHAR(50) NULL,
	Edu VARCHAR(50) NULL,
	ZYJN VARCHAR(50) NULL,
	GZJH VARCHAR(50) NULL,
	role TINYINT NULL COMMENT '',
	PRIMARY KEY(id) 
)ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_system_dictionary;
CREATE TABLE tb_system_dictionary(
	id INTEGER NOT NULL AUTO_INCREMENT COMMENT 'KEY ID', 
	type_id TINYINT NOT NULL COMMENT 'dict type id ',
	type_name VARCHAR(50) NOT NULL COMMENT 'dict type name' ,
	type_desc VARCHAR(500) COMMENT 'business description' , 
	superior_id TINYINT COMMENT 'some have parent ' , 
	type_code TINYINT NOT NULL COMMENT 'what type in dictionary' ,
	PRIMARY KEY (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/* resource type */
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 1 , '学习' , '资源类型' , 1);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 2 , '研究' , '资源类型' , 1);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 3 , '成才' , '资源类型' , 1);

/* resource audit status */
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 1 , '审核通过' , '资源处理' , 2);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 2 , '审核未通过' , '资源处理' , 2);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 3 , '待审核' , '资源处理' , 2);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 4 , '正在处理' , '资源处理' , 2);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 5 , '标题或分类不准确' , '资源处理' , 2);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 6 , '信息不完整' , '资源处理' , 2);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 7 , '系统处理' , '资源处理' , 2);

/* user type for manager */
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 1 , '用户' , '用户类型' , 3);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 100 , '管理员' , '用户类型' , 3);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 101 , '超级用户' , '用户类型' , 3);
											 
/* project status */
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 1 , '启动中' , '项目状态' , 4);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 2 , '进行中' , '项目状态' , 4);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 3 , '完成' , '项目状态' , 4);


/* project applyer status */
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 1 , '申请中' , '项目申请人状态' , 5);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 2 , '审核通过，参与中' , '项目申请人状态' , 5);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 3 , '完成' , '项目申请人状态' , 5);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 4 , '拒绝' , '项目申请人状态' , 5);

/* project attender role */
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 1 , '发起人' , '项目参与者角色类型', 6);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 2 , '参与人' , '项目参与者角色类型' , 6);

/* user sex */
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 1 , '男' , '性别', 7);
INSERT INTO tb_system_dictionary(type_id , type_name , type_desc , type_code)  VALUES( 0 , '女' , '性别' , 7);

DROP TABLE if exists tb_system_user;
CREATE TABLE tb_system_user(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	name VARCHAR(50) NOT NULL COMMENT 'user Name',
	pet_name VARCHAR(50) NULL COMMENT '',
	pwd VARCHAR(50) NOT NULL COMMENT 'password',
	resume VARCHAR(200) NULL COMMENT 'resume',
	sex tinyint NULL COMMENT 'boy or girl',
	email VARCHAR(50) NULL DEFAULT '' COMMENT 'email address',
	sfz VARCHAR(50) NULL COMMENT '',
	im VARCHAR(50) NULL ,
	phone VARCHAR(50) NULL,
	regist_time DATETIME NULL COMMENT 'sign in time',
	last_sign_in DATETIME NULL COMMENT 'sign off time',
	point VARCHAR(50) NULL,
	prestige VARCHAR(50) NULL,
	PRIMARY KEY(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * friend link
 */
DROP TABLE if exists tb_yqLink;
CREATE TABLE tb_yqLink(
	id BIGINT NOT NULL AUTO_INCREMENT,
	yqtitle VARCHAR(100) NULL,
	yqhref VARCHAR(200) NULL,
	yqxh INT NULL,
	PRIMARY KEY(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/**
 * expert information 
 */
DROP TABLE if exists tb_expert;
CREATE TABLE tb_expert(
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NULL,
	qq VARCHAR(50) NULL,
	profile varchar(600) NULL,
	add_date DATETIME NULL,
	PRIMARY KEY(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

