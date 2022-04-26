INSERT INTO users VALUES ('admin', '{noop}admin');
INSERT INTO users VALUES ('user', '{noop}user');
INSERT INTO users VALUES ('deve', '{noop}deve');

INSERT INTO userRoles (username, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO userRoles (username, role) VALUES ('admin', 'ROLE_USER');
INSERT INTO userRoles (username, role) VALUES ('user', 'ROLE_USER');
INSERT INTO userRoles (username, role) VALUES ('deve', 'ROLE_USER');

INSERT INTO course (code, title)VALUES ('COMPS380F', 'Web Application : Design And Development');
INSERT INTO course (code, title)VALUES ('COMPS382F', 'Data Mining');
INSERT INTO course (code, title)VALUES ('COMPS492F', 'Machine Learning');

INSERT INTO lecture (title, courseID)VALUES ('GA', 3);
INSERT INTO lecture (title, courseID)VALUES ('Supervised Learning', 3);
INSERT INTO lecture (title, courseID)VALUES ('Unsupervised Learning', 3);