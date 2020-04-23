CREATE TABLE IF NOT EXISTS `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(80) NOT NULL
);

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `username` varchar(80) NOT NULL,
  `password` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL
);

CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(80) NOT NULL,
  `qtd` varchar(80) NOT NULL,
  `price` decimal(13, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	`client_id` bigint(20),
    CONSTRAINT fk_client FOREIGN KEY (`client_id`) REFERENCES client(`id`),
  	`product_id` bigint(20),
    CONSTRAINT fk_product FOREIGN KEY (`product_id`) REFERENCES product(`id`),
  `qtd` varchar(80) NOT NULL,
  `price` decimal(13, 2) NOT NULL
);
