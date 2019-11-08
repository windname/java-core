/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.core.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 *
 * @author 1
 */
public class AnnotRunner {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class clazz = SampleClass.class;
        SampleClass obj = (SampleClass)clazz.newInstance();
        Method m1 = clazz.getMethod("m1");
        m1.invoke(obj, new Object[]{});
        
        Method m2 = clazz.getDeclaredMethod("m2");
        m2.setAccessible(true);
        m2.invoke(obj, new Object[]{});
        
        Object o2 = new Object();
        HashMap hm =  null;
    }
}
