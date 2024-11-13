-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mercadinho
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mercadinho
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mercadinho` DEFAULT CHARACTER SET utf8mb4 ;
USE `mercadinho` ;

-- -----------------------------------------------------
-- Table `mercadinho`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mercadinho`.`cliente` (
  `idCliente` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `endereco` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `telefone` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `mercadinho`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mercadinho`.`funcionario` (
  `idFuncionario` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cargo` VARCHAR(255) NULL DEFAULT NULL,
  `cpf` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `horarioTrabalho` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `salario` DOUBLE NOT NULL,
  `telefone` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`idFuncionario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `mercadinho`.`cliente_funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mercadinho`.`cliente_funcionario` (
  `cliente_id` BIGINT(20) NOT NULL,
  `funcionario_id` BIGINT(20) NOT NULL,
  INDEX `FKsregub83nvftxx7bsg6uxkb1n` (`funcionario_id` ASC) VISIBLE,
  INDEX `FKsy6x24py3l5g9p66x2w96mo2y` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `FKsregub83nvftxx7bsg6uxkb1n`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `mercadinho`.`funcionario` (`idFuncionario`),
  CONSTRAINT `FKsy6x24py3l5g9p66x2w96mo2y`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `mercadinho`.`cliente` (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `mercadinho`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mercadinho`.`fornecedor` (
  `idFornecedor` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `endereco` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `produtosFornecidos` VARCHAR(255) NULL DEFAULT NULL,
  `telefone` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`idFornecedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `mercadinho`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mercadinho`.`produto` (
  `idProduto` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(255) NULL DEFAULT NULL,
  `dataValidade` DATE NULL DEFAULT NULL,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `preco` DOUBLE NOT NULL,
  `quantidadeEstoque` INT(11) NOT NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `mercadinho`.`produto_fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mercadinho`.`produto_fornecedor` (
  `produto_id` BIGINT(20) NOT NULL,
  `fornecedor_id` BIGINT(20) NOT NULL,
  INDEX `FKju3ce6732sap2918m63mer0c3` (`fornecedor_id` ASC) VISIBLE,
  INDEX `FKk3gehn487pjjntqyk8xtd9flx` (`produto_id` ASC) VISIBLE,
  CONSTRAINT `FKju3ce6732sap2918m63mer0c3`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `mercadinho`.`fornecedor` (`idFornecedor`),
  CONSTRAINT `FKk3gehn487pjjntqyk8xtd9flx`
    FOREIGN KEY (`produto_id`)
    REFERENCES `mercadinho`.`produto` (`idProduto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `mercadinho`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mercadinho`.`venda` (
  `idVenda` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `dataVenda` DATE NULL DEFAULT NULL,
  `formaPagamento` VARCHAR(255) NULL DEFAULT NULL,
  `status` INT(11) NULL DEFAULT NULL,
  `totalVenda` DOUBLE NOT NULL,
  `cliente_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`idVenda`),
  INDEX `FKdofv694x76omty2jcr43wpi4y` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `FKdofv694x76omty2jcr43wpi4y`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `mercadinho`.`cliente` (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `mercadinho`.`venda_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mercadinho`.`venda_produto` (
  `venda_id` BIGINT(20) NOT NULL,
  `produto_id` BIGINT(20) NOT NULL,
  INDEX `FKia8lfuu8rad70hbhhdcl0fwiu` (`produto_id` ASC) VISIBLE,
  INDEX `FKe2kn4o8opics28jpbrurrw2mn` (`venda_id` ASC) VISIBLE,
  CONSTRAINT `FKe2kn4o8opics28jpbrurrw2mn`
    FOREIGN KEY (`venda_id`)
    REFERENCES `mercadinho`.`venda` (`idVenda`),
  CONSTRAINT `FKia8lfuu8rad70hbhhdcl0fwiu`
    FOREIGN KEY (`produto_id`)
    REFERENCES `mercadinho`.`produto` (`idProduto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
