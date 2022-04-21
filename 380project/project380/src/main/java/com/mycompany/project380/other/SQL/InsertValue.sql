INSERT INTO users VALUES ('admin', '{noop}admin');
INSERT INTO users VALUES ('user', '{noop}user');
INSERT INTO users VALUES ('deve', '{noop}deve');

INSERT INTO userRoles (username, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO userRoles (username, role) VALUES ('admin', 'ROLE_USER');
INSERT INTO userRoles (username, role) VALUES ('user', 'ROLE_USER');
INSERT INTO userRoles (username, role) VALUES ('deve', 'ROLE_USER');