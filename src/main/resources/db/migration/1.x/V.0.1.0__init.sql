CREATE TABLE IF NOT EXISTS ITEM(
    ID BIGINT AUTO_INCREMENT primary key,
    NAME varchar(255) not null default '',
    PRICE numeric not null default 0.0
);

INSERT INTO ITEM('NAME', 'PRICE') VALUES ( 'ITEM 1', 30.4 );
INSERT INTO ITEM('NAME', 'PRICE') VALUES ( 'ITEM 2', 20.0 );
INSERT INTO ITEM('NAME', 'PRICE') VALUES ( 'ITEM 3', 31.8 );
INSERT INTO ITEM('NAME', 'PRICE') VALUES ( 'ITEM 4', 11.6 );

CREATE TABLE IF NOT EXISTS ORDER(
                                   ID BIGINT AUTO_INCREMENT primary key,
                                   REFERENCE varchar(255) not null,
                                   STATUS varchar(10) not null,
);

INSERT INTO ORDER('REFERENCE', 'STATUS') VALUES ('ORDER 1', 'CONFIRMED' );
INSERT INTO ORDER('REFERENCE', 'STATUS') VALUES ('ORDER 2', 'PLACED' );


CREATE TABLE IF NOT EXISTS ORDER_ITEM(
                                    ID BIGINT AUTO_INCREMENT primary key,
                                    ITEM_ID BIGINT references ITEM(ID),
                                    ORDER_ID BIGINT references ORDER(ID),
                                    QUANTITY number not null,
);

INSERT INTO ORDER_ITEM('ITEM_ID', 'ORDER_ID', 'QUANTITY') VALUES ( 1, 1, 4 );
INSERT INTO ORDER_ITEM('ITEM_ID', 'ORDER_ID', 'QUANTITY') VALUES ( 2, 1, 3 );
INSERT INTO ORDER_ITEM('ITEM_ID', 'ORDER_ID', 'QUANTITY') VALUES ( 3, 2, 5 );
INSERT INTO ORDER_ITEM('ITEM_ID', 'ORDER_ID', 'QUANTITY') VALUES ( 4, 2, 10 );

