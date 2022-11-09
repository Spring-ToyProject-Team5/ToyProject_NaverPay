package org.example.shopping.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.example.response.BaseResponse;
import org.example.response.StatusEnum;
import org.example.sessions.SessionMgr;
import org.example.shopping.dto.ShopListDetailDTO;
import org.example.shopping.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/shop-list")
@Validated
public class ShoppingDetailController {
    private SessionMgr sessionMgr; // = SessionMgr.getInstance();
    private PaymentService paymentService;

    @Autowired
    public ShoppingDetailController(SessionMgr sessionMgr, PaymentService paymentService) {
        this.sessionMgr = sessionMgr;
        this.paymentService = paymentService;
    }
    @GetMapping("detail/{pmId}")
    public ResponseEntity<BaseResponse> getShopListDetailByUserId(@PathVariable @Min(1) Integer pmId, Model model) {
        if (pmId <1 ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new BaseResponse<>(StatusEnum.BAD_REQUEST));
        }
        ShopListDetailDTO shopListDetailDTO = paymentService.getByPaymentId(pmId);

        if (shopListDetailDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new BaseResponse<>(StatusEnum.NOT_FOUND, shopListDetailDTO));
        }

        return ResponseEntity.ok().body(new BaseResponse(shopListDetailDTO.toVO()));
    }

    @DeleteMapping("/detail/{pmId}")
    public ResponseEntity<BaseResponse> removeByPaymentId(@PathVariable @Min(1) Integer pmId, HttpSession session) {
        if (pmId <1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new BaseResponse<>(StatusEnum.BAD_REQUEST));
        }

        StatusEnum status = paymentService.removeByPaymentId( pmId) ?
                StatusEnum.SUCCESS : StatusEnum.CANT_DELETE;

        return ResponseEntity.ok()
                .body(new BaseResponse(status));
    }


}
