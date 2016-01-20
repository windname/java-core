/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.str;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vladimir
 */
public class StringUtils {

    public static void main(String[] args) {
        System.out.println(String.valueOf(10));
        String str = "A.B.C!";
        System.out.println(str.replaceAll(".", ",").replace("!", "?")); // replace all uses regexp as well as split

        String quote = "aba*abaa**aabaa***";
        System.out.println("words: " + Arrays.asList(quote.split("a\\*", 10)));
        System.out.println("words: " + Arrays.asList(quote.split("a\\**", 10)));

        str = "boo:and:foo";
        System.out.println(Arrays.asList(str.split(":", 2)));
        System.out.println(Arrays.asList(str.split(":", -2)));
        System.out.println(Arrays.asList(str.split(":", 5)));

        System.out.println(Arrays.asList(str.split("o", 2)));
        System.out.println(Arrays.asList(str.split("o", -2)));
        System.out.println(Arrays.asList(str.split("o", 5)));
        
        String in = "1 a2 b 3 c4d 5e";
        String[] chunks = in.split(" ");
        System.out.println("count " + chunks.length + " " + Arrays.asList(chunks));
        chunks = "1 a2 b 3 c4d 5e".split("\\d");
        System.out.println("count " + chunks.length + " " + Arrays.asList(chunks));
        

        str = "OCPJP a2013 OCPJP7 q";
        Pattern pattern = Pattern.compile("\\b\\w+\\D\\b");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        str= "Suneetha N.=9876543210, Pratish Patil=9898989897";
        pattern= Pattern.compile("(\\w+)(\\s\\w+)(=)(\\d{10})");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        String newStr = matcher.replaceAll("$4:$2,$1 ");
        System.out.println(newStr);       
        
    }
}
