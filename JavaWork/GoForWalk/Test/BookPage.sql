SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS bookcategor;
DROP TABLE IF EXISTS like;
DROP TABLE IF EXISTS bookinfo;
DROP TABLE IF EXISTS bookwantboard;
DROP TABLE IF EXISTS boradQA;
DROP TABLE IF EXISTS replymode;
DROP TABLE IF EXISTS User;




/* Create Tables */

CREATE TABLE bookcategor
(
	booktype varchar(50) NOT NULL,
	booktypename varchar(20) NOT NULL,
	bookid int NOT NULL,
	PRIMARY KEY (booktype)
);


CREATE TABLE bookinfo
(
	bookid int NOT NULL AUTO_INCREMENT,
	bookname varchar(100) NOT NULL,
	bookprice varchar(20) NOT NULL,
	bookimg mediumblob,
	bookcomment text,
	bookregdate date DEFAULT NOW(), SYSDATE() NOT NULL,
	booktype varchar(50),
	-- 0: 안팔림
	-- 
	-- 1: 팔림
	booksold int DEFAULT 0 NOT NULL COMMENT '0: 안팔림

1: 팔림',
	likeid int NOT NULL,
	uid int NOT NULL,
	PRIMARY KEY (bookid)
);


CREATE TABLE bookwantboard
(
	bwuid int NOT NULL AUTO_INCREMENT,
	booktype varchar(30) NOT NULL,
	-- qa : q
	-- rq : 구매
	boardtype varchar(20) NOT NULL COMMENT 'qa : q
rq : 구매',
	bwcontent text,
	bwregdate date DEFAULT NOW(), SYSDATE() NOT NULL,
	uid int NOT NULL,
	replyuid int NOT NULL,
	PRIMARY KEY (bwuid)
);


CREATE TABLE boradQA
(
	qauid int NOT NULL AUTO_INCREMENT,
	uid int NOT NULL,
	qatitle varchar(20) NOT NULL,
	qacontent text,
	qaregdate date DEFAULT NOW(), SYSDATE() NOT NULL,
	-- 0: 미확인
	-- 
	-- 1: 확인
	qacheck int DEFAULT 0 NOT NULL COMMENT '0: 미확인

1: 확인',
	replyuid int NOT NULL,
	uid int NOT NULL,
	replyuid int NOT NULL,
	PRIMARY KEY (qauid)
);


CREATE TABLE like
(
	uid int NOT NULL,
	booklike int NOT NULL,
	likeid int NOT NULL AUTO_INCREMENT,
	bookid int NOT NULL,
	bookid int NOT NULL,
	uid int NOT NULL,
	PRIMARY KEY (likeid)
);


CREATE TABLE replymode
(
	replyuid int NOT NULL AUTO_INCREMENT,
	replycontent text,
	replyregdate date DEFAULT NOW(), SYSDATE() NOT NULL,
	-- qa : q
	-- rq : 구매
	boardtype varchar(20) NOT NULL COMMENT 'qa : q
rq : 구매',
	PRIMARY KEY (replyuid)
);


CREATE TABLE User
(
	uid int NOT NULL AUTO_INCREMENT,
	name varchar(20) NOT NULL,
	phonenum varchar(20),
	address varchar(100),
	-- 0:무궈한
	-- 1 ; 사용자
	-- 
	-- 2: 관리자
	auth int DEFAULT 0 NOT NULL COMMENT '0:무궈한
1 ; 사용자

2: 관리자',
	password varchar(1000) NOT NULL,
	loginid varchar(20) NOT NULL,
	likeid int,
	PRIMARY KEY (uid)
);



/* Create Foreign Keys */

ALTER TABLE bookcategor
	ADD FOREIGN KEY (bookid)
	REFERENCES bookinfo (bookid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE like
	ADD FOREIGN KEY (bookid)
	REFERENCES bookinfo (bookid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE bookwantboard
	ADD FOREIGN KEY (replyuid)
	REFERENCES replymode (replyuid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE boradQA
	ADD FOREIGN KEY (replyuid)
	REFERENCES replymode (replyuid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE bookinfo
	ADD FOREIGN KEY (uid)
	REFERENCES User (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE bookwantboard
	ADD FOREIGN KEY (uid)
	REFERENCES User (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE boradQA
	ADD FOREIGN KEY (uid)
	REFERENCES User (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE like
	ADD FOREIGN KEY (uid)
	REFERENCES User (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



