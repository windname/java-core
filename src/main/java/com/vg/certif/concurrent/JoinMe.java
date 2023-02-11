/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.concurrent;

/**
 *
 * @author vladimir
 */
public class JoinMe {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {public void run() {
            System.out.println("Start thread");
            try {
                sleep(500);
            } catch (InterruptedException ex) {                
            }
            System.out.println("End thread");
        }};
        
        new JoinMe().new MyThread().start();
        thread.start();
        thread.join(); // main waits thread to die
        System.out.println("Main thread is done");
    }
    
    class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Start my thread");
            try {
//                join(); // never thread finished
                join(1000); // sleep 1000
            } catch (InterruptedException ex) {                
            }
            System.out.println("End my thread");
        }
        
    }
}
