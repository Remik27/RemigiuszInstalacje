--Integer id,
--        Address address,
--        Stage stage,
--        BigDecimal materialCosts,
--        BigDecimal workCosts,
--        OffsetDateTime startDate,
--        OffsetDateTime deadline
 create TABLE build
    (
        id              SERIAL                      NOT NULL,
        address_id      INT                         NOT NULL,
        stage           VARCHAR(32)                 NOT NULL,
        material_costs  NUMERIC(7,2),
        work_costs      NUMERIC(7,2),
        start_date      TIMESTAMP WITH TIME ZONE    NOT NULL,
        deadline        TIMESTAMP WITH TIME ZONE    NOT NULL,
        PRIMARY KEY(id),
        CONSTRAINT fk_address
            FOREIGN KEY(address_id)
                REFERENCES address(id)
    );