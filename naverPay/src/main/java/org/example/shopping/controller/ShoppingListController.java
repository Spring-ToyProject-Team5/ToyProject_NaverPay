package org.example.shopping.controller;

import org.example.cookies.CookieMgr;
import org.example.sessions.SessionMgr;
import org.example.shopping.dto.ShopListDTO;
import org.example.shopping.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/naver")
public class ShoppingListController {

    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private CookieMgr cookieMgr = CookieMgr.getInstance();
    private PaymentService paymentService = PaymentService.getInstance();

    @GetMapping("/pay")
    public String shoppingListPage(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
//        if (session.getAttribute("SESSION_ID") != null) { // 로그인이 되어있는 상태
//            return "로그인 화면으로";
//        }
//        sessionMgr.create(session, "SESSION_ID", "2");
        cookieMgr.delete(request, response, new String[]{"Date1", "Date2", "Method"});
        List<ShopListDTO> shoppingDTOList = paymentService.getShoppingList(Integer.parseInt(sessionMgr.get(session, "SESSION_ID")));
        model.addAttribute("list", shoppingDTOList);
        return "shopList";
    }

    @GetMapping("/shopping")
    public String shoppingPeriodSearch(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam String date1, @RequestParam String date2, @RequestParam String method, Model model) { // 기간을 안 넣어도 되고 안 넣으면 디폴트값주기
        // 기간을 받아 그 기간에 해당하는 Product를 모델에서 담아서 뷰에 넘김
        List<ShopListDTO> shoppingDTOList;
//        sessionMgr.create(session, "SESSION_ID", "2");
        if (method.equals("전체상태")) {
            shoppingDTOList = paymentService.getShoppingPeriod(Integer.parseInt(sessionMgr.get(session, "SESSION_ID")), date1, date2);
        } else {
            shoppingDTOList = paymentService.getShoppingPeriod(Integer.parseInt(sessionMgr.get(session, "SESSION_ID")), date1, date2, method);
        }


        if (shoppingDTOList != null) {
//            saveCookieForDate(date1, date2, method, response);
            model.addAttribute("date1", date1);
            model.addAttribute("date2", date2);
            model.addAttribute("method", method);
            model.addAttribute("list", shoppingDTOList);
        }

        return "shopListPeriod";
    }

    @PostMapping("/detail")
    public String detail(@RequestParam String pName) {
        System.out.println(pName);
        return "index";
    }

    // 쿠키가 아니였음. (쿠키는 새로고침해야 뜨는데 네이버페이에서는 바로 값을 줌)
//    private void saveCookieForDate(String date1, String date2, String method, HttpServletResponse response) {
//        cookieMgr.create(response, "Date1", date1);
//        cookieMgr.create(response, "Date2", date2);
//        cookieMgr.create(response, "Method", method);
//    }

}
