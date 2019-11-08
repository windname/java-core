/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.core.concur;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author 1
 */
public class Account extends ReentrantLock{

    private int balance;

    public int getBalance() {
        return balance;
    }

    public Account(int b) {
        balance = b;
    }

    public void get(int sum) {
        balance -= sum;
    }

    public void put(int sum) {
        balance += sum;
    }
}
