
/* Drop Tables */

DROP TABLE phonebook CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE phonebook
(
	pb_uid number NOT NULL,
	pb_name varchar2(40) NOT NULL,
	pb_phonenum varchar2(40),
	pb_memo clob,
	pb_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pb_uid)
);

-- 시퀀스 객체도 생성하자!!

DROP SEQUENCE phonebook_seq;
CREATE SEQUENCE phonebook_seq;

SELECT *FROM PHONEBOOK ;

SELECT count(*) CNT FROM TEST_MEMBER ; --현재 테이블에 있는 모든 레코드 개수 출력!!!!
SELECT max(MB_NO) "MAX" FROM TEST_MEMBER ; -- mb_no의 최댓값
SELECT min(MB_NO) "MIN" FROM TEST_MEMBER ; -- mb_no의 최솟값

SELECT COUNT(*) cnt FROM PHONEBOOK ;

SELECT * FROM PHONEBOOK ORDER BY PB_UID DESC ;
