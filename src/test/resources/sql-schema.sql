DROP TABLE `order_items`;
DROP TABLE `orders`;
DROP TABLE `items`;
DROP TABLE `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
	`id` INT(11)  PRIMARY KEY AUTO_INCREMENT ,
    `item_name` VARCHAR(60) NOT NULL,
    `price` Double NOT NULL
);

CREATE TABLE IF NOT EXISTS `orders` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS `order_items` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `item_id` INT NOT NULL,
    `order_id` INT NOT NULL,
    FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE,
    FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE
);