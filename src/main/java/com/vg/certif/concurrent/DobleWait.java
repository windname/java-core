/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.concurrent;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vladimir
 */
public class DobleWait {
    
    private static final String str="";
    
    public static void main(String[] args) {
        Thread t = new Thread(){

            @Override
            public void run() {
                synchronized(str) {
                try {
                    System.out.println("Before wait");
                    str.wait(100);
//                    wait();
                    System.out.println("After wait");
                } catch (InterruptedException ex) {
                    System.out.println("Error ");
                }}
            }
            
        };
        
        t.run();
    }
}
