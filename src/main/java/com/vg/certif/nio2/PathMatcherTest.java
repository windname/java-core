/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.nio2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 *
 * @author vladimir
 */
public class PathMatcherTest {
    public static void main(String[] args) {
        PathMatcher matcher =   FileSystems.getDefault().getPathMatcher("glob:" + "**.java");
        Path p1 = Paths.get("/tmp/Test.java");
        System.out.println("Mathes: " + matcher.matches(p1)); // true
        
        matcher =   FileSystems.getDefault().getPathMatcher("regex:Test.java");
        p1 = Paths.get("Test.java");
        System.out.println("Mathes: " + matcher.matches(p1)); // true
    }
}
