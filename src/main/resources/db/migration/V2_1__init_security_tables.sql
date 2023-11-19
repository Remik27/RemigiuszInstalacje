CREATE TABLE users
(
    id          SERIAL          NOT NULL,
    username    VARCHAR(32)     NOT NULL,
    email       VARCHAR(32)     NOT NULL,
    password    VARCHAR(255)    NOT NULL,
    active      BOOLEAN         NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE roles
(
    id      SERIAL          NOT NULL,
    role    VARCHAR(32)     NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE users_roles
(
    user_id     INT     NOT NULL,
    role_id     INT     NOT NULL,
    PRIMARY KEY(user_id, role_id)
)