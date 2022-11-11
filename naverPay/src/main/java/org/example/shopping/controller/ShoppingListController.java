package org.example.shopping.controller;

import org.example.sessions.SessionMgr;
import org.example.shopping.dto.ShopListDTO;
import org.example.shopping.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/naver")
public class ShoppingListController {

    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private PaymentService paymentService = PaymentService.getInstance();

    @GetMapping("/pay")
    public String shoppingListPage(HttpSession session, Model model) {

        List<ShopListDTO> shoppingDTOList = paymentService.getShoppingList(Integer.parseInt(sessionMgr.get(session, "SESSION_ID")));

        model.addAttribute("list", shoppingDTOList.stream().map(s -> s.toVo()).collect(Collectors.toList()));
        return "shopList";
    }

    @GetMapping("/shopping")
    public String shoppingPeriodSearch(HttpSession session, @RequestParam String date1, @RequestParam String date2, @RequestParam String method, Model model) { // 기간을 안 넣어도 되고 안 넣으면 디폴트값주기
        // 기간을 받아 그 기간에 해당하는 Product를 모델에서 담아서 뷰에 넘김
        List<ShopListDTO> shoppingDTOList;

        if (method.equals("전체상태")) {
            shoppingDTOList = paymentService.getShoppingPeriod(Integer.parseInt(sessionMgr.get(session, "SESSION_ID")), date1, date2);

        } else {
            shoppingDTOList = paymentService.getShoppingPeriod(Integer.parseInt(sessionMgr.get(session, "SESSION_ID")), date1, date2, method);

        }


        if (shoppingDTOList != null) {
            model.addAttribute("date1", date1);
            model.addAttribute("date2", date2);
            model.addAttribute("method", method);
            model.addAttribute("list", shoppingDTOList.stream().map(s -> s.toVo()).collect(Collectors.toList()));
        }

        return "shopListPeriod";
    }

}
