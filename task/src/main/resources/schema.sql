CREATE TABLE restaurant (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE schedule (
    id SERIAL PRIMARY KEY,
    opening_time VARCHAR(12) NOT NULL,
    closing_time VARCHAR(12) NOT NULL,
    monday BOOLEAN NOT NULL,
    tuesday BOOLEAN NOT NULL,
    wednesday BOOLEAN NOT NULL,
    thursday BOOLEAN NOT NULL,
    friday BOOLEAN NOT NULL,
    saturday BOOLEAN NOT NULL,
    sunday BOOLEAN NOT NULL,
    restaurant_id INTEGER,
    CONSTRAINT fk_restaurant
      FOREIGN KEY(restaurant_id) 
	      REFERENCES restaurant(id)
);