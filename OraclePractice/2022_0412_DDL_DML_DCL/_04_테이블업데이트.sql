CREATE TABLE MEMBER
(
    ID       VARCHAR2(50),
    PWD      VARCHAR2(50),
    NAME     VARCHAR2(50),
    GENDER   CHAR(50),
    AGE      NUMBER,
    BIRTHDAY CHAR(50),
    PHONE    CHAR(50),
    REGDATE  DATE
)

-- �빮�ڸ� �ַ� ���. (��ҹ��� ����x) / �ٸ� �񱳸� �� ���� �ҹ��� ���
INSERT INTO MEMBER(ID, PWD) VALUES('NEW LEC','111');
INSERT INTO MEMBER(ID, PWD) VALUES('DRAGON','111');
SELECT id, name, pwd FROM MEMBER;
-- "  " �ȿ� �ӽ� ����� ����ϸ� �빮�ڷ� ��ȯ���� �ʰ� �ҹ��ڸ� �״�� ����Ѵ�.
SELECT id "user_ID", NAME, PWD FROM MEMBER;

-- ��� PWD �����Ͱ� '222'�� �ٲ��.
UPDATE MEMBER SET PWD = '222';
UPDATE MEMBER SET PWD = '222' WHERE ID = 'newlec';
-- ���� �������� ��� ��ҹ��ڸ� �����ϱ� ������ ��ҹ��ڱ��� ��ġ�ؾ��Ѵ�.
UPDATE MEMBER SET PWD = '333', name = '�տ���' WHERE ID = 'DRAGON';
