/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author vladimir
 */
public class CloseException implements AutoCloseable {

    public static void main(String[] args) {
        try (CloseException ce = new CloseException()) {
            if (false) {
                throw new IOException("Body exception");
            }
            System.out.println("Body message");

        } catch (IOException | NumberFormatException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        System.out.printf("Invoke noCatch %n%n%n");
        try {
            noCatch();
        } catch (IOException ex) {
            System.err.println("First exception " + ex.getMessage());
            for (Throwable e : ex.getSuppressed()) {
                System.err.println("One more exception! " + ex.getMessage());
            }
        }
    }

    private static void noCatch() throws IOException {
        try (CloseException ce = new CloseException(); 
                CloseException ce1 = new CloseException();
                CloseException ce2 = new CloseException()) {
            System.out.println(" Method throws try block not");
            throw new IOException("Body exception");
        }
    }

    @Override
    public void close() throws IOException, ClassCastException {
        if (false) {
            throw new FileNotFoundException("file not found");
        }

        try {
            throw new FileNotFoundException("io found");
        } catch (Exception ex) {
            throw ex;
        }
    }

}
