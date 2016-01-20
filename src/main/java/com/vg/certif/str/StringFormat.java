/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.str;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author vladimir
 */
public class StringFormat {

    public static void main(String[] args) {

        //   %[argument_index$][flags][width][.precision]conversion
        // %n - new line 
        System.out.printf("%5.3s %n", "hello world"); //  __hel
        System.out.printf("%3.7s %n", "hello world"); //  hell
        System.out.printf("%05d", 123); // 00123

        System.out.printf("%4$2s %3$2s %2$2s %1$2s %n", "a", "b", "c", "d");
        // -> " d  c  b  a" ;4$ the forth parameter, 2 - two positions, s - string

        System.out.printf(Locale.FRANCE, "e = %+10.4f%n", Math.E);
        // -> "e =    +2,7183"
        
        System.out.printf("%tB%n", new Date());
        
        System.out.printf("%f%n", 100.001f); 
        // for float and Double we can use e=1.000010e+02, or g=100.001, f=100.000999
        
        System.out.printf("%f%n", new BigDecimal("100.001")); 
        // for BigDecimal we can use e=1.000010e+02, or g=100.001, f=100.001000
        
        System.out.printf("%+d%n", new Integer("100000"));
        // for Byte, Short, Integer, and Long d=+100000 o=303240 in base 8, x=186a0 in base 16
        
        System.out.printf("%d%n", new BigInteger("100000"));
        // for d=100000 o=303240 in base 8, x=186a0 in base 16
        
        System.out.printf("%h%n", new String("hash code"));
        // h=ef555bf getting hash code for any object
        
        
    }
}
