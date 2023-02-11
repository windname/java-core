/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

/**
 *
 * @author vladimir
 */
public class JdbcRowTest {

    public static void main(String[] args) throws SQLException {

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl("jdbc:mysql://localhost:3306/test");
            jdbcRs.setUsername("root");
            jdbcRs.setPassword("pass123");

            jdbcRs.setCommand("select * from t");
            jdbcRs.execute();

            jdbcRs.moveToInsertRow();
            jdbcRs.updateString(1, "Kolea");
            jdbcRs.updateInt(2, 25);
            jdbcRs.insertRow();

            jdbcRs.last();
            jdbcRs.deleteRow(); // remove row
            
        } catch (SQLException ex) {
            System.err.println("rez: " + ex.getMessage());
        }

    }
}
