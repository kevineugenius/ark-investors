CREATE TABLE IF NOT EXISTS `fund` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL,
`created_by` int NOT NULL REFERENCES client(id)
);

-- I would like constraints on this table; it is acting as an enum for credit/debit
CREATE TABLE IF NOT EXISTS `transaction_flow` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`flow_direction` varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `transaction_type` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(20) NOT NULL,
`flow` int NOT NULL REFERENCES transaction_flow(id)
);

CREATE TABLE IF NOT EXISTS `transaction` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`type` int NOT NULL REFERENCES transaction_type(id),
`amount` decimal(19,4) NOT NULL,
`date` datetime NOT NULL DEFAULT(current_timestamp)
);

CREATE TABLE IF NOT EXISTS `fund_investor` (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`fund` int NOT NULL REFERENCES fund(id),
`investor` int NOT NULL REFERENCES investor(id)
);
