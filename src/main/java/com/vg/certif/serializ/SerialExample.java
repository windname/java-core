/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.serializ;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author vladimir
 */
public class SerialExample {

    public static void main(String[] args) {

        MyObj e = new MyObj("Masha2");

        boolean ser = false;

        if (ser) {

            try (FileOutputStream fileOut = new FileOutputStream("/tmp/MyObj.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                MyObj.gen = "M";
                out.writeObject(e);
            } catch (IOException ex) {
                System.err.println("error" + ex.getMessage());                
            }
        } else {
            try (FileInputStream fileOut = new FileInputStream("/tmp/MyObj.ser");
                    ObjectInputStream in = new ObjectInputStream(fileOut)) {
                MyObj e2 = (MyObj) in.readObject();
                System.out.println(e2);
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("error" +  ex.getMessage());
            }
        }
    }
}

class MyObj implements Serializable {

    private String name;
    public static transient String gen;

    public MyObj(String name) {
        this.name = name;        
    }
    
    public String toString() {
        return name + ", " + gen;
    }
    
    // not mandatory!
    private void readObject(ObjectInputStream in) throws IOException {
        name = "r" + in.readUTF();
    }
    
    // not mandatory!
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name);
    }
}
