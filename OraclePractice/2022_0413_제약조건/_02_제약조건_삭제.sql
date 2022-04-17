create table userInfo3
(
    name      varchar2(100) not null,
    id        varchar2(100) not null unique,
    password  varchar2(100) not null
)
/

alter table userInfo3 
  add constraint unique_userInfo3_password unique(password);
  
alter table userInfo3 drop constraint unique_userInfo3_password

insert into userInfo3 values('È«±æµ¿','hong123','1234'); 
insert into userInfo3 values('±èÃ¶¼ö','park123','2345');