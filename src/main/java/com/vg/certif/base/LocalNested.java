package com.vg.certif.base;

public class LocalNested {
    public static int MAX_PERCENT = 100;

    private int percent;

    public static void main(String[] args) {
        new LocalNested();
    }

    public LocalNested() {

        class LocalInner {
            int loclaVar;

            LocalInner() {
                percent = MAX_PERCENT;
                loclaVar = percent;
                System.out.println(loclaVar);

            }
        }

        new LocalInner();

    }

}
