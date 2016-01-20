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
public abstract class AbstrExtend extends Base {
    public static void main(String[] args) {
        new Base().printname();
    }
}

class Base {
    public void printname() {
        System.out.println("Uasea");
    }
}
