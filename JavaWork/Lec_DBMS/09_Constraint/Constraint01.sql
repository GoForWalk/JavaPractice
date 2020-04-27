-- 제약조건
-- 테이블 생성시 동시에 설정 하기


-- t_dept2.dcode 참조 예정
SELECT * FROM T_DEPT2 ; -- dcode : 0001, 1000 ~

-- #9001)   다음 조건을 만족하는 t_emp3 테이블 생성

--최대 숫자 4자리 담을 컬럼 no ,  기본키로 설정
--최대 10문자 담을 컬럼 name,  null 허용 안함
--최대 13문자 담을 컬럼 jumin,  null 허용 안함, 고유해야 함
--숫자 1자리 담을 컬럼 area,    area 값은 5보다 작아야 한다
--최대 6자리 담을 컬럼 deptno,   t_dept2 테이블의 dcode 컬럼을 참조한다

DROP TABLE T_EMP3 CASCADE CONSTRAINT; -- 제약조건도 같이 지운다!!! ( 그냥 지우면 제약조건은 안지워 진다!! ) 

CREATE TABLE T_EMP3 (
 NO NUMBER(4) PRIMARY KEY,
 name VARCHAR2(10) NOT NULL,
 jumin VARCHAR2(13) NOT NULL UNIQUE,
 area NUMBER(1) CHECK(area < 5),
 deptno VARCHAR2(6) REFERENCES t_dept2(dcode)
);

-- 별도의 제약조건을 명시하지 않는 방법 - not null은 안댐
DROP TABLE T_EMP4 CASCADE CONSTRAINT;
CREATE TABLE T_EMP4 (
 NO NUMBER(4),
 name VARCHAR2(10) NOT NULL,
 jumin VARCHAR2(13) NOT NULL,
 area NUMBER(1),
 deptno VARCHAR2(6), 
 PRIMARY KEY(NO), 
 UNIQUE(jumin),
 CHECK(area < 5),
 FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);

-- 제약조건에 이름을 붙여서 정의하고 사용한다.
-- #9002)   다음 조건을 만족하는 t_emp4 테이블 생성
-- primary key : pk
-- not null : nn
-- unique : uk
-- check : ck
-- references : fk
DROP TABLE T_EMP3 CASCADE CONSTRAINT;
CREATE TABLE T_EMP3 (
 NO NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY,
 name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
 jumin VARCHAR2(13) CONSTRAINT emp3_jumin_nn NOT NULL CONSTRAINT emp3_jumin_uk UNIQUE,
 area NUMBER(1) CONSTRAINT emp3_area_ck CHECK(area < 5),
 deptno VARCHAR2(6) CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
);


DROP TABLE T_EMP3 CASCADE CONSTRAINT;
CREATE TABLE T_EMP3 (
 NO NUMBER(4),
 name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
 jumin VARCHAR2(13) CONSTRAINT emp3_jumin_nn NOT NULL ,
 area NUMBER(1),
 deptno VARCHAR2(6),
 CONSTRAINT emp3_no_pk PRIMARY KEY(NO),
 CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
 CONSTRAINT emp3_area_ck CHECK(area < 5),
 CONSTRAINT emp3_deptno FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);



-- 제약조건 조회하기 ** 
SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_type, STATUS 
FROM USER_CONSTRAINTS
WHERE TABLE_name = 'T_EMP4'; -- 테이블명 대문자로!
-- CONSTRAINT_NAME : 오라클이 붙여주는 별명
-- P : Primary Key,   U : Unique,  C : Check, Not Null   R : Foreign Key



SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_type, STATUS 
FROM USER_CONSTRAINTS
WHERE TABLE_name = 'T_EMP3'; -- 테이블명 대문자로!
-- P : Primary Key,   U : Unique,  C : Check, Not Null   R : Foreign Key

-- #9005 : 제약조건에 맞는 / 위배되는 DML 시도해 보기
INSERT INTO t_emp3 VALUES(1, '오라클', '1234561234567', 4, 1000);
-- 두번 실행하면 오류: SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.EMP3_NO_PK) violated
-- primary key 어김

INSERT INTO t_emp3 VALUES(2, '오라클', '1234561234567', 4, 1000);
-- err : SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated
-- 주민번호 유니크 어김!! 

INSERT INTO t_emp3 VALUES(2, '오라클', '22222222222222222', 4, 1000);
-- err : SQL Error [12899] [72000]: ORA-12899: value too large for column "SCOTT0316"."T_EMP3"."JUMIN" (actual: 17, maximum: 13)
-- 주민번호는 데이터 타입에서 입력 거부( VARCHAR2(13) 초과 오류!! )

INSERT INTO t_emp3 VALUES(2, '오라클', '2222222222222', 10, 1000);
-- SQL Error [1438] [22003]: ORA-01438: value larger than specified precision allowed for this column


INSERT INTO t_emp3 VALUES(2, '오라클', '2222222222222', 3, 2000);
-- ORA-02291: integrity constraint (SCOTT0316.EMP3_DEPTNO) violated - parent key not found
-- 참조하는 테이블에 해당하는 값이 없다.(FK 오류)
-- 외래키 참조: 자식 - 부모 

