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

