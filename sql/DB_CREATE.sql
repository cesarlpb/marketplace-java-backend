CREATE DATABASE practicas_inkor;

use practicas_inkor;

CREATE TABLE `practicas_inkor`.`services` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `category` VARCHAR(30) NULL,
  `description` VARCHAR(1200) NULL,
  `tags` VARCHAR(255) NULL,
  `url` VARCHAR(120) NULL,
  `urlimg` VARCHAR(120) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `practicas_inkor`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `username` VARCHAR(30) NULL,
  `password` VARCHAR(100) NULL,
  `email` VARCHAR(60) NULL,
  PRIMARY KEY (`id`));
 
INSERT INTO `practicas_inkor`.`services`(name,category,description,tags,url,urlimg)
VALUES ("Prueba","test","Esta es el primer registro de la página","test","laurl","urldelaimagen");
  
INSERT INTO `practicas_inkor`.`users`(name,username,password,email)
VALUES ("Lola Galindo","lolalolita","123456","lolamola@test.com");
