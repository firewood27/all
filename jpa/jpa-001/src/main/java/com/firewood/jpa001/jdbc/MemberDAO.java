package com.firewood.jpa001.jdbc;

import java.sql.ResultSet;

public class MemberDAO {



    public Member find(String memberId) {
        String sql = "SELECT MEMBER_ID, NAME FROM MEMBER M WHERE MEMBER_ID = ?";
        ResultSet rs = 
    }

    public void save(Member member) {

    }
}
