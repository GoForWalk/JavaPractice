SELECT * FROM TEST_MEMBER ;

INSERT INTO TEST_MEMBER values(10, '이성준', SYSDATE);
-- dml의 결과는 정수

SELECT * FROM TEST_MEMBER ;

INSERT INTO TEST_MEMBER  values(22, '이승환', '1994-02-21');
INSERT INTO TEST_MEMBER  values(17, '윤종섭', '2019-08-03');
INSERT INTO TEST_MEMBER  values('', '이예지', ''); -- 비어있는 ''를 insert 하면 null 값 처리
SELECT * FROM TEST_MEMBER ;

--INSERT INTO TEST_MEMBER values(10,'', SYSDATE);
INSERT INTO TEST_MEMBER  values(Null, '문상현', '2017-08-03');
SELECT * FROM TEST_MEMBER ;




