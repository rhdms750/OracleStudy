-- Q1. ��� ���̺��� �̹��ڿ� ������ ������ �Ի��� ���� ����
SELECT * FROM SAWON 
  WHERE TRUNC(TO_NUMBER(TO_CHAR(sahire,'MM')) / 3, 0) = (
   											    SELECT
   											       TRUNC(TO_NUMBER(TO_CHAR(sahire,'MM')) / 3, 0)
   											       FROM SAWON
   											       WHERE SANAME = '�̹���'
  											   );


-- Q2. ��� ���̺��� �� �޿� ��� ���� �� �޿��� ���� �޴� ���� ����
SELECT * FROM SAWON
  WHERE SAPAY > AVG(SAPAY);  -- ���� ! �׷� �Լ��� �㰡���� �ʽ��ϴ�
  
SELECT * FROM SAWON
  WHERE SAPAY > (SELECT AVG(SAPAY) FROM SAWON);


-- Q3. ��� ���̺��� ���� �Ի��� ������ ����
SELECT MIN(SAHIRE) FROM SAWON

SELECT * FROM SAWON
 WHERE SAHIRE = (SELECT MIN(SAHIRE) FROM SAWON)


-- Q4. ��� ���̺��� ���� �ֱ� �Ի��� ������ ���� 
SELECT * FROM SAWON
 WHERE SAHIRE = (SELECT MAX(SAHIRE) FROM SAWON)

-- Q5. ��� ���̺��� ���ڸ� �������� �����Ի���, �ֱ��Ի��ڸ� ��� ����
SELECT * FROM SAWON
  WHERE SAHIRE = (SELECT MIN(SAHIRE) FROM SAWON)
        or
        SAHIRE = (SELECT MAX(SAHIRE) FROM SAWON);