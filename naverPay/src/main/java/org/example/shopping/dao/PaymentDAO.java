package org.example.shopping.dao;

import org.example.shopping.database.JDBCMgr;
import org.example.shopping.dto.ShopListDetailDTO;
import org.example.shopping.entity.Payment;
import org.example.shopping.entity.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class PaymentDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;


    private static final String PAYMENT_SELECT = "select * from payment where pmId = ?";
    private static final String PAYMENT_DELETE = "delete from payment where pmId = ?";
    private static final String PRODUCT_SELECT = "select * from product where pId = ?";
    private static final String SHOPLIST_DETAIL ="SELECT *\n" +
                                                                                        "from payment\n" +
                                                                                        "join product\n" +
                                                                                        "on product.pId = payment.pId\n" +
                                                                                        "where pmId = ?";

    private static final String SHOPLIST_SELECT_ALL ="SELECT *\n" +
                                                                                                "from payment\n" +
                                                                                                "join product\n" +
                                                                                                "on product.pId = payment.pId\n" +
                                                                                                "where uId = ?";

    private static final String USER_PAYMENT = "select * from payment where uId = ? ";

    public PaymentDAO() {
        System.out.println("PaymentDAO()");
    }

    public Payment paymentSelect(int pmId) {
        Payment payment = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PAYMENT_SELECT);
            stmt.setInt(1,pmId);

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


                payment =  new Payment(pmId, uId, pId, cardName
                        , cardNum, paymentMethod,paymentDate,progress
                        ,productNum,savedPoint,usePoint);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return payment;
    }

    public Product productSelect(int pId) {
        Product product = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PRODUCT_SELECT);
            stmt.setInt(1,pId);

            rs = stmt.executeQuery();
            if (rs.next()) {

                String pName = rs.getString("pName");
                int pPrice = rs.getInt("pPrice");
                String pCompany = rs.getString("pCompany");
                String pCompanyPhone = rs.getString("pCompanyPhone");

                product =  new Product(pId, pName, pPrice, pCompany, pCompanyPhone);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return product;
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

    public ShopListDetailDTO shopListDetail(int pmId){
        ShopListDetailDTO shopListDetailDTO = new ShopListDetailDTO();
        System.out.println("dao");
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SHOPLIST_DETAIL);
            stmt.setInt(1,pmId);

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


                shopListDetailDTO =new  ShopListDetailDTO(pmId, uId, pId, cardName
                        , cardNum, paymentMethod,paymentDate,progress
                        ,productNum,savedPoint,usePoint, pName, pPrice, pCompany, pCompanyPhone);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return shopListDetailDTO;
    }

}
