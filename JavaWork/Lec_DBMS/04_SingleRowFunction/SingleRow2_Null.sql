SELECT * FROM T_PROFESSOR ;

-- 보너스 NULL -> 급여 + 보너스를 수행하면, NULL 이 있는경우 NULL로 표기됨 ㅎ

-- NULL 값과의 연산 결과는 NULL 이다!!




-- 그룹함수에서는 동작!!
SELECT sum(pay), sum(BONUS) FROM T_PROFESSOR ; -- 시험에 개 많이 나옴!!
 --> NULL 값 무시하고~ 잘 계산한다 (NULL은 연산에서 제외되어 동작한다.)
 
-- nvl() 함수
SELECT NAME , PAY , BONUS ,
		PAY +BONUS 총지급액,
		pay + nvl(BONUS, 0) "총지급액(nvl)" 
FROM T_PROFESSOR ;

-- #4201
SELECT NAME , PAY , NVL( BONUS, 0) BONUS, PAY * 12 + NVL(BONUS , 0) AS 연봉 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;

-- #4202
SELECT NAME , PAY , NVL2( BONUS, BONUS ,0) BONUS, NVL2 (BONUS ,PAY * 12 + BONUS , PAY * 12) AS 연봉 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;



