create table todo(
 id number primary key, -- 할 일 번호
 todo varchar2(150) not null, -- 할 일
 created date not null, -- 등록일
 completed number(1) not null -- 할 일 수행 여부 0 미완료 1 완료
);
create sequence todo_seq;