-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
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
  PRIMARY KEY (`id_discount_card`),
  UNIQUE INDEX `id_discount_card_UNIQUE` (`id_discount_card` ASC) VISIBLE,
  UNIQUE INDEX `number_UNIQUE` (`number` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `billgenerator`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `billgenerator`.`products` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `prise` DOUBLE NOT NULL,
  `total_prise` DOUBLE NULL DEFAULT NULL,
  `is_on_sale` TINYINT NULL DEFAULT '0',
  `discount_amount` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `id_product_UNIQUE` (`id_product` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- -----------------------------------------------------
-- Populate Table `products`
-- -----------------------------------------------------

insert into products (name, quantity, prise ) values ('Kindness', 3, 7.25);
insert into products (name, quantity, prise ) values ('Solidarity', 1, 4.15);
insert into products (name, quantity, prise ) values ('Sensitivity', 7, 5.48);
insert into products (name, quantity, prise ) values ('Empathy', 5, 4.00);
insert into products (name, quantity, prise ) values ('Humility', 4, 9.50);
insert into products (name, quantity, prise ) values ('Intelligence', 12, 1.1);
insert into products (name, quantity, prise, is_on_sale ) values ('Benevolence', 3, 2.50, 1);

-- -----------------------------------------------------
-- Populate Table `discount_cards`
-- -----------------------------------------------------

insert into discount_cards (number) values (1234);
insert into discount_cards (number) values (1235);
insert into discount_cards (number) values (1236);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
