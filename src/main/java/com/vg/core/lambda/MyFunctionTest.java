package com.vg.core.lambda;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 11/15/2019
 */


public class MyFunctionTest {
    public static void main(String[] args) {
        MyFunctionTest myFunctionTest = new MyFunctionTest();
        myFunctionTest.useFunction(() -> System.out.print("Hello function"));
    }

    public void useFunction(MyFunction function) {
        function.apply();
    }

    @FunctionalInterface
    interface MyFunction {
        public void apply();
    }
}
