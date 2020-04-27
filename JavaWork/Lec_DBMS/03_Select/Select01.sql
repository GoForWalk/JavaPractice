-- dual 은 ROW 1 개 짜리 dummy TABLE;
SELECT 'abcde' FROM dual;
SELECT '안녕하세요' FROM dual;
SELECT 100 FROM dual;
SELECT 100 + 10 FROM dual;

-- * : '모든 컬럼'
SELECT * FROM t_emp;

-- 원하는 컬럼만 조회
SELECT EMPNO, ENAME
FROM T_EMP;

--
SELECT * FROM T_PROFESSOR;
SELECT name FROM T_PROFESSOR ;


SELECT bonus FROM T_PROFESSOR ;
SELECT '안녕하세요' FROM T_PROFESSOR ;

SELECT name, '교수님 사랑해요' FROM T_PROFESSOR ;

-- 칼럼 별명(alias) 사용한 출력
SELECT STUDNO 학번, NAME 이름 
FROM T_STUDENT;

SELECT STUDNO "학번", NAME AS 이름
FROM T_STUDENT ;

SELECT STUDNO "학생 학번", NAME AS 이름 -- 띄어쓰기를 별명안에 넣는 경우는 반드시 " " 안에 넣는다 안그러면 에러 발생!!
FROM T_STUDENT ;

SELECT EMPNO "사원번호", ENAME "사원명", JOB "별명"
FROM T_EMP ;

SELECT DEPTNO "부서#", DNAME "부서명", LOC "위치"
FROM T_DEPT ;

-- DISTINCT : 중복 값을 제거하고 출력
SELECT * FROM T_EMP ;

SELECT DEPTNO 
FROM T_EMP ;

SELECT DISTINCT DEPTNO 
FROM T_EMP ;

SELECT DISTINCT DEPTNO1 
FROM T_STUDENT ;

SELECT DISTINCT JOB 
FROM T_EMP ;

-- || : 필드, 문자열 연결 연산
SELECT NAME ,"POSITION" 
FROM T_PROFESSOR ;

SELECT NAME || '-' || POSITION AS 교수님명단  
FROM T_PROFESSOR ;

SELECT NAME || '의 키는' || HEIGHT ||'cm, 몸무게는 '|| WEIGHT ||'Kg 입니다.' "학생의 키와 몸무게"
FROM T_STUDENT ;



