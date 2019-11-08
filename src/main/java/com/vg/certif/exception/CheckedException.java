package com.vg.certif.exception;

import java.io.IOException;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 11/8/2019
 */


public class CheckedException {

    public static void main(String[] args) {
        try {
            new CheckedException().throwEx(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void throwEx(boolean condition) throws IOException {
        if (condition) throw new IOException("File not found");
    }
}
