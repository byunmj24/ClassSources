CREATE SEQUENCE memo_seq
increment by 1
start with 1
nomaxvalue;

CREATE TABLE memo_t(
	idx 	NUMBER(6),
	writer 	VARCHAR2(30),
	content VARCHAR2(4000),
	reg_date DATE,
	ip 	VARCHAR2(30),
	CONSTRAINT memo_t_pk PRIMARY KEY(idx)
);