INSERT INTO t_emp3 (NO, jumin, area, deptno) VALUES (2, '3333333333333', 4, 1001);
-- ORA-01400: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")
-- not null err (NN 오류)



-- INSERT 뿐 아니라, UPDATE/DELETE 에서도 오류 발생 가능!!
-- UPDATE 오류
UPDATE t_emp3 SET area = 10 WHERE NO = 1; -- check 값 오류
-- err : ORA-01438: value larger than specified precision allowed for this column

DELETE FROM t_dept2 WHERE DCODE = 1000;
-- 자식이 참조하고 있는 부모를 삭제하려 하면, 자식이 참조하는 부조는 삭제될 수 없다
-- err : ORA-02292: integrity constraint (SCOTT0316.EMP3_DEPTNO) violated - child record found

SELECT * FROM t_emp3;



-- 제약조건에 위배되는 DML 
-- #9005)  t_emp3 에 제약조건에 맞는 / 위배되는 DML 작성해보고, 에러메세지 확인해보자
-- 테이블 생성 후에 ALTER 명령 사용하여 제약조건 추가 가능!
-- t_emp4 의 name 컬람 UNIQUE 제약조건 추가

--ALTER ~ ADD 
--ALTER ~ MODIFY
--ALTER ~ DROP

ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_uk UNIQUE(name);

-- #9006)   
-- t_emp4 테이블의 area 컬럼에 NOT NULL 제약조건 추가해보세요
-- 이미 칼럼의 기본 값은 null을 허용하도록 설정이 되어 있다, 따라서 새로 생성하는 add 가 아닌, 이미 있는 것을 바꿔주는 modify 로 해야한다 

ALTER TABLE t_emp4 ADD CONSTRAINT emp4_area_nn NOT NULL;
-- err : ORA-00904: : invalid identifier

ALTER TABLE t_emp4 MODIFY (area CONSTRAINT emp4_area_nn NOT NULL);


-- #9007)    외래키 추가
--t_emp4 테이블의 name 컬럼이 t_emp2 테이블의 name 컬럼의 값을 참조하도록 참조키 제약조건을 설정하세요

ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) REFERENCES t_emp2(name);
-- err : ORA-02270: no matching unique or primary key for this column-list
-- 참조되는 부모 쪽의 칼럼은 primary key 이거나, unique 이여야 한다. (부모 쪽 칼럼이 문제!! )

-- 일단 부모 테이블의 name을 unique 로 바꾼 뒤, 위의 쿼리를 다시 실행시켜 보세요!!
ALTER TABLE T_EMP2 ADD CONSTRAINT emp2_name_uk UNIQUE(name);




-- #9008 t_emp3 테이블을 DROP 하고, 이전과 같은 조건으로 다시 만들되
--			t_dept2(dcode)를 참조하는 detpno 컬럼은 
--			부모테이블의 해당 데이터가 삭제되면 함께 삭제되도록 설정


DROP TABLE T_EMP3 CASCADE CONSTRAINT;
CREATE TABLE T_EMP3 (
 NO NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY,
 name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
 jumin VARCHAR2(13) CONSTRAINT emp3_jumin_nn NOT NULL CONSTRAINT emp3_jumin_uk UNIQUE,
 area NUMBER(1) CONSTRAINT emp3_area_ck CHECK(area < 5),
 deptno VARCHAR2(6) 
 		CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
 		ON DELETE CASCADE -- 부모 삭제되면, 자식도 삭제
-- 		ON DELETE SET NULL -- 부모 삭제되면 NULL 값으로 
);




-- #9009)   
--	t_emp4 테이블의 name 필드의 제약조건을 수정 (ALTER TABLE)
--	부모테이블이 삭제되면 NULL 이 되도록 설정하기

ALTER TABLE t_emp4 DROP CONSTRAINT emp4_name_fk; -- 일단 기존 제약조건 삭제

ALTER TABLE t_emp4 
ADD 
	CONSTRAINT emp4_name_fk FOREIGN KEY(name) 
	REFERENCES t_emp2(name) 
	ON DELETE SET NULL -- 부모가 삭제 되면, 자식은 null 로 변환 
;

-- 제약조건 조회하기
SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_type, STATUS 
FROM USER_CONSTRAINTS
WHERE TABLE_name = 'T_EMP4';

--------------------------------------------------------------
-- DISABLE NOVALIDATE

-- #9010
SELECT * FROM T_NOVALIDATE ;
SELECT * FROM T_VALIDATE ;

SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_VALIDATE';

SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_NOVALIDATE';

INSERT INTO T_NOVALIDATE VALUES(1 , 'DDD');  -처음에는 에러!! PK!
-- err: ORA-00001: unique constraint (SCOTT0316.SYS_C007031) violated

ALTER TABLE T_NOVALIDATE 
ENABLE NOVALIDATE CONSTRAINT SYS_C007031;
-- 제약조건 비활성화
-- 비활성화 시킨후 제약조건에 맞지 않은 값들이 테이블에 들어가 있는 경우, 다시 제약조건을 활성화 시킬수 없다.
-- 다시 제약조건을 재활성 시키려는 경우에는, 제약조건에 맞지 않는 값들을 모두 정리해야 한다.

DELETE FROM T_NOVALIDATE WHERE name = 'DDD'; 

















