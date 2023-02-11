/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

/**
 *
 * @author vladimir
 */
public class JoinSetTest {
    public static void main(String[] args) {
        
            try (CachedRowSet cacheRs = RowSetProvider.newFactory().createCachedRowSet();
                 CachedRowSet cacheRs2 = RowSetProvider.newFactory().createCachedRowSet();
                    JoinRowSet jrs = RowSetProvider.newFactory().createJoinRowSet();
                    ) {
            cacheRs.setUrl("jdbc:mysql://localhost:3306/test?relaxAutoCommit=true");
            cacheRs.setUsername("root");
            cacheRs.setPassword("pass123");

            cacheRs.setCommand("select * from t");
            cacheRs.execute();
            
            cacheRs2.setUrl("jdbc:mysql://localhost:3306/test?relaxAutoCommit=true");
            cacheRs2.setUsername("root");
            cacheRs2.setPassword("pass123");

            cacheRs2.setCommand("select * from t");
            cacheRs2.execute();
            
            jrs.addRowSet(cacheRs, "name");
            jrs.addRowSet(cacheRs2, "name");
            
            int n = jrs.getMetaData().getColumnCount();
            while (jrs.next()) {
                System.out.println("row");
                for (int i=1; i<=n; i++)
                System.out.print(" " + jrs.getString(i));
                
            }
        } catch (SQLException ex) {
            System.err.println("rez: " + ex.getMessage());
        }
    }
}
