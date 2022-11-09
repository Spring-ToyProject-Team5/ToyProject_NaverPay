package org.example.shopping.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ShopListVO {
    private int pmId;
    private int uId;
    private int pId;
    private String paymentMethod;
    private String paymentDate;
    private String pName;
    private String companyName;
    private String companyNamePhone;
    private int priceSum;
    private String uNaverId;

    @Builder
    public ShopListVO(int pmId, int uId, int pId, String paymentMethod, String paymentDate, String pName, String companyName, String companyNamePhone, int priceSum, String uNaverId) {
        this.pmId = pmId;
        this.uId = uId;
        this.pId = pId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.pName = pName;
        this.companyName = companyName;
        this.companyNamePhone = companyNamePhone;
        this.priceSum = priceSum;
        this.uNaverId = uNaverId;
    }
}
