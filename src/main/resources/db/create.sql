SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS team (
    teamId int PRIMARY KEY auto_increment,
    name VARCHAR,
    description VARCHAR
);

CREATE TABLE IF NOT EXISTS member (
    memberId int PRIMARY KEY auto_increment,
    teamId INTEGER,
    firstName VARCHAR,
    lastName VARCHAR,
    email VARCHAR,
    favoritecolor VARCHAR,
    skills VARCHAR
);