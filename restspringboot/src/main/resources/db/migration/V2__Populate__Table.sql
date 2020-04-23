INSERT INTO `client` (`id`, `name`) VALUES
	(1, 'Paulo'),
	(2, 'João');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES
	(1, 'admin', 'password123', 'asd@123.com'),
	(2, 'user', 'password', 'asd@asd.com');
INSERT INTO `product` (`id`, `name`, `qtd`, `price`) VALUES
	(1, 'Caneta', '3', 1.100),
	(2, 'Borracha', '4', 2.20);
INSERT INTO `orders` (`id`, `client_id`, `product_id`,`qtd`, `price`) VALUES
	(1, 1, 1, 2, 2.20),
	(2, 2, 2, 2, 4.40);
