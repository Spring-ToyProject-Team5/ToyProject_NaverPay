package org.example.shopping.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.shopping.vo.ShopListDetailVO;
import org.example.shopping.vo.ShopListVO;

@Getter
@Setter
@NoArgsConstructor
public class ShopListDTO {
    private int pmId;
    private int uId;
    private int pId;
    private String paymentMethod;
    private String paymentDate;
    private String pName;
    private int pPrice;
    private String companyName;
    private String companyNamePhone;
    private int productNum;
    private String uNaverId;

    @Builder
    public ShopListDTO(int pmId, int uId, int pId, String paymentMethod, String paymentDate, String pName, int pPrice, String companyName, String companyNamePhone, int productNum, String uNaverId) {
        this.pmId = pmId;
        this.uId = uId;
        this.pId = pId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.pName = pName;
        this.pPrice = pPrice;
        this.companyName = companyName;
        this.companyNamePhone = companyNamePhone;
        this.productNum = productNum;
        this.uNaverId = uNaverId;
    }

    public ShopListVO toVo() {
        return ShopListVO.builder()
                .pmId(pmId)
                .uId(uId)
                .pId(pId)
                .paymentMethod(paymentMethod)
                .paymentDate(paymentDate)
                .pName(pName)
                .priceSum(pPrice * productNum)
                .companyName(companyName)
                .companyNamePhone(companyNamePhone)
                .uNaverId(uNaverId)
                .build();
    }
}
