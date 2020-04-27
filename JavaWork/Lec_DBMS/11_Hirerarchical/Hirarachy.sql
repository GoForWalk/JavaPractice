-- 계층형 쿼리 (Hirerarchical Query)

SELECT * FROM T_DEPT2 ; -- 서로의 계층관계 주목!! 

-- 사장실 -> 경영지원부 -> H/W 지원팀 (이렇게)

SELECT LPAD(dname, 10, '*') 부서명 FROM T_DEPT2 ;

-- LEVEL
SELECT dname, LEVEL 
FROM T_DEPT2 
CONNECT BY PRIOR DCODE = PDEPT
START WITH DCODE = 0001
ORDER BY 2
;

/* 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR  :  각 row 들이 어떻게 연결되어야 하는지 조건 지정
 * PRIOR를 어느쪽에 주느냐가 중요!
 */
-- prior 를 다른데 주면??
SELECT dname, LEVEL 
FROM T_DEPT2 
CONNECT BY DCODE = PRIOR PDEPT 
START WITH DCODE = 0001
ORDER BY 2
;

SELECT DCODE ,dname, PDEPT, LEVEL 
FROM T_DEPT2 
CONNECT BY DCODE = PRIOR PDEPT 
--START WITH DCODE = 1005
START WITH DCODE = 1011
ORDER BY 4
;


SELECT LPAD(DNAME , LEVEL * 6, '*' ) 부서명
FROM T_DEPT2 
CONNECT BY PRIOR DCODE = PDEPT 
START WITH DCODE = 0001
;

--------------------
SELECT  * FROM T_EMP2;

SELECT  LPAD(e.NAME ||' '|| d.dname ||' '|| NVL(e.POST , '사원') , LEVEL*22, '-') "이름과 직급"
FROM T_EMP2 e , (SELECT dname, dcode, pdept FROM T_DEPT2 ) d
WHERE e.deptno = d.dcode
CONNECT BY PRIOR e.EMPNO = e.PEMPNO 
START WITH e.EMPNO = 20000101
;

SELECT LEVEL - 1 HR 
FROM dual
CONNECT BY LEVEL <= 24
;


----------------------------------------------------------------------------------------------------------------

-- 코드를 입력하세요
 SELECT LEVEL - 1 HR
 FROM DUAL
 CONNECT BY LEVEL <= 24
 ;

 SELECT TO_CHAR(DATETIME, 'hh') , COUNT(ANIMAL_ID)
 FROM ANIMAL_OUTS
 GROUP BY TO_CHAR(DATETIME, 'hh')
 ;

--  SELECT H.HR, COUNT(ANIMAL_ID)
--  FROM (SELECT LEVEL - 1 HR FROM DUAL CONNECT BY LEVEL <= 24) H, 
--  (SELECT COUNT(ANIMAL_ID) FROM ANIMAL_OUTS GROUP BY TO_NUMBER(TO_CHAR(DATETIME, 'hh'))) B
-- WHERE  B.TO_NUMBER(TO_CHAR(DATETIME, 'hh')) = A.(LEVEL - 1)
-- ;

SELECT TO_CHAR(DATETIME, 'HH24') HR, COUNT(DATETIME) 
FROM ANIMAL_OUTS
GROUP BY TO_CHAR(DATETIME, 'HH24')
;

-- https://programmers.co.kr/learn/courses/30/lessons/59413?language=oracle
SELECT h.hr "HOUR", count(datetime) "COUNT"
FROM 
    (SELECT LEVEL - 1 HR FROM DUAL CONNECT BY LEVEL <= 24) h
    LEFT OUTER JOIN ANIMAL_OUTS a
    ON h.hr = to_number(to_char(a.datetime, 'hh24'))
GROUP BY h.hr
ORDER BY 1
;







