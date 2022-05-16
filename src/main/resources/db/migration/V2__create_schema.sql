CREATE TABLE IF NOT EXISTS `url` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `real_url` varchar(500) NOT NULL,
    `short_url` varchar(500) NOT NULL
);