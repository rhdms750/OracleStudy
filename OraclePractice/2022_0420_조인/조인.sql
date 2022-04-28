-- INNNR JOIN ����    
SELECT 
  a.APPLY_NO AS ����,
  c.COM_NAME AS �����,
  c.COM_CAT AS ����о�,
  c.COM_FOCUS AS �ַ¿��,
  TO_CHAR(a.APPLY_DATE, 'YYYY-MM-DD') AS ��������,
  a.APPLY_STATE AS ��������
FROM MY_APPLY a INNER JOIN COMPANY c
     ON a.APPLY_NO = c.APPLY_NO;
     
SELECT
  a.APPLY_NO AS ����,
  c.COM_NAME AS �����,
  c.COM_CAT AS ����о�,
  c.COM_FOCUS AS �ַ¿��,
  TO_CHAR(a.APPLY_DATE, 'YYYY-MM-DD') AS ��������,
  a.APPLY_STATE AS ��������
FROM MY_APPLY a, COMPANY c
WHERE a.APPLY_NO = c.APPLY_NO;

-- LEFT OUTER JOIN ����  
SELECT
  c.COM_NO AS ����,
  c.COM_NAME AS �����,
  w.SALARY AS ����,
  w.OVERTIME_PAY AS �߱ټ���,
  W.FACILITY AS �ü�
FROM COMPANY c LEFT OUTER JOIN WORK_ENV w
     ON c.COM_NO = w.COM_NO;
     
SELECT
  c.COM_NO AS ����,
  c.COM_NAME AS �����,
  w.SALARY AS ����,
  w.OVERTIME_PAY AS �߱ټ���,
  W.FACILITY AS �ü�
FROM COMPANY c, WORK_ENV w
WHERE c.COM_NO = w.COM_NO;
     
-- RIGHT OUTER JOIN ����  
SELECT
  c.COM_NO AS ����,
  c.COM_NAME AS �����,
  w.SALARY AS ����,
  w.OVERTIME_PAY AS �߱ټ���,
  W.FACILITY AS �ü�
FROM WORK_ENV w RIGHT OUTER JOIN COMPANY c
     ON w.COM_NO = c.COM_NO;
     
SELECT
  c.COM_NO AS ����,
  c.COM_NAME AS �����,
  w.SALARY AS ����,
  w.OVERTIME_PAY AS �߱ټ���,
  W.FACILITY AS �ü�
FROM WORK_ENV w, COMPANY c
WHERE w.COM_NO = c.COM_NO;

-- CROSS JOIN ����      
SELECT
  c.COM_NO AS ����,
  c.COM_NAME AS �����,
  w.SALARY AS ����,
  w.OVERTIME_PAY AS �߱ټ���,
  W.FACILITY AS �ü�
FROM WORK_ENV w CROSS JOIN COMPANY c;

-- SELF JOIN ���� 
SELECT
  c.COM_NO AS ����,
  c2.COM_NAME AS ȸ���,
  c2.COM_CAT AS ī�װ�
FROM COMPANY c JOIN COMPANY c2
     ON c.COM_NO = c2.COM_NO;