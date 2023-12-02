package com.vg.certif.base;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NestedExample {
    private static int age = 22;

    public static void main(String[] args) {
        new NestedStatic().showAge();

    }

    /*private*/ /*public*/ static class NestedStatic {
        private void showAge() {
            System.out.println(age);
        }
    }

    class MyInnerClass {
        public void useStatucClass() {
            new NestedStatic().showAge();
        }
    }
}
