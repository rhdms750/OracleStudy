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
  
insert into userInfo3 values('ȫ�浿','hong123','1234'); -- OK
insert into userInfo3(name) values('���浿'); -- ����! ������ �̻��� : �� ���Ἲ ���� 
                                            --ORA-01400: NULL�� ("TEST1"."USERINFO3"."ID") �ȿ� ������ �� �����ϴ�
insert into userInfo3 values('�ٱ浿','hong123','2345'); -- ����! �ߺ��� �߰� : ���� ���Ἲ ����
                                                       -- ORA-00001: ���Ἲ ���� ����(TEST1.SYS_C004094)�� ����˴ϴ�
insert into userInfo3 values('���浿','hong234','')