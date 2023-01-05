-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema billgenerator
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema billgenerator
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `billgenerator` DEFAULT CHARACTER SET utf8 ;
USE `billgenerator` ;

-- -----------------------------------------------------
-- Table `billgenerator`.`discount_cards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `billgenerator`.`discount_cards` (
  `id_discount_card` INT NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  `discount_percent` DOUBLE NOT NULL,
  PRIMARY KEY (`id_discount_card`),
  UNIQUE INDEX `id_discount_card_UNIQUE` (`id_discount_card` ASC),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `billgenerator`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `billgenerator`.`products` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `prise` DOUBLE NOT NULL,
  `is_on_sale` TINYINT NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_product`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `id_product_UNIQUE` (`id_product` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb3;

-- -----------------------------------------------------
-- Populate Table `products`
-- -----------------------------------------------------

insert into products (name, prise ) values ('Kindness', 7.25);
insert into products (name, prise ) values ('Solidarity', 4.15);
insert into products (name, prise ) values ('Sensitivity', 5.48);
insert into products (name, prise ) values ('Empathy', 4.00);
insert into products (name, prise ) values ('Humility', 9.50);
insert into products (name, prise ) values ('Intelligence', 1.1);
insert into products (name, prise, is_on_sale ) values ('Benevolence', 2.50, 1);

-- -----------------------------------------------------
-- Populate Table `discount_cards`
-- -----------------------------------------------------

insert into discount_cards (number, discount_percent) values (1234, 10);
insert into discount_cards (number, discount_percent) values (1235, 8);
insert into discount_cards (number, discount_percent) values (1236, 2.5);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
