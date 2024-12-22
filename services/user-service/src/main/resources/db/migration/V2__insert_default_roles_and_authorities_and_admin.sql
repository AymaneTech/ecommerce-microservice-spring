INSERT INTO roles (name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');

INSERT INTO authorities (name)
VALUES ('USERS_READ'),
       ('USERS_UPDATE'),
       ('USERS_DELETE'),
       ('USERS_READ_ALL'),
       ('USERS_CREATE');

INSERT INTO authorities (name)
VALUES ('ROLES_READ'),
       ('ROLES_UPDATE'),
       ('ROLES_DELETE'),
       ('ROLES_READ_ALL'),
       ('ROLES_CREATE');

INSERT INTO authorities (name)
VALUES ('AUTHORITIES_READ'),
       ('AUTHORITIES_UPDATE'),
       ('AUTHORITIES_DELETE'),
       ('AUTHORITIES_READ_ALL'),
       ('AUTHORITIES_CREATE');

INSERT INTO roles_authorities (role_id, authority_id)
SELECT 1, id
FROM authorities;

-- Insert n admin user
INSERT INTO users (email, full_name, password, role_id)
VALUES ('admin@example.com', 'Administrator', 'admin_password_hash', 1);
