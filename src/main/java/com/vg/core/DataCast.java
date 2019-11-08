/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.core;

import java.util.Arrays;

/**
 *
 * @author 1
 */
public class DataCast {

    public static void main(String[] args) {
        long val = 10;
        val += 20;
        val = val + 20;
        System.out.println(val);

        Integer i = Integer.valueOf(15);
        int sum = 0;
        sum = sum + i;
        i = i + sum;
        System.out.println(sum);
        System.out.println(i);

        byte b = 1;
        b += 10;
        b = (byte) (b + 10);
        System.out.println(b);

        String s = "str";
        Object o = null;
        o = s;
        String s2 = (String) o;
        System.out.println(s2);

        String[] sarr = new String[3];
        Object[] oarr = new String[]{"str"};
        if (oarr instanceof String[]) {
            sarr = (String[]) oarr;
        }
        System.out.println(Arrays.deepToString(sarr));
        
        byte one = 1;
        boolean bool = one != 0;
        int intValue = bool ? 1:0;
        
        String str = "333";
        try {
            long lon = Long.valueOf(str);
        } catch (NumberFormatException ex)  {System.err.println(ex);} 
        
        System.out.println(Integer.valueOf("011",8));
        
        int in = 10;
        showInt(in);
       
    }
    
public static void showInt(int i) {
    System.out.println("int" + i);
}

public static void showInt(Integer i) {
    System.out.println("Integer" + i);
}

public static void showInt(int... i) {
    System.out.println("VarArg" + i);
}

}
