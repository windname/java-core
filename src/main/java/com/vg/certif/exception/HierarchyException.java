/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vladimir
 */
public class HierarchyException {
    
    public static void main(String[] args) {
        new HierarchyException();
    }

    public HierarchyException() {
        try (MyClass clazz = new MyClass()) {
            System.out.println("Execute");
            if (true) {
                throw new SQLException();
            }
        } 
//        catch (SQLException | Exception ex) { // not allowe because the same hierarchy
        catch(FileNotFoundException | SQLException | ClassCastException ex) 
        {
            System.out.println(ex);
        } catch (Exception ex2)  {
            System.out.println(ex2);
        } finally {
            System.out.println("Finally close");
        }
    }

    class MyClass implements AutoCloseable {

        @Override
        public void close() throws FileNotFoundException, Exception {
            try {
            System.out.println("Close object");
            } catch (Exception ex) {
                throw ex;
            }
        }
    }

}
