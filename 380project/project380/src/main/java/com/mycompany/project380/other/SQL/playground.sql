-- -1 for not belong with any class
INSERT INTO notes (title, courseid, lectureid ) VALUES ('this is notes 1 title in lec 1', '-1', '1');
INSERT INTO notes (title, courseid, lectureid ) VALUES ('this is notes 2 title in lec 2', '-1', '2');
INSERT INTO notes (title, courseid, lectureid ) VALUES ('this is notes 3 title in lec 3', '-1', '3');
INSERT INTO notes (title, courseid, lectureid ) VALUES ('this is notes 4 title in lec 4', '-1', '4');
INSERT INTO notes (title, courseid, lectureid ) VALUES ('this is notes 5 title in lec 5', '-1', '5');

INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment1', '3', '1', '-1', 'admin');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment2', '2', '1', '-1', 'user');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment3', '1', '3', '-1', 'deve');
INSERT INTO comments (content, courseID, lectureID, questionID, username) VALUES ('comment4', '3', '2', '-1', 'admin');

-- SELECT * FROM users;
-- 
-- SELECT * FROM question;
-- SELECT * FROM answer;
-- select * from comments;
