package org.example.shopping.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.shopping.vo.ShopListDetailVO;

@Getter
@Setter
@NoArgsConstructor

public class ShopListDetailDTO {
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
    private int pPrice;
    private String companyName;
    private String companyNamePhone;

    @Builder
    public ShopListDetailDTO(int pmId, int uId, int pId, String cardName, String cardNum, String paymentMethod, String paymentDate, String progress, int productNum, int savedPoint, int usePoint, String pName, int pPrice, String companyName, String companyNamePhone) {
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
        this.pPrice = pPrice;
        this.companyName = companyName;
        this.companyNamePhone = companyNamePhone;
    }

    public ShopListDetailVO toVO() {
        return ShopListDetailVO.builder()
                .pmId(pmId)
                .uId(uId)
                .pId(pId)
                .cardName(cardName)
                .cardNum(cardNum)
                .paymentMethod(paymentMethod)
                .paymentDate(paymentDate)
                .progress(progress)
                .productNum(productNum)
                .savedPoint(savedPoint)
                .usePoint(usePoint)
                .pName(pName)
                .priceSum(pPrice * productNum)
                .companyName(companyName)
                .companyNamePhone(companyNamePhone)
                .build();
    }
}
