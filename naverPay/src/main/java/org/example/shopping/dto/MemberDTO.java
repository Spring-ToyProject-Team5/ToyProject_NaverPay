package org.example.shopping.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.shopping.entity.Member;
import org.example.shopping.vo.MemberVO;

@Getter
@Setter
public class MemberDTO { //uId, uName, uPhone, uAddress, uEmail, uNaverId, uPw, uPoint
    private int uId;
    private String uName = "";
    private String uPhone = "";
    private String uAddress = "";
    private String uEmail = "";
    private String uNaverId = "";
    private String uPw = null;
    private int uPoint;

    public MemberDTO() {
    }

    public MemberDTO(String uNaverId) {
        this.uNaverId = uNaverId;
    }

    public MemberDTO(String uNaverId, String uPw) {
        this.uNaverId = uNaverId;
        this.uPw = uPw; //needEncode ? Password.of(uPw, true) : Password.of(uPw, false);
    }

    public MemberDTO(int uId, String uName, String uPhone, String uAddress, String uEmail, String uNaverId, String uPw, int uPoint) {
        this.uId = uId;
        this.uName = uName;
        this.uPhone = uPhone;
        this.uAddress = uAddress;
        this.uEmail = uEmail;
        this.uNaverId = uNaverId;
        this.uPw = uPw;
        this.uPoint = uPoint;
    }

    //    public MemberDTO(String uNaverId, String uPw) {
//        this.uNaverId = uNaverId;
//        this.uPw = uPw;
//    }

//    public MemberDTO(String uName, String uPhone, String uAddress, String uEmail, String uNaverId, String uPw, boolean needEncode) {
//        this.uName = uName;
//        this.uPhone = uPhone;
//        this.uAddress = uAddress;
//        this.uEmail = uEmail;
//        this.uNaverId = uNaverId;
//        this.uPw = uPw; // needEncode ? Password.of(uPw, true) : Password.of(uPw, false);
//    }

    public MemberDTO(String uName, String uPhone, String uAddress, String uEmail, String uNaverId, String uPw) {
        this.uName = uName;
        this.uPhone = uPhone;
        this.uAddress = uAddress;
        this.uEmail = uEmail;
        this.uNaverId = uNaverId;
        this.uPw = uPw;
    }

    public Member toEntity() {
        return new Member(uId, uName, uPhone, uAddress, uEmail, uNaverId, getuPw(), uPoint);
    }

    public MemberVO toVO() {
        return new MemberVO(uNaverId, uEmail);
    }

//    public int getuId() {
//        return uId;
//    }
//
//    public void setuId(int uId) {
//        this.uId = uId;
//    }

    public String getuPw() {
        return uPw;
    }

//    public String getuPwStr() {
//        return uPw.getuPw();
//    }

    public void setuPw(String uPw) {
        this.uPw = uPw;
    }

//    public String getuEmail() {
//        return uEmail;
//    }
//
//    public void setuEmail(String uEmail) {
//        this.uEmail = uEmail;
//    }


    @Override
    public String toString() {
        return "MemberDTO{" +
                "uId='" + uId + '\'' +
                ", uPw=" + uPw +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}

