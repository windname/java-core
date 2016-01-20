/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.io;

import java.io.Console;

/**
 *
 * @author vladimir
 */
public class ConsoleRead {

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.exit(-1);
        }
        console.printf(console.readLine());
    }
}
