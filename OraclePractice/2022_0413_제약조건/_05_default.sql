create table userInfo3
(
    name      varchar2(100) not null,
    id        varchar2(100) not null unique,
    password  varchar2(100) not null,
    eng       int           check(eng between 0 and 100),
    mat       int           check(mat between 0 and 100)
)

alter table userInfo3 
  modify name varchar2(100) default 'UNKNOWN'

  
