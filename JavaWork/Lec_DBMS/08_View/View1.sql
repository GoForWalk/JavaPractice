1. -- #8101) t_professor 테이블의 profno, name, email, hpage 칼럼만 사용하는 view를 생성하세요 view 의 이름은 v_prof로 하세요

CREATE VIEW v_prof
AS 
SELECT profno, name, email, hpage
FROM T_PROFESSOR 
;


-- 생성된 view 가 table 처럼 작동한다.
SELECT * FROM v_prof;

SELECT tname FROM tab;

-- VIEW 같은 이름으로 중복으로 만들 수 없다.
-- 따라서, OR REPLACE 는 혹시 이전에 같은 이름의 view 가 있으면 삭제하고 새로 만들라는 의미

CREATE OR REPLACE VIEW v_prof
AS 
SELECT profno, name, email, hpage
FROM T_PROFESSOR 
;

-- view 생성시 별도의 컬럼 이름을 지정해 줄 수 있다.
CREATE OR REPLACE VIEW v_prof(pfno, nm, em, hp)
AS 
SELECT profno, name, email, hpage
FROM T_PROFESSOR 
;

SELECT * FROM v_prof;


CREATE OR REPLACE VIEW v_prof_dept("교수번호", "교수명" ,"소속학과명")
AS
SELECT p.PROFNO , p.NAME , d.DNAME 
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO 
;
SELECT * FROM v_prof_dept;

-- #8103) t_student, t_department 테이블 : 학과별로 학생들의 최대키와 최대몸무게, 학과 이름을 출력하세요 **
SELECT DEPTNO1 , MAX(HEIGHT) max_height, MAX(WEIGHT) max_weight
FROM T_STUDENT 
GROUP BY DEPTNO1 
;

SELECT d.name "학과명", s.max_height "최대키", 
	
FROM (SELECT DEPTNO1 , MAX(HEIGHT) max_height, MAX(WEIGHT) max_weight FROM T_STUDENT GROUP BY DEPTNO1 ) s ,
		t_department d
WHERE 

;


--#8104) t_student, t_department 테이블 : 학과별(deptno1)로 가장 키가 큰 학생들의 이름과 키, 학과이름을 인라인뷰 를 사용하여 다음과 같이 출력하세요 **
SELECT d.dname "학과명", a.max_height "최대키", s.name "학생이름", s.height "키"
FROM 
	(SELECT deptno1, MAX(height) max_height FROM t_student GROUP BY deptno1) a,
	t_student s, t_department d
WHERE 
	s.deptno1 = a.deptno1 AND s.height = a.max_height
	AND s.deptno1 =  d.deptno
;

-- #8105) t_student 테이블 : 학생의 키가 동일 학년의 평균 키보다 큰 학생들의 학년과 이름과 키, 해당 학년의 평균키를 출력하되, inline view 를 사용해서 아래와 같이 출력하세요. 단 학년 칼럼은 오름 차순으로 정렬.
SELECT
	s.GRADE "학년" , s.NAME "이름" , s.HEIGHT "키" , a.avg_height "평균키"
FROM
	(SELECT GRADE , AVG(HEIGHT) avg_height FROM T_STUDENT GROUP BY GRADE) a,
	t_student s
WHERE a.grade = s.GRADE AND s.HEIGHT > a.avg_height
ORDER BY 1
;

-- 인라인 뷰랑 그냥 뷰랑 뭐가 다름?? 









