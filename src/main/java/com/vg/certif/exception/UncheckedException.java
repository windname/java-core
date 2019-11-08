package com.vg.certif.exception;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 11/8/2019
 */


public class UncheckedException {
    public static void main(String[] args) {
        new UncheckedException().throwEx(true);
    }

    public void throwEx(boolean condition) {
        if (condition) throw new RuntimeException("Unchecked exception");
    }
}
