/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.serializ;

import static com.vg.certif.serializ.MyObj.gen;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 *
 * @author vladimir
 */
public class ExternExample {
    
        public static void main(String[] args) {

        MyObj2 e = new MyObj2("Petea");

        boolean ser = false;

        if (ser) {

            try (FileOutputStream fileOut = new FileOutputStream("/tmp/MyObj2.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                MyObj.gen = "M";
                out.writeObject(e);
            } catch (IOException ex) {
                System.err.println("error" + ex.getMessage());                
            }
        } else {
            try (FileInputStream fileOut = new FileInputStream("/tmp/MyObj2.ser");
                    ObjectInputStream in = new ObjectInputStream(fileOut)) {
                MyObj2 e2 = (MyObj2) in.readObject();
                System.out.println(e2);
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("error" +  ex.getMessage());
            }
        }
    }
    
    static class MyObj2 implements Externalizable{
         private String name;
         
         public MyObj2() {          
         }
         
         public MyObj2(String name) {
             this.name = name;
         }
        
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeUTF("e" + name);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            name = in.readUTF();
        }
        
            public String toString() {
        return name + ", " + gen;
    }
    }
}
