/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.jdbc;

import java.sql.*;
import java.util.Properties;

/**
 *
 * @author vladimir
 */
public class MetadataInfo {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "pass123");
        String sql = "select * from t";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", props);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)
                ) {

            DatabaseMetaData metaData = conn.getMetaData();
            String s1 = metaData.getDatabaseProductName();
            System.out.println("dnBame " + s1);
            s1 = metaData.getDriverName();
            System.out.println("DriverName " + s1);
            s1 = metaData.getURL();
            System.out.println("url " + s1);            
            System.out.println("DB ver " + metaData.getDatabaseMajorVersion());
            System.out.println("Driver ver " + metaData.getDriverMajorVersion());
            
            ResultSetMetaData rsMetaData = rs.getMetaData();
            System.out.println("columns " + rsMetaData.getColumnCount());
            System.out.println("name " + rsMetaData.getColumnName(1));
            System.out.println("type " + rsMetaData.getColumnType(1)); // Types.VARCHAR
            
        } catch (Exception ex) {
            System.err.println("error: " + ex.getMessage());
        }
    }
}
