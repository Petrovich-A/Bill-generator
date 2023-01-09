CREATE SCHEMA IF NOT EXISTS billgenerator;
USE billgenerator;

CREATE TABLE IF NOT EXISTS discount_cards
(
  id_discount_card SERIAL PRIMARY KEY UNIQUE,
  number INTEGER UNIQUE NOT NULL,
  discount_percent NUMERIC(5,2) NOT NULL CHECK(discount_percent > 0)
);

 CREATE TABLE IF NOT EXISTS products (
  id_product SERIAL PRIMARY KEY UNIQUE,
  name VARCHAR(45) NOT NULL,
  prise NUMERIC(5,2) NOT NULL CHECK(prise > 0),
  is_on_sale BOOLEAN NOT NULL DEFAULT FALSE
) ; 

INSERT INTO discount_cards (number, discount_percent) values (1234, 10);
INSERT INTO discount_cards (number, discount_percent) values (1235, 8);
INSERT INTO discount_cards (number, discount_percent) values (1236, 2.5);

insert into products (name, prise, is_on_sale ) values ('Aggressiveness', 0.27, TRUE);
insert into products (name, prise) values ('Arrogance', 0.87);
insert into products (name, prise, is_on_sale ) values ('Boastfulness', 1.02, TRUE);
insert into products (name, prise) values ('Cruelty', 0.12);
insert into products (name, prise) values ('Carelessness', 1.5);
insert into products (name, prise) values ('Ignorance', 1.1);
insert into products (name, prise, is_on_sale) values ('Indecisiveness', 0.88, TRUE);