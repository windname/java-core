/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author vladimir
 */
public class Transactions {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "pass123");
        String sql = "select * from t";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", props);
                Statement st = conn.createStatement();) {
//            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ); // optional
            conn.setAutoCommit(false);

            try {
                st.executeUpdate("update t set name = 'Elizabeth' ");
            } catch (SQLException ex) {
                conn.rollback();
                conn.setAutoCommit(true);
                throw ex;
            }
            
            conn.commit();
            conn.setAutoCommit(true);

        } catch (SQLException ex) {
            System.err.println("error: " + ex.getMessage());
        }
    }
}
