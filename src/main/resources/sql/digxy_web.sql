DROP DATABASE IF EXISTS digxy; 

CREATE DATABASE digxy;

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
);

/**
 * use sender mail for communication .
 */
DROP TABLE if exists tb_mail;
CREATE TABLE tb_mail(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	sendUser VARCHAR(50) NULL COMMENT 'email sender',
	receiveUser VARCHAR(50) NULL COMMENT 'email receiver',
	emailTitle VARCHAR(200) NULL COMMENT 'email title',
	emailContent TEXT NULL COMMENT 'email content',
	`date` DATETIME NULL COMMENT 'email create time',
	bj INT NULL COMMENT '',
	sendDelBJ INT NULL COMMENT '',
	receiveDelBJ INT NULL COMMENT '',
	PRIMARY KEY(id) 
);

/**
 * project 
 */
DROP TABLE if exists tb_project;
CREATE TABLE tb_project(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	resid BIGINT NULL COMMENT 'resource id',
	yhm VARCHAR(50) NULL COMMENT '',
	`date` DATETIME NULL COMMENT 'create date time',
	state INT NULL COMMENT 'state',
	PRIMARY KEY(id) 
);

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
);

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
CREATE TABLE tb_revert(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	resid INT NULL COMMENT 'resource id',
	revertName VARCHAR(50) NULL COMMENT ' who revert',
	revertDate DATETIME NULL COMMENT 'revert time',
	revertContent TEXT NULL COMMENT 'revert content',
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
);

/**
 * The site system information
 */
DROP TABLE if exists tb_system;
CREATE TABLE tb_system(
	aboutmy TEXT NULL COMMENT 'about for our information',
	docupload TEXT NULL COMMENT 'document upload law information',
	lxwm TEXT NULL COMMENT 'connect our ',
	hyzc TEXT NULL COMMENT ''
);

/**
 * The user information 
 */
DROP TABLE if exists tb_user;
CREATE TABLE tb_user(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'KEY ID',
	yhm VARCHAR(50) NOT NULL COMMENT 'user Name',
	pwd VARCHAR(50) NOT NULL COMMENT 'password',
	jianjie VARCHAR(200) NULL COMMENT 'resume',
	sex tinyint NULL COMMENT 'boy or girl',
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
	PRIMARY KEY(id) 
);

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
);


/**
 * expert information 
 */
DROP TABLE if exists tb_zhuanjia;
CREATE TABLE tb_zhuanjia(
	id BIGINT NOT NULL AUTO_INCREMENT,
	zjname VARCHAR(50) NULL,
	zjqq VARCHAR(50) NULL,
	zjjianjie TEXT NULL,
	PRIMARY KEY(id) 
);

