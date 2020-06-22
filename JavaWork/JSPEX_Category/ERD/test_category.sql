
/* Drop Tables */

DROP TABLE test_category CASCADE CONSTRAINTS;




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



/* Comments */

COMMENT ON COLUMN test_category.ca_order IS '노출되는 순서 (바꾸기 가능 -> 우선순위가 먼저 나온다)
';



