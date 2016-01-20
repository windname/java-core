/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.exception;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author vladimir
 */
public class Animals {

    class Lamb implements Closeable {
        public void close() {
            throw new RuntimeException("a");
        }
    }

    public static void main(String[] args) throws IOException{
        new Animals().run();
    }

    public void run() throws IOException{
        try (Lamb l = new Lamb();) {
            throw new IOException();
        } catch (Exception e) {
            throw e; // now getting IOexception with suppresed RuntimeException: a
//            throw new RuntimeException("c"); // in this case will get just RuntimeException c
        }
    }
}
