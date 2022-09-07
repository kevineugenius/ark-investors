CREATE TABLE IF NOT EXISTS `clients` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `investor` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`created_by` int NOT NULL REFERENCES clients(id),
`name` varchar(20) NOT NULL
);