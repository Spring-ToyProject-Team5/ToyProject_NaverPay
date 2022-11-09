package org.example.shopping.dao;

import org.example.shopping.database.JDBCMgr;
import org.example.shopping.entity.Member;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemberDAO implements IMemberDAO {
    private static MemberDAO memberDAO = null;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String MEMBER_SEARCH = "select * from member where uNaverId like ? or uEmail like ?";
    private static final String MEMBER_SELECT_ALL = "select * from member";
    private static final String MEMBER_SELECT = "select * from member where uNaverId = ?";
    private static final String MEMBER_INSERT = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String MEMBER_PASSWORD_UPDATE = "update member set uPw = ? where uNaverId ?";
    private static final String MEMBER_DELETE = "delete member where uNaverId = ?";
    private static final String MEMBER_DELETE_ALL = "delete member";

    public static MemberDAO getInstance() {
        if (memberDAO == null) {
            memberDAO = new MemberDAO();
        }
        return memberDAO;
    }

    @Override
    public List<Member> search(String q) { // 이름이나 이메일로 검색
        List<Member> memberList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SEARCH);
            stmt.setString(1, "%" + q + "%");
            stmt.setString(2, "%" + q + "%");

            rs = stmt.executeQuery();
            while (rs.next()) {
                int uId = rs.getInt("uId");
                String uNaverId = rs.getString("uNaverId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");
                String uName = rs.getString("uName");
                String uPhone = rs.getString("uPhone");
                String uAddress = rs.getString("uAddress");
                int uPoint = rs.getInt("uPoint");

                memberList.add(new Member(uId, uName, uPhone, uAddress, uEmail, uNaverId, uPw, uPoint));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }

        return memberList;
    }

    @Override
    public Member select(String uNaverId) {
        Member member = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT);
            stmt.setString(1, uNaverId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                int uId = rs.getInt("uId");
                String mNaverId = rs.getString("uNaverId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");
                String uName = rs.getString("uName");
                String uPhone = rs.getString("uPhone");
                String uAddress = rs.getString("uAddress");
                int uPoint = rs.getInt("uPoint");
                member = new Member(uId, uName, uPhone, uAddress, uEmail, mNaverId, uPw, uPoint);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return member;
    }

    @Override
    public List<Member> selectAll() {
        List<Member> memberList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT_ALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int uId = rs.getInt("uId");
                String mNaverId = rs.getString("uNaverId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");
                String uName = rs.getString("uName");
                String uPhone = rs.getString("uPhone");
                String uAddress = rs.getString("uAddress");
                int uPoint = rs.getInt("uPoint");

                memberList.add(new Member(uId, uName, uPhone, uAddress, uEmail, mNaverId, uPw, uPoint));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return memberList;
    }

    @Override
    public int insert(Member member) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_INSERT);
            stmt.setInt(1, member.getUId());
            stmt.setString(2, member.getUNaverId());
            stmt.setString(3, member.getUPw());
            stmt.setString(4, member.getUEmail());
            stmt.setString(5, member.getUName());
            stmt.setString(6, member.getUPhone());
            stmt.setString(7, member.getUAddress());
            stmt.setInt(8, member.getUPoint());
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int insertAll(List<Member> members) {
        return members.stream().map(m -> memberDAO.insert(m)).collect(Collectors.toList()).stream().reduce((x, y) -> x + y).orElse(0);
    }

    @Override
    public int update(String uNaverId, String uPw) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_PASSWORD_UPDATE);
            stmt.setString(1, uPw);
            stmt.setString(2, uNaverId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int delete(String uNaverId) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE);
            stmt.setString(1, uNaverId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int deleteAll() {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE_ALL);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

}