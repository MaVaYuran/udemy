create schema gurudb;
use gurudb;
CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
username varchar(128) UNIQUE,
firstname VARCHAR(128),
lastname VARCHAR(128),
birth_date DATE,
role VARCHAR(32),
company_id int REFERENCES company(id)
);
CREATE TABLE users1(
id INT PRIMARY KEY AUTO_INCREMENT,
username varchar(128) UNIQUE,
firstname VARCHAR(128),
lastname VARCHAR(128),
birth_date DATE,
role VARCHAR(32),
company_id int REFERENCES company(id)
);

DROP TABLE users1;

CREATE TABLE company(
id int PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(128) NOT NULL UNIQUE
);
--использование натурального ключа
CREATE TABLE profile(
user_id INT PRIMARY KEY REFERENCES users(id),
street VARCHAR(128),
language CHAR(2)
);
--использование синтетического ключа !предпочтительно
CREATE TABLE profile1(
id int PRIMARY KEY,
user_id INT NOT NULL UNIQUE REFERENCES users(id),
street VARCHAR(128),
language CHAR(2)
);

CREATE TABLE CHAT(
ID INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(128) UNIQUE NOT NULL
);
CREATE TABLE USERS_CHAT(
user_id INT REFERENCES users(id),
chat_id INT REFERENCES chat(id),
primary key(user_id, chat_id));