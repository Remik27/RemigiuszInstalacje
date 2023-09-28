--Integer id,
--    String name,
--    String surname,
--    String email,
--    String phoneNumber

CREATE TABLE customer
    (
        id              SERIAL      NOT NULL,
        name            VARCHAR(32) NOT NULL,
        surname         VARCHAR(32) NOT NULL,
        email           VARCHAR(32) NOT NULL,
        phone_number    VARCHAR(32) NOT NULL,
        PRIMARY KEY(id)
    );
