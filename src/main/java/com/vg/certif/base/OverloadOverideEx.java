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
public class OverloadOverideEx {

    public static void main(String[] args) {
        Side s = new Side();

        s.overload(s);
        s.overload((BaseSide) s);

        s.overide(s);
        s.overide((BaseSide) s);
    }
}

class BaseSide {

    public void overload(BaseSide s) {
        System.out.println("overload BaseSide");
    }

    public void overide(BaseSide s) {
        System.out.println("overide BaseSide");
    }
}

class Side extends BaseSide {

    public void overload(Side s) {
        System.out.println("overload Side");
    }

    public void overide(BaseSide s) {
        System.out.println("overide Side");
    }
}
