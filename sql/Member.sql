create table member
(
    id number PRIMARY KEY,
    login_id varchar2(50) not null,
    password varchar2(50) not null,
    password2 varchar2(50) not null,
    name varchar2(50) not null,
    email varchar2(50),
    phone_number varchar2(50)

);
create SEQUENCE member_seq
    START WITH 1          -- 시작을 1부터
    INCREMENT BY 1        -- 1씩 증가
    NOMAXVALUE            -- 최대값 제한 없음
    NOCYCLE;              -- 사이클 없음
