-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rentalcarsdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rentalcarsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rentalcarsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `rentalcarsdb` ;

-- -----------------------------------------------------
-- Table `rentalcarsdb`.`sede`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rentalcarsdb`.`sede` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `end_bairro` VARCHAR(60) NOT NULL,
  `end_cep` VARCHAR(10) NULL DEFAULT NULL,
  `end_cidade` VARCHAR(60) NULL DEFAULT NULL,
  `end_complemento` VARCHAR(60) NULL DEFAULT NULL,
  `end_estado` VARCHAR(60) NULL DEFAULT NULL,
  `end_nome_lugradouro` VARCHAR(60) NOT NULL,
  `end_tipo_lugradouro` VARCHAR(20) NOT NULL,
  `end_numero` VARCHAR(10) NULL DEFAULT NULL,
  `multa_sede_diferente` DECIMAL(19,2) NULL DEFAULT NULL,
  `nome` VARCHAR(40) NOT NULL,
  `nome_gerente` VARCHAR(40) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rentalcarsdb`.`carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rentalcarsdb`.`carro` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ano` YEAR(4) NULL DEFAULT NULL,
  `classe` VARCHAR(20) NOT NULL,
  `cor` VARCHAR(20) NULL DEFAULT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  `modelo` VARCHAR(30) NULL DEFAULT NULL,
  `placa` VARCHAR(10) NULL DEFAULT NULL,
  `quilometragem` INT(11) NULL DEFAULT NULL,
  `situacao` VARCHAR(20) NOT NULL,
  `valor_diaria` DECIMAL(19,2) NULL DEFAULT NULL,
  `id_sede_atual` INT(11) NULL DEFAULT NULL,
  `id_sede_de_origem` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKe3f429tvqu0yjqfhjageshtpd` (`id_sede_atual` ASC) VISIBLE,
  INDEX `FKj3sm4fsgcwg18vim0eb8k8xaa` (`id_sede_de_origem` ASC) VISIBLE,
  CONSTRAINT `FKe3f429tvqu0yjqfhjageshtpd`
    FOREIGN KEY (`id_sede_atual`)
    REFERENCES `rentalcarsdb`.`sede` (`id`),
  CONSTRAINT `FKj3sm4fsgcwg18vim0eb8k8xaa`
    FOREIGN KEY (`id_sede_de_origem`)
    REFERENCES `rentalcarsdb`.`sede` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 101
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rentalcarsdb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rentalcarsdb`.`cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `categoria_cnh` VARCHAR(20) NULL DEFAULT NULL,
  `numero_cnh` VARCHAR(60) NOT NULL,
  `validade_cnh` DATE NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_62uiuvr9jpnkok8sve9l23dvg` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 101
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rentalcarsdb`.`cliente_enderecos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rentalcarsdb`.`cliente_enderecos` (
  `id_cliente` INT(11) NOT NULL,
  `bairro` VARCHAR(60) NOT NULL,
  `cep` CHAR(10) NULL DEFAULT NULL,
  `cidade` VARCHAR(60) NULL DEFAULT NULL,
  `complemento` VARCHAR(60) NULL DEFAULT NULL,
  `estado` VARCHAR(60) NULL DEFAULT NULL,
  `nome_lugradouro` VARCHAR(40) NOT NULL,
  `tipo_lugradouro` VARCHAR(20) NOT NULL,
  `numero` VARCHAR(15) NULL DEFAULT NULL,
  INDEX `FKbnbsija7m45gv41thqjbhu924` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `FKbnbsija7m45gv41thqjbhu924`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `rentalcarsdb`.`cliente` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rentalcarsdb`.`cliente_telefones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rentalcarsdb`.`cliente_telefones` (
  `id_cliente` INT(11) NOT NULL,
  `codigo_area` CHAR(2) NULL DEFAULT NULL,
  `numero` CHAR(10) NOT NULL,
  INDEX `FKr8ogbtndhm3h8owmsw5twu8xh` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `FKr8ogbtndhm3h8owmsw5twu8xh`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `rentalcarsdb`.`cliente` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rentalcarsdb`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rentalcarsdb`.`reserva` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data_locacao` DATE NOT NULL,
  `data_retorno` DATE NULL DEFAULT NULL,
  `qtde_diarias` INT(11) NOT NULL,
  `quilometros_rodados` INT(11) NULL DEFAULT NULL,
  `multa` DECIMAL(19,2) NOT NULL,
  `numero` VARCHAR(10) NULL DEFAULT NULL,
  `situacao` VARCHAR(20) NULL DEFAULT NULL,
  `valor_total` DECIMAL(19,2) NOT NULL,
  `id_carro` INT(11) NOT NULL,
  `id_cliente` INT(11) NOT NULL,
  `id_sede_devolucao` INT(11) NULL DEFAULT NULL,
  `id_sede_locacao` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKitg2bk1ruf0auvoeh4s269smg` (`id_carro` ASC) VISIBLE,
  INDEX `FKmnnu1h1ni5wn43tk7ywak9bb` (`id_cliente` ASC) VISIBLE,
  INDEX `FKsbwfg6cl5q1xqkqkym9vvagdv` (`id_sede_devolucao` ASC) VISIBLE,
  INDEX `FK4g8ss4oipo19hd6hic8edabjh` (`id_sede_locacao` ASC) VISIBLE,
  CONSTRAINT `FK4g8ss4oipo19hd6hic8edabjh`
    FOREIGN KEY (`id_sede_locacao`)
    REFERENCES `rentalcarsdb`.`sede` (`id`),
  CONSTRAINT `FKitg2bk1ruf0auvoeh4s269smg`
    FOREIGN KEY (`id_carro`)
    REFERENCES `rentalcarsdb`.`carro` (`id`),
  CONSTRAINT `FKmnnu1h1ni5wn43tk7ywak9bb`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `rentalcarsdb`.`cliente` (`id`),
  CONSTRAINT `FKsbwfg6cl5q1xqkqkym9vvagdv`
    FOREIGN KEY (`id_sede_devolucao`)
    REFERENCES `rentalcarsdb`.`sede` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 101
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rentalcarsdb`.`sede_telefones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rentalcarsdb`.`sede_telefones` (
  `id_sede` INT(11) NOT NULL,
  `codigo_area` CHAR(2) NULL DEFAULT NULL,
  `numero` CHAR(10) NOT NULL,
  INDEX `FKe8vxmta9r1ac53lxiasc0m23n` (`id_sede` ASC) VISIBLE,
  CONSTRAINT `FKe8vxmta9r1ac53lxiasc0m23n`
    FOREIGN KEY (`id_sede`)
    REFERENCES `rentalcarsdb`.`sede` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
