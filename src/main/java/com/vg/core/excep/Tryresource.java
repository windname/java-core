/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.core.excep;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author 1
 */
public class Tryresource {

    public Tryresource() throws IOException {
        try (MyCloseable obj = new MyCloseable()) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        try {
            new Tryresource();
        } catch (IOException ex) {
            System.err.println("Error");
        }
    }

    class MyCloseable implements Closeable {
        @Override
        public void close() throws IOException {
            System.out.println("Close Resource");
        }
    }
}
