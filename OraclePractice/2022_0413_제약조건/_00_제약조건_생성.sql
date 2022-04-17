-- ���1
create table userInfo
(
    name      varchar2(100) not null,
    nickname  varchar2(100) null       
)
/

drop table userInfo;

-- ���2
create table userInfo2
(
    name      varchar2(100) not null,
    id        varchar2(100) not null,
    password  varchar2(100) not null,
    
    constraint unique_userInfo2_password23 unique(id)
)

insert into userInfo2 values('ȫ�浿','hong123','1234');
insert into userInfo2 values('���浿','hong323','1234');
insert into userInfo2 values('���浿','hong323','1234');

-- ���3
create table userInfo3
(
    name      varchar2(100) not null,
    id        varchar2(100) not null unique,
    password  varchar2(100) not null
)
/

alter table userInfo3 
  add constraint unique_userInfo3_password unique(password);
  

