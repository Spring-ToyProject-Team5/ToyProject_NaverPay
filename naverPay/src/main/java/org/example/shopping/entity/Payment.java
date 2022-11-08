package org.example.shopping.entity;

import lombok.Getter;

@Getter
public class Payment {
    private int pmId;
    private int uId;
    private int pId;
    private String cardName;
    private String cardNum;
    private String paymentMethod;
    private String paymentDate;
    private String progress;
    private int productNum;
    private int savedPoint;
    private int usePoint;

    public Payment() {
    }

    public Payment(int pmId, int uId, int pId, String cardName, String cardNum, String paymentMethod, String paymentDate, String progress, int productNum, int savedPoint, int usePoint) {
        this.pmId = pmId;
        this.uId = uId;
        this.pId = pId;
        this.cardName = cardName;
        this.cardNum = cardNum;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.progress = progress;
        this.productNum = productNum;
        this.savedPoint = savedPoint;
        this.usePoint = usePoint;
    }
}
