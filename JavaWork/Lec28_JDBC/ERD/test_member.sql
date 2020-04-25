
/* Drop Tables */

DROP TABLE test_member CASCADE CONSTRAINTS;

SELECT * FROM TEST_MEMBER ORDER BY MB_NO DESC ;

SELECT * FROM T_DEPT2 ;

/* Create Tables */

CREATE TABLE test_member
(
	mb_no number,
	mb_name varchar2(40) NOT NULL,
	mb_birthdate date
);

-- 시퀀스
DROP SEQUENCE TEST_MEMBER_SEQ;
CREATE SEQUENCE test_member_seq;

DELETE FROM TEST_MEMBER ;

