DROP TABLE IF EXISTS car;

CREATE TABLE car (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  brand VARCHAR(25) NOT NULL,
  model VARCHAR(25) NOT NULL,
  value DOUBLE DEFAULT NULL,
  created_at DATE
);

/*INSERT INTO car (brand, model, value) VALUES
  ('Classic', 'Corsa', '20000'),
  ('EcoSport', 'Ford', '50000');*/