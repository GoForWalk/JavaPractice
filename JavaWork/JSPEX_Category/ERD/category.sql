
/* Drop Triggers */

DROP TRIGGER TRI_test_category_ca_uid;



/* Drop Tables */

DROP TABLE test_category CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_test_category_ca_uid;




/* Create Sequences */

CREATE SEQUENCE SEQ_test_category_ca_uid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE test_category
(
	ca_uid number NOT NULL,
	ca_name varchar2(30) NOT NULL,
	ca_parent number,
	-- 노출되는 순서 (바꾸기 가능 -> 우선순위가 먼저 나온다)
	-- 
	ca_order number DEFAULT 1,
	ca_depth number DEFAULT 1,
	PRIMARY KEY (ca_uid)
);



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_test_category_ca_uid BEFORE INSERT ON test_category
FOR EACH ROW
BEGIN
	SELECT SEQ_test_category_ca_uid.nextval
	INTO :new.ca_uid
	FROM dual;
END;






/* Comments */

COMMENT ON COLUMN test_category.ca_order IS '노출되는 순서 (바꾸기 가능 -> 우선순위가 먼저 나온다)
';



