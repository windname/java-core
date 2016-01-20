/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.base;

/**
 *
 * @author vladimir
 */
public class OverloadTest {

    private OverloadTest(Object o) {
        System.out.println("Object");
    }

    private OverloadTest(double[] arr) {
        System.out.println("double []");
    }

    private OverloadTest() {
        System.out.println("void");
    }

    public static void main(String[] args) {
        new OverloadTest(null);
 // MARKER
    }
}
