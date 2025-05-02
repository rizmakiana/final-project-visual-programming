-- Active: 1746109704149@@127.0.0.1@3306

show DATABASEs;

CREATE DATABASE final_project_visual_programming;

use final_project_visual_programming;

show TABLEs;

alter Table teachers;

DESC teachers;

CREATE TABLE teachers (
    id VARCHAR(16) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birth_place VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    gender ENUM('Laki-laki', 'Perempuan') NOT NULL,
    address TEXT NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL
);

DROP Table teacher;



ALTER TABLE teachers MODIFY COLUMN birth_date DATE;

CREATE Table admin (
    username varchar(100),
    password VARCHAR(100)
);

