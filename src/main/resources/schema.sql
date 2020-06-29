CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS notes (
    id SERIAL NOT NULL,
    description TEXT NOT NULL ,
    title VARCHAR(255) NOT NULL ,
    user_id INT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS roles (
    id SERIAL NOT NULL ,
    name VARCHAR(255) NOT NULL ,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL NOT NULL ,
    gender VARCHAR(255) DEFAULT 'none',
    password TEXT NOT NULL ,
    username VARCHAR(20) NOT NULL ,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users_roles (
    users_id INT NOT NULL ,
    roles_id INT NOT NULL ,
    PRIMARY KEY (users_id, roles_id)
);

ALTER TABLE IF EXISTS notes ADD CONSTRAINT FKechaouoa6kus6k1dpix1u91c FOREIGN KEY (user_id) REFERENCES users;
ALTER TABLE IF EXISTS users_roles ADD CONSTRAINT FKa62j07k5mhgifpp955h37ponj FOREIGN KEY (roles_id) REFERENCES roles;
