/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.core.concur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 * @author 1
 */
public class Transfer4 implements Callable<Boolean>{
    private Account ac1;
    private Account ac2;
    private int sum;

    public Transfer4(Account ac1, Account ac2, int sum) {
        this.ac1 = ac1;
        this.ac2 = ac2;
        this.sum = sum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Account acc1 = new Account(100);
        Account acc2 = new Account(60);

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        final Transfer4 t1 = new Transfer4(acc1, acc2, 100);
        final Transfer4 t2 = new Transfer4(acc2, acc1, 50);
        List<Future> resultOfExecution = executorService.invokeAll(new ArrayList(){{add(t1);add(t2);}});
        for (Future<Boolean> f: resultOfExecution ) {
            System.out.println(f.get().toString());
        }
        executorService.shutdown();
        if (executorService.awaitTermination(2000, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
                
        

        System.out.println("Finished main thread");
    }

    
    @Override
    public Boolean call() throws Exception {
        if (ac1.tryLock(100, TimeUnit.MILLISECONDS)) {
            try {
                if (ac2.tryLock(100, TimeUnit.MILLISECONDS)) {
                    try {
                        ac1.get(sum);
                        ac2.put(sum);
                        System.out.println(ac1.getBalance() + " " + ac2.getBalance());
                    } finally {
                        ac2.unlock();
                    }
                }
            } finally {
                ac1.unlock();
            }
        }
        return true;
    }
    
}
