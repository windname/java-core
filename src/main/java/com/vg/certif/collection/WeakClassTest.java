/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.collection;

import java.util.WeakHashMap;

/**
 *
 * @author vladimir
 */
public class WeakClassTest {
    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<MapKey, MapValue> map = new WeakHashMap<>();
        
        MapKey superKey = null;
        for (int i=0; i<10000; i++) {
            MapKey key = new MapKey();
            map.put(key, new MapValue());
            if (superKey == null) superKey = key;
        }        
        
        int i=0;
        while(map.size()!=0) {
            System.out.println("map.size() = " + map.size());
            i++;            
            System.gc();
            Thread.sleep(1000);
            if (i>3) superKey = null;
        }        
        System.out.println("i=" + i);
        
    }
    
    static class MapKey{
        private String key = "key";
    }
    
    static class MapValue {
        private String val = "value";
    }
}
