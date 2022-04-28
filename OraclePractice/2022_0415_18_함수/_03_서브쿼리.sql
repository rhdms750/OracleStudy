-- Q1. 사원 테이블에서 이미자와 동일한 계절에 입사한 직원 추출
SELECT * FROM SAWON 
  WHERE TRUNC(TO_NUMBER(TO_CHAR(sahire,'MM')) / 3, 0) = (
   											    SELECT
   											       TRUNC(TO_NUMBER(TO_CHAR(sahire,'MM')) / 3, 0)
   											       FROM SAWON
   											       WHERE SANAME = '이미자'
  											   );


-- Q2. 사원 테이블에서 총 급여 평균 보다 더 급여를 많이 받는 직원 추출
SELECT * FROM SAWON
  WHERE SAPAY > AVG(SAPAY);  -- 에러 ! 그룹 함수는 허가되지 않습니다
  
SELECT * FROM SAWON
  WHERE SAPAY > (SELECT AVG(SAPAY) FROM SAWON);


-- Q3. 사원 테이블에서 최초 입사한 직원을 추출
SELECT MIN(SAHIRE) FROM SAWON

SELECT * FROM SAWON
 WHERE SAHIRE = (SELECT MIN(SAHIRE) FROM SAWON)


-- Q4. 사원 테이블에서 가장 최근 입사한 직원을 추출 
SELECT * FROM SAWON
 WHERE SAHIRE = (SELECT MAX(SAHIRE) FROM SAWON)

-- Q5. 사원 테이블에서 일자를 기준으로 최초입사자, 최근입사자를 모두 추출
SELECT * FROM SAWON
  WHERE SAHIRE = (SELECT MIN(SAHIRE) FROM SAWON)
        or
        SAHIRE = (SELECT MAX(SAHIRE) FROM SAWON);