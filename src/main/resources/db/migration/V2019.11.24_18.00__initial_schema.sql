CREATE SCHEMA wealfy;

CREATE SEQUENCE wealfy.s_action INCREMENT BY 50 START 1;
CREATE SEQUENCE wealfy.s_category INCREMENT BY 50 START 1;

CREATE TABLE wealfy.category (
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(256) NOT NULL UNIQUE,
    color VARCHAR(7) NOT NULL
);

CREATE TABLE wealfy.action (
    id BIGINT NOT NULL PRIMARY KEY,
    info VARCHAR(1024),
    summ DOUBLE NOT NULL,
    created_date TIMESTAMP WITH TIME ZONE NOT NULL,
    category_id BIGINT REFERENCES wealfy.category(id),
    income BOOLEAN NOT NULL DEFAULT false
);