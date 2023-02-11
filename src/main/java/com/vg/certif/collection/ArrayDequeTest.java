/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.collection;

import java.util.ArrayDeque;

/**
 *
 * @author vladimir
 */
public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> dequeu = new ArrayDeque<>();
        dequeu.offer(1);
        dequeu.offer(2);
        dequeu.offer(3);
        
        while(!dequeu.isEmpty()) {
            System.out.println(dequeu.pollLast()); // FILO mechanism
        }
    }
}
