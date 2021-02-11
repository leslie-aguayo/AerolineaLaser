DROP DATABASE IF EXISTS Aerolinea_Laser;
CREATE DATABASE Aerolinea_Laser;
USE Aerolinea_Laser;
CREATE TABLE Tipo_Usuario(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL
);
CREATE TABLE Usuario(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    correo VARCHAR(40) NOT NULL,
    usuario VARCHAR(20) NOT NULL,
    contrasena VARCHAR(20) NOT NULL,
    tipo_usuario_id INT NOT NULL,
    CONSTRAINT fk_tipo_usuario_id FOREIGN KEY (tipo_usuario_id) REFERENCES Tipo_Usuario (id)
);
INSERT INTO Tipo_Usuario(nombre)
VALUES ("admin");
INSERT INTO Tipo_Usuario(nombre)
VALUES ("turismo");
INSERT INTO Tipo_Usuario(nombre)
VALUES ("premium");
INSERT INTO Usuario(nombre, apellido, correo, usuario, contrasena, tipo_usuario_id)
VALUES ("Administrador", "Uno", "admin@laser.com", "admin", "123", 1);
INSERT INTO Usuario(nombre, apellido, correo, usuario, contrasena, tipo_usuario_id)
VALUES ("Usuario", "Turista", "turista@gmail.com", "usertur", "123", 2);
INSERT INTO Usuario(nombre, apellido, correo, usuario, contrasena, tipo_usuario_id)
VALUES ("Usuario", "Premium", "premium@gmail.com", "userpre", "123", 3);

SELECT *
FROM Usuario;