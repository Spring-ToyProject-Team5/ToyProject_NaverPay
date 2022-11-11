package org.example.shopping.controller;

import org.example.sessions.SessionMgr;
import org.example.shopping.service.PaymentService;
import org.example.shopping.vo.ShopListVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/naver")
public class ShoppingListController {

    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private PaymentService paymentService = PaymentService.getInstance();

    @GetMapping("/pay")
    public String shoppingListPage(HttpSession session, Model model) {
//        if (session.getAttribute("SESSION_ID") != null) { // 로그인이 되어있는 상태
//            return "로그인 화면으로";
//        }
        List<ShopListVO> shoppingDTOList = paymentService.getShoppingList(sessionMgr.get(session, "SESSION_ID"));
        model.addAttribute("list", shoppingDTOList);
        return "shopList";
    }

    @GetMapping("/shopping")
    public String shoppingPeriodSearch(HttpSession session, @RequestParam String date1, @RequestParam String date2, @RequestParam String method, Model model) { // 기간을 안 넣어도 되고 안 넣으면 디폴트값주기
        List<ShopListVO> shoppingDTOList;
        if (method.equals("전체상태")) {
            shoppingDTOList = paymentService.getShoppingPeriod(sessionMgr.get(session, "SESSION_ID"), date1, date2);
        } else {
            shoppingDTOList = paymentService.getShoppingPeriod(sessionMgr.get(session, "SESSION_ID"), date1, date2, method);
        }

        if (shoppingDTOList != null) {
            model.addAttribute("date1", date1);
            model.addAttribute("date2", date2);
            model.addAttribute("method", method);
            model.addAttribute("list", shoppingDTOList);
        }

        return "shopListPeriod";
    }

}
