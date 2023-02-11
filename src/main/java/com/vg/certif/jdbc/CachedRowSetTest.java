/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.spi.SyncProviderException;
import javax.sql.rowset.spi.SyncResolver;
import java.sql.SQLException;

/**
 *
 * @author vladimir
 */
public class CachedRowSetTest {

    public static void main(String[] args) throws InterruptedException {
        try (CachedRowSet cacheRs = RowSetProvider.newFactory().createCachedRowSet()) {
            cacheRs.setUrl("jdbc:mysql://localhost:3306/test?relaxAutoCommit=true");
            cacheRs.setUsername("root");
            cacheRs.setPassword("pass123");

//            int [] keys = {3};
//            rs.setKeyColumns(keys);
            cacheRs.setCommand("select * from t");
            cacheRs.execute();
            
            while (cacheRs.next()) {
                if (cacheRs.getString(1).equals("Kolea") && cacheRs.getInt(2) > 10) {
                    cacheRs.updateInt(2, 10);
                    cacheRs.updateRow();                    
                }
            }
            
            try {
                cacheRs.acceptChanges();
            } catch (SyncProviderException spe) {
                SyncResolver resolver = spe.getSyncResolver();
                while (resolver.nextConflict()) {
                    System.out.println("Setting value " + resolver.getConflictValue(2));
                    resolver.setResolvedValue(2, resolver.getConflictValue(2));
                }
            }

        } catch (SQLException ex) {
            System.err.println("rez: " + ex.getMessage());
        }
    }
}
