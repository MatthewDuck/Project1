INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jack', 'harrison');
INSERT INTO `orders` (`customer_id`) VALUES (1);
INSERT INTO `orders` (`customer_id`) VALUES (2);
INSERT INTO `items` (`item_name`, `price`) VALUES ('Hammer', 20.00);
INSERT INTO `items` (`item_name`, `price`) VALUES ('Bike', 20.00);
INSERT INTO `order_items` (`item_id`, `order_id`) VALUES (1, 1);
INSERT INTO `order_items` (`item_id`, `order_id`) VALUES (1, 1);
INSERT INTO `order_items` (`item_id`, `order_id`) VALUES (1, 1);
INSERT INTO `order_items` (`item_id`, `order_id`) VALUES (2, 1);
INSERT INTO `order_items` (`item_id`, `order_id`) VALUES (2, 2);