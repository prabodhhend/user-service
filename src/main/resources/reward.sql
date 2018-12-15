create database users;

use users;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT '',
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `country_code` varchar(10) ,
  `contact_number` varchar(10) ,
  `account_expired` bit(1) DEFAULT b'0',
  `is_enabled` bit(1) DEFAULT b'1',
  `is_verified` bit(1) DEFAULT b'1',
  `is_deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;