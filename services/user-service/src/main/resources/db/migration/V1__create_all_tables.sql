-- Create Sequences for auto-incrementing IDs
CREATE SEQUENCE roles_seq START 1 INCREMENT BY 50;
CREATE SEQUENCE authorities_seq START 1 INCREMENT BY 50;
CREATE SEQUENCE users_seq START 1 INCREMENT BY 50;

-- Create tables using sequences
CREATE TABLE roles
(
    id   BIGINT NOT NULL DEFAULT nextval('roles_seq'),
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE authorities
(
    id   BIGINT NOT NULL DEFAULT nextval('authorities_seq'),
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE roles_authorities
(
    role_id      BIGINT NOT NULL,
    authority_id BIGINT NOT NULL,
    PRIMARY KEY (role_id, authority_id),
    CONSTRAINT fk_role_authorities_role FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE,
    CONSTRAINT fk_role_authorities_authority FOREIGN KEY (authority_id) REFERENCES authorities (id) ON DELETE CASCADE
);

CREATE TABLE users
(
    id        BIGINT NOT NULL DEFAULT nextval('users_seq'),
    email     VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    role_id   BIGINT,
    CONSTRAINT fk_users_role FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE SET NULL,
    PRIMARY KEY (id)
);
