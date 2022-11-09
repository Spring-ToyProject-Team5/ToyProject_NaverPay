package org.example.shopping.vo;

import java.util.Objects;

public class MemberVO {
    private String uNaverId = "";
    private String uEmail = "";

    public MemberVO() {
    }

    public MemberVO(String uNaverId, String uEmail) {
        this.uNaverId = uNaverId;
        this.uEmail = uEmail;
    }

    public String getuId() {
        return uNaverId;
    }

    public String getuEmail() {
        return uEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberVO memberVO = (MemberVO) o;
        return uNaverId.equals(memberVO.uNaverId) && uEmail.equals(memberVO.uEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uNaverId, uEmail);
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "uNaverId='" + uNaverId + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}