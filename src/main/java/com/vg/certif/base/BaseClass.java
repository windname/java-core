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
public class BaseClass {

    private void foo() {
        System.out.println("In BaseClass.foo()");
    }

    void bar() {
        System.out.println("In BaseClass.bar()");
    }

    public static void main(String[] args) {
        BaseClass po = new DerivedClass();
        po.foo();
        po.bar();
    }
}

class DerivedClass extends BaseClass {

    void foo() {
        System.out.println("In Derived.foo()");
    }

    void bar() {
        System.out.println("In Derived.bar()");
    }
}
