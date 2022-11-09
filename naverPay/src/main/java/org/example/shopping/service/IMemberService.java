package org.example.shopping.service;

import org.example.shopping.dto.MemberDTO;

import java.util.List;

public interface IMemberService {

    List<MemberDTO> findByUserIdOrEmail(String q);

//    boolean autoLogin(String autoLogin, String cookieId);

    MemberDTO login(String uId);
    MemberDTO login(String uId, String uPw);

    //int uId, String uName, String uPhone, String uAddress, String uEmail, String uNaverId, String uPw, int uPoint
    boolean signup(String uNaverId, String uName, String uPhone, String uEmail, String uPw, String uAddress);

    MemberDTO getByUserId(String uId);

    List<MemberDTO> getAllUsers();

//    boolean updateUserPassword(String uId, Password uPw, Password uNewPw);
//
//    boolean removeByUserId(String uId, Password uPw);
//
//    boolean removeUsers();
}
