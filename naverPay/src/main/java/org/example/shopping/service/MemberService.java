package org.example.shopping.service;

import org.example.cookies.CookieMgr;
import org.example.shopping.dao.MemberDAO;
import org.example.shopping.dto.MemberDTO;
import org.example.shopping.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService implements IMemberService {

    private CookieMgr cookieMgr;
    private MemberDAO memberDAO;

    @Autowired
    public MemberService(CookieMgr cookieMgr, MemberDAO memberDAO) {
        this.cookieMgr = cookieMgr;
        this.memberDAO = memberDAO;
    }


    @Override
    public List<MemberDTO> findByUserIdOrEmail(String q) {
        if (q == null) return null;

        List<Member> memberList = memberDAO.search(q);
        return memberList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }

//    @Override
//    public boolean autoLogin(String autoLogin, String cookieId) {
//        if (autoLogin == null || cookieId == null) return false;
//
//        if (autoLogin.equals("true")) {
//            if (getByUserId(cookieId) != null) {
//                MemberDTO memberDTO = login(cookieId);
//                return memberDTO != null;
//            }
//        }
//        return false;
//    }

    @Override
    public MemberDTO login(String uNaverId) {
        MemberDTO memberDTO = new MemberDTO(uNaverId);
        if (memberDTO == null) return null;

        Member member = memberDAO.select(memberDTO.getUNaverId());
        return member.toDTO();
    }

    @Override
    public MemberDTO login(String uNaverId, String uPw) {
        MemberDTO memberDTO = new MemberDTO(uNaverId, uPw);
        if (memberDTO == null || memberDTO.getuPw() == null) return null;

        Member member = memberDAO.select(memberDTO.getUNaverId());
        System.out.println("여기"+member.getUId());
        if (member == null || member.getUPw() == null) return null;
        if (member.getUPw().equals(memberDTO.getuPw())) {
            return member.toDTO();
        }
        return null;
    }

    @Override
    //int uId, String uName, String uPhone, String uAddress, String uEmail, String uNaverId, String uPw, int uPoint
    public boolean signup(int uId, String uNaverId, String uName, String uPhone, String uEmail, String uPw, String uAddress) {
        MemberDTO memberDTO = new MemberDTO(uId, uNaverId, uName, uPhone, uEmail, uPw, uAddress);
        if (memberDTO == null || memberDTO.getuPw() == null) return false;

        int res = memberDAO.insert(memberDTO.toEntity());
        return res > 0;
    }

    @Override
    public MemberDTO getByUserId(String uId) {
        if (uId == null) return null;

        Member member = memberDAO.select(uId);
        return member.toDTO();
    }

    @Override
    public List<MemberDTO> getAllUsers() {
        List<Member> memberList = memberDAO.selectAll();
        return memberList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }

    /*@Override
    public boolean updateUserPassword(String uId, Password uPw, Password uNewPw) {
        if (uId == null || uPw == null || uNewPw == null) return false;

        Member member = memberDAO.select(uId);
        if (member == null || member.getuPw() == null) return false;
        if (!member.getuPw().equals(uPw.getuPw())) return false;

        int res = memberDAO.update(uId, uNewPw.getuPw());
        return res > 0;
    }*/

    /*@Override
    public boolean removeByUserId(String uId, Password uPw) {
        if (uId == null || uPw == null) return false;

        Member member = memberDAO.select(uId);
        if (member == null || member.getuPw() == null) return false;
        if (!member.getuPw().equals(uPw.getuPw())) return false;

        int res = memberDAO.delete(uId);
        return res > 0;
    }*/

    /*@Override
    public boolean removeUsers() {
        int res = memberDAO.deleteAll();
        return res > 0;
    }*/

}