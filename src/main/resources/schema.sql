CREATE TABLE PAYMENT (
	id UUID PRIMARY KEY,
	user_id INT NOT NULL,
	item_id VARCHAR(45) NOT NULL,
	amount INT NOT NULL,
	total FLOAT NOT NULL
);