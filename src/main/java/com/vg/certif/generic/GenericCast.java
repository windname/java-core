/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.generic;

/**
 *
 * @author vladimir
 */
public class GenericCast {

    static <E> E cast(Object item) {
        return (E) item;
    }

    public static void main(String[] args) {
        Object o1 = 10;
        int i = 10;
        Integer anInteger = 10;
        Integer i1
                = cast(o1);
        Integer i2
                = cast(i);
        Integer i3
                = cast(10);
        Integer i4
                = cast(anInteger);
         String s5 = "10";
         // = cast(anInteger); // this line generate runtime error java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
System.out.printf("i1 = %d, i2 = %d, i3 = %d, i4 = %d, s5 = %s", i1, i2, i3, i4, s5);
    }

}
