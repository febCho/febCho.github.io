create table sitem(
 item_num number primary key, -- 상품 번호
 item_name varchar2(30) not null, -- 상품명
 item_price number(9) not null, -- 가격
 item_date date default sysdate not null -- 등록일, 입력하지 않으면 default 값 동작
);

create sequence sitem_seq;

create table customer(
 cust_id varchar2(30) primary key, -- 아이디
 cust_name varchar2(30) not null, -- 이름
 cust_address varchar2(90) not null, -- 주소
 cust_tel varchar2(20) not null, -- 전화번호
 cust_date date default sysdate not null -- 가입일
);

create table sorder(
 order_num number primary key, -- 주문 번호
 cust_id varchar2(30) references customer (cust_id), -- 주문자 ID, fk 제약 조건+가져오기
 item_num number references sitem (item_num), -- 주문 상품 번호
 order_date date default sysdate not null -- 주문일
);

create sequence sorder_seq;