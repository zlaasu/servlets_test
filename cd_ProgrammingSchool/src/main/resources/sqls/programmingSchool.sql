CREATE DATABASE programmingSchool CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE users_group
(
    id   int AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE exercise
(
    id          int AUTO_INCREMENT,
    title       VARCHAR(255),
    description TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE users
(
    id            int AUTO_INCREMENT,
    user_group_id int,
    username      VARCHAR(255),
    email         VARCHAR(255),
    password      VARCHAR(245),
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (user_group_id) REFERENCES users_group (id)
);

CREATE TABLE solution
(
    id          int AUTO_INCREMENT,
    exercise_id int,
    user_id    int,
    created     DATETIME,
    updated     DATETIME,
    description TEXT,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (exercise_id) REFERENCES exercise (id),
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES users (id)
);
