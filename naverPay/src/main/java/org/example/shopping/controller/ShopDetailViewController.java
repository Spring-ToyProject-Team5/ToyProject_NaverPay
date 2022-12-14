package org.example.shopping.controller;

import jakarta.validation.constraints.Min;
import org.example.response.BaseResponse;
import org.example.response.StatusEnum;
import org.example.sessions.SessionMgr;
import org.example.shopping.dto.ShopListDetailDTO;
import org.example.shopping.service.PaymentService;
import org.example.shopping.vo.ShopListDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/naver/pay")
public class ShopDetailViewController {
    private SessionMgr sessionMgr; // = SessionMgr.getInstance();
    private PaymentService paymentService;

    @Autowired
    public ShopDetailViewController(SessionMgr sessionMgr, PaymentService paymentService) {
        this.sessionMgr = sessionMgr;
        this.paymentService = paymentService;
    }


    @GetMapping("/{pmId}")
    public String getShopListDetail(@PathVariable Integer pmId, Model model, HttpSession session) {
        if (pmId < 1) {
            return "redirect:/naver/pay"; //쇼핑리스트 페이지로 돌아가게 하면 될 것 같음
        }

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        model.addAttribute("uId", sessionMgr.get(session));

        ShopListDetailDTO shopListDetailDTO = paymentService.getByPaymentId(pmId);

        if (shopListDetailDTO == null) {
            return "redirect:/naver/pay"; //쇼핑리스트 페이지로 돌아가게 하면 될 것 같음
        }

        model.addAttribute("detail", shopListDetailDTO.toVO());
        return "shopDetail";
    }

    @GetMapping("/delete/{pmId}")
    public String removeByPaymentId(@PathVariable @Min(1) Integer pmId, HttpSession session, Model model) {

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        model.addAttribute("uId", sessionMgr.get(session));

        StatusEnum status = paymentService.removeByPaymentId(pmId) ?
                StatusEnum.SUCCESS : StatusEnum.CANT_DELETE;

        return "redirect:/naver/pay";
    }

}