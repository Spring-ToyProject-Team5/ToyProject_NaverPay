package org.example.shopping.service;


import org.example.shopping.dao.PaymentDAO;
import org.example.shopping.dto.ShopListDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PaymentService {
    private PaymentDAO paymentDAO;

    @Autowired
    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public ShopListDetailDTO getByPaymentId(int pmId){
        ShopListDetailDTO shopListDetailDTO = paymentDAO.shopListDetail(pmId);
        return shopListDetailDTO;
    }


    public boolean removeByPaymentId(int pmId){

        int res = paymentDAO.delete(pmId);
        return res>0;
    }




}
