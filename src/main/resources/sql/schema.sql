DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `map`;

CREATE TABLE `map` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `franchiseDate` DATE NOT NULL,
  `name` varchar(100),
  `longitude` varchar(100),
  `dataDate` DATE NOT NULL,
  `streetAddress` varchar(100) DEFAULT NULL,
  `sector` varchar(100) DEFAULT NULL,
  `latitude` varchar(100),
  `numberAddress` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idx`)
);

CREATE TABLE `user` (
  `idx` int(10) NOT NULL AUTO_INCREMENT,
  `id` varchar(10) NOT NULL,
  `pw` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  PRIMARY KEY (`idx`),
  UNIQUE KEY `user_un` (`id`),
  UNIQUE KEY `user_un2` (`email`)
);

CREATE TABLE `user_role` (
  `idx` int(10) NOT NULL AUTO_INCREMENT,
  `user_idx` int(10) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`idx`),
  CONSTRAINT `user_role_check` CHECK (`role` in ('ADMIN','USER'))
)