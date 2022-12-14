CREATE TABLE IF NOT EXISTS `fund` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL,
`created_by` int NOT NULL REFERENCES client(id)
);

CREATE TABLE IF NOT EXISTS `transaction_type` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL,
`multiplier` int NOT NULL
);

CREATE TABLE IF NOT EXISTS `transaction` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`type` int NOT NULL REFERENCES transaction_type(id),
`amount` decimal(19,4) NOT NULL,
`date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`investor_id` int NOT NULL REFERENCES investor(id),
`fund_id` int NOT NULL REFERENCES fund(id)
);

CREATE TABLE IF NOT EXISTS `fund_investor` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`fund` int NOT NULL REFERENCES fund(id),
`investor` int NOT NULL REFERENCES investor(id)
);
