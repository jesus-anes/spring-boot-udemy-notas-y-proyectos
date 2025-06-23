/* Populate tables */
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Jesús', 'Anes', 'jesus@gmail.com', '2025-06-01', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Mario', 'Rodríguez', 'mario@gmail.com', '2025-04-01', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Laura', 'Gómez', 'laura.gomez@gmail.com', '2025-06-01', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Carlos', 'Martínez', 'carlos.martinez@gmail.com', '2025-06-02', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('María', 'Fernández', 'maria.fernandez@gmail.com', '2025-06-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Pedro', 'Sánchez', 'pedro.sanchez@gmail.com', '2025-06-04', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Ana', 'López', 'ana.lopez@gmail.com', '2025-06-05', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Jorge', 'Ramírez', 'jorge.ramirez@gmail.com', '2025-06-06', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Elena', 'Vargas', 'elena.vargas@gmail.com', '2025-06-07', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Alberto', 'Cruz', 'alberto.cruz@gmail.com', '2025-06-08', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Lucía', 'Morales', 'lucia.morales@gmail.com', '2025-06-09', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Raúl', 'Silva', 'raul.silva@gmail.com', '2025-06-10', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Carmen', 'Torres', 'carmen.torres@gmail.com', '2025-06-11', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Sergio', 'Delgado', 'sergio.delgado@gmail.com', '2025-06-12', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Natalia', 'Rojas', 'natalia.rojas@gmail.com', '2025-06-13', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Diego', 'Molina', 'diego.molina@gmail.com', '2025-06-14', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Isabel', 'Navarro', 'isabel.navarro@gmail.com', '2025-06-15', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Tomás', 'Castro', 'tomas.castro@gmail.com', '2025-06-16', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Claudia', 'Peña', 'claudia.pena@gmail.com', '2025-06-17', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Hugo', 'Reyes', 'hugo.reyes@gmail.com', '2025-06-18', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Patricia', 'Iglesias', 'patricia.iglesias@gmail.com', '2025-06-19', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Iván', 'Herrera', 'ivan.herrera@gmail.com', '2025-06-20', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Rosa', 'Cabrera', 'rosa.cabrera@gmail.com', '2025-06-21', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Óscar', 'Medina', 'oscar.medina@gmail.com', '2025-06-22', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Marta', 'Vega', 'marta.vega@gmail.com', '2025-06-23', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Andrés', 'Nieto', 'andres.nieto@gmail.com', '2025-06-24', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES ('Beatriz', 'León', 'beatriz.leon@gmail.com', '2025-06-25', '');

INSERT INTO productos(nombre, precio, create_at) VALUES ('Panasonic Pantalla LCS', 690, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Samsung Galaxy S21', 799, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Apple iPhone 13', 999, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Sony WH-1000XM4 Auriculares', 349, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Dell XPS 13 Laptop', 1200, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('HP LaserJet Impresora', 150, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Canon EOS Rebel T7 Cámara', 550, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Xiaomi Mi Band 7', 49, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Samsung Smart TV 55"', 680, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Apple AirPods Pro', 249, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Lenovo ThinkPad E15', 890, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Razer DeathAdder V2 Mouse', 69, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Logitech K380 Teclado', 40, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Amazon Echo Dot', 49, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Samsung Galaxy Tab A8', 220, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('GoPro HERO9', 399, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('JBL Flip 5 Altavoz', 119, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Apple Watch SE', 279, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Nintendo Switch OLED', 349, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Asus TUF Gaming Laptop', 1350, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Philips Hue Smart Bulb', 29, NOW());

INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipos de oficina', null,1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (2,1,4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,2);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,6);

INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES ('Factura Bicileta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (2,2,6);

INSERT INTO users (username, password, enabled) VALUES ('jesus', '$2a$10$EdVfHtNT36qT7JDiqmT0.OWBlAZWLhc/JJd14Q5WSFRB2ipKgGleW', 1);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$Ben0phhTM8btu1z9WFMPmexmNxNzOXYGWGNDp3AUB4WAfU/V2fBeO', 1);

INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_ADMIN');