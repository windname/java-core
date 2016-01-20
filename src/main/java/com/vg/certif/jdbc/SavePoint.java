/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;

/**
 *
 * @author vladimir
 */
public class SavePoint {
        public static void main(String[] args) {
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "pass123");
        String sql = "select * from t";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", props);
                Statement st = conn.createStatement();) {
            conn.setAutoCommit(false);

            try {
                st.executeUpdate("update t set name = 'My Elizabeth' ");
                Savepoint sp1 = conn.setSavepoint("up1");
                
                st.executeUpdate("update t set age = 3 ");
                Savepoint sp2 = conn.setSavepoint("up2");
                
                Calendar c = Calendar.getInstance();
                c.set(2015, Calendar.MARCH, 27);
                if ((new Date()).before(c.getTime())) {
                    conn.rollback(sp2);
                }
                
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

