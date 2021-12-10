INSERT INTO tb_user (email, password, first_name, last_name, birth_date) VALUES ('arthur@gmail.com', '123456', 'Arthur', 'Scarpati', '1997-01-29T10:30:00Z');
INSERT INTO tb_user (email, password, first_name, last_name, birth_date) VALUES ('bob@gmail.com', '123456', 'Bob', 'Brown', '1996-01-15T10:30:00Z');
INSERT INTO tb_user (email, password, first_name, last_name, birth_date) VALUES ('ana@gmail.com', '123456', 'Ana', 'Clara', '1999-01-19T10:30:00Z');
INSERT INTO tb_user (email, password, first_name, last_name, birth_date) VALUES ('joao@gmail.com', '123456', 'Joao', 'Tuqs', '1994-01-14T10:30:00Z');
INSERT INTO tb_user (email, password, first_name, last_name, birth_date) VALUES ('clair@gmail.com', '123456', 'Clair', 'Souza', '2000-01-25T10:30:00Z');

INSERT INTO TB_ROLE (authority) VALUES ('ROLE_ADMIN');
INSERT INTO TB_ROLE (authority) VALUES ('ROLE_USER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 2);