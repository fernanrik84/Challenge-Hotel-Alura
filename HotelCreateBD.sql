CREATE DATABASE  hotel;

USE hotel;

CREATE TABLE `huespedes` (
  `idhuespedes` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Fecha_nacimiento` date DEFAULT NULL,
  `Nacionalidad` varchar(45) DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `idreserva` int(11) NOT NULL,
  PRIMARY KEY (`idhuespedes`,`idreserva`)
);

CREATE TABLE `precio_reservas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `precio` float NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `reservas` (
  `idreservas` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha_entrada` date DEFAULT NULL,
  `Fecha_salida` date DEFAULT NULL,
  `Valor` float DEFAULT NULL,
  `Forma_Pago` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idreservas`)
);


CREATE TABLE `sesion` (
  `idusuario` int(11) NOT NULL,
  `crear_at` datetime DEFAULT current_timestamp()
);


CREATE TABLE `users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idusers`)
);


