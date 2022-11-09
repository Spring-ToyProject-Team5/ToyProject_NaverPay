package org.example.shopping.entity;

import lombok.Getter;
import org.example.shopping.dto.MemberDTO;

@Getter
public class Member {
    private int uId;
    private String uNaverId;
    private String uPw;
    private String uEmail;
    private String uName;
    private String uPhone;
    private String uAddress;
    private int uPoint;

    public Member() {
    }

    public Member(int uId, String uNaverId, String uPw, String uEmail, String uName, String uPhone, String uAddress, int uPoint) {
        this.uId = uId;
        this.uNaverId = uNaverId;
        this.uPw = uPw;
        this.uEmail = uEmail;
        this.uName = uName;
        this.uPhone = uPhone;
        this.uAddress = uAddress;
        this.uPoint = uPoint;
    }

    public MemberDTO toDTO() {
        return new MemberDTO(uId, uNaverId, uPw, uEmail, uName, uPhone, uAddress, uPoint);
    }

    @Override
    public String toString() {
        return "Member{" +
                "uId=" + uId +
                ", uNaverId='" + uNaverId + '\'' +
                ", uPw='" + uPw + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uName='" + uName + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uAddress='" + uAddress + '\'' +
                ", uPoint=" + uPoint +
                '}';
    }
}