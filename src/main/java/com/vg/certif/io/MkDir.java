/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.io;

import java.io.File;

/**
 *
 * @author vladimir
 */
public class MkDir {
    public static void main(String[] args) {
        String[] fileList = { "/tmp/file1.txt", "/tmp/subdir/file2.txt"};
    for (String file : fileList) {new File(file).mkdirs();}
    }
}
