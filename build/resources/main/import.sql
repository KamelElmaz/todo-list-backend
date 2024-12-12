DROP TABLE todo IF EXISTS;

Create table todo(id bigint auto_increment primary key, task varchar(300), priority bigint);

INSERT INTO todo (id, task, priority) VALUES (1, 'Implement loading - frontend only', 1);
INSERT INTO todo (id, task, priority) VALUES (2, 'Implement search - frontend only', 2);
INSERT INTO todo (id, task, priority) VALUES (3, 'Implement delete on click - frontend only', 1);
INSERT INTO todo (id, task, priority) VALUES (4, 'Replace mock service by integrating backend', 3);
