/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.concurrent;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vladimir
 */
public class BlockDeposit {

    public static void main(String[] args) {
        
        final Deposit d = new Deposit();
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    d.put();
                }
            }
        };

        Thread concumer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    d.get();
                }
            }
        };

        concumer.start();
        producer.start();

    }

    static class Deposit {

        LinkedList<String> queue = new LinkedList<>();

        public synchronized void put() {
            while (queue.size() > 0) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BlockDeposit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Put product");
            queue.add("product");
            notifyAll();
        }

        public synchronized void get() {
            while (queue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BlockDeposit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Get " + queue.remove());
            notifyAll();
        }
    }
}
