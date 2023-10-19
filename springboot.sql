drop table myuser;
create table myuser (
    id varchar2(10),
    name varchar2(10)
);

-- 샘플 데이터 직접 추가하기
insert into myuser values ( 'test1', '홍길동1');
insert into myuser values ( 'test2', '홍길동2');
insert into myuser values ( 'test3', '홍길동3');
commit;

drop table simple_bbs;
create table simple_bbs (
    id number(4) primary key,
    writer varchar2(100),
    title varchar2(100),
    content varchar2(100)
);

drop sequence simple_bbs_seq;
create sequence simple_bbs_seq;


create table user_list (
    name varchar2(20) primary key,
    password varchar2(100),
    authority varchar(20),
    enabled number(1)
);

insert into user_list values ('user', '$2a$10$aeBmUoFNSBmt0.7PUaErNeysL.c5chxt.AJTTMTyZdJsQFQ2W0B2.', 'ROLE_USER', 1);
insert into user_list values ('admin', '$2a$10$aeBmUoFNSBmt0.7PUaErNeysL.c5chxt.AJTTMTyZdJsQFQ2W0B2.', 'ROLE_ADMIN', 1);
commit;
delete user_list;
select * from user_list;

insert into JPAMEMBER03 values (1, 'test1@test.com', 'test1');
insert into JPAMEMBER03 values (2, 'test2@test.com', 'test2');
insert into JPAMEMBER03 values (3, 'test3@test.com', 'test3');
insert into JPAMEMBER03 values (4, 'test4@test.com', 'test4');
insert into JPAMEMBER03 values (5, 'test5@test.com', 'test5');
insert into JPAMEMBER03 values (6, 'test6@test.com', 'test6');
insert into JPAMEMBER03 values (7, 'test7@test.com', 'test7');
insert into JPAMEMBER03 values (8, 'test8@test.com', 'test8');
insert into JPAMEMBER03 values (9, 'test9@test.com', 'test9');
insert into JPAMEMBER03 values (10, 'test10@test.com', 'test10');
insert into JPAMEMBER03 values (11, 'test11@test.com', 'test11');
insert into JPAMEMBER03 values (12, 'test12@test.com', 'test12');
insert into JPAMEMBER03 values (13, 'test13@test.com', 'test13');
insert into JPAMEMBER03 values (14, 'test14@test.com', 'test14');
insert into JPAMEMBER03 values (15, 'test15@test.com', 'test15');
insert into JPAMEMBER03 values (16, 'test16@test.com', 'test16');
commit;
