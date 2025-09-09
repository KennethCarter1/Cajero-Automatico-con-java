-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS cajero;
USE cajero;

-- Crear la tabla Cuenta
CREATE TABLE IF NOT EXISTS Cuenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pin VARCHAR(10) NOT NULL,
    saldo DECIMAL(10,2) NOT NULL
);

-- Insertar datos de ejemplo
INSERT INTO Cuenta (pin, saldo) VALUES
('1234', 7763.00),
('4321', 500.00);
