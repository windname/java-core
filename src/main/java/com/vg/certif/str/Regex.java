/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vladimir
 */
public class Regex {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d*");
        Matcher m = p.matcher("ab34ef");
        boolean b = false;
        while (b = m.find()) {
            System.out.print(m.start() + "|" + m.group()); // 0|1|2|344|5|6| group method may return empty string if pattern matches empty string !
        }

        String str = "ph: 9876501234 ";
        Pattern pattern = Pattern.compile("(\\D)(\\d{3})(\\d{7})(\\D)");
        Matcher matcher = pattern.matcher(str);
        String newStr = matcher.replaceAll("$1$2-$3$4");
        System.out.println(newStr); // ph: 987-6501234
        

    }
}
