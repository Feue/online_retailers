package com.feue.missyou;

import org.junit.Test;

import java.sql.*;

/**
 * @author Feue
 * @create 2021-07-20 14:51
 */
public class JdbcTest {
    @Test
    public void test() throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "070310";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
                    while (rs.next()) {
                        long id = rs.getLong(1); // 注意：索引从1开始
                        long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                        System.out.println("id:"+id+",grade:"+grade+",name:"+name+",gender:"+gender);
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
