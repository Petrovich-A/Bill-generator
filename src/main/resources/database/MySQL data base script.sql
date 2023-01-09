CREATE SCHEMA IF NOT EXISTS `billgenerator` DEFAULT CHARACTER SET utf8 ;
USE `billgenerator` ;

CREATE TABLE IF NOT EXISTS `billgenerator`.`products` (
  `id_product` INT NOT NULL AUTO_INCREMENT UNIQUE NOT NULL PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL UNIQUE,
  `prise` DOUBLE NOT NULL,
  `is_on_sale` TINYINT NOT NULL DEFAULT '0')
AUTO_INCREMENT = 0;

CREATE TABLE IF NOT EXISTS `billgenerator`.`discount_cards` (
  `id_discount_card` INT  NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
  `number` INT NOT NULL UNIQUE,
  `discount_percent` DOUBLE NOT NULL)
  AUTO_INCREMENT = 0;
  
insert into discount_cards (number, discount_percent) values (1234, 10);
insert into discount_cards (number, discount_percent) values (1235, 8);
insert into discount_cards (number, discount_percent) values (1236, 2.5);

insert into products (name, prise ) values ('Kindness', 7.25);
insert into products (name, prise ) values ('Solidarity', 4.15);
insert into products (name, prise ) values ('Sensitivity', 5.48);
insert into products (name, prise ) values ('Empathy', 4.00);
insert into products (name, prise ) values ('Humility', 9.50);
insert into products (name, prise ) values ('Intelligence', 1.1);
insert into products (name, prise, is_on_sale ) values ('Benevolence', 2.50, 1);