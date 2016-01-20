/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.jdbc;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author vladimir
 */
public class BugReport {
       public static void main(String[] args) throws InterruptedException {
        try (CachedRowSet cacheRs = RowSetProvider.newFactory().createCachedRowSet()) {
            cacheRs.setUrl("jdbc:mysql://localhost:3306/test");
            cacheRs.setUsername("root");
            cacheRs.setPassword("pass123");

            cacheRs.setCommand("select * from t");
            cacheRs.execute();
            
//            ((CachedRowSetImpl)cacheRs).getConnection().setAutoCommit(false);
            
            cacheRs.absolute(1);
            cacheRs.updateInt(2, 10);
            cacheRs.updateRow();
            
            cacheRs.acceptChanges();            
        } catch (SQLException ex) {
            System.err.println("rez: " + ex.getMessage());
        } finally { System.err.println("Hello");}
    }
}
