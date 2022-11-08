package org.example.shopping.controller;

//import org.example.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("shop-list")
public class ShopDetailViewController {
//    private SessionMgr sessionMgr; // = SessionMgr.getInstance();

//    @Autowired
//    public ShopDetailViewController(SessionMgr sessionMgr) {
//        this.sessionMgr = sessionMgr;
//    }
//
//    @GetMapping("/detail")
//    public String shopListDetail(Model model, HttpSession session, HttpServletRequest httpServletRequest) {
//        String view = "shopDetail";
//        if (session.getAttribute("SESSION_ID") != null) { // 로그인이 되어있는 상태
//            return "redirect:/";
//        }
//
//        sessionMgr.create(session,"imakecookieid");
//        model.addAttribute("uId", sessionMgr.get(session));
//
//        System.out.println(model.getAttribute("detail"));
//        return view;
//    }
}
