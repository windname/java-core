/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.nio2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author vladimir
 */
public class MyFileStore {

    public static void main(String[] args) throws IOException {
        Path file = Paths.get("/tmp/subdir");
        FileStore store = Files.getFileStore(file);

        long total = store.getTotalSpace() / 1024 / 1024;
        long used = (store.getTotalSpace()
                - store.getUnallocatedSpace()) / 1024/ 1024;
        long avail = store.getUsableSpace() / 1024 / 1024;
        
        System.out.println("total=" + total + " used=" + used + " avail=" + avail);
    }
}
