package org.example.shopping.dao;

import org.example.shopping.entity.Member;

import java.util.List;

public interface IMemberDAO {

    List<Member> search(String q);
    Member select(String uNaverId);
    List<Member> selectAll();
    int insert(Member member);
    int insertAll(List<Member> members);
    int update(String uNaverId, String uPw);
    int delete(String uNaverId);
    int deleteAll();
}
