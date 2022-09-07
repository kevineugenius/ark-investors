-- The difference between a client and an investor in terms of who has access to the application
-- was quite ambiguous.  I have proceeded as though clients only have access to add or remove
-- investors and funds while investors only have access to perform transactions.
CREATE TABLE IF NOT EXISTS `user_type` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `user` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`type` int NOT NULL REFERENCES user_type(id),
`username` varchar(20) NOT NULL,
`password` varchar(512) NOT NULL
);

CREATE TABLE IF NOT EXISTS `investor` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`created_by` int NOT NULL REFERENCES clients(id),
`name` varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `clients` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `fund` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL,
`created_by` int NOT NULL REFERENCES clients(id)
);

CREATE TABLE IF NOT EXISTS `transaction_type` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `transaction` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`type` int NOT NULL REFERENCES transaction_type(id),
`amount` decimal(19,4) NOT NULL,
`date` datetime NOT NULL DEFAULT(current_timestamp)
);

CREATE TABLE IF NOT EXISTS `fund_investors` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`fund_investor` int NOT NULL,
`fund` int NOT NULL REFERENCES fund(id),
`investor` int NOT NULL REFERENCES investor(id)
);
