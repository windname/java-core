/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.str;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 *
 * @author vladimir
 */
public class NumberFormatTest {

    public static void main(String[] args) throws ParseException {
        float f1 = 123.45678f;
        NumberFormat nf = NumberFormat.getInstance();
        System.out.print(nf.getMaximumFractionDigits() + " ");
        System.out.print(nf.format(f1) + " ");
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(f1));

        System.out.println(nf.parse("1234.567"));
        nf.setParseIntegerOnly(true);
        System.out.println(nf.parse("1234.567")); // 1234
        
        double d = 987.123455d;
        nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(5); // rounds up!
        System.out.println(nf.format(d) + " "); // 987.12346
        
       for (int i=0; i<10; i++) {
           if (true) {
               if (i==5) continue;
               System.out.println("i=" + i);
           }
       }

    }

}
