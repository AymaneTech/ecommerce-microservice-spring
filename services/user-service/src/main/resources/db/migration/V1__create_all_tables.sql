CREATE TABLE roles
(
    id   BIGINT       NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE authorities
(
    id   BIGINT       NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
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
    id        BIGINT       NOT NULL PRIMARY KEY,
    email     VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    role_id   BIGINT,
    CONSTRAINT fk_users_role FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE SET NULL
);