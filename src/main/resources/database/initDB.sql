drop table if exists users;

create table if not exists users
(
    id       INTEGER     NOT NULL,
    email    VARCHAR(64) NOT NULL UNIQUE,
    name     VARCHAR(32) NOT NULL,
    surName  VARCHAR(32),
    phone    VARCHAR(13),
    password VARCHAR(32)
);

