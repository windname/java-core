/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.core.collect;

import java.util.Arrays;

/**
 *
 * @author 1
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] arr1 = new int[3];
        arr1[0] = 1;arr1[1] = 2;arr1[2] = 3;
        int arr1_1[] = new int[3]; // it is not by code convension
        int[] arr2 = new int[]{1, 2, 3};
        int[] arr3 = {1, 2, 3};

        int[][] m1 = new int[2][2];
        int[][] m2 = new int[2][]; // can declare dimension only of the based array
        m2[0] = new int[]{1, 2};
        m2[1] = new int[]{3, 4};
        int[][] m3 = new int[][]{{1, 2}, {3, 4}};
        int[][] m4 = {{1, 2}, {3, 4}};
        int[][][] m5 = {{{1}, {2}}};
        System.out.println(m5[0][0][0] + " " + m5[0][1][0]);
//        System.ar

        System.arraycopy(arr1, 0, arr1_1, 0, 3); // copy ome array to another
        System.out.println(arr1_1[0] + " " + arr1_1[1] + " " + arr1_1[2]);
        
        arr1[0] = 5;
        int[] arr1_2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println(arr1_2[0] + " " + arr1_2[1] + " " + arr1_2[2]);
        
        arr1[0] = 10;
        
        int[] arr1_3 = arr1.clone();
        System.out.println(arr1_3[0] + " " + arr1_3[1] + " " + arr1_3[2]);
        
//        Arrays.fill(array[], object); // Assign the specified object to each element of the  array
        Integer[] ai1 = {new Integer(1), new Integer(2)};
        Integer[] ai2 = {new Integer(1), new Integer(2)};
        System.out.println(Arrays.equals(ai1, ai2));
        System.out.println(Arrays.deepEquals(ai1, ai2));
        System.out.println(Arrays.deepToString(ai1));
        System.out.println(Arrays.asList(ai1));
        
        
    }
    

    public int[] getArr1() {
        return null;
    }

    public int getArr2 () 
        [] {
return null;
    }
}
