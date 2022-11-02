DROP TABLE PRODUCT;

CREATE TABLE PRODUCT (
        pId INT AUTO_INCREMENT,
        pName VARCHAR(255),
        pPrice INT,
        pCompany VARCHAR(255),
        pCompanyPhone VARCHAR(255),
        PRIMARY KEY (pId)
);

SELECT * FROM PRODUCT;

INSERT INTO PRODUCT (pName, pPrice, pCompany, pCompanyPhone) VALUES ('pn',1000,'pc','pch' );