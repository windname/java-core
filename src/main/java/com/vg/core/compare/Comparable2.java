/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.core.compare;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author 1
 */
public class Comparable2 {
    public static void main(String[] args) {
        Set<PlayerType> list = new TreeSet<PlayerType>();
//        list.add(new PlayerType(3, "Tom", 20));
//        list.add(new PlayerType(1, "Bill", 30));
//        list.add(new PlayerType(2, "Bob", 10));
        System.out.println(list);
        list.add(new PlayerType(null, "Chen", 10));
        System.out.println(list);
    }
  
}
