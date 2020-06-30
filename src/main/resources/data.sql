INSERT INTO roles(name) VALUES('ROLE_ADMIN') ON CONFLICT ON CONSTRAINT roles_name_key DO NOTHING;
INSERT INTO roles(name) VALUES('ROLE_USER') ON CONFLICT ON CONSTRAINT roles_name_key DO NOTHING;

INSERT INTO users(username, password) VALUES ( 'admin', crypt('admin', gen_salt('bf', 8)))
ON CONFLICT ON CONSTRAINT users_username_key DO NOTHING;

INSERT INTO users_roles (users_id, roles_id)
VALUES (1, 1)
ON CONFLICT ON CONSTRAINT users_roles_pkey DO NOTHING;

INSERT INTO users_roles (users_id, roles_id)
VALUES (1, 2)
ON CONFLICT ON CONSTRAINT users_roles_pkey DO NOTHING;
