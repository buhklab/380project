SELECT * FROM users;

INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment1', '3', '1', '-1', 'admin');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment2', '2', '1', '-1', 'user');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment3', '1', '3', '-1', 'deve');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment4', '3', '2', '-1', 'admin');

select * from comments;