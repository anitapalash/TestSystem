BEGIN;

CREATE TABLE IF NOT EXISTS Users2(
    id bigint PRIMARY KEY,
    userName VARCHAR(25),
    password VARCHAR(20),
    firstName VARCHAR(25),
    lastName VARCHAR(25),
    groupName VARCHAR(10),
    access VARCHAR(8),
    status VARCHAR(7),
    gender VARCHAR(7),
    passedgl BOOLEAN,
    passedgb BOOLEAN,
    passeddn BOOLEAN,
    passedat BOOLEAN,
    passedn BOOLEAN,
    passedgen BOOLEAN
);

INSERT INTO Users2 (id, userName, password, firstName, lastName, groupName, access, status, gender, passedgl, passedgb, passeddn, passedat, passedn, passedgen)
VALUES (0, 'root', 'loveKopos', 'Koposovo', 'Dev', '17БИ1', 'ADMIN', 'ACTIVE', 'Женский', false, false, false, false, false, false) on conflict (id) do nothing;

COMMIT;

