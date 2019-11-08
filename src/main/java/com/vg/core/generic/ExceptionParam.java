package com.vg.core.generic;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 11/8/2019
 */


/**
 * Generics doesn't work with exception. Only as method params
 */
public class ExceptionParam {
    public static void main(String[] args) {
        exceptionContition(false, new RuntimeException("Condition false"));
        exceptionContition(true, new RuntimeException("Condition true"));
    }

    public static <T extends Throwable> void exceptionContition(boolean cond, T exception) throws T{
        if (cond) throw exception;
    }
}
