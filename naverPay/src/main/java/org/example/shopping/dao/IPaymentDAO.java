package org.example.shopping.dao;

import org.example.shopping.dto.ShopListDetailDTO;
import org.example.shopping.vo.ShopListVO;

import java.util.List;

public interface IPaymentDAO {

    int delete(int pmId);

    ShopListDetailDTO shopListDetail(int pmId);

    List<ShopListVO> userSearchPeriod(int id, String date1, String date2);

    List<ShopListVO> userSearchPeriod(int id, String date1, String date2, String method);

    List<ShopListVO> userSelectAll(int id);

}
