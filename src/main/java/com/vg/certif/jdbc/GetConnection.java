/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author vladimir
 */
public class GetConnection {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "pass123");
        String sql = "select * from t";

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", props);
             Statement st = conn.createStatement();) {
             ResultSet rs = st.executeQuery(sql);
             while (rs.next()) {
                 System.out.println(rs.getString(1) + " " + rs.getString(2));
             }
        } catch (Exception ex) {
            System.err.println("error: " + ex.getMessage());
        }
    }
}
