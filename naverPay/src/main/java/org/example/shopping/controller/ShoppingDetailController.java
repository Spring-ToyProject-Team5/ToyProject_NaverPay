package org.example.shopping.controller;

import jakarta.validation.constraints.Min;
import org.example.response.BaseResponse;
import org.example.response.StatusEnum;
import org.example.shopping.dto.ShopListDetailDTO;
import org.example.shopping.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop-list")
@Validated
public class ShoppingDetailController {
    private PaymentService paymentService;

    @Autowired
    public ShoppingDetailController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("detail/{pmId}")
    public ResponseEntity<BaseResponse> getShopListDetailByUserId(@PathVariable @Min(1) Integer pmId, Model model) {
        ShopListDetailDTO shopListDetailDTO = paymentService.getByPaymentId(pmId);

        if (shopListDetailDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new BaseResponse<>(StatusEnum.NOT_FOUND, shopListDetailDTO));
        }

        model.addAttribute("detail", shopListDetailDTO);
        return ResponseEntity.ok().body(new BaseResponse(shopListDetailDTO));
    }

    @DeleteMapping("/detail/{paymentId}")
    public ResponseEntity<BaseResponse> removeByPaymentId(@PathVariable @Min(1) Integer paymentId) {
        if (paymentId == null) {
            return ResponseEntity.badRequest().body(new BaseResponse(StatusEnum.BAD_REQUEST));
        };

        StatusEnum status = paymentService.removeByPaymentId(paymentId) ?
                StatusEnum.SUCCESS : StatusEnum.CANT_DELETE;

        return ResponseEntity.ok()
                .body(new BaseResponse(status));
    }
}
