drop table if exists users;
DROP SEQUENCE if exists global_seq;

CREATE SEQUENCE global_seq START WITH 1000;

create table if not exists users
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    email    VARCHAR(64) NOT NULL UNIQUE,
    name     VARCHAR(32) NOT NULL,
    surName  VARCHAR(32),
    phone    VARCHAR(13) NOT NULL ,
    password VARCHAR(32) NOT NULL
);

