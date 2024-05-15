CREATE SCHEMA IF NOT EXISTS instituto;

USE instituto;

CREATE TABLE `instituto`.`alumno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `curso` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `instituto`.`alumno` (`nombre`, `apellido`, `curso`) VALUES ('Pepe', 'Garcia', 'Java');
INSERT INTO `instituto`.`alumno` (`nombre`, `apellido`, `curso`) VALUES ('Ana', 'Gonzalez', 'HTML');
INSERT INTO `instituto`.`alumno` (`nombre`, `apellido`, `curso`) VALUES ('Pedro', 'Cadahia', 'Kotlin');
INSERT INTO `instituto`.`alumno` (`nombre`, `apellido`, `curso`) VALUES ('Jose', 'Mendez', 'PHP');
INSERT INTO `instituto`.`alumno` (`nombre`, `apellido`, `curso`) VALUES ('Pedro', 'Mendoza', 'Python');
INSERT INTO `instituto`.`alumno` (`nombre`, `apellido`, `curso`) VALUES ('Pepe', 'Navarro', 'C++');
INSERT INTO `instituto`.`alumno` (`nombre`, `apellido`, `curso`) VALUES ('Ana', 'Garcia', 'Java');

SELECT * from alumno;