SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS connection_info;
DROP TABLE IF EXISTS User_info;




/* Create Tables */

CREATE TABLE connection_info
(
	ciNo int(10) unsigned NOT NULL AUTO_INCREMENT,
	ciName varchar(200) NOT NULL,
	ciUrl varchar(300) NOT NULL,
	ciPort smallint(6) NOT NULL,
	ciDatabase varchar(300) NOT NULL,
	ciUser varchar(100),
	ciPwd varchar(100),
	ciEtc varchar(2000),
	uId int unsigned NOT NULL,
	PRIMARY KEY (ciNo)
);


CREATE TABLE User_info
(
	uNo int unsigned NOT NULL AUTO_INCREMENT,
	uName varchar(300) NOT NULL,
	uId varchar(300) NOT NULL,
	uPwd varchar(300) NOT NULL,
	uEmail varchar(400) NOT NULL,
	PRIMARY KEY (uNo),
	UNIQUE (uId)
);



/* Create Foreign Keys */

ALTER TABLE connection_info
	ADD FOREIGN KEY (uId)
	REFERENCES User_info (uNo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;
