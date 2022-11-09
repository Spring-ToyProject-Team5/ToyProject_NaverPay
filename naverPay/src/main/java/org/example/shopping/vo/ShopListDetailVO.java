package org.example.shopping.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ShopListDetailVO {
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

    private String pName;
    private int priceSum;
    private String companyName;
    private String companyNamePhone;

    @Builder
    public ShopListDetailVO(int pmId, int uId, int pId, String cardName, String cardNum, String paymentMethod, String paymentDate, String progress, int productNum, int savedPoint, int usePoint, String pName, int priceSum, String companyName, String companyNamePhone) {
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
        this.pName = pName;
        this.priceSum = priceSum;
        this.companyName = companyName;
        this.companyNamePhone = companyNamePhone;
    }

    
}
