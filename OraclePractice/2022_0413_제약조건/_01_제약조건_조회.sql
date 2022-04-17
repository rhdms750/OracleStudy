create table userInfo3
(
    name      varchar2(100) not null,
    id        varchar2(100) not null unique,
    password  varchar2(100) not null
)
/

alter table userInfo3 
  add constraint unique_userInfo3_name unique(name);
  
select owner, constraint_name, constraint_type, table_name from user_constraints

select owner, constraint_name, constraint_type, table_name from user_constraints
  where table_name = upper('userInfo3')

insert into userInfo3 values('È«±æµ¿','hong123','1234'); 
insert into userInfo3 values('±èÃ¶¼ö','park123','2345');

