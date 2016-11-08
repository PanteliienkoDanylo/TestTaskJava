CREATE SCHEMA `test_task` DEFAULT CHARACTER SET utf8 ;


CREATE TABLE `test_task`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `sex` VARCHAR(1) NOT NULL,
  `mobile_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));