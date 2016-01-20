/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 *
 * @author vladimir
 */
public class ThreadFactoryTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor(new MaxPriorityThreadFactory());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with priority: " + new Thread(this).getPriority());
            }
        });
        executor.shutdown();
    }
    static class MaxPriorityThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.MAX_PRIORITY);
        return t;
    }
}
}
