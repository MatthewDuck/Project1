CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`id` INT(11)  PRIMARY KEY AUTO_INCREMENT,
    `item_name` VARCHAR(60) NOT NULL,
    `price` Double NOT NULL
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `item_id` INT NOT NULL,
    `order_id` INT NOT NULL,
    FOREIGN KEY (`item_id`) REFERENCES `ims`.`items` (`id`),
    FOREIGN KEY (`order_id`) REFERENCES `ims`.`order` (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `ims`.`customers` (`id`)
);
