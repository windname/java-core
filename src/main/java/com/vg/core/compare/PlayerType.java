/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.core.compare;

/**
 *
 * @author 1
 */
public class PlayerType implements Comparable<PlayerType>{
        private Integer codeId;
        private String name;
        private int age;

        public PlayerType(Integer codeId, String name, int age) {
            this.codeId = codeId;
            this.name = name;
            this.age = age;
        }
        
        @Override
        public int compareTo(PlayerType t) {
//            if (t.codeId == null || codeId == null) throw new NullPointerException("Wrong codeId value");
            if (t.codeId == null || codeId == null) return -1;
//            return codeId == t.codeId ? 0 : codeId > t.codeId ? 1: -1;
            return codeId.compareTo(t.codeId);
        }
        
        public String toString(){
            return codeId + "-" + name + "-" + age;
        }
}
