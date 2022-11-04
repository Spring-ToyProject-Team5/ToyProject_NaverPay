package org.example.members.entity;

import lombok.Getter;

@Getter
public class Member {
    private int uId;
    private String uName;
    private String uPhone;
    private String uAddress;
    private String uEmail;
    private String uNaverId;
    private String uPw;
    private int uPoint;

    public Member() {
    }

    public Member(int uId, String uName, String uPhone, String uAddress, String uEmail, String uNaverId, String uPw, int uPoint) {
        this.uId = uId;
        this.uName = uName;
        this.uPhone = uPhone;
        this.uAddress = uAddress;
        this.uEmail = uEmail;
        this.uNaverId = uNaverId;
        this.uPw = uPw;
        this.uPoint = uPoint;
    }
}
