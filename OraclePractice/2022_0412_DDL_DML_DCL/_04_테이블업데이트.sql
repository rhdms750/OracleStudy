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

-- 대문자를 주로 사용. (대소문자 구분x) / 다만 비교를 할 때는 소문자 사용
INSERT INTO MEMBER(ID, PWD) VALUES('NEW LEC','111');
INSERT INTO MEMBER(ID, PWD) VALUES('DRAGON','111');
SELECT id, name, pwd FROM MEMBER;
-- "  " 안에 임시 헤딩을 사용하면 대문자로 변환되지 않고 소문자를 그대로 출력한다.
SELECT id "user_ID", NAME, PWD FROM MEMBER;

-- 모든 PWD 데이터가 '222'로 바뀐다.
UPDATE MEMBER SET PWD = '222';
UPDATE MEMBER SET PWD = '222' WHERE ID = 'newlec';
-- 문자 데이터의 경우 대소문자를 구분하기 때문에 대소문자까지 일치해야한다.
UPDATE MEMBER SET PWD = '333', name = '손오공' WHERE ID = 'DRAGON';
