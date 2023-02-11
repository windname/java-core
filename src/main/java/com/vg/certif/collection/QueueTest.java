/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.collection;

import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author vladimir
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> q1 = new ArrayBlockingQueue<>(10);
        
        // throw exceptions if queue is empty or element to add is null
        q1.add(1);
        System.out.println(q1.element());
        System.out.println(q1.remove());
        
        // don't throws any exception
        q1.offer(2);        
        System.out.println(q1.peek());
        System.out.println(q1.poll());
        
        AbstractQueue<Integer> q2 = new PriorityQueue<>();
        q2.offer(1);
        q2.offer(3);
        q2.offer(2);
        System.out.println("q2=" + q2);
        while (!q2.isEmpty()) {
            System.out.println(q2.poll());
        }
        
    }
}
