-- MySQL Script generated by MySQL Workbench
-- 04/11/15 23:22:02
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema appgestionagencelocationvoiture
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `appgestionagencelocationvoiture` ;

-- -----------------------------------------------------
-- Schema appgestionagencelocationvoiture
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `appgestionagencelocationvoiture` DEFAULT CHARACTER SET utf8 ;
USE `appgestionagencelocationvoiture` ;

-- -----------------------------------------------------
-- Table `appgestionagencelocationvoiture`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `appgestionagencelocationvoiture`.`client` ;

CREATE TABLE IF NOT EXISTS `appgestionagencelocationvoiture`.`client` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cin` VARCHAR(45) NULL DEFAULT NULL,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `telephone` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `appgestionagencelocationvoiture`.`voiture`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `appgestionagencelocationvoiture`.`voiture` ;

CREATE TABLE IF NOT EXISTS `appgestionagencelocationvoiture`.`voiture` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `immatriculation` VARCHAR(45) NULL DEFAULT NULL,
  `couleur` VARCHAR(45) NULL DEFAULT NULL,
  `dateMiseEncirculation` DATE NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 39
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `appgestionagencelocationvoiture`.`location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `appgestionagencelocationvoiture`.`location` ;

CREATE TABLE IF NOT EXISTS `appgestionagencelocationvoiture`.`location` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dateDebut` DATE NULL DEFAULT NULL,
  `dateFin` DATE NULL DEFAULT NULL,
  `duree` VARCHAR(45) NULL DEFAULT NULL,
  `idVoiture` INT(11) NULL DEFAULT NULL,
  `idClient` INT(11) NULL DEFAULT NULL,
  `idLocation` VARCHAR(200) NULL DEFAULT NULL,
  `prixUnitaire` INT(11) NULL DEFAULT NULL,
  `sommeTotale` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idVehicule_idx` (`idVoiture` ASC),
  INDEX `idClient_idx` (`idClient` ASC),
  CONSTRAINT `idClient`
    FOREIGN KEY (`idClient`)
    REFERENCES `appgestionagencelocationvoiture`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idVoiture`
    FOREIGN KEY (`idVoiture`)
    REFERENCES `appgestionagencelocationvoiture`.`voiture` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;