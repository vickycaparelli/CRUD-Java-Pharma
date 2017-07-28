CREATE DATABASE farmaciaExpres;

USE farmaciaExpres;

CREATE TABLE IF NOT EXISTS Cliente(
	id INTEGER AUTO_INCREMENT
	, DNI INTEGER
	, nombre VARCHAR(50) NOT NULL
	, apellido VARCHAR(50) NOT NULL
	, telefono INTEGER
	, ultDispensacion VARCHAR(10) 
	, PRIMARY KEY(id, DNI)
);
	
