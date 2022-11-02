DROP TABLE MEMBER;

CREATE TABLE MEMBER (
        uId INT AUTO_INCREMENT ,
        uNaverId VARCHAR(255),
        uPw VARCHAR(255),
        uEmail VARCHAR(255),
        uName VARCHAR(255),
        uPhone VARCHAR(255),
        uAddress VARCHAR(255),
        uPoint INT,

        PRIMARY KEY (uId)
);

INSERT INTO MEMBER (uNaverId, uPw, uEmail, uName, uPhone, uAddress, uPoint)  VALUES ('a','a','a','a','a','a',10);
INSERT INTO MEMBER (uNaverId, uPw, uEmail, uName, uPhone, uAddress, uPoint)  VALUES ('b','b','b','b','b','b',20);


SELECT * FROM MEMBER;