-- -1 for not belong with any class
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment1 of q1', '-1', '-1', '1', 'admin');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment2 of q2', '-1', '-1', '2', 'user');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment3 of q3', '-1', '-1', '3', 'deve');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment4 of q1', '-1', '-1', '1', 'admin');


SELECT * FROM comments;

-- SELECT * FROM users;
-- 
-- SELECT * FROM question;
-- SELECT * FROM answer;
-- select * from comments;
