/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.collection;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author vladimir
 */
public class EnumSetTest {

    enum Letters {A, B, C, D};

    public static void main(String[] args) {
        System.out.println(Letters.valueOf("A"));
        EnumSet<Letters> firstLetters = EnumSet.of(Letters.A, Letters.B);

        Iterator<Letters> firstLettersIter = firstLetters.iterator();
        while (firstLettersIter.hasNext()) {
            System.out.println(firstLettersIter.next()); // A,B
        }

        EnumSet<Letters> lastLetters = EnumSet.complementOf(firstLetters);
        Iterator<Letters> lastLettersIter = lastLetters.iterator();
        while (lastLettersIter.hasNext()) {
            System.out.println(lastLettersIter.next()); // C, D
        }

        boolean b = lastLetters.containsAll(firstLetters); // false
        System.out.println("last contains first:" + b);

        EnumSet<Letters> middleLetters = EnumSet.range(Letters.A, Letters.C);
        System.out.println("middle comtains first:" + middleLetters.containsAll(firstLetters)); // true
        
        Set<Letters> syncEnumSet = Collections.synchronizedSet(EnumSet.allOf(Letters.class));

    }

}
