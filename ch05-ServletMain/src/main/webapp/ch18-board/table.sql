-- 게시판
create table smboard(
 num number primary key,
 title varchar2(150) not null,
 name varchar2(30) not null,
 passwd varchar2(12) not null,
 content clob not null,
 ip varchar2(30) not null,
 reg_date date default sysdate not null
);
create sequence smboard_seq;