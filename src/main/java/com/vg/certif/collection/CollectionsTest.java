/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.certif.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vladimir
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<String> str = Collections.emptyList();
        Map<String, String> job = new HashMap<>();
        job.put("emp1","boss");
        job.put("emp2","dev");
        job.put("emp3","dev");
        
        job.values().removeAll(Collections.singleton("dev"));
        
        for(String emp: job.keySet()) {
            System.out.println(job.get(emp)); // only boss
        }
        
        List<String> manyFruits = Collections.nCopies(100, "fruit bat"); 
        System.out.println(manyFruits);
        
        Collections.sort(manyFruits);
    }
}
