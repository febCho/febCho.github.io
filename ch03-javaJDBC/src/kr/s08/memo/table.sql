create table memo(
 num number primary key, -- 글번호
 name varchar2(30) not null, -- 작성자
 passwd varchar2(10) not null, -- 비밀번호
 subject varchar2(60) not null, -- 제목
 content varchar2(4000) not null, -- 내용
 email varchar2(60), -- 이메일 주소
 reg_date date not null -- 작성일 
);

create sequence memo_seq;