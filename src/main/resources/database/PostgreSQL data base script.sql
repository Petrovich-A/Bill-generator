CREATE TABLE IF NOT EXISTS discount_cards
(
  id_discount_card SERIAL PRIMARY KEY UNIQUE,
  number INTEGER UNIQUE NOT NULL,
  discount_percent NUMERIC(5,2) NOT NULL CHECK(discount_percent > 0)
);
  
INSERT INTO discount_cards (number, discount_percent) values (1234, 10);
INSERT INTO discount_cards (number, discount_percent) values (1235, 8);
INSERT INTO discount_cards (number, discount_percent) values (1236, 2.5);

CREATE TABLE IF NOT EXISTS products (
  id_product SERIAL PRIMARY KEY UNIQUE,
  name VARCHAR(45) NOT NULL,
  prise NUMERIC(5,2) NOT NULL CHECK(prise > 0),
  is_on_sale BOOLEAN NOT NULL DEFAULT FALSE
) ;

insert into products (name, prise ) values ('Kindness', 7.25);
insert into products (name, prise ) values ('Solidarity', 4.15);
insert into products (name, prise ) values ('Sensitivity', 5.48);
insert into products (name, prise ) values ('Empathy', 4.00);
insert into products (name, prise ) values ('Humility', 9.50);
insert into products (name, prise ) values ('Intelligence', 1.1);
insert into products (name, prise, is_on_sale ) values ('Benevolence', 2.50, TRUE);