-- ���� ���̺� ) userInfo3
create table userInfo3
(
    SID       int,           
    name      varchar2(100) not null,
    id        varchar2(100) not null unique,
    password  varchar2(100) not null,
    eng       int           check(eng between 0 and 100),
    mat       int           check(mat between 0 and 100)
)

alter table userInfo3 
  add constraint pk_userInfo3_SID primary key(SID)

insert into userInfo3 values(1001, '��浿', 'kim1234', '1234', 88, 100);
insert into userInfo3 values(1002, '���浿', 'nah1234', '2345', 78, 90);
insert into userInfo3 values(1003, '�ٱ浿', 'dah1234', '2345', 98, 50);

select * from userInfo3

-- A���̺� ) userInfoRevised1
create table userInfoRevised1
(
    SID       int,           
    name      varchar2(100) not null,
    id        varchar2(100) not null unique,
    password  varchar2(100) not null
)

alter table userInfoRevised1
  add constraint pk_userInfoRevised1_SID primary key(SID)

insert into userInfoRevised1 values(1001, '��浿', 'kim1234', '1234');
insert into userInfoRevised1 values(1002, '���浿', 'nah1234', '2345');
insert into userInfoRevised1 values(1003, '�ٱ浿', 'dah1234', '2345');

select * from userInfoRevised1

-- B���̺� : userInfoRevised2
create table userInfoRevised2
(
    idx       int,
    SID       int,           
    name      varchar2(100) not null,
    eng       int           check(eng between 0 and 100),
    mat       int           check(mat between 0 and 100)
)

alter table userInfoRevised2 
  add constraint pk_userInfoRevised2_idx primary key(idx)
  
alter table userInfoRevised2
  add constraint fk_userInfoRevised2_SID foreign key(SID) references userInfoRevised1(SID)

insert into userInfoRevised2 values(1, 1001, '��浿', 88, 100); -- OK
insert into userInfoRevised2 values(2, 1002, '���浿', 78, 90);  -- OK
insert into userInfoRevised2 values(3, 1005, '�ٱ浿', 98, 50);  -- ����! ���� SID �ڵ�

select * from userInfoRevised2