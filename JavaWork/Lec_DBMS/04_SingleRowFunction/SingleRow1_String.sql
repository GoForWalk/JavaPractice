-- INICAP() 함수

-- #4101
SELECT INITCAP('pretty girl') 
FROM dual;

-- #4102
SELECT id, INITCAP(ID) ID 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;


-- LOWER(), UPPER()

-- #4103
SELECT NAME "이름", ID , LOWER(ID) "소문자", UPPER(ID) "대문자" 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- LENGTH(), LENGTHB()

-- #4104
SELECT  NAME 이름 , ID ,LENGTH(id) 글자수
FROM T_STUDENT 
WHERE LENGTH (ID) >= 9;

-- #4105
SELECT NAME 이름, LENGTH (NAME) 길이, Lengthb(NAME) 바이트
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- CONCAT 함수 
-- #4106
SELECT CONCAT( NAME, POSITION ) 교수님명단
FROM T_PROFESSOR 
WHERE DEPTNO = 101;

-- SUBSTR 함수: SUBSTR(문자열, 시작위치(1부터 시작), 추출할 글자 수)// 시작 인덱스 음수 지원!! (글자 인덱스 역방향 )

-- #4107
SELECT NAME , SUBSTR(JUMIN, 1, 6) 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4108
SELECT NAME , SUBSTR(JUMIN, 1, 6) 생년월일 
FROM T_STUDENT 
WHERE SUBSTR(JUMIN ,3,2) = '08';
-- WHERE JUMIN LIKE '__08%';

-- #4109
SELECT NAME , JUMIN 
FROM T_STUDENT 
WHERE GRADE = 4 and SUBSTR(JUMIN, 7,1) = '2' ;


-- INSTR('문자열' , 찾는 문자열, 시작위치, 몇번째 등장?);    함수 // 없으면 0 리턴
SELECT INSTR('A*B*C*', '*', 1, 1) -- 첫번째 문자열 부터 * 찾아서 , 첫번째 등장하는 * 가 어디에 있는지??
FROM  dual;

SELECT INSTR('A*B*C*', '*', 1, 2)
FROM DUAL ; -- 4

SELECT INSTR('A*B*C*', '*', 3, 2) FROM dual;  -- 6
SELECT INSTR('A*B*C*', '*', -4, 1) FROM dual;  --2  음수인덱스의 경우 검색도 음의 방향으로 진행
SELECT INSTR('A*B*C*', '*', -4, 2) FROM dual;   -- 0 없으면 0 리턴 

-- #4110
--SELECT NAME , TEL , INSTR(TEL , ')', 1,1) 위치 
SELECT NAME , TEL , INSTR(TEL , ')') 위치 -- 1, 1 default 값
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4111
SELECT NAME, TEL,  SUBSTR(TEL , 1 ,INSTR(TEL , ')') -1 ) 지역번호
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- LTRIM(), RTRIM(), TRIM()
SELECT 
	LTRIM('슈퍼슈퍼슈가맨', '슈퍼') LTRIM,
	LTRIM('슈퍼슈퍼슈가맨', '슈') LTRIM,
	LTRIM('    슈퍼슈가맨', ' ') LTRIM, -- 왠쪽 공백 제거
	LTRIM('    슈퍼슈가맨') LTRIM, -- 디폴트로 공백 제거!!
	RTRIM('슈퍼슈가맨      ') RTRIM 
	FROM DUAL ;
	
SELECT *
FROM T_DEPT2 ;

SELECT DNAME, RTRIM(DNAME ,'부') 
FROM  T_DEPT2 

-- REPLACE 함수

SELECT REPLACE('슈퍼맨 슈퍼걸', '슈퍼', '파워') REPLACE -- 슈퍼를 찾아서 파워로 바꿔라~~ : 파워맨 파워걸
FROM DUAL ;


SELECT REPLACE('아버지가 방에 들어가신다', ' ', '') AS 가방
FROM DUAL ;

-- #4118
SELECT NAME , REPLACE (NAME, SUBSTR(NAME , 1, 1), '#') AS 학생 
FROM T_STUDENT 
WHERE DEPTNO1  = 102;

-- #4119
SELECT  REPLACE (NAME ,SUBSTR(NAME , 2,1), '#') AS 학생
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4120
SELECT NAME ,  REPLACE (JUMIN ,SUBSTR(JUMIN , 7,7), '*******') AS 주민번호 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4121
SELECT NAME , TEL , REPLACE (TEL , SUBSTR(TEL , INSTR(tel , ')') + 1 , 3), '###') AS  전화번호
FROM T_STUDENT 
WHERE DEPTNO1  = 102;













