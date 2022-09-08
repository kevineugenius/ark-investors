-- 1.2 skipped because flyway is very picky and it detects an old file that is no longer in use.
-- Probably fixable but the advice given is "don't".

-- The difference between a client and an investor in terms of who has access to the application
-- was quite ambiguous.  I have proceeded as though clients only have access to add or remove
-- investors and funds while investors only have access to perform transactions.
-- The user tables are intended to handle authorization/permissions.
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
