-- 다중칼럼 Sub Query
-- Sub Query 결과가 여러 칼럼인 경우. 
-- 주로 Primary Key 를 여러 칼럼을 합쳐서 만들었을 경우 한꺼번에 비교하기 위해서 자주 사용.

-- 쿼리문을 작성할 때 원하는 결과를 그림으로 그려보기!!

-- #7201) t_student 테이블을 조회하여 각 학년별로 최대 키를 가진 학생들의 학년과 이름과 키를 출력하세요,  학년 오름차순으로 출력

SELECT t1.GRADE , t1.MAX(HEIGHT ) 
FROM T_STUDENT t1 
GROUP BY GRADE 
;

SELECT GRADE "학년", NAME "이름", HEIGHT "키"
FROM T_STUDENT 
WHERE (GRADE, HEIGHT) IN (SELECT GRADE , MAX(HEIGHT ) FROM T_STUDENT GROUP BY GRADE )
ORDER BY "학년" ASC -- ORDER BY 에서는 마지막에 나오기 때문에 별명을 사용할 수 있다. 
;

-- #7202) t_professor , t_department 테이블 :  각 학과별로 입사일이 가장 오래된 교수의 교수번호와 이름, 학과명을 출력하세요.  단 학과이름 순으로 오름차순 정렬하세요
SELECT DEPTNO , MAX(HIREDATE ) 
FROM T_PROFESSOR 
GROUP BY DEPTNO 
;

SELECT  p.PROFNO "교수번호", p.NAME "교수명", TO_CHAR( p.HIREDATE, 'YYYY-MM-DD' )"입사일" , d.DNAME "학과명" 
FROM T_PROFESSOR p , T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO AND (p.DEPTNO , p.HIREDATE) IN (SELECT DEPTNO , MAX(HIREDATE ) FROM T_PROFESSOR GROUP BY DEPTNO )
ORDER BY 4
;

--#7203)  t_emp2 테이블 : 직급별로 해당직급에서 최대 연봉을 받는 직원의 이름과 직급, 연봉을 출력하세요,  단, 연봉순으로 오름차순 정렬하세요
SELECT POST ,MAX(PAY) 
FROM T_EMP2 
GROUP BY POST 
;

SELECT NAME , POST , PAY 
FROM T_EMP2 
WHERE (POST , PAY) IN (SELECT POST ,MAX(PAY) FROM T_EMP2 GROUP BY POST)
ORDER BY 3 ASC 
;

--#7204)  t_emp2, t_dept2 테이블 : 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다 적게 받는 직원들의 부서명, 직원명, 연봉을 출력 하세요

SELECT AVG(PAY) 
FROM T_EMP2
GROUP BY DEPTNO
ORDER BY 1
;

SELECT d.DNAME, e.NAME, e.PAY 
FROM T_EMP2 e, T_DEPT2 d
WHERE e.DEPTNO = d.DCODE 
	AND e.PAY < ALL (SELECT AVG(PAY) FROM T_EMP2 GROUP BY DEPTNO)
ORDER BY 3
;

-- 상호연관 Sub Query
-- Main Query 값을 Sub Query 에 주고 Sub Query를 수행한 후 그 결과를 다시 Main Query 로 반환해서 수행하는 쿼리.


-- #7205) t_emp2 테이블 : 직원들 중에서 자신의 직급의 평균연봉과 같거나 많이 받는 사람들의 이름과 직급, 현재 연봉을 출력하세요.

-- Main query
SELECT a.NAME "사원이름", NVL(a.POST, ' ') "직급", -- post는 null 을 허용하는 컬럼!! 
		a.PAY "급여"
FROM T_EMP2 a
--WHERE a.PAY >= ( a.POST 직급의 평균연봉)
WHERE a.PAY >= (SELECT AVG(b.pay) FROM T_EMP2 b WHERE NVL(a.POST, ' ') = NVL(b.POST, ' '))
;

SELECT AVG(b.pay) FROM T_EMP2 b WHERE '과장' = b.POST;

-- Scalar Sub Query (스칼라 서브쿼리)
-- #7206) t_emp2, t_dept2 테이블: 조회하여 사원들의 이름과 부서 이름을 출력
-- JOIN 과 같은 결과 나옴.  그러나 데이터 양이 적은 경우는 스칼라서브쿼리 방식이 Join 보다 나은 성능을 보여줌

SELECT NAME "사원이름", 
		(SELECT dname FROM T_DEPT2 d WHERE e.deptno = d.DCODE ) "부서이름"  -- SELECT 구문 안에 서브 쿼리 사용 가능!!
FROM T_EMP2 e
;




