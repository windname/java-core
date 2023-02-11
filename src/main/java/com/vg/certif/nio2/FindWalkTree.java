/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;

/**
 *
 * @author vladimir
 */
public class FindWalkTree {

    public static void main(String[] args) throws IOException {
        String startingDir = "/tmp/subdir";
        Files.walkFileTree(Paths.get(startingDir), new MyFileVisitor());
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        private final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/file3.txt");

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (matcher.matches(file)) {
                System.out.println("File found:" + file);
                return TERMINATE;
            }
            return CONTINUE;
        }
    }
}
