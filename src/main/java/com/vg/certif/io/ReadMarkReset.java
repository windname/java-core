/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author vladimir
 */
public class ReadMarkReset {

    public static void main(String[] args) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("/tmp/test.txt")))) {
            System.out.println(br.readLine());
            br.mark(2); // setting rollback point if reset is invoked

            System.out.println(br.readLine()); 
            br.reset();

            System.out.println(br.readLine());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
