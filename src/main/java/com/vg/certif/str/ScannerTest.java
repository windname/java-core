/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.str;

import java.util.Scanner;

/**
 *
 * @author vladimir
 */
public class ScannerTest {

    public static void main(String[] args) {
//        String str = "abb 100 baa 200";

        String onlyNumbers = "1 100.43 200"; // this line should contain only nymbers space separated
        Scanner s = new Scanner(onlyNumbers);
        while (s.hasNextBigDecimal()) {
            System.out.println(s.nextBigDecimal()); // 1 100.43 200
        }

        System.out.println("Delimiter");
        String numbersFromChars = "100, 200, null, 300";
        s = new Scanner(numbersFromChars);
        s.useDelimiter(",\\D*");

        while (s.hasNextInt()) {
            System.out.println(s.nextInt()); // 100 200 300
        }

        s = new Scanner("asdasd23sdf344t5323");
        String token;
        do {
            token = s.findInLine("\\d\\d"); // 23 45 53 23
            System.out.println("found " + token);
        } while (token != null);

    }
}
