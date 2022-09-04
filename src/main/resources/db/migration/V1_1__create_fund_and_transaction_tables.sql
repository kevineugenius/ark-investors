CREATE TABLE IF NOT EXISTS `fund` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `transaction_type` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `transaction` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`type` int NOT NULL REFERENCES transaction_type(id),
`amount` float(24) NOT NULL,
`date` datetime NOT NULL DEFAULT(current_timestamp)
);
