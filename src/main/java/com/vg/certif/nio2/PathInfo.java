/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author vladimir
 */
public class PathInfo {
    public static void main(String[] args) {
        Path path = Paths.get("/tmp/test.txt");
        System.out.println("file name: " + path.getFileName()); 
        System.out.println("root of the path: " + path.getRoot()); 
        System.out.println("parent of the target: " + path.getParent()); 
        System.out.println("normalize " + path.normalize()); 
        System.out.println("subpath " + path.subpath(0, 1)); 
        System.out.println("absolute " + path.toAbsolutePath()); // /home/vladimir/projects/TestApp/./test.txt
        
//        path = Paths.get("./test.txt");
        path = Paths.get(".././.././../test.txt");
        System.out.println("absolute " + path.toAbsolutePath()); // /home/vladimir/projects/TestApp/./test.txt
        System.out.println("normalize " + path.normalize());  // test.txt
        
        
        Path testFilePath = Paths.get("C:\\WINDOWS\\system32\\config\\.\\systemprofile\\Start Menu\\Programs\\Accessories\\Entertainment\\..\\..");
        System.out.println("It's normalized absolute path is: " +
        testFilePath.normalize().toAbsolutePath());

    } 
}
