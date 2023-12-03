ALTER TABLE BUILD
ADD COLUMN customer_id INT NOT NULL,
ADD CONSTRAINT fk_customer
		FOREIGN KEY(customer_id)
			REFERENCES customer (id)