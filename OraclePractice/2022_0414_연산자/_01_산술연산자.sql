
--덧셈은 숫자만 더하기 때문에 숫자 + 문자면 숫자로 더해진다 
SELECT 1+'3' FROM DUAL;
--문자와 문자를 더하기
SELECT 1 || '3' FROM DUAL;

--Q. 모든 회원의 이름을 조회하시오. 단 이름은 ID를 붙여서
SELECT NAME || '(' || ID || ')' "이름(ID)" FROM MEMBER;
