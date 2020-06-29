INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_USER');

INSERT INTO users(username, password) VALUES ( 'admin', crypt('admin', gen_salt('bf', 8)));

INSERT INTO users_roles (users_id, roles_id)
VALUES (1, 1);

INSERT INTO users_roles (users_id, roles_id)
VALUES (1, 2);
