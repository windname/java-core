/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author vladimir
 */
public class SortTest {
    
    public static void main(String[] args) {
        SortTest st = new SortTest();
        MyObj m1 = st.new MyObj(2, "AAA");
        MyObj m2 = st.new MyObj(1, "BBB");
        MyObj m3 = st.new MyObj(3, "CCC");
        List<MyObj> list = new ArrayList<>(Arrays.asList(m1,m2,m3));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, st.new MyComparator());
        System.out.println(list);
    }
    
    class MyObj implements Comparable<MyObj> {
        private int id;
        private String name;

        public MyObj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyObj{" + "id=" + id + ", name=" + name + '}';
        }

        @Override
        public int compareTo(MyObj o) {
            return (new Integer(id)).compareTo(o.id);
        }
    }
    
    class MyComparator implements Comparator<MyObj> {

        @Override
        public int compare(MyObj o1, MyObj o2) {
            return o2.name.compareToIgnoreCase(o1.name); // descending order
//            return o1.compareToIgnoreCase(o2); // asc order
        }

        
        
    }
    
}
