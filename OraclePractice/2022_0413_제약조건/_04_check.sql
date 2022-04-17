create table userInfo3
(
    name      varchar2(100) not null,
    id        varchar2(100) not null unique,
    password  varchar2(100) not null
)

alter table userInfo3
  add eng int;

alter table userInfo3
  add constraint check_userInfo3_eng check(eng >= 0 and eng <= 100)
  
alter table userInfo3
  add mat int;
  
alter table userInfo3
  add constraint check_userInfo3_mat check(mat between 0 and 100)
  
insert into userInfo3 values('±è¿µÈñ','kim1234','5643',88,100)

select * from userInfo3
