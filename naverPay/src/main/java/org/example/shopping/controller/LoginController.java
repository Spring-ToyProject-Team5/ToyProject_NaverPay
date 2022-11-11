package org.example.shopping.controller;


import org.example.cookies.CookieMgr;
import org.example.shopping.dto.MemberDTO;
import org.example.shopping.service.MemberService;
import org.example.sessions.SessionMgr;
import org.example.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/naver")
public class LoginController {

    private SessionMgr sessionMgr;// = SessionMgr.getInstance();
    private CookieMgr cookieMgr;// = CookieMgr.getInstance();
    private MemberService memberService;// = MemberService.getInstance();
    @Autowired
    public LoginController(SessionMgr sessionMgr, CookieMgr cookieMgr, MemberService memberService) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, HttpSession session) {
        String view = "members/nonlogin/login";

        if (session.getAttribute("SESSION_ID") != null) { // 로그인이 되어있는 상태
            return "redirect:/naver/pay";
        }

        return view;
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String uNaverId, @RequestParam String uPw, @RequestParam(required = false) String save,
                          Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        String view = loginPage(request, session);
        Status respStatus = Status.FAIL;

        MemberDTO memberDTO = memberService.login(uNaverId, uPw);
        if (memberDTO != null) {
            sessionMgr.create(session, Integer.toString(memberDTO.getUId()));


            view = "redirect:/naver/pay";
            respStatus = Status.SUCCESS;
        }


        session.setAttribute("login", respStatus);
        model.addAttribute("uId", session.getAttribute("SESSION_ID"));
        return view;

    }

}