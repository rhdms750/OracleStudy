/*
  ���� �ּ�
*/

-- xxx.sqlȭ�� ������ 1�� �ּ��� : --
-- ���� �ּ��� : /* */

-- hr�������� �����
-- ��� ���� ��ȸ
select * from EMPLOYEES
-- �������� �����ݷ��� ���û���/ ���� �巡���Ͽ� Alt+x�ϸ� �����

-- �μ� ���� ��ȸ
select * from DEPARTMENTS;

-- AWS ���� 
select * from TEST:

--scott ����
/*
�ּ� ó���� ���·ε� ���� ����
select * from emp;
*/

/*
-- dept ���̺�� emp ���̺��� �����ϴ� ����
SELECT e.empno, e.ename, d.dname
  FROM dept d, empe
WHERE d.deptno = e.deptno;

--����Ŭ ������ �ȵǸ� -> �˻� -> ����
  1. OracleServiceXE
  2. OracleXETNSListener
  ����Ȯ�� 
  3. ojdbc14.jar�� ����ġ�� �ִ��� Ȯ��
  
-- ����Ŭ ���� �ȵɶ� CMDâ���� Ȯ�� �ϴ� ��
-- cmdâ���� �����Ͱ� �۵��ϴ��� Ȯ���ϰ�, ���۵��� start�� �۵�
   c:\>lsnrctl
   LSNRCTL>status    -- ������ ���� Ȯ��
   LSNRCTL>start     -- ������ ����
   LSNRCTL>stop      -- ������ ����
     
     
  
*/

/*
  create user test1 identified by test1
  
*/