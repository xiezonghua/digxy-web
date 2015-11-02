CREATE DATABASE digxy;

USE digxy;

/**
*	collector information
**/
CREATE TABLE tb_Collection(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'key id',
	resid BIGINT NULL COMMENT 'resource id',
	Collectioner VARCHAR(50) NULL COMMENT 'collector',
	CollectionDate DATETIME NULL COMMENT 'collect date time',
	PRIMARY KEY(id) 
);

/**
* one user be attentive to the other user.
**/
CREATE TABLE tb_guanzhu(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'key id',
	yhm VARCHAR(50) NULL COMMENT '',
	gzyhm VARCHAR(50) NULL COMMENT '',
	DATE DATETIME NULL COMMENT 'attentive time',
	PRIMARY KEY(id) 
 );
 
 /**
 * key word for resource
 **/
 CREATE TABLE tb_keyword(
	id BIGINT NOT NULL AUTO_INCREMENT comment 'KEY ID',
	keywords VARCHAR(200) NULL comment 'key word',
	PRIMARY KEY(id) 
);

/**
 * use sender mail for communication .
 */
CREATE TABLE tb_mail(
	id BIGINT NOT NULL AUTO_INCREMENT comment 'KEY ID',
	sendUser VARCHAR(50) NULL comment 'email sender',
	receiveUser VARCHAR(50) NULL comment 'email receiver',
	emailTitle VARCHAR(200) NULL comment 'email title',
	emailContent TEXT NULL comment 'email content',
	date DATETIME NULL comment 'email create time',
	bj INT NULL comment '',
	sendDelBJ INT NULL comment '',
	receiveDelBJ INT NULL comment '',
	PRIMARY KEY(id) 
)

/**
 * project 
 */
CREATE TABLE tb_project(
	id BIGINT NOT NULL AUTO_INCREMENT comment 'KEY ID',
	resid BIGINT NULL comment 'resource id',
	yhm VARCHAR(50) NULL comment '',
	date DATETIME NULL comment 'create date time',
	state INT NULL comment 'state',
	PRIMARY KEY(id) 
);

/**
 * Record who download and time.
 */
CREATE TABLE tb_recorder(
	id BIGINT NOT NULL AUTO_INCREMENT comment 'KEY ID',
	resid BIGINT NULL comment 'resource id',
	downloader VARCHAR(50) NULL comment 'who download',
	downloadDate DATETIME NULL DEFAULT getdate() comment 'download date time',
	PRIMARY KEY(id) 
);

/**
 * The resource information
 */
CREATE TABLE tb_resource(
	id BIGINT NOT NULL AUTO_INCREMENT comment 'KEY ID',
	resName VARCHAR(200) NULL comment 'resouce name ',
	resDescribe VARCHAR(1000) NULL DEFAULT '' comment 'resource description',
	resLabel VARCHAR(200) NULL comment 'resource label',
	resPath VARCHAR(500) NULL comment 'resource store path',
	pdfPath VARCHAR(500) NULL comment 'pdf store path',
	swfPath VARCHAR(500) NULL comment 'swf store path',
	resFormat VARCHAR(50) NULL comment 'resource format',
	resSrc VARCHAR(200) NULL DEFAULT '' comment 'resource src',
	resType VARCHAR(50) NULL DEFAULT '1' comment 'type',
	dicType VARCHAR(50) NULL DEFAULT '1' comment 'dic type',
	uploader VARCHAR(50) NULL comment 'who commit',
	uploadDate DATETIME NULL DEFAULT getdate() comment 'commit datetime',
	modifier VARCHAR(50) NULL DEFAULT '-1' comment 'who modify ',
	modifyDate DATETIME NULL DEFAULT getdate() comment 'modify date time',
	clickTimes INT NULL DEFAULT 0 comment 'click times',
	resStar INT NULL DEFAULT 0 comment 'document class',
	resState INT NULL comment 'resource state',
	pState INT NULL comment '',
	PRIMARY KEY(id) 
);

/**
 *  The resource revert
 */
CREATE TABLE tb_revert(
	id BIGINT NOT NULL AUTO_INCREMENT comment 'KEY ID',
	resid INT NULL comment 'resource id',
	revertName VARCHAR(50) NULL comment ' who revert',
	revertDate DATETIME NULL comment 'revert time',
	revertContent TEXT NULL comment 'revert content',
	PRIMARY KEY(id) 
);

/**
 * who share the resource
 */
CREATE TABLE tb_share(
	id BIGINT NOT NULL AUTO_INCREMENT comment 'KEY ID',
	resid INT NULL comment 'resource id',
	yhm VARCHAR(50) NULL comment 'user name',
	date DATETIME NULL comment 'share time',
	PRIMARY KEY(id) 
);

/**
 * The site system information
 */
CREATE TABLE tb_system(
	aboutmy TEXT NULL comment 'about for our information',
	docupload TEXT NULL comment 'document upload law information',
	lxwm TEXT NULL comment 'connect our ',
	hyzc TEXT NULL comment ''
);

/**
 * The user information 
 */
CREATE TABLE tb_user(
	id BIGINT NOT NULL AUTO_INCREMENT comment 'KEY ID',
	yhm VARCHAR(50) NOT NULL comment 'user Name',
	pwd VARCHAR(50) NOT NULL comment 'password',
	jianjie VARCHAR(200) NULL comment 'resume',
	sex INT NULL comment 'boy or girl',
	email VARCHAR(50) NULL DEFAULT '' comment 'email address',
	sfz VARCHAR(50) NULL comment '',
	qq VARCHAR(50) NULL ,
	phone VARCHAR(50) NULL,
	zcsj DATETIME NULL comment 'sign in time',
	lastdlsj DATETIME NULL comment 'sign off time',
	nic VARCHAR(50) NULL comment '',
	jifen VARCHAR(50) NULL,
	shengwang VARCHAR(50) NULL,
	yhtp VARCHAR(50) NULL,
	lev VARCHAR(50) NULL,
	LevName VARCHAR(50) NULL,
	csrq DATETIME NULL,
	NAME VARCHAR(50) NULL,
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
CREATE TABLE tb_yqLink(
	id INT IDENTITY(1,1) NOT NULL,
	yqtitle VARCHAR(100) NULL,
	yqhref VARCHAR(200) NULL,
	yqxh INT NULL,
	PRIMARY KEY(id) 
);


/**
 * expert information 
 */
CREATE TABLE tb_zhuanjia(
	id BIGINT NOT NULL AUTO_INCREMENT,
	zjname VARCHAR(50) NULL,
	zjqq VARCHAR(50) NULL,
	zjjianjie TEXT NULL,
	PRIMARY KEY(id) 
);

