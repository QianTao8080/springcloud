package com.example.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

@SpringBootTest
public class TestDriver {

    @Test
    public void test(@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String userName, @Value("${spring.datasource.password}") String password) throws SQLException {
        System.out.println(url);
        Connection connection = DriverManager.getConnection(url, userName, password);
        String sql = "SELECT *FROM student;";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println("id:" + resultSet.getInt("id") + ",name:" + resultSet.getString("name") + " 年龄：" + resultSet.getInt("age"));
        }
    }
}
