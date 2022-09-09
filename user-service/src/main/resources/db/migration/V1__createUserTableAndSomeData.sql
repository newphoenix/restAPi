CREATE TABLE `user_service`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`));


INSERT INTO `user_service`.`user` (`name`, `surname`, `age`) VALUES ('John', 'Smith', '34');
INSERT INTO `user_service`.`user` (`name`, `surname`, `age`) VALUES ('Amanda', 'Will', '22');
INSERT INTO `user_service`.`user` (`name`, `surname`, `age`) VALUES ('Rick', 'Miller', '42');
INSERT INTO `user_service`.`user` (`name`, `surname`, `age`) VALUES ('Suzan', 'MArin', '36');