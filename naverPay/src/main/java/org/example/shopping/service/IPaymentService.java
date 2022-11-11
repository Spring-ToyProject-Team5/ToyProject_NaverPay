package org.example.shopping.service;

import org.example.shopping.dto.ShopListDetailDTO;
import org.example.shopping.vo.ShopListVO;

import java.util.List;

public interface IPaymentService {

    ShopListDetailDTO getByPaymentId(int pmId);

    boolean removeByPaymentId(int pmId);

    List<ShopListVO> getShoppingPeriod(String uNaverId, String date1, String date2);

    List<ShopListVO> getShoppingPeriod(String uNaverId, String date1, String date2, String method);

    List<ShopListVO> getShoppingList(String uNaverId);

}
