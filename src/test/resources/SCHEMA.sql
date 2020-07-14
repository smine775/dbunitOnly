-- DROP TABLE if  EXISTS user;
drop table  if exists user;
CREATE TABLE `user`(
  `id` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- insert into "user" values ("22","sd",123);