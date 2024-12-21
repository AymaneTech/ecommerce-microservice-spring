INSERT INTO roles (id, name) VALUES
                                 (1, 'ROLE_ADMIN'),
                                 (2, 'ROLE_USER');

INSERT INTO authorities (id, name) VALUES
                                       (1, 'USERS_READ'),
                                       (2, 'USERS_UPDATE'),
                                       (3, 'USERS_DELETE'),
                                       (4, 'USERS_READ_ALL'),
                                       (5, 'USERS_CREATE');

INSERT INTO authorities (id, name) VALUES
                                       (6, 'ROLES_READ'),
                                       (7, 'ROLES_UPDATE'),
                                       (8, 'ROLES_DELETE'),
                                       (9, 'ROLES_READ_ALL'),
                                       (10, 'ROLES_CREATE');

INSERT INTO authorities (id, name) VALUES
                                       (11, 'AUTHORITIES_READ'),
                                       (12, 'AUTHORITIES_UPDATE'),
                                       (13, 'AUTHORITIES_DELETE'),
                                       (14, 'AUTHORITIES_READ_ALL'),
                                       (15, 'AUTHORITIES_CREATE');

INSERT INTO roles_authorities (role_id, authority_id)
SELECT 1, id FROM authorities;

INSERT INTO roles_authorities (role_id, authority_id) VALUES
                                                          (2, 1),
                                                          (2, 4);

-- Insert n admin user
INSERT INTO users (id, email, full_name, password, role_id) VALUES
    (1, 'admin@example.com', 'Administrator', 'admin_password_hash', 1);
