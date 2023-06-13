create table cafe_member
(
    cafe_id number PRIMARY KEY,
    cafe_name varchaar2(50),
    address varchar2(50),
    number varchar2(50),
    menu1 varchar2(50),
    menu2 varchar2(50),
    menu3 varchar2(50),
    type varchar2(50)
);

create sequence cafe_member_seq
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE
    NOCYCLE;