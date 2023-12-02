package com.vg.certif.base;

public class AnonymousNested {
    abstract class MyAbstr {
        abstract void sayMom();
    }

    public AnonymousNested() {
        int loc = 0;
        MyAbstr m = new MyAbstr() {
            @Override
            void sayMom() {
                System.out.println("Mom" + loc); // loc is initilized and could be used here
            }
        };
        m.sayMom();
    }

    public static void main(String[] args) {
        new AnonymousNested();
    }
}
