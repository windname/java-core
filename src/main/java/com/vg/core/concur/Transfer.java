/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.core.concur;

/**
 *
 * @author 1
 */
public class Transfer extends Thread {
    private Account ac1;
    private Account ac2;
    private int sum;

    public Transfer(Account ac1, Account ac2, int sum) {
        this.ac1 = ac1;
        this.ac2 = ac2;
        this.sum = sum;
    }

    
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account(100);
        Account acc2 = new Account(60);
        
        Transfer t1 = new Transfer(acc1, acc2, 100);
        t1.start();
        sleep(100);
        Transfer t2 = new Transfer(acc2, acc1, 50);
        t2.start();
        
        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
    }
    
    public void run() {
        transferMoney(ac1, ac2, sum);
    } 
    
    public void transferMoney(Account acc1, Account acc2, int sum ) {
        acc1.get(sum);
        acc2.put(sum);
    }
}
