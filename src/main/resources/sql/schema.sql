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