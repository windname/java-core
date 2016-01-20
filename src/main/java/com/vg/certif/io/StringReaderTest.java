/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Locale;

/**
 *
 * @author vladimir
 */
public class StringReaderTest {
    public static final String LINE = "Line 1\nLine 2\nLine 3\nLine 4\n";

    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(new StringReader(LINE)); PrintStream out = System.out;) {

            // first check if this Reader support mark operation
            if (in.markSupported()) {

                out.println(in.readLine());
                in.mark(0);                     // mark 'Line 2'
                out.println(in.readLine());
                out.println(in.readLine());
                in.reset();                     // reset 'Line 2'
                out.println(in.readLine());
                in.reset();                     // reset 'Line 2'
                out.println(in.readLine());
                in.mark(0);                     // mark 'Line 3'
                out.println(in.readLine());
                in.reset();                     // reset 'Line 3'
                out.println(in.readLine());
                out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
