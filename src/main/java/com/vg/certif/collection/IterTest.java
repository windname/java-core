/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author vladimir
 */
public class IterTest {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(); 
        set.add("A");
        // Iterator<String> iter = set.iterator(); // ConcurrentModificationException !!! if we have line above
        set.add("R");
        Iterator<String> iter = set.iterator(); 
        while (iter.hasNext()) {
            // iter.remove(); // java.lang.IllegalStateException !!!
            System.out.println(iter.next());
            iter.remove();
        }
    }
}
