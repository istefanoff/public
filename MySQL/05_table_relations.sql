CREATE DATABASE `table_relations`;
USE `table_relations`;


-- one to one relationship

DROP TABLE `people`;
CREATE TABLE people(
person_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
salary DECIMAL(10,2),
passport_id INT UNIQUE,
CONSTRAINT fk_people_passwords
FOREIGN KEY (`passport_id`)
REFERENCES passports(`passport_id`)
);

DROP TABLE passports;
CREATE TABLE passports(
passport_id INT PRIMARY KEY AUTO_INCREMENT,
passport_number VARCHAR(20) UNIQUE
);

INSERT INTO passports
VALUES
(101,'N23FG21B'),
(102,'K52FF26F'),
(103,'E11KQ08V');

INSERT INTO people(first_name,salary,passport_id)
VALUES 
('Pesho', 2500.20, 101),
('Gosho', 3500.40, 102),
('Losho', 4500.60, 103);

-- 2 one to many relationship

CREATE TABLE manufacturers(
manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20),
established_on DATE
);

CREATE TABLE models(
model_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20),
manufacturer_id INT,
CONSTRAINT fk_models_manufacturers
FOREIGN KEY (manufacturer_id)
REFERENCES manufacturers(manufacturer_id)
);

-- 3 many to many relationship

CREATE TABLE exams (
exam_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30)
);

CREATE TABLE students (
student_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30)
);

CREATE TABLE students_exams(
student_id INT,
exam_id INT,
CONSTRAINT pk_students_exams
PRIMARY KEY(student_id,exam_id),
CONSTRAINT fk_se_students_exams
FOREIGN KEY (student_id)
REFERENCES students(student_id),
CONSTRAINT fk_se_exams
FOREIGN KEY (exam_id)
REFERENCES exams(exam_id)
);

-- 4 self referencing relations

CREATE TABLE teachers(
teacher_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20),
manager_id INT
);

INSERT INTO teachers VALUES
(101,'John',NULL),
(102,'Maya',106),
(103,'Silvia',106),
(104,'Ted',105),
(105,'Mark',101),
(106,'Greta',101);

ALTER TABLE teachers
ADD CONSTRAINT fk_manager_teacher
FOREIGN KEY(manager_id)
REFERENCES teachers(teacher_id);





