DROP TABLE PRODUCT;

CREATE TABLE PRODUCT
(
    pId           INT AUTO_INCREMENT,
    pName         VARCHAR(255),
    pPrice        INT,
    pCompany      VARCHAR(255),
    pCompanyPhone VARCHAR(255),
    PRIMARY KEY (pId)
);

SELECT *
FROM PRODUCT;


INSERT INTO PRODUCT (pName, pPrice, pCompany, pCompanyPhone)
VALUES ('의자', 1000, '가구나라', 'pch');
INSERT INTO PRODUCT (pName, pPrice, pCompany, pCompanyPhone)
VALUES ('티비', 2000, '하이마트', 'pch');
INSERT INTO PRODUCT (pName, pPrice, pCompany, pCompanyPhone)
VALUES ('치킨', 3000, '쿠팡이츠', 'pch');
INSERT INTO PRODUCT (pName, pPrice, pCompany, pCompanyPhone)
VALUES ('짬뽕', 4000, '배달의민족', 'pch');
INSERT INTO PRODUCT (pName, pPrice, pCompany, pCompanyPhone)
VALUES ('마라탕', 5000, '쿠팡이츠', 'pch');
INSERT INTO PRODUCT (pName, pPrice, pCompany, pCompanyPhone)
VALUES ('떡볶이', 6000, '배달의민족', 'pch');
INSERT INTO PRODUCT (pName, pPrice, pCompany, pCompanyPhone)
VALUES ('책상', 7000, '가구나라', 'pch');
INSERT INTO PRODUCT (pName, pPrice, pCompany, pCompanyPhone)
VALUES ('모니터', 8000, '하이마트', 'pch');
INSERT INTO PRODUCT (pName, pPrice, pCompany, pCompanyPhone)
VALUES ('지우개', 9000, '문방구', 'pch');
