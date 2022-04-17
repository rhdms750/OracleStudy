-- not null
create table userInfo3
(
    name      varchar2(100) not null,
    id        varchar2(100) not null unique,
    password  varchar2(100) not null
)

alter table userInfo3
  add constraint unique_userInfo3_name unique(name);
  
alter table userInfo3 drop unique_userInfo3_password;
  
insert into userInfo3 values('홍길동','hong123','1234'); -- OK
insert into userInfo3(name) values('나길동'); -- 에러! 데이터 미삽입 : 널 무결성 위배 
                                            --ORA-01400: NULL을 ("TEST1"."USERINFO3"."ID") 안에 삽입할 수 없습니다
insert into userInfo3 values('다길동','hong123','2345'); -- 에러! 중복값 추가 : 고유 무결성 위배
                                                       -- ORA-00001: 무결성 제약 조건(TEST1.SYS_C004094)에 위배됩니다
insert into userInfo3 values('마길동','hong234','')