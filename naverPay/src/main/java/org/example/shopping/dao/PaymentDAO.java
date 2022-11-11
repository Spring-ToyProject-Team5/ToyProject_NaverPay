package org.example.shopping.dao;


import org.example.shopping.database.JDBCMgr;
import org.example.shopping.dto.ShopListDTO;
import org.example.shopping.dto.ShopListDetailDTO;
import org.example.shopping.vo.ShopListVO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PaymentDAO implements IPaymentDAO {

    private static PaymentDAO paymentDAO = null;
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String PAYMENT_DELETE = "delete from payment where pmId = ?";
    private static final String PAYMENT_SELECT_ALL = "select * from payment join product on product.pId = payment.pId join member on member.uId = payment.uId where payment.uId = ? order by paymentDate DESC";
    private static final String SHOPPING_SEARCH_PERIOD = "select * from payment join product on product.pId = payment.pId join member on member.uId = payment.uId where (payment.uId = ?) and (paymentDate between ? and ?) order by paymentDate DESC";
    private static final String SHOPPING_SEARCH_PERIOD_METHOD = "select * from payment join product on product.pId = payment.pId join member on member.uId = payment.uId where (payment.uId = ?) and (paymentDate between ? and ?) and (paymentMethod = ?) order by paymentDate DESC";
    private static final String SHOPLIST_DETAIL = "SELECT *\n" +
            "from payment\n" +
            "join product\n" +
            "on product.pId = payment.pId\n" +
            "where pmId = ?";


    public static PaymentDAO getInstance() {
        if (paymentDAO == null) {
            paymentDAO = new PaymentDAO();
        }
        return paymentDAO;
    }

    public int delete(int pmId) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PAYMENT_DELETE);
            stmt.setInt(1, pmId);

            res = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    public ShopListDetailDTO shopListDetail(int pmId) {
        ShopListDetailDTO shopListDetailDTO = new ShopListDetailDTO();

        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SHOPLIST_DETAIL);
            stmt.setInt(1, pmId);

            rs = stmt.executeQuery();
            if (rs.next()) {
                int uId = rs.getInt("uId");
                int pId = rs.getInt("payment.pId");
                String cardName = rs.getString("cardName");
                String cardNum = rs.getString("cardNum");
                String paymentMethod = rs.getString("paymentMethod");
                String paymentDate = rs.getString("paymentDate");
                String progress = rs.getString("progress");
                int productNum = rs.getInt("productNum");
                int savedPoint = rs.getInt("savedPoint");
                int usePoint = rs.getInt("usePoint");

                String pName = rs.getString("pName");
                int pPrice = rs.getInt("pPrice");
                String pCompany = rs.getString("pCompany");
                String pCompanyPhone = rs.getString("pCompanyPhone");


                shopListDetailDTO = new ShopListDetailDTO(pmId, uId, pId, cardName
                        , cardNum, paymentMethod, paymentDate, progress
                        , productNum, savedPoint, usePoint, pName, pPrice, pCompany, pCompanyPhone);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return shopListDetailDTO;
    }

    public List<ShopListVO> userSearchPeriod(int id, String date1, String date2) {
        List<ShopListDTO> shoppingList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SHOPPING_SEARCH_PERIOD);
            stmt.setInt(1, id);
            stmt.setString(2, date1);
            stmt.setString(3, date2);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int pmId = rs.getInt("pmId");
                int uId = rs.getInt("uId");
                int pId = rs.getInt("pId");
                String paymentMethod = rs.getString("paymentMethod");
                String paymentDate = rs.getString("paymentDate");
                String pName = rs.getString("pName");
                int pPrice = rs.getInt("pPrice");
                String companyName = rs.getString("pCompany");
                String companyNamePhone = rs.getString("pCompanyPhone");
                int productNum = rs.getInt("productNum");
                String uNaverId = rs.getString("uNaverId");


                shoppingList.add(new ShopListDTO(pmId, uId, pId, paymentMethod, paymentDate, pName, pPrice, companyName, companyNamePhone, productNum, uNaverId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }

        return shoppingList.stream().map(s -> s.toVo()).collect(Collectors.toList());
    }

    public List<ShopListVO> userSearchPeriod(int id, String date1, String date2, String method) {
        List<ShopListDTO> shoppingList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SHOPPING_SEARCH_PERIOD_METHOD);
            stmt.setInt(1, id);
            stmt.setString(2, date1);
            stmt.setString(3, date2);
            stmt.setString(4, method);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int pmId = rs.getInt("pmId");
                int uId = rs.getInt("uId");
                int pId = rs.getInt("pId");
                String paymentMethod = rs.getString("paymentMethod");
                String paymentDate = rs.getString("paymentDate");
                String pName = rs.getString("pName");
                int pPrice = rs.getInt("pPrice");
                String companyName = rs.getString("pCompany");
                String companyNamePhone = rs.getString("pCompanyPhone");
                int productNum = rs.getInt("productNum");
                String uNaverId = rs.getString("uNaverId");

                shoppingList.add(new ShopListDTO(pmId, uId, pId, paymentMethod, paymentDate, pName, pPrice, companyName, companyNamePhone, productNum, uNaverId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }

        return shoppingList.stream().map(s -> s.toVo()).collect(Collectors.toList());
    }

    public List<ShopListVO> userSelectAll(int id) {
        List<ShopListDTO> shoppingList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PAYMENT_SELECT_ALL);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int pmId = rs.getInt("pmId");
                int uId = rs.getInt("uId");
                int pId = rs.getInt("pId");
                String paymentMethod = rs.getString("paymentMethod");
                String paymentDate = rs.getString("paymentDate");
                String pName = rs.getString("pName");
                int pPrice = rs.getInt("pPrice");
                String companyName = rs.getString("pCompany");
                String companyNamePhone = rs.getString("pCompanyPhone");
                int productNum = rs.getInt("productNum");
                String uNaverId = rs.getString("uNaverId");

                shoppingList.add(new ShopListDTO(pmId, uId, pId, paymentMethod, paymentDate, pName, pPrice, companyName, companyNamePhone, productNum, uNaverId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return shoppingList.stream().map(s -> s.toVo()).collect(Collectors.toList());
    }

}