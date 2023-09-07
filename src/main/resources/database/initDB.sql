DROP TABLE IF EXISTS user_categories;

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS psychologist;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1000;

CREATE TABLE IF NOT EXISTS users
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    email    VARCHAR(64) NOT NULL UNIQUE,
    name     VARCHAR(32),
    surName  VARCHAR(32) NOT NULL ,
    phone    VARCHAR(13),
    password VARCHAR(32) NOT NULL,
    role     VARCHAR
);

CREATE SEQUENCE psych_seq START WITH 100000;
CREATE TABLE IF NOT EXISTS psychologist (
    id          INTEGER PRIMARY KEY DEFAULT nextval('psych_seq'),
    name        VARCHAR,
    surName     VARCHAR,
    email       VARCHAR,
    phone       VARCHAR,
    price       VARCHAR,
    location    VARCHAR,
    online      BOOLEAN,
    offline     BOOLEAN,
    experience  INTEGER,
    rating      INTEGER,
    description VARCHAR,
    photoLink   VARCHAR
)

-- CREATE TABLE user_roles
-- (
--     user_id INTEGER NOT NULL,
--     role    VARCHAR NOT NULL,
--     CONSTRAINT user_roles_idx UNIQUE (user_id, role),
--     FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
-- );

-- CREATE TABLE IF NOT EXISTS user_categories
-- (
--     user_id INTEGER NOT NULL,
--     categories VARCHAR NOT NULL,
--     CONSTRAINT user_categories_idx UNIQUE (user_id,categories),
--     FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
-- );
