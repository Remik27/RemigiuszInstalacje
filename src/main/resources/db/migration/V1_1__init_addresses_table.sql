--Integer id,
--        String city,
--        String street,
--        String postalCode,
--        String fullAddress

CREATE TABLE address
    (
        id              SERIAL          NOT NULL,
        street          VARCHAR(48)     NOT NULL,
        posta_code      VARCHAR(10)     NOT NULL,
        full_address    VARCHAR(100)    NOT NULL,
        PRIMARY KEY(id)
    );