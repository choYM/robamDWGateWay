CREATE TABLE `user` (
  `name` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `id` char(20) NOT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `retailerCountry` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;
