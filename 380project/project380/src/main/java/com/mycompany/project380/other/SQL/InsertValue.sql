INSERT INTO users VALUES ('admin', '{noop}admin', 'Chan Tai Wan', '1234567', 'ShaTin');
INSERT INTO users VALUES ('user', '{noop}user', 'Chan Wan', '1234567', 'Central');
INSERT INTO users VALUES ('deve', '{noop}deve', 'Chan Tai', '1234567', 'TaiPo');
INSERT INTO users VALUES ('Carlo', '{noop}Carlo', 'Chan CTai', '1234567', 'TaiPo');
INSERT INTO users VALUES ('Samuel', '{noop}Samuel', 'Chan STai', '1234567', 'TaiPo');
INSERT INTO users VALUES ('Jerry', '{noop}Jerry', 'Chan JTai', '1234567', 'TaiPo');
INSERT INTO users VALUES ('Tsang', '{noop}Samuel', 'Chan TTai', '1234567', 'TaiPo');
INSERT INTO userRoles (username, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO userRoles (username, role) VALUES ('admin', 'ROLE_USER');
INSERT INTO userRoles (username, role) VALUES ('user', 'ROLE_USER');
INSERT INTO userRoles (username, role) VALUES ('deve', 'ROLE_USER');
INSERT INTO userRoles (username, role) VALUES ('Carlo', 'ROLE_LECTURER');
INSERT INTO userRoles (username, role) VALUES ('Carlo', 'ROLE_USER');
INSERT INTO userRoles (username, role) VALUES ('Samuel', 'ROLE_LECTURER');
INSERT INTO userRoles (username, role) VALUES ('Samuel', 'ROLE_USER');
INSERT INTO userRoles (username, role) VALUES ('Jerry', 'ROLE_LECTURER');
INSERT INTO userRoles (username, role) VALUES ('Jerry', 'ROLE_USER');
INSERT INTO userRoles (username, role) VALUES ('Tsang', 'ROLE_LECTURER');
INSERT INTO userRoles (username, role) VALUES ('Tsang', 'ROLE_USER');

INSERT INTO course (code, title)VALUES ('COMPS380F', 'Web Application : Design And Development');
INSERT INTO course (code, title)VALUES ('COMPS382F', 'Data Mining');
INSERT INTO course (code, title)VALUES ('COMPS492F', 'Machine Learning');

INSERT INTO lecture (title, courseID)VALUES ('GA', '3');
INSERT INTO lecture (title, courseID)VALUES ('Supervised Learning', '3');
INSERT INTO lecture (title, courseID)VALUES ('Unsupervised Learning', '3');

INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment1', '3', '1', null, 'admin');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment2', '2', '1', null, 'user');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment3', '1', '3', null, 'deve');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment4', '3', '2', null, 'admin');

INSERT INTO notes (title, courseid, lectureid ) VALUES ('this is notes 1 title in lec 1', '-1', '1');
INSERT INTO notes (title, courseid, lectureid ) VALUES ('this is notes 2 title in lec 2', '-1', '2');
INSERT INTO notes (title, courseid, lectureid ) VALUES ('this is notes 3 title in lec 3', '-1', '3');
INSERT INTO notes (title, courseid, lectureid ) VALUES ('this is notes 4 title in lec 4', '-1', '4');
INSERT INTO notes (title, courseid, lectureid ) VALUES ('this is notes 5 title in lec 5', '-1', '5');
INSERT INTO lecture (title, courseID)VALUES ('Overview of Web Applications', '1');
INSERT INTO lecture (title, courseID)VALUES ('Servlet', '1');
INSERT INTO lecture (title, courseID)VALUES ('JSP, JavaBean', '1');

INSERT INTO question (query, courseID) VALUES 
('Who is the course coordinator ?', '-1');
INSERT INTO question (query, courseID) VALUES 
('Do you enjoy the course?', '-1');
INSERT INTO question (query, courseID) VALUES 
('Would you recommend the course to others?', '-1');

INSERT INTO answer (content, questionID, courseID) VALUES 
('Keith', '1', '-1');
INSERT INTO answer (content, questionID, courseID) VALUES 
('Andrew', '1', '-1');
INSERT INTO answer (content, questionID, courseID) VALUES 
('Henry', '1', '-1');

INSERT INTO answer (content, questionID, courseID) VALUES 
('Yes', '2', '-1');
INSERT INTO answer (content, questionID, courseID) VALUES 
('No', '2', '-1');
INSERT INTO answer (content, questionID, courseID) VALUES 
('Yes', '3', '-1');
INSERT INTO answer (content, questionID, courseID) VALUES 
('No', '3', '-1');

INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment1 of q1', null, null, '1', 'admin');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment2 of q2', null, null, '2', 'user');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment3 of q3', null, null, '3', 'deve');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment4 of q1', null, null, '1', 'admin');
INSERT INTO votedAnswer (answerid, username) VALUES ('1', 'admin');
INSERT INTO votedAnswer (answerid, username) VALUES ('2', 'user');
INSERT INTO votedAnswer (answerid, username) VALUES ('3', 'deve');
INSERT INTO votedAnswer (answerid, username) VALUES ('4', 'admin');