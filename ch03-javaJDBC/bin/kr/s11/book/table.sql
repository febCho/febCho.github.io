create table member(
 me_id varchar2(10) primary key,
 me_passwd varchar2(10) not null,
 me_name varchar2(30) not null,
 me_phone varchar2(13) not null,
 me_regdate date default sysdate not null
);

create table book(
 bk_num number primary key,
 bk_name varchar2(90) not null,
 bk_category varchar2(30) not null,
 bk_regdate date default sysdate not null
);

create sequence book_seq;

create table reservation(
 re_num number primary key,
 re_status number(1) not null, -- 0. 반납(미대출), 1. 대출중
 bk_num number not null references book (bk_num),
 me_id varchar2(10) not null references member (me_id),
 re_regdate date default sysdate not null,
 re_modifydate date -- 변경 시에만 사용할 거라 null 허용
);

create sequence reservation_seq;