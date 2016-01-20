/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 *
 * @author vladimir
 */
public class IterateFiles {
    public static void main(String[] args) {
        Path file = Paths.get("/tmp/subdir/f1.txt");
        Iterator<Path> files = file.iterator();
        while (files.hasNext()) {
            System.out.println("filename: " + files.next());
        }
    }   
}
