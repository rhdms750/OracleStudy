-- INNNR JOIN 연습    
SELECT 
  a.APPLY_NO AS 순번,
  c.COM_NAME AS 기업명,
  c.COM_CAT AS 기업분야,
  c.COM_FOCUS AS 주력요소,
  TO_CHAR(a.APPLY_DATE, 'YYYY-MM-DD') AS 지원일자,
  a.APPLY_STATE AS 지원상태
FROM MY_APPLY a INNER JOIN COMPANY c
     ON a.APPLY_NO = c.APPLY_NO;
     
SELECT
  a.APPLY_NO AS 순번,
  c.COM_NAME AS 기업명,
  c.COM_CAT AS 기업분야,
  c.COM_FOCUS AS 주력요소,
  TO_CHAR(a.APPLY_DATE, 'YYYY-MM-DD') AS 지원일자,
  a.APPLY_STATE AS 지원상태
FROM MY_APPLY a, COMPANY c
WHERE a.APPLY_NO = c.APPLY_NO;

-- LEFT OUTER JOIN 연습  
SELECT
  c.COM_NO AS 순번,
  c.COM_NAME AS 기업명,
  w.SALARY AS 연봉,
  w.OVERTIME_PAY AS 야근수당,
  W.FACILITY AS 시설
FROM COMPANY c LEFT OUTER JOIN WORK_ENV w
     ON c.COM_NO = w.COM_NO;
     
SELECT
  c.COM_NO AS 순번,
  c.COM_NAME AS 기업명,
  w.SALARY AS 연봉,
  w.OVERTIME_PAY AS 야근수당,
  W.FACILITY AS 시설
FROM COMPANY c, WORK_ENV w
WHERE c.COM_NO = w.COM_NO;
     
-- RIGHT OUTER JOIN 연습  
SELECT
  c.COM_NO AS 순번,
  c.COM_NAME AS 기업명,
  w.SALARY AS 연봉,
  w.OVERTIME_PAY AS 야근수당,
  W.FACILITY AS 시설
FROM WORK_ENV w RIGHT OUTER JOIN COMPANY c
     ON w.COM_NO = c.COM_NO;
     
SELECT
  c.COM_NO AS 순번,
  c.COM_NAME AS 기업명,
  w.SALARY AS 연봉,
  w.OVERTIME_PAY AS 야근수당,
  W.FACILITY AS 시설
FROM WORK_ENV w, COMPANY c
WHERE w.COM_NO = c.COM_NO;

-- CROSS JOIN 연습      
SELECT
  c.COM_NO AS 순번,
  c.COM_NAME AS 기업명,
  w.SALARY AS 연봉,
  w.OVERTIME_PAY AS 야근수당,
  W.FACILITY AS 시설
FROM WORK_ENV w CROSS JOIN COMPANY c;

-- SELF JOIN 연습 
SELECT
  c.COM_NO AS 순번,
  c2.COM_NAME AS 회사명,
  c2.COM_CAT AS 카테고리
FROM COMPANY c JOIN COMPANY c2
     ON c.COM_NO = c2.COM_NO;