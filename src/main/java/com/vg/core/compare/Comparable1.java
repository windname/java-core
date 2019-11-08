/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.core.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 1
 * sort array using Collections.sort(list);
 * PlayerType oveeride only compareTo method!
 */
public class Comparable1 {
    public static void main(String[] args) {
        List<PlayerType> list = new ArrayList<PlayerType>();
//        list.add(new PlayerType(3, "Tom", 20));
//        list.add(new PlayerType(1, "Bill", 30));
//        list.add(new PlayerType(2, "Bill", 10));
        list.add(new PlayerType(null, "Chen", 10));
        list.add(new PlayerType(4, "Bill", 10));
        Collections.sort(list);
        System.out.println(list);
    }
    
}
