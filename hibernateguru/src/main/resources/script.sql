create schema gurudb;
use gurudb;
CREATE TABLE users(
username varchar(128) PRIMARY KEY,
firstname VARCHAR(128),
lastname VARCHAR(128),
birth_date DATE,
role VARCHAR(32)
);

DROP TABLE users;


CREATE TABLE users1(
firstname VARCHAR(128),
lastname VARCHAR(128),
birth_date DATE,
username VARCHAR(92) UNIQUE,
role VARCHAR(32),
PRIMARY KEY(firstname, lastname,birth_date)
);