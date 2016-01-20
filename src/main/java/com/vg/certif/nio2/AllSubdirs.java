/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author vladimir
 */
public class AllSubdirs {
    public static void main(String[] args) {        
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/home/"))) {
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());            
        }

    }
}
