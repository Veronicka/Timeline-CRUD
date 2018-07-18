create database timelinebd;
use timelinebd;

CREATE TABLE `USUARIO` (
  `usuario_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  PRIMARY KEY (`usuario_id`),
  UNIQUE KEY `usuario_id_UNIQUE` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

CREATE TABLE `LOG_OPERACOES` (
  `log_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `detalhe` varchar(250) NOT NULL,
  `data_hora` TIMESTAMP NOT NULL,
  `usuario_id` BIGINT UNSIGNED,
  PRIMARY KEY (`log_id`),
  UNIQUE KEY `log_id_UNIQUE` (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

INSERT INTO `USUARIO` (nome, senha, email, telefone) VALUES 
('jose','1234','jose@email.com', '(11)8888-8888'),('maria','12345', 'maria@email.com', '(11)9999-9999');
