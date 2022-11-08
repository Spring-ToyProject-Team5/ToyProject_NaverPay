package org.example.shopping.dto;

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

    public  ShopListDTO() {}

    public ShopListDTO(int pmId, int uId, int pId, String paymentMethod, String paymentDate, String pName, int pPrice, String companyName, String companyNamePhone) {
        this.pmId = pmId;
        this.uId = uId;
        this.pId = pId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.pName = pName;
        this.pPrice = pPrice;
        this.companyName = companyName;
        this.companyNamePhone = companyNamePhone;
    }

    public int getPmId() {
        return pmId;
    }

    public void setPmId(int pmId) {
        this.pmId = pmId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNamePhone() {
        return companyNamePhone;
    }

    public void setCompanyNamePhone(String companyNamePhone) {
        this.companyNamePhone = companyNamePhone;
    }

    @Override
    public String toString() {
        return "ShopListDTO{" +
                "pmId=" + pmId +
                ", uId=" + uId +
                ", pId=" + pId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                ", companyName='" + companyName + '\'' +
                ", companyNamePhone='" + companyNamePhone + '\'' +
                '}';
    }

    public ShopListDTO toDTO() {
        return new ShopListDTO(pmId, uId, pId, paymentMethod, paymentDate, pName, pPrice, companyName, companyNamePhone);
    }
}
