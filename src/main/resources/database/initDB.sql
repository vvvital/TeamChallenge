
DROP TABLE IF EXISTS psychologist_categories;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS psychologist;
DROP TYPE IF EXISTS location;
DROP TYPE IF EXISTS categories;

CREATE TYPE Location AS ENUM (
    'KYIV',
    'LVIV',
    'DNIPRO',
    'ODESSA'
    );
CREATE TYPE Categories AS ENUM (
    'PSYCHOTHERAPIST',
    'ORGANIZATIONAL_PSYCHOLOGIST',
    'CHILD_PSYCHOLOGIST'
    );

CREATE TABLE IF NOT EXISTS users
(
    id       BIGSERIAL PRIMARY KEY NOT NULL,
    email    VARCHAR(64)           NOT NULL UNIQUE,
    name     VARCHAR(32),
    surName  VARCHAR(32)           NOT NULL,
    phone    VARCHAR(13),
    password VARCHAR(32)           NOT NULL,
    role     VARCHAR
);

CREATE TABLE IF NOT EXISTS psychologist
(
    id          BIGSERIAL PRIMARY KEY NOT NULL,
    name        VARCHAR,
    surName     VARCHAR,
    email       VARCHAR,
    password    VARCHAR,
    phone       VARCHAR,
    price       VARCHAR,
    location    VARCHAR,
    online      BOOLEAN,
    offline     BOOLEAN,
    experience  INTEGER,
    rating      INTEGER,
    description VARCHAR,
    photoLink   VARCHAR
);

CREATE TABLE psychologist_categories
(
    psychologist_id INTEGER NOT NULL,
    categories      VARCHAR not null ,
    CONSTRAINT user_roles_idx UNIQUE (psychologist_id, categories),
    FOREIGN KEY (psychologist_id) REFERENCES psychologist (id) ON DELETE CASCADE
);

