package org.example.shopping.service;


import org.example.shopping.dao.PaymentDAO;
import org.example.shopping.dto.ShopListDTO;
import org.example.shopping.dto.ShopListDetailDTO;
import org.example.shopping.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private PaymentDAO paymentDAO = PaymentDAO.getInstance();

    private static PaymentService paymentService = null;

    public static PaymentService getInstance() {
        if (paymentService == null) {
            paymentService = new PaymentService();
        }
        return paymentService;
    }


    public ShopListDetailDTO getByPaymentId(int pmId) {
        if (pmId == 0) return null;
        ShopListDetailDTO shopListDetailDTO = paymentDAO.shopListDetail(pmId);
        return shopListDetailDTO;
    }


    public boolean removeByPaymentId(int paymentId) {
        if (paymentId == 0) return false;

        int res = paymentDAO.delete(paymentId);
        return res > 0;
    }


    public List<ShopListDTO> getShoppingPeriod(String date1, String date2) {
        if (date1 == null || date2 == null) {
            return null;
        }
        List<ShopListDTO> shoppingList = paymentDAO.searchPeriod(date1, date2);
        if (shoppingList == null) return null;

        return shoppingList;
    }


    public List<ShopListDTO> getShoppingPeriod(String date1, String date2, String method) {
        if (date1 == null || date2 == null || method == null) {
            return null;
        }

        List<ShopListDTO> shoppingList = paymentDAO.searchPeriod(date1, date2, method);

        if (shoppingList == null) {
            return null;
        }

        return shoppingList;
    }


    public List<ShopListDTO> getShoppingList() {
        List<ShopListDTO> shoppingList = paymentDAO.selectAll();

        if (shoppingList == null) {
            return null;
        }

        return shoppingList;
    }


}
