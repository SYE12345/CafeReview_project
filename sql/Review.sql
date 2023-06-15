create table review(
    id number primary key,
    review_title VARCHAR2(50) not null,
    review_content VARCHAR2(50) not null
);

create SEQUENCE review_seq
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE
    NOCYCLE;