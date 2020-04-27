SELECT * 
FROM T_PROFESSOR ;
-- null 이 배제된다!! 
SELECT COUNT(*) ,
	COUNT(HPAGE ) 	 
FROM T_PROFESSOR ;

SELECT COUNT(BONUS ), SUM(BONUS ), avg(BONUS ) -- 받는 사람만을 평균 내버림!!
FROM T_PROFESSOR ;

SELECT MAX(HIREDATE ), MIN(HIREDATE )
FROM T_EMP ;



-- NULL 허용 컬럼의 그룹함수 적용시 
-- nvl ,nvl2 사용해야함!!

SELECT AVG(BONUS ), avg(NVL(BONUS , 0)) 
FROM T_PROFESSOR ;

--예) t_professor 테이블에서 ‘학과별’로 교수들의 평균 보너스를 출력하세요

-- *********************************************************
-- SELECT 절에 그룹함수와 그룹함수 아닌것은 동시에 들어올 수 없다!!
-- 불가능하다!  SELECT 절에 group 함수와 group 함수가 아닌 것과는 같이 출력 불가
-- SELECT deptno, avg(bonus)
-- FROM t_professor;
-- **********************************************************

 SELECT deptno, ROUND(AVG(NVL(BONUS , 0)), 1) 보너스평균
 FROM t_professor
 GROUP BY DEPTNO 
 ;
 
SELECT DEPTNO , POSITION, AVG(PAY ) 평균급여 
FROM T_PROFESSOR 
GROUP BY DEPTNO , POSITION  --1. 학과별 그룹핑, 2. 직급별 그룹핑
ORDER BY DEPTNO ASC , POSITION ASC 
;

--SELECT DEPTNO , AVG(PAY ) 평균급여 
--FROM T_PROFESSOR
--WHERE avg(PAY ) > 450 -- 그룹함수는 WHERE 절에서 사용불가!!!
--GROUP BY DEPTNO 
--;

-- having : 그룹함수 결과에 대한 조건절
SELECT DEPTNO , AVG(PAY ) 평균급여 
FROM T_PROFESSOR
GROUP BY DEPTNO 
HAVING AVG(PAY) > 300 
;



-- <SELECT 쿼리문 순서>
--
--SELECT 
--FROM 
--WHERE 
--GROUP BY 
--HAVING 
--ORDER BY 
-- *********** 기사시험 단골!!

SELECT * 
FROM T_EMP ;


-- #5202
SELECT 	MGR 매니저, 
		COUNT(EMPNO ) 직원수,
		SUM(SAL ) 급여총액,
		avg(sal + nvl(COMM , 0)) 급여평균,
		avg(nvl(COMM ,0)) 교통비평균
FROM T_EMP 
WHERE JOB != 'PRESIDENT'
GROUP BY MGR
;
SELECT * FROM  T_PROFESSOR ;

-- #5203
SELECT 	DEPTNO ,
		COUNT(deptno) 총인원,
		ROUND(AVG(SYSDATE - HIREDATE ), 1) 근속평균,
		ROUND(AVG(PAY ),1) 급여평균,
		AVG(NVL(BONUS , 0)) 보너스평균 
FROM T_PROFESSOR 
WHERE POSITION != '전임강사'
GROUP BY DEPTNO 
;

SELECT  * FROM T_STUDENT ;
-- #5204
SELECT 	DEPTNO1 학과,
		MAX(WEIGHT ) - MIN(WEIGHT ) 최대최소몸무게차
FROM T_STUDENT 
GROUP BY DEPTNO1 
;

-- #5205
SELECT 	DEPTNO1 학과,
		MAX(WEIGHT ) - MIN(WEIGHT ) 최대최소몸무게차
FROM T_STUDENT 
GROUP BY DEPTNO1 
HAVING MAX(WEIGHT ) - MIN(WEIGHT ) >= 30
;

SELECT * FROM T_PROFESSOR ;
SELECT * FROM T_STUDENT ;
SELECT * FROM T_DEPARTMENT ;
SELECT * FROM T_EMP2 ;
SELECT * FROM T_DEPT2 ;
SELECT * FROM T_POST ;
SELECT * FROM T_CUSTOMER ;
SELECT * FROM T_GIFT ;
SELECT * FROM T_EXAM01 ;
SELECT * FROM T_CREDIT ;
SELECT * FROM T_EMP ;



