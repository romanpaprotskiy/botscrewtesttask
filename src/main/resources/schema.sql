INSERT INTO degree(id,name)
VALUES (1,'assistant'),
       (2,'associate professor'),
       (3,'professor');

INSERT INTO lecturer(id,first_name, last_name, salary, degree_id)
VALUES (1,'Ivan', 'Petrenko', 8500, 1),
       (2,'Andriy', 'Kovalenko', 12000, 2),
       (3,'Petro', 'Ivanenko', 14500, 3),
       (4,'Adnriy', 'Ivanchuk', 9500, 1),
       (5,'Oleh', 'Petryshyn', 12800, 2),
       (6,'Ivan', 'Ivanov', 10000, 2),
       (7,'Vasyl', 'Ivanenko', 12000, 3);

INSERT INTO department(id,name, head_id)
VALUES (1,'ComputerScience', 3),
       (2,'Medical', 7);

INSERT INTO department_lecturer(lecturer_id, department_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 2),
       (6, 2),
       (7, 2);


