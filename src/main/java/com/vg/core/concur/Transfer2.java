/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.core.concur;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1
 */
public class Transfer2 extends Thread {

    private Account ac1;
    private Account ac2;
    private int sum;

    public Transfer2(Account ac1, Account ac2, int sum) {
        this.ac1 = ac1;
        this.ac2 = ac2;
        this.sum = sum;
    }

    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account(100);
        Account acc2 = new Account(60);

        Transfer2 t1 = new Transfer2(acc1, acc2, 100);
        t1.start();
//        sleep(100);
        Transfer2 t2 = new Transfer2(acc2, acc1, 50);
        t2.start();

        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
    }

    public void run() {
        try {
            transferMoney(ac1, ac2, sum);
        } catch (InterruptedException ex) {
            Logger.getLogger(Transfer2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void transferMoney(Account acc1, Account acc2, int sum) throws InterruptedException {
        synchronized (acc1) {
            sleep(500);
            synchronized (acc2) {
                acc1.get(sum);
                acc2.put(sum);
            }
        }
    }
}
