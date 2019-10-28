/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.different;

/**
 *
 * @author 1
 */
public class Primitives {

    public static void main(String[] args) {
        byte b = 10; // 8 bits min -128 max 127 default 0 
        short s = 10; // 16 bits min -32168 max 32167 default 0 2^15
        int i = 10; // 32 bits min -2147483648 max 2147483647 default 0 2^31 (from java8 2^32 - 1)
        long l = 10L; // [L|l] 64 bits min -2^63 max 2^63-1 (java8 2^64-1)
        float f = 10F; // [F|f] 32 bits min 1.4E-45F max 3.4028235*10^38 default 0.0f
        double d = 10D; // [D|d] 64 bits 
        boolean bool = true; // [true|false] has no data size 
        char c = 'a'; // 16 bits min `\u0000`(0) and max '\uffff' (65535)

        System.out.println("Max int=" + Math.pow(2, 31)); // Max int=2.147483648E9
        double rez = Math.log(2147483648d) / Math.log(2); // 31.000000000000004
        System.out.println(rez);
        System.out.println(5.12e2f);//512.0

        final int OCT_INT = 013; // 11
        System.out.println(OCT_INT);
        final int HEX_INT = 0xB; // 11
        System.out.println(HEX_INT);
        final int BIN_INT = 0b1011; // 11
        System.out.println(BIN_INT);
        final long OCT_LONG = 013L; // 11
        System.out.println(OCT_LONG);
        final int INT_INT = 10_000_000;
        

        final char DEC_CHAR = '\123';
        System.out.println(DEC_CHAR);
        final char HEX_CHAR = '\u0053';
        System.out.println(HEX_CHAR);
        
        
        System.out.println(b2);

    }
    
    public static boolean b2;
}
