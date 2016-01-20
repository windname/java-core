/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/**
 *
 * @author vladimir
 */
public class WeakClassTest2 {
    public static void main(String[] args) throws InterruptedException {
        Set<MapKey> keySet = new HashSet<>();
        WeakHashMap<MapKey, MapValue> map = new WeakHashMap<>();
        
        for (int i=0; i<200000; i++) {
            keySet.add(new MapKey());
        }        

        Iterator<MapKey> iter = keySet.iterator();
        MapKey superkey = null;
        while (iter.hasNext()) {
            MapKey key = iter.next();
            MapValue value = new MapValue();
            map.put(key, value);            
            iter.remove();
            if (superkey ==null) {
                superkey = key;
            } else {
                key=null;
            }
        }
        
        int i=0;
        while(map.size()!=0) { 
            System.out.println("map.size() = " + map.size());
            i++;
            System.gc();
            if (i>2)  superkey = null;
            Thread.sleep(1000);
        }
        
        System.out.println("i=" + i + " values size = " + map.values().size() );
        
       
    }
    
    static class MapKey{
        private String key = "key";
    }
    
    static class MapValue {
        private String val = "value";
    }
}
