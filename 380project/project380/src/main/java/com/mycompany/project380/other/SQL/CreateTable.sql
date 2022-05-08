CREATE TABLE notes(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    title VARCHAR(255) DEFAULT NULL,
    mimeContentType VARCHAR(255) DEFAULT NULL,
    content BLOB DEFAULT NULL,
    courseID VARCHAR(255) NOT NULL,
    lectureID VARCHAR(255) NOT NULL,
    type VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE materials (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    filename VARCHAR(255) DEFAULT NULL,
    content_type VARCHAR(255) DEFAULT NULL,
    content BLOB DEFAULT NULL,
    lecture_id INTEGER DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (lecture_id) REFERENCES lecture(lectureID)
);

CREATE TABLE comments (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    content VARCHAR(255) DEFAULT NULL,
    courseID VARCHAR(255) DEFAULT NULL,
    lectureID VARCHAR(255) DEFAULT NULL,
    username VARCHAR(50)  DEFAULT NULL,
    questionID  VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    fullname VARCHAR(50) NOT NULL,
    phonenbr VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE userRoles(
    roleId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (roleId)
);
CREATE TABLE course (
    courseID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    code VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    PRIMARY KEY (courseID)
);

CREATE TABLE question (
    questionId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    query VARCHAR(255) NOT NULL,
    courseID VARCHAR(255) NOT NULL,
    PRIMARY KEY(questionId)
);

-- CREATE TABLE answer (
--     answerId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--     content VARCHAR(255) NOT NULL,
--     voted INTEGER NOT NULL,
--     questionID INTEGER NOT NULL,
--     PRIMARY KEY(answerId),
--     FOREIGN KEY (questionID) REFERENCES question (questionId)
-- );
CREATE TABLE answer (
    answerId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    content VARCHAR(255) NOT NULL,
    questionID VARCHAR(255) NOT NULL,
    courseID VARCHAR(255) NOT NULL,
    PRIMARY KEY(answerId)
);

CREATE TABLE lecture(
    lectureID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    title VARCHAR(255) DEFAULT NULL,
    courseID VARCHAR(255) NOT NULL,
    PRIMARY KEY(lectureID)
);

CREATE TABLE votedAnswer(
    votedId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    answerID VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    PRIMARY KEY(votedId)
);