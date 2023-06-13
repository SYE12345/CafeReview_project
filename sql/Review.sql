create table review(
    id number primary key,
    review_title VARCHAR2(50),
    review_content VARCHAR2(50)
);

create SEQUENCE review_seq
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE
    NOCYCLE;