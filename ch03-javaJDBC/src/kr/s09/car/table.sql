create table car(
 num number primary key, -- 자동차 관리 번호
 name varchar2(30) not null, -- 이름
 cnumber varchar2(30) not null, -- 자동차 번호
 color varchar2(30) not null, -- 색상
 maker varchar2(30) not null, -- 제조사
 price number(10) not null, -- 가격
 reg_date date not null -- 등록일
);

create sequence car_seq;

