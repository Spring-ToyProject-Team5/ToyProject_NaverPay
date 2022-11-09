DROP TABLE PAYMENT;

CREATE TABLE PAYMENT
(
    pmId          INT AUTO_INCREMENT,
    uId           INT,
    pId           INT,
    cardName      VARCHAR(255),
    cardNum       VARCHAR(255),
    paymentMethod VARCHAR(255),
    paymentDate   VARCHAR(255),
    progress      VARCHAR(255),
    productNum    VARCHAR(255),
    savedPoint    INT,
    usePoint      INT,
    PRIMARY KEY (pmId),
    FOREIGN KEY (uId) REFERENCES MEMBER (uId),
    FOREIGN KEY (pId) REFERENCES PRODUCT (pId)
);

INSERT INTO PAYMENT (uId, pId, cardName, cardNum, paymentMethod, paymentDate, progress, productNum, savedPoint,
                     usePoint)
VALUES (1, 1, '신한', 'p', '결제완료', FORMATDATETIME('2022-11-01', 'yyyy-MM-dd'), 'p', 6, 10, 5);
INSERT INTO PAYMENT (uId, pId, cardName, cardNum, paymentMethod, paymentDate, progress, productNum, savedPoint,
                     usePoint)
VALUES (1, 1, '하나', 'p', '결제완료', FORMATDATETIME('2022-11-02', 'yyyy-MM-dd'), 'p', 6, 10, 5);
INSERT INTO PAYMENT (uId, pId, cardName, cardNum, paymentMethod, paymentDate, progress, productNum, savedPoint,
                     usePoint)
VALUES (1, 1, '하나', 'p', '결제진행중', FORMATDATETIME('2022-11-03', 'yyyy-MM-dd'), 'p', 6, 10, 5);
INSERT INTO PAYMENT (uId, pId, cardName, cardNum, paymentMethod, paymentDate, progress, productNum, savedPoint,
                     usePoint)
VALUES (2, 1, '국민', 'p', '취소', FORMATDATETIME('2022-11-01', 'yyyy-MM-dd'), 'p', 6, 10, 5);
INSERT INTO PAYMENT (uId, pId, cardName, cardNum, paymentMethod, paymentDate, progress, productNum, savedPoint,
                     usePoint)
VALUES (2, 2, '하나', 'p', '취소', FORMATDATETIME('2022-11-06', 'yyyy-MM-dd'), 'p', 6, 10, 5);
INSERT INTO PAYMENT (uId, pId, cardName, cardNum, paymentMethod, paymentDate, progress, productNum, savedPoint,
                     usePoint)
VALUES (2, 3, '국민', 'p', '반품', FORMATDATETIME('2022-11-07', 'yyyy-MM-dd'), 'p', 6, 10, 5);
INSERT INTO PAYMENT (uId, pId, cardName, cardNum, paymentMethod, paymentDate, progress, productNum, savedPoint,
                     usePoint)
VALUES (2, 3, '신한', 'p', '결제완료', FORMATDATETIME('2022-11-07', 'yyyy-MM-dd'), 'p', 6, 10, 5);
INSERT INTO PAYMENT (uId, pId, cardName, cardNum, paymentMethod, paymentDate, progress, productNum, savedPoint,
                     usePoint)
VALUES (2, 3, '국민', 'p', '반품', FORMATDATETIME('2022-11-07', 'yyyy-MM-dd'), 'p', 6, 10, 5);
INSERT INTO PAYMENT (uId, pId, cardName, cardNum, paymentMethod, paymentDate, progress, productNum, savedPoint,
                     usePoint)
VALUES (2, 3, '신한', 'p', '반품', FORMATDATETIME('2022-11-07', 'yyyy-MM-dd'), 'p', 6, 10, 5);

SELECT *
FROM PAYMENT;

select *
from payment
         join product on product.pId = payment.pId
         join member on member.uId = payment.uId
where payment.uId = 1
order by paymentDate DESC